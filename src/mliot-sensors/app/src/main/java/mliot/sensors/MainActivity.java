package mliot.sensors;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.protobuf.ByteString;

import java.io.ByteArrayOutputStream;

import mliot.sensors.model.Acceleration;
import mliot.sensors.stream.GrpcAccTask;
import mliot.sensors.stream.GrpcAudioTask;
import mliot.sensors.stream.GrpcVideoTask;
import mliot.sensors.view.AccelerationView;
import mliot.sensors.view.AudioView;
import mliot.sensors.view.CameraView;

public class MainActivity extends AppCompatActivity implements Runnable, SensorEventListener, Camera.PreviewCallback {

    /**
     * Hardware representative sensors
     */
    private Camera camera;
    private AudioRecord audioRecord;
    private SensorManager sensorManager;

    /**
     * Audio recorder settings
     */
    private static final int SAMPLE_RATE = 44100;
    private static final int CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = AudioFormat.ENCODING_PCM_8BIT;
    private static final int AUDIO_SOURCE = MediaRecorder.AudioSource.VOICE_COMMUNICATION;
    private static final int BUFFER_SIZE = AudioRecord.getMinBufferSize(SAMPLE_RATE, CHANNELS, AUDIO_FORMAT);

    /**
     * Processes
     */
    private Thread recordingProcess;
    private boolean isRecording = false;

    /**
     * Required runtime permissions
     */
    private final int PERMISSION_REQUEST_CODE = 0x0;
    private final static String[] REQUESTED_PERMISSION_ARRAY = new String[]{Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO};

    /**
     * Audio & Acceleration visualizer custom view
     */
    private AudioView audioModulationView;
    private AccelerationView accelerationView;

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Initialize accelerometer Sensor
         */
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        accelerationView = findViewById(R.id.acc_preview);
        accelerationView.setMaxValue(sensor.getMaximumRange());

        if (!willRequestRuntimePermission()) {
            /*
             * Check if any camera exists and initialize it
             */
            if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
                camera = Camera.open();
                camera.setDisplayOrientation(90);
                if (camera != null) {
                    CameraView cameraView = new CameraView(this, camera);
                    FrameLayout preview = findViewById(R.id.camera_preview);
                    preview.addView(cameraView);
                    camera.setPreviewCallback(this);
                }
            }
            /*
             * Check if if any microphone exists and initialize it
             */
            if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
                audioRecord = new AudioRecord.Builder()
                        .setAudioSource(AUDIO_SOURCE)
                        .setAudioFormat(new AudioFormat.Builder()
                                .setEncoding(AUDIO_FORMAT)
                                .setSampleRate(SAMPLE_RATE)
                                .setChannelMask(CHANNELS)
                                .build())
                        .setBufferSizeInBytes(BUFFER_SIZE)
                        .build();
                audioRecord.startRecording();
                recordingProcess = new Thread(this);
                recordingProcess.start();
                isRecording = true;

                /*
                 * Retrieve the audio visualizer view reference from the XML layout
                 */
                audioModulationView = findViewById(R.id.audio_preview);
            }
        } else {
            requestPermissions(REQUESTED_PERMISSION_ARRAY, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
        isRecording = false;
        if (audioRecord != null) {
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
            recordingProcess = null;
        }
    }

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            for (int i = 0; i < Math.min(permissions.length, grantResults.length); i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    openAppSettings();
                    return;
                }
            }
            finish();
            startActivity(getIntent());
        }
    }

    /**
     * Accelerometer listener
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        /*
         * Call gRPC service to receive tri-axial accelerometer values
         */
        new GrpcAccTask(this).execute(event.values[0],event.values[1],event.values[2]);
        accelerationView.populateAcceleration(new Acceleration(event.values[0],event.values[1],event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        /*
         * Call gRPC service to receive camera stream
         */
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size size = parameters.getPreviewSize();
        YuvImage yuvImage = new YuvImage(data, parameters.getPreviewFormat(), size.width, size.height, null);
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 0, outputStream);
        new GrpcVideoTask(this).execute(ByteString.copyFrom(outputStream.toByteArray()));
    }

    @Override
    public void run() {
        while (isRecording) {
            byte []data = new byte[BUFFER_SIZE];
            audioRecord.read(data, 0, BUFFER_SIZE);
            runOnUiThread(() -> audioModulationView.updateWaveform(data));
            /*
             * Call gRPC service to receive audio stream
             */
            new GrpcAudioTask(this).execute(ByteString.copyFrom(data));
        }
    }

    private boolean willRequestRuntimePermission() {
        for (String permission : REQUESTED_PERMISSION_ARRAY) {
            if (!(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED)) {
                return true;
            }
        }
        return false;
    }

    private void openAppSettings() {
        Intent appSettingsIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
        appSettingsIntent.addCategory(Intent.CATEGORY_DEFAULT);
        appSettingsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        appSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        appSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(appSettingsIntent);
    }
}
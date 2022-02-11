package mliot.sensors;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.protobuf.ByteString;

import java.io.ByteArrayOutputStream;

import mliot.sensors.grpc.GrpcVideoTask;
import mliot.sensors.view.CameraView;

public class HeadActivity extends AppCompatActivity implements Camera.PreviewCallback, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    /**
     * Hardware representative sensors
     */
    private Camera camera;
    private AudioRecord audioRecord;

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
    //private Thread recordingProcess;
    //private boolean isRecording = false;

    /**
     * Required runtime permissions
     */
    private final int PERMISSION_REQUEST_CODE = 0x0;
    private final static String[] REQUESTED_PERMISSION_ARRAY = new String[]{Manifest.permission.CAMERA/*, Manifest.permission.RECORD_AUDIO*/};

    /**
     * Audio visualizer custom view
     */
    //private AudioView audioModulationView;

    /**
     *  Default camera
     */
    private FrameLayout preview;
    private int  currentCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;

    /**
     *  Camera controls
     */
    private SeekBar zoom;

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        if (!willRequestRuntimePermission()) {
            /*
             * Check if any camera exists and initialize it
             */
            if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
                findViewById(R.id.switcher).setOnClickListener(this);
                preview = findViewById(R.id.camera_preview);
                zoom = findViewById(R.id.zoom);
                zoom.setOnSeekBarChangeListener(this);
                setupCamera();
            }
            /*
             * Check if if any microphone exists and initialize it
             */
            /*if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
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

                //Retrieve the audio visualizer view reference from the XML layout
                audioModulationView = findViewById(R.id.audio_preview);
            }*/
        } else {
            requestPermissions(REQUESTED_PERMISSION_ARRAY, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*
        isRecording = false;
        if (audioRecord != null) {
            audioRecord.stop();
            audioRecord.release();
            audioRecord = null;
            recordingProcess = null;
        }*/
        stopPreviewAndFreeCamera();
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

    @Override
    public void onClick(View view) {
        setupCamera();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(progress);
        camera.setParameters(parameters);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size size = parameters.getPreviewSize();

        YuvImage yuvImage = new YuvImage(data, ImageFormat.NV21, size.width, size.height, null);
        yuvImage.compressToJpeg(new Rect(0, 0, size.width, size.height), 100, outputStream);
        byte[] rawImage = outputStream.toByteArray();
        Bitmap bitmap = BitmapFactory.decodeByteArray(rawImage, 0, rawImage.length);

        ByteArrayOutputStream rotatedStream = new ByteArrayOutputStream();
        Matrix matrix = new Matrix();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = (windowManager).getDefaultDisplay();
        if(display.getRotation() == Surface.ROTATION_0) {
            matrix.postRotate(90);
        }
        if(display.getRotation() == Surface.ROTATION_270) {
            matrix.postRotate(180);
        }

        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);


        int MAX_ALLOWED_RESOLUTION = 720;
        int outWidth;
        int outHeight;
        int inWidth = bitmap.getWidth();
        int inHeight = bitmap.getHeight();
        if(inWidth > inHeight){
            outWidth = MAX_ALLOWED_RESOLUTION;
            outHeight = (inHeight * MAX_ALLOWED_RESOLUTION) / inWidth;
        } else {
            outHeight = MAX_ALLOWED_RESOLUTION;
            outWidth = (inWidth * MAX_ALLOWED_RESOLUTION) / inHeight;
        }

        bitmap = Bitmap.createScaledBitmap(bitmap, outWidth, outHeight, false);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, rotatedStream);
        /*
         * Call gRPC service to receive camera stream
         */
        new GrpcVideoTask(this).execute(ByteString.copyFrom(rotatedStream.toByteArray()));
    }
    /**
    @Override
    public void run() {
        while (isRecording) {
            byte []data = new byte[BUFFER_SIZE];
            audioRecord.read(data, 0, BUFFER_SIZE);
            runOnUiThread(() -> audioModulationView.updateWaveform(data));
            //Call gRPC service to receive audio stream
            new GrpcAudioTask(this).execute(ByteString.copyFrom(data));
        }
    }
    */

    private void setupCamera() {
        stopPreviewAndFreeCamera();
        currentCameraId = currentCameraId != Camera.CameraInfo.CAMERA_FACING_BACK ? Camera.CameraInfo.CAMERA_FACING_BACK : Camera.CameraInfo.CAMERA_FACING_FRONT;
        camera = Camera.open(currentCameraId);
        //camera.setDisplayOrientation(90);
        if (camera != null) {
            CameraView cameraView = new CameraView(this, camera);
            Camera.Parameters parameters = camera.getParameters();
            zoom.setMax(parameters.getMaxZoom());
            zoom.setProgress(parameters.getZoom());
            preview.removeAllViews();
            preview.addView(cameraView);
            camera.setPreviewCallback(this);
        }
    }

    private void stopPreviewAndFreeCamera() {
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera = null;
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
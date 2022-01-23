package mliot.sensors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import mliot.sensors.callback.OnAccelerationCallback;
import mliot.sensors.model.Acceleration;
import mliot.sensors.stream.GrpcAccRangeTask;
import mliot.sensors.stream.GrpcAccTask;
import mliot.sensors.view.AccelerationView;

public class HandActivity extends AppCompatActivity implements SensorEventListener, OnAccelerationCallback {

    /**
     * Hardware representative sensors
     */
    private Sensor heartBeatSensor;
    private Sensor accelerometerSensor;
    private SensorManager sensorManager;

    /**
     * Audio & Acceleration visualizer custom view
     */
    private AccelerationView accelerationView;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            /*
             * Initialize accelerometer Sensor
             */
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);

            accelerationView = findViewById(R.id.acc_preview);
            accelerationView.setMaxValue(accelerometerSensor.getMaximumRange());
        } else {
            Toast.makeText(this, "Accelerometer is not supported by this device", Toast.LENGTH_LONG).show();
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE) != null) {
            /*
             * Initialize heart beat Sensor
             */
            heartBeatSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
            sensorManager.registerListener(this, heartBeatSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(this, "Heart beat sensor is not supported by this device", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    /**
     * Accelerometer listener
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            /*
             * Call gRPC service to receive tri-axial accelerometer values
             */
            new GrpcAccTask(this, this).execute(event.values[0],event.values[1],event.values[2]);
            accelerationView.populateAcceleration(new Acceleration(event.values[0],event.values[1],event.values[2]));
        }
        if (event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
            Log.e("thiss", " " + event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onAccelerationReceived(boolean isReceived) {
        if (!isReceived) {
            new GrpcAccRangeTask(this).execute(accelerometerSensor.getMaximumRange());
        }
    }
}
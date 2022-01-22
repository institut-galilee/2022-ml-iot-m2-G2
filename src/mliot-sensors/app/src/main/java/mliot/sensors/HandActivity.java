package mliot.sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import mliot.sensors.callback.OnAccelerationCallback;
import mliot.sensors.model.Acceleration;
import mliot.sensors.stream.GrpcAccRangeTask;
import mliot.sensors.stream.GrpcAccTask;
import mliot.sensors.view.AccelerationView;

public class HandActivity extends AppCompatActivity implements SensorEventListener, OnAccelerationCallback {

    /**
     * Hardware representative sensors
     */
    private Sensor sensor;
    private SensorManager sensorManager;

    /**
     * Audio & Acceleration visualizer custom view
     */
    private AccelerationView accelerationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand);

        /*
         * Initialize accelerometer Sensor
         */
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        accelerationView = findViewById(R.id.acc_preview);
        accelerationView.setMaxValue(sensor.getMaximumRange());
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    /**
     * Accelerometer listener
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        /*
         * Call gRPC service to receive tri-axial accelerometer values
         */
        new GrpcAccTask(this, this).execute(event.values[0],event.values[1],event.values[2]);
        accelerationView.populateAcceleration(new Acceleration(event.values[0],event.values[1],event.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onAccelerationReceived(boolean isReceived) {
        if (!isReceived) {
            new GrpcAccRangeTask(this).execute(sensor.getMaximumRange());
        }
    }
}
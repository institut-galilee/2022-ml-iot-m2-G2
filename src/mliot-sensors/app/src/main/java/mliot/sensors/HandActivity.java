package mliot.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import mliot.sensors.callback.OnAccelerationCallback;
import mliot.sensors.grpc.GrpcAccTask;
import mliot.sensors.grpc.GrpcHeartBeatTask;
import mliot.sensors.grpc.GrpcProximityTask;
import mliot.sensors.grpc.GrpcRangeTask;
import mliot.sensors.grpc.GrpcStepTask;
import mliot.sensors.grpc.GrpcTemperatureTask;
import mliot.sensors.handler.DetectionHandler;
import mliot.sensors.model.Acceleration;
import mliot.sensors.view.AccelerationView;

public class HandActivity extends AppCompatActivity implements SensorEventListener, OnAccelerationCallback {

    /**
     * Hardware representative sensors
     */
    private Sensor heartBeatSensor;
    private Sensor proximitySensor;
    private Sensor temperatureSensor;
    private Sensor stepDetectionSensor;
    private Sensor accelerometerSensor;
    private Sensor motionDetectionSensor;
    private SensorManager sensorManager;

    /**
     * Audio & Acceleration visualizer custom view
     */
    private AccelerationView accelerationView;

    /**
     * Motion & Step detection handler
     */
    private DetectionHandler detectionHandler;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand);

        detectionHandler = new DetectionHandler(this);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            /*
             * Initialize accelerometer Sensor
             */
            accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            accelerationView = findViewById(R.id.acc_preview);
            accelerationView.setMaxValue(accelerometerSensor.getMaximumRange());
        } else {
            Log.w(getClass().getCanonicalName(), "Accelerometer sensor is not supported by this device");
            Toast.makeText(this, "Accelerometer is not supported by this device", Toast.LENGTH_LONG).show();
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT) != null) {
            /*
             * Initialize heart beat Sensor
             */
            heartBeatSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT);
        } else {
            Log.w(getClass().getCanonicalName(), "Heart beat sensor is not supported by this device");
            Toast.makeText(this, "Heart beat sensor is not supported by this device", Toast.LENGTH_LONG).show();
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {
            /*
             * Initialize proximity Sensor
             */
            proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        } else {
            Log.w(getClass().getCanonicalName(), "Proximity sensor is not supported by this device");
            Toast.makeText(this, "Proximity sensor is not supported by this device", Toast.LENGTH_LONG).show();
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            /*
             * Initialize temperature Sensor
             */
            temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        } else {
            Log.w(getClass().getCanonicalName(), "Temperature sensor is not supported by this device");
            Toast.makeText(this, "Temperature sensor is not supported by this device", Toast.LENGTH_LONG).show();
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            /*
             * Initialize step detection Sensor
             */
            stepDetectionSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        } else {
            Log.w(getClass().getCanonicalName(), "Step detection sensor is not supported by this device");
            Toast.makeText(this, "Step detection sensor is not supported by this device", Toast.LENGTH_LONG).show();
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION) != null) {
            /*
             * Initialize movement detection Sensor
             */
            motionDetectionSensor = sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
        } else {
            Log.w(getClass().getCanonicalName(), "Movement detection sensor is not supported by this device");
            Toast.makeText(this, "Movement detection sensor is not supported by this device", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (stepDetectionSensor != null) {
            sensorManager.registerListener(this, stepDetectionSensor, SensorManager.SENSOR_DELAY_NORMAL);
            //sensorManager.requestTriggerSensor(detectionHandler, stepDetectionSensor);
        }
        if (motionDetectionSensor != null) {
            sensorManager.requestTriggerSensor(detectionHandler, motionDetectionSensor);
        }
        if (heartBeatSensor != null) {
            sensorManager.registerListener(this, heartBeatSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (temperatureSensor != null) {
            sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);

        if (motionDetectionSensor != null) {
            sensorManager.cancelTriggerSensor(detectionHandler, motionDetectionSensor);
        }
    }

    /**
     * Sensors' values changed
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
            /*
             * Call gRPC service to receive heart beat rate
             */
            new GrpcHeartBeatTask(this).execute(event.values[0]);
        }

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            /*
             * Call gRPC service to receive proximity distance
             */
            new GrpcProximityTask(this).execute(event.values[0]);
        }

        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            /*
             * Call gRPC service to receive ambient temperature in Celsius degrees
             */
            new GrpcTemperatureTask(this).execute(event.values[0]);
        }

        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            /*
             * Call gRPC service to register a step detected
             */
            new GrpcStepTask(this).execute(true);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onAccelerationReceived(boolean isReceived) {
        if (!isReceived) {
            new GrpcRangeTask(this).execute(accelerometerSensor.getMaximumRange());
        }
    }
}
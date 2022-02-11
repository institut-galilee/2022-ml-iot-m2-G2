package mliot.sensors.handler;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;

import mliot.sensors.grpc.GrpcMotionTask;
import mliot.sensors.grpc.GrpcStepTask;

/**
 * Sensors' detection happened
 */
public class DetectionHandler extends TriggerEventListener {

    private final Activity context;

    public DetectionHandler(Activity context) {
        this.context = context;
    }

    @Override
    public void onTrigger(TriggerEvent triggerEvent) {
        if (triggerEvent.sensor.getType() == Sensor.TYPE_SIGNIFICANT_MOTION) {
            /*
             * Call gRPC service to notice a movement detected
             */
            new GrpcMotionTask(context).execute(true);
        }

        if (triggerEvent.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            /*
             * Call gRPC service to register a step detected
             */
            new GrpcStepTask(context).execute(true);
        }
    }
}

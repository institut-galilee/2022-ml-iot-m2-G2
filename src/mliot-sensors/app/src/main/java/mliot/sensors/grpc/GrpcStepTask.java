package mliot.sensors.grpc;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mliot.sensors.proto.Response;
import mliot.sensors.proto.SinkServiceGrpc;
import mliot.sensors.proto.StepDetectionMessage;
import mliot.sensors.util.Prefs;

public class GrpcStepTask extends AsyncTask<Boolean, Void, Boolean> {

    public ManagedChannel channel;
    private SinkServiceGrpc.SinkServiceBlockingStub stub;
    private final WeakReference<Activity> activityReference;

    public GrpcStepTask(Activity context) {
        this.activityReference = new WeakReference<>(context);
    }

    @Override
    protected void onPreExecute() {
        Activity activity = activityReference.get();
        channel = ManagedChannelBuilder.forAddress(Prefs.getServerAddress(activity), Prefs.getServerPort(activity)).usePlaintext().build();
        stub = SinkServiceGrpc.newBlockingStub(channel);
    }

    @Override
    protected Boolean doInBackground(Boolean... isDetected) {
        try {
            StepDetectionMessage stepDetectionMessage = StepDetectionMessage.newBuilder().setIsDetected(isDetected[0]).build();
            Response response = stub.onStepDetected(stepDetectionMessage);
            return response.getIsReceived();
        } catch (Exception e) {
            Log.e(getClass().getCanonicalName(), "Error while calling the service", e);
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean received) {
        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
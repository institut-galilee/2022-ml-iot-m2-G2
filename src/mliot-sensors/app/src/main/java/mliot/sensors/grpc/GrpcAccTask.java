package mliot.sensors.grpc;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mliot.sensors.callback.OnAccelerationCallback;
import mliot.sensors.generated.AccelerationMessage;
import mliot.sensors.generated.BoolResponse;
import mliot.sensors.generated.SinkServiceGrpc;
import mliot.sensors.util.Prefs;

public class GrpcAccTask extends AsyncTask<Float, Void, Boolean> {

    public ManagedChannel channel;
    private SinkServiceGrpc.SinkServiceBlockingStub stub;
    private final WeakReference<Activity> activityReference;
    private final OnAccelerationCallback onAccelerationCallback;

    public GrpcAccTask(Activity context, OnAccelerationCallback onAccelerationCallback) {
        this.activityReference = new WeakReference<>(context);
        this.onAccelerationCallback = onAccelerationCallback;
    }

    @Override
    protected void onPreExecute() {
        Activity activity = activityReference.get();
        channel = ManagedChannelBuilder.forAddress(Prefs.getServerAddress(activity), Prefs.getServerPort(activity)).usePlaintext().build();
        stub = SinkServiceGrpc.newBlockingStub(channel);
    }

    @Override
    protected Boolean doInBackground(Float... acc) {
        try {
            float x = acc[0];
            float y = acc[1];
            float z = acc[2];
            AccelerationMessage accelerationMessage = AccelerationMessage.newBuilder().setX(x).setY(y).setZ(z).build();
            BoolResponse response = stub.onAccelerationChanged(accelerationMessage);
            return response.getIsReceived();
        } catch (Exception e) {
            Log.e(getClass().getCanonicalName(), "Error while calling the service", e);
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean received) {
        onAccelerationCallback.onAccelerationReceived(received);
        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

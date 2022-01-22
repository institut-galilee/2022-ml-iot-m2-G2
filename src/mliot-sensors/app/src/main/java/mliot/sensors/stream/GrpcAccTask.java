package mliot.sensors.stream;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mliot.sensors.callback.OnAccelerationCallback;
import mliot.sensors.proto.AccelerationMessage;
import mliot.sensors.proto.Response;
import mliot.sensors.proto.SinkServiceGrpc;
import mliot.sensors.util.Prefs;

public class GrpcAccTask extends AsyncTask<Float, Void, Boolean> {

    public ManagedChannel channel;
    private SinkServiceGrpc.SinkServiceBlockingStub stub;
    private WeakReference<Activity> activityReference;
    private OnAccelerationCallback onAccelerationCallback;

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
            Response response = stub.onAccelerationValuesChanged(accelerationMessage);
            return response.getReceived();
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

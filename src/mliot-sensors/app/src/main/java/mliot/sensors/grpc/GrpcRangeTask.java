package mliot.sensors.grpc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mliot.sensors.generated.RangeMessage;
import mliot.sensors.generated.SinkServiceGrpc;
import mliot.sensors.util.Prefs;

public class GrpcRangeTask extends AsyncTask<Float, Void, Void> {

    public ManagedChannel channel;
    private SinkServiceGrpc.SinkServiceBlockingStub stub;
    private final WeakReference<Activity> activityReference;

    public GrpcRangeTask(Activity context) {
        this.activityReference = new WeakReference<>(context);
    }

    @Override
    protected void onPreExecute() {
        Activity activity = activityReference.get();
        channel = ManagedChannelBuilder.forAddress(Prefs.getServerAddress(activity), Prefs.getServerPort(activity)).usePlaintext().build();
        stub = SinkServiceGrpc.newBlockingStub(channel);
    }

    @SuppressLint("CheckResult")
    @Override
    protected Void doInBackground(Float... range) {
        try {
            RangeMessage rangeMessage = RangeMessage.newBuilder().setMaxRange(range[0]).build();
            stub.setAccelerationMaxRange(rangeMessage);
        } catch (Exception e) {
            Log.e(getClass().getCanonicalName(), "Error while calling the service", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        try {
            channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

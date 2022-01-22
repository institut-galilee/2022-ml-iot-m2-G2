package mliot.sensors.stream;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mliot.sensors.callback.OnAccelerationCallback;
import mliot.sensors.proto.RangeMessage;
import mliot.sensors.proto.Response;
import mliot.sensors.proto.SinkServiceGrpc;
import mliot.sensors.util.Prefs;

public class GrpcAccRangeTask extends AsyncTask<Float, Void, Boolean> {

    public ManagedChannel channel;
    private SinkServiceGrpc.SinkServiceBlockingStub stub;
    private WeakReference<Activity> activityReference;

    public GrpcAccRangeTask(Activity context) {
        this.activityReference = new WeakReference<>(context);
    }

    @Override
    protected void onPreExecute() {
        Activity activity = activityReference.get();
        channel = ManagedChannelBuilder.forAddress(Prefs.getServerAddress(activity), Prefs.getServerPort(activity)).usePlaintext().build();
        stub = SinkServiceGrpc.newBlockingStub(channel);
    }

    @Override
    protected Boolean doInBackground(Float... range) {
        try {
            RangeMessage rangeMessage = RangeMessage.newBuilder().setMaxRange(range[0]).build();
            Response response = stub.setAccelerationMaxRange(rangeMessage);
            return response.getReceived();
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

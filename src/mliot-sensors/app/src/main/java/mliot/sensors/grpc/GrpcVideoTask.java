package mliot.sensors.grpc;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.google.protobuf.ByteString;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import mliot.sensors.proto.Response;
import mliot.sensors.proto.SinkServiceGrpc;
import mliot.sensors.proto.VideoMessage;
import mliot.sensors.util.Prefs;

public class GrpcVideoTask extends AsyncTask<ByteString, Void, Boolean> {

    public ManagedChannel channel;
    private SinkServiceGrpc.SinkServiceBlockingStub stub;
    private final WeakReference<Activity> activityReference;

    public GrpcVideoTask(Activity context) {
        this.activityReference = new WeakReference<>(context);
    }

    @Override
    protected void onPreExecute() {
        Activity activity = activityReference.get();
        channel = ManagedChannelBuilder.forAddress(Prefs.getServerAddress(activity), Prefs.getServerPort(activity)).usePlaintext().build();
        stub = SinkServiceGrpc.newBlockingStub(channel);
    }

    @Override
    protected Boolean doInBackground(ByteString... data) {
        try {
            VideoMessage videoMessage = VideoMessage.newBuilder().setVideoFrame(data[0]).build();
            Response response = stub.onVideoFrameAvailable(videoMessage);
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

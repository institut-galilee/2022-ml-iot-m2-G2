package mliot.sensors.view;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.Arrays;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback{

    private Camera camera;
    private SurfaceHolder holder;

    public CameraView(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        holder = getHolder();
        holder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            Log.d(getClass().getCanonicalName(), "Error while setting camera preview", e);
        }

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        if (this.holder.getSurface() == null){
            return;
        }
        try {
            this.camera.stopPreview();
        } catch (Exception e){
            Log.e(getClass().getCanonicalName(), "Tried to stop a non-existent preview", e);
        }

        Camera.Parameters parameters = this.camera.getParameters();
        parameters.setPreviewFrameRate(5);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        Display display = ((WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if(display.getRotation() == Surface.ROTATION_0) {
            this.camera.setDisplayOrientation(90);
        }

        if(display.getRotation() == Surface.ROTATION_270) {
            this.camera.setDisplayOrientation(180);
        }

        try {
            this.camera.setPreviewDisplay(this.holder);
            this.camera.setParameters(parameters);
            this.camera.startPreview();
        } catch (Exception e){
            Log.d(getClass().getCanonicalName(), "Error while starting camera preview", e);
        }
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}

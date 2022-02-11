package mliot.sensors.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class AudioView extends View {

    private byte[] waveform;
    private float[] pointArray;
    private Paint paint;

    public AudioView(Context context) {
        super(context);
        init();
    }

    public AudioView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AudioView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        waveform = null;
        paint = new Paint();

        paint.setStrokeWidth(1f);
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
    }

    public void updateWaveform(byte[] frame) {
        this.waveform = frame;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (waveform == null) {
            return;
        }

        if (pointArray == null || pointArray.length < waveform.length * 4) {
            pointArray = new float[waveform.length * 4];
        }

        for (int i = 0; i < waveform.length - 1; i++) {
            pointArray[i * 4] = (getWidth() * i) / (waveform.length - 1f);
            pointArray[i * 4 + 1] = (getHeight() / 2f) + ((((byte) (waveform[i] + 128f)) * (getHeight() / 2f)) / 128f);
            pointArray[i * 4 + 2] = (getWidth() * (i + 1f)) / (waveform.length - 1f);
            pointArray[i * 4 + 3] = (getHeight() / 2f) + ((((byte) (waveform[i + 1] + 128f)) * (getHeight() / 2f)) / 128f);
        }

        canvas.drawLines(pointArray, paint);
        paint.setTextSize(40f);
        canvas.drawText("Microphone", 30f, 50f, paint);
        super.onDraw(canvas);
    }
}

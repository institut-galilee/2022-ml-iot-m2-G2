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
    private Rect rect;
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
        rect = new Rect();
        paint = new Paint();
        waveform = null;

        paint.setStrokeWidth(1f);
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
    }

    public void updateWaveform(byte[] waveform) {
        this.waveform = waveform;
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

        rect.set(0, 0, getWidth(), getHeight());

        for (int i = 0; i < waveform.length - 1; i++) {
            pointArray[i * 4] = (rect.width() * i) / (waveform.length - 1f);
            pointArray[i * 4 + 1] = (rect.height() / 2f) + ((((byte) (waveform[i] + 128f)) * (rect.height() / 2f)) / 128f);
            pointArray[i * 4 + 2] = (rect.width() * (i + 1f)) / (waveform.length - 1f);
            pointArray[i * 4 + 3] = (rect.height() / 2f) + ((((byte) (waveform[i + 1] + 128f)) * (rect.height() / 2f)) / 128f);
        }

        canvas.drawLines(pointArray, paint);
        paint.setTextSize(40f);
        canvas.drawText("Microphone", 30f, 50f, paint);
        super.onDraw(canvas);
    }
}

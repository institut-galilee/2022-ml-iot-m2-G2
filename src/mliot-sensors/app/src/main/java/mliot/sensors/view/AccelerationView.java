package mliot.sensors.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import mliot.sensors.model.Acceleration;

public class AccelerationView extends View {

    private float[] xPoints;
    private float[] yPoints;
    private float[] zPoints;

    private Paint xPaint;
    private Paint yPaint;
    private Paint zPaint;

    private float maxValue;
    private List<Acceleration> accelerationList;
    private static final int MAX_ITEMS = 50;

    public AccelerationView(Context context) {
        super(context);
        init();
    }

    public AccelerationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AccelerationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        accelerationList = new ArrayList<>();

        xPaint = new Paint();
        xPaint.setStrokeWidth(1f);
        xPaint.setAntiAlias(true);
        xPaint.setColor(Color.BLUE);

        yPaint = new Paint();
        yPaint.setStrokeWidth(1f);
        yPaint.setAntiAlias(true);
        yPaint.setColor(Color.YELLOW);

        zPaint = new Paint();
        zPaint.setStrokeWidth(1f);
        zPaint.setAntiAlias(true);
        zPaint.setColor(Color.WHITE);
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public void populateAcceleration(Acceleration acceleration) {
        if (accelerationList.size() == MAX_ITEMS) {
            accelerationList.remove(0);
        }
        accelerationList.add(acceleration);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (xPoints == null || xPoints.length < accelerationList.size() * 4) {
            xPoints = new float[accelerationList.size() * 4];
        }
        if (yPoints == null || yPoints.length < accelerationList.size() * 4) {
            yPoints = new float[accelerationList.size() * 4];
        }
        if (zPoints == null || zPoints.length < accelerationList.size() * 4) {
            zPoints = new float[accelerationList.size() * 4];
        }

        for (int i = 0; i < accelerationList.size() - 1; i++) {
            xPoints[i * 4] = (getWidth() * i) / (accelerationList.size() - 1f);
            xPoints[i * 4 + 1] = (getHeight() / 2f) + ((accelerationList.get(i).getX() * getHeight() * 2) / this.maxValue);
            xPoints[i * 4 + 2] = (getWidth() * (i + 1f)) / (accelerationList.size() - 1f);
            xPoints[i * 4 + 3] = (getHeight() / 2f) +((accelerationList.get(i + 1).getX() * getHeight() * 2) / this.maxValue);

            yPoints[i * 4] = (getWidth() * i) / (accelerationList.size() - 1f);
            yPoints[i * 4 + 1] = (getHeight() / 2f) + ((accelerationList.get(i).getY() * getHeight() * 2) / this.maxValue);
            yPoints[i * 4 + 2] = (getWidth() * (i + 1f)) / (accelerationList.size() - 1f);
            yPoints[i * 4 + 3] = (getHeight() / 2f) + ((accelerationList.get(i + 1).getY() * getHeight() * 2) / this.maxValue);

            zPoints[i * 4] = (getWidth() * i) / (accelerationList.size() - 1f);
            zPoints[i * 4 + 1] = (getHeight() / 2f) + ((accelerationList.get(i).getZ() * getHeight() * 2) / this.maxValue);
            zPoints[i * 4 + 2] = (getWidth() * (i + 1f)) / (accelerationList.size() - 1f);
            zPoints[i * 4 + 3] = (getHeight() / 2f) + ((accelerationList.get(i + 1).getZ() * getHeight() * 2) / this.maxValue);
        }
        canvas.drawLines(xPoints, xPaint);
        canvas.drawLines(yPoints, yPaint);
        canvas.drawLines(zPoints, zPaint);

        xPaint.setTextSize(40f);
        canvas.drawText("X", 30f, 50f, xPaint);

        yPaint.setTextSize(40f);
        canvas.drawText("Y", 80f, 50f, yPaint);

        zPaint.setTextSize(40f);
        canvas.drawText("Z", 130f, 50f, zPaint);
        super.onDraw(canvas);
    }
}

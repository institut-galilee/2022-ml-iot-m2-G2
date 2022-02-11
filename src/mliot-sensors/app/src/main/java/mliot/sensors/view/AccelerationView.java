package mliot.sensors.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mliot.sensors.model.Acceleration;

public class AccelerationView extends View {

    private float[] xPoints;
    private float[] yPoints;
    private float[] zPoints;

    private Paint xPaint;
    private Paint yPaint;
    private Paint zPaint;
    private Paint gPaint;

    private float maxValue;
    private List<Acceleration> accelerationList;
    private static final int MAX_ITEMS = 500;

    private int width;
    private int height;
    private float []verticalLines;
    private float []horizontalLines;
    private static int HORIZONTAL_SPACING;
    private static final int VERTICAL_SPACING = 50;

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
        xPaint.setColor(Color.rgb(135, 100, 69));

        yPaint = new Paint();
        yPaint.setStrokeWidth(1f);
        yPaint.setAntiAlias(true);
        yPaint.setColor(Color.rgb(23, 0, 85));

        zPaint = new Paint();
        zPaint.setStrokeWidth(1f);
        zPaint.setAntiAlias(true);
        zPaint.setColor(Color.rgb(121, 0, 255));

        gPaint = new Paint();
        gPaint.setTextSize(30f);
        gPaint.setStrokeWidth(1f);
        gPaint.setAntiAlias(true);
        gPaint.setColor(Color.argb(150, 255, 255, 255));
    }

    @Override
    @SuppressLint("DrawAllocation")
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        HORIZONTAL_SPACING = (int) ((getWidth() * VERTICAL_SPACING) / getHeight());
        this.width = getUsableWidth();
        this.height = getUsableHeight();
        verticalLines = new float[((int)(getHeight()/VERTICAL_SPACING) + 1) * 4];
        horizontalLines = new float[((int)(getWidth()/HORIZONTAL_SPACING) + 1) * 4];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
        drawGraph(canvas);
        drawCaption(canvas);
        super.onDraw(canvas);
    }

    private void drawCaption(Canvas canvas) {
        xPaint.setTextSize(40f);
        canvas.drawText("X", (float) (getWidth() / 2) - 50, 40f, xPaint);

        yPaint.setTextSize(40f);
        canvas.drawText("Y", (float) (getWidth() / 2), 40f, yPaint);

        zPaint.setTextSize(40f);
        canvas.drawText("Z", (float) (getWidth() / 2) + 50, 40f, zPaint);

    }

    private void drawGraph(Canvas canvas) {

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
            xPoints[i * 4] = ((this.width - HORIZONTAL_SPACING) * i) / (accelerationList.size() - 1f) + HORIZONTAL_SPACING;
            xPoints[i * 4 + 1] = ((this.height + VERTICAL_SPACING * 2f) / 2f) - ((accelerationList.get(i).getX() * this.height) / (this.maxValue * 2f));
            xPoints[i * 4 + 2] = ((this.width - HORIZONTAL_SPACING) * (i + 1f)) / (accelerationList.size() - 1f) + HORIZONTAL_SPACING;
            xPoints[i * 4 + 3] = ((this.height + VERTICAL_SPACING * 2f) / 2f) - ((accelerationList.get(i + 1).getX() * this.height) / (this.maxValue * 2f));

            yPoints[i * 4] = ((this.width - HORIZONTAL_SPACING) * i) / (accelerationList.size() - 1f) + HORIZONTAL_SPACING;
            yPoints[i * 4 + 1] = ((this.height + VERTICAL_SPACING * 2f) / 2f) - ((accelerationList.get(i).getY() * this.height) / (this.maxValue * 2f));
            yPoints[i * 4 + 2] = ((this.width - HORIZONTAL_SPACING) * (i + 1f)) / (accelerationList.size() - 1f) + HORIZONTAL_SPACING;
            yPoints[i * 4 + 3] = ((this.height + VERTICAL_SPACING * 2f) / 2f) - ((accelerationList.get(i + 1).getY() * this.height) / (this.maxValue * 2f));

            zPoints[i * 4] = ((this.width - HORIZONTAL_SPACING) * i) / (accelerationList.size() - 1f) + HORIZONTAL_SPACING;
            zPoints[i * 4 + 1] = ((this.height + VERTICAL_SPACING * 2f) / 2f) - ((accelerationList.get(i).getZ() * this.height) / (this.maxValue * 2f));
            zPoints[i * 4 + 2] = ((this.width - HORIZONTAL_SPACING) * (i + 1f)) / (accelerationList.size() - 1f) + HORIZONTAL_SPACING;
            zPoints[i * 4 + 3] = ((this.height + VERTICAL_SPACING * 2f) / 2f) - ((accelerationList.get(i + 1).getZ() * this.height) / (this.maxValue * 2f));
        }
        canvas.drawLines(xPoints, xPaint);
        canvas.drawLines(yPoints, yPaint);
        canvas.drawLines(zPoints, zPaint);
    }

    private void drawGrid(Canvas canvas) {
        float interval = (this.maxValue * VERTICAL_SPACING * 2) / this.height;
        float currentValue = this.maxValue;
        for (int i = 0; i < height; i +=VERTICAL_SPACING) {
            canvas.drawText(String.format(Locale.getDefault(), "%.1f", currentValue), (float) (HORIZONTAL_SPACING / 4), VERTICAL_SPACING + i, gPaint);
            verticalLines[(i/VERTICAL_SPACING) * 4] = HORIZONTAL_SPACING;
            verticalLines[((i/VERTICAL_SPACING) * 4) + 1] = VERTICAL_SPACING + i;
            verticalLines[((i/VERTICAL_SPACING) * 4) + 2] = width;
            verticalLines[((i/VERTICAL_SPACING) * 4) + 3] = VERTICAL_SPACING + i;
            currentValue -= interval;
        }

        for (int i = 0; i < width; i +=HORIZONTAL_SPACING) {
            horizontalLines[(i/HORIZONTAL_SPACING) * 4] = HORIZONTAL_SPACING + i;
            horizontalLines[((i/HORIZONTAL_SPACING) * 4) + 1] = VERTICAL_SPACING;
            horizontalLines[((i/HORIZONTAL_SPACING) * 4) + 2] = HORIZONTAL_SPACING + i;
            horizontalLines[((i/HORIZONTAL_SPACING) * 4) + 3] = height;
        }
        canvas.drawLines(verticalLines, gPaint);
        canvas.drawLines(horizontalLines, gPaint);
    }

    private int getUsableWidth() {
        int width = 0 ;
        while(HORIZONTAL_SPACING < (getWidth() - width)) {
            width += HORIZONTAL_SPACING;
        }
        return width;
    }

    private int getUsableHeight() {
        int height = 0 ;
        while(VERTICAL_SPACING < (getHeight() - height)) {
            height += VERTICAL_SPACING;
        }
        return height;
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
}

package com.microtech.aidexx.ui.main.trend.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.microtech.aidexx.R;
import java.util.ArrayList;
import java.util.List;

public class PieChartView extends View {
    private float mTextHeight;
    private TextPaint mTextPaint;
    private float mTextSize = 12.0f;
    private float mTextWidth;
    private float markerLineLength = 10.0f;
    private float pieChartCircleRadius = 110.0f;
    private final RectF pieChartCircleRectF = new RectF();
    private final List<PieceDataHolder> pieceDataHolders = new ArrayList();
    private float textBottom;

    public PieChartView(Context context) {
        super(context);
        init((AttributeSet) null, 0);
    }

    public PieChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public PieChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PieChartView, i, 0);
        this.pieChartCircleRadius = obtainStyledAttributes.getDimension(R.styleable.PieChartView_circleRadius, this.pieChartCircleRadius);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.PieChartView_textSize, this.mTextSize) / getResources().getDisplayMetrics().density;
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setFlags(1);
        this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {
        this.mTextPaint.setTextSize(TypedValue.applyDimension(2, this.mTextSize, getContext().getResources().getDisplayMetrics()));
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.mTextHeight = fontMetrics.descent - fontMetrics.ascent;
        this.textBottom = fontMetrics.bottom;
    }

    public void setPieChartCircleRadius(int i) {
        this.pieChartCircleRadius = (float) i;
        invalidate();
    }

    public void setMarkerLineLength(int i) {
        this.markerLineLength = (float) i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPieChartCircleRectF();
        drawAllSectors(canvas);
    }

    private void drawAllSectors(Canvas canvas) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (PieceDataHolder access$000 : this.pieceDataHolders) {
            f2 += access$000.value;
        }
        for (PieceDataHolder next : this.pieceDataHolders) {
            float f3 = (f / f2) * 360.0f;
            f += next.value;
            float access$0002 = (next.value / f2) * 360.0f;
            drawSector(canvas, next.color, f3, access$0002);
            if (next.value >= 5.0f) {
                drawMarkerLineAndText(canvas, next.color, f3 + (access$0002 / 2.0f), next.marker);
            }
        }
    }

    private void initPieChartCircleRectF() {
        this.pieChartCircleRectF.left = ((float) (getWidth() >> 1)) - this.pieChartCircleRadius;
        this.pieChartCircleRectF.top = ((float) (getHeight() >> 1)) - this.pieChartCircleRadius;
        RectF rectF = this.pieChartCircleRectF;
        rectF.right = rectF.left + (this.pieChartCircleRadius * 2.0f);
        RectF rectF2 = this.pieChartCircleRectF;
        rectF2.bottom = rectF2.top + (this.pieChartCircleRadius * 2.0f);
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        invalidateTextPaintAndMeasurements();
    }

    public void setData(List<PieceDataHolder> list) {
        if (list != null) {
            this.pieceDataHolders.clear();
            this.pieceDataHolders.addAll(list);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void drawSector(Canvas canvas, int i, float f, float f2) {
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        canvas.drawArc(this.pieChartCircleRectF, f, f2, true, paint);
    }

    /* access modifiers changed from: protected */
    public void drawMarkerLineAndText(Canvas canvas, int i, float f, String str) {
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        Path path = new Path();
        path.close();
        path.moveTo((float) (getWidth() >> 1), (float) (getHeight() >> 1));
        double d = (double) f;
        float width = (float) (((double) (getWidth() / 2)) + (((double) (this.markerLineLength + this.pieChartCircleRadius)) * Math.cos(Math.toRadians(d))));
        float height = (float) (((double) (getHeight() / 2)) + (((double) (this.markerLineLength + this.pieChartCircleRadius)) * Math.sin(Math.toRadians(d))));
        path.lineTo(width, height);
        int i2 = (270.0f > f ? 1 : (270.0f == f ? 0 : -1));
        float f2 = (i2 <= 0 || f <= 90.0f) ? width + 20.0f : width - 20.0f;
        path.lineTo(f2, height);
        canvas.drawPath(path, paint);
        this.mTextPaint.setColor(i);
        if (i2 <= 0 || f <= 90.0f) {
            canvas.drawText(str, f2, (height + (this.mTextHeight / 2.0f)) - this.textBottom, this.mTextPaint);
        } else {
            canvas.drawText(str, f2 - this.mTextPaint.measureText(str), (height + (this.mTextHeight / 2.0f)) - this.textBottom, this.mTextPaint);
        }
    }

    public static final class PieceDataHolder {
        /* access modifiers changed from: private */
        public final int color;
        /* access modifiers changed from: private */
        public final String marker;
        /* access modifiers changed from: private */
        public final float value;

        public PieceDataHolder(float f, int i, String str) {
            this.value = f;
            this.color = i;
            this.marker = str;
        }
    }
}

package com.microtech.aidexx.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.LogUtil;

public class HollowPieChartView extends View {
    float centerX = 0.0f;
    float centerY = 0.0f;
    private float mTextHeight;
    private TextPaint mTextPaint;
    private float mTextSize = 14.0f;
    private float mTextWidth;
    private float markerLineLength = 10.0f;
    private final Paint paint = new Paint();
    private final Path path = new Path();
    private float pieChartCircleRadius = 100.0f;
    private final RectF pieChartCircleRectF = new RectF();
    private PieceDataHolder pieceDataHolder;
    private float textBottom;

    public HollowPieChartView(Context context) {
        super(context);
        init((AttributeSet) null, 0);
    }

    public HollowPieChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public HollowPieChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HollowPieChartView, i, 0);
        this.pieChartCircleRadius = obtainStyledAttributes.getDimension(R.styleable.HollowPieChartView_pieRadius, this.pieChartCircleRadius);
        LogUtil.d("pieChartCircleRadius: " + this.pieChartCircleRadius, "");
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.HollowPieChartView_pieTextSize, this.mTextSize) / getResources().getDisplayMetrics().density;
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setFlags(1);
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
        if (this.pieceDataHolder != null) {
            initPieChartCircleRectF();
            drawAllSectors(canvas);
            this.path.reset();
            this.path.addCircle(this.centerX, this.centerY, this.pieChartCircleRadius * 0.7f, Path.Direction.CCW);
            canvas.clipPath(this.path, Region.Op.INTERSECT);
            canvas.drawColor(-1);
            drawCenterText(canvas);
            this.paint.setColor(SupportMenu.CATEGORY_MASK);
            this.paint.setStrokeWidth(3.0f);
        }
    }

    private void drawCenterText(Canvas canvas) {
        this.mTextPaint.setColor(this.pieceDataHolder.color);
        this.mTextPaint.setFlags(1);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        canvas.drawText(this.pieceDataHolder.marker, this.centerX, this.centerY + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.mTextPaint);
    }

    private void drawAllSectors(Canvas canvas) {
        float access$200 = (this.pieceDataHolder.value / 100.0f) * 360.0f;
        drawSector(canvas, this.pieceDataHolder.color, 0.0f, access$200);
        drawSector(canvas, this.pieceDataHolder.backGroundColor, access$200 + 0.0f, ((100.0f - this.pieceDataHolder.value) / 100.0f) * 360.0f);
    }

    private void initPieChartCircleRectF() {
        this.pieChartCircleRectF.left = (((float) getWidth()) / 2.0f) - this.pieChartCircleRadius;
        this.pieChartCircleRectF.top = (((float) getHeight()) / 2.0f) - this.pieChartCircleRadius;
        RectF rectF = this.pieChartCircleRectF;
        rectF.right = rectF.left + (this.pieChartCircleRadius * 2.0f);
        RectF rectF2 = this.pieChartCircleRectF;
        rectF2.bottom = rectF2.top + (this.pieChartCircleRadius * 2.0f);
        this.centerX = (this.pieChartCircleRectF.left + this.pieChartCircleRectF.right) / 2.0f;
        this.centerY = (this.pieChartCircleRectF.top + this.pieChartCircleRectF.bottom) / 2.0f;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        invalidateTextPaintAndMeasurements();
    }

    public void setData(PieceDataHolder pieceDataHolder2) {
        if (pieceDataHolder2 != null) {
            this.pieceDataHolder = pieceDataHolder2;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void drawSector(Canvas canvas, int i, float f, float f2) {
        Paint paint2 = new Paint();
        paint2.setFlags(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(i);
        canvas.drawArc(this.pieChartCircleRectF, f, f2, true, paint2);
    }

    /* access modifiers changed from: protected */
    public void drawMarkerLineAndText(Canvas canvas, int i, float f, String str) {
        Paint paint2 = new Paint();
        paint2.setFlags(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(i);
        Path path2 = new Path();
        path2.close();
        path2.moveTo((float) (getWidth() >> 1), (float) (getHeight() >> 1));
        double d = (double) f;
        float width = (float) (((double) (getWidth() / 2)) + (((double) (this.markerLineLength + this.pieChartCircleRadius)) * Math.cos(Math.toRadians(d))));
        float height = (float) (((double) (getHeight() / 2)) + (((double) (this.markerLineLength + this.pieChartCircleRadius)) * Math.sin(Math.toRadians(d))));
        path2.lineTo(width, height);
        int i2 = (270.0f > f ? 1 : (270.0f == f ? 0 : -1));
        float f2 = (i2 <= 0 || f <= 90.0f) ? width + 20.0f : width - 20.0f;
        path2.lineTo(f2, height);
        canvas.drawPath(path2, paint2);
        this.mTextPaint.setColor(i);
        if (i2 <= 0 || f <= 90.0f) {
            canvas.drawText(str, f2, (height + (this.mTextHeight / 2.0f)) - this.textBottom, this.mTextPaint);
        } else {
            canvas.drawText(str, f2 - this.mTextPaint.measureText(str), (height + (this.mTextHeight / 2.0f)) - this.textBottom, this.mTextPaint);
        }
    }

    public static final class PieceDataHolder {
        /* access modifiers changed from: private */
        public int backGroundColor;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public String marker;
        /* access modifiers changed from: private */
        public float value;

        public PieceDataHolder(float f, int i, int i2, String str) {
            this.value = f;
            this.color = i;
            this.backGroundColor = i2;
            this.marker = str;
        }
    }
}

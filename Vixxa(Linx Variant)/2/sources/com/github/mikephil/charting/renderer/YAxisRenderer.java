package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class YAxisRenderer extends AxisRenderer {
    protected Path mDrawZeroLinePath = new Path();
    protected float[] mGetTransformedPositionsBuffer = new float[2];
    protected RectF mGridClippingRect = new RectF();
    protected RectF mLimitLineClippingRect = new RectF();
    protected Path mRenderGridLinesPath = new Path();
    protected Path mRenderLimitLines = new Path();
    protected float[] mRenderLimitLinesBuffer = new float[2];
    protected YAxis mYAxis;
    protected RectF mZeroLineClippingRect = new RectF();
    protected Paint mZeroLinePaint;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.mYAxis = yAxis;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
            Paint paint = new Paint(1);
            this.mZeroLinePaint = paint;
            paint.setColor(-7829368);
            this.mZeroLinePaint.setStrokeWidth(1.0f);
            this.mZeroLinePaint.setStyle(Paint.Style.STROKE);
        }
    }

    public void renderAxisLabels(Canvas canvas) {
        float f;
        float f2;
        float f3;
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawLabelsEnabled()) {
            float[] transformedPositions = getTransformedPositions();
            this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
            float xOffset = this.mYAxis.getXOffset();
            float calcTextHeight = (((float) Utils.calcTextHeight(this.mAxisLabelPaint, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) / 2.5f) + this.mYAxis.getYOffset();
            YAxis.AxisDependency axisDependency = this.mYAxis.getAxisDependency();
            YAxis.YAxisLabelPosition labelPosition = this.mYAxis.getLabelPosition();
            if (axisDependency == YAxis.AxisDependency.LEFT) {
                if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                    f2 = this.mViewPortHandler.offsetLeft();
                    f = f2 - xOffset;
                    drawYLabels(canvas, f, transformedPositions, calcTextHeight);
                }
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                f3 = this.mViewPortHandler.offsetLeft();
            } else if (labelPosition == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.LEFT);
                f3 = this.mViewPortHandler.contentRight();
            } else {
                this.mAxisLabelPaint.setTextAlign(Paint.Align.RIGHT);
                f2 = this.mViewPortHandler.contentRight();
                f = f2 - xOffset;
                drawYLabels(canvas, f, transformedPositions, calcTextHeight);
            }
            f = f3 + xOffset;
            drawYLabels(canvas, f, transformedPositions, calcTextHeight);
        }
    }

    public void renderAxisLine(Canvas canvas) {
        if (this.mYAxis.isEnabled() && this.mYAxis.isDrawAxisLineEnabled()) {
            this.mAxisLinePaint.setColor(this.mYAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mYAxis.getAxisLineWidth());
            if (this.mYAxis.getAxisDependency() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
                return;
            }
            canvas.drawLine(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawYLabels(Canvas canvas, float f, float[] fArr, float f2) {
        int i;
        if (this.mYAxis.isDrawTopYLabelEntryEnabled()) {
            i = this.mYAxis.mEntryCount;
        } else {
            i = this.mYAxis.mEntryCount - 1;
        }
        float labelXOffset = this.mYAxis.getLabelXOffset();
        for (int i2 = !this.mYAxis.isDrawBottomYLabelEntryEnabled(); i2 < i; i2++) {
            canvas.drawText(this.mYAxis.getFormattedLabel(i2), f + labelXOffset, fArr[(i2 * 2) + 1] + f2, this.mAxisLabelPaint);
        }
    }

    public void renderGridLines(Canvas canvas) {
        if (this.mYAxis.isEnabled()) {
            if (this.mYAxis.isDrawGridLinesEnabled()) {
                int save = canvas.save();
                canvas.clipRect(getGridClippingRect());
                float[] transformedPositions = getTransformedPositions();
                this.mGridPaint.setColor(this.mYAxis.getGridColor());
                this.mGridPaint.setStrokeWidth(this.mYAxis.getGridLineWidth());
                this.mGridPaint.setPathEffect(this.mYAxis.getGridDashPathEffect());
                Path path = this.mRenderGridLinesPath;
                path.reset();
                for (int i = 0; i < transformedPositions.length; i += 2) {
                    canvas.drawPath(linePath(path, i, transformedPositions), this.mGridPaint);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.mYAxis.isDrawZeroLineEnabled()) {
                drawZeroLine(canvas);
            }
        }
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(0.0f, -this.mAxis.getGridLineWidth());
        return this.mGridClippingRect;
    }

    /* access modifiers changed from: protected */
    public Path linePath(Path path, int i, float[] fArr) {
        int i2 = i + 1;
        path.moveTo(this.mViewPortHandler.offsetLeft(), fArr[i2]);
        path.lineTo(this.mViewPortHandler.contentRight(), fArr[i2]);
        return path;
    }

    /* access modifiers changed from: protected */
    public float[] getTransformedPositions() {
        if (this.mGetTransformedPositionsBuffer.length != this.mYAxis.mEntryCount * 2) {
            this.mGetTransformedPositionsBuffer = new float[(this.mYAxis.mEntryCount * 2)];
        }
        float[] fArr = this.mGetTransformedPositionsBuffer;
        for (int i = 0; i < fArr.length; i += 2) {
            fArr[i + 1] = this.mYAxis.mEntries[i / 2];
        }
        this.mTrans.pointValuesToPixel(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public void drawZeroLine(Canvas canvas) {
        int save = canvas.save();
        this.mZeroLineClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mZeroLineClippingRect.inset(0.0f, -this.mYAxis.getZeroLineWidth());
        canvas.clipRect(this.mZeroLineClippingRect);
        MPPointD pixelForValues = this.mTrans.getPixelForValues(0.0f, 0.0f);
        this.mZeroLinePaint.setColor(this.mYAxis.getZeroLineColor());
        this.mZeroLinePaint.setStrokeWidth(this.mYAxis.getZeroLineWidth());
        Path path = this.mDrawZeroLinePath;
        path.reset();
        path.moveTo(this.mViewPortHandler.contentLeft(), (float) pixelForValues.y);
        path.lineTo(this.mViewPortHandler.contentRight(), (float) pixelForValues.y);
        canvas.drawPath(path, this.mZeroLinePaint);
        canvas.restoreToCount(save);
    }

    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mYAxis.getLimitLines();
        if (limitLines != null && limitLines.size() > 0) {
            float[] fArr = this.mRenderLimitLinesBuffer;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.mRenderLimitLines;
            path.reset();
            for (int i = 0; i < limitLines.size(); i++) {
                LimitLine limitLine = limitLines.get(i);
                if (limitLine.isEnabled()) {
                    int save = canvas.save();
                    this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                    this.mLimitLineClippingRect.inset(0.0f, -limitLine.getLineWidth());
                    canvas.clipRect(this.mLimitLineClippingRect);
                    this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
                    this.mLimitLinePaint.setColor(limitLine.getLineColor());
                    this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
                    this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
                    fArr[1] = limitLine.getLimit();
                    this.mTrans.pointValuesToPixel(fArr);
                    path.moveTo(this.mViewPortHandler.contentLeft(), fArr[1]);
                    path.lineTo(this.mViewPortHandler.contentRight(), fArr[1]);
                    canvas.drawPath(path, this.mLimitLinePaint);
                    path.reset();
                    String label = limitLine.getLabel();
                    if (label != null && !label.equals("")) {
                        this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
                        this.mLimitLinePaint.setPathEffect((PathEffect) null);
                        this.mLimitLinePaint.setColor(limitLine.getTextColor());
                        this.mLimitLinePaint.setTypeface(limitLine.getTypeface());
                        this.mLimitLinePaint.setStrokeWidth(0.5f);
                        this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
                        float calcTextHeight = (float) Utils.calcTextHeight(this.mLimitLinePaint, label);
                        float convertDpToPixel = Utils.convertDpToPixel(4.0f) + limitLine.getXOffset();
                        float lineWidth = limitLine.getLineWidth() + calcTextHeight + limitLine.getYOffset();
                        LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
                        if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(label, this.mViewPortHandler.contentRight() - convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                        } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, this.mViewPortHandler.contentLeft() + convertDpToPixel, (fArr[1] - lineWidth) + calcTextHeight, this.mLimitLinePaint);
                        } else {
                            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(label, this.mViewPortHandler.offsetLeft() + convertDpToPixel, fArr[1] + lineWidth, this.mLimitLinePaint);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeAxisValues(float r12, float r13) {
        /*
            r11 = this;
            com.github.mikephil.charting.components.AxisBase r0 = r11.mAxis
            int r0 = r0.getLabelCount()
            float r1 = r13 - r12
            float r1 = java.lang.Math.abs(r1)
            double r1 = (double) r1
            r3 = 0
            if (r0 == 0) goto L_0x011b
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x011b
            boolean r6 = java.lang.Double.isInfinite(r1)
            if (r6 == 0) goto L_0x001e
            goto L_0x011b
        L_0x001e:
            double r6 = (double) r0
            double r6 = r1 / r6
            float r6 = com.github.mikephil.charting.utils.Utils.roundToNextSignificant(r6)
            double r6 = (double) r6
            com.github.mikephil.charting.components.AxisBase r8 = r11.mAxis
            boolean r8 = r8.isGranularityEnabled()
            if (r8 == 0) goto L_0x0040
            com.github.mikephil.charting.components.AxisBase r8 = r11.mAxis
            float r8 = r8.getGranularity()
            double r8 = (double) r8
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0040
            com.github.mikephil.charting.components.AxisBase r6 = r11.mAxis
            float r6 = r6.getGranularity()
            double r6 = (double) r6
        L_0x0040:
            com.github.mikephil.charting.components.AxisBase r8 = r11.mAxis
            boolean r8 = r8.isCenterAxisLabelsEnabled()
            com.github.mikephil.charting.components.AxisBase r9 = r11.mAxis
            boolean r9 = r9.isForceLabelsEnabled()
            if (r9 == 0) goto L_0x0074
            float r13 = (float) r1
            int r1 = r0 + -1
            float r1 = (float) r1
            float r13 = r13 / r1
            double r6 = (double) r13
            com.github.mikephil.charting.components.AxisBase r13 = r11.mAxis
            r13.mEntryCount = r0
            com.github.mikephil.charting.components.AxisBase r13 = r11.mAxis
            float[] r13 = r13.mEntries
            int r13 = r13.length
            if (r13 >= r0) goto L_0x0065
            com.github.mikephil.charting.components.AxisBase r13 = r11.mAxis
            float[] r1 = new float[r0]
            r13.mEntries = r1
        L_0x0065:
            r13 = r3
        L_0x0066:
            if (r13 >= r0) goto L_0x00d6
            com.github.mikephil.charting.components.AxisBase r1 = r11.mAxis
            float[] r1 = r1.mEntries
            r1[r13] = r12
            double r1 = (double) r12
            double r1 = r1 + r6
            float r12 = (float) r1
            int r13 = r13 + 1
            goto L_0x0066
        L_0x0074:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x007a
            r1 = r4
            goto L_0x0081
        L_0x007a:
            double r1 = (double) r12
            double r1 = r1 / r6
            double r1 = java.lang.Math.ceil(r1)
            double r1 = r1 * r6
        L_0x0081:
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            boolean r12 = r12.isCenterAxisLabelsEnabled()
            if (r12 == 0) goto L_0x008a
            double r1 = r1 - r6
        L_0x008a:
            if (r0 != 0) goto L_0x008e
            r12 = r4
            goto L_0x0099
        L_0x008e:
            double r12 = (double) r13
            double r12 = r12 / r6
            double r12 = java.lang.Math.floor(r12)
            double r12 = r12 * r6
            double r12 = com.github.mikephil.charting.utils.Utils.nextUp(r12)
        L_0x0099:
            if (r0 == 0) goto L_0x00a8
            int r0 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00a8
            r9 = r1
        L_0x00a0:
            int r0 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x00b1
            int r8 = r8 + 1
            double r9 = r9 + r6
            goto L_0x00a0
        L_0x00a8:
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 != 0) goto L_0x00b1
            if (r8 != 0) goto L_0x00b1
            r12 = 1
            r0 = r12
            goto L_0x00b2
        L_0x00b1:
            r0 = r8
        L_0x00b2:
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            r12.mEntryCount = r0
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            float[] r12 = r12.mEntries
            int r12 = r12.length
            if (r12 >= r0) goto L_0x00c3
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            float[] r13 = new float[r0]
            r12.mEntries = r13
        L_0x00c3:
            r12 = r3
        L_0x00c4:
            if (r12 >= r0) goto L_0x00d6
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 != 0) goto L_0x00cb
            r1 = r4
        L_0x00cb:
            com.github.mikephil.charting.components.AxisBase r13 = r11.mAxis
            float[] r13 = r13.mEntries
            float r8 = (float) r1
            r13[r12] = r8
            double r1 = r1 + r6
            int r12 = r12 + 1
            goto L_0x00c4
        L_0x00d6:
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r12 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x00eb
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            double r1 = java.lang.Math.log10(r6)
            double r1 = -r1
            double r1 = java.lang.Math.ceil(r1)
            int r13 = (int) r1
            r12.mDecimals = r13
            goto L_0x00ef
        L_0x00eb:
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            r12.mDecimals = r3
        L_0x00ef:
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            boolean r12 = r12.isCenterAxisLabelsEnabled()
            if (r12 == 0) goto L_0x011a
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            float[] r12 = r12.mCenteredEntries
            int r12 = r12.length
            if (r12 >= r0) goto L_0x0104
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            float[] r13 = new float[r0]
            r12.mCenteredEntries = r13
        L_0x0104:
            float r12 = (float) r6
            r13 = 1073741824(0x40000000, float:2.0)
            float r12 = r12 / r13
        L_0x0108:
            if (r3 >= r0) goto L_0x011a
            com.github.mikephil.charting.components.AxisBase r13 = r11.mAxis
            float[] r13 = r13.mCenteredEntries
            com.github.mikephil.charting.components.AxisBase r1 = r11.mAxis
            float[] r1 = r1.mEntries
            r1 = r1[r3]
            float r1 = r1 + r12
            r13[r3] = r1
            int r3 = r3 + 1
            goto L_0x0108
        L_0x011a:
            return
        L_0x011b:
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            float[] r13 = new float[r3]
            r12.mEntries = r13
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            float[] r13 = new float[r3]
            r12.mCenteredEntries = r13
            com.github.mikephil.charting.components.AxisBase r12 = r11.mAxis
            r12.mEntryCount = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.YAxisRenderer.computeAxisValues(float, float):void");
    }
}

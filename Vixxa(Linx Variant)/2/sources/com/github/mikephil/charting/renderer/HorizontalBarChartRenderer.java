package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Fill;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class HorizontalBarChartRenderer extends BarChartRenderer {
    private final RectF mBarShadowRectBuffer = new RectF();

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Fill.Direction direction;
        IBarDataSet iBarDataSet2 = iBarDataSet;
        int i2 = i;
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        int i3 = 0;
        boolean z = true;
        boolean z2 = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) iBarDataSet.getEntryCount()) * phaseX)), iBarDataSet.getEntryCount());
            for (int i4 = 0; i4 < min; i4++) {
                BarEntry barEntry = (BarEntry) iBarDataSet2.getEntryForIndex(i4);
                if (barEntry != null) {
                    float x = barEntry.getX();
                    this.mBarShadowRectBuffer.top = x - barWidth;
                    this.mBarShadowRectBuffer.bottom = x + barWidth;
                    transformer.rectValueToPixel(this.mBarShadowRectBuffer);
                    if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                        if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                            break;
                        }
                        this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                        this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
                        canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                    }
                }
                Canvas canvas2 = canvas;
            }
        }
        Canvas canvas3 = canvas;
        BarBuffer barBuffer = this.mBarBuffers[i2];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i2);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet2);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z3 = iBarDataSet.getFills() != null && !iBarDataSet.getFills().isEmpty();
        if (iBarDataSet.getColors().size() != 1) {
            z = false;
        }
        boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
        if (z) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        int i5 = 0;
        while (i3 < barBuffer.size()) {
            int i6 = i3 + 3;
            if (this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i6])) {
                int i7 = i3 + 1;
                if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i7])) {
                    if (!z) {
                        this.mRenderPaint.setColor(iBarDataSet2.getColor(i3 / 4));
                    }
                    if (z3) {
                        Fill fill = iBarDataSet2.getFill(i5);
                        Paint paint = this.mRenderPaint;
                        float f = barBuffer.buffer[i3];
                        float f2 = barBuffer.buffer[i7];
                        float f3 = barBuffer.buffer[i3 + 2];
                        float f4 = barBuffer.buffer[i6];
                        if (isInverted) {
                            direction = Fill.Direction.LEFT;
                        } else {
                            direction = Fill.Direction.RIGHT;
                        }
                        fill.fillRect(canvas, paint, f, f2, f3, f4, direction);
                    } else {
                        canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i7], barBuffer.buffer[i3 + 2], barBuffer.buffer[i6], this.mRenderPaint);
                    }
                    if (z2) {
                        canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i7], barBuffer.buffer[i3 + 2], barBuffer.buffer[i6], this.mBarBorderPaint);
                    }
                }
                i3 += 4;
                i5++;
                Canvas canvas4 = canvas;
            } else {
                return;
            }
        }
    }

    public void drawValues(Canvas canvas) {
        List list;
        int i;
        MPPointF mPPointF;
        int i2;
        float[] fArr;
        float[] fArr2;
        int i3;
        float f;
        float f2;
        float f3;
        BarEntry barEntry;
        float f4;
        int i4;
        List list2;
        int i5;
        ValueFormatter valueFormatter;
        BarBuffer barBuffer;
        MPPointF mPPointF2;
        BarEntry barEntry2;
        ValueFormatter valueFormatter2;
        float f5;
        float f6;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (!shouldDrawValues(iBarDataSet)) {
                    list = dataSets;
                    i = i6;
                } else {
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    applyValueTextStyle(iBarDataSet);
                    float f7 = 2.0f;
                    float calcTextHeight = ((float) Utils.calcTextHeight(this.mValuePaint, "10")) / 2.0f;
                    ValueFormatter valueFormatter3 = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = this.mBarBuffers[i6];
                    float phaseY = this.mAnimator.getPhaseY();
                    MPPointF instance = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    if (!iBarDataSet.isStacked()) {
                        int i7 = 0;
                        while (((float) i7) < ((float) barBuffer2.buffer.length) * this.mAnimator.getPhaseX()) {
                            int i8 = i7 + 1;
                            float f8 = (barBuffer2.buffer[i8] + barBuffer2.buffer[i7 + 3]) / f7;
                            if (!this.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i8])) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i7]) && this.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i8]) && (barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i7 / 4)) != null) {
                                float y = barEntry2.getY();
                                String barLabel = valueFormatter3.getBarLabel(barEntry2);
                                float calcTextWidth = (float) Utils.calcTextWidth(this.mValuePaint, barLabel);
                                String str = barLabel;
                                float f9 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth + convertDpToPixel);
                                MPPointF mPPointF3 = instance;
                                if (isDrawValueAboveBarEnabled) {
                                    f5 = -(calcTextWidth + convertDpToPixel);
                                    valueFormatter2 = valueFormatter3;
                                } else {
                                    valueFormatter2 = valueFormatter3;
                                    f5 = convertDpToPixel;
                                }
                                int i9 = i7 + 2;
                                list2 = dataSets;
                                float f10 = f5 - (barBuffer2.buffer[i9] - barBuffer2.buffer[i7]);
                                if (isInverted) {
                                    f9 = (-f9) - calcTextWidth;
                                    f10 = (-f10) - calcTextWidth;
                                }
                                float f11 = f9;
                                float f12 = f10;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    float f13 = barBuffer2.buffer[i9];
                                    float f14 = y >= 0.0f ? f11 : f12;
                                    int valueTextColor = iBarDataSet.getValueTextColor(i7 / 2);
                                    i4 = i7;
                                    String str2 = str;
                                    f6 = f11;
                                    mPPointF2 = mPPointF3;
                                    i5 = i6;
                                    barBuffer = barBuffer2;
                                    f4 = calcTextHeight;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, str2, f13 + f14, f8 + calcTextHeight, valueTextColor);
                                } else {
                                    i4 = i7;
                                    f6 = f11;
                                    f4 = calcTextHeight;
                                    mPPointF2 = mPPointF3;
                                    valueFormatter = valueFormatter2;
                                    i5 = i6;
                                    barBuffer = barBuffer2;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry2.getIcon();
                                    float f15 = barBuffer.buffer[i9];
                                    if (y < 0.0f) {
                                        f6 = f12;
                                    }
                                    Utils.drawImage(canvas, icon, (int) (f15 + f6 + mPPointF2.x), (int) (f8 + mPPointF2.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            } else {
                                i4 = i7;
                                list2 = dataSets;
                                i5 = i6;
                                f4 = calcTextHeight;
                                mPPointF2 = instance;
                                barBuffer = barBuffer2;
                                valueFormatter = valueFormatter3;
                            }
                            i7 = i4 + 4;
                            instance = mPPointF2;
                            barBuffer2 = barBuffer;
                            valueFormatter3 = valueFormatter;
                            i6 = i5;
                            dataSets = list2;
                            calcTextHeight = f4;
                            f7 = 2.0f;
                        }
                        list = dataSets;
                        i = i6;
                        mPPointF = instance;
                    } else {
                        list = dataSets;
                        i = i6;
                        float f16 = calcTextHeight;
                        mPPointF = instance;
                        BarBuffer barBuffer3 = barBuffer2;
                        ValueFormatter valueFormatter4 = valueFormatter3;
                        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i10 = 0;
                        int i11 = 0;
                        while (((float) i10) < ((float) iBarDataSet.getEntryCount()) * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i10);
                            if (barEntry3 != null) {
                                int valueTextColor2 = iBarDataSet.getValueTextColor(i10);
                                float[] yVals = barEntry3.getYVals();
                                if (yVals != null) {
                                    BarEntry barEntry4 = barEntry3;
                                    i2 = i10;
                                    fArr = yVals;
                                    int length = fArr.length * 2;
                                    float[] fArr3 = new float[length];
                                    float f17 = -barEntry4.getNegativeSum();
                                    float f18 = 0.0f;
                                    int i12 = 0;
                                    int i13 = 0;
                                    while (i12 < length) {
                                        float f19 = fArr[i13];
                                        int i14 = (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1));
                                        if (i14 == 0 && (f18 == 0.0f || f17 == 0.0f)) {
                                            float f20 = f17;
                                            f17 = f19;
                                            f3 = f20;
                                        } else if (i14 >= 0) {
                                            f18 += f19;
                                            f3 = f17;
                                            f17 = f18;
                                        } else {
                                            f3 = f17 - f19;
                                        }
                                        fArr3[i12] = f17 * phaseY;
                                        i12 += 2;
                                        i13++;
                                        f17 = f3;
                                    }
                                    transformer.pointValuesToPixel(fArr3);
                                    int i15 = 0;
                                    while (true) {
                                        if (i15 >= length) {
                                            break;
                                        }
                                        float f21 = fArr[i15 / 2];
                                        String barStackedLabel = valueFormatter4.getBarStackedLabel(f21, barEntry4);
                                        float calcTextWidth2 = (float) Utils.calcTextWidth(this.mValuePaint, barStackedLabel);
                                        String str3 = barStackedLabel;
                                        float f22 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth2 + convertDpToPixel);
                                        int i16 = length;
                                        float f23 = isDrawValueAboveBarEnabled ? -(calcTextWidth2 + convertDpToPixel) : convertDpToPixel;
                                        if (isInverted) {
                                            f22 = (-f22) - calcTextWidth2;
                                            f23 = (-f23) - calcTextWidth2;
                                        }
                                        boolean z = (f21 == 0.0f && f17 == 0.0f && f18 > 0.0f) || f21 < 0.0f;
                                        float f24 = fArr3[i15];
                                        if (z) {
                                            f22 = f23;
                                        }
                                        float f25 = f24 + f22;
                                        float f26 = (barBuffer3.buffer[i11 + 1] + barBuffer3.buffer[i11 + 3]) / 2.0f;
                                        if (!this.mViewPortHandler.isInBoundsTop(f26)) {
                                            break;
                                        }
                                        if (this.mViewPortHandler.isInBoundsX(f25) && this.mViewPortHandler.isInBoundsBottom(f26)) {
                                            if (iBarDataSet.isDrawValuesEnabled()) {
                                                float f27 = f26 + f16;
                                                f = f26;
                                                String str4 = str3;
                                                i3 = i15;
                                                fArr2 = fArr3;
                                                float f28 = f27;
                                                f2 = f25;
                                                drawValue(canvas, str4, f25, f28, valueTextColor2);
                                            } else {
                                                f = f26;
                                                i3 = i15;
                                                fArr2 = fArr3;
                                                f2 = f25;
                                            }
                                            if (barEntry4.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                                Drawable icon2 = barEntry4.getIcon();
                                                Utils.drawImage(canvas, icon2, (int) (f2 + mPPointF.x), (int) (f + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                            }
                                        } else {
                                            i3 = i15;
                                            fArr2 = fArr3;
                                        }
                                        i15 = i3 + 2;
                                        length = i16;
                                        fArr3 = fArr2;
                                    }
                                } else {
                                    int i17 = i11 + 1;
                                    if (!this.mViewPortHandler.isInBoundsTop(barBuffer3.buffer[i17])) {
                                        break;
                                    } else if (this.mViewPortHandler.isInBoundsX(barBuffer3.buffer[i11]) && this.mViewPortHandler.isInBoundsBottom(barBuffer3.buffer[i17])) {
                                        String barLabel2 = valueFormatter4.getBarLabel(barEntry3);
                                        float calcTextWidth3 = (float) Utils.calcTextWidth(this.mValuePaint, barLabel2);
                                        float f29 = isDrawValueAboveBarEnabled ? convertDpToPixel : -(calcTextWidth3 + convertDpToPixel);
                                        float f30 = isDrawValueAboveBarEnabled ? -(calcTextWidth3 + convertDpToPixel) : convertDpToPixel;
                                        if (isInverted) {
                                            f29 = (-f29) - calcTextWidth3;
                                            f30 = (-f30) - calcTextWidth3;
                                        }
                                        float f31 = f29;
                                        float f32 = f30;
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            i2 = i10;
                                            fArr = yVals;
                                            barEntry = barEntry3;
                                            drawValue(canvas, barLabel2, barBuffer3.buffer[i11 + 2] + (barEntry3.getY() >= 0.0f ? f31 : f32), barBuffer3.buffer[i17] + f16, valueTextColor2);
                                        } else {
                                            barEntry = barEntry3;
                                            i2 = i10;
                                            fArr = yVals;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon3 = barEntry.getIcon();
                                            float f33 = barBuffer3.buffer[i11 + 2];
                                            if (barEntry.getY() < 0.0f) {
                                                f31 = f32;
                                            }
                                            Utils.drawImage(canvas, icon3, (int) (f33 + f31 + mPPointF.x), (int) (barBuffer3.buffer[i17] + mPPointF.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                        }
                                    }
                                }
                                i11 = fArr == null ? i11 + 4 : i11 + (fArr.length * 4);
                                i10 = i2 + 1;
                            }
                        }
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i6 = i + 1;
                dataSets = list;
            }
        }
    }

    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    /* access modifiers changed from: protected */
    public void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f2, f - f4, f3, f + f4);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* access modifiers changed from: protected */
    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }

    /* access modifiers changed from: protected */
    public boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }
}

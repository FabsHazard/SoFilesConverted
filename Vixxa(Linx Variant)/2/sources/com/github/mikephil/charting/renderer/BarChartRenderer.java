package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Fill;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect = new RectF();
    private final RectF mBarShadowRectBuffer = new RectF();
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    public void drawExtras(Canvas canvas) {
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = barDataProvider;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint = new Paint(1);
        this.mShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mBarBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i);
            }
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
                float x = ((BarEntry) iBarDataSet2.getEntryForIndex(i4)).getX();
                this.mBarShadowRectBuffer.left = x - barWidth;
                this.mBarShadowRectBuffer.right = x + barWidth;
                transformer.rectValueToPixel(this.mBarShadowRectBuffer);
                if (!this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    Canvas canvas2 = canvas;
                } else if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                    break;
                } else {
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
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
            int i6 = i3 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i6])) {
                if (this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i3])) {
                    if (!z) {
                        this.mRenderPaint.setColor(iBarDataSet2.getColor(i5));
                    }
                    if (z3) {
                        Fill fill = iBarDataSet2.getFill(i5);
                        Paint paint = this.mRenderPaint;
                        float f = barBuffer.buffer[i3];
                        float f2 = barBuffer.buffer[i3 + 1];
                        float f3 = barBuffer.buffer[i6];
                        float f4 = barBuffer.buffer[i3 + 3];
                        if (isInverted) {
                            direction = Fill.Direction.DOWN;
                        } else {
                            direction = Fill.Direction.UP;
                        }
                        fill.fillRect(canvas, paint, f, f2, f3, f4, direction);
                    } else {
                        canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i3 + 1], barBuffer.buffer[i6], barBuffer.buffer[i3 + 3], this.mRenderPaint);
                    }
                    if (z2) {
                        canvas.drawRect(barBuffer.buffer[i3], barBuffer.buffer[i3 + 1], barBuffer.buffer[i6], barBuffer.buffer[i3 + 3], this.mBarBorderPaint);
                    }
                } else {
                    return;
                }
            }
            i3 += 4;
            i5++;
            Canvas canvas4 = canvas;
        }
    }

    /* access modifiers changed from: protected */
    public void prepareBarHighlight(float f, float f2, float f3, float f4, Transformer transformer) {
        this.mBarRect.set(f - f4, f2, f + f4, f3);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    public void drawValues(Canvas canvas) {
        boolean z;
        float f;
        float f2;
        List list;
        boolean z2;
        MPPointF mPPointF;
        int i;
        float f3;
        boolean z3;
        Transformer transformer;
        float[] fArr;
        float f4;
        int i2;
        int i3;
        BarEntry barEntry;
        float[] fArr2;
        float f5;
        float f6;
        float f7;
        BarEntry barEntry2;
        List list2;
        int i4;
        ValueFormatter valueFormatter;
        MPPointF mPPointF2;
        float f8;
        BarEntry barEntry3;
        float f9;
        float f10;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getBarData().getDataSets();
            float convertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean isDrawValueAboveBarEnabled = this.mChart.isDrawValueAboveBarEnabled();
            int i5 = 0;
            while (i5 < this.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i5);
                if (!shouldDrawValues(iBarDataSet)) {
                    list = dataSets;
                    f2 = f;
                    z2 = z;
                } else {
                    applyValueTextStyle(iBarDataSet);
                    boolean isInverted = this.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float calcTextHeight = (float) Utils.calcTextHeight(this.mValuePaint, "8");
                    float f11 = z ? -f : calcTextHeight + f;
                    float f12 = z ? calcTextHeight + f : -f;
                    if (isInverted) {
                        f11 = (-f11) - calcTextHeight;
                        f12 = (-f12) - calcTextHeight;
                    }
                    float f13 = f11;
                    float f14 = f12;
                    BarBuffer barBuffer = this.mBarBuffers[i5];
                    float phaseY = this.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF instance = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    if (!iBarDataSet.isStacked()) {
                        int i6 = 0;
                        while (((float) i6) < ((float) barBuffer.buffer.length) * this.mAnimator.getPhaseX()) {
                            float f15 = (barBuffer.buffer[i6] + barBuffer.buffer[i6 + 2]) / 2.0f;
                            if (!this.mViewPortHandler.isInBoundsRight(f15)) {
                                break;
                            }
                            int i7 = i6 + 1;
                            if (!this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i7]) || !this.mViewPortHandler.isInBoundsLeft(f15)) {
                                i4 = i6;
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = instance;
                            } else {
                                int i8 = i6 / 4;
                                BarEntry barEntry4 = (BarEntry) iBarDataSet.getEntryForIndex(i8);
                                float y = barEntry4.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    String barLabel = valueFormatter2.getBarLabel(barEntry4);
                                    if (y >= 0.0f) {
                                        f10 = barBuffer.buffer[i7] + f13;
                                    } else {
                                        f10 = barBuffer.buffer[i6 + 3] + f14;
                                    }
                                    barEntry3 = barEntry4;
                                    f8 = f15;
                                    String str = barLabel;
                                    i4 = i6;
                                    list2 = dataSets;
                                    mPPointF2 = instance;
                                    float f16 = f10;
                                    valueFormatter = valueFormatter2;
                                    drawValue(canvas, str, f8, f16, iBarDataSet.getValueTextColor(i8));
                                } else {
                                    barEntry3 = barEntry4;
                                    f8 = f15;
                                    i4 = i6;
                                    valueFormatter = valueFormatter2;
                                    list2 = dataSets;
                                    mPPointF2 = instance;
                                }
                                if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = barEntry3.getIcon();
                                    if (y >= 0.0f) {
                                        f9 = barBuffer.buffer[i7] + f13;
                                    } else {
                                        f9 = barBuffer.buffer[i4 + 3] + f14;
                                    }
                                    Utils.drawImage(canvas, icon, (int) (f8 + mPPointF2.x), (int) (f9 + mPPointF2.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            }
                            i6 = i4 + 4;
                            instance = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                        }
                        list = dataSets;
                        mPPointF = instance;
                    } else {
                        ValueFormatter valueFormatter3 = valueFormatter2;
                        list = dataSets;
                        mPPointF = instance;
                        Transformer transformer2 = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i9 = 0;
                        int i10 = 0;
                        while (((float) i9) < ((float) iBarDataSet.getEntryCount()) * this.mAnimator.getPhaseX()) {
                            BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i9);
                            float[] yVals = barEntry5.getYVals();
                            float f17 = (barBuffer.buffer[i10] + barBuffer.buffer[i10 + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i9);
                            if (yVals != null) {
                                BarEntry barEntry6 = barEntry5;
                                i = i9;
                                f3 = f;
                                z3 = z;
                                fArr = yVals;
                                transformer = transformer2;
                                float f18 = f17;
                                int length = fArr.length * 2;
                                float[] fArr3 = new float[length];
                                float f19 = -barEntry6.getNegativeSum();
                                float f20 = 0.0f;
                                int i11 = 0;
                                int i12 = 0;
                                while (i11 < length) {
                                    float f21 = fArr[i12];
                                    int i13 = (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1));
                                    if (i13 == 0 && (f20 == 0.0f || f19 == 0.0f)) {
                                        float f22 = f19;
                                        f19 = f21;
                                        f6 = f22;
                                    } else if (i13 >= 0) {
                                        f20 += f21;
                                        f6 = f19;
                                        f19 = f20;
                                    } else {
                                        f6 = f19 - f21;
                                    }
                                    fArr3[i11 + 1] = f19 * phaseY;
                                    i11 += 2;
                                    i12++;
                                    f19 = f6;
                                }
                                transformer.pointValuesToPixel(fArr3);
                                int i14 = 0;
                                while (i14 < length) {
                                    float f23 = fArr[i14 / 2];
                                    float f24 = fArr3[i14 + 1] + (((f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) == 0 && (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) == 0 && (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) > 0) || (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1)) < 0 ? f14 : f13);
                                    int i15 = i14;
                                    if (!this.mViewPortHandler.isInBoundsRight(f18)) {
                                        break;
                                    }
                                    if (!this.mViewPortHandler.isInBoundsY(f24) || !this.mViewPortHandler.isInBoundsLeft(f18)) {
                                        i2 = length;
                                        f4 = f18;
                                        i3 = i15;
                                        barEntry = barEntry6;
                                        fArr2 = fArr3;
                                    } else {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f5 = f24;
                                            i3 = i15;
                                            barEntry = barEntry7;
                                            fArr2 = fArr3;
                                            i2 = length;
                                            f4 = f18;
                                            drawValue(canvas, valueFormatter3.getBarStackedLabel(f23, barEntry7), f18, f5, valueTextColor);
                                        } else {
                                            f5 = f24;
                                            i2 = length;
                                            f4 = f18;
                                            i3 = i15;
                                            barEntry = barEntry6;
                                            fArr2 = fArr3;
                                        }
                                        if (barEntry.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f4 + mPPointF.x), (int) (f5 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    }
                                    i14 = i3 + 2;
                                    fArr3 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i2;
                                    f18 = f4;
                                }
                            } else if (!this.mViewPortHandler.isInBoundsRight(f17)) {
                                break;
                            } else {
                                float[] fArr4 = yVals;
                                int i16 = i10 + 1;
                                if (!this.mViewPortHandler.isInBoundsY(barBuffer.buffer[i16]) || !this.mViewPortHandler.isInBoundsLeft(f17)) {
                                    transformer2 = transformer2;
                                    z = z;
                                    f = f;
                                    i9 = i9;
                                } else {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        f7 = f17;
                                        f3 = f;
                                        fArr = fArr4;
                                        barEntry2 = barEntry5;
                                        i = i9;
                                        z3 = z;
                                        transformer = transformer2;
                                        drawValue(canvas, valueFormatter3.getBarLabel(barEntry5), f7, barBuffer.buffer[i16] + (barEntry5.getY() >= 0.0f ? f13 : f14), valueTextColor);
                                    } else {
                                        f7 = f17;
                                        i = i9;
                                        f3 = f;
                                        z3 = z;
                                        fArr = fArr4;
                                        barEntry2 = barEntry5;
                                        transformer = transformer2;
                                    }
                                    if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                        Drawable icon3 = barEntry2.getIcon();
                                        Utils.drawImage(canvas, icon3, (int) (mPPointF.x + f7), (int) (barBuffer.buffer[i16] + (barEntry2.getY() >= 0.0f ? f13 : f14) + mPPointF.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                    }
                                }
                            }
                            i10 = fArr == null ? i10 + 4 : i10 + (fArr.length * 4);
                            i9 = i + 1;
                            transformer2 = transformer;
                            z = z3;
                            f = f3;
                        }
                    }
                    f2 = f;
                    z2 = z;
                    MPPointF.recycleInstance(mPPointF);
                }
                i5++;
                isDrawValueAboveBarEnabled = z2;
                dataSets = list;
                convertDpToPixel = f2;
            }
        }
    }

    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float f;
        float f2;
        float f3;
        float f4;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() < 0 || !barEntry.isStacked()) {
                        f4 = barEntry.getY();
                        f3 = 0.0f;
                    } else if (this.mChart.isHighlightFullBarEnabled()) {
                        f4 = barEntry.getPositiveSum();
                        f3 = -barEntry.getNegativeSum();
                    } else {
                        Range range = barEntry.getRanges()[highlight.getStackIndex()];
                        f2 = range.from;
                        f = range.to;
                        prepareBarHighlight(barEntry.getX(), f2, f, barData.getBarWidth() / 2.0f, transformer);
                        setHighlightDrawPos(highlight, this.mBarRect);
                        canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                    }
                    f = f3;
                    f2 = f4;
                    prepareBarHighlight(barEntry.getX(), f2, f, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}

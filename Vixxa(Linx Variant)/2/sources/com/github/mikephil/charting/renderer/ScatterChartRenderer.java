package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer = new float[2];

    public void drawExtras(Canvas canvas) {
    }

    public void initBuffers() {
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = scatterDataProvider;
    }

    public void drawData(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.mChart.getScatterData().getDataSets()) {
            if (iScatterDataSet.isVisible()) {
                drawDataSet(canvas, iScatterDataSet);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        int i;
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        if (iScatterDataSet.getEntryCount() >= 1) {
            ViewPortHandler viewPortHandler = this.mViewPortHandler;
            Transformer transformer = this.mChart.getTransformer(iScatterDataSet.getAxisDependency());
            float phaseY = this.mAnimator.getPhaseY();
            IShapeRenderer shapeRenderer = iScatterDataSet.getShapeRenderer();
            if (shapeRenderer == null) {
                Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
                return;
            }
            int min = (int) Math.min(Math.ceil((double) (((float) iScatterDataSet.getEntryCount()) * this.mAnimator.getPhaseX())), (double) ((float) iScatterDataSet.getEntryCount()));
            int i2 = 0;
            while (i2 < min) {
                Entry entryForIndex = iScatterDataSet2.getEntryForIndex(i2);
                if (entryForIndex != null) {
                    this.mPixelBuffer[0] = entryForIndex.getX();
                    this.mPixelBuffer[1] = entryForIndex.getY() * phaseY;
                    transformer.pointValuesToPixel(this.mPixelBuffer);
                    if (viewPortHandler.isInBoundsRight(this.mPixelBuffer[0])) {
                        if (viewPortHandler.isInBoundsLeft(this.mPixelBuffer[0]) && viewPortHandler.isInBoundsY(this.mPixelBuffer[1])) {
                            this.mRenderPaint.setColor(iScatterDataSet2.getColor(i2 / 2));
                            ViewPortHandler viewPortHandler2 = this.mViewPortHandler;
                            float[] fArr = this.mPixelBuffer;
                            i = i2;
                            shapeRenderer.renderShape(canvas, iScatterDataSet, viewPortHandler2, fArr[0], fArr[1], this.mRenderPaint);
                            i2 = i + 1;
                        }
                    } else {
                        return;
                    }
                }
                i = i2;
                i2 = i + 1;
            }
        }
    }

    public void drawValues(Canvas canvas) {
        IScatterDataSet iScatterDataSet;
        Entry entry;
        IScatterDataSet iScatterDataSet2;
        Drawable icon;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getScatterData().getDataSets();
            for (int i = 0; i < this.mChart.getScatterData().getDataSetCount(); i++) {
                IScatterDataSet iScatterDataSet3 = (IScatterDataSet) dataSets.get(i);
                boolean isAttachedToLineDataSet = iScatterDataSet3.isAttachedToLineDataSet();
                if (shouldDrawValues(iScatterDataSet3) && iScatterDataSet3.getEntryCount() >= 1) {
                    applyValueTextStyle(iScatterDataSet3);
                    this.mXBounds.set(this.mChart, iScatterDataSet3);
                    float[] generateTransformedValuesScatter = this.mChart.getTransformer(iScatterDataSet3.getAxisDependency()).generateTransformedValuesScatter(iScatterDataSet3, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), this.mXBounds.min, this.mXBounds.max);
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet3.getScatterShapeSize());
                    ValueFormatter valueFormatter = iScatterDataSet3.getValueFormatter();
                    MPPointF instance = MPPointF.getInstance(iScatterDataSet3.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    int i2 = 0;
                    while (i2 < generateTransformedValuesScatter.length && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i2])) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i2])) {
                            int i3 = i2 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i3])) {
                                int i4 = i2 / 2;
                                Entry entryForIndex = iScatterDataSet3.getEntryForIndex(this.mXBounds.min + i4);
                                if (entryForIndex != null) {
                                    if (iScatterDataSet3.isDrawValuesEnabled()) {
                                        String pointLabel = valueFormatter.getPointLabel(entryForIndex);
                                        float f = generateTransformedValuesScatter[i2];
                                        entry = entryForIndex;
                                        float f2 = generateTransformedValuesScatter[i3] - convertDpToPixel;
                                        iScatterDataSet2 = iScatterDataSet3;
                                        drawValue(canvas, pointLabel, f, f2, iScatterDataSet3.getValueTextColor(i4 + this.mXBounds.min));
                                    } else {
                                        entry = entryForIndex;
                                        iScatterDataSet2 = iScatterDataSet3;
                                    }
                                    if (entry.getIcon() == null || !iScatterDataSet2.isDrawIconsEnabled()) {
                                        iScatterDataSet = iScatterDataSet2;
                                        i2 += 2;
                                        iScatterDataSet3 = iScatterDataSet;
                                    } else {
                                        Drawable icon2 = entry.getIcon();
                                        if (isAttachedToLineDataSet) {
                                            int i5 = 0;
                                            while (i5 < i2) {
                                                IScatterDataSet iScatterDataSet4 = iScatterDataSet2;
                                                Entry entryForIndex2 = iScatterDataSet4.getEntryForIndex((i5 / 2) + this.mXBounds.min);
                                                if (!(entryForIndex2 == null || (icon = entryForIndex2.getIcon()) == null)) {
                                                    int intrinsicHeight = (icon2.getIntrinsicHeight() + icon.getIntrinsicHeight()) / 2;
                                                    if (Math.abs(generateTransformedValuesScatter[i2] - generateTransformedValuesScatter[i5]) < ((float) ((icon2.getIntrinsicWidth() + icon.getIntrinsicWidth()) / 2))) {
                                                        int i6 = i5 + 1;
                                                        float f3 = (float) intrinsicHeight;
                                                        if (Math.abs(generateTransformedValuesScatter[i3] - generateTransformedValuesScatter[i6]) < f3) {
                                                            generateTransformedValuesScatter[i3] = generateTransformedValuesScatter[i6] - f3;
                                                        }
                                                    }
                                                }
                                                i5 += 2;
                                                iScatterDataSet2 = iScatterDataSet4;
                                            }
                                        }
                                        iScatterDataSet = iScatterDataSet2;
                                        Utils.drawImage(canvas, icon2, (int) (generateTransformedValuesScatter[i2] + instance.x), (int) (generateTransformedValuesScatter[i3] + instance.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        i2 += 2;
                                        iScatterDataSet3 = iScatterDataSet;
                                    }
                                }
                            }
                        }
                        iScatterDataSet = iScatterDataSet3;
                        i2 += 2;
                        iScatterDataSet3 = iScatterDataSet;
                    }
                    MPPointF.recycleInstance(instance);
                }
            }
        }
    }

    public void drawValues(Canvas canvas, List<Float> list) {
        IScatterDataSet iScatterDataSet;
        Entry entry;
        IScatterDataSet iScatterDataSet2;
        Drawable icon;
        List<Float> list2 = list;
        if (isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getScatterData().getDataSets();
            for (int i = 0; i < this.mChart.getScatterData().getDataSetCount(); i++) {
                IScatterDataSet iScatterDataSet3 = (IScatterDataSet) dataSets.get(i);
                boolean isAttachedToLineDataSet = iScatterDataSet3.isAttachedToLineDataSet();
                if (shouldDrawValues(iScatterDataSet3) && iScatterDataSet3.getEntryCount() >= 1) {
                    applyValueTextStyle(iScatterDataSet3);
                    this.mXBounds.set(this.mChart, iScatterDataSet3);
                    float[] generateTransformedValuesScatter = this.mChart.getTransformer(iScatterDataSet3.getAxisDependency()).generateTransformedValuesScatter(iScatterDataSet3, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), this.mXBounds.min, this.mXBounds.max);
                    if (isAttachedToLineDataSet) {
                        for (int i2 = 0; i2 < generateTransformedValuesScatter.length; i2 += 2) {
                            float f = 20.0f;
                            int i3 = 0;
                            for (int i4 = 0; i4 < list.size(); i4 += 2) {
                                if (list2.get(i4) != null) {
                                    float abs = Math.abs(generateTransformedValuesScatter[i2] - list2.get(i4).floatValue());
                                    if (abs < f) {
                                        i3 = i4;
                                        f = abs;
                                    }
                                }
                            }
                            if (f < 17.0f) {
                                generateTransformedValuesScatter[i2 + 1] = list2.get(i3 + 1).floatValue();
                            }
                        }
                    }
                    float convertDpToPixel = Utils.convertDpToPixel(iScatterDataSet3.getScatterShapeSize());
                    ValueFormatter valueFormatter = iScatterDataSet3.getValueFormatter();
                    MPPointF instance = MPPointF.getInstance(iScatterDataSet3.getIconsOffset());
                    instance.x = Utils.convertDpToPixel(instance.x);
                    instance.y = Utils.convertDpToPixel(instance.y);
                    int i5 = 0;
                    while (i5 < generateTransformedValuesScatter.length && this.mViewPortHandler.isInBoundsRight(generateTransformedValuesScatter[i5])) {
                        if (this.mViewPortHandler.isInBoundsLeft(generateTransformedValuesScatter[i5])) {
                            int i6 = i5 + 1;
                            if (this.mViewPortHandler.isInBoundsY(generateTransformedValuesScatter[i6])) {
                                int i7 = i5 / 2;
                                Entry entryForIndex = iScatterDataSet3.getEntryForIndex(this.mXBounds.min + i7);
                                if (entryForIndex != null) {
                                    if (iScatterDataSet3.isDrawValuesEnabled()) {
                                        String pointLabel = valueFormatter.getPointLabel(entryForIndex);
                                        float f2 = generateTransformedValuesScatter[i5];
                                        entry = entryForIndex;
                                        float f3 = generateTransformedValuesScatter[i6] - convertDpToPixel;
                                        iScatterDataSet2 = iScatterDataSet3;
                                        drawValue(canvas, pointLabel, f2, f3, iScatterDataSet3.getValueTextColor(i7 + this.mXBounds.min));
                                    } else {
                                        entry = entryForIndex;
                                        iScatterDataSet2 = iScatterDataSet3;
                                    }
                                    if (entry.getIcon() == null || !iScatterDataSet2.isDrawIconsEnabled()) {
                                        iScatterDataSet = iScatterDataSet2;
                                        i5 += 2;
                                        iScatterDataSet3 = iScatterDataSet;
                                    } else {
                                        Drawable icon2 = entry.getIcon();
                                        if (isAttachedToLineDataSet) {
                                            int i8 = 0;
                                            while (i8 < i5) {
                                                IScatterDataSet iScatterDataSet4 = iScatterDataSet2;
                                                Entry entryForIndex2 = iScatterDataSet4.getEntryForIndex((i8 / 2) + this.mXBounds.min);
                                                if (!(entryForIndex2 == null || (icon = entryForIndex2.getIcon()) == null)) {
                                                    int intrinsicHeight = (icon2.getIntrinsicHeight() + icon.getIntrinsicHeight()) / 2;
                                                    if (Math.abs(generateTransformedValuesScatter[i5] - generateTransformedValuesScatter[i8]) < ((float) ((icon2.getIntrinsicWidth() + icon.getIntrinsicWidth()) / 2))) {
                                                        int i9 = i8 + 1;
                                                        float f4 = (float) intrinsicHeight;
                                                        if (Math.abs(generateTransformedValuesScatter[i6] - generateTransformedValuesScatter[i9]) < f4) {
                                                            generateTransformedValuesScatter[i6] = generateTransformedValuesScatter[i9] - f4;
                                                        }
                                                    }
                                                }
                                                i8 += 2;
                                                iScatterDataSet2 = iScatterDataSet4;
                                            }
                                        }
                                        iScatterDataSet = iScatterDataSet2;
                                        Utils.drawImage(canvas, icon2, (int) (generateTransformedValuesScatter[i5] + instance.x), (int) (generateTransformedValuesScatter[i6] + instance.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        i5 += 2;
                                        iScatterDataSet3 = iScatterDataSet;
                                    }
                                }
                            }
                        }
                        iScatterDataSet = iScatterDataSet3;
                        i5 += 2;
                        iScatterDataSet3 = iScatterDataSet;
                    }
                    MPPointF.recycleInstance(instance);
                }
            }
        }
    }

    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.mChart.getScatterData();
        for (Highlight highlight : highlightArr) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iScatterDataSet != null && iScatterDataSet.isHighlightEnabled()) {
                Entry entryForXValue = iScatterDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iScatterDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.x, (float) pixelForValues.y);
                    drawHighlightLines(canvas, (float) pixelForValues.x, (float) pixelForValues.y, iScatterDataSet);
                }
            }
        }
    }
}

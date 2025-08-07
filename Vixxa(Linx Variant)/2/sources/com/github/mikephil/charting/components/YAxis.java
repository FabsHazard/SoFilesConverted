package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {
    private final AxisDependency mAxisDependency;
    private final boolean mDrawBottomYLabelEntry;
    private boolean mDrawTopYLabelEntry;
    protected boolean mDrawZeroLine;
    protected boolean mInverted;
    protected float mMaxWidth;
    protected float mMinWidth;
    private YAxisLabelPosition mPosition;
    protected float mSpacePercentBottom;
    protected float mSpacePercentTop;
    private boolean mUseAutoScaleRestrictionMax;
    private boolean mUseAutoScaleRestrictionMin;
    private float mXLabelOffset;
    protected int mZeroLineColor;
    protected float mZeroLineWidth;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public boolean isDrawBottomYLabelEntryEnabled() {
        return true;
    }

    public YAxis() {
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mUseAutoScaleRestrictionMin = false;
        this.mUseAutoScaleRestrictionMax = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mXLabelOffset = 0.0f;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mYOffset = 0.0f;
    }

    public YAxis(AxisDependency axisDependency) {
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mUseAutoScaleRestrictionMin = false;
        this.mUseAutoScaleRestrictionMax = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mXLabelOffset = 0.0f;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mAxisDependency = axisDependency;
        this.mYOffset = 0.0f;
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public float getMinWidth() {
        return this.mMinWidth;
    }

    public void setMinWidth(float f) {
        this.mMinWidth = f;
    }

    public float getMaxWidth() {
        return this.mMaxWidth;
    }

    public void setMaxWidth(float f) {
        this.mMaxWidth = f;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.mPosition;
    }

    public void setPosition(YAxisLabelPosition yAxisLabelPosition) {
        this.mPosition = yAxisLabelPosition;
    }

    public float getLabelXOffset() {
        return this.mXLabelOffset;
    }

    public void setLabelXOffset(float f) {
        this.mXLabelOffset = f;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.mDrawTopYLabelEntry;
    }

    public void setDrawTopYLabelEntry(boolean z) {
        this.mDrawTopYLabelEntry = z;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    @Deprecated
    public void setStartAtZero(boolean z) {
        if (z) {
            setAxisMinimum(0.0f);
        } else {
            resetAxisMinimum();
        }
    }

    public void setSpaceTop(float f) {
        this.mSpacePercentTop = f;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public void setSpaceBottom(float f) {
        this.mSpacePercentBottom = f;
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public boolean isDrawZeroLineEnabled() {
        return this.mDrawZeroLine;
    }

    public void setDrawZeroLine(boolean z) {
        this.mDrawZeroLine = z;
    }

    public int getZeroLineColor() {
        return this.mZeroLineColor;
    }

    public void setZeroLineColor(int i) {
        this.mZeroLineColor = i;
    }

    public float getZeroLineWidth() {
        return this.mZeroLineWidth;
    }

    public void setZeroLineWidth(float f) {
        this.mZeroLineWidth = Utils.convertDpToPixel(f);
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        float calcTextWidth = ((float) Utils.calcTextWidth(paint, getLongestLabel())) + (getXOffset() * 2.0f);
        float minWidth = getMinWidth();
        float maxWidth = getMaxWidth();
        if (minWidth > 0.0f) {
            minWidth = Utils.convertDpToPixel(minWidth);
        }
        if (maxWidth > 0.0f && maxWidth != Float.POSITIVE_INFINITY) {
            maxWidth = Utils.convertDpToPixel(maxWidth);
        }
        if (((double) maxWidth) <= Utils.DOUBLE_EPSILON) {
            maxWidth = calcTextWidth;
        }
        return Math.max(minWidth, Math.min(calcTextWidth, maxWidth));
    }

    public float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return ((float) Utils.calcTextHeight(paint, getLongestLabel())) + (getYOffset() * 2.0f);
    }

    public boolean needsOffset() {
        return isEnabled() && isDrawLabelsEnabled() && getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    @Deprecated
    public boolean isUseAutoScaleMinRestriction() {
        return this.mUseAutoScaleRestrictionMin;
    }

    @Deprecated
    public void setUseAutoScaleMinRestriction(boolean z) {
        this.mUseAutoScaleRestrictionMin = z;
    }

    @Deprecated
    public boolean isUseAutoScaleMaxRestriction() {
        return this.mUseAutoScaleRestrictionMax;
    }

    @Deprecated
    public void setUseAutoScaleMaxRestriction(boolean z) {
        this.mUseAutoScaleRestrictionMax = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void calculate(float r6, float r7) {
        /*
            r5 = this;
            int r0 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            r1 = 0
            if (r0 <= 0) goto L_0x002f
            boolean r0 = r5.mCustomAxisMax
            if (r0 == 0) goto L_0x000e
            boolean r0 = r5.mCustomAxisMin
            if (r0 == 0) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            boolean r0 = r5.mCustomAxisMax
            r2 = 1069547520(0x3fc00000, float:1.5)
            r3 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x0020
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x001d
            float r2 = r2 * r7
            r6 = r2
            goto L_0x002f
        L_0x001d:
            float r3 = r3 * r7
            r6 = r3
            goto L_0x002f
        L_0x0020:
            boolean r0 = r5.mCustomAxisMin
            if (r0 == 0) goto L_0x002f
            int r7 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x002a
            float r3 = r3 * r6
            goto L_0x002c
        L_0x002a:
            float r3 = r6 * r2
        L_0x002c:
            r7 = r6
            r6 = r3
            goto L_0x0032
        L_0x002f:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0032:
            float r0 = r6 - r7
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0040
            r0 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 + r0
            float r7 = r7 - r0
        L_0x0040:
            float r0 = r6 - r7
            float r0 = java.lang.Math.abs(r0)
            boolean r1 = r5.mCustomAxisMin
            r2 = 1120403456(0x42c80000, float:100.0)
            if (r1 == 0) goto L_0x004f
            float r7 = r5.mAxisMinimum
            goto L_0x0057
        L_0x004f:
            float r1 = r0 / r2
            float r3 = r5.getSpaceBottom()
            float r1 = r1 * r3
            float r7 = r7 - r1
        L_0x0057:
            r5.mAxisMinimum = r7
            boolean r7 = r5.mCustomAxisMax
            if (r7 == 0) goto L_0x0060
            float r6 = r5.mAxisMaximum
            goto L_0x0067
        L_0x0060:
            float r0 = r0 / r2
            float r7 = r5.getSpaceTop()
            float r0 = r0 * r7
            float r6 = r6 + r0
        L_0x0067:
            r5.mAxisMaximum = r6
            float r6 = r5.mAxisMinimum
            float r7 = r5.mAxisMaximum
            float r6 = r6 - r7
            float r6 = java.lang.Math.abs(r6)
            r5.mAxisRange = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.YAxis.calculate(float, float):void");
    }
}

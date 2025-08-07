package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class AxisRenderer extends Renderer {
    protected AxisBase mAxis;
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setAlpha(90);
            Paint paint2 = new Paint();
            this.mAxisLinePaint = paint2;
            paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public void computeAxis(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.mViewPortHandler != null && this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!z) {
                f3 = (float) valuesByTouchPoint2.y;
                d = valuesByTouchPoint.y;
            } else {
                f3 = (float) valuesByTouchPoint.y;
                d = valuesByTouchPoint2.y;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f = f3;
            f2 = (float) d;
        }
        computeAxisValues(f, f2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeAxisValues(float r16, float r17) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            com.github.mikephil.charting.components.AxisBase r3 = r0.mAxis
            int r3 = r3.getLabelCount()
            float r4 = r2 - r1
            float r4 = java.lang.Math.abs(r4)
            double r4 = (double) r4
            if (r3 == 0) goto L_0x014d
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x014d
            boolean r9 = java.lang.Double.isInfinite(r4)
            if (r9 == 0) goto L_0x0022
            goto L_0x014d
        L_0x0022:
            double r9 = (double) r3
            double r9 = r4 / r9
            float r9 = com.github.mikephil.charting.utils.Utils.roundToNextSignificant(r9)
            double r9 = (double) r9
            com.github.mikephil.charting.components.AxisBase r11 = r0.mAxis
            boolean r11 = r11.isGranularityEnabled()
            if (r11 == 0) goto L_0x0044
            com.github.mikephil.charting.components.AxisBase r11 = r0.mAxis
            float r11 = r11.getGranularity()
            double r11 = (double) r11
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0044
            com.github.mikephil.charting.components.AxisBase r9 = r0.mAxis
            float r9 = r9.getGranularity()
            double r9 = (double) r9
        L_0x0044:
            double r11 = java.lang.Math.log10(r9)
            int r11 = (int) r11
            double r11 = (double) r11
            r13 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r11 = java.lang.Math.pow(r13, r11)
            float r11 = com.github.mikephil.charting.utils.Utils.roundToNextSignificant(r11)
            double r11 = (double) r11
            double r6 = r9 / r11
            int r6 = (int) r6
            r7 = 5
            if (r6 <= r7) goto L_0x006b
            double r11 = r11 * r13
            double r6 = java.lang.Math.floor(r11)
            r13 = 0
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            double r9 = java.lang.Math.floor(r11)
        L_0x006b:
            com.github.mikephil.charting.components.AxisBase r6 = r0.mAxis
            boolean r6 = r6.isCenterAxisLabelsEnabled()
            com.github.mikephil.charting.components.AxisBase r7 = r0.mAxis
            boolean r7 = r7.isForceLabelsEnabled()
            if (r7 == 0) goto L_0x009f
            float r2 = (float) r4
            int r4 = r3 + -1
            float r4 = (float) r4
            float r2 = r2 / r4
            double r9 = (double) r2
            com.github.mikephil.charting.components.AxisBase r2 = r0.mAxis
            r2.mEntryCount = r3
            com.github.mikephil.charting.components.AxisBase r2 = r0.mAxis
            float[] r2 = r2.mEntries
            int r2 = r2.length
            if (r2 >= r3) goto L_0x0090
            com.github.mikephil.charting.components.AxisBase r2 = r0.mAxis
            float[] r4 = new float[r3]
            r2.mEntries = r4
        L_0x0090:
            r2 = 0
        L_0x0091:
            if (r2 >= r3) goto L_0x0106
            com.github.mikephil.charting.components.AxisBase r4 = r0.mAxis
            float[] r4 = r4.mEntries
            r4[r2] = r1
            double r4 = (double) r1
            double r4 = r4 + r9
            float r1 = (float) r4
            int r2 = r2 + 1
            goto L_0x0091
        L_0x009f:
            r3 = 0
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00a8
            r13 = 0
            goto L_0x00b0
        L_0x00a8:
            double r3 = (double) r1
            double r3 = r3 / r9
            double r3 = java.lang.Math.ceil(r3)
            double r13 = r3 * r9
        L_0x00b0:
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            boolean r1 = r1.isCenterAxisLabelsEnabled()
            if (r1 == 0) goto L_0x00b9
            double r13 = r13 - r9
        L_0x00b9:
            if (r5 != 0) goto L_0x00be
            r1 = 0
            goto L_0x00c9
        L_0x00be:
            double r1 = (double) r2
            double r1 = r1 / r9
            double r1 = java.lang.Math.floor(r1)
            double r1 = r1 * r9
            double r1 = com.github.mikephil.charting.utils.Utils.nextUp(r1)
        L_0x00c9:
            if (r5 == 0) goto L_0x00d7
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x00d7
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            int r1 = r1.getLabelCount()
        L_0x00d5:
            r3 = r1
            goto L_0x00e0
        L_0x00d7:
            int r1 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r1 != 0) goto L_0x00df
            if (r6 != 0) goto L_0x00df
            r1 = 1
            goto L_0x00d5
        L_0x00df:
            r3 = r6
        L_0x00e0:
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            r1.mEntryCount = r3
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            float[] r1 = r1.mEntries
            int r1 = r1.length
            if (r1 >= r3) goto L_0x00f1
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            float[] r2 = new float[r3]
            r1.mEntries = r2
        L_0x00f1:
            r1 = 0
        L_0x00f2:
            if (r1 >= r3) goto L_0x0106
            r4 = 0
            int r2 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x00fb
            r13 = r4
        L_0x00fb:
            com.github.mikephil.charting.components.AxisBase r2 = r0.mAxis
            float[] r2 = r2.mEntries
            float r6 = (float) r13
            r2[r1] = r6
            double r13 = r13 + r9
            int r1 = r1 + 1
            goto L_0x00f2
        L_0x0106:
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x011b
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            double r4 = java.lang.Math.log10(r9)
            double r4 = -r4
            double r4 = java.lang.Math.ceil(r4)
            int r2 = (int) r4
            r1.mDecimals = r2
            goto L_0x0120
        L_0x011b:
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            r2 = 0
            r1.mDecimals = r2
        L_0x0120:
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            boolean r1 = r1.isCenterAxisLabelsEnabled()
            if (r1 == 0) goto L_0x014c
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            float[] r1 = r1.mCenteredEntries
            int r1 = r1.length
            if (r1 >= r3) goto L_0x0135
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            float[] r2 = new float[r3]
            r1.mCenteredEntries = r2
        L_0x0135:
            float r1 = (float) r9
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            r6 = 0
        L_0x013a:
            if (r6 >= r3) goto L_0x014c
            com.github.mikephil.charting.components.AxisBase r2 = r0.mAxis
            float[] r2 = r2.mCenteredEntries
            com.github.mikephil.charting.components.AxisBase r4 = r0.mAxis
            float[] r4 = r4.mEntries
            r4 = r4[r6]
            float r4 = r4 + r1
            r2[r6] = r4
            int r6 = r6 + 1
            goto L_0x013a
        L_0x014c:
            return
        L_0x014d:
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            r2 = 0
            float[] r3 = new float[r2]
            r1.mEntries = r3
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            float[] r3 = new float[r2]
            r1.mCenteredEntries = r3
            com.github.mikephil.charting.components.AxisBase r1 = r0.mAxis
            r1.mEntryCount = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.AxisRenderer.computeAxisValues(float, float):void");
    }
}

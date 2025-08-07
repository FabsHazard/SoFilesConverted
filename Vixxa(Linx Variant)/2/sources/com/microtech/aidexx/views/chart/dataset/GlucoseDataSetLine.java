package com.microtech.aidexx.views.chart.dataset;

import android.graphics.Color;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineDataSet;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.chart.ChartUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/GlucoseDataSetLine;", "Lcom/github/mikephil/charting/data/LineDataSet;", "()V", "breakInterval", "", "getBreakInterval", "()F", "setBreakInterval", "(F)V", "needCheckBreak", "", "getNeedCheckBreak", "()Z", "setNeedCheckBreak", "(Z)V", "checkBreak", "cur", "Lcom/github/mikephil/charting/data/Entry;", "next", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseDataSetLine.kt */
public class GlucoseDataSetLine extends LineDataSet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private float breakInterval;
    private boolean needCheckBreak = true;

    public GlucoseDataSetLine() {
        super(new CopyOnWriteArrayList(), "glucose");
        long j = (long) 1000;
        this.breakInterval = ChartUtil.INSTANCE.secondToX((System.currentTimeMillis() / j) + ((long) 100)) - ChartUtil.INSTANCE.secondToX(System.currentTimeMillis() / j);
        setAxisDependency(YAxis.AxisDependency.RIGHT);
        setLineWidth(2.0f);
        setMode(LineDataSet.Mode.CUBIC_BEZIER);
        int color = AidexxApp.Companion.getInstance().getResources().getColor(R.color.green);
        int color2 = AidexxApp.Companion.getInstance().getResources().getColor(R.color.yellow);
        int color3 = AidexxApp.Companion.getInstance().getResources().getColor(R.color.red);
        setColors((List<Integer>) CollectionsKt.mutableListOf(Integer.valueOf(color2), Integer.valueOf(color), Integer.valueOf(color), Integer.valueOf(color3)));
        Color.argb(150, 255, 255, 255);
        setDrawFilled(false);
        setFillAlpha(255);
        Companion companion = Companion;
        setFillColors((List<Integer>) CollectionsKt.listOf(Integer.valueOf(companion.alpha(color2, 100)), Integer.valueOf(companion.alpha(color2, 25)), 0, 0, Integer.valueOf(companion.alpha(color3, 25)), Integer.valueOf(companion.alpha(color3, 100))));
        setDrawCircles(false);
        setDrawCircleHole(false);
        setCircleRadius(1.0f);
        setCircleColors((List<Integer>) CollectionsKt.listOf(Integer.valueOf(color2), Integer.valueOf(color), Integer.valueOf(color3), Integer.valueOf(color3)));
        setDrawValues(false);
        setHighLightColor(-7829368);
        setDrawHorizontalHighlightIndicator(false);
    }

    public final float getBreakInterval() {
        return this.breakInterval;
    }

    public final void setBreakInterval(float f) {
        this.breakInterval = f;
    }

    public final boolean getNeedCheckBreak() {
        return this.needCheckBreak;
    }

    public final void setNeedCheckBreak(boolean z) {
        this.needCheckBreak = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkBreak(com.github.mikephil.charting.data.Entry r4, com.github.mikephil.charting.data.Entry r5) {
        /*
            r3 = this;
            boolean r0 = r3.needCheckBreak
            if (r0 == 0) goto L_0x0062
            if (r4 == 0) goto L_0x0062
            if (r5 == 0) goto L_0x0062
            java.lang.Object r0 = r4.getData()
            boolean r0 = r0 instanceof kotlin.Pair
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r5.getData()
            boolean r0 = r0 instanceof kotlin.Pair
            if (r0 == 0) goto L_0x004d
            java.lang.Object r5 = r5.getData()
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Pair<kotlin.Long, kotlin.Float>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r0)
            kotlin.Pair r5 = (kotlin.Pair) r5
            java.lang.Object r5 = r5.getFirst()
            java.lang.Number r5 = (java.lang.Number) r5
            long r1 = r5.longValue()
            java.lang.Object r4 = r4.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r0)
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r4 = r4.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            long r1 = r1 - r4
            long r4 = java.lang.Math.abs(r1)
            r0 = 100000(0x186a0, double:4.94066E-319)
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0062
            goto L_0x0060
        L_0x004d:
            float r5 = r5.getX()
            float r4 = r4.getX()
            float r5 = r5 - r4
            float r4 = java.lang.Math.abs(r5)
            float r5 = r3.breakInterval
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0062
        L_0x0060:
            r4 = 1
            goto L_0x0063
        L_0x0062:
            r4 = 0
        L_0x0063:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine.checkBreak(com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.Entry):boolean");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/GlucoseDataSetLine$Companion;", "", "()V", "alpha", "", "color", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucoseDataSetLine.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int alpha(int i, int i2) {
            return i & Color.argb(i2, 255, 255, 255);
        }
    }
}

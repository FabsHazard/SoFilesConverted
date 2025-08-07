package com.microtech.aidexx.views.chart.dataset;

import android.graphics.Color;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineDataSet;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/GlucoseDataSet;", "Lcom/github/mikephil/charting/data/LineDataSet;", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseDataSet.kt */
public class GlucoseDataSet extends LineDataSet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public GlucoseDataSet() {
        super(new CopyOnWriteArrayList(), "glucose");
        setAxisDependency(YAxis.AxisDependency.RIGHT);
        setLineWidth(2.0f);
        setMode(LineDataSet.Mode.CUBIC_BEZIER);
        setColors((List<Integer>) CollectionsKt.listOf(0, 0, 0, 0));
        int color = AidexxApp.Companion.getInstance().getResources().getColor(R.color.green);
        int color2 = AidexxApp.Companion.getInstance().getResources().getColor(R.color.yellow);
        int color3 = AidexxApp.Companion.getInstance().getResources().getColor(R.color.red);
        Color.argb(150, 255, 255, 255);
        setDrawFilled(false);
        setFillAlpha(255);
        Companion companion = Companion;
        setFillColors((List<Integer>) CollectionsKt.listOf(Integer.valueOf(companion.alpha(color2, 100)), Integer.valueOf(companion.alpha(color2, 25)), 0, 0, Integer.valueOf(companion.alpha(color3, 25)), Integer.valueOf(companion.alpha(color3, 100))));
        setDrawCircles(true);
        setDrawCircleHole(false);
        setCircleRadius(2.0f);
        setCircleColors((List<Integer>) CollectionsKt.listOf(Integer.valueOf(color2), Integer.valueOf(color), Integer.valueOf(color3), Integer.valueOf(color3)));
        setDrawValues(false);
        setHighLightColor(-7829368);
        setDrawHorizontalHighlightIndicator(false);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/GlucoseDataSet$Companion;", "", "()V", "alpha", "", "color", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucoseDataSet.kt */
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

package com.microtech.aidexx.views.chart.dataset;

import android.graphics.drawable.BitmapDrawable;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.BitmapUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/TimezoneDataSet;", "Lcom/github/mikephil/charting/data/ScatterDataSet;", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimezoneDataSet.kt */
public final class TimezoneDataSet extends ScatterDataSet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public TimezoneDataSet() {
        super(new CopyOnWriteArrayList(), "icon");
        setAxisDependency(YAxis.AxisDependency.RIGHT);
        setAttachedToLineDataSet(false);
        setColor(0);
        setValueTextSize(10.0f);
        setHighLightColor(-7829368);
        setDrawHorizontalHighlightIndicator(false);
        setDrawValues(false);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/TimezoneDataSet$Companion;", "", "()V", "getTimezoneIcon", "Landroid/graphics/drawable/BitmapDrawable;", "timezone", "", "isTextTop", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TimezoneDataSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BitmapDrawable getTimezoneIcon(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "timezone");
            return BitmapUtils.INSTANCE.combineVectorAndTextToDrawable(R.drawable.ic_clock, str, z);
        }
    }
}

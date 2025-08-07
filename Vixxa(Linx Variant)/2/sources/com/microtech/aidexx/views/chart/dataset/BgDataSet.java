package com.microtech.aidexx.views.chart.dataset;

import android.graphics.drawable.BitmapDrawable;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.BitmapUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/BgDataSet;", "Lcom/github/mikephil/charting/data/ScatterDataSet;", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgDataSet.kt */
public final class BgDataSet extends ScatterDataSet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float ICON_SIZE = 40.0f;
    /* access modifiers changed from: private */
    public static final BitmapDrawable icon = BitmapUtils.INSTANCE.getBitmapFromResource(R.drawable.ic_bg_cal, 40.0f, 40.0f);

    public BgDataSet() {
        super(new CopyOnWriteArrayList(), "bg");
        setAxisDependency(YAxis.AxisDependency.RIGHT);
        setAttachedToLineDataSet(false);
        setColor(0);
        setValueTextSize(10.0f);
        setHighLightColor(-7829368);
        setDrawHorizontalHighlightIndicator(false);
        setDrawValues(false);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/BgDataSet$Companion;", "", "()V", "ICON_SIZE", "", "icon", "Landroid/graphics/drawable/BitmapDrawable;", "getIcon", "()Landroid/graphics/drawable/BitmapDrawable;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BgDataSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BitmapDrawable getIcon() {
            return BgDataSet.icon;
        }
    }
}

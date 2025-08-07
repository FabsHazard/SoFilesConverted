package com.microtech.aidexx.views.chart.dataset;

import android.graphics.drawable.BitmapDrawable;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.BitmapUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/IconDataSet;", "Lcom/github/mikephil/charting/data/ScatterDataSet;", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: IconDataSet.kt */
public final class IconDataSet extends ScatterDataSet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final BitmapDrawable dietIcon = BitmapUtils.INSTANCE.getBitmapFromResource(R.drawable.ic_have_food, 40.0f, 40.0f);
    /* access modifiers changed from: private */
    public static final BitmapDrawable exerciseIcon = BitmapUtils.INSTANCE.getBitmapFromResource(R.drawable.ic_excise, 40.0f, 40.0f);
    /* access modifiers changed from: private */
    public static final BitmapDrawable insulinIcon = BitmapUtils.INSTANCE.getBitmapFromResource(R.drawable.ic_yds, 40.0f, 40.0f);
    /* access modifiers changed from: private */
    public static final BitmapDrawable medicineIcon = BitmapUtils.INSTANCE.getBitmapFromResource(R.drawable.ic_use_medical, 40.0f, 40.0f);
    /* access modifiers changed from: private */
    public static final BitmapDrawable otherMarkIcon = BitmapUtils.INSTANCE.getBitmapFromResource(R.drawable.ic_other_mark, 40.0f, 40.0f);
    private static final float size = 40.0f;

    public IconDataSet() {
        super(new CopyOnWriteArrayList(), "icon");
        setAxisDependency(YAxis.AxisDependency.RIGHT);
        setAttachedToLineDataSet(true);
        setColor(0);
        setValueTextSize(10.0f);
        setHighLightColor(-7829368);
        setDrawHorizontalHighlightIndicator(false);
        setIconsOffset(new MPPointF(0.0f, -10.0f));
        setDrawValues(false);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/IconDataSet$Companion;", "", "()V", "dietIcon", "Landroid/graphics/drawable/BitmapDrawable;", "getDietIcon", "()Landroid/graphics/drawable/BitmapDrawable;", "exerciseIcon", "getExerciseIcon", "insulinIcon", "getInsulinIcon", "medicineIcon", "getMedicineIcon", "otherMarkIcon", "getOtherMarkIcon", "size", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: IconDataSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BitmapDrawable getInsulinIcon() {
            return IconDataSet.insulinIcon;
        }

        public final BitmapDrawable getDietIcon() {
            return IconDataSet.dietIcon;
        }

        public final BitmapDrawable getMedicineIcon() {
            return IconDataSet.medicineIcon;
        }

        public final BitmapDrawable getExerciseIcon() {
            return IconDataSet.exerciseIcon;
        }

        public final BitmapDrawable getOtherMarkIcon() {
            return IconDataSet.otherMarkIcon;
        }
    }
}

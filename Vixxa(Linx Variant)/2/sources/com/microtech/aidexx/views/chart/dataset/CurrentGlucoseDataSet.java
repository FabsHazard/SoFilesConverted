package com.microtech.aidexx.views.chart.dataset;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/CurrentGlucoseDataSet;", "Lcom/microtech/aidexx/views/chart/dataset/GlucoseDataSet;", "()V", "getCircleHoleColor", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CurrentGlucoseDataSet.kt */
public final class CurrentGlucoseDataSet extends GlucoseDataSet {
    public CurrentGlucoseDataSet() {
        setLineWidth(0.0f);
        setDrawCircleHole(true);
        setCircleRadius(4.0f);
        setCircleHoleRadius(1.5f);
        setDrawFilled(false);
        setDrawValues(false);
        setHighlightEnabled(false);
    }

    public int getCircleHoleColor() {
        return ExtendsKt.getContext().getColor(ThemeManager.INSTANCE.isLight() ? R.color.light_bg_history : R.color.bg_event_color);
    }
}

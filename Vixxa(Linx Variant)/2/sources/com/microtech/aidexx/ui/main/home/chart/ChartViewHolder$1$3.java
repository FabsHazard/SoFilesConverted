package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.views.chart.MyAnimatedZoomJob;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewHolder.kt */
final class ChartViewHolder$1$3 extends Lambda implements Function0<Boolean> {
    public static final ChartViewHolder$1$3 INSTANCE = new ChartViewHolder$1$3();

    ChartViewHolder$1$3() {
        super(0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(MyAnimatedZoomJob.Companion.getAnimators() <= 0);
    }
}

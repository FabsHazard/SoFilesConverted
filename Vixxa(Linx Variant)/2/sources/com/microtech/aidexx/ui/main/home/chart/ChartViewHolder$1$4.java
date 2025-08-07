package com.microtech.aidexx.ui.main.home.chart;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewHolder.kt */
final class ChartViewHolder$1$4 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ChartViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewHolder$1$4(ChartViewHolder chartViewHolder) {
        super(1);
        this.this$0 = chartViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        int i2 = 2;
        if (i != 1) {
            i2 = i != 2 ? 1 : 4;
        }
        this.this$0.getChartViewModel().updateGranularity(i2);
    }
}

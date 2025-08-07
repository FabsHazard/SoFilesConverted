package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewHolder.kt */
final class ChartViewHolder$1$5$onGoToHistory$1 extends Lambda implements Function1<BaseEventEntity, Unit> {
    final /* synthetic */ ChartViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewHolder$1$5$onGoToHistory$1(ChartViewHolder chartViewHolder) {
        super(1);
        this.this$0 = chartViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseEventEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BaseEventEntity baseEventEntity) {
        Intrinsics.checkNotNullParameter(baseEventEntity, "it");
        this.this$0.toHistory.invoke(baseEventEntity);
    }
}

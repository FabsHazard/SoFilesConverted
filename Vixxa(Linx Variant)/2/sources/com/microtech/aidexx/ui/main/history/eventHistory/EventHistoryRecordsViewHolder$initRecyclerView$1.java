package com.microtech.aidexx.ui.main.history.eventHistory;

import com.microtech.aidexx.ui.main.history.HistoryDetailModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryRecordsViewHolder.kt */
/* synthetic */ class EventHistoryRecordsViewHolder$initRecyclerView$1 extends FunctionReferenceImpl implements Function1<HistoryDetailModel, Unit> {
    EventHistoryRecordsViewHolder$initRecyclerView$1(Object obj) {
        super(1, obj, EventHistoryRecordsViewHolder.class, "onDeleteClick", "onDeleteClick(Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HistoryDetailModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HistoryDetailModel historyDetailModel) {
        Intrinsics.checkNotNullParameter(historyDetailModel, "p0");
        ((EventHistoryRecordsViewHolder) this.receiver).onDeleteClick(historyDetailModel);
    }
}

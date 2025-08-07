package com.microtech.aidexx.ui.main.history;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.HistoryViewModel", f = "HistoryViewModel.kt", i = {0, 0}, l = {541, 552}, m = "onDelete", n = {"this", "event"}, s = {"L$0", "L$1"})
/* compiled from: HistoryViewModel.kt */
final class HistoryViewModel$onDelete$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HistoryViewModel$onDelete$1(HistoryViewModel historyViewModel, Continuation<? super HistoryViewModel$onDelete$1> continuation) {
        super(continuation);
        this.this$0 = historyViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onDelete((BaseEventEntity) null, this);
    }
}

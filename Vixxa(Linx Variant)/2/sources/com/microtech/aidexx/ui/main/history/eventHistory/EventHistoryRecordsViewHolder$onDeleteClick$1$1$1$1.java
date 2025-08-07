package com.microtech.aidexx.ui.main.history.eventHistory;

import com.microtech.aidexx.ui.main.history.HistoryDetailModel;
import com.microtech.aidexx.ui.main.history.HistoryRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1", f = "HistoryRecordsViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HistoryRecordsViewHolder.kt */
final class EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoryDetailModel $model;
    int label;
    final /* synthetic */ EventHistoryRecordsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1(EventHistoryRecordsViewHolder eventHistoryRecordsViewHolder, HistoryDetailModel historyDetailModel, Continuation<? super EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = eventHistoryRecordsViewHolder;
        this.$model = historyDetailModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1(this.this$0, this.$model, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int indexOf = this.this$0.dataList.indexOf(this.$model);
            this.this$0.dataList.remove(indexOf);
            HistoryRecyclerViewAdapter access$getAdapter$p = this.this$0.adapter;
            if (access$getAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                access$getAdapter$p = null;
            }
            access$getAdapter$p.notifyItemRemoved(indexOf);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

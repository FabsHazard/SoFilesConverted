package com.microtech.aidexx.ui.main.history.eventHistory;

import com.microtech.aidexx.ui.main.history.HistoryDetailModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$onDeleteClick$1", f = "HistoryRecordsViewHolder.kt", i = {0, 1, 1, 2, 2}, l = {65, 66, 71}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "removed", "$this$launch", "removed"}, s = {"L$0", "L$0", "L$3", "L$0", "L$2"})
/* compiled from: HistoryRecordsViewHolder.kt */
final class EventHistoryRecordsViewHolder$onDeleteClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoryDetailModel $model;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ EventHistoryRecordsViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHistoryRecordsViewHolder$onDeleteClick$1(HistoryDetailModel historyDetailModel, EventHistoryRecordsViewHolder eventHistoryRecordsViewHolder, Continuation<? super EventHistoryRecordsViewHolder$onDeleteClick$1> continuation) {
        super(2, continuation);
        this.$model = historyDetailModel;
        this.this$0 = eventHistoryRecordsViewHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventHistoryRecordsViewHolder$onDeleteClick$1 eventHistoryRecordsViewHolder$onDeleteClick$1 = new EventHistoryRecordsViewHolder$onDeleteClick$1(this.$model, this.this$0, continuation);
        eventHistoryRecordsViewHolder$onDeleteClick$1.L$0 = obj;
        return eventHistoryRecordsViewHolder$onDeleteClick$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryRecordsViewHolder$onDeleteClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 1
            r4 = 2
            r5 = 0
            if (r1 == 0) goto L_0x0054
            if (r1 == r3) goto L_0x0041
            if (r1 == r4) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r0 = r11.L$2
            com.microtech.aidexx.db.entity.BaseEventEntity r0 = (com.microtech.aidexx.db.entity.BaseEventEntity) r0
            java.lang.Object r1 = r11.L$1
            com.microtech.aidexx.ui.main.history.HistoryDetailModel r1 = (com.microtech.aidexx.ui.main.history.HistoryDetailModel) r1
            java.lang.Object r2 = r11.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00bd
        L_0x0023:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x002b:
            java.lang.Object r1 = r11.L$3
            com.microtech.aidexx.db.entity.BaseEventEntity r1 = (com.microtech.aidexx.db.entity.BaseEventEntity) r1
            java.lang.Object r3 = r11.L$2
            com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder r3 = (com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder) r3
            java.lang.Object r6 = r11.L$1
            com.microtech.aidexx.ui.main.history.HistoryDetailModel r6 = (com.microtech.aidexx.ui.main.history.HistoryDetailModel) r6
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r1
        L_0x003f:
            r1 = r6
            goto L_0x00a7
        L_0x0041:
            java.lang.Object r1 = r11.L$2
            com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder r1 = (com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder) r1
            java.lang.Object r3 = r11.L$1
            com.microtech.aidexx.ui.main.history.HistoryDetailModel r3 = (com.microtech.aidexx.ui.main.history.HistoryDetailModel) r3
            java.lang.Object r6 = r11.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r7 = r6
            r6 = r3
            r3 = r1
            goto L_0x0085
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            com.microtech.aidexx.ui.main.history.HistoryDetailModel r1 = r11.$model
            java.lang.Long r1 = r1.getIdForRealEntity()
            if (r1 == 0) goto L_0x00ed
            com.microtech.aidexx.ui.main.history.HistoryDetailModel r6 = r11.$model
            com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder r7 = r11.this$0
            java.lang.Number r1 = (java.lang.Number) r1
            long r8 = r1.longValue()
            com.microtech.aidexx.db.repository.EventDbRepository r1 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            java.lang.Class r10 = r6.getClazz()
            r11.L$0 = r12
            r11.L$1 = r6
            r11.L$2 = r7
            r11.label = r3
            java.lang.Object r1 = r1.removeEventById(r8, r10, r11)
            if (r1 != r0) goto L_0x0082
            return r0
        L_0x0082:
            r3 = r7
            r7 = r12
            r12 = r1
        L_0x0085:
            com.microtech.aidexx.db.entity.BaseEventEntity r12 = (com.microtech.aidexx.db.entity.BaseEventEntity) r12
            if (r12 == 0) goto L_0x00d3
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1 r8 = new com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$onDeleteClick$1$1$1$1
            r8.<init>(r3, r6, r5)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r11.L$0 = r7
            r11.L$1 = r6
            r11.L$2 = r3
            r11.L$3 = r12
            r11.label = r4
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r8, r11)
            if (r1 != r0) goto L_0x003f
            return r0
        L_0x00a7:
            com.microtech.aidexx.ui.main.history.HistoryViewModel r3 = r3.getVm()
            r11.L$0 = r7
            r11.L$1 = r1
            r11.L$2 = r12
            r11.L$3 = r5
            r11.label = r2
            java.lang.Object r2 = r3.onDelete(r12, r11)
            if (r2 != r0) goto L_0x00bc
            return r0
        L_0x00bc:
            r0 = r12
        L_0x00bd:
            com.microtech.aidexx.utils.eventbus.EventBusManager r12 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
            kotlin.Pair r2 = new kotlin.Pair
            com.microtech.aidexx.utils.eventbus.DataChangedType r3 = com.microtech.aidexx.utils.eventbus.DataChangedType.DELETE
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            r2.<init>(r3, r0)
            java.lang.String r0 = "EVENT_DATA_CHANGED"
            r12.send(r0, r2)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            r6 = r1
            goto L_0x00d4
        L_0x00d3:
            r12 = r5
        L_0x00d4:
            if (r12 != 0) goto L_0x00ea
            com.microtech.aidexx.utils.LogUtil$Companion r12 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "删除失败 "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.d$default(r12, r0, r5, r4, r5)
        L_0x00ea:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            goto L_0x00ee
        L_0x00ed:
            r12 = r5
        L_0x00ee:
            if (r12 != 0) goto L_0x0106
            com.microtech.aidexx.ui.main.history.HistoryDetailModel r12 = r11.$model
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "删除失败  "
            r1.<init>(r2)
            java.lang.StringBuilder r12 = r1.append(r12)
            java.lang.String r12 = r12.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.d$default(r0, r12, r5, r4, r5)
        L_0x0106:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$onDeleteClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\t0\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$save$2", f = "BaseEventViewModel.kt", i = {0, 1, 1}, l = {136, 137, 146}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "eventEntity"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$save$2 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends T>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseEventViewModel<T, D, P> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$save$2(BaseEventViewModel<T, D, P> baseEventViewModel, Continuation<? super BaseEventViewModel$save$2> continuation) {
        super(2, continuation);
        this.this$0 = baseEventViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseEventViewModel$save$2 baseEventViewModel$save$2 = new BaseEventViewModel$save$2(this.this$0, continuation);
        baseEventViewModel$save$2.L$0 = obj;
        return baseEventViewModel$save$2;
    }

    public final Object invoke(FlowCollector<? super Pair<Boolean, ? extends T>> flowCollector, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$save$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a4
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            java.lang.Object r1 = r9.L$1
            com.microtech.aidexx.db.entity.BaseEventEntity r1 = (com.microtech.aidexx.db.entity.BaseEventEntity) r1
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0061
        L_0x002a:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r1
            goto L_0x004c
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r1 = r9.this$0
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.L$0 = r10
            r9.label = r4
            java.lang.Object r1 = r1.genEventEntityWhenSave(r5)
            if (r1 != r0) goto L_0x004a
            return r0
        L_0x004a:
            r5 = r10
            r10 = r1
        L_0x004c:
            r1 = r10
            com.microtech.aidexx.db.entity.BaseEventEntity r1 = (com.microtech.aidexx.db.entity.BaseEventEntity) r1
            com.microtech.aidexx.db.repository.EventDbRepository r10 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r6 = r9
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r9.L$0 = r5
            r9.L$1 = r1
            r9.label = r3
            java.lang.Object r10 = r10.insertEvent(r1, r6)
            if (r10 != r0) goto L_0x0061
            return r0
        L_0x0061:
            if (r10 == 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r4 = 0
        L_0x0065:
            if (r4 == 0) goto L_0x0086
            com.microtech.aidexx.utils.eventbus.EventBusManager r10 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
            kotlin.Pair r6 = new kotlin.Pair
            com.microtech.aidexx.utils.eventbus.DataChangedType r7 = com.microtech.aidexx.utils.eventbus.DataChangedType.ADD
            java.util.List r8 = kotlin.collections.CollectionsKt.listOf(r1)
            r6.<init>(r7, r8)
            java.lang.String r7 = "EVENT_DATA_CHANGED"
            r10.send(r7, r6)
            com.microtech.aidexx.utils.eventbus.EventBusManager r10 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.String r8 = "EVENT_JUMP_TO_TAB"
            r10.sendDelay(r8, r3, r6)
        L_0x0086:
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r10 = r9.this$0
            r10.clearToSaveDetailList()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r1)
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r3 = 0
            r9.L$0 = r3
            r9.L$1 = r3
            r9.label = r2
            java.lang.Object r10 = r5.emit(r10, r1)
            if (r10 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$save$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

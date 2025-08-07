package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u00020\t0\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$loadHistory$2", f = "BaseEventViewModel.kt", i = {0}, l = {108, 115}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$loadHistory$2 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseEventViewModel<T, D, P> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$loadHistory$2(BaseEventViewModel<T, D, P> baseEventViewModel, Continuation<? super BaseEventViewModel$loadHistory$2> continuation) {
        super(2, continuation);
        this.this$0 = baseEventViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseEventViewModel$loadHistory$2 baseEventViewModel$loadHistory$2 = new BaseEventViewModel$loadHistory$2(this.this$0, continuation);
        baseEventViewModel$loadHistory$2.L$0 = obj;
        return baseEventViewModel$loadHistory$2;
    }

    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$loadHistory$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0080
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003a
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r6 = r5.this$0
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r6.getDetailHistory(r4)
            if (r6 != r0) goto L_0x003a
            return r0
        L_0x003a:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r3 = 15
            java.util.List r6 = kotlin.collections.CollectionsKt.take(r6, r3)
            r3 = r6
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$loadHistory$2$invokeSuspend$$inlined$sortedByDescending$1 r4 = new com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$loadHistory$2$invokeSuspend$$inlined$sortedByDescending$1
            r4.<init>()
            java.util.Comparator r4 = (java.util.Comparator) r4
            kotlin.collections.CollectionsKt.sortedWith(r3, r4)
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r3 = r5.this$0
            java.util.List r3 = r3._detailHistory
            r3.clear()
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r3 = r5.this$0
            java.util.List r3 = r3._detailHistory
            java.util.Collection r6 = (java.util.Collection) r6
            r3.addAll(r6)
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r6 = r5.this$0
            java.util.List r6 = r6._detailHistory
            int r6 = r6.size()
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r5.L$0 = r4
            r5.label = r2
            java.lang.Object r6 = r1.emit(r6, r3)
            if (r6 != r0) goto L_0x0080
            return r0
        L_0x0080:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$loadHistory$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\b\u0012\u0004\u0012\u00020\t0\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$searchPresetByName$2", f = "BaseEventViewModel.kt", i = {0, 1}, l = {120, 129, 131}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$searchPresetByName$2 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseEventViewModel<T, D, P> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$searchPresetByName$2(BaseEventViewModel<T, D, P> baseEventViewModel, String str, Continuation<? super BaseEventViewModel$searchPresetByName$2> continuation) {
        super(2, continuation);
        this.this$0 = baseEventViewModel;
        this.$name = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseEventViewModel$searchPresetByName$2 baseEventViewModel$searchPresetByName$2 = new BaseEventViewModel$searchPresetByName$2(this.this$0, this.$name, continuation);
        baseEventViewModel$searchPresetByName$2.L$0 = obj;
        return baseEventViewModel$searchPresetByName$2;
    }

    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$searchPresetByName$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r4) goto L_0x002b
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b8
        L_0x0016:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001e:
            java.lang.Object r1 = r8.L$1
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r3 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0096
        L_0x002b:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004f
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r1 = r8.this$0
            java.lang.String r5 = r8.$name
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r9
            r8.label = r4
            java.lang.Object r1 = r1.queryPresetByName(r5, r6)
            if (r1 != r0) goto L_0x004c
            return r0
        L_0x004c:
            r7 = r1
            r1 = r9
            r9 = r7
        L_0x004f:
            java.util.List r9 = (java.util.List) r9
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r4 = r8.this$0
            java.util.List r4 = r4._presetList
            r4.clear()
            r4 = r9
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0078
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$searchPresetByName$2$invokeSuspend$$inlined$sortedBy$1 r5 = new com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$searchPresetByName$2$invokeSuspend$$inlined$sortedBy$1
            r5.<init>()
            java.util.Comparator r5 = (java.util.Comparator) r5
            kotlin.collections.CollectionsKt.sortedWith(r9, r5)
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r9 = r8.this$0
            java.util.List r9 = r9._presetList
            r9.addAll(r4)
        L_0x0078:
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r9 = r8.this$0
            java.util.List r9 = r9._presetList
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r4 = r8.this$0
            java.lang.String r5 = r8.$name
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r1
            r8.L$1 = r9
            r8.label = r3
            java.lang.Object r3 = r4.genNewPreset(r5, r6)
            if (r3 != r0) goto L_0x0092
            return r0
        L_0x0092:
            r7 = r1
            r1 = r9
            r9 = r3
            r3 = r7
        L_0x0096:
            r1.add(r9)
            com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel<T, D, P> r9 = r8.this$0
            java.util.List r9 = r9._presetList
            int r9 = r9.size()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r1 = r8
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4 = 0
            r8.L$0 = r4
            r8.L$1 = r4
            r8.label = r2
            java.lang.Object r9 = r3.emit(r9, r1)
            if (r9 != r0) goto L_0x00b8
            return r0
        L_0x00b8:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$searchPresetByName$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

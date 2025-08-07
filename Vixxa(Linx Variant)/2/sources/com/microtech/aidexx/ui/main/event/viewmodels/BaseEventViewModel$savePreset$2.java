package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$savePreset$2", f = "BaseEventViewModel.kt", i = {0}, l = {150, 154}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$savePreset$2 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {
    final /* synthetic */ P $entity;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$savePreset$2(P p, Continuation<? super BaseEventViewModel$savePreset$2> continuation) {
        super(2, continuation);
        this.$entity = p;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseEventViewModel$savePreset$2 baseEventViewModel$savePreset$2 = new BaseEventViewModel$savePreset$2(this.$entity, continuation);
        baseEventViewModel$savePreset$2.L$0 = obj;
        return baseEventViewModel$savePreset$2;
    }

    public final Object invoke(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$savePreset$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L_0x0022
            if (r1 == r2) goto L_0x001a
            if (r1 != r3) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x0012:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001a:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x003c
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.db.repository.EventDbRepository r9 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            P r4 = r8.$entity
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = r9.insertPresetData((com.microtech.aidexx.db.entity.event.preset.BasePresetEntity) r4, (kotlin.coroutines.Continuation<? super java.lang.Long>) r5)
            if (r9 != r0) goto L_0x003c
            return r0
        L_0x003c:
            java.lang.Long r9 = (java.lang.Long) r9
            r2 = 0
            if (r9 != 0) goto L_0x0059
            P r4 = r8.$entity
            com.microtech.aidexx.utils.LogUtil$Companion r5 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "预设数据保存失败 "
            r6.<init>(r7)
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.String r4 = r4.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r5, r4, r2, r3, r2)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0059:
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r9 = r1.emit(r9, r4)
            if (r9 != r0) goto L_0x0067
            return r0
        L_0x0067:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$savePreset$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

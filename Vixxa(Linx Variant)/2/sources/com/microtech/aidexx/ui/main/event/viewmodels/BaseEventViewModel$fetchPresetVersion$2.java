package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.common.net.entity.ResEventPresetVersion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/microtech/aidexx/common/net/entity/ResEventPresetVersion;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$fetchPresetVersion$2", f = "BaseEventViewModel.kt", i = {0, 1}, l = {223, 226, 227, 230}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$fetchPresetVersion$2 extends SuspendLambda implements Function2<FlowCollector<? super ResEventPresetVersion>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $type;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$fetchPresetVersion$2(int i, Continuation<? super BaseEventViewModel$fetchPresetVersion$2> continuation) {
        super(2, continuation);
        this.$type = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseEventViewModel$fetchPresetVersion$2 baseEventViewModel$fetchPresetVersion$2 = new BaseEventViewModel$fetchPresetVersion$2(this.$type, continuation);
        baseEventViewModel$fetchPresetVersion$2.L$0 = obj;
        return baseEventViewModel$fetchPresetVersion$2;
    }

    public final Object invoke(FlowCollector<? super ResEventPresetVersion> flowCollector, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$fetchPresetVersion$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0033
            if (r1 == r5) goto L_0x002b
            if (r1 == r4) goto L_0x0023
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            goto L_0x001e
        L_0x0016:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ac
        L_0x0023:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0086
        L_0x002b:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0053
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            com.microtech.aidexx.common.net.repository.EventRepository r1 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            int r7 = r10.$type
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            r8 = r10
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r10.L$0 = r11
            r10.label = r5
            java.lang.Object r1 = r1.fetchPresetVersion(r7, r8)
            if (r1 != r0) goto L_0x0050
            return r0
        L_0x0050:
            r9 = r1
            r1 = r11
            r11 = r9
        L_0x0053:
            com.microtech.aidexx.common.net.ApiResult r11 = (com.microtech.aidexx.common.net.ApiResult) r11
            boolean r5 = r11 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r5 == 0) goto L_0x009a
            com.microtech.aidexx.common.net.ApiResult$Success r11 = (com.microtech.aidexx.common.net.ApiResult.Success) r11
            java.lang.Object r11 = r11.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r11 = (com.microtech.aidexx.common.net.entity.BaseResponse) r11
            java.lang.Object r11 = r11.getData()
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto L_0x0089
            r2 = r11
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x007a
            r2 = 0
            java.lang.Object r11 = r11.get(r2)
            com.microtech.aidexx.common.net.entity.ResEventPresetVersion r11 = (com.microtech.aidexx.common.net.entity.ResEventPresetVersion) r11
            goto L_0x007b
        L_0x007a:
            r11 = r6
        L_0x007b:
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L_0x0086
            return r0
        L_0x0086:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            goto L_0x008a
        L_0x0089:
            r11 = r6
        L_0x008a:
            if (r11 != 0) goto L_0x00ac
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.L$0 = r6
            r10.label = r3
            java.lang.Object r11 = r1.emit(r6, r11)
            if (r11 != r0) goto L_0x00ac
            return r0
        L_0x009a:
            boolean r11 = r11 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r11 == 0) goto L_0x00ac
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.L$0 = r6
            r10.label = r2
            java.lang.Object r11 = r1.emit(r6, r11)
            if (r11 != r0) goto L_0x00ac
            return r0
        L_0x00ac:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$fetchPresetVersion$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package com.microtech.aidexx.ui.pair;

import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.pair.PairUtil$observeMessage$1$onMessage$1", f = "PairUtil.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PairUtil.kt */
final class PairUtil$observeMessage$1$onMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceModel $model;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PairUtil$observeMessage$1$onMessage$1(DeviceModel deviceModel, Continuation<? super PairUtil$observeMessage$1$onMessage$1> continuation) {
        super(2, continuation);
        this.$model = deviceModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PairUtil$observeMessage$1$onMessage$1(this.$model, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PairUtil$observeMessage$1$onMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PairUtil pairUtil = PairUtil.INSTANCE;
            PairUtil.transmitterOperateComplete = true;
            this.label = 1;
            if (DeviceModel.deletePair$default(this.$model, (Function0) null, this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

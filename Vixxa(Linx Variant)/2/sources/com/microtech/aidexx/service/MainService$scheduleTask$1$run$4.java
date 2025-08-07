package com.microtech.aidexx.service;

import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.service.MainService$scheduleTask$1$run$4", f = "MainService.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainService.kt */
final class MainService$scheduleTask$1$run$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceModel $model;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainService$scheduleTask$1$run$4(DeviceModel deviceModel, Continuation<? super MainService$scheduleTask$1$run$4> continuation) {
        super(2, continuation);
        this.$model = deviceModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainService$scheduleTask$1$run$4(this.$model, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainService$scheduleTask$1$run$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$model.uploadPairInfo(this) == coroutine_suspended) {
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

package com.microtech.aidexx.service;

import com.microtech.aidexx.ble.AidexBleAdapter;
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
@DebugMetadata(c = "com.microtech.aidexx.service.MainService$onTransmitterChangeListener$1$1$1", f = "MainService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainService.kt */
final class MainService$onTransmitterChangeListener$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceModel $it;
    int label;
    final /* synthetic */ MainService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainService$onTransmitterChangeListener$1$1$1(DeviceModel deviceModel, MainService mainService, Continuation<? super MainService$onTransmitterChangeListener$1$1$1> continuation) {
        super(2, continuation);
        this.$it = deviceModel;
        this.this$0 = mainService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainService$onTransmitterChangeListener$1$1$1(this.$it, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainService$onTransmitterChangeListener$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$it.isPaired()) {
                this.this$0.observeAlert(this.$it);
                AidexBleAdapter.Companion.getInstance().stopBtScan(true);
                this.this$0.registerReceiver();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

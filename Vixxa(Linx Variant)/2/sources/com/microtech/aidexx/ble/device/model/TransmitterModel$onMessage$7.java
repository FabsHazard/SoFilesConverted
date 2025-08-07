package com.microtech.aidexx.ble.device.model;

import com.microtechmd.blecomm.entity.BleMessage;
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
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$onMessage$7", f = "TransmitterModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$onMessage$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BleMessage $message;
    int label;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$onMessage$7(TransmitterModel transmitterModel, BleMessage bleMessage, Continuation<? super TransmitterModel$onMessage$7> continuation) {
        super(2, continuation);
        this.this$0 = transmitterModel;
        this.$message = bleMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterModel$onMessage$7(this.this$0, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterModel$onMessage$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.saveCalHistory(this.$message.getData(), false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

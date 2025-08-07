package com.microtech.aidexx.ble.device;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.TransmitterManager", f = "TransmitterManager.kt", i = {0}, l = {52, 68}, m = "loadTransmitter", n = {"this"}, s = {"L$0"})
/* compiled from: TransmitterManager.kt */
final class TransmitterManager$loadTransmitter$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransmitterManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterManager$loadTransmitter$1(TransmitterManager transmitterManager, Continuation<? super TransmitterManager$loadTransmitter$1> continuation) {
        super(continuation);
        this.this$0 = transmitterManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadTransmitter((String) null, this);
    }
}

package com.microtech.aidexx.ble.device;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.TransmitterManager", f = "TransmitterManager.kt", i = {}, l = {122}, m = "removeDb", n = {}, s = {})
/* compiled from: TransmitterManager.kt */
final class TransmitterManager$removeDb$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransmitterManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterManager$removeDb$1(TransmitterManager transmitterManager, Continuation<? super TransmitterManager$removeDb$1> continuation) {
        super(continuation);
        this.this$0 = transmitterManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeDb((Function0<Unit>) null, this);
    }
}

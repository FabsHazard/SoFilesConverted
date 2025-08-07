package com.microtech.aidexx.ble.device.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel", f = "TransmitterModel.kt", i = {0, 0}, l = {548, 551, 558, 563}, m = "deletePair", n = {"this", "callback"}, s = {"L$0", "L$1"})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$deletePair$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$deletePair$1(TransmitterModel transmitterModel, Continuation<? super TransmitterModel$deletePair$1> continuation) {
        super(continuation);
        this.this$0 = transmitterModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deletePair((Function0<Unit>) null, this);
    }
}

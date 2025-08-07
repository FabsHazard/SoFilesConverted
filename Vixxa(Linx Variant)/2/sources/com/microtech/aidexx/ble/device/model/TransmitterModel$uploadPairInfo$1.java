package com.microtech.aidexx.ble.device.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel", f = "TransmitterModel.kt", i = {0}, l = {500}, m = "uploadPairInfo", n = {"this"}, s = {"L$0"})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$uploadPairInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$uploadPairInfo$1(TransmitterModel transmitterModel, Continuation<? super TransmitterModel$uploadPairInfo$1> continuation) {
        super(continuation);
        this.this$0 = transmitterModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadPairInfo(this);
    }
}

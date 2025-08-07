package com.microtech.aidexx.service.push;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.service.push.PushMessage", f = "PushMessage.kt", i = {0}, l = {55}, m = "applyMsg$suspendImpl", n = {"$this"}, s = {"L$0"})
/* compiled from: PushMessage.kt */
final class PushMessage$applyMsg$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushMessage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushMessage$applyMsg$1(PushMessage pushMessage, Continuation<? super PushMessage$applyMsg$1> continuation) {
        super(continuation);
        this.this$0 = pushMessage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PushMessage.applyMsg$suspendImpl(this.this$0, this);
    }
}

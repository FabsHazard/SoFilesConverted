package com.microtech.aidexx.ui.pair;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.pair.PairUtil", f = "PairUtil.kt", i = {}, l = {286}, m = "checkSn", n = {}, s = {})
/* compiled from: PairUtil.kt */
final class PairUtil$checkSn$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PairUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PairUtil$checkSn$1(PairUtil pairUtil, Continuation<? super PairUtil$checkSn$1> continuation) {
        super(continuation);
        this.this$0 = pairUtil;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkSn((String) null, this);
    }
}

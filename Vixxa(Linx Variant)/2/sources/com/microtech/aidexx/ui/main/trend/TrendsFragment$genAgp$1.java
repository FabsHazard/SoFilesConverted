package com.microtech.aidexx.ui.main.trend;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment", f = "TrendsFragment.kt", i = {0, 0, 0}, l = {690}, m = "genAgp", n = {"this", "userId", "formBody"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$genAgp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$genAgp$1(TrendsFragment trendsFragment, Continuation<? super TrendsFragment$genAgp$1> continuation) {
        super(continuation);
        this.this$0 = trendsFragment;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.genAgp(this);
    }
}

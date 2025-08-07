package com.microtech.aidexx.ui.main.trend;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment", f = "TrendsFragment.kt", i = {0, 0}, l = {734, 736}, m = "downloadAgp", n = {"this", "reportUrl"}, s = {"L$0", "L$1"})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$downloadAgp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$downloadAgp$1(TrendsFragment trendsFragment, Continuation<? super TrendsFragment$downloadAgp$1> continuation) {
        super(continuation);
        this.this$0 = trendsFragment;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadAgp((String) null, this);
    }
}

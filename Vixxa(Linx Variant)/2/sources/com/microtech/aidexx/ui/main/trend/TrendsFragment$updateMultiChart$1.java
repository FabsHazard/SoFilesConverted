package com.microtech.aidexx.ui.main.trend;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment", f = "TrendsFragment.kt", i = {0}, l = {208}, m = "updateMultiChart", n = {"this"}, s = {"L$0"})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$updateMultiChart$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$updateMultiChart$1(TrendsFragment trendsFragment, Continuation<? super TrendsFragment$updateMultiChart$1> continuation) {
        super(continuation);
        this.this$0 = trendsFragment;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateMultiChart((List<MultiDayBgItem>) null, this);
    }
}

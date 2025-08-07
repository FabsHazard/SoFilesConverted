package com.microtech.aidexx.ui.main.trend;

import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsViewModel", f = "TrendsViewModel.kt", i = {0, 0, 1, 1, 1}, l = {47, 50, 96}, m = "runCgat", n = {"this", "trendsInfo", "this", "trendsInfo", "findDataByDays"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: TrendsViewModel.kt */
final class TrendsViewModel$runCgat$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrendsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsViewModel$runCgat$1(TrendsViewModel trendsViewModel, Continuation<? super TrendsViewModel$runCgat$1> continuation) {
        super(continuation);
        this.this$0 = trendsViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runCgat((Date) null, (Date) null, this);
    }
}

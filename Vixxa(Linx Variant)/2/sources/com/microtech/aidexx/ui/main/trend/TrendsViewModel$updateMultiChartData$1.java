package com.microtech.aidexx.ui.main.trend;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsViewModel", f = "TrendsViewModel.kt", i = {0, 0}, l = {121}, m = "updateMultiChartData", n = {"this", "lineData"}, s = {"L$0", "L$1"})
/* compiled from: TrendsViewModel.kt */
final class TrendsViewModel$updateMultiChartData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrendsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsViewModel$updateMultiChartData$1(TrendsViewModel trendsViewModel, Continuation<? super TrendsViewModel$updateMultiChartData$1> continuation) {
        super(continuation);
        this.this$0 = trendsViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateMultiChartData((List<MultiDayBgItem>) null, this);
    }
}

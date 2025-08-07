package com.microtech.aidexx.ui.main.home.chart;

import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel", f = "ChartViewModel.kt", i = {0, 0, 0, 0}, l = {1515, 1517}, m = "onJumpToDate", n = {"this", "tarDateOfStart", "tmpAreaLabel", "tmpAreaDate"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$onJumpToDate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$onJumpToDate$1(ChartViewModel chartViewModel, Continuation<? super ChartViewModel$onJumpToDate$1> continuation) {
        super(continuation);
        this.this$0 = chartViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onJumpToDate((Date) null, this);
    }
}

package com.microtech.aidexx.ui.main.home.chart;

import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel", f = "ChartViewModel.kt", i = {0}, l = {1593}, m = "getJumpDate", n = {"jumpToDate"}, s = {"L$0"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$getJumpDate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$getJumpDate$1(ChartViewModel chartViewModel, Continuation<? super ChartViewModel$getJumpDate$1> continuation) {
        super(continuation);
        this.this$0 = chartViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getJumpDate((Date) null, this);
    }
}

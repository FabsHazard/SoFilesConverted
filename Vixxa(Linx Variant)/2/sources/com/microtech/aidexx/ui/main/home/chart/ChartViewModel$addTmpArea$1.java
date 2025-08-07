package com.microtech.aidexx.ui.main.home.chart;

import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel", f = "ChartViewModel.kt", i = {0, 0, 2, 2, 2, 2}, l = {1529, 1534, 1571, 1575, 1574}, m = "addTmpArea", n = {"this", "label", "this", "datePair", "tmpAreaInfo", "label"}, s = {"L$0", "J$0", "L$0", "L$1", "L$2", "J$0"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$addTmpArea$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$addTmpArea$1(ChartViewModel chartViewModel, Continuation<? super ChartViewModel$addTmpArea$1> continuation) {
        super(continuation);
        this.this$0 = chartViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addTmpArea(0, (Pair<? extends Date, ? extends Date>) null, (Date) null, false, this);
    }
}

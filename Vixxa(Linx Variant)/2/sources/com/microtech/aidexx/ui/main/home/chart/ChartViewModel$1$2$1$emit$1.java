package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.ui.main.home.chart.ChartViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$1$2$1", f = "ChartViewModel.kt", i = {0, 0, 0, 1}, l = {206, 255}, m = "emit", n = {"this", "dataUserId", "needNotify", "this"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$1$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChartViewModel.AnonymousClass1.AnonymousClass2.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$1$2$1$emit$1(ChartViewModel.AnonymousClass1.AnonymousClass2.AnonymousClass1<? super T> r1, Continuation<? super ChartViewModel$1$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, (Continuation<? super Unit>) this);
    }
}

package com.microtech.aidexx.ui.main.home.chart;

import com.github.mikephil.charting.data.CombinedData;
import com.microtech.aidexx.utils.LogUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$reload$startReset$1", f = "ChartViewModel.kt", i = {}, l = {381}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$reload$startReset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$reload$startReset$1(ChartViewModel chartViewModel, Continuation<? super ChartViewModel$reload$startReset$1> continuation) {
        super(2, continuation);
        this.this$0 = chartViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$reload$startReset$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$reload$startReset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<CombinedData> initData = this.this$0.initData(true);
            final ChartViewModel chartViewModel = this.this$0;
            this.label = 1;
            if (initData.collect(new FlowCollector() {
                public final Object emit(CombinedData combinedData, Continuation<? super Unit> continuation) {
                    LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== reload initdata", (String) null, 2, (Object) null);
                    Object notifyToRefreshChart$default = ChartViewModel.notifyToRefreshChart$default(chartViewModel, true, (Date) null, continuation, 2, (Object) null);
                    return notifyToRefreshChart$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? notifyToRefreshChart$default : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

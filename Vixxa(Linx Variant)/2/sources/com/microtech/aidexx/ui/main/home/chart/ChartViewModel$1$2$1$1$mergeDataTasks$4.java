package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$1$2$1$1$mergeDataTasks$4", f = "ChartViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$1$2$1$1$mergeDataTasks$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $needNotify;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$1$2$1$1$mergeDataTasks$4(ChartViewModel chartViewModel, Ref.BooleanRef booleanRef, Continuation<? super ChartViewModel$1$2$1$1$mergeDataTasks$4> continuation) {
        super(2, continuation);
        this.this$0 = chartViewModel;
        this.$needNotify = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$1$2$1$1$mergeDataTasks$4(this.this$0, this.$needNotify, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$1$2$1$1$mergeDataTasks$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.nextPageEventData.isEmpty()) {
                LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== 下一页数据 nextPageEventData size=" + this.this$0.nextPageEventData.size(), (String) null, 2, (Object) null);
                ChartViewModel chartViewModel = this.this$0;
                chartViewModel.addEvent(chartViewModel.nextPageEventData, this.this$0.curLabel);
                this.this$0.nextPageEventData.clear();
                this.$needNotify.element = true;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

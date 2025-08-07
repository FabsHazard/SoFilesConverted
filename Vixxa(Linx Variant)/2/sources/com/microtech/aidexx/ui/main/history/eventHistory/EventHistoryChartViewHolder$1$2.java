package com.microtech.aidexx.ui.main.history.eventHistory;

import com.microtech.aidexx.databinding.FragmentHistoryEventBinding;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.views.chart.GlucoseChart;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryChartViewHolder$1$2", f = "HistoryChartViewHolder.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HistoryChartViewHolder.kt */
final class EventHistoryChartViewHolder$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentHistoryEventBinding $this_apply;
    int label;
    final /* synthetic */ EventHistoryChartViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHistoryChartViewHolder$1$2(EventHistoryChartViewHolder eventHistoryChartViewHolder, FragmentHistoryEventBinding fragmentHistoryEventBinding, Continuation<? super EventHistoryChartViewHolder$1$2> continuation) {
        super(2, continuation);
        this.this$0 = eventHistoryChartViewHolder;
        this.$this_apply = fragmentHistoryEventBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryChartViewHolder$1$2(this.this$0, this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryChartViewHolder$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "cm", "Lcom/microtech/aidexx/ui/main/history/eventHistory/ChartModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryChartViewHolder$1$2$1", f = "HistoryChartViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryChartViewHolder$1$2$1  reason: invalid class name */
    /* compiled from: HistoryChartViewHolder.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ChartModel, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(fragmentHistoryEventBinding, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(ChartModel chartModel, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(chartModel, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChartModel chartModel = (ChartModel) this.L$0;
                if (chartModel != null) {
                    FragmentHistoryEventBinding fragmentHistoryEventBinding = fragmentHistoryEventBinding;
                    if (fragmentHistoryEventBinding.chart.getData() == null) {
                        fragmentHistoryEventBinding.chart.initData(chartModel.getCombinedData());
                    } else {
                        GlucoseChart glucoseChart = fragmentHistoryEventBinding.chart;
                        Intrinsics.checkNotNullExpressionValue(glucoseChart, "chart");
                        GlucoseChart.notifyChanged$default(glucoseChart, true, (Date) null, 2, (Object) null);
                    }
                    fragmentHistoryEventBinding.tvMaxWave.setText(chartModel.getCgmWaveText());
                    fragmentHistoryEventBinding.tvMax.setText(chartModel.getCgmHighestText());
                    fragmentHistoryEventBinding.tvMaxText.setText(chartModel.getCgmHighestTitleText());
                    fragmentHistoryEventBinding.tvMin.setText(chartModel.getCgmLowestText());
                    fragmentHistoryEventBinding.tvMinText.setText(chartModel.getCgmLowestTitleText());
                    fragmentHistoryEventBinding.tvGlucoseUnit.setText(UnitManager.INSTANCE.getDisplayUnit());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FragmentHistoryEventBinding fragmentHistoryEventBinding = this.$this_apply;
            this.label = 1;
            if (FlowKt.collectLatest(this.this$0.getVm().getChartModel(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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

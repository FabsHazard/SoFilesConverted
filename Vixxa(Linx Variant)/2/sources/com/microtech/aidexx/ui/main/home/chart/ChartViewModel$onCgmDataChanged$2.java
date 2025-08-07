package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onCgmDataChanged$2", f = "ChartViewModel.kt", i = {}, l = {503}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$onCgmDataChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<DataChangedType, List<BaseEventEntity>> $data;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ChartViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataChangedType.values().length];
            try {
                iArr[DataChangedType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$onCgmDataChanged$2(Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair, ChartViewModel chartViewModel, Continuation<? super ChartViewModel$onCgmDataChanged$2> continuation) {
        super(2, continuation);
        this.$data = pair;
        this.this$0 = chartViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$onCgmDataChanged$2(this.$data, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$onCgmDataChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (WhenMappings.$EnumSwitchMapping$0[this.$data.getFirst().ordinal()] == 1) {
                List<BaseEventEntity> second = this.$data.getSecond();
                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.collections.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>");
                Map access$dataListGroupByLabel = this.this$0.dataListGroupByLabel(second);
                if (access$dataListGroupByLabel.isEmpty()) {
                    access$dataListGroupByLabel = null;
                }
                if (access$dataListGroupByLabel == null) {
                    return null;
                }
                ChartViewModel chartViewModel = this.this$0;
                for (Map.Entry entry : access$dataListGroupByLabel.entrySet()) {
                    chartViewModel.addCgmData((List) entry.getValue(), ((Number) entry.getKey()).longValue(), (Date) null, (Date) null);
                    LogUtil.Companion.d("===CHART=== onCgmDataChanged " + ((Number) entry.getKey()).longValue() + " ADD", "ChartViewModel");
                }
                this.label = 1;
                if (chartViewModel.eventToRefreshChart(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

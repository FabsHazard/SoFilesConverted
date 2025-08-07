package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.views.chart.dataset.EventEntryConverterKt;
import com.microtech.aidexx.views.chart.dataset.IconDataSet;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onEventDataChanged$2", f = "ChartViewModel.kt", i = {}, l = {641, 651}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$onEventDataChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<DataChangedType, List<BaseEventEntity>> $changedInfo;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ChartViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.microtech.aidexx.utils.eventbus.DataChangedType[] r0 = com.microtech.aidexx.utils.eventbus.DataChangedType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.utils.eventbus.DataChangedType r1 = com.microtech.aidexx.utils.eventbus.DataChangedType.ADD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.eventbus.DataChangedType r1 = com.microtech.aidexx.utils.eventbus.DataChangedType.DELETE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onEventDataChanged$2.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$onEventDataChanged$2(Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair, ChartViewModel chartViewModel, Continuation<? super ChartViewModel$onEventDataChanged$2> continuation) {
        super(2, continuation);
        this.$changedInfo = pair;
        this.this$0 = chartViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$onEventDataChanged$2(this.$changedInfo, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$onEventDataChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.$changedInfo.getFirst().ordinal()];
            if (i2 == 1) {
                Map access$dataListGroupByLabel = this.this$0.dataListGroupByLabel(this.$changedInfo.getSecond());
                if (!access$dataListGroupByLabel.isEmpty()) {
                    ChartViewModel chartViewModel = this.this$0;
                    for (Map.Entry entry : access$dataListGroupByLabel.entrySet()) {
                        chartViewModel.addEvent((List) entry.getValue(), ((Number) entry.getKey()).longValue());
                        LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== onEventDataChanged " + ((Number) entry.getKey()).longValue() + " add", (String) null, 2, (Object) null);
                    }
                    this.label = 1;
                    if (this.this$0.eventToRefreshChart(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i2 == 2) {
                ChartViewModel chartViewModel2 = this.this$0;
                Iterator it = this.$changedInfo.getSecond().iterator();
                loop0:
                while (true) {
                    z = false;
                    while (true) {
                        if (!it.hasNext()) {
                            break loop0;
                        }
                        BaseEventEntity baseEventEntity = (BaseEventEntity) it.next();
                        if (z || chartViewModel2.deleteEntry(EventEntryConverterKt.toChartEntry$default(baseEventEntity, (Function0) null, 1, (Object) null), IconDataSet.class)) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== onEventDataChanged del", (String) null, 2, (Object) null);
                    this.label = 2;
                    if (this.this$0.eventToRefreshChart(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

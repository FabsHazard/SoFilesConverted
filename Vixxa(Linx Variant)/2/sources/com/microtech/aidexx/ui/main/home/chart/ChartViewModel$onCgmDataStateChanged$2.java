package com.microtech.aidexx.ui.main.home.chart;

import com.github.mikephil.charting.data.Entry;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.eventbus.CgmDataState;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.views.chart.ChartUtil;
import com.microtech.aidexx.views.chart.dataset.CurrentGlucoseDataSet;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onCgmDataStateChanged$2", f = "ChartViewModel.kt", i = {}, l = {557, 568}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$onCgmDataStateChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<DataChangedType, CgmDataState> $data;
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
                com.microtech.aidexx.utils.eventbus.DataChangedType r1 = com.microtech.aidexx.utils.eventbus.DataChangedType.DATA_STATE_ADD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.eventbus.DataChangedType r1 = com.microtech.aidexx.utils.eventbus.DataChangedType.DATA_STATE_DELETE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onCgmDataStateChanged$2.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$onCgmDataStateChanged$2(Pair<? extends DataChangedType, CgmDataState> pair, ChartViewModel chartViewModel, Continuation<? super ChartViewModel$onCgmDataStateChanged$2> continuation) {
        super(2, continuation);
        this.$data = pair;
        this.this$0 = chartViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$onCgmDataStateChanged$2(this.$data, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$onCgmDataStateChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.$data.getFirst().ordinal()];
            if (i2 == 1) {
                CgmDataState second = this.$data.getSecond();
                if (second.getTime() == null || second.getGlucoseValueMg() == null) {
                    LogUtil.Companion.xLogE("onCgmDataStateChanged data=" + second, "ChartViewModel");
                } else {
                    this.this$0.curGlucoseStateSets.clear();
                    float f = 36.0f;
                    if (second.getGlucoseValueMg().floatValue() > 36.0f) {
                        f = 450.0f;
                        if (second.getGlucoseValueMg().floatValue() < 450.0f) {
                            f = second.getGlucoseValueMg().floatValue();
                        }
                    }
                    float glucoseValue = GlucoseUtilKt.toGlucoseValue(f);
                    float glucoseValue2 = GlucoseUtilKt.toGlucoseValue(f) + (glucoseValue == GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHyper()) ? 0.1f : glucoseValue == GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHypo()) ? -0.1f : 0.0f);
                    String formatWithoutZone = ExtendsKt.formatWithoutZone(new Date(second.getTime().longValue()));
                    this.this$0.dateFormat.setTimeZone(TimeUtils.INSTANCE.getCDFTimezone());
                    Date parse = this.this$0.dateFormat.parse(formatWithoutZone);
                    if (parse != null) {
                        CurrentGlucoseDataSet access$getCurGlucoseStateSets$p = this.this$0.curGlucoseStateSets;
                        Entry entry = new Entry(ChartUtil.INSTANCE.millSecondToX(parse.getTime()), glucoseValue2);
                        entry.setData(second);
                        access$getCurGlucoseStateSets$p.addEntry(entry);
                        LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== onCgmDataStateChanged", (String) null, 2, (Object) null);
                        if (this.this$0.canMergeData(this.$data.getSecond().getUserId())) {
                            this.label = 1;
                            if (this.this$0.eventToRefreshChart(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                }
            } else if (i2 == 2) {
                this.this$0.curGlucoseStateSets.clear();
                if (this.this$0.canMergeData(this.$data.getSecond().getUserId())) {
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

package com.microtech.aidexx.ui.main.trend;

import com.github.mikephil.charting.data.LineData;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$2", f = "TrendsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TrendsViewModel.kt */
final class TrendsViewModel$updateMultiChartData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LineData $lineData;
    final /* synthetic */ List<MultiDayBgItem> $mutableList;
    int label;
    final /* synthetic */ TrendsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsViewModel$updateMultiChartData$2(List<MultiDayBgItem> list, TrendsViewModel trendsViewModel, LineData lineData, Continuation<? super TrendsViewModel$updateMultiChartData$2> continuation) {
        super(2, continuation);
        this.$mutableList = list;
        this.this$0 = trendsViewModel;
        this.$lineData = lineData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendsViewModel$updateMultiChartData$2(this.$mutableList, this.this$0, this.$lineData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrendsViewModel$updateMultiChartData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            for (MultiDayBgItem next : this.$mutableList) {
                if (!next.getHistories().isEmpty()) {
                    for (List<RealCgmHistoryEntity> access$addLineData : next.getHistories().values()) {
                        this.this$0.addLineData(access$addLineData, this.$lineData, next.getColor());
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

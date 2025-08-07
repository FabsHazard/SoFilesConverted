package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.ui.main.home.chart.ChartViewModel;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.chart.ChartUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$needLoadNextPage$1$1", f = "ChartViewModel.kt", i = {0}, l = {447, 455}, m = "invokeSuspend", n = {"needToMerge"}, s = {"L$0"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$needLoadNextPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChartViewModel.AreaInfo $ai;
    final /* synthetic */ Ref.ObjectRef<Date> $endDate;
    final /* synthetic */ Date $startDate;
    Object L$0;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$needLoadNextPage$1$1(ChartViewModel chartViewModel, Date date, Ref.ObjectRef<Date> objectRef, ChartViewModel.AreaInfo areaInfo, Continuation<? super ChartViewModel$needLoadNextPage$1$1> continuation) {
        super(2, continuation);
        this.this$0 = chartViewModel;
        this.$startDate = date;
        this.$endDate = objectRef;
        this.$ai = areaInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$needLoadNextPage$1$1(this.this$0, this.$startDate, this.$endDate, this.$ai, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$needLoadNextPage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Dialogs.showWait$default(Dialogs.INSTANCE, (String) null, 1, (Object) null);
            booleanRef = new Ref.BooleanRef();
            Pair access$dealUnion = this.this$0.dealUnion(TuplesKt.to(this.$startDate, this.$endDate.element), (ChartViewModel.AreaInfo) null, (ChartViewModel.AreaInfo) this.this$0.areas.get(Boxing.boxLong(this.this$0.defaultLabel)));
            if (access$dealUnion != null) {
                Ref.ObjectRef<Date> objectRef = this.$endDate;
                ChartViewModel chartViewModel = this.this$0;
                if (((Number) access$dealUnion.getFirst()).intValue() == 1) {
                    objectRef.element = ((Pair) access$dealUnion.getSecond()).getSecond();
                    booleanRef.element = true;
                    chartViewModel.curLabel = chartViewModel.defaultLabel;
                    LogUtil.Companion.xLogI("又翻页融合持久区", "ChartViewModel");
                }
            }
            this.L$0 = booleanRef;
            this.label = 1;
            obj2 = ChartViewModel.loadNextPageData$default(this.this$0, this.$startDate, (Date) this.$endDate.element, false, this.this$0.curLabel, this, 4, (Object) null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            Dialogs.INSTANCE.dismissWait();
            this.$ai.setLoadingRightPage(false);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj2).booleanValue()) {
            this.$ai.setMaxX(ChartUtil.INSTANCE.millSecondToX(((Date) this.$endDate.element).getTime()));
            this.$ai.setMaxTs(((Date) this.$endDate.element).getTime());
            if (booleanRef.element) {
                this.this$0.mergeTmpToDefArea(this.$ai.getLabel());
            }
            this.L$0 = null;
            this.label = 2;
            if (ChartViewModel.notifyToRefreshChart$default(this.this$0, false, (Date) null, this, 3, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Dialogs.INSTANCE.dismissWait();
        this.$ai.setLoadingRightPage(false);
        return Unit.INSTANCE;
    }
}

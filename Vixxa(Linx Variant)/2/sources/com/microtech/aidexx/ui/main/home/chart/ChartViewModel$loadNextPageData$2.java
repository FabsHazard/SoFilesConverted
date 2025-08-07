package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.chart.ChartUtil;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$loadNextPageData$2", f = "ChartViewModel.kt", i = {0}, l = {821}, m = "invokeSuspend", n = {"isSuccess"}, s = {"L$0"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$loadNextPageData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $areaLabel;
    final /* synthetic */ Date $endDate;
    final /* synthetic */ boolean $needApply;
    final /* synthetic */ Date $startDate;
    Object L$0;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$loadNextPageData$2(long j, Date date, Date date2, ChartViewModel chartViewModel, boolean z, Continuation<? super ChartViewModel$loadNextPageData$2> continuation) {
        super(2, continuation);
        this.$areaLabel = j;
        this.$startDate = date;
        this.$endDate = date2;
        this.this$0 = chartViewModel;
        this.$needApply = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$loadNextPageData$2(this.$areaLabel, this.$startDate, this.$endDate, this.this$0, this.$needApply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((ChartViewModel$loadNextPageData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LogUtil.Companion.d("===CHART=== loadNextPage areaLabel=" + this.$areaLabel + " start=" + ExtendsKt.formatToYMdHm(this.$startDate) + " end=" + ExtendsKt.formatToYMdHm(this.$endDate), "ChartViewModel");
            this.this$0.timeMin = Boxing.boxFloat(ChartUtil.INSTANCE.dateToX(this.$startDate));
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            booleanRef2.element = true;
            final ChartViewModel chartViewModel = this.this$0;
            final Date date = this.$startDate;
            final Date date2 = this.$endDate;
            final boolean z = this.$needApply;
            final long j = this.$areaLabel;
            final Ref.BooleanRef booleanRef3 = booleanRef2;
            this.L$0 = booleanRef2;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(booleanRef.element);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$loadNextPageData$2$1", f = "ChartViewModel.kt", i = {}, l = {892}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.chart.ChartViewModel$loadNextPageData$2$1  reason: invalid class name */
    /* compiled from: ChartViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(chartViewModel, date, date2, booleanRef3, z, j, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$loadNextPageData$2$1$loadTasks$1(chartViewModel, date, date2, booleanRef3, z, j, (Continuation<? super ChartViewModel$loadNextPageData$2$1$loadTasks$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$loadNextPageData$2$1$loadTasks$2(date, date2, booleanRef3, z, chartViewModel, j, (Continuation<? super ChartViewModel$loadNextPageData$2$1$loadTasks$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$loadNextPageData$2$1$loadTasks$3(date, date2, booleanRef3, z, chartViewModel, j, (Continuation<? super ChartViewModel$loadNextPageData$2$1$loadTasks$3>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$loadNextPageData$2$1$loadTasks$4(date, date2, booleanRef3, z, chartViewModel, j, (Continuation<? super ChartViewModel$loadNextPageData$2$1$loadTasks$4>) null), 3, (Object) null)};
                this.label = 1;
                obj = AwaitKt.awaitAll(CollectionsKt.listOf(deferredArr), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }
}

package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.repository.CgmCalibBgRepository;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$loadNextPageData$2$1$loadTasks$3", f = "ChartViewModel.kt", i = {}, l = {864}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$loadNextPageData$2$1$loadTasks$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ long $areaLabel;
    final /* synthetic */ Date $endDate;
    final /* synthetic */ Ref.BooleanRef $isSuccess;
    final /* synthetic */ boolean $needApply;
    final /* synthetic */ Date $startDate;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$loadNextPageData$2$1$loadTasks$3(Date date, Date date2, Ref.BooleanRef booleanRef, boolean z, ChartViewModel chartViewModel, long j, Continuation<? super ChartViewModel$loadNextPageData$2$1$loadTasks$3> continuation) {
        super(2, continuation);
        this.$startDate = date;
        this.$endDate = date2;
        this.$isSuccess = booleanRef;
        this.$needApply = z;
        this.this$0 = chartViewModel;
        this.$areaLabel = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$loadNextPageData$2$1$loadTasks$3(this.$startDate, this.$endDate, this.$isSuccess, this.$needApply, this.this$0, this.$areaLabel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((ChartViewModel$loadNextPageData$2$1$loadTasks$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = CgmCalibBgRepository.INSTANCE.queryCalByPage(this.$startDate, this.$endDate, UserInfoManager.Companion.getCurShowUserId(), (Continuation<? super List<CalibrateEntity>>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (list == null) {
            return null;
        }
        Ref.BooleanRef booleanRef = this.$isSuccess;
        boolean z = this.$needApply;
        ChartViewModel chartViewModel = this.this$0;
        long j = this.$areaLabel;
        if (list.size() > 0 && !Intrinsics.areEqual((Object) ((CalibrateEntity) list.get(0)).getUserId(), (Object) UserInfoManager.Companion.getCurShowUserId())) {
            booleanRef.element = false;
            return Unit.INSTANCE;
        } else if (!z) {
            return Boxing.boxBoolean(chartViewModel.nextPageCalData.addAll(list));
        } else {
            chartViewModel.addCalData(list, j);
            return Unit.INSTANCE;
        }
    }
}

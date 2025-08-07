package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.utils.LogUtil;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$loadNextPageData$2$1$loadTasks$1", f = "ChartViewModel.kt", i = {}, l = {825}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$loadNextPageData$2$1$loadTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $areaLabel;
    final /* synthetic */ Date $endDate;
    final /* synthetic */ Ref.BooleanRef $isSuccess;
    final /* synthetic */ boolean $needApply;
    final /* synthetic */ Date $startDate;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$loadNextPageData$2$1$loadTasks$1(ChartViewModel chartViewModel, Date date, Date date2, Ref.BooleanRef booleanRef, boolean z, long j, Continuation<? super ChartViewModel$loadNextPageData$2$1$loadTasks$1> continuation) {
        super(2, continuation);
        this.this$0 = chartViewModel;
        this.$startDate = date;
        this.$endDate = date2;
        this.$isSuccess = booleanRef;
        this.$needApply = z;
        this.$areaLabel = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewModel$loadNextPageData$2$1$loadTasks$1(this.this$0, this.$startDate, this.$endDate, this.$isSuccess, this.$needApply, this.$areaLabel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$loadNextPageData$2$1$loadTasks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getCgmPageData(this.$startDate, this.$endDate, this);
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
        Date date = this.$startDate;
        Date date2 = this.$endDate;
        ChartViewModel chartViewModel = this.this$0;
        long j = this.$areaLabel;
        if (list.size() > 0 && !Intrinsics.areEqual((Object) ((RealCgmHistoryEntity) list.get(0)).getUserId(), (Object) UserInfoManager.Companion.getCurShowUserId())) {
            booleanRef.element = false;
            LogUtil.Companion.d("cgm 加载成功 size=" + list.size() + " 或用户不对", "ChartViewModel");
        } else if (z) {
            LogUtil.Companion.d("cgm 加载成功 size=" + list.size() + " 开始添加内存 " + ExtendsKt.formatToYMdHm(date) + "->" + ExtendsKt.formatToYMdHm(date2), "ChartViewModel");
            chartViewModel.addCgmData(list, j, date, date2);
            LogUtil.Companion.d("cgm 加载成功 size=" + list.size() + " 添加内存成功", "ChartViewModel");
        } else {
            LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== 下一页数据 size=" + list.size() + " 准备完毕 " + ExtendsKt.formatToYMdHm(date) + "->" + ExtendsKt.formatToYMdHm(date2), (String) null, 2, (Object) null);
            if (list.size() > 2) {
                LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== 下一页数据 first=" + ((RealCgmHistoryEntity) CollectionsKt.first(list)).getTimestamp() + " last=" + ((RealCgmHistoryEntity) CollectionsKt.last(list)).getTimestamp(), (String) null, 2, (Object) null);
            }
            chartViewModel.nextPageCgmData.addAll(list);
            chartViewModel.globalStartDate = date;
            chartViewModel.globalEndDate = date2;
        }
        return Unit.INSTANCE;
    }
}

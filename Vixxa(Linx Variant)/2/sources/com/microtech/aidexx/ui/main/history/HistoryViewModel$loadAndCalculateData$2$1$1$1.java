package com.microtech.aidexx.ui.main.history;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.ui.main.history.eventHistory.ChartModel;
import com.microtech.aidexx.ui.main.history.eventHistory.CountModel;
import com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel;
import com.microtech.aidexx.utils.LogUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.HistoryViewModel$loadAndCalculateData$2$1$1$1", f = "HistoryViewModel.kt", i = {}, l = {163, 166, 188}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HistoryViewModel.kt */
final class HistoryViewModel$loadAndCalculateData$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Pair<Boolean, List<HistoryDetailModel>>> $alerts;
    final /* synthetic */ ChartModel $chartModel;
    final /* synthetic */ CountModel $countDataModel;
    final /* synthetic */ List<BaseEventEntity> $it;
    final /* synthetic */ ProportionModel $proportionDataModel;
    final /* synthetic */ CopyOnWriteArrayList<HistoryDetailModel> $records;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HistoryViewModel$loadAndCalculateData$2$1$1$1(List<? extends BaseEventEntity> list, ChartModel chartModel, HistoryViewModel historyViewModel, ProportionModel proportionModel, Ref.ObjectRef<Pair<Boolean, List<HistoryDetailModel>>> objectRef, CountModel countModel, CopyOnWriteArrayList<HistoryDetailModel> copyOnWriteArrayList, Continuation<? super HistoryViewModel$loadAndCalculateData$2$1$1$1> continuation) {
        super(2, continuation);
        this.$it = list;
        this.$chartModel = chartModel;
        this.this$0 = historyViewModel;
        this.$proportionDataModel = proportionModel;
        this.$alerts = objectRef;
        this.$countDataModel = countModel;
        this.$records = copyOnWriteArrayList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryViewModel$loadAndCalculateData$2$1$1$1(this.$it, this.$chartModel, this.this$0, this.$proportionDataModel, this.$alerts, this.$countDataModel, this.$records, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HistoryViewModel$loadAndCalculateData$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        HistoryViewModel historyViewModel;
        Ref.ObjectRef<Pair<Boolean, List<HistoryDetailModel>>> objectRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<BaseEventEntity> list = this.$it;
            if (list != null) {
                ChartModel chartModel = this.$chartModel;
                HistoryViewModel historyViewModel2 = this.this$0;
                ProportionModel proportionModel = this.$proportionDataModel;
                Ref.ObjectRef<Pair<Boolean, List<HistoryDetailModel>>> objectRef2 = this.$alerts;
                CountModel countModel = this.$countDataModel;
                CopyOnWriteArrayList<HistoryDetailModel> copyOnWriteArrayList = this.$records;
                BaseEventEntity baseEventEntity = (BaseEventEntity) CollectionsKt.firstOrNull(list);
                if (baseEventEntity != null) {
                    if (!Intrinsics.areEqual((Object) UserInfoManager.Companion.getCurShowUserId(), (Object) baseEventEntity.getUserId())) {
                        String access$getTAG$cp = HistoryViewModel.TAG;
                        Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
                        LogUtil.Companion.d("用户变了 终止处理 " + baseEventEntity, access$getTAG$cp);
                        return Unit.INSTANCE;
                    } else if (baseEventEntity instanceof RealCgmHistoryEntity) {
                        chartModel.setHasWave(list.size() > 2);
                        for (BaseEventEntity baseEventEntity2 : list) {
                            historyViewModel2.calculateForChart(baseEventEntity2, chartModel);
                            Intrinsics.checkNotNull(baseEventEntity2, "null cannot be cast to non-null type com.microtech.aidexx.db.entity.RealCgmHistoryEntity");
                            RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) baseEventEntity2;
                            historyViewModel2.calculateForProportion(proportionModel, realCgmHistoryEntity);
                            historyViewModel2.calculateForAlert((List) ((Pair) objectRef2.element).getSecond(), realCgmHistoryEntity);
                        }
                        historyViewModel2.calculateCgmWave(chartModel);
                        historyViewModel2.calculateForProportion(proportionModel, (RealCgmHistoryEntity) null);
                        proportionModel.setDirty(true);
                        MutableStateFlow access$get_proportionModel$p = historyViewModel2._proportionModel;
                        this.L$0 = historyViewModel2;
                        this.L$1 = objectRef2;
                        this.label = 1;
                        if (access$get_proportionModel$p.emit(proportionModel, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef = objectRef2;
                        historyViewModel = historyViewModel2;
                    } else if (baseEventEntity instanceof BloodGlucoseEntity) {
                        for (BaseEventEntity baseEventEntity3 : list) {
                            HistoryViewModel.calculateForChart$default(historyViewModel2, baseEventEntity3, (ChartModel) null, 2, (Object) null);
                            historyViewModel2.calculateForRecords(copyOnWriteArrayList, baseEventEntity3);
                        }
                    } else if (baseEventEntity instanceof CalibrateEntity) {
                        for (BaseEventEntity baseEventEntity4 : list) {
                            HistoryViewModel.calculateForChart$default(historyViewModel2, baseEventEntity4, (ChartModel) null, 2, (Object) null);
                            historyViewModel2.calculateForRecords(copyOnWriteArrayList, baseEventEntity4);
                        }
                    } else {
                        for (BaseEventEntity baseEventEntity5 : list) {
                            CopyOnWriteArrayList<HistoryDetailModel> copyOnWriteArrayList2 = copyOnWriteArrayList;
                            HistoryViewModel.calculateForCount$default(historyViewModel2, countModel, baseEventEntity5, (Function2) null, 4, (Object) null);
                            HistoryViewModel.calculateForChart$default(historyViewModel2, baseEventEntity5, (ChartModel) null, 2, (Object) null);
                            historyViewModel2.calculateForRecords(copyOnWriteArrayList2, baseEventEntity5);
                            countModel = countModel;
                            copyOnWriteArrayList = copyOnWriteArrayList2;
                            z = true;
                        }
                        CountModel countModel2 = countModel;
                        countModel2.setDirty(z);
                        MutableStateFlow access$get_countModel$p = historyViewModel2._countModel;
                        this.label = 3;
                        if (access$get_countModel$p.emit(countModel2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$1;
            historyViewModel = (HistoryViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef.element = TuplesKt.to(Boxing.boxBoolean(false), ((Pair) objectRef.element).getSecond());
        MutableStateFlow access$get_alertModel$p = historyViewModel._alertModel;
        Object second = ((Pair) objectRef.element).getSecond();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (access$get_alertModel$p.emit(second, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}

package com.microtech.aidexx.ui.main.home.chart;

import com.github.mikephil.charting.data.CombinedData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/github/mikephil/charting/data/CombinedData;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$initData$1", f = "ChartViewModel.kt", i = {2, 2, 3, 3, 4, 4, 4, 5}, l = {280, 282, 292, 293, 354, 357, 360, 366}, m = "invokeSuspend", n = {"$this$flow", "curUserId", "$this$flow", "curUserId", "curUserId", "cgmMaxDate", "minDate", "curUserId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$initData$1 extends SuspendLambda implements Function2<FlowCollector<? super CombinedData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needReloadData;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$initData$1(ChartViewModel chartViewModel, boolean z, Continuation<? super ChartViewModel$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = chartViewModel;
        this.$needReloadData = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChartViewModel$initData$1 chartViewModel$initData$1 = new ChartViewModel$initData$1(this.this$0, this.$needReloadData, continuation);
        chartViewModel$initData$1.L$0 = obj;
        return chartViewModel$initData$1;
    }

    public final Object invoke(FlowCollector<? super CombinedData> flowCollector, Continuation<? super Unit> continuation) {
        return ((ChartViewModel$initData$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x010d, code lost:
        com.microtech.aidexx.utils.LogUtil.Companion.eAiDEX("zoneTest isDataLoaded --> isDataLoaded = true 11");
        r0.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x011e, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r0) != r1) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0120, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0121, code lost:
        r0.this$0.setDataLoaded(true);
        com.microtech.aidexx.utils.LogUtil.Companion.eAiDEX("zoneTest isDataLoaded --> isDataLoaded = true");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x012f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x016d, code lost:
        r0.L$0 = r10;
        r0.L$1 = r2;
        r0.label = 4;
        r11 = com.microtech.aidexx.db.repository.CgmCalibBgRepository.INSTANCE.queryNextByTargetDate(com.microtech.aidexx.common.user.UserInfoManager.Companion.getCurShowUserId(), new java.util.Date(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0188, code lost:
        if (r11 != r1) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x018a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x018b, code lost:
        com.microtech.aidexx.utils.LogUtil.Companion.d("查询第一条 " + ((com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r11) + ' ' + r0.this$0, "ChartViewModel");
        r11 = new java.util.Date().getTime() + 1296000000;
        r13 = new java.util.Date(r11);
        com.microtech.aidexx.utils.LogUtil.Companion.d("查询第一条 日期 " + new java.util.Date(r11) + ' ' + r0.this$0, "ChartViewModel");
        r4 = r0.this$0.getCurPageStartDate(r11, true);
        com.microtech.aidexx.utils.LogUtil.Companion.d("查询第一条 最小日期 " + r4 + ' ' + r0.this$0, "ChartViewModel");
        r0.this$0.timeMin = kotlin.coroutines.jvm.internal.Boxing.boxFloat(com.microtech.aidexx.views.chart.ChartUtil.INSTANCE.dateToX(r4));
        r5 = new java.util.concurrent.CopyOnWriteArrayList();
        r5.addAll(com.microtech.aidexx.views.chart.GlucoseChart.Companion.generateLimitLines(r0.this$0.xMin(), r0.this$0.xMax(), r0.this$0.getLowerLimit(), r0.this$0.getUpperLimit()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0245, code lost:
        if (r0.this$0.glucoseSets.isEmpty() == false) goto L_0x0271;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0247, code lost:
        r8 = r0.this$0.glucoseSets;
        r11 = new com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine();
        r11.setLabel(new java.lang.StringBuilder().append(r0.this$0.defaultLabel).append(org.apache.commons.codec.language.Soundex.SILENT_MARKER).toString());
        r8.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0271, code lost:
        com.microtech.aidexx.views.chart.GlucoseChart.Companion.formatGlucoseSetAfterInitData(r0.this$0.glucoseSets, r0.this$0.getLowerLimit(), r0.this$0.getUpperLimit());
        com.microtech.aidexx.utils.LogUtil.Companion.d("数据加载完毕 " + r0.this$0, "ChartViewModel");
        r5.addAll(r0.this$0.glucoseSets);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x02af, code lost:
        if (com.microtech.aidexx.common.user.UserInfoManager.Companion.getShareUserInfo() != null) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x02b1, code lost:
        com.microtech.aidexx.views.chart.GlucoseChart.Companion.formatGlucoseSetAfterInitData(kotlin.collections.CollectionsKt.listOf(r0.this$0.curGlucoseStateSets), r0.this$0.getLowerLimit(), r0.this$0.getUpperLimit());
        r5.add(r0.this$0.curGlucoseStateSets);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x02d5, code lost:
        r0.this$0.calSet.setLabel(java.lang.String.valueOf(r0.this$0.defaultLabel));
        r0.this$0.bgSet.setLabel(r0.this$0.calSet.getLabel());
        r0.this$0.eventSet.setLabel(r0.this$0.calSet.getLabel());
        r0.this$0.timezoneSet.setLabel(r0.this$0.calSet.getLabel());
        r0.this$0.dstSet.setLabel(r0.this$0.calSet.getLabel());
        r6 = new java.util.ArrayList();
        r6.add(r0.this$0.dstSet);
        r6.add(r0.this$0.timezoneSet);
        r6.add(r0.this$0.calSet);
        r6.add(r0.this$0.bgSet);
        r6.add(r0.this$0.eventSet);
        r0.this$0.getCombinedData().setData(new com.github.mikephil.charting.data.ScatterData((java.util.List<com.github.mikephil.charting.interfaces.datasets.IScatterDataSet>) r6));
        r0.this$0.getCombinedData().setData(new com.github.mikephil.charting.data.LineData((java.util.List<com.github.mikephil.charting.interfaces.datasets.ILineDataSet>) r5));
        r5 = new java.util.Date();
        r37 = r4;
        r6 = new java.util.Date(new java.util.Date().getTime() - ((((long) (r0.this$0.getGranularity() * 6)) * com.microtech.aidexx.utils.TimeUtils.oneHourSeconds) * ((long) 1000)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x03b2, code lost:
        if (r0.this$0.timeMax != null) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x03b4, code lost:
        r0.this$0.timeMax = kotlin.coroutines.jvm.internal.Boxing.boxFloat(com.microtech.aidexx.views.chart.ChartUtil.INSTANCE.dateToX(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x03c9, code lost:
        if (r0.this$0.timeMin != null) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x03cb, code lost:
        r0.this$0.timeMin = kotlin.coroutines.jvm.internal.Boxing.boxFloat(com.microtech.aidexx.views.chart.ChartUtil.INSTANCE.dateToX(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x03da, code lost:
        r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0.this$0.defaultLabel);
        r18 = r8;
        r8 = new java.util.Date();
        r17 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel.AreaInfo(r18, (kotlin.Pair) null, 0, 0, 0.0f, 0.0f, 0, 0, (java.lang.String) null, (java.util.Date) null, false, false, 4094, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r8 = r0.this$0;
        r17.setMinTs(r6.getTime());
        r17.setMaxTs(r5.getTime());
        r5 = r8.timeMin;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r17.setMinX(r5.floatValue());
        r5 = r8.timeMax;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r17.setMaxX(r5.floatValue());
        r0.this$0.areas.put(r4, r17);
        r0.L$0 = r2;
        r0.L$1 = r13;
        r5 = r37;
        r0.L$2 = r5;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x045b, code lost:
        if (r10.emit(r0.this$0.getCombinedData(), r0) != r1) goto L_0x045e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x045d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x045e, code lost:
        r18 = r5;
        r19 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0462, code lost:
        r3 = r0.this$0;
        r0.L$0 = r2;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0480, code lost:
        if (com.microtech.aidexx.ui.main.home.chart.ChartViewModel.loadNextPageData$default(r3, r18, r19, false, 0, r0, 12, (java.lang.Object) null) != r1) goto L_0x0483;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0482, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x048d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) com.microtech.aidexx.common.user.UserInfoManager.Companion.getCurShowUserId()) == false) goto L_0x04c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x048f, code lost:
        com.microtech.aidexx.utils.LogUtil.Companion.d("initData 查询区间数据 结束 " + r0.this$0, "ChartViewModel");
        r2 = r0.this$0;
        r0.L$0 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x04bf, code lost:
        if (com.microtech.aidexx.ui.main.home.chart.ChartViewModel.notifyToRefreshChart$default(r2, true, (java.util.Date) null, r0, 2, (java.lang.Object) null) != r1) goto L_0x04d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x04c1, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x04c2, code lost:
        com.microtech.aidexx.utils.LogUtil.Companion.d("initData 换人了不刷新图表 结束 " + r0.this$0, "ChartViewModel");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x04d8, code lost:
        com.microtech.aidexx.views.dialog.Dialogs.INSTANCE.dismissWait();
        r3 = true;
        r0.this$0.setDataInit(true);
        r0.L$0 = null;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x04f3, code lost:
        if (kotlinx.coroutines.DelayKt.delay(5000, r0) != r1) goto L_0x04f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x04f5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x04f6, code lost:
        r0.this$0.setDataLoaded(r3);
        com.microtech.aidexx.views.chart.GlucoseChart.Companion.setIsInit(r0.this$0.isDataLoaded());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0508, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r37) {
        /*
            r36 = this;
            r0 = r36
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 6
            r4 = 5000(0x1388, double:2.4703E-320)
            r7 = 1
            r8 = 32
            java.lang.String r9 = "ChartViewModel"
            switch(r2) {
                case 0: goto L_0x006b;
                case 1: goto L_0x0066;
                case 2: goto L_0x0061;
                case 3: goto L_0x0054;
                case 4: goto L_0x0045;
                case 5: goto L_0x002f;
                case 6: goto L_0x0026;
                case 7: goto L_0x0021;
                case 8: goto L_0x001b;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r37)
            r3 = r7
            goto L_0x04f6
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x04d8
        L_0x0026:
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x0483
        L_0x002f:
            java.lang.Object r2 = r0.L$2
            java.util.Date r2 = (java.util.Date) r2
            java.lang.Object r8 = r0.L$1
            java.util.Date r8 = (java.util.Date) r8
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r37)
            r18 = r2
            r19 = r8
            r2 = r10
            goto L_0x0462
        L_0x0045:
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r37)
            r11 = r37
            goto L_0x018b
        L_0x0054:
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x016d
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x0121
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r37)
            goto L_0x010d
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r37)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r10 = r0.this$0
            r11 = 0
            r10.setDataLoaded(r11)
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r12 = "zoneTest isDataLoaded --> isDataLoaded = false"
            r10.eAiDEX(r12)
            com.microtech.aidexx.views.chart.GlucoseChart$Companion r10 = com.microtech.aidexx.views.chart.GlucoseChart.Companion
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r12 = r0.this$0
            boolean r12 = r12.isDataLoaded()
            r10.setIsInit(r12)
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "initData "
            r12.<init>(r13)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r13 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r13 = r13.combinedData
            if (r13 == 0) goto L_0x009a
            r11 = r7
        L_0x009a:
            java.lang.StringBuilder r11 = r12.append(r11)
            java.lang.StringBuilder r11 = r11.append(r8)
            boolean r12 = r0.$needReloadData
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r11 = r11.append(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r12 = r0.this$0
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r11 = r11.append(r8)
            java.lang.String r11 = r11.toString()
            r10.d(r11, r9)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r10 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r10 = r10.combinedData
            if (r10 == 0) goto L_0x0130
            boolean r10 = r0.$needReloadData
            if (r10 != 0) goto L_0x0130
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r10 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r10 = r10.getCombinedData()
            int r10 = r10.getEntryCount()
            if (r10 <= 0) goto L_0x0130
            com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r10 = "combinedData.entryCount="
            r6.<init>(r10)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r10 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r10 = r10.getCombinedData()
            int r10 = r10.getEntryCount()
            java.lang.StringBuilder r6 = r6.append(r10)
            java.lang.StringBuilder r6 = r6.append(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            r3.d(r6, r9)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r3 = r3.getCombinedData()
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.label = r7
            java.lang.Object r2 = r2.emit(r3, r6)
            if (r2 != r1) goto L_0x010d
            return r1
        L_0x010d:
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r3 = "zoneTest isDataLoaded --> isDataLoaded = true 11"
            r2.eAiDEX(r3)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 2
            r0.label = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r4, r2)
            if (r2 != r1) goto L_0x0121
            return r1
        L_0x0121:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r1 = r0.this$0
            r1.setDataLoaded(r7)
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "zoneTest isDataLoaded --> isDataLoaded = true"
            r1.eAiDEX(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0130:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r10 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r10 = r10.combinedData
            if (r10 != 0) goto L_0x0140
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r10 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r11 = new com.github.mikephil.charting.data.CombinedData
            r11.<init>()
            r10.setCombinedData(r11)
        L_0x0140:
            com.microtech.aidexx.views.dialog.Dialogs r10 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            com.microtech.aidexx.AidexxApp r11 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r12 = com.microtech.aidexx.R.string.com_loading
            java.lang.String r11 = r11.getString(r12)
            r10.showWait(r11)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r10 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            java.lang.String r10 = r10.getCurShowUserId()
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r2
            r0.L$1 = r10
            r12 = 3
            r0.label = r12
            r12 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r12, r11)
            if (r11 != r1) goto L_0x0168
            return r1
        L_0x0168:
            r35 = r10
            r10 = r2
            r2 = r35
        L_0x016d:
            com.microtech.aidexx.db.repository.CgmCalibBgRepository r11 = com.microtech.aidexx.db.repository.CgmCalibBgRepository.INSTANCE
            com.microtech.aidexx.common.user.UserInfoManager$Companion r12 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            java.lang.String r12 = r12.getCurShowUserId()
            java.util.Date r13 = new java.util.Date
            r13.<init>()
            r14 = r0
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r0.L$0 = r10
            r0.L$1 = r2
            r15 = 4
            r0.label = r15
            java.lang.Object r11 = r11.queryNextByTargetDate(r12, r13, r14)
            if (r11 != r1) goto L_0x018b
            return r1
        L_0x018b:
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r11 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r11
            com.microtech.aidexx.utils.LogUtil$Companion r12 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "查询第一条 "
            r13.<init>(r14)
            java.lang.StringBuilder r11 = r13.append(r11)
            java.lang.StringBuilder r11 = r11.append(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r13 = r0.this$0
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r11 = r11.toString()
            r12.d(r11, r9)
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            long r11 = r11.getTime()
            r13 = 1296000000(0x4d3f6400, double:6.40309077E-315)
            long r11 = r11 + r13
            java.util.Date r13 = new java.util.Date
            r13.<init>(r11)
            com.microtech.aidexx.utils.LogUtil$Companion r14 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r4 = "查询第一条 日期 "
            r15.<init>(r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>(r11)
            java.lang.StringBuilder r4 = r15.append(r4)
            java.lang.StringBuilder r4 = r4.append(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r5 = r0.this$0
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r14.d(r4, r9)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r4 = r0.this$0
            java.util.Date r4 = r4.getCurPageStartDate(r11, r7)
            com.microtech.aidexx.utils.LogUtil$Companion r5 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "查询第一条 最小日期 "
            r11.<init>(r12)
            java.lang.StringBuilder r11 = r11.append(r4)
            java.lang.StringBuilder r8 = r11.append(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r11 = r0.this$0
            java.lang.StringBuilder r8 = r8.append(r11)
            java.lang.String r8 = r8.toString()
            r5.d(r8, r9)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r5 = r0.this$0
            com.microtech.aidexx.views.chart.ChartUtil r8 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            float r8 = r8.dateToX(r4)
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            r5.timeMin = r8
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            com.microtech.aidexx.views.chart.GlucoseChart$Companion r8 = com.microtech.aidexx.views.chart.GlucoseChart.Companion
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r11 = r0.this$0
            float r11 = r11.xMin()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r12 = r0.this$0
            float r12 = r12.xMax()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r14 = r0.this$0
            float r14 = r14.getLowerLimit()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r15 = r0.this$0
            float r15 = r15.getUpperLimit()
            java.util.List r8 = r8.generateLimitLines(r11, r12, r14, r15)
            java.util.Collection r8 = (java.util.Collection) r8
            r5.addAll(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            java.util.List r8 = r8.glucoseSets
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0271
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            java.util.List r8 = r8.glucoseSets
            com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r11 = new com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine
            r11.<init>()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r12 = r0.this$0
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            long r6 = r12.defaultLabel
            java.lang.StringBuilder r6 = r14.append(r6)
            r7 = 45
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r11.setLabel(r6)
            r8.add(r11)
        L_0x0271:
            com.microtech.aidexx.views.chart.GlucoseChart$Companion r6 = com.microtech.aidexx.views.chart.GlucoseChart.Companion
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            java.util.List r7 = r7.glucoseSets
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            float r8 = r8.getLowerLimit()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r11 = r0.this$0
            float r11 = r11.getUpperLimit()
            r6.formatGlucoseSetAfterInitData(r7, r8, r11)
            com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "数据加载完毕 "
            r7.<init>(r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.d(r7, r9)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            java.util.List r6 = r6.glucoseSets
            java.util.Collection r6 = (java.util.Collection) r6
            r5.addAll(r6)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r6 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r6 = r6.getShareUserInfo()
            if (r6 != 0) goto L_0x02d5
            com.microtech.aidexx.views.chart.GlucoseChart$Companion r6 = com.microtech.aidexx.views.chart.GlucoseChart.Companion
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CurrentGlucoseDataSet r7 = r7.curGlucoseStateSets
            java.util.List r7 = kotlin.collections.CollectionsKt.listOf(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            float r8 = r8.getLowerLimit()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r11 = r0.this$0
            float r11 = r11.getUpperLimit()
            r6.formatGlucoseSetAfterInitData(r7, r8, r11)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CurrentGlucoseDataSet r6 = r6.curGlucoseStateSets
            r5.add(r6)
        L_0x02d5:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CalDataSet r6 = r6.calSet
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            long r7 = r7.defaultLabel
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r6.setLabel(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.BgDataSet r6 = r6.bgSet
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CalDataSet r7 = r7.calSet
            java.lang.String r7 = r7.getLabel()
            r6.setLabel(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.IconDataSet r6 = r6.eventSet
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CalDataSet r7 = r7.calSet
            java.lang.String r7 = r7.getLabel()
            r6.setLabel(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.TimezoneDataSet r6 = r6.timezoneSet
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CalDataSet r7 = r7.calSet
            java.lang.String r7 = r7.getLabel()
            r6.setLabel(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.DstDataSet r6 = r6.dstSet
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CalDataSet r7 = r7.calSet
            java.lang.String r7 = r7.getLabel()
            r6.setLabel(r7)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.DstDataSet r7 = r7.dstSet
            r6.add(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.TimezoneDataSet r7 = r7.timezoneSet
            r6.add(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.CalDataSet r7 = r7.calSet
            r6.add(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.BgDataSet r7 = r7.bgSet
            r6.add(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.microtech.aidexx.views.chart.dataset.IconDataSet r7 = r7.eventSet
            r6.add(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r7 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r7 = r7.getCombinedData()
            com.github.mikephil.charting.data.ScatterData r8 = new com.github.mikephil.charting.data.ScatterData
            java.util.List r6 = (java.util.List) r6
            r8.<init>((java.util.List<com.github.mikephil.charting.interfaces.datasets.IScatterDataSet>) r6)
            r7.setData((com.github.mikephil.charting.data.ScatterData) r8)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r6 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r6 = r6.getCombinedData()
            com.github.mikephil.charting.data.LineData r7 = new com.github.mikephil.charting.data.LineData
            java.util.List r5 = (java.util.List) r5
            r7.<init>((java.util.List<com.github.mikephil.charting.interfaces.datasets.ILineDataSet>) r5)
            r6.setData((com.github.mikephil.charting.data.LineData) r7)
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            java.util.Date r6 = new java.util.Date
            java.util.Date r7 = new java.util.Date
            r7.<init>()
            long r7 = r7.getTime()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r11 = r0.this$0
            int r11 = r11.getGranularity()
            int r11 = r11 * r3
            long r11 = (long) r11
            r16 = 3600(0xe10, double:1.7786E-320)
            long r11 = r11 * r16
            r14 = 1000(0x3e8, float:1.401E-42)
            r37 = r4
            long r3 = (long) r14
            long r11 = r11 * r3
            long r7 = r7 - r11
            r6.<init>(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            java.lang.Float r3 = r3.timeMax
            if (r3 != 0) goto L_0x03c3
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            com.microtech.aidexx.views.chart.ChartUtil r4 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            float r4 = r4.dateToX(r5)
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r3.timeMax = r4
        L_0x03c3:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            java.lang.Float r3 = r3.timeMin
            if (r3 != 0) goto L_0x03da
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            com.microtech.aidexx.views.chart.ChartUtil r4 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            float r4 = r4.dateToX(r6)
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r3.timeMin = r4
        L_0x03da:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            android.util.ArrayMap r3 = r3.areas
            java.util.Map r3 = (java.util.Map) r3
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r4 = r0.this$0
            long r7 = r4.defaultLabel
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r7 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo
            r17 = r7
            java.util.Date r8 = new java.util.Date
            r18 = r8
            r8.<init>()
            r33 = 4094(0xffe, float:5.737E-42)
            r34 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r17.<init>(r18, r19, r20, r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r34)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = r0.this$0
            long r11 = r6.getTime()
            r7.setMinTs(r11)
            long r5 = r5.getTime()
            r7.setMaxTs(r5)
            java.lang.Float r5 = r8.timeMin
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            float r5 = r5.floatValue()
            r7.setMinX(r5)
            java.lang.Float r5 = r8.timeMax
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            float r5 = r5.floatValue()
            r7.setMaxX(r5)
            r3.put(r4, r7)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            com.github.mikephil.charting.data.CombinedData r3 = r3.getCombinedData()
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r0.L$0 = r2
            r0.L$1 = r13
            r5 = r37
            r0.L$2 = r5
            r6 = 5
            r0.label = r6
            java.lang.Object r3 = r10.emit(r3, r4)
            if (r3 != r1) goto L_0x045e
            return r1
        L_0x045e:
            r18 = r5
            r19 = r13
        L_0x0462:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r3 = r0.this$0
            r23 = r0
            kotlin.coroutines.Continuation r23 = (kotlin.coroutines.Continuation) r23
            r0.L$0 = r2
            r4 = 0
            r0.L$1 = r4
            r0.L$2 = r4
            r4 = 6
            r0.label = r4
            r20 = 0
            r21 = 0
            r24 = 12
            r25 = 0
            r17 = r3
            java.lang.Object r3 = com.microtech.aidexx.ui.main.home.chart.ChartViewModel.loadNextPageData$default(r17, r18, r19, r20, r21, r23, r24, r25)
            if (r3 != r1) goto L_0x0483
            return r1
        L_0x0483:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r3 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            java.lang.String r3 = r3.getCurShowUserId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x04c2
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "initData 查询区间数据 结束 "
            r3.<init>(r4)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r4 = r0.this$0
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.d(r3, r9)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r2 = r0.this$0
            r19 = r0
            kotlin.coroutines.Continuation r19 = (kotlin.coroutines.Continuation) r19
            r3 = 0
            r0.L$0 = r3
            r3 = 7
            r0.label = r3
            r17 = 1
            r18 = 0
            r20 = 2
            r21 = 0
            r16 = r2
            java.lang.Object r2 = com.microtech.aidexx.ui.main.home.chart.ChartViewModel.notifyToRefreshChart$default(r16, r17, r18, r19, r20, r21)
            if (r2 != r1) goto L_0x04d8
            return r1
        L_0x04c2:
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "initData 换人了不刷新图表 结束 "
            r3.<init>(r4)
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r4 = r0.this$0
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.d(r3, r9)
        L_0x04d8:
            com.microtech.aidexx.views.dialog.Dialogs r2 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r2.dismissWait()
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r2 = r0.this$0
            r3 = 1
            r2.setDataInit(r3)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r4 = 0
            r0.L$0 = r4
            r4 = 8
            r0.label = r4
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r4, r2)
            if (r2 != r1) goto L_0x04f6
            return r1
        L_0x04f6:
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r1 = r0.this$0
            r1.setDataLoaded(r3)
            com.microtech.aidexx.views.chart.GlucoseChart$Companion r1 = com.microtech.aidexx.views.chart.GlucoseChart.Companion
            com.microtech.aidexx.ui.main.home.chart.ChartViewModel r2 = r0.this$0
            boolean r2 = r2.isDataLoaded()
            r1.setIsInit(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

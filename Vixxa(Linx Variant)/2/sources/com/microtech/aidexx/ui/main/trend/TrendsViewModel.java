package com.microtech.aidexx.ui.main.trend;

import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.FormatUtil;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.views.chart.ChartUtil;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J#\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u001eH\u0002J!\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u00100J\u001f\u00101\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0011H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020\u0014J\u0006\u00106\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u0014J\u0006\u00108\u001a\u00020\u0014R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/TrendsViewModel;", "Lcom/microtech/aidexx/base/BaseViewModel;", "()V", "cgatFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/microtech/aidexx/ui/main/trend/TrendsInfo;", "getCgatFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "combinedData", "Lcom/github/mikephil/charting/data/CombinedData;", "getCombinedData", "()Lcom/github/mikephil/charting/data/CombinedData;", "setCombinedData", "(Lcom/github/mikephil/charting/data/CombinedData;)V", "glucoseSensorEntryMap", "", "", "", "Lcom/github/mikephil/charting/data/Entry;", "<set-?>", "", "lowerLimit", "getLowerLimit", "()F", "oneDigitFormat", "Ljava/text/DecimalFormat;", "oneDigitFormatWithLocale", "upperLimit", "getUpperLimit", "addLineData", "", "histories", "", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "lineData", "Lcom/github/mikephil/charting/data/LineData;", "color", "", "getValidArray", "", "array", "ratio", "([DLjava/lang/Float;)[D", "resetChartData", "runCgat", "startDate", "Ljava/util/Date;", "endDate", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMultiChartData", "mutableList", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "xMargin", "xMax", "xMin", "xRange", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsViewModel.kt */
public final class TrendsViewModel extends BaseViewModel {
    private final MutableStateFlow<TrendsInfo> cgatFlow = StateFlowKt.MutableStateFlow(null);
    public CombinedData combinedData;
    private Map<String, List<Entry>> glucoseSensorEntryMap = new LinkedHashMap();
    private float lowerLimit = GlucoseUtilKt.toGlucoseValue(70.200005f);
    /* access modifiers changed from: private */
    public DecimalFormat oneDigitFormat = FormatUtil.INSTANCE.getOneDigitFormat();
    /* access modifiers changed from: private */
    public DecimalFormat oneDigitFormatWithLocale = FormatUtil.INSTANCE.getOneDigitFormatWithLocale();
    private float upperLimit = GlucoseUtilKt.toGlucoseValue(180.0f);

    public final float xMargin() {
        return 2.0f;
    }

    public final float xRange() {
        return 24.0f;
    }

    public final MutableStateFlow<TrendsInfo> getCgatFlow() {
        return this.cgatFlow;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runCgat(java.util.Date r8, java.util.Date r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$1 r0 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$1 r0 = new com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b3
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            java.lang.Object r8 = r0.L$2
            com.microtech.aidexx.ui.main.trend.DataInfoForTrends r8 = (com.microtech.aidexx.ui.main.trend.DataInfoForTrends) r8
            java.lang.Object r9 = r0.L$1
            com.microtech.aidexx.ui.main.trend.TrendsInfo r9 = (com.microtech.aidexx.ui.main.trend.TrendsInfo) r9
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.ui.main.trend.TrendsViewModel r2 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009b
        L_0x004a:
            java.lang.Object r8 = r0.L$1
            com.microtech.aidexx.ui.main.trend.TrendsInfo r8 = (com.microtech.aidexx.ui.main.trend.TrendsInfo) r8
            java.lang.Object r9 = r0.L$0
            com.microtech.aidexx.ui.main.trend.TrendsViewModel r9 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r9
            r9 = r8
            goto L_0x0076
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r10)
            com.microtech.aidexx.ui.main.trend.TrendsInfo r10 = new com.microtech.aidexx.ui.main.trend.TrendsInfo
            r10.<init>()
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager$Companion r2 = com.microtech.aidexx.ui.main.trend.MultiDayBGManager.Companion
            com.microtech.aidexx.ui.main.trend.MultiDayBGManager r2 = r2.getInstance()
            r0.L$0 = r7
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r8 = r2.findDataByDays(r8, r9, r0)
            if (r8 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r2 = r7
            r9 = r10
            r10 = r8
        L_0x0076:
            r8 = r10
            com.microtech.aidexx.ui.main.trend.DataInfoForTrends r8 = (com.microtech.aidexx.ui.main.trend.DataInfoForTrends) r8
            int r10 = r8.getTotalHistory()
            if (r10 <= 0) goto L_0x009b
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$2$1 r5 = new com.microtech.aidexx.ui.main.trend.TrendsViewModel$runCgat$2$1
            r5.<init>(r8, r9, r2, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r5, r0)
            if (r10 != r1) goto L_0x009b
            return r1
        L_0x009b:
            java.util.List r8 = r8.getMultiDayBgItemList()
            r9.setMultiDayHistory(r8)
            kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.ui.main.trend.TrendsInfo> r8 = r2.cgatFlow
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsViewModel.runCgat(java.util.Date, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ double[] getValidArray$default(TrendsViewModel trendsViewModel, double[] dArr, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Float.valueOf(0.75f);
        }
        return trendsViewModel.getValidArray(dArr, f);
    }

    private final double[] getValidArray(double[] dArr, Float f) {
        int i = 0;
        for (double isNaN : dArr) {
            if (Double.isNaN(isNaN)) {
                i++;
            }
        }
        Intrinsics.checkNotNull(f);
        if (((float) i) > ((float) dArr.length) * (((float) 1) - f.floatValue())) {
            return null;
        }
        return dArr;
    }

    public final CombinedData getCombinedData() {
        CombinedData combinedData2 = this.combinedData;
        if (combinedData2 != null) {
            return combinedData2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("combinedData");
        return null;
    }

    public final void setCombinedData(CombinedData combinedData2) {
        Intrinsics.checkNotNullParameter(combinedData2, "<set-?>");
        this.combinedData = combinedData2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateMultiChartData(java.util.List<com.microtech.aidexx.ui.main.trend.MultiDayBgItem> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$1 r0 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$1 r0 = new com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r7 = r0.L$1
            com.github.mikephil.charting.data.LineData r7 = (com.github.mikephil.charting.data.LineData) r7
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.ui.main.trend.TrendsViewModel r0 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006f
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.github.mikephil.charting.data.CombinedData r8 = r6.combinedData
            if (r8 != 0) goto L_0x004a
            com.github.mikephil.charting.data.CombinedData r8 = new com.github.mikephil.charting.data.CombinedData
            r8.<init>()
            r6.setCombinedData(r8)
            goto L_0x004d
        L_0x004a:
            r6.resetChartData()
        L_0x004d:
            com.github.mikephil.charting.data.LineData r8 = new com.github.mikephil.charting.data.LineData
            r8.<init>()
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$2 r4 = new com.microtech.aidexx.ui.main.trend.TrendsViewModel$updateMultiChartData$2
            r5 = 0
            r4.<init>(r7, r6, r8, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r0 = r6
            r7 = r8
        L_0x006f:
            com.github.mikephil.charting.data.CombinedData r8 = r0.getCombinedData()
            r8.setData((com.github.mikephil.charting.data.LineData) r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsViewModel.updateMultiChartData(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00af, code lost:
        r15 = r6.parse(r14.getAppTime());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addLineData(java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity> r20, com.github.mikephil.charting.data.LineData r21, int r22) {
        /*
            r19 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x01a2
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0013
            goto L_0x01a2
        L_0x0013:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            java.util.Date r4 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r4)
            long r4 = r4.getTime()
            boolean r6 = com.microtech.aidexx.common.ExtendsKt.useAppTime()
            if (r6 == 0) goto L_0x003e
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat
            java.lang.String r7 = "yyyy-MM-dd HH:mm:ss"
            r6.<init>(r7)
            com.microtech.aidexx.utils.TimeUtils r7 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            java.util.TimeZone r7 = r7.getCDFTimezone()
            r6.setTimeZone(r7)
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            boolean r7 = com.microtech.aidexx.common.ExtendsKt.useAppTime()
            r8 = 0
            if (r7 == 0) goto L_0x007b
            if (r6 == 0) goto L_0x0063
            java.lang.Object r7 = r0.get(r8)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r7 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r7
            java.lang.String r7 = r7.getAppTime()
            java.util.Date r7 = r6.parse(r7)
            if (r7 == 0) goto L_0x0063
            java.util.Date r7 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r7)
            if (r7 == 0) goto L_0x0063
            long r9 = r7.getTime()
            goto L_0x0092
        L_0x0063:
            java.util.Date r7 = new java.util.Date
            java.lang.Object r9 = r0.get(r8)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r9 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r9
            long r9 = r9.getTimestamp()
            r7.<init>(r9)
            java.util.Date r7 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r7)
            long r9 = r7.getTime()
            goto L_0x0092
        L_0x007b:
            java.util.Date r7 = new java.util.Date
            java.lang.Object r9 = r0.get(r8)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r9 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r9
            long r9 = r9.getTimestamp()
            r7.<init>(r9)
            java.util.Date r7 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r7)
            long r9 = r7.getTime()
        L_0x0092:
            java.util.Iterator r0 = r20.iterator()
            r11 = 0
            r7 = r8
        L_0x0099:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x016d
            int r13 = r7 + 1
            java.lang.Object r14 = r0.next()
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r14 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r14
            boolean r15 = com.microtech.aidexx.common.ExtendsKt.useAppTime()
            if (r15 == 0) goto L_0x00c3
            if (r6 == 0) goto L_0x00be
            java.lang.String r15 = r14.getAppTime()
            java.util.Date r15 = r6.parse(r15)
            if (r15 == 0) goto L_0x00be
            long r15 = r15.getTime()
            goto L_0x00c7
        L_0x00be:
            long r15 = r14.getTimestamp()
            goto L_0x00c7
        L_0x00c3:
            long r15 = r14.getTimestamp()
        L_0x00c7:
            long r15 = r15 + r4
            long r15 = r15 - r9
            r17 = r9
            r8 = r15
            java.lang.Float r10 = r14.getGlucose()
            if (r10 != 0) goto L_0x00d7
            r7 = r13
            r9 = r17
            r8 = 0
            goto L_0x0099
        L_0x00d7:
            java.lang.Float r10 = r14.getGlucose()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r10 = r10.floatValue()
            r15 = 1108344832(0x42100000, float:36.0)
            int r10 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x00f3
            java.lang.Float r10 = r14.getGlucose()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            float r15 = r10.floatValue()
        L_0x00f3:
            r10 = 1142292480(0x44160000, float:600.0)
            int r10 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x00fb
            r15 = 1138819072(0x43e10000, float:450.0)
        L_0x00fb:
            com.github.mikephil.charting.data.Entry r10 = new com.github.mikephil.charting.data.Entry
            r20 = r0
            com.microtech.aidexx.views.chart.ChartUtil r0 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            float r0 = r0.millSecondToX(r8)
            com.microtech.aidexx.utils.UnitManager r8 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            com.microtech.aidexx.utils.UnitManager$GlucoseUnit r8 = r8.getGlucoseUnit()
            int r8 = r8.getIndex()
            r9 = 1
            if (r8 != r9) goto L_0x0113
            goto L_0x0117
        L_0x0113:
            float r15 = com.microtech.aidexx.utils.GlucoseUtilKt.toGlucoseValue((float) r15)
        L_0x0117:
            r10.<init>(r0, r15)
            long r8 = r14.getTimestamp()
            long r8 = r8 - r11
            long r8 = java.lang.Math.abs(r8)
            int r0 = com.microtech.aidexx.common.ExtendsKt.millisToMinutes(r8)
            r8 = 10
            if (r0 <= r8) goto L_0x015d
            if (r7 == 0) goto L_0x015d
            com.github.mikephil.charting.data.LineDataSet r0 = new com.github.mikephil.charting.data.LineDataSet
            java.lang.String r7 = ""
            r0.<init>(r3, r7)
            r7 = 0
            r0.setDrawCircles(r7)
            com.github.mikephil.charting.components.YAxis$AxisDependency r3 = com.github.mikephil.charting.components.YAxis.AxisDependency.LEFT
            r0.setAxisDependency(r3)
            r3 = 1070386381(0x3fcccccd, float:1.6)
            r0.setLineWidth(r3)
            r0.setColor(r2)
            r0.setDrawIcons(r7)
            r0.setDrawValues(r7)
            r0.setHighlightEnabled(r7)
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = (com.github.mikephil.charting.interfaces.datasets.IDataSet) r0
            r1.addDataSet(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r3 = r0
            goto L_0x015e
        L_0x015d:
            r7 = 0
        L_0x015e:
            r3.add(r10)
            long r11 = r14.getTimestamp()
            r0 = r20
            r8 = r7
            r7 = r13
            r9 = r17
            goto L_0x0099
        L_0x016d:
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x01a2
            com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r0 = new com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine
            r0.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r6
            long r4 = r4 / r6
            com.microtech.aidexx.views.chart.ChartUtil r6 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            r7 = 300(0x12c, float:4.2E-43)
            long r7 = (long) r7
            long r7 = r7 + r4
            float r6 = r6.secondToX(r7)
            com.microtech.aidexx.views.chart.ChartUtil r7 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            float r4 = r7.secondToX(r4)
            float r6 = r6 - r4
            r0.setBreakInterval(r6)
            r0.setColor(r2)
            r0.addEntries(r3)
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = (com.github.mikephil.charting.interfaces.datasets.IDataSet) r0
            r1.addDataSet(r0)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsViewModel.addLineData(java.util.List, com.github.mikephil.charting.data.LineData, int):void");
    }

    private final void resetChartData() {
        this.glucoseSensorEntryMap.clear();
        getCombinedData().clearValues();
    }

    public final float xMin() {
        return xMax() - xRange();
    }

    public final float xMax() {
        return ChartUtil.INSTANCE.secondToX(ExtendsKt.getEndOfTheDay(new Date()).getTime() / ((long) 1000));
    }

    public final float getUpperLimit() {
        return GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHyper());
    }

    public final float getLowerLimit() {
        return GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHypo());
    }
}

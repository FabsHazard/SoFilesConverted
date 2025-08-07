package com.microtech.aidexx.ui.main.history;

import androidx.lifecycle.ViewModelKt;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.data.resource.SpecificationModel;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.event.DietDetail;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseDetail;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinDetail;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.ui.main.history.eventHistory.ChartModel;
import com.microtech.aidexx.ui.main.history.eventHistory.CountModel;
import com.microtech.aidexx.ui.main.history.eventHistory.ProportionModel;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.views.chart.ChartUtil;
import com.microtech.aidexx.views.chart.GlucoseChart;
import com.microtech.aidexx.views.chart.dataset.BgDataSet;
import com.microtech.aidexx.views.chart.dataset.CalDataSet;
import com.microtech.aidexx.views.chart.dataset.EventEntryConverterKt;
import com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine;
import com.microtech.aidexx.views.chart.dataset.IconDataSet;
import com.microtechmd.cgat.CGATools;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u0000 [2\u00020\u0001:\u0001[B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00102\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001e\u00104\u001a\u0002032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u00106\u001a\u000207H\u0002J\u001c\u00108\u001a\u0002032\u0006\u00106\u001a\u0002092\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002J4\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\n2\u0006\u00106\u001a\u0002092\u001a\b\u0002\u0010<\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>0=H\u0002J\u001a\u0010?\u001a\u0002032\u0006\u0010;\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u001e\u0010@\u001a\u0002032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060A2\u0006\u00106\u001a\u000209H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020>H\u0002J\u0010\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020FH\u0002J\u0011\u0010G\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u0010HJ/\u0010I\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000209\u0018\u00010\u00050\u00052\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010LJ/\u0010I\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000209\u0018\u00010\u00050\u00052\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010MJ\u0019\u0010N\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u0019\u0010P\u001a\u0002032\u0006\u00106\u001a\u000209H@ø\u0001\u0000¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u000203H\u0002J\u0006\u0010S\u001a\u000203J\u0006\u0010T\u001a\u000203J\u000e\u0010U\u001a\u0002032\u0006\u0010V\u001a\u00020\fJ\u0006\u0010W\u001a\u00020(J\u0006\u0010X\u001a\u00020(J\u0006\u0010Y\u001a\u00020(J\u0006\u0010Z\u001a\u00020(R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R \u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0#X\u000e¢\u0006\u0002\n\u0000R \u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0013R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013R \u00100\u001a\u00020(2\u0006\u0010'\u001a\u00020(8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "Lcom/microtech/aidexx/base/BaseViewModel;", "()V", "_alertModel", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "_chartModel", "Lcom/microtech/aidexx/ui/main/history/eventHistory/ChartModel;", "_countModel", "Lcom/microtech/aidexx/ui/main/history/eventHistory/CountModel;", "_curDate", "Ljava/util/Date;", "_proportionModel", "Lcom/microtech/aidexx/ui/main/history/eventHistory/ProportionModel;", "_recordsModel", "alertModel", "Lkotlinx/coroutines/flow/StateFlow;", "getAlertModel", "()Lkotlinx/coroutines/flow/StateFlow;", "bgSet", "Lcom/microtech/aidexx/views/chart/dataset/BgDataSet;", "calSet", "Lcom/microtech/aidexx/views/chart/dataset/CalDataSet;", "chartModel", "getChartModel", "combinedData", "Lcom/github/mikephil/charting/data/CombinedData;", "countModel", "getCountModel", "curDate", "getCurDate", "eventSet", "Lcom/microtech/aidexx/views/chart/dataset/IconDataSet;", "glucoseSensorEntryMap", "", "", "", "Lcom/github/mikephil/charting/data/Entry;", "<set-?>", "", "lowerLimit", "getLowerLimit", "()F", "proportionModel", "getProportionModel", "recordsModel", "getRecordsModel", "upperLimit", "getUpperLimit", "calculateCgmWave", "", "calculateForAlert", "records", "event", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "calculateForChart", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "calculateForCount", "model", "plusOrMinus", "Lkotlin/Function2;", "", "calculateForProportion", "calculateForRecords", "Ljava/util/concurrent/CopyOnWriteArrayList;", "formatTimeText", "minute", "jumpDays", "days", "", "loadAndCalculateData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCurDateAllData", "startDate", "endDate", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyRefreshChart", "(Lcom/microtech/aidexx/ui/main/history/eventHistory/ChartModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDelete", "(Lcom/microtech/aidexx/db/entity/BaseEventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetChartData", "toNextDay", "toPreviousDay", "updateDate", "selectedDate", "xMargin", "xMax", "xMin", "xRange", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryViewModel.kt */
public final class HistoryViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float HIGHEST_GLUCOSE_MG = 450.0f;
    private static final float LOWEST_GLUCOSE_MG = 36.0f;
    /* access modifiers changed from: private */
    public static final String TAG = "HistoryViewModel";
    private static final float TIP_GLUCOSE_MG = 414.0f;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<HistoryDetailModel>> _alertModel;
    private final MutableStateFlow<ChartModel> _chartModel;
    /* access modifiers changed from: private */
    public final MutableStateFlow<CountModel> _countModel;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Date> _curDate;
    /* access modifiers changed from: private */
    public final MutableStateFlow<ProportionModel> _proportionModel;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<HistoryDetailModel>> _recordsModel;
    private final StateFlow<List<HistoryDetailModel>> alertModel;
    private final BgDataSet bgSet = new BgDataSet();
    private final CalDataSet calSet = new CalDataSet();
    private final StateFlow<ChartModel> chartModel;
    /* access modifiers changed from: private */
    public CombinedData combinedData;
    private final StateFlow<CountModel> countModel;
    private final StateFlow<Date> curDate;
    private final IconDataSet eventSet = new IconDataSet();
    private Map<String, List<Entry>> glucoseSensorEntryMap = new LinkedHashMap();
    private float lowerLimit = GlucoseUtilKt.toGlucoseValue(70.200005f);
    private final StateFlow<ProportionModel> proportionModel;
    private final StateFlow<List<HistoryDetailModel>> recordsModel;
    private float upperLimit = GlucoseUtilKt.toGlucoseValue(180.0f);

    public final float xMargin() {
        return 2.0f;
    }

    public final float xRange() {
        return 24.0f;
    }

    public HistoryViewModel() {
        MutableStateFlow<Date> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._curDate = MutableStateFlow;
        this.curDate = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<CountModel> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._countModel = MutableStateFlow2;
        this.countModel = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<ProportionModel> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._proportionModel = MutableStateFlow3;
        this.proportionModel = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<List<HistoryDetailModel>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._recordsModel = MutableStateFlow4;
        this.recordsModel = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<ChartModel> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._chartModel = MutableStateFlow5;
        this.chartModel = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<List<HistoryDetailModel>> MutableStateFlow6 = StateFlowKt.MutableStateFlow(null);
        this._alertModel = MutableStateFlow6;
        this.alertModel = FlowKt.asStateFlow(MutableStateFlow6);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryViewModel$Companion;", "", "()V", "HIGHEST_GLUCOSE_MG", "", "LOWEST_GLUCOSE_MG", "TAG", "", "kotlin.jvm.PlatformType", "TIP_GLUCOSE_MG", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HistoryViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final StateFlow<Date> getCurDate() {
        return this.curDate;
    }

    public final void updateDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "selectedDate");
        if (date.getTime() <= System.currentTimeMillis()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new HistoryViewModel$updateDate$1(this, date, (Continuation<? super HistoryViewModel$updateDate$1>) null), 3, (Object) null);
        }
    }

    public final void toNextDay() {
        jumpDays(1);
    }

    public final void toPreviousDay() {
        jumpDays(-1);
    }

    private final void jumpDays(int i) {
        Date value = this._curDate.getValue();
        if (value == null) {
            value = new Date();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(value.getTime());
        instance.add(5, i);
        updateDate(new Date(instance.getTimeInMillis()));
    }

    public final StateFlow<CountModel> getCountModel() {
        return this.countModel;
    }

    public final StateFlow<ProportionModel> getProportionModel() {
        return this.proportionModel;
    }

    public final StateFlow<List<HistoryDetailModel>> getRecordsModel() {
        return this.recordsModel;
    }

    public final StateFlow<ChartModel> getChartModel() {
        return this.chartModel;
    }

    public final StateFlow<List<HistoryDetailModel>> getAlertModel() {
        return this.alertModel;
    }

    /* access modifiers changed from: private */
    public final Object loadAndCalculateData(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new HistoryViewModel$loadAndCalculateData$2(this, (Continuation<? super HistoryViewModel$loadAndCalculateData$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object notifyRefreshChart(ChartModel chartModel2, Continuation<? super Unit> continuation) {
        Object obj;
        ChartModel chartModel3 = chartModel2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(GlucoseChart.Companion.generateLimitLines(xMin(), xMax(), getLowerLimit(), getUpperLimit()));
        CombinedData combinedData2 = null;
        if (!this.glucoseSensorEntryMap.isEmpty()) {
            Map<String, List<Entry>> map = this.glucoseSensorEntryMap;
            Collection arrayList2 = new ArrayList(map.size());
            for (Map.Entry next : map.entrySet()) {
                List list = (List) next.getValue();
                String str = (String) next.getKey();
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    ILineDataSet iLineDataSet = (ILineDataSet) obj;
                    if ((iLineDataSet instanceof GlucoseDataSetLine) && Intrinsics.areEqual((Object) ((GlucoseDataSetLine) iLineDataSet).getLabel(), (Object) str)) {
                        break;
                    }
                }
                GlucoseDataSetLine glucoseDataSetLine = (GlucoseDataSetLine) obj;
                if (glucoseDataSetLine == null) {
                    HistoryViewModel historyViewModel = this;
                    glucoseDataSetLine = new GlucoseDataSetLine();
                    glucoseDataSetLine.setLabel(str);
                    GlucoseChart.Companion.formatGlucoseSetAfterInitData(CollectionsKt.listOf(glucoseDataSetLine), getLowerLimit(), getUpperLimit());
                    arrayList.add(glucoseDataSetLine);
                }
                int size = list.size();
                float[] fArr = new float[size];
                int i = 0;
                for (Object next2 : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    fArr[i] = ((Entry) next2).getY();
                    i = i2;
                }
                float[] smoothGauss = CGATools.smoothGauss(fArr, size, 31);
                Intrinsics.checkNotNull(smoothGauss);
                int length = smoothGauss.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    float f = smoothGauss[i3];
                    int i5 = i4 + 1;
                    Entry entry = (Entry) list.get(i4);
                    entry.setData(Boxing.boxFloat(entry.getY()));
                    entry.setY(f);
                    glucoseDataSetLine.addEntryOrdered(entry);
                    i3++;
                    i4 = i5;
                }
                arrayList2.add(Unit.INSTANCE);
            }
            List list2 = (List) arrayList2;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(this.calSet);
        arrayList3.add(this.bgSet);
        arrayList3.add(this.eventSet);
        CombinedData combinedData3 = this.combinedData;
        if (combinedData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("combinedData");
            combinedData3 = null;
        }
        LineData lineData = new LineData((List<ILineDataSet>) arrayList);
        List<ILineDataSet> dataSets = lineData.getDataSets();
        Intrinsics.checkNotNullExpressionValue(dataSets, "getDataSets(...)");
        for (ILineDataSet iLineDataSet2 : dataSets) {
            iLineDataSet2.setDrawIcons(false);
            iLineDataSet2.setDrawValues(false);
        }
        combinedData3.setData(lineData);
        CombinedData combinedData4 = this.combinedData;
        if (combinedData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("combinedData");
            combinedData4 = null;
        }
        combinedData4.setData(new ScatterData((List<IScatterDataSet>) arrayList3));
        CombinedData combinedData5 = this.combinedData;
        if (combinedData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("combinedData");
        } else {
            combinedData2 = combinedData5;
        }
        chartModel3.setCombinedData(combinedData2);
        Object emit = this._chartModel.emit(chartModel3, continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    static /* synthetic */ void calculateForCount$default(HistoryViewModel historyViewModel, CountModel countModel2, BaseEventEntity baseEventEntity, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = HistoryViewModel$calculateForCount$1.INSTANCE;
        }
        historyViewModel.calculateForCount(countModel2, baseEventEntity, function2);
    }

    private final void calculateForCount(CountModel countModel2, BaseEventEntity baseEventEntity, Function2<? super Double, ? super Double, Double> function2) {
        Object obj;
        boolean z = baseEventEntity instanceof DietEntity;
        double d = Utils.DOUBLE_EPSILON;
        if (z) {
            for (DietDetail dietDetail : ((DietEntity) baseEventEntity).getExpandList()) {
                Double carb = countModel2.getCarb();
                countModel2.setCarb(function2.invoke(Double.valueOf(carb != null ? carb.doubleValue() : 0.0d), Double.valueOf(dietDetail.getCarbohydrate())));
                Double protein = countModel2.getProtein();
                countModel2.setProtein(function2.invoke(Double.valueOf(protein != null ? protein.doubleValue() : 0.0d), Double.valueOf(dietDetail.getProtein())));
                Double fat = countModel2.getFat();
                countModel2.setFat(function2.invoke(Double.valueOf(fat != null ? fat.doubleValue() : 0.0d), Double.valueOf(dietDetail.getFat())));
            }
        } else if (baseEventEntity instanceof ExerciseEntity) {
            for (ExerciseDetail exerciseDetail : ((ExerciseEntity) baseEventEntity).getExpandList()) {
                Double exerciseTime = countModel2.getExerciseTime();
                Double valueOf = Double.valueOf(exerciseTime != null ? exerciseTime.doubleValue() : 0.0d);
                double quantity = exerciseDetail.getQuantity();
                Iterator it = EventUnitManager.INSTANCE.getTimeUnitList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((SpecificationModel) obj).getCode() == exerciseDetail.getUnit()) {
                        break;
                    }
                }
                SpecificationModel specificationModel = (SpecificationModel) obj;
                countModel2.setExerciseTime(function2.invoke(valueOf, Double.valueOf(quantity * (specificationModel != null ? specificationModel.getRatio() : 1.0d))));
            }
        } else if (baseEventEntity instanceof MedicationEntity) {
            Double medicationTimes = countModel2.getMedicationTimes();
            if (medicationTimes != null) {
                d = medicationTimes.doubleValue();
            }
            countModel2.setMedicationTimes(function2.invoke(Double.valueOf(d), Double.valueOf(1.0d)));
        } else if (baseEventEntity instanceof InsulinEntity) {
            for (InsulinDetail insulinDetail : ((InsulinEntity) baseEventEntity).getExpandList()) {
                Double insulinTotal = countModel2.getInsulinTotal();
                countModel2.setInsulinTotal(function2.invoke(Double.valueOf(insulinTotal != null ? insulinTotal.doubleValue() : 0.0d), Double.valueOf(insulinDetail.getQuantity())));
            }
        }
    }

    static /* synthetic */ void calculateForChart$default(HistoryViewModel historyViewModel, BaseEventEntity baseEventEntity, ChartModel chartModel2, int i, Object obj) {
        if ((i & 2) != 0) {
            chartModel2 = null;
        }
        historyViewModel.calculateForChart(baseEventEntity, chartModel2);
    }

    /* access modifiers changed from: private */
    public final void calculateForChart(BaseEventEntity baseEventEntity, ChartModel chartModel2) {
        Float glucose;
        if (baseEventEntity instanceof RealCgmHistoryEntity) {
            RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) baseEventEntity;
            if (realCgmHistoryEntity.getSensorId() != null) {
                String genChartSetLabel = realCgmHistoryEntity.genChartSetLabel();
                if (this.glucoseSensorEntryMap.containsKey(genChartSetLabel)) {
                    List list = this.glucoseSensorEntryMap.get(genChartSetLabel);
                    if (list != null) {
                        list.add(EventEntryConverterKt.toChartEntry$default(baseEventEntity, (Function0) null, 1, (Object) null));
                    }
                } else {
                    this.glucoseSensorEntryMap.put(genChartSetLabel, CollectionsKt.mutableListOf(EventEntryConverterKt.toChartEntry$default(baseEventEntity, (Function0) null, 1, (Object) null)));
                }
            }
            if (chartModel2 != null && (glucose = realCgmHistoryEntity.getGlucose()) != null) {
                float floatValue = glucose.floatValue();
                if (chartModel2.getCgmHighestGlucose() == 0.0f || chartModel2.getCgmHighestGlucose() <= floatValue) {
                    chartModel2.setCgmHighestGlucose(floatValue);
                    chartModel2.setCgmHighestTime(baseEventEntity.convertToCurZoneTs());
                }
                if (chartModel2.getCgmLowestGlucose() == 0.0f || chartModel2.getCgmLowestGlucose() >= floatValue) {
                    chartModel2.setCgmLowestGlucose(floatValue);
                    chartModel2.setCgmLowestTime(baseEventEntity.convertToCurZoneTs());
                }
            }
        } else if (baseEventEntity instanceof CalibrateEntity) {
            this.calSet.addEntryOrdered(EventEntryConverterKt.toChartEntry$default(baseEventEntity, (Function0) null, 1, (Object) null));
        } else if (baseEventEntity instanceof BloodGlucoseEntity) {
            this.bgSet.addEntryOrdered(EventEntryConverterKt.toChartEntry$default(baseEventEntity, (Function0) null, 1, (Object) null));
        } else {
            this.eventSet.addEntryOrdered(EventEntryConverterKt.toChartEntry$default(baseEventEntity, (Function0) null, 1, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public final void calculateCgmWave(ChartModel chartModel2) {
        double d;
        String str;
        ChartModel chartModel3 = chartModel2;
        if (chartModel2.getHasWave()) {
            float cgmHighestGlucose = chartModel2.getCgmHighestGlucose();
            float cgmLowestGlucose = chartModel2.getCgmLowestGlucose();
            int i = UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L ? 1 : 0;
            String scale$default = ExtendsKt.setScale$default(Float.valueOf(GlucoseUtilKt.toGlucoseValue(RangesKt.coerceAtMost(cgmHighestGlucose, 450.0f))), i, false, 2, (Object) null);
            String scale$default2 = ExtendsKt.setScale$default(Float.valueOf(GlucoseUtilKt.toGlucoseValue(RangesKt.coerceAtLeast(cgmLowestGlucose, 36.0f))), i, false, 2, (Object) null);
            chartModel3.setCgmHighestTitleText(chartModel2.getCgmHighestTitleText() + '(' + ExtendsKt.hourMinute$default(chartModel2.getCgmHighestTime(), (String) null, 1, (Object) null) + ')');
            int i2 = (cgmHighestGlucose > 450.0f ? 1 : (cgmHighestGlucose == 450.0f ? 0 : -1));
            if (i2 > 0) {
                scale$default = ">" + scale$default;
            }
            chartModel3.setCgmHighestText(scale$default);
            String str2 = scale$default2;
            chartModel3.setCgmLowestTitleText(chartModel2.getCgmLowestTitleText() + '(' + ExtendsKt.hourMinute$default(chartModel2.getCgmLowestTime(), (String) null, 1, (Object) null) + ')');
            int i3 = (cgmLowestGlucose > 36.0f ? 1 : (cgmLowestGlucose == 36.0f ? 0 : -1));
            chartModel3.setCgmLowestText(i3 < 0 ? "<" + str2 : str2);
            if (LanguageResourceManager.INSTANCE.isLocalNumber()) {
                d = (double) (GlucoseUtilKt.toGlucoseValue(RangesKt.coerceAtMost(cgmHighestGlucose, 450.0f)) - GlucoseUtilKt.toGlucoseValue(RangesKt.coerceAtLeast(cgmLowestGlucose, 36.0f)));
            } else {
                d = Double.parseDouble(StringsKt.replace$default(ExtendsKt.setScale(Float.valueOf(GlucoseUtilKt.toGlucoseValue(RangesKt.coerceAtMost(cgmHighestGlucose, 450.0f))), i, false), ",", ".", false, 4, (Object) null)) - Double.parseDouble(StringsKt.replace$default(ExtendsKt.setScale(Float.valueOf(GlucoseUtilKt.toGlucoseValue(RangesKt.coerceAtLeast(cgmLowestGlucose, 36.0f))), i, false), ",", ".", false, 4, (Object) null));
            }
            int i4 = (cgmHighestGlucose > 450.0f ? 1 : (cgmHighestGlucose == 450.0f ? 0 : -1));
            if (i4 <= 0 && cgmLowestGlucose >= 36.0f) {
                str = ExtendsKt.setScale$default(Double.valueOf(d), i, false, 2, (Object) null);
            } else if (i2 >= 0 && i3 < 0) {
                str = ">" + ExtendsKt.setScale$default(Float.valueOf(GlucoseUtilKt.toGlucoseValue((float) TIP_GLUCOSE_MG)), i, false, 2, (Object) null);
            } else if (i2 > 0 && cgmLowestGlucose >= 36.0f) {
                str = ">" + ExtendsKt.setScale$default(Double.valueOf(RangesKt.coerceAtMost(d, (double) GlucoseUtilKt.toGlucoseValue((float) TIP_GLUCOSE_MG))), i, false, 2, (Object) null);
            } else if (i4 > 0 || i3 >= 0) {
                str = chartModel2.getCgmWaveText();
            } else {
                str = ">" + ExtendsKt.setScale$default(Double.valueOf(RangesKt.coerceAtMost(d, (double) GlucoseUtilKt.toGlucoseValue((float) TIP_GLUCOSE_MG))), i, false, 2, (Object) null);
            }
            chartModel3.setCgmWaveText(str);
        }
    }

    /* access modifiers changed from: private */
    public final void calculateForProportion(ProportionModel proportionModel2, RealCgmHistoryEntity realCgmHistoryEntity) {
        Integer num;
        int i;
        if (realCgmHistoryEntity != null) {
            Float glucose = realCgmHistoryEntity.getGlucose();
            if (glucose != null) {
                float floatValue = glucose.floatValue();
                if (floatValue >= ThresholdManager.INSTANCE.getCurUserHyper()) {
                    i = proportionModel2.getHighCount();
                    proportionModel2.setHighCount(i + 1);
                } else if (floatValue <= ThresholdManager.INSTANCE.getCurUserHypo()) {
                    i = proportionModel2.getLowCount();
                    proportionModel2.setLowCount(i + 1);
                } else {
                    i = proportionModel2.getNormalCount();
                    proportionModel2.setNormalCount(i + 1);
                }
                num = Integer.valueOf(i);
            } else {
                num = null;
            }
            if (num != null) {
                return;
            }
        }
        HistoryViewModel historyViewModel = this;
        double highCount = (double) (proportionModel2.getHighCount() + proportionModel2.getLowCount() + proportionModel2.getNormalCount());
        if (highCount > Utils.DOUBLE_EPSILON) {
            proportionModel2.setTotalCount((int) highCount);
            double d = (double) 100;
            proportionModel2.setHighCountPercent(MathKt.roundToInt((((double) proportionModel2.getHighCount()) / highCount) * d));
            proportionModel2.setHighCountPercentStr(ExtendsKt.getNumberFormatWithLocale().format(Integer.valueOf(proportionModel2.getHighCountPercent())) + '%');
            proportionModel2.setLowCountPercent(Math.min(MathKt.roundToInt((((double) proportionModel2.getLowCount()) / highCount) * d), 100 - proportionModel2.getHighCountPercent()));
            proportionModel2.setLowCountPercentStr(ExtendsKt.getNumberFormatWithLocale().format(Integer.valueOf(proportionModel2.getLowCountPercent())) + '%');
            int highCountPercent = (100 - proportionModel2.getHighCountPercent()) - proportionModel2.getLowCountPercent();
            if (highCountPercent <= 0) {
                highCountPercent = 0;
            }
            proportionModel2.setNormalCountPercent(highCountPercent);
            proportionModel2.setNormalCountPercentStr(ExtendsKt.getNumberFormatWithLocale().format(Integer.valueOf(proportionModel2.getNormalCountPercent())) + '%');
            double coerceAtMost = RangesKt.coerceAtMost(highCount, 1440.0d);
            proportionModel2.setHighCountMinutesStr(formatTimeText((((double) proportionModel2.getHighCountPercent()) / 100.0d) * coerceAtMost));
            proportionModel2.setNormalCountMinutesStr(formatTimeText((((double) proportionModel2.getNormalCountPercent()) / 100.0d) * coerceAtMost));
            proportionModel2.setLowCountMinutesStr(formatTimeText((((double) proportionModel2.getLowCountPercent()) / 100.0d) * coerceAtMost));
        }
        Unit unit = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void calculateForRecords(CopyOnWriteArrayList<HistoryDetailModel> copyOnWriteArrayList, BaseEventEntity baseEventEntity) {
        if (baseEventEntity instanceof BloodGlucoseEntity) {
            copyOnWriteArrayList.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel((BloodGlucoseEntity) baseEventEntity));
        } else if (baseEventEntity instanceof DietEntity) {
            copyOnWriteArrayList.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel((DietEntity) baseEventEntity));
        } else if (baseEventEntity instanceof ExerciseEntity) {
            copyOnWriteArrayList.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel((ExerciseEntity) baseEventEntity));
        } else if (baseEventEntity instanceof MedicationEntity) {
            copyOnWriteArrayList.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel((MedicationEntity) baseEventEntity));
        } else if (baseEventEntity instanceof InsulinEntity) {
            copyOnWriteArrayList.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel((InsulinEntity) baseEventEntity));
        } else if (baseEventEntity instanceof OthersEntity) {
            copyOnWriteArrayList.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel((OthersEntity) baseEventEntity));
        }
    }

    /* access modifiers changed from: private */
    public final void calculateForAlert(List<HistoryDetailModel> list, RealCgmHistoryEntity realCgmHistoryEntity) {
        int eventWarning = realCgmHistoryEntity.getEventWarning();
        if (1 <= eventWarning && eventWarning < 4) {
            list.add(HistoryDetailModelExtentionsKt.toHistoryDetailModel(realCgmHistoryEntity));
        }
    }

    /* access modifiers changed from: private */
    public final Object loadCurDateAllData(Date date, Date date2, Continuation<? super List<? extends List<? extends BaseEventEntity>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HistoryViewModel$loadCurDateAllData$2(date, date2, (Continuation<? super HistoryViewModel$loadCurDateAllData$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Object loadCurDateAllData(String str, String str2, Continuation<? super List<? extends List<? extends BaseEventEntity>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HistoryViewModel$loadCurDateAllData$4(str, str2, (Continuation<? super HistoryViewModel$loadCurDateAllData$4>) null), continuation);
    }

    private final String formatTimeText(double d) {
        String str;
        if (d < 60.0d) {
            String string = ExtendsKt.getContext().getString(R.string.history_percent_minute, new Object[]{ExtendsKt.stripTrailingZeros(Double.valueOf(d), 0)});
            Intrinsics.checkNotNull(string);
            return string;
        }
        double d2 = (double) 60;
        String stripTrailingZeros$default = ExtendsKt.stripTrailingZeros$default(Double.valueOf(Math.floor(d / d2)), (Integer) null, 1, (Object) null);
        double d3 = d % d2;
        if (d3 > Utils.DOUBLE_EPSILON) {
            str = ExtendsKt.stripTrailingZeros$default(Double.valueOf(Math.floor(d3)), (Integer) null, 1, (Object) null);
        } else {
            str = "";
        }
        String str2 = ExtendsKt.getContext().getString(R.string.history_percent_hour, new Object[]{stripTrailingZeros$default}) + ExtendsKt.getContext().getString(R.string.history_percent_minute, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        return str2;
    }

    /* access modifiers changed from: private */
    public final void resetChartData() {
        this.bgSet.clear();
        this.eventSet.clear();
        this.glucoseSensorEntryMap.clear();
        this.calSet.clear();
        CombinedData combinedData2 = this.combinedData;
        CombinedData combinedData3 = null;
        if (combinedData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("combinedData");
            combinedData2 = null;
        }
        combinedData2.getLineData().clearValues();
        CombinedData combinedData4 = this.combinedData;
        if (combinedData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("combinedData");
            combinedData4 = null;
        }
        combinedData4.getScatterData().clearValues();
        CombinedData combinedData5 = this.combinedData;
        if (combinedData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("combinedData");
        } else {
            combinedData3 = combinedData5;
        }
        combinedData3.clearValues();
    }

    public final float xMin() {
        return xMax() - xRange();
    }

    public final float xMax() {
        ChartUtil chartUtil = ChartUtil.INSTANCE;
        Date value = this._curDate.getValue();
        if (value == null) {
            value = new Date();
        }
        return chartUtil.secondToX(ExtendsKt.getEndOfTheDay(value).getTime() / ((long) 1000));
    }

    public final float getUpperLimit() {
        return GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHyper());
    }

    public final float getLowerLimit() {
        return GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHypo());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0106 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onDelete(com.microtech.aidexx.db.entity.BaseEventEntity r27, kotlin.coroutines.Continuation<? super kotlin.Unit> r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            boolean r3 = r2 instanceof com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$1 r3 = (com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$1 r3 = new com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x0049
            if (r5 == r8) goto L_0x003d
            if (r5 != r6) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0107
        L_0x0035:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003d:
            java.lang.Object r1 = r3.L$1
            com.microtech.aidexx.db.entity.BaseEventEntity r1 = (com.microtech.aidexx.db.entity.BaseEventEntity) r1
            java.lang.Object r5 = r3.L$0
            com.microtech.aidexx.ui.main.history.HistoryViewModel r5 = (com.microtech.aidexx.ui.main.history.HistoryViewModel) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x008f
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.ui.main.history.eventHistory.CountModel> r2 = r0._countModel
            java.lang.Object r2 = r2.getValue()
            r9 = r2
            com.microtech.aidexx.ui.main.history.eventHistory.CountModel r9 = (com.microtech.aidexx.ui.main.history.eventHistory.CountModel) r9
            if (r9 == 0) goto L_0x0075
            r19 = 255(0xff, float:3.57E-43)
            r20 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.microtech.aidexx.ui.main.history.eventHistory.CountModel r2 = com.microtech.aidexx.ui.main.history.eventHistory.CountModel.copy$default(r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r2 == 0) goto L_0x0075
            long r9 = java.lang.System.currentTimeMillis()
            r2.setId(r9)
            goto L_0x0076
        L_0x0075:
            r2 = r7
        L_0x0076:
            com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$minus$1 r5 = com.microtech.aidexx.ui.main.history.HistoryViewModel$onDelete$minus$1.INSTANCE
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            if (r2 == 0) goto L_0x008e
            r0.calculateForCount(r2, r1, r5)
            kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.ui.main.history.eventHistory.CountModel> r5 = r0._countModel
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r8
            java.lang.Object r2 = r5.emit(r2, r3)
            if (r2 != r4) goto L_0x008e
            return r4
        L_0x008e:
            r5 = r0
        L_0x008f:
            boolean r2 = r1 instanceof com.microtech.aidexx.db.entity.event.DietEntity
            if (r2 == 0) goto L_0x0095
            r2 = r8
            goto L_0x0097
        L_0x0095:
            boolean r2 = r1 instanceof com.microtech.aidexx.db.entity.event.ExerciseEntity
        L_0x0097:
            if (r2 == 0) goto L_0x009b
            r2 = r8
            goto L_0x009d
        L_0x009b:
            boolean r2 = r1 instanceof com.microtech.aidexx.db.entity.event.MedicationEntity
        L_0x009d:
            if (r2 == 0) goto L_0x00a1
            r2 = r8
            goto L_0x00a3
        L_0x00a1:
            boolean r2 = r1 instanceof com.microtech.aidexx.db.entity.event.InsulinEntity
        L_0x00a3:
            if (r2 == 0) goto L_0x00a7
            r2 = r8
            goto L_0x00a9
        L_0x00a7:
            boolean r2 = r1 instanceof com.microtech.aidexx.db.entity.event.OthersEntity
        L_0x00a9:
            if (r2 == 0) goto L_0x00b7
            com.microtech.aidexx.views.chart.dataset.IconDataSet r2 = r5.eventSet
            com.microtech.aidexx.views.chart.dataset.ChartEntry r1 = com.microtech.aidexx.views.chart.dataset.EventEntryConverterKt.toChartEntry$default(r1, r7, r8, r7)
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            r2.removeEntry(r1)
            goto L_0x00c6
        L_0x00b7:
            boolean r2 = r1 instanceof com.microtech.aidexx.db.entity.BloodGlucoseEntity
            if (r2 == 0) goto L_0x00c6
            com.microtech.aidexx.views.chart.dataset.BgDataSet r2 = r5.bgSet
            com.microtech.aidexx.views.chart.dataset.ChartEntry r1 = com.microtech.aidexx.views.chart.dataset.EventEntryConverterKt.toChartEntry$default(r1, r7, r8, r7)
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            r2.removeEntry(r1)
        L_0x00c6:
            kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.ui.main.history.eventHistory.ChartModel> r1 = r5._chartModel
            java.lang.Object r2 = r1.getValue()
            r8 = r2
            com.microtech.aidexx.ui.main.history.eventHistory.ChartModel r8 = (com.microtech.aidexx.ui.main.history.eventHistory.ChartModel) r8
            if (r8 == 0) goto L_0x00ef
            r24 = 4095(0xfff, float:5.738E-42)
            r25 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            com.microtech.aidexx.ui.main.history.eventHistory.ChartModel r2 = com.microtech.aidexx.ui.main.history.eventHistory.ChartModel.copy$default(r8, r9, r11, r12, r13, r14, r16, r17, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x00f0
        L_0x00ef:
            r2 = r7
        L_0x00f0:
            if (r2 != 0) goto L_0x00f3
            goto L_0x00fa
        L_0x00f3:
            long r8 = java.lang.System.currentTimeMillis()
            r2.setId(r8)
        L_0x00fa:
            r3.L$0 = r7
            r3.L$1 = r7
            r3.label = r6
            java.lang.Object r1 = r1.emit(r2, r3)
            if (r1 != r4) goto L_0x0107
            return r4
        L_0x0107:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.history.HistoryViewModel.onDelete(com.microtech.aidexx.db.entity.BaseEventEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.history.HistoryViewModel$1", f = "HistoryViewModel.kt", i = {}, l = {565}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.history.HistoryViewModel$1  reason: invalid class name */
    /* compiled from: HistoryViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HistoryViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow debounce = FlowKt.debounce(this.this$0._curDate, 300);
                final HistoryViewModel historyViewModel = this.this$0;
                this.label = 1;
                if (FlowKt.collectLatest(debounce, new Function2<Date, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    /* synthetic */ Object L$0;
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 r0 = 
                    }

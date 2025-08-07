package com.microtech.aidexx.views.chart;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.chart.MyChart;
import com.microtech.aidexx.views.chart.dataset.CurrentGlucoseDataSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020'H\u0002J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001aH\u0002J\u001c\u0010/\u001a\u00020'2\b\b\u0002\u00100\u001a\u00020\u00162\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0002J\u000e\u00105\u001a\u00020'2\u0006\u00106\u001a\u000202J\b\u00107\u001a\u00020'H\u0016J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020'H\u0002J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020'H\u0002J\u0010\u0010=\u001a\u00020'2\b\b\u0001\u0010>\u001a\u00020\tJ\b\u0010?\u001a\u00020'H\u0002J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006E"}, d2 = {"Lcom/microtech/aidexx/views/chart/GlucoseChart;", "Lcom/microtech/aidexx/views/chart/MyChart;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "extraParams", "Lcom/microtech/aidexx/views/chart/GlucoseChart$ExtraParams;", "getExtraParams", "()Lcom/microtech/aidexx/views/chart/GlucoseChart$ExtraParams;", "setExtraParams", "(Lcom/microtech/aidexx/views/chart/GlucoseChart$ExtraParams;)V", "format", "Ljava/text/SimpleDateFormat;", "getFormat", "()Ljava/text/SimpleDateFormat;", "isValueNull", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "newestGranularity", "", "Ljava/lang/Float;", "textColor", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSubstring", "", "str", "count", "initBackground", "", "initChartAxisX", "initData", "combinedData", "Lcom/github/mikephil/charting/data/CombinedData;", "initView", "isAtLatestPosition", "highestVisibleX", "notifyChanged", "needMoveLatest", "jumpToDate", "Ljava/util/Date;", "refresh", "refreshAndMoveLatest", "refreshAndMoveToDate", "date", "reload", "updateChartAxisX", "updateChartAxisY", "updateChartAxisYStyle2", "updateData", "updateGlucoseStartEndValue", "updateGranularity", "granularity", "updateListener", "updateYaxisMaxMin", "yAxis", "Lcom/github/mikephil/charting/components/YAxis;", "Companion", "ExtraParams", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseChart.kt */
public final class GlucoseChart extends MyChart {
    public static final int CHART_LABEL_COUNT = 6;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "GlucoseChart";
    /* access modifiers changed from: private */
    public static boolean isInit;
    private ExtraParams extraParams;
    private final SimpleDateFormat format = new SimpleDateFormat(getContext().getString(R.string.com_dateFormat_MMddHHmm), Locale.getDefault());
    /* access modifiers changed from: private */
    public boolean isValueNull = true;
    private LifecycleOwner lifecycleOwner;
    private Float newestGranularity;
    private Integer textColor;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010?\u001a\u00020\u0016H&J\b\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020AH&J\b\u0010C\u001a\u00020AH&J\b\u0010D\u001a\u00020AH&J\b\u0010E\u001a\u00020AH&J\b\u0010F\u001a\u00020AH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RL\u0010\u0014\u001a6\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010!X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0005\"\u0004\b)\u0010\u0007R\u001a\u0010*\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0005\"\u0004\b,\u0010\u0007R\u001a\u0010-\u001a\u0004\u0018\u00010.X¦\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0005\"\u0004\b5\u0010\u0007R\u001a\u00106\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0005\"\u0004\b8\u0010\u0007R\u001a\u00109\u001a\u0004\u0018\u00010:X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006G"}, d2 = {"Lcom/microtech/aidexx/views/chart/GlucoseChart$ExtraParams;", "", "curDateTv", "Landroid/widget/TextView;", "getCurDateTv", "()Landroid/widget/TextView;", "setCurDateTv", "(Landroid/widget/TextView;)V", "goToHistory", "Landroid/widget/ImageView;", "getGoToHistory", "()Landroid/widget/ImageView;", "setGoToHistory", "(Landroid/widget/ImageView;)V", "llValue", "Landroid/widget/LinearLayout;", "getLlValue", "()Landroid/widget/LinearLayout;", "setLlValue", "(Landroid/widget/LinearLayout;)V", "onChartEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "obj", "", "getOnChartEvent", "()Lkotlin/jvm/functions/Function2;", "setOnChartEvent", "(Lkotlin/jvm/functions/Function2;)V", "onGoToHistory", "Lkotlin/Function1;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "getOnGoToHistory", "()Lkotlin/jvm/functions/Function1;", "setOnGoToHistory", "(Lkotlin/jvm/functions/Function1;)V", "outerDescriptionU", "getOuterDescriptionU", "setOuterDescriptionU", "outerDescriptionUnit", "getOuterDescriptionUnit", "setOuterDescriptionUnit", "outerDescriptionView", "Landroid/view/View;", "getOuterDescriptionView", "()Landroid/view/View;", "setOuterDescriptionView", "(Landroid/view/View;)V", "outerDescriptionX", "getOuterDescriptionX", "setOuterDescriptionX", "outerDescriptionY", "getOuterDescriptionY", "setOuterDescriptionY", "rlDescription", "Landroid/widget/RelativeLayout;", "getRlDescription", "()Landroid/widget/RelativeLayout;", "setRlDescription", "(Landroid/widget/RelativeLayout;)V", "getYAxisStyle", "lowerLimit", "", "upperLimit", "xMargin", "xMax", "xMin", "xRange", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucoseChart.kt */
    public interface ExtraParams {
        TextView getCurDateTv();

        ImageView getGoToHistory();

        LinearLayout getLlValue();

        Function2<Integer, Object, Unit> getOnChartEvent();

        Function1<BaseEventEntity, Unit> getOnGoToHistory();

        TextView getOuterDescriptionU();

        TextView getOuterDescriptionUnit();

        View getOuterDescriptionView();

        TextView getOuterDescriptionX();

        TextView getOuterDescriptionY();

        RelativeLayout getRlDescription();

        int getYAxisStyle();

        float lowerLimit();

        void setCurDateTv(TextView textView);

        void setGoToHistory(ImageView imageView);

        void setLlValue(LinearLayout linearLayout);

        void setOnChartEvent(Function2<? super Integer, Object, Unit> function2);

        void setOnGoToHistory(Function1<? super BaseEventEntity, Unit> function1);

        void setOuterDescriptionU(TextView textView);

        void setOuterDescriptionUnit(TextView textView);

        void setOuterDescriptionView(View view);

        void setOuterDescriptionX(TextView textView);

        void setOuterDescriptionY(TextView textView);

        void setRlDescription(RelativeLayout relativeLayout);

        float upperLimit();

        float xMargin();

        float xMax();

        float xMin();

        float xRange();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucoseChart.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit[] r0 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r1 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MMOL_PER_L     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r1 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MG_PER_DL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.chart.GlucoseChart.WhenMappings.<clinit>():void");
        }
    }

    public final SimpleDateFormat getFormat() {
        return this.format;
    }

    public final ExtraParams getExtraParams() {
        return this.extraParams;
    }

    public final void setExtraParams(ExtraParams extraParams2) {
        this.extraParams = extraParams2;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(Integer num) {
        this.textColor = num;
    }

    public GlucoseChart(Context context) {
        super(context);
        initView();
    }

    public GlucoseChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public GlucoseChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void reload() {
        LineData lineData;
        LineData lineData2;
        LineData lineData3;
        LineData lineData4;
        super.reload();
        LogUtil.Companion companion = LogUtil.Companion;
        StringBuilder sb = new StringBuilder("===CHART=== reload data.entryCount=");
        CombinedData combinedData = (CombinedData) getData();
        Integer num = null;
        String sb2 = sb.append(combinedData != null ? Integer.valueOf(combinedData.getEntryCount()) : null).toString();
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion.xLogE(sb2, str);
        LogUtil.Companion companion2 = LogUtil.Companion;
        StringBuilder sb3 = new StringBuilder("===CHART=== reload lineData ");
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder("xmax=");
        CombinedData combinedData2 = (CombinedData) getData();
        sb4.append(sb5.append((combinedData2 == null || (lineData4 = combinedData2.getLineData()) == null) ? null : Float.valueOf(lineData4.getXMax())).append(' ').toString());
        StringBuilder sb6 = new StringBuilder("xmin=");
        CombinedData combinedData3 = (CombinedData) getData();
        sb4.append(sb6.append((combinedData3 == null || (lineData3 = combinedData3.getLineData()) == null) ? null : Float.valueOf(lineData3.getXMin())).append(' ').toString());
        StringBuilder sb7 = new StringBuilder("ymax=");
        CombinedData combinedData4 = (CombinedData) getData();
        sb4.append(sb7.append((combinedData4 == null || (lineData2 = combinedData4.getLineData()) == null) ? null : Float.valueOf(lineData2.getYMax())).append(' ').toString());
        StringBuilder sb8 = new StringBuilder("ymin=");
        CombinedData combinedData5 = (CombinedData) getData();
        sb4.append(sb8.append((combinedData5 == null || (lineData = combinedData5.getLineData()) == null) ? null : Float.valueOf(lineData.getYMin())).append(' ').toString());
        Unit unit = Unit.INSTANCE;
        String sb9 = sb4.toString();
        Intrinsics.checkNotNullExpressionValue(sb9, "toString(...)");
        String sb10 = sb3.append(sb9).toString();
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion2.xLogE(sb10, str);
        LogUtil.Companion companion3 = LogUtil.Companion;
        StringBuilder sb11 = new StringBuilder("===CHART=== reload data.entryCount=");
        YAxisRenderer rendererRightYAxis = getRendererRightYAxis();
        String sb12 = sb11.append(rendererRightYAxis != null ? rendererRightYAxis.getTransformer() : null).toString();
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion3.xLogE(sb12, str);
        LogUtil.Companion companion4 = LogUtil.Companion;
        StringBuilder sb13 = new StringBuilder("===CHART=== reload data.entryCount=");
        YAxisRenderer rendererRightYAxis2 = getRendererRightYAxis();
        String sb14 = sb13.append(rendererRightYAxis2 != null ? rendererRightYAxis2.getTransformer() : null).toString();
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion4.d(sb14, str);
        EventBusManager eventBusManager = EventBusManager.INSTANCE;
        ExtraParams extraParams2 = this.extraParams;
        if (extraParams2 != null) {
            num = Integer.valueOf(extraParams2.getYAxisStyle());
        }
        eventBusManager.send(EventBusKey.EVENT_RELOAD_CHART, num);
    }

    private final void initView() {
        this.textColor = Integer.valueOf(ThemeManager.getTypeValue(getContext(), R.attr.colorChartText));
        initBackground();
        initChartAxisX();
        setKeepPositionOnRotation(true);
        this.needDrawLineDataSetValuesAndIcons = true;
        setMinOffset(0.0f);
        setExtraTopOffset(10.0f);
        setExtraBottomOffset(21.0f);
        setExtraLeftOffset(10.0f);
        setExtraRightOffset(10.0f);
        getDescription().setEnabled(false);
        Description description = getDescription();
        Integer num = this.textColor;
        Intrinsics.checkNotNull(num);
        description.setTextColor(num.intValue());
        getDescription().setTextSize(20.0f);
        getLegend().setEnabled(false);
        setScaleEnabled(false);
        setTouchEnabled(true);
        setDragXEnabled(true);
        setDragYEnabled(false);
        setDragDecelerationEnabled(true);
        setHighlightPerDragEnabled(false);
        setHighlightPerTapEnabled(false);
        setMaxHighlightDistance(10.0f);
        setEnableAutoScaleY(true);
        getAutoYMaxRule().put(UnitManager.GlucoseUnit.MMOL_PER_L.getUnit(), CollectionsKt.mutableListOf(TuplesKt.to(Float.valueOf(18.0f), Float.valueOf(20.0f)), TuplesKt.to(Float.valueOf(23.0f), Float.valueOf(25.0f))));
        getAutoYMaxRule().put(UnitManager.GlucoseUnit.MG_PER_DL.getUnit(), CollectionsKt.mutableListOf(TuplesKt.to(Float.valueOf(324.0f), Float.valueOf(360.0f)), TuplesKt.to(Float.valueOf(414.0f), Float.valueOf(450.0f))));
        setOnChartValueSelectedListener(new GlucoseChart$initView$1(this));
        setOnSelectX(new GlucoseChart$initView$2(this));
    }

    public final void initData(CombinedData combinedData) {
        Intrinsics.checkNotNullParameter(combinedData, "combinedData");
        LogUtil.Companion companion = LogUtil.Companion;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion.d("initData", str);
        updateChartAxisY();
        updateChartAxisX();
        updateListener();
        initBackground();
        setData(combinedData);
        notifyChanged$default(this, true, (Date) null, 2, (Object) null);
    }

    public static /* synthetic */ void notifyChanged$default(GlucoseChart glucoseChart, boolean z, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            date = null;
        }
        glucoseChart.notifyChanged(z, date);
    }

    public final void notifyChanged(boolean z, Date date) {
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        LogUtil.Companion.d("notifyChanged needMoveLatest=" + z, str);
        if (getData() != null) {
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            LogUtil.Companion.d("===CHART===  highestVisibleX=" + getHighestVisibleX() + " max=" + getXAxis().getAxisMaximum() + " min=" + getXAxis().getAxisMinimum(), str);
            if (getAxisRight().isEnabled()) {
                YAxis axisRight = getAxisRight();
                Intrinsics.checkNotNullExpressionValue(axisRight, "getAxisRight(...)");
                updateYaxisMaxMin(axisRight);
            }
            if (getAxisLeft().isEnabled()) {
                YAxis axisLeft = getAxisLeft();
                Intrinsics.checkNotNullExpressionValue(axisLeft, "getAxisLeft(...)");
                updateYaxisMaxMin(axisLeft);
            }
            updateGlucoseStartEndValue();
            Float f = this.newestGranularity;
            Unit unit = null;
            if (f != null) {
                getXAxis().setGranularity(f.floatValue());
                this.newestGranularity = null;
                ((CombinedData) getData()).notifyDataChanged();
            }
            if (date != null) {
                refreshAndMoveToDate(date);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                GlucoseChart glucoseChart = this;
                if (UserInfoManager.Companion.getShareUserInfo() != null) {
                    if (!isAtLatestPosition(getHighestVisibleX()) || !isInit) {
                        refresh();
                    } else {
                        refreshAndMoveLatest();
                    }
                } else if (z || isAtLatestPosition(getHighestVisibleX())) {
                    refreshAndMoveLatest();
                } else {
                    refresh();
                }
            }
            postDelayed(new GlucoseChart$$ExternalSyntheticLambda0(this), 500);
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyChanged$lambda$4(GlucoseChart glucoseChart) {
        Function2<Integer, Object, Unit> onChartEvent;
        Intrinsics.checkNotNullParameter(glucoseChart, "this$0");
        ExtraParams extraParams2 = glucoseChart.extraParams;
        if (extraParams2 != null && (onChartEvent = extraParams2.getOnChartEvent()) != null) {
            onChartEvent.invoke(1, Float.valueOf(glucoseChart.getLowestVisibleX()));
        }
    }

    public final void updateGranularity(@MyChart.ChartGranularityPerScreen int i) {
        this.newestGranularity = Float.valueOf((float) i);
    }

    private final void updateListener() {
        ExtraParams extraParams2 = this.extraParams;
        if (extraParams2 != null && extraParams2.getYAxisStyle() != 1) {
            setTouchEnabled(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r3 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        if (r3 != null) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isAtLatestPosition(float r10) {
        /*
            r9 = this;
            float r0 = r9.getXChartMax()
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r1 = r9.extraParams
            r2 = 0
            if (r1 == 0) goto L_0x000e
            float r1 = r1.xMargin()
            goto L_0x000f
        L_0x000e:
            r1 = r2
        L_0x000f:
            float r0 = r0 - r1
            boolean r0 = java.lang.Float.isNaN(r0)
            r1 = 0
            if (r0 != 0) goto L_0x00a0
            boolean r0 = java.lang.Float.isNaN(r10)
            if (r0 == 0) goto L_0x001f
            goto L_0x00a0
        L_0x001f:
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            boolean r3 = r0.inDaylightTime(r3)
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 == 0) goto L_0x0048
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            long r5 = r3.getTime()
            long r7 = (long) r4
            long r5 = r5 / r7
            int r0 = r0.getDSTSavings()
            int r0 = r0 / r4
            long r3 = (long) r0
            long r5 = r5 + r3
            float r0 = (float) r5
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r3 = r9.extraParams
            if (r3 == 0) goto L_0x005c
            goto L_0x0058
        L_0x0048:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r5 = r0.getTime()
            long r3 = (long) r4
            long r5 = r5 / r3
            float r0 = (float) r5
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r3 = r9.extraParams
            if (r3 == 0) goto L_0x005c
        L_0x0058:
            float r2 = r3.xMargin()
        L_0x005c:
            float r0 = r0 + r2
            com.microtech.aidexx.views.chart.ChartUtil r2 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
            long r2 = r2.xToSecond(r10)
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "===CHART=== diff: m="
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r5 = " - h="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r5 = " = "
            java.lang.StringBuilder r4 = r4.append(r5)
            float r2 = (float) r2
            float r0 = r0 - r2
            java.lang.StringBuilder r2 = r4.append(r0)
            r3 = 32
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 2
            r4 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.d$default(r10, r2, r4, r3, r4)
            float r10 = java.lang.Math.abs(r0)
            r0 = 1133903872(0x43960000, float:300.0)
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a0
            r1 = 1
        L_0x00a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.chart.GlucoseChart.isAtLatestPosition(float):boolean");
    }

    public final void refreshAndMoveToDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        float millSecondToX = ChartUtil.INSTANCE.millSecondToX(date.getTime());
        updateData();
        LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== refreshAndMoveToDate tar=" + millSecondToX + " hi=" + getHighestVisibleX() + "  rang=" + getVisibleXRange() + " max=" + getXAxis().getAxisMaximum() + " min=" + getXAxis().getAxisMinimum(), (String) null, 2, (Object) null);
        moveViewToX(millSecondToX);
        delayAutoScaleY(500);
    }

    private final void refresh() {
        float axisMinimum = getXAxis().getAxisMinimum();
        float visibleXRange = getVisibleXRange();
        float highestVisibleX = getHighestVisibleX() - visibleXRange;
        updateData();
        LogUtil.Companion.d$default(LogUtil.Companion, "===CHART=== refresh tar=" + highestVisibleX + " hi=" + getHighestVisibleX() + "  cr=" + visibleXRange + " rang=" + getVisibleXRange() + " max=" + getXAxis().getAxisMaximum() + " curmin=" + axisMinimum + " min=" + getXAxis().getAxisMinimum(), (String) null, 2, (Object) null);
        moveViewToX(highestVisibleX);
        delayAutoScaleY(500);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        if (r2 != null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void refreshAndMoveLatest() {
        /*
            r9 = this;
            java.lang.String r0 = "refreshAndMove max="
            monitor-enter(r9)
            java.util.TimeZone r1 = java.util.TimeZone.getDefault()     // Catch:{ all -> 0x0073 }
            java.util.Date r2 = new java.util.Date     // Catch:{ all -> 0x0073 }
            r2.<init>()     // Catch:{ all -> 0x0073 }
            boolean r2 = r1.inDaylightTime(r2)     // Catch:{ all -> 0x0073 }
            r3 = 0
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r2 == 0) goto L_0x0037
            com.microtech.aidexx.views.chart.ChartUtil r2 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE     // Catch:{ all -> 0x0073 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x0073 }
            r5.<init>()     // Catch:{ all -> 0x0073 }
            long r5 = r5.getTime()     // Catch:{ all -> 0x0073 }
            long r7 = (long) r4     // Catch:{ all -> 0x0073 }
            long r5 = r5 / r7
            int r1 = r1.getDSTSavings()     // Catch:{ all -> 0x0073 }
            int r1 = r1 / r4
            long r7 = (long) r1     // Catch:{ all -> 0x0073 }
            long r5 = r5 + r7
            float r1 = r2.secondToX(r5)     // Catch:{ all -> 0x0073 }
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r2 = r9.extraParams     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x0035
        L_0x0031:
            float r3 = r2.xMargin()     // Catch:{ all -> 0x0073 }
        L_0x0035:
            float r1 = r1 + r3
            goto L_0x004d
        L_0x0037:
            com.microtech.aidexx.views.chart.ChartUtil r1 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE     // Catch:{ all -> 0x0073 }
            java.util.Date r2 = new java.util.Date     // Catch:{ all -> 0x0073 }
            r2.<init>()     // Catch:{ all -> 0x0073 }
            long r5 = r2.getTime()     // Catch:{ all -> 0x0073 }
            long r7 = (long) r4     // Catch:{ all -> 0x0073 }
            long r5 = r5 / r7
            float r1 = r1.secondToX(r5)     // Catch:{ all -> 0x0073 }
            com.microtech.aidexx.views.chart.GlucoseChart$ExtraParams r2 = r9.extraParams     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x0035
            goto L_0x0031
        L_0x004d:
            r9.updateData()     // Catch:{ all -> 0x0073 }
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r3.<init>(r0)     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r0 = r3.append(r1)     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0073 }
            java.lang.String r4 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0073 }
            r2.d(r0, r3)     // Catch:{ all -> 0x0073 }
            r9.moveViewToX(r1)     // Catch:{ all -> 0x0073 }
            r0 = 500(0x1f4, double:2.47E-321)
            r9.delayAutoScaleY(r0)     // Catch:{ all -> 0x0073 }
            monitor-exit(r9)
            return
        L_0x0073:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0073 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.chart.GlucoseChart.refreshAndMoveLatest():void");
    }

    private final void updateData() {
        setTouchable(false);
        XAxis xAxis = getXAxis();
        ExtraParams extraParams2 = this.extraParams;
        float f = 0.0f;
        xAxis.setAxisMinimum(extraParams2 != null ? extraParams2.xMin() : 0.0f);
        XAxis xAxis2 = getXAxis();
        ExtraParams extraParams3 = this.extraParams;
        xAxis2.setAxisMaximum(extraParams3 != null ? extraParams3.xMax() : 0.0f);
        ExtraParams extraParams4 = this.extraParams;
        if (extraParams4 != null) {
            f = extraParams4.xRange();
        }
        setVisibleXRange(f);
        notifyDataSetChanged();
    }

    private final void initBackground() {
        setBackgroundColor(0);
        setDrawGridBackground(true);
        setGridBackgroundColor(ThemeManager.getTypeValue(getContext(), R.attr.bgHomeGlucose));
        updateGlucoseStartEndValue();
    }

    private final void updateGlucoseStartEndValue() {
        ExtraParams extraParams2 = this.extraParams;
        float f = 0.0f;
        setGridBackgroundStart(extraParams2 != null ? extraParams2.lowerLimit() : 0.0f);
        ExtraParams extraParams3 = this.extraParams;
        if (extraParams3 != null) {
            f = extraParams3.upperLimit();
        }
        setGridBackgroundEnd(f);
    }

    private final void updateYaxisMaxMin(YAxis yAxis) {
        yAxis.setGranularityEnabled(true);
        int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i == 1) {
            yAxis.setAxisMinimum(0.0f);
            yAxis.setAxisMaximum(30.0f);
            setUnitTag(UnitManager.GlucoseUnit.MMOL_PER_L.getUnit());
        } else if (i == 2) {
            yAxis.setAxisMinimum(0.0f);
            yAxis.setAxisMaximum(600.0f);
            setUnitTag(UnitManager.GlucoseUnit.MG_PER_DL.getUnit());
        }
    }

    private final void initChartAxisX() {
        getXAxis().setDrawAxisLine(false);
        getXAxis().setDrawGridLines(true);
        getXAxis().setGridColor(ThemeManager.getTypeValue(getContext(), R.attr.colorLineChart));
        getXAxis().setDrawLabels(true);
        getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        getXAxis().setTextSize(14.0f);
        getXAxis().setYOffset(5.0f);
        XAxis xAxis = getXAxis();
        Integer num = this.textColor;
        Intrinsics.checkNotNull(num);
        xAxis.setTextColor(num.intValue());
        getXAxis().setGranularity(1.0f);
        getXAxis().setLabelCount(7);
        getXAxis().setGridDashedLine(new DashPathEffect(new float[]{22.0f, 2000.0f}, 0.0f));
        getXAxis().setGridLineWidth(1.0f);
        getXAxis().setValueFormatter(new GlucoseChart$initChartAxisX$1(this));
    }

    private final void updateChartAxisX() {
        ExtraParams extraParams2 = this.extraParams;
        Integer valueOf = extraParams2 != null ? Integer.valueOf(extraParams2.getYAxisStyle()) : null;
        if (valueOf == null || valueOf.intValue() != 1) {
            getXAxis().setGranularity(4.0f);
        }
    }

    private final void updateChartAxisY() {
        ExtraParams extraParams2 = this.extraParams;
        Integer valueOf = extraParams2 != null ? Integer.valueOf(extraParams2.getYAxisStyle()) : null;
        if (valueOf == null || valueOf.intValue() == 1) {
            setMajorAxis(YAxis.AxisDependency.RIGHT);
            YAxis axisRight = getAxisRight();
            Intrinsics.checkNotNullExpressionValue(axisRight, "getAxisRight(...)");
            axisRight.setDrawAxisLine(false);
            axisRight.setDrawGridLines(true);
            axisRight.setDrawLabels(true);
            axisRight.setGridColor(ThemeManager.getTypeValue(getContext(), R.attr.colorLineChart));
            axisRight.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
            updateYaxisMaxMin(axisRight);
            axisRight.setLabelCount(6, false);
            axisRight.setTextSize(14.0f);
            Integer num = this.textColor;
            Intrinsics.checkNotNull(num);
            axisRight.setTextColor(num.intValue());
            getAxisLeft().setEnabled(false);
            YAxis axisLeft = getAxisLeft();
            Intrinsics.checkNotNullExpressionValue(axisLeft, "getAxisLeft(...)");
            updateYaxisMaxMin(axisLeft);
            return;
        }
        updateChartAxisYStyle2();
    }

    private final void updateChartAxisYStyle2() {
        setMajorAxis(YAxis.AxisDependency.LEFT);
        int typeValue = ThemeManager.getTypeValue(getContext(), R.attr.colorLineChart);
        YAxis axisLeft = getAxisLeft();
        axisLeft.setDrawAxisLine(false);
        axisLeft.setDrawGridLines(true);
        axisLeft.setDrawLabels(true);
        axisLeft.setGridColor(typeValue);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        Intrinsics.checkNotNull(axisLeft);
        updateYaxisMaxMin(axisLeft);
        axisLeft.setLabelCount(6, false);
        axisLeft.setTextSize(14.0f);
        Integer num = this.textColor;
        Intrinsics.checkNotNull(num);
        axisLeft.setTextColor(num.intValue());
        getAxisRight().setEnabled(true);
        getAxisRight().setDrawAxisLine(false);
        getAxisRight().setDrawGridLines(false);
        getAxisRight().setDrawLabels(false);
        YAxis axisRight = getAxisRight();
        Intrinsics.checkNotNullExpressionValue(axisRight, "getAxisRight(...)");
        updateYaxisMaxMin(axisRight);
    }

    /* access modifiers changed from: private */
    public final String getSubstring(String str, int i) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            Integer valueOf = Integer.valueOf(String.valueOf(bytes[i2]));
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            if (valueOf.intValue() < 0) {
                if (arrayList.size() == 3) {
                    arrayList.clear();
                    arrayList.add(Integer.valueOf(i2));
                } else {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
        }
        if (arrayList.size() == 3 || arrayList.size() == 0) {
            byte[] bArr = new byte[i];
            System.arraycopy(bytes, 0, bArr, 0, i);
            return new String(bArr, Charsets.UTF_8);
        }
        byte[] bArr2 = new byte[(i - arrayList.size())];
        System.arraycopy(bytes, 0, bArr2, 0, i - arrayList.size());
        return new String(bArr2, Charsets.UTF_8);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/views/chart/GlucoseChart$Companion;", "", "()V", "CHART_LABEL_COUNT", "", "TAG", "", "kotlin.jvm.PlatformType", "isInit", "", "formatGlucoseSetAfterInitData", "", "glucoseSets", "", "Lcom/github/mikephil/charting/data/LineDataSet;", "lowerLimit", "", "upperLimit", "generateLimitLines", "xMin", "xMax", "setIsInit", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucoseChart.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<LineDataSet> generateLimitLines(float f, float f2, float f3, float f4) {
            LineDataSet lineDataSet = new LineDataSet(CollectionsKt.listOf(new Entry(f, f4), new Entry(f2, f4)), "");
            lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet.setDrawValues(false);
            lineDataSet.setDrawCircles(false);
            lineDataSet.setColor(0);
            lineDataSet.setLineWidth(0.0f);
            lineDataSet.setHighlightEnabled(false);
            LineDataSet lineDataSet2 = new LineDataSet(CollectionsKt.listOf(new Entry(f, f3), new Entry(f2, f3)), "");
            lineDataSet2.setDrawValues(false);
            lineDataSet2.setDrawCircles(false);
            lineDataSet2.setColor(0);
            lineDataSet2.setLineWidth(0.0f);
            lineDataSet2.setHighlightEnabled(false);
            lineDataSet.setDrawFilled(false);
            return CollectionsKt.listOf(lineDataSet, lineDataSet2);
        }

        public final void formatGlucoseSetAfterInitData(List<? extends LineDataSet> list, float f, float f2) {
            Intrinsics.checkNotNullParameter(list, "glucoseSets");
            for (LineDataSet lineDataSet : list) {
                if (!(lineDataSet instanceof CurrentGlucoseDataSet)) {
                    lineDataSet.setGradientPositions(CollectionsKt.listOf(Float.valueOf(f2), Float.valueOf(f2), Float.valueOf(f), Float.valueOf(f)));
                    lineDataSet.setFillFormatter(new GlucoseChart$Companion$formatGlucoseSetAfterInitData$1(f2, f));
                    lineDataSet.setFillGradientPositions(CollectionsKt.listOf(Float.valueOf(GlucoseUtilKt.toGlucoseValue(10.0f) + f2), Float.valueOf(f2), Float.valueOf(f2), Float.valueOf(f), Float.valueOf(f), Float.valueOf(f - GlucoseUtilKt.toGlucoseValue(1.0f))));
                }
                lineDataSet.setCircleColorRanges(CollectionsKt.listOf(Float.valueOf(f2), Float.valueOf(f - 0.1f), Float.valueOf(0.0f)));
            }
        }

        public final void setIsInit(boolean z) {
            GlucoseChart.isInit = z;
        }
    }
}

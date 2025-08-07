package com.microtech.aidexx.ui.main.trend;

import android.content.Context;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.FragmentTrendBinding;
import com.microtech.aidexx.ui.main.trend.view.PieChartView;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.utils.FormatUtil;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.views.calendar.CalendarDialog;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001GB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u000200H\u0016J$\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020'H\u0002J:\u0010:\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010>\u001a\u0004\u0018\u00010<2\b\u0010?\u001a\u0004\u0018\u00010<2\b\u0010@\u001a\u0004\u0018\u00010<H\u0002J\u001f\u0010A\u001a\u00020'2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH@ø\u0001\u0000¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/TrendsFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/ui/main/trend/TrendsViewModel;", "Lcom/microtech/aidexx/databinding/FragmentTrendBinding;", "Landroid/view/View$OnClickListener;", "()V", "attempt", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentEndDate", "Ljava/util/Date;", "getCurrentEndDate", "()Ljava/util/Date;", "setCurrentEndDate", "(Ljava/util/Date;)V", "currentStartDate", "getCurrentStartDate", "setCurrentStartDate", "mNumGlucose", "", "oneDigitFormat", "Ljava/text/DecimalFormat;", "rangeChanged", "", "getRangeChanged", "()Z", "setRangeChanged", "(Z)V", "userIdCurrentShow", "", "getUserIdCurrentShow", "()Ljava/lang/String;", "setUserIdCurrentShow", "(Ljava/lang/String;)V", "buildDataHolder", "Lcom/microtech/aidexx/ui/main/trend/view/PieChartView$PieceDataHolder;", "value", "", "color", "downloadAgp", "", "reportUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genAgp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFormatText", "initView", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "openCalendar", "updateAgpChart", "dailyMean", "", "daily75", "daily25", "daily90", "daily10", "updateMultiChart", "mutableList", "", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrends", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
public final class TrendsFragment extends BaseFragment<TrendsViewModel, FragmentTrendBinding> implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public AtomicInteger attempt = new AtomicInteger(0);
    private Date currentEndDate;
    private Date currentStartDate;
    /* access modifiers changed from: private */
    public int mNumGlucose;
    /* access modifiers changed from: private */
    public DecimalFormat oneDigitFormat;
    private boolean rangeChanged = true;
    private String userIdCurrentShow = UserInfoManager.Companion.instance().userId();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TrendsFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final TrendsFragment newInstance() {
        return Companion.newInstance();
    }

    public TrendsFragment() {
        Date dateLastWeek = Dialogs.DateInfo.INSTANCE.getDateLastWeek();
        Intrinsics.checkNotNull(dateLastWeek);
        this.currentStartDate = dateLastWeek;
        Date dateToday = Dialogs.DateInfo.INSTANCE.getDateToday();
        Intrinsics.checkNotNull(dateToday);
        this.currentEndDate = dateToday;
        this.oneDigitFormat = FormatUtil.INSTANCE.getOneDigitFormat();
    }

    public final boolean getRangeChanged() {
        return this.rangeChanged;
    }

    public final void setRangeChanged(boolean z) {
        this.rangeChanged = z;
    }

    public final String getUserIdCurrentShow() {
        return this.userIdCurrentShow;
    }

    public final void setUserIdCurrentShow(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userIdCurrentShow = str;
    }

    public final Date getCurrentStartDate() {
        return this.currentStartDate;
    }

    public final void setCurrentStartDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.currentStartDate = date;
    }

    public final Date getCurrentEndDate() {
        return this.currentEndDate;
    }

    public final void setCurrentEndDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.currentEndDate = date;
    }

    public void onResume() {
        String str;
        super.onResume();
        TextView textView = ((FragmentTrendBinding) getBinding()).tvTrendsTitle;
        ShareUserInfo shareUserInfo = UserInfoManager.Companion.getShareUserInfo();
        if (shareUserInfo == null || (str = shareUserInfo.getDisplayName()) == null) {
            str = getString(R.string.trend);
        }
        textView.setText(str);
        ImageView imageView = ((FragmentTrendBinding) getBinding()).ivGenerationAgp;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivGenerationAgp");
        imageView.setVisibility(UserInfoManager.Companion.getShareUserInfo() == null ? 0 : 8);
        Date dateLastWeek = Dialogs.DateInfo.INSTANCE.getDateLastWeek();
        Intrinsics.checkNotNull(dateLastWeek);
        this.currentStartDate = dateLastWeek;
        Date dateToday = Dialogs.DateInfo.INSTANCE.getDateToday();
        Intrinsics.checkNotNull(dateToday);
        this.currentEndDate = dateToday;
        if (!((FragmentTrendBinding) getBinding()).trendRefreshLayout.isRefreshing()) {
            ((FragmentTrendBinding) getBinding()).trendRefreshLayout.autoRefresh();
        }
        this.rangeChanged = false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTrendBinding inflate = FragmentTrendBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ((FragmentTrendBinding) getBinding()).layoutActionbar.setPadding(0, ExtendsKt.getStatusBarHeight() + ExtendsKt.dp2px((Number) 10), 0, 0);
        LinearLayout linearLayout = ((FragmentTrendBinding) getBinding()).rlDateSpace;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "rlDateSpace");
        ExtendsKt.setDebounceClickListener$default(linearLayout, 0, new TrendsFragment$$ExternalSyntheticLambda0(this), 1, (Object) null);
        initView();
        LinearLayout root = ((FragmentTrendBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(TrendsFragment trendsFragment, View view) {
        Intrinsics.checkNotNullParameter(trendsFragment, "this$0");
        trendsFragment.openCalendar();
    }

    private final void initView() {
        ((FragmentTrendBinding) getBinding()).trendRefreshLayout.setOnRefreshListener(new TrendsFragment$$ExternalSyntheticLambda1(this));
        View.OnClickListener onClickListener = this;
        ((FragmentTrendBinding) getBinding()).txtTitleGlucose.setOnClickListener(onClickListener);
        ((FragmentTrendBinding) getBinding()).tvAverage.setOnClickListener(onClickListener);
        ((FragmentTrendBinding) getBinding()).txtTitleTir.setOnClickListener(onClickListener);
        ((FragmentTrendBinding) getBinding()).txtTitleAgp.setOnClickListener(onClickListener);
        ((FragmentTrendBinding) getBinding()).txtTitleLBGI.setOnClickListener(onClickListener);
        ((FragmentTrendBinding) getBinding()).ivGenerationAgp.setOnClickListener(onClickListener);
        ((FragmentTrendBinding) getBinding()).expandableGrid.setOnDataChange(new TrendsFragment$initView$2(this));
        ((FragmentTrendBinding) getBinding()).multiDayChart.setExtraParams(new TrendsFragment$initView$3(this));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TrendsFragment$initView$4(this, (Continuation<? super TrendsFragment$initView$4>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(TrendsFragment trendsFragment, RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(trendsFragment, "this$0");
        Intrinsics.checkNotNullParameter(refreshLayout, "it");
        trendsFragment.updateTrends();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateMultiChart(java.util.List<com.microtech.aidexx.ui.main.trend.MultiDayBgItem> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.main.trend.TrendsFragment$updateMultiChart$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.main.trend.TrendsFragment$updateMultiChart$1 r0 = (com.microtech.aidexx.ui.main.trend.TrendsFragment$updateMultiChart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.trend.TrendsFragment$updateMultiChart$1 r0 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$updateMultiChart$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.microtech.aidexx.ui.main.trend.TrendsFragment r5 = (com.microtech.aidexx.ui.main.trend.TrendsFragment) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.base.BaseViewModel r6 = r4.getViewModel()
            com.microtech.aidexx.ui.main.trend.TrendsViewModel r6 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel) r6
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.updateMultiChartData(r5, r0)
            if (r5 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r5 = r4
        L_0x004b:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            com.microtech.aidexx.databinding.FragmentTrendBinding r6 = (com.microtech.aidexx.databinding.FragmentTrendBinding) r6
            com.microtech.aidexx.views.chart.GlucoseChart r0 = r6.multiDayChart
            com.github.mikephil.charting.data.ChartData r0 = r0.getData()
            if (r0 != 0) goto L_0x0069
            com.microtech.aidexx.views.chart.GlucoseChart r6 = r6.multiDayChart
            com.microtech.aidexx.base.BaseViewModel r5 = r5.getViewModel()
            com.microtech.aidexx.ui.main.trend.TrendsViewModel r5 = (com.microtech.aidexx.ui.main.trend.TrendsViewModel) r5
            com.github.mikephil.charting.data.CombinedData r5 = r5.getCombinedData()
            r6.initData(r5)
            goto L_0x0076
        L_0x0069:
            com.microtech.aidexx.views.chart.GlucoseChart r5 = r6.multiDayChart
            java.lang.String r6 = "multiDayChart"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = 0
            r0 = 2
            r1 = 0
            com.microtech.aidexx.views.chart.GlucoseChart.notifyChanged$default(r5, r6, r1, r0, r1)
        L_0x0076:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsFragment.updateMultiChart(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void updateAgpChart(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        boolean z;
        int color = ContextCompat.getColor(requireContext(), R.color.gray1);
        ((FragmentTrendBinding) getBinding()).agpChart.getDescription().setEnabled(false);
        ((FragmentTrendBinding) getBinding()).agpChart.getLegend().setEnabled(false);
        ((FragmentTrendBinding) getBinding()).agpChart.setTouchEnabled(false);
        ((FragmentTrendBinding) getBinding()).agpChart.setBackgroundColor(0);
        ((FragmentTrendBinding) getBinding()).agpChart.setDrawGridBackground(true);
        ((FragmentTrendBinding) getBinding()).agpChart.setGridBackgroundColor(1083742360);
        ((FragmentTrendBinding) getBinding()).agpChart.setGridBackgroundStart(GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHypo()));
        ((FragmentTrendBinding) getBinding()).agpChart.setGridBackgroundEnd(GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHyper()));
        XAxis xAxis = ((FragmentTrendBinding) getBinding()).agpChart.getXAxis();
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0.0f);
        xAxis.setAxisMaximum(24.0f);
        xAxis.setTextSize(12.0f);
        xAxis.setTextColor(color);
        xAxis.setDrawGridLines(true);
        int typeValue = ThemeManager.getTypeValue(getContext(), R.attr.colorTrendLine);
        xAxis.setGridColor(typeValue);
        xAxis.setValueFormatter(new TrendsFragment$updateAgpChart$1(this));
        YAxis axisLeft = ((FragmentTrendBinding) getBinding()).agpChart.getAxisLeft();
        Intrinsics.checkNotNullExpressionValue(axisLeft, "getAxisLeft(...)");
        axisLeft.setDrawAxisLine(false);
        axisLeft.setDrawGridLines(true);
        axisLeft.setDrawLabels(true);
        axisLeft.setGridColor(typeValue);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        LimitLine limitLine = new LimitLine(GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getHypo()), "");
        axisLeft.removeAllLimitLines();
        limitLine.enableDashedLine(15.0f, 3.0f, 0.0f);
        limitLine.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        limitLine.setLineColor(ContextCompat.getColor(requireContext(), R.color.colorTrend_1));
        limitLine.setLineWidth(0.5f);
        axisLeft.addLimitLine(limitLine);
        LimitLine limitLine2 = new LimitLine(GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getHyper()), "");
        limitLine2.enableDashedLine(15.0f, 3.0f, 0.0f);
        limitLine2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        limitLine2.setLineColor(ContextCompat.getColor(requireContext(), R.color.colorTrend_2));
        limitLine2.setLineWidth(0.5f);
        axisLeft.addLimitLine(limitLine2);
        Double valueOf = dArr4 != null ? Double.valueOf(ArraysKt.maxOrThrow(dArr4)) : null;
        if (valueOf == null || valueOf.doubleValue() < 18.0d) {
            int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
            if (i == 1) {
                axisLeft.setAxisMinimum(0.0f);
                axisLeft.setAxisMaximum(20.0f);
            } else if (i == 2) {
                axisLeft.setAxisMinimum(0.0f);
                axisLeft.setAxisMaximum(360.0f);
            }
        } else {
            int i2 = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
            if (i2 == 1) {
                axisLeft.setAxisMinimum(0.0f);
                axisLeft.setAxisMaximum(30.0f);
            } else if (i2 == 2) {
                axisLeft.setAxisMinimum(0.0f);
                axisLeft.setAxisMaximum(600.0f);
            }
        }
        xAxis.setGridDashedLine(new DashPathEffect(new float[]{20.0f, 1000.0f}, 0.0f));
        xAxis.setGridLineWidth(1.0f);
        axisLeft.setLabelCount(5, true);
        axisLeft.setTextSize(12.0f);
        axisLeft.setTextColor(color);
        ((FragmentTrendBinding) getBinding()).agpChart.getAxisLeft().setEnabled(true);
        ((FragmentTrendBinding) getBinding()).agpChart.getAxisRight().setEnabled(false);
        LineData lineData = new LineData();
        float f = 0.083333336f;
        if (!(dArr4 == null || dArr5 == null)) {
            List arrayList = new ArrayList();
            int i3 = 0;
            for (int i4 = DeviceModelKt.GLUCOSE_NUM_ONE_DAY; i3 < i4; i4 = DeviceModelKt.GLUCOSE_NUM_ONE_DAY) {
                arrayList.add(new Entry((((float) i3) + 0.5f) * f, UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L ? (float) dArr4[i3] : ((float) dArr4[i3]) * ((float) 18)));
                i3++;
                f = 0.083333336f;
            }
            LineDataSet lineDataSet = new LineDataSet(arrayList, "");
            lineDataSet.setDrawValues(false);
            lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet.setDrawCircles(false);
            int typeValue2 = ThemeManager.getTypeValue(getContext(), R.attr.colorTrendChart90);
            lineDataSet.setColor(typeValue2);
            lineDataSet.setLineWidth(0.0f);
            List arrayList2 = new ArrayList();
            for (int i5 = 0; i5 < 288; i5++) {
                arrayList2.add(new Entry((((float) i5) + 0.5f) * 0.083333336f, UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L ? (float) dArr5[i5] : ((float) dArr5[i5]) * ((float) 18)));
            }
            LineDataSet lineDataSet2 = new LineDataSet(arrayList2, "");
            lineDataSet2.setDrawValues(false);
            lineDataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet2.setDrawCircles(false);
            lineDataSet2.setColor(typeValue2);
            lineDataSet2.setLineWidth(0.0f);
            lineDataSet.setDrawFilled(true);
            lineDataSet.setClipPath(true);
            lineDataSet.setFillColor(typeValue2);
            lineDataSet.setFillAlpha(100);
            lineDataSet.setFillFormatter(new TrendsFragment$updateAgpChart$2(lineDataSet2));
            lineData.addDataSet(lineDataSet);
            lineData.addDataSet(lineDataSet2);
        }
        if (dArr2 == null || dArr3 == null) {
            z = true;
        } else {
            List arrayList3 = new ArrayList();
            for (int i6 = 0; i6 < 288; i6++) {
                arrayList3.add(new Entry((((float) i6) + 0.5f) * 0.083333336f, UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L ? (float) dArr2[i6] : ((float) dArr2[i6]) * ((float) 18)));
            }
            LineDataSet lineDataSet3 = new LineDataSet(arrayList3, "");
            lineDataSet3.setDrawValues(false);
            lineDataSet3.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet3.setDrawCircles(false);
            int typeValue3 = ThemeManager.getTypeValue(getContext(), R.attr.colorTrendChart75);
            lineDataSet3.setColor(typeValue3);
            lineDataSet3.setLineWidth(0.0f);
            List arrayList4 = new ArrayList();
            for (int i7 = 0; i7 < 288; i7++) {
                arrayList4.add(new Entry((((float) i7) + 0.5f) * 0.083333336f, UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L ? (float) dArr3[i7] : ((float) dArr3[i7]) * ((float) 18)));
            }
            LineDataSet lineDataSet4 = new LineDataSet(arrayList4, "");
            lineDataSet4.setDrawValues(false);
            lineDataSet4.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet4.setDrawCircles(false);
            lineDataSet4.setColor(typeValue3);
            lineDataSet4.setLineWidth(0.0f);
            z = true;
            lineDataSet3.setDrawFilled(true);
            lineDataSet3.setClipPath(true);
            lineDataSet3.setFillColor(typeValue3);
            lineDataSet3.setFillAlpha(100);
            lineDataSet3.setFillFormatter(new TrendsFragment$updateAgpChart$3(lineDataSet4));
            lineData.addDataSet(lineDataSet3);
            lineData.addDataSet(lineDataSet4);
        }
        if (dArr != null) {
            List arrayList5 = new ArrayList();
            boolean z2 = false;
            for (int i8 = 0; i8 < 288; i8++) {
                if (!Double.isNaN(dArr[i8])) {
                    arrayList5.add(new Entry((((float) i8) + 0.5f) * 0.083333336f, UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L ? (float) dArr[i8] : ((float) dArr[i8]) * ((float) 18)));
                    z2 = z;
                } else if (z2) {
                    break;
                }
            }
            LineDataSet lineDataSet5 = new LineDataSet(arrayList5, "");
            lineDataSet5.setDrawValues(false);
            lineDataSet5.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet5.setDrawCircles(false);
            lineDataSet5.setColor(ThemeManager.getTypeValue(getContext(), R.attr.colorTrendChartMain));
            lineDataSet5.setLineWidth(1.6f);
            lineData.addDataSet(lineDataSet5);
        }
        List dataSets = lineData.getDataSets();
        Intrinsics.checkNotNullExpressionValue(dataSets, "getDataSets(...)");
        if (!dataSets.isEmpty()) {
            CombinedData combinedData = new CombinedData();
            combinedData.setData(lineData);
            ((FragmentTrendBinding) getBinding()).agpChart.setData(combinedData);
        }
        ((FragmentTrendBinding) getBinding()).agpChart.invalidate();
    }

    /* access modifiers changed from: private */
    public final PieChartView.PieceDataHolder buildDataHolder(float f, int i) {
        return new PieChartView.PieceDataHolder(f, ContextCompat.getColor(requireContext(), i), ExtendsKt.getNumberFormatWithLocale().format(Float.valueOf(f)) + '%');
    }

    /* access modifiers changed from: private */
    public final void openCalendar() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        new CalendarDialog(requireContext, true, new TrendsFragment$openCalendar$1(this), new TrendsFragment$openCalendar$2(this)).show();
    }

    private final void updateTrends() {
        this.userIdCurrentShow = UserInfoManager.Companion.getCurShowUserId();
        ((FragmentTrendBinding) getBinding()).timeBegin.setText(ExtendsKt.formatToYMd(this.currentStartDate));
        Calendar instance = Calendar.getInstance();
        instance.setTime(this.currentEndDate);
        instance.add(5, -1);
        TextView textView = ((FragmentTrendBinding) getBinding()).timeEnd;
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        textView.setText(ExtendsKt.formatToYMd(time));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TrendsFragment$updateTrends$1(this, (Continuation<? super TrendsFragment$updateTrends$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/TrendsFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/trend/TrendsFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TrendsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TrendsFragment newInstance() {
            return new TrendsFragment();
        }
    }

    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == R.id.iv_generation_agp) {
            long time = this.currentEndDate.getTime() - this.currentStartDate.getTime();
            if (this.mNumGlucose < 7200 || time > 1382400000) {
                Dialogs dialogs = Dialogs.INSTANCE;
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                Dialogs.showMessage$default(dialogs, (AppCompatActivity) activity, getString(R.string.trend_agp_reselect_date_range), getString(R.string.trend_agp_date_range_tips), (String) null, (String) null, new TrendsFragment$onClick$1(this), 24, (Object) null);
                return;
            }
            Dialogs dialogs2 = Dialogs.INSTANCE;
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            Dialogs.showWhether$default(dialogs2, (AppCompatActivity) activity2, getString(R.string.trend_agp_generate_ensure), getString(R.string.trend_agp_analysis_tips), new TrendsFragment$onClick$2(this), (Function0) null, (String) null, (String) null, (String) null, 0, 496, (Object) null);
        } else if (id == R.id.txt_title_glucose) {
            Dialogs dialogs3 = Dialogs.INSTANCE;
            FragmentActivity activity3 = getActivity();
            Intrinsics.checkNotNull(activity3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            Dialogs.showMessage$default(dialogs3, (AppCompatActivity) activity3, getString(R.string.trend_ehba1c), getString(R.string.trend_ehba1c_msg), (String) null, (String) null, (Function0) null, 56, (Object) null);
        } else if (id == R.id.tv_average) {
            if (UnitManager.INSTANCE.getGlucoseUnit().getIndex() == 0) {
                str8 = ExtendsKt.getNumberFormatWithLocale().format(4.3d);
                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                str7 = ExtendsKt.getNumberFormatWithLocale().format(6.6d);
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            } else {
                str8 = String.valueOf(MathKt.roundToInt(77.39999999999999d));
                str7 = String.valueOf(MathKt.roundToInt(118.8d));
            }
            String displayUnit = UnitManager.INSTANCE.getDisplayUnit();
            Dialogs dialogs4 = Dialogs.INSTANCE;
            FragmentActivity activity4 = getActivity();
            Intrinsics.checkNotNull(activity4, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            Dialogs.showMessage$default(dialogs4, (AppCompatActivity) activity4, getString(R.string.trend_mbg), getString(R.string.trend_mbg_msg, str8, str7, displayUnit), (String) null, (String) null, (Function0) null, 56, (Object) null);
        } else if (id == R.id.txt_title_tir) {
            if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
                String format = ExtendsKt.getNumberFormatWithLocale().format(3.9d);
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                String format2 = ExtendsKt.getNumberFormatWithLocale().format(10.0d);
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                str5 = getString(R.string.cgm_unit_mmol);
                Intrinsics.checkNotNullExpressionValue(str5, "getString(...)");
                String format3 = ExtendsKt.getNumberFormatWithLocale().format(3.9d);
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                str6 = ExtendsKt.getNumberFormatWithLocale().format(7.8d);
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                str4 = getString(R.string.cgm_unit_mmol);
                Intrinsics.checkNotNullExpressionValue(str4, "getString(...)");
                str3 = format;
                str2 = format2;
                str = format3;
            } else {
                String valueOf = String.valueOf(MathKt.roundToInt(70.2d));
                str5 = getString(R.string.cgm_unit_mg);
                Intrinsics.checkNotNullExpressionValue(str5, "getString(...)");
                String valueOf2 = String.valueOf(MathKt.roundToInt(70.2d));
                str6 = String.valueOf(MathKt.roundToInt(140.4d));
                str4 = getString(R.string.cgm_unit_mg);
                Intrinsics.checkNotNullExpressionValue(str4, "getString(...)");
                str = valueOf2;
                str2 = "180";
                str3 = valueOf;
            }
            Dialogs dialogs5 = Dialogs.INSTANCE;
            FragmentActivity activity5 = getActivity();
            Intrinsics.checkNotNull(activity5, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            String string = getString(R.string.trend_tir);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = getString(R.string.trend_tir_msg);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String format4 = String.format(string2, Arrays.copyOf(new Object[]{str3, str2, str5, str, str6, str4}, 6));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            Dialogs.showMessage$default(dialogs5, (AppCompatActivity) activity5, string, format4, (String) null, (String) null, (Function0) null, 56, (Object) null);
        } else if (id == R.id.txt_title_agp) {
            Dialogs dialogs6 = Dialogs.INSTANCE;
            FragmentActivity activity6 = getActivity();
            Intrinsics.checkNotNull(activity6, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            Dialogs.showMessage$default(dialogs6, (AppCompatActivity) activity6, getString(R.string.trend_agp), getString(R.string.trend_agp_msg), (String) null, (String) null, (Function0) null, 56, (Object) null);
        } else if (id == R.id.txt_title_LBGI) {
            Dialogs dialogs7 = Dialogs.INSTANCE;
            FragmentActivity activity7 = getActivity();
            Intrinsics.checkNotNull(activity7, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            Dialogs.showMessage$default(dialogs7, (AppCompatActivity) activity7, getString(R.string.trend_lbgi), getString(R.string.trend_lbgi_msg), (String) null, (String) null, (Function0) null, 56, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fe, code lost:
        if (r10 != null) goto L_0x0102;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object genAgp(kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            java.lang.String r2 = "getString(...)"
            boolean r3 = r1 instanceof com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$1
            if (r3 == 0) goto L_0x001a
            r3 = r1
            com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$1 r3 = (com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r1 = r3.label
            int r1 = r1 - r5
            r3.label = r1
            goto L_0x001f
        L_0x001a:
            com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$1 r3 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$1
            r3.<init>(r0, r1)
        L_0x001f:
            java.lang.Object r1 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L_0x0045
            if (r5 != r6) goto L_0x003d
            java.lang.Object r2 = r3.L$2
            okhttp3.FormBody r2 = (okhttp3.FormBody) r2
            java.lang.Object r4 = r3.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.L$0
            com.microtech.aidexx.ui.main.trend.TrendsFragment r3 = (com.microtech.aidexx.ui.main.trend.TrendsFragment) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x024a
        L_0x003d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r1 = "gp"
            int r5 = r1.hashCode()
            r7 = 3305(0xce9, float:4.631E-42)
            java.lang.String r8 = ""
            if (r5 == r7) goto L_0x0055
            goto L_0x0088
        L_0x0055:
            boolean r1 = r1.equals(r1)
            if (r1 == 0) goto L_0x0088
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r1 = r1.instance()
            com.microtech.aidexx.db.entity.UserEntity r1 = r1.getUserEntity()
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = r1.getEmail()
            if (r1 != 0) goto L_0x006e
        L_0x006d:
            r1 = r8
        L_0x006e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.microtech.aidexx.common.Constants r7 = com.microtech.aidexx.common.Constants.INSTANCE
            java.lang.String r7 = r7.getAGP_URL_DOMAIN()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = "/aidex?id=%s&name=%s&device=%s&start=%s&end=%s&gender=%s&email=%s&hypo=%s&hyper=%s&unit=%s&birthday=%s&height=%s&weight=%s&diagnosis=%s"
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            goto L_0x00b4
        L_0x0088:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r1 = r1.instance()
            com.microtech.aidexx.db.entity.UserEntity r1 = r1.getUserEntity()
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = r1.getPhone()
            if (r1 != 0) goto L_0x009b
        L_0x009a:
            r1 = r8
        L_0x009b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.microtech.aidexx.common.Constants r7 = com.microtech.aidexx.common.Constants.INSTANCE
            java.lang.String r7 = r7.getAGP_URL_DOMAIN()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = "/aidex?id=%s&name=%s&device=%s&start=%s&end=%s&gender=%s&phone=%s&hypo=%s&hyper=%s&unit=%s&birthday=%s&height=%s&weight=%s&diagnosis=%s"
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
        L_0x00b4:
            r15 = r1
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r1 = r1.instance()
            com.microtech.aidexx.db.entity.UserEntity r1 = r1.getUserEntity()
            if (r1 == 0) goto L_0x00c6
            java.lang.String r1 = r1.getFullName()
            goto L_0x00c7
        L_0x00c6:
            r1 = 0
        L_0x00c7:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r9 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r9 = r9.instance()
            com.microtech.aidexx.db.entity.UserEntity r9 = r9.getUserEntity()
            if (r9 == 0) goto L_0x00d8
            java.lang.Integer r9 = r9.getGender()
            goto L_0x00d9
        L_0x00d8:
            r9 = 0
        L_0x00d9:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r10 = com.microtech.aidexx.common.user.UserInfoManager.Companion     // Catch:{ Exception -> 0x0105 }
            com.microtech.aidexx.common.user.UserInfoManager r10 = r10.instance()     // Catch:{ Exception -> 0x0105 }
            com.microtech.aidexx.db.entity.UserEntity r10 = r10.getUserEntity()     // Catch:{ Exception -> 0x0105 }
            if (r10 == 0) goto L_0x0101
            java.lang.String r10 = r10.getBirthDate()     // Catch:{ Exception -> 0x0105 }
            if (r10 == 0) goto L_0x0101
            int r11 = com.microtech.aidexx.R.string.com_dateFormat_yyyyMM     // Catch:{ Exception -> 0x0105 }
            java.lang.String r11 = r0.getString(r11)     // Catch:{ Exception -> 0x0105 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch:{ Exception -> 0x0105 }
            java.util.Date r10 = com.microtech.aidexx.common.ExtendsKt.dateAndYM((java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x0105 }
            if (r10 == 0) goto L_0x0101
            java.lang.String r10 = com.microtech.aidexx.common.ExtendsKt.date2YMDByEnglish(r10)     // Catch:{ Exception -> 0x0105 }
            if (r10 == 0) goto L_0x0101
            goto L_0x0102
        L_0x0101:
            r10 = r8
        L_0x0102:
            r19 = r10
            goto L_0x0107
        L_0x0105:
            r19 = r8
        L_0x0107:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r10 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r10 = r10.instance()
            java.lang.String r14 = r10.userId()
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r10 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r10 = r10.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r10 = r10.getDefault()
            if (r10 == 0) goto L_0x012c
            com.microtech.aidexx.db.entity.TransmitterEntity r10 = r10.getEntity()
            if (r10 == 0) goto L_0x012c
            java.lang.String r10 = r10.getDeviceSn()
            if (r10 != 0) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r11 = r10
            goto L_0x012d
        L_0x012c:
            r11 = r8
        L_0x012d:
            java.util.Date r10 = r0.currentStartDate
            java.lang.String r12 = com.microtech.aidexx.common.ExtendsKt.date2YMDByEnglish(r10)
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            java.util.Date r13 = r0.currentEndDate
            r10.setTime(r13)
            r13 = 5
            r7 = -1
            r10.add(r13, r7)
            java.util.Date r7 = r10.getTime()
            java.lang.String r10 = "getTime(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r10)
            java.lang.String r13 = com.microtech.aidexx.common.ExtendsKt.date2YMDByEnglish(r7)
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            if (r1 != 0) goto L_0x0154
            r10 = r8
            goto L_0x0155
        L_0x0154:
            r10 = r1
        L_0x0155:
            if (r9 != 0) goto L_0x0159
            r1 = r8
            goto L_0x0183
        L_0x0159:
            int r1 = r9.intValue()
            if (r1 != r6) goto L_0x0169
            int r1 = com.microtech.aidexx.R.string.user_info_gender_male
            java.lang.String r1 = r0.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x0183
        L_0x0169:
            r1 = 2
            int r7 = r9.intValue()
            if (r7 != r1) goto L_0x017a
            int r1 = com.microtech.aidexx.R.string.user_info_gender_female
            java.lang.String r1 = r0.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            goto L_0x0183
        L_0x017a:
            int r1 = com.microtech.aidexx.R.string.user_info_gender_other
            java.lang.String r1 = r0.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x0183:
            com.microtech.aidexx.utils.ThresholdManager r2 = com.microtech.aidexx.utils.ThresholdManager.INSTANCE
            float r2 = r2.getCurUserHypo()
            r7 = 1099956224(0x41900000, float:18.0)
            float r2 = r2 / r7
            java.lang.Float r16 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            com.microtech.aidexx.utils.ThresholdManager r2 = com.microtech.aidexx.utils.ThresholdManager.INSTANCE
            float r2 = r2.getCurUserHyper()
            float r2 = r2 / r7
            java.lang.Float r17 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            com.microtech.aidexx.utils.UnitManager r2 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            com.microtech.aidexx.utils.UnitManager$GlucoseUnit r2 = r2.getGlucoseUnit()
            int r2 = r2.getIndex()
            java.lang.Integer r18 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r2 = r2.instance()
            com.microtech.aidexx.db.entity.UserEntity r2 = r2.getUserEntity()
            if (r2 == 0) goto L_0x01ce
            java.lang.Integer r2 = r2.getHeight()
            if (r2 == 0) goto L_0x01ce
            int r2 = r2.intValue()
            float r2 = (float) r2
            r7 = 1120403456(0x42c80000, float:100.0)
            float r2 = r2 / r7
            float r2 = com.microtech.aidexx.common.ExtendsKt.roundTwoDigits(r2)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r20 = r2
            goto L_0x01d0
        L_0x01ce:
            r20 = r8
        L_0x01d0:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r2 = r2.instance()
            com.microtech.aidexx.db.entity.UserEntity r2 = r2.getUserEntity()
            if (r2 == 0) goto L_0x01e6
            java.lang.Integer r2 = r2.getBodyWeight()
            if (r2 != 0) goto L_0x01e3
            goto L_0x01e6
        L_0x01e3:
            r21 = r2
            goto L_0x01e8
        L_0x01e6:
            r21 = r8
        L_0x01e8:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r2 = r2.instance()
            com.microtech.aidexx.db.entity.UserEntity r2 = r2.getUserEntity()
            if (r2 == 0) goto L_0x01fe
            java.lang.String r2 = r2.getDiabetesTypeDisplayName()
            if (r2 != 0) goto L_0x01fb
            goto L_0x01fe
        L_0x01fb:
            r22 = r2
            goto L_0x0200
        L_0x01fe:
            r22 = r8
        L_0x0200:
            r9 = r14
            r2 = r14
            r14 = r1
            java.lang.Object[] r1 = new java.lang.Object[]{r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}
            r7 = 14
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r7)
            java.lang.String r1 = java.lang.String.format(r5, r1)
            java.lang.String r5 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            com.microtech.aidexx.views.dialog.Dialogs r5 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            int r7 = com.microtech.aidexx.R.string.com_loading
            java.lang.String r7 = r0.getString(r7)
            r5.showWait(r7)
            okhttp3.FormBody$Builder r5 = new okhttp3.FormBody$Builder
            r7 = 0
            r5.<init>(r7, r6, r7)
            okhttp3.FormBody r5 = r5.build()
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$encodeResult$1 r9 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$encodeResult$1
            r9.<init>(r1, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r3.L$0 = r0
            r3.L$1 = r2
            r3.L$2 = r5
            r3.label = r6
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r8, r9, r3)
            if (r1 != r4) goto L_0x0247
            return r4
        L_0x0247:
            r3 = r0
            r4 = r2
            r2 = r5
        L_0x024a:
            java.lang.String r1 = (java.lang.String) r1
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder
            r5.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.microtech.aidexx.common.Constants r7 = com.microtech.aidexx.common.Constants.INSTANCE
            java.lang.String r7 = r7.getAGP_URL()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = "?userId="
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.String r6 = "&url="
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r1 = r1.toString()
            okhttp3.Request$Builder r1 = r5.url((java.lang.String) r1)
            okhttp3.RequestBody r2 = (okhttp3.RequestBody) r2
            okhttp3.Request$Builder r1 = r1.post(r2)
            okhttp3.Request r1 = r1.build()
            com.microtech.aidexx.common.net.ApiService$Companion r2 = com.microtech.aidexx.common.net.ApiService.Companion
            okhttp3.OkHttpClient r2 = r2.getOkClient()
            okhttp3.Call r1 = r2.newCall(r1)
            com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$2 r2 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$2
            r2.<init>(r3)
            okhttp3.Callback r2 = (okhttp3.Callback) r2
            r1.enqueue(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsFragment.genAgp(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadAgp(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$1 r0 = (com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$1 r0 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.ui.main.trend.TrendsFragment r2 = (com.microtech.aidexx.ui.main.trend.TrendsFragment) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0054
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r8 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r6
        L_0x0054:
            com.microtech.aidexx.utils.FileUtils r8 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            java.lang.String r4 = "agp"
            java.lang.String r8 = r8.getDownloadDir(r4)
            com.microtech.aidexx.common.net.repository.ApiRepository r4 = com.microtech.aidexx.common.net.repository.ApiRepository.INSTANCE
            java.lang.String r5 = "agp_report.pdf"
            kotlinx.coroutines.flow.Flow r4 = r4.downloadFile(r7, r8, r5)
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2 r5 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2
            r5.<init>(r2, r7, r8)
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r4.collect(r5, r0)
            if (r7 != r1) goto L_0x0079
            return r1
        L_0x0079:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsFragment.downloadAgp(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String getFormatText(float f) {
        int i = (int) f;
        if (i < 10) {
            return ExtendsKt.getNumberFormatStr(0) + ExtendsKt.getNumberFormatStr(i) + ':' + ExtendsKt.getNumberFormatStr(0) + ExtendsKt.getNumberFormatStr(0);
        }
        return ExtendsKt.getNumberFormatStr(i) + ':' + ExtendsKt.getNumberFormatStr(0) + ExtendsKt.getNumberFormatStr(0);
    }
}

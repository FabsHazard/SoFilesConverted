package com.microtech.aidexx.ui.main.home.chart;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.chart.MyChart;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/microtech/aidexx/ui/main/home/chart/ChartViewHolder$1$6", "Lcom/microtech/aidexx/views/chart/MyChart$ScrollListener;", "onToEndLeft", "", "onToEndRight", "onXAxisVisibleAreaChanged", "", "isLtr", "", "visibleLeftX", "", "visibleRightX", "xAxisMin", "xAxisMax", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewHolder.kt */
public final class ChartViewHolder$1$6 implements MyChart.ScrollListener {
    final /* synthetic */ FragmentHomeBinding $this_run;
    final /* synthetic */ ChartViewHolder this$0;

    ChartViewHolder$1$6(ChartViewHolder chartViewHolder, FragmentHomeBinding fragmentHomeBinding) {
        this.this$0 = chartViewHolder;
        this.$this_run = fragmentHomeBinding;
    }

    public int onXAxisVisibleAreaChanged(boolean z, float f, float f2, float f3, float f4) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0.fragment), (CoroutineContext) null, (CoroutineStart) null, new ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1(f4, f, this.this$0, this.$this_run, (Continuation<? super ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1>) null), 3, (Object) null);
        int needLoadNextPage = this.this$0.getChartViewModel().needLoadNextPage(z, f, f2, f3);
        if (needLoadNextPage == 1) {
            LogUtil.Companion.d("===CHART=== startLoadNextPage: " + this.this$0.getChartViewModel().getStartLoadNextPage().compareAndSet(false, true), ChartViewHolder.TAG);
        }
        return needLoadNextPage;
    }

    public void onToEndLeft() {
        LogUtil.Companion.d("===CHART===onToEndLeft start applyData: " + this.this$0.getChartViewModel().getStartApplyNextPageData().compareAndSet(false, true), ChartViewHolder.TAG);
    }

    public void onToEndRight() {
        LogUtil.Companion.d("===CHART===onToEndRight", ChartViewHolder.TAG);
        this.this$0.getChartViewModel().onChartToEndRight();
    }
}

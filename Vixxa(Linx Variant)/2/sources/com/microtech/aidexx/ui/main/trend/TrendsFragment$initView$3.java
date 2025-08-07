package com.microtech.aidexx.ui.main.trend;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.views.chart.GlucoseChart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010@\u001a\u00020\u0016H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020BH\u0016J\b\u0010D\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020BH\u0016J\b\u0010F\u001a\u00020BH\u0016J\b\u0010G\u001a\u00020BH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RN\u0010\u0014\u001a6\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0005\"\u0004\b*\u0010\u0007R\u001c\u0010+\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0005\"\u0004\b-\u0010\u0007R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0005\"\u0004\b6\u0010\u0007R\u001c\u00107\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0005\"\u0004\b9\u0010\u0007R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006H"}, d2 = {"com/microtech/aidexx/ui/main/trend/TrendsFragment$initView$3", "Lcom/microtech/aidexx/views/chart/GlucoseChart$ExtraParams;", "curDateTv", "Landroid/widget/TextView;", "getCurDateTv", "()Landroid/widget/TextView;", "setCurDateTv", "(Landroid/widget/TextView;)V", "goToHistory", "Landroid/widget/ImageView;", "getGoToHistory", "()Landroid/widget/ImageView;", "setGoToHistory", "(Landroid/widget/ImageView;)V", "llValue", "Landroid/widget/LinearLayout;", "getLlValue", "()Landroid/widget/LinearLayout;", "setLlValue", "(Landroid/widget/LinearLayout;)V", "onChartEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "", "obj", "", "getOnChartEvent", "()Lkotlin/jvm/functions/Function2;", "setOnChartEvent", "(Lkotlin/jvm/functions/Function2;)V", "onGoToHistory", "Lkotlin/Function1;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "getOnGoToHistory", "()Lkotlin/jvm/functions/Function1;", "setOnGoToHistory", "(Lkotlin/jvm/functions/Function1;)V", "outerDescriptionU", "getOuterDescriptionU", "setOuterDescriptionU", "outerDescriptionUnit", "getOuterDescriptionUnit", "setOuterDescriptionUnit", "outerDescriptionView", "Landroid/view/View;", "getOuterDescriptionView", "()Landroid/view/View;", "setOuterDescriptionView", "(Landroid/view/View;)V", "outerDescriptionX", "getOuterDescriptionX", "setOuterDescriptionX", "outerDescriptionY", "getOuterDescriptionY", "setOuterDescriptionY", "rlDescription", "Landroid/widget/RelativeLayout;", "getRlDescription", "()Landroid/widget/RelativeLayout;", "setRlDescription", "(Landroid/widget/RelativeLayout;)V", "getYAxisStyle", "lowerLimit", "", "upperLimit", "xMargin", "xMax", "xMin", "xRange", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
public final class TrendsFragment$initView$3 implements GlucoseChart.ExtraParams {
    private TextView curDateTv;
    private ImageView goToHistory;
    private LinearLayout llValue;
    private Function2<? super Integer, Object, Unit> onChartEvent;
    private Function1<? super BaseEventEntity, Unit> onGoToHistory;
    private TextView outerDescriptionU;
    private TextView outerDescriptionUnit;
    private View outerDescriptionView;
    private TextView outerDescriptionX;
    private TextView outerDescriptionY;
    private RelativeLayout rlDescription;
    final /* synthetic */ TrendsFragment this$0;

    public int getYAxisStyle() {
        return 3;
    }

    TrendsFragment$initView$3(TrendsFragment trendsFragment) {
        this.this$0 = trendsFragment;
    }

    public View getOuterDescriptionView() {
        return this.outerDescriptionView;
    }

    public void setOuterDescriptionView(View view) {
        this.outerDescriptionView = view;
    }

    public LinearLayout getLlValue() {
        return this.llValue;
    }

    public void setLlValue(LinearLayout linearLayout) {
        this.llValue = linearLayout;
    }

    public TextView getOuterDescriptionY() {
        return this.outerDescriptionY;
    }

    public void setOuterDescriptionY(TextView textView) {
        this.outerDescriptionY = textView;
    }

    public TextView getOuterDescriptionUnit() {
        return this.outerDescriptionUnit;
    }

    public void setOuterDescriptionUnit(TextView textView) {
        this.outerDescriptionUnit = textView;
    }

    public TextView getOuterDescriptionX() {
        return this.outerDescriptionX;
    }

    public void setOuterDescriptionX(TextView textView) {
        this.outerDescriptionX = textView;
    }

    public RelativeLayout getRlDescription() {
        return this.rlDescription;
    }

    public void setRlDescription(RelativeLayout relativeLayout) {
        this.rlDescription = relativeLayout;
    }

    public TextView getOuterDescriptionU() {
        return this.outerDescriptionU;
    }

    public void setOuterDescriptionU(TextView textView) {
        this.outerDescriptionU = textView;
    }

    public ImageView getGoToHistory() {
        return this.goToHistory;
    }

    public void setGoToHistory(ImageView imageView) {
        this.goToHistory = imageView;
    }

    public Function1<BaseEventEntity, Unit> getOnGoToHistory() {
        return this.onGoToHistory;
    }

    public void setOnGoToHistory(Function1<? super BaseEventEntity, Unit> function1) {
        this.onGoToHistory = function1;
    }

    public TextView getCurDateTv() {
        return this.curDateTv;
    }

    public void setCurDateTv(TextView textView) {
        this.curDateTv = textView;
    }

    public float xMax() {
        return ((TrendsViewModel) this.this$0.getViewModel()).xMax();
    }

    public float xMin() {
        return ((TrendsViewModel) this.this$0.getViewModel()).xMin();
    }

    public float xRange() {
        return ((TrendsViewModel) this.this$0.getViewModel()).xRange();
    }

    public float xMargin() {
        return ((TrendsViewModel) this.this$0.getViewModel()).xMargin();
    }

    public float lowerLimit() {
        return ((TrendsViewModel) this.this$0.getViewModel()).getLowerLimit();
    }

    public float upperLimit() {
        return ((TrendsViewModel) this.this$0.getViewModel()).getUpperLimit();
    }

    public Function2<Integer, Object, Unit> getOnChartEvent() {
        return this.onChartEvent;
    }

    public void setOnChartEvent(Function2<? super Integer, Object, Unit> function2) {
        this.onChartEvent = function2;
    }
}

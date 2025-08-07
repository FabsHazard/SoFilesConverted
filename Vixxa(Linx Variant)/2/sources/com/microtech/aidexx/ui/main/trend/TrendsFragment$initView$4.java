package com.microtech.aidexx.ui.main.trend;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentTrendBinding;
import com.microtech.aidexx.ui.main.trend.view.LbgiCursorView;
import com.microtech.aidexx.utils.UnitManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment$initView$4", f = "TrendsFragment.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$initView$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$initView$4(TrendsFragment trendsFragment, Continuation<? super TrendsFragment$initView$4> continuation) {
        super(2, continuation);
        this.this$0 = trendsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendsFragment$initView$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrendsFragment$initView$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "trendInfo", "Lcom/microtech/aidexx/ui/main/trend/TrendsInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment$initView$4$1", f = "TrendsFragment.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.trend.TrendsFragment$initView$4$1  reason: invalid class name */
    /* compiled from: TrendsFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<TrendsInfo, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(trendsFragment, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(TrendsInfo trendsInfo, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(trendsInfo, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TrendsInfo trendsInfo = (TrendsInfo) this.L$0;
                ((FragmentTrendBinding) trendsFragment.getBinding()).trendRefreshLayout.finishRefresh();
                if (trendsInfo != null) {
                    TrendsFragment trendsFragment = trendsFragment;
                    ((FragmentTrendBinding) trendsFragment.getBinding()).tvCoverTimeValue.setText(trendsInfo.getCoverTime());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).tvMonitorTimesValue.setText(ExtendsKt.getNumberFormatWithLocale().format(Boxing.boxInt(Integer.parseInt(trendsInfo.getMonitorTimes()))));
                    trendsFragment.mNumGlucose = Integer.parseInt(trendsInfo.getMonitorTimes());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).ehba1cValue.setText(trendsInfo.getEHbA1c());
                    ImageView imageView = ((FragmentTrendBinding) trendsFragment.getBinding()).ivEhba1cTrends;
                    Intrinsics.checkNotNullExpressionValue(imageView, "ivEhba1cTrends");
                    int i2 = 8;
                    imageView.setVisibility(trendsInfo.getShowEhbA1cTrend() ? 0 : 8);
                    ((FragmentTrendBinding) trendsFragment.getBinding()).tvMbgValue.setText(trendsInfo.getMbg());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).tvMbgUnit.setText(UnitManager.INSTANCE.getDisplayUnit());
                    ImageView imageView2 = ((FragmentTrendBinding) trendsFragment.getBinding()).ivMbgTrends;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "ivMbgTrends");
                    imageView2.setVisibility(trendsInfo.getShowMbgTrend() ? 0 : 8);
                    ((FragmentTrendBinding) trendsFragment.getBinding()).pieChart.setData(CollectionsKt.listOf(trendsFragment.buildDataHolder((float) trendsInfo.getLowPercent(), R.color.colorGlucoseLow), trendsFragment.buildDataHolder((float) trendsInfo.getNormalPercent(), R.color.colorGlucoseNormal), trendsFragment.buildDataHolder((float) trendsInfo.getHighPercent(), R.color.colorGlucoseHigh)));
                    ((FragmentTrendBinding) trendsFragment.getBinding()).highPercent.setText(trendsInfo.getHighPercentDisplay());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).descHigh.setText(trendsInfo.getHighPercentDesc());
                    ImageView imageView3 = ((FragmentTrendBinding) trendsFragment.getBinding()).ivHighTrends;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "ivHighTrends");
                    imageView3.setVisibility(trendsInfo.getShowHighPercentTrend() ? 0 : 8);
                    ((FragmentTrendBinding) trendsFragment.getBinding()).normalPercent.setText(trendsInfo.getNormalPercentDisplay());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).descNormal.setText(trendsInfo.getNormalPercentDesc());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).lowPercent.setText(trendsInfo.getLowPercentDisplay());
                    ((FragmentTrendBinding) trendsFragment.getBinding()).descLow.setText(trendsInfo.getLowPercentDesc());
                    ImageView imageView4 = ((FragmentTrendBinding) trendsFragment.getBinding()).ivLowTrends;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "ivLowTrends");
                    imageView4.setVisibility(trendsInfo.getShowLowPercentTrend() ? 0 : 8);
                    TextView textView = ((FragmentTrendBinding) trendsFragment.getBinding()).txtEmptyPies;
                    Intrinsics.checkNotNullExpressionValue(textView, "txtEmptyPies");
                    View view = textView;
                    if (trendsInfo.getShowPieNoData()) {
                        i2 = 0;
                    }
                    view.setVisibility(i2);
                    trendsFragment.updateAgpChart(trendsInfo.getDailyP50(), trendsInfo.getDailyP75(), trendsInfo.getDailyP25(), trendsInfo.getDailyP90(), trendsInfo.getDailyP10());
                    LbgiCursorView lbgiCursorView = ((FragmentTrendBinding) trendsFragment.getBinding()).cursorView;
                    String format = trendsFragment.oneDigitFormat.format(trendsInfo.getLbgi());
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    Number parseToNumberByEnglish = ExtendsKt.parseToNumberByEnglish(format);
                    lbgiCursorView.setValue(parseToNumberByEnglish != null ? Boxing.boxFloat(parseToNumberByEnglish.floatValue()) : null);
                    List<MultiDayBgItem> multiDayHistory = trendsInfo.getMultiDayHistory();
                    if (multiDayHistory != null) {
                        ((FragmentTrendBinding) trendsFragment.getBinding()).expandableGrid.refreshData(multiDayHistory);
                    }
                    List<MultiDayBgItem> dataSet = ((FragmentTrendBinding) trendsFragment.getBinding()).expandableGrid.getDataSet();
                    this.label = 1;
                    if (trendsFragment.updateMultiChart(dataSet, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TrendsFragment trendsFragment = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(((TrendsViewModel) this.this$0.getViewModel()).getCgatFlow(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

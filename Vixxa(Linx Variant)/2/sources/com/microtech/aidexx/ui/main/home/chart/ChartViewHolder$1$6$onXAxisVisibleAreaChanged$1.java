package com.microtech.aidexx.ui.main.home.chart;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
import com.microtech.aidexx.views.chart.ChartUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1", f = "ChartViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewHolder.kt */
final class ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentHomeBinding $this_run;
    final /* synthetic */ float $visibleLeftX;
    final /* synthetic */ float $xAxisMax;
    int label;
    final /* synthetic */ ChartViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1(float f, float f2, ChartViewHolder chartViewHolder, FragmentHomeBinding fragmentHomeBinding, Continuation<? super ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1> continuation) {
        super(2, continuation);
        this.$xAxisMax = f;
        this.$visibleLeftX = f2;
        this.this$0 = chartViewHolder;
        this.$this_run = fragmentHomeBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1(this.$xAxisMax, this.$visibleLeftX, this.this$0, this.$this_run, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$xAxisMax - this.$visibleLeftX >= this.this$0.oneDayX && this.this$0.needTipJumpByCalendar) {
                this.this$0.needTipJumpByCalendar = false;
                Animator loadAnimator = AnimatorInflater.loadAnimator(this.this$0.fragment.requireContext(), R.anim.anim_date_tip);
                Intrinsics.checkNotNull(loadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
                AnimatorSet animatorSet = (AnimatorSet) loadAnimator;
                animatorSet.setTarget(this.$this_run.chartDateTip);
                animatorSet.addListener(new ChartViewHolder$1$6$onXAxisVisibleAreaChanged$1$invokeSuspend$$inlined$addListener$default$1(this.$this_run, this.this$0));
                animatorSet.start();
                String string = this.this$0.fragment.getString(R.string.home_tip_calendar);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
            }
            ChartViewHolder chartViewHolder = this.this$0;
            Date date = new Date();
            date.setTime(ChartUtil.INSTANCE.xToSecond(this.$visibleLeftX) * ((long) 1000));
            chartViewHolder.curDate = date;
            TextView textView = this.$this_run.chartDateTip;
            Date access$getCurDate$p = this.this$0.curDate;
            Intrinsics.checkNotNull(access$getCurDate$p);
            textView.setText(ExtendsKt.formatToMd(access$getCurDate$p));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

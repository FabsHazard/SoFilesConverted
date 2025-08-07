package com.microtech.aidexx.ui.main.home.chart;

import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
import com.microtech.aidexx.views.chart.ChartUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "type", "", "obj", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewHolder.kt */
final class ChartViewHolder$1$5$onChartEvent$1 extends Lambda implements Function2<Integer, Object, Unit> {
    final /* synthetic */ FragmentHomeBinding $this_run;
    final /* synthetic */ ChartViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewHolder$1$5$onChartEvent$1(ChartViewHolder chartViewHolder, FragmentHomeBinding fragmentHomeBinding) {
        super(2);
        this.this$0 = chartViewHolder;
        this.$this_run = fragmentHomeBinding;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), obj2);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewHolder$1$5$onChartEvent$1$1", f = "ChartViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.chart.ChartViewHolder$1$5$onChartEvent$1$1  reason: invalid class name */
    /* compiled from: ChartViewHolder.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(chartViewHolder, fragmentHomeBinding, obj, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChartViewHolder chartViewHolder = chartViewHolder;
                Date date = new Date();
                date.setTime(ChartUtil.INSTANCE.xToSecond(((Number) obj).floatValue()) * ((long) 1000));
                chartViewHolder.curDate = date;
                TextView textView = fragmentHomeBinding.chartDateTip;
                Date access$getCurDate$p = chartViewHolder.curDate;
                Intrinsics.checkNotNull(access$getCurDate$p);
                textView.setText(ExtendsKt.formatToMd(access$getCurDate$p));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void invoke(int i, final Object obj) {
        if (i == 1 && (obj instanceof Float)) {
            final ChartViewHolder chartViewHolder = this.this$0;
            final FragmentHomeBinding fragmentHomeBinding = this.$this_run;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0.fragment), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }
}

package com.microtech.aidexx.ui.main.history;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentHistoryBinding;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.HistoryFragment$initTitle$1$1", f = "HistoryFragment.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HistoryFragment.kt */
final class HistoryFragment$initTitle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentHistoryBinding $this_apply;
    int label;
    final /* synthetic */ HistoryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HistoryFragment$initTitle$1$1(HistoryFragment historyFragment, FragmentHistoryBinding fragmentHistoryBinding, Continuation<? super HistoryFragment$initTitle$1$1> continuation) {
        super(2, continuation);
        this.this$0 = historyFragment;
        this.$this_apply = fragmentHistoryBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryFragment$initTitle$1$1(this.this$0, this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HistoryFragment$initTitle$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "it", "Ljava/util/Date;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.history.HistoryFragment$initTitle$1$1$1", f = "HistoryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.history.HistoryFragment$initTitle$1$1$1  reason: invalid class name */
    /* compiled from: HistoryFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Date, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(fragmentHistoryBinding, historyFragment, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Date date, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(date, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Date date = (Date) this.L$0;
                if (date == null) {
                    date = new Date();
                }
                fragmentHistoryBinding.tvTimeSelected.setText(ExtendsKt.formatToYMd(date));
                if (ExtendsKt.isSameDay(new Date(), date)) {
                    fragmentHistoryBinding.btnNextDay.setClickable(false);
                    fragmentHistoryBinding.btnNextDay.setColorFilter(historyFragment.getResources().getColor(R.color.gray1, (Resources.Theme) null), PorterDuff.Mode.SRC_IN);
                } else {
                    fragmentHistoryBinding.btnNextDay.setClickable(true);
                    fragmentHistoryBinding.btnNextDay.clearColorFilter();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FragmentHistoryBinding fragmentHistoryBinding = this.$this_apply;
            final HistoryFragment historyFragment = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(this.this$0.getVm().getCurDate(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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

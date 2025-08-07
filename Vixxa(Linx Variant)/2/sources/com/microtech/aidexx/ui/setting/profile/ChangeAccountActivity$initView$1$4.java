package com.microtech.aidexx.ui.setting.profile;

import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.ActivityChangeAccountBinding;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ChangeAccountActivity$initView$1$4", f = "ChangeAccountActivity.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChangeAccountActivity.kt */
final class ChangeAccountActivity$initView$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivityChangeAccountBinding $this_apply;
    int label;
    final /* synthetic */ ChangeAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChangeAccountActivity$initView$1$4(ChangeAccountActivity changeAccountActivity, ActivityChangeAccountBinding activityChangeAccountBinding, Continuation<? super ChangeAccountActivity$initView$1$4> continuation) {
        super(2, continuation);
        this.this$0 = changeAccountActivity;
        this.$this_apply = activityChangeAccountBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangeAccountActivity$initView$1$4(this.this$0, this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangeAccountActivity$initView$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ChangeAccountActivity$initView$1$4$1", f = "ChangeAccountActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.profile.ChangeAccountActivity$initView$1$4$1  reason: invalid class name */
    /* compiled from: ChangeAccountActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends Integer>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(activityChangeAccountBinding, changeAccountActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Pair<Boolean, Integer> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                if (pair != null) {
                    ActivityChangeAccountBinding activityChangeAccountBinding = activityChangeAccountBinding;
                    ChangeAccountActivity changeAccountActivity = changeAccountActivity;
                    if (((Boolean) pair.getFirst()).booleanValue()) {
                        activityChangeAccountBinding.btnGetCode.setTextColor(ThemeManager.getTypeValue(changeAccountActivity, R.attr.textColorHint));
                        activityChangeAccountBinding.btnGetCode.setClickable(false);
                        activityChangeAccountBinding.btnGetCode.setText(changeAccountActivity.getString(R.string.user_sign_getCode_retry, new Object[]{((Number) pair.getSecond()).intValue() + "s "}));
                    } else {
                        activityChangeAccountBinding.btnGetCode.setTextColor(ThemeManager.getTypeValue(changeAccountActivity, R.attr.appColorAccent));
                        activityChangeAccountBinding.btnGetCode.setClickable(true);
                        activityChangeAccountBinding.btnGetCode.setText(changeAccountActivity.getString(R.string.user_sign_getCode_retry, new Object[]{""}));
                    }
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
            final ActivityChangeAccountBinding activityChangeAccountBinding = this.$this_apply;
            final ChangeAccountActivity changeAccountActivity = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(this.this$0.getPVm().getSendCodeTimeLeft(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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

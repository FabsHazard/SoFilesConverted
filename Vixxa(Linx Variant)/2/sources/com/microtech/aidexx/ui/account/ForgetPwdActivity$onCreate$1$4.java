package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.ActivityForgetPwdBinding;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ForgetPwdActivity.kt */
final class ForgetPwdActivity$onCreate$1$4 extends Lambda implements Function1<Pair<? extends Boolean, ? extends Integer>, Unit> {
    final /* synthetic */ ActivityForgetPwdBinding $this_run;
    final /* synthetic */ ForgetPwdActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForgetPwdActivity$onCreate$1$4(ActivityForgetPwdBinding activityForgetPwdBinding, ForgetPwdActivity forgetPwdActivity) {
        super(1);
        this.$this_run = activityForgetPwdBinding;
        this.this$0 = forgetPwdActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Boolean, Integer>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<Boolean, Integer> pair) {
        if (pair.getFirst().booleanValue()) {
            this.$this_run.btnGetCode.setTextColor(ThemeManager.getTypeValue(this.this$0, R.attr.textColorHint));
            this.$this_run.btnGetCode.setClickable(false);
            this.$this_run.btnGetCode.setText(this.this$0.getString(R.string.user_sign_getCode_retry, new Object[]{pair.getSecond().intValue() + "s "}));
            return;
        }
        this.$this_run.btnGetCode.setTextColor(ThemeManager.getTypeValue(this.this$0, R.attr.appColorAccent));
        this.$this_run.btnGetCode.setClickable(true);
        this.$this_run.btnGetCode.setText(this.this$0.getString(R.string.user_sign_getCode_retry, new Object[]{""}));
    }
}

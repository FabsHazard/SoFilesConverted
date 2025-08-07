package com.microtech.aidexx.ui.account;

import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.ActivityRegisterBinding;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: RegisterActivity.kt */
final class RegisterActivity$initEvent$1 extends Lambda implements Function1<Pair<? extends Boolean, ? extends Integer>, Unit> {
    final /* synthetic */ RegisterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterActivity$initEvent$1(RegisterActivity registerActivity) {
        super(1);
        this.this$0 = registerActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Boolean, Integer>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<Boolean, Integer> pair) {
        TextView textView = ((ActivityRegisterBinding) this.this$0.getBinding()).btnGetCode;
        RegisterActivity registerActivity = this.this$0;
        boolean booleanValue = pair.getFirst().booleanValue();
        textView.setTextColor(registerActivity.getColor(R.color.light_colorAccent));
        ((ActivityRegisterBinding) this.this$0.getBinding()).btnGetCode.setClickable(!pair.getFirst().booleanValue());
        ((ActivityRegisterBinding) this.this$0.getBinding()).btnGetCode.setText(this.this$0.getString(R.string.user_sign_getCode_retry, new Object[]{pair.getFirst().booleanValue() ? pair.getSecond().intValue() + "s " : ""}));
    }
}

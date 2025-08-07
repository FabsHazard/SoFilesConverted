package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.ui.pair.TransmitterActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccountSecurityActivity.kt */
final class AccountSecurityActivity$onCreate$1$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AccountSecurityActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountSecurityActivity$onCreate$1$4$1(AccountSecurityActivity accountSecurityActivity) {
        super(0);
        this.this$0 = accountSecurityActivity;
    }

    public final void invoke() {
        ActivityUtil.INSTANCE.toActivity(this.this$0, TransmitterActivity.class);
    }
}

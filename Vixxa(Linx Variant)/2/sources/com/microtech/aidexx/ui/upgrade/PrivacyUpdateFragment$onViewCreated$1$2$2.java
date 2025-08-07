package com.microtech.aidexx.ui.upgrade;

import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: PrivacyUpdateFragment.kt */
final class PrivacyUpdateFragment$onViewCreated$1$2$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PrivacyUpdateFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrivacyUpdateFragment$onViewCreated$1$2$2(PrivacyUpdateFragment privacyUpdateFragment) {
        super(0);
        this.this$0 = privacyUpdateFragment;
    }

    public final void invoke() {
        StandardDialog showWhether = this.this$0.getShowWhether();
        if (showWhether != null) {
            showWhether.dismiss();
        }
    }
}

package com.microtech.aidexx.ui.main.home.customerservice;

import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomerServiceView.kt */
final class CustomerServiceView$layoutRunnable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CustomerServiceView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerServiceView$layoutRunnable$1(CustomerServiceView customerServiceView) {
        super(0);
        this.this$0 = customerServiceView;
    }

    public final void invoke() {
        RelativeLayout access$getChild$p = this.this$0.child;
        if (access$getChild$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            access$getChild$p = null;
        }
        access$getChild$p.requestLayout();
    }
}

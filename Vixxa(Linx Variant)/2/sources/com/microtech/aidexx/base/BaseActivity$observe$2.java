package com.microtech.aidexx.base;

import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.SignalLostCheckDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseActivity.kt */
final class BaseActivity$observe$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BaseActivity<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseActivity$observe$2(BaseActivity<VM, VB> baseActivity) {
        super(1);
        this.this$0 = baseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        SignalLostCheckDialog instance = SignalLostCheckDialog.Companion.instance(this.this$0);
        if (!instance.isShowing()) {
            instance.show();
            LogUtil.Companion.eAiDEX("Signal lost one hour, show dialog");
        }
    }
}

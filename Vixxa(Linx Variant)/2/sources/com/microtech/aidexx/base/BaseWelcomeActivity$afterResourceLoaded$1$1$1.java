package com.microtech.aidexx.base;

import com.microtech.aidexx.databinding.ActivityWelcomeBinding;
import com.microtech.aidexx.ui.welcome.UserAgreeView;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseWelcomeActivity.kt */
final class BaseWelcomeActivity$afterResourceLoaded$1$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BaseWelcomeActivity<VM> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseWelcomeActivity$afterResourceLoaded$1$1$1(BaseWelcomeActivity<VM> baseWelcomeActivity) {
        super(1);
        this.this$0 = baseWelcomeActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LogUtil.Companion.eAiDEX("Welcome Protocol agree:" + z);
        if (z) {
            UserAgreeView userAgreeView = ((ActivityWelcomeBinding) this.this$0.getBinding()).welcomeTipViewStub.viewAgreeProtocal;
            Intrinsics.checkNotNullExpressionValue(userAgreeView, "viewAgreeProtocal");
            userAgreeView.setVisibility(8);
            MmkvManager.INSTANCE.saveAppLaunched();
            MmkvManager.INSTANCE.saveAgreeProtocol(true);
            BaseWelcomeActivity<VM> baseWelcomeActivity = this.this$0;
            baseWelcomeActivity.afterAgreeUserProtocol(((ActivityWelcomeBinding) baseWelcomeActivity.getBinding()).welcomeTipViewStub);
            return;
        }
        this.this$0.finish();
    }
}

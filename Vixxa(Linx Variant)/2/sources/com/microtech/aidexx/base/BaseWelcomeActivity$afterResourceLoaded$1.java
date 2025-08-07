package com.microtech.aidexx.base;

import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo;
import com.microtech.aidexx.data.resource.PrivacyUpdateManager;
import com.microtech.aidexx.databinding.ActivityWelcomeBinding;
import com.microtech.aidexx.databinding.ActivityWelcomeTipBinding;
import com.microtech.aidexx.ui.welcome.UserAgreeView;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.base.BaseWelcomeActivity$afterResourceLoaded$1", f = "BaseWelcomeActivity.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseWelcomeActivity.kt */
final class BaseWelcomeActivity$afterResourceLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseWelcomeActivity<VM> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseWelcomeActivity$afterResourceLoaded$1(BaseWelcomeActivity<VM> baseWelcomeActivity, Continuation<? super BaseWelcomeActivity$afterResourceLoaded$1> continuation) {
        super(2, continuation);
        this.this$0 = baseWelcomeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseWelcomeActivity$afterResourceLoaded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseWelcomeActivity$afterResourceLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CharSequence charSequence;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ActivityWelcomeTipBinding activityWelcomeTipBinding = ((ActivityWelcomeBinding) this.this$0.getBinding()).welcomeTipViewStub;
            BaseWelcomeActivity<VM> baseWelcomeActivity = this.this$0;
            TextView textView = activityWelcomeTipBinding.title;
            if (!ExtendsKt.isGp()) {
                charSequence = baseWelcomeActivity.getString(R.string.app_slogan);
            }
            textView.setText(charSequence);
            activityWelcomeTipBinding.textView.setText(baseWelcomeActivity.getString(R.string.welcome_title_ph, new Object[]{baseWelcomeActivity.getString(R.string.app_name)}));
            activityWelcomeTipBinding.textView2.setText(baseWelcomeActivity.getString(R.string.welcome_desc));
            activityWelcomeTipBinding.viewAgreeProtocal.resetText();
            UserAgreeView userAgreeView = activityWelcomeTipBinding.viewAgreeProtocal;
            Intrinsics.checkNotNullExpressionValue(userAgreeView, "viewAgreeProtocal");
            userAgreeView.setVisibility(0);
            activityWelcomeTipBinding.viewAgreeProtocal.setOnClick(new BaseWelcomeActivity$afterResourceLoaded$1$1$1(baseWelcomeActivity));
            LogUtil.Companion.xLogI("AppFirstLaunch", "BaseWelcomeActivity");
            Dialogs.INSTANCE.showWait(this.this$0.getString(R.string.com_loading));
            this.label = 1;
            obj = PrivacyUpdateManager.INSTANCE.checkPolicyUpdate(true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BaseWelcomeActivity<VM> baseWelcomeActivity2 = this.this$0;
        PolicyUpgradeInfo policyUpgradeInfo = (PolicyUpgradeInfo) obj;
        Dialogs.INSTANCE.dismissWait();
        ((ActivityWelcomeBinding) baseWelcomeActivity2.getBinding()).welcomeTipViewStub.viewAgreeProtocal.resetText();
        return Unit.INSTANCE;
    }
}

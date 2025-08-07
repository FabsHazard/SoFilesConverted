package com.microtech.aidexx.ui.welcome;

import android.content.Intent;
import android.view.View;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.base.BaseWelcomeActivity;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityWelcomeTipBinding;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.account.LoginActivity;
import com.microtech.aidexx.ui.account.RegisterActivity;
import com.microtech.aidexx.ui.main.MainActivity;
import com.microtech.aidexx.ui.welcome.guide.GuidanceActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.button.StateButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/WelcomeActivity;", "Lcom/microtech/aidexx/base/BaseWelcomeActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "()V", "afterAgreeUserProtocol", "", "welcomeTipBinding", "Lcom/microtech/aidexx/databinding/ActivityWelcomeTipBinding;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WelcomeActivity.kt */
public final class WelcomeActivity extends BaseWelcomeActivity<BaseViewModel> {
    public void afterAgreeUserProtocol(ActivityWelcomeTipBinding activityWelcomeTipBinding) {
        if (UserInfoManager.Companion.instance().isLogin()) {
            UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
            if (userEntity == null || userEntity.isGuide() != 1) {
                ActivityUtil.INSTANCE.toActivity(this, GuidanceActivity.class);
            } else {
                ActivityUtil.INSTANCE.toActivity(this, MainActivity.class);
            }
            finish();
        } else if (activityWelcomeTipBinding != null) {
            LogUtil.Companion.xLogI("gp afterAgreeUserProtocol", "BaseWelcomeActivity");
            activityWelcomeTipBinding.title.setText("");
            activityWelcomeTipBinding.buttonLogin.setText(getString(R.string.welcome_login));
            activityWelcomeTipBinding.buttonLogin.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda0(this));
            activityWelcomeTipBinding.textView.setText(getString(R.string.welcome_title_ph, new Object[]{getString(R.string.app_name)}));
            activityWelcomeTipBinding.buttonRegist.setText(getString(R.string.welcome_register));
            activityWelcomeTipBinding.buttonRegist.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda1(this));
            StateButton stateButton = activityWelcomeTipBinding.buttonLogin;
            Intrinsics.checkNotNullExpressionValue(stateButton, "buttonLogin");
            stateButton.setVisibility(0);
            StateButton stateButton2 = activityWelcomeTipBinding.buttonRegist;
            Intrinsics.checkNotNullExpressionValue(stateButton2, "buttonRegist");
            stateButton2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void afterAgreeUserProtocol$lambda$2$lambda$0(WelcomeActivity welcomeActivity, View view) {
        Intrinsics.checkNotNullParameter(welcomeActivity, "this$0");
        welcomeActivity.startActivity(new Intent(welcomeActivity, LoginActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void afterAgreeUserProtocol$lambda$2$lambda$1(WelcomeActivity welcomeActivity, View view) {
        Intrinsics.checkNotNullParameter(welcomeActivity, "this$0");
        welcomeActivity.startActivity(new Intent(welcomeActivity, RegisterActivity.class));
    }
}

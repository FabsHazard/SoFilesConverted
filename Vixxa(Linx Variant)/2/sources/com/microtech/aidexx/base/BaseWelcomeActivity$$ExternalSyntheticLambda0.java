package com.microtech.aidexx.base;

import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.SplashScreenViewProvider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseWelcomeActivity$$ExternalSyntheticLambda0 implements SplashScreen.OnExitAnimationListener {
    public final /* synthetic */ BaseWelcomeActivity f$0;

    public /* synthetic */ BaseWelcomeActivity$$ExternalSyntheticLambda0(BaseWelcomeActivity baseWelcomeActivity) {
        this.f$0 = baseWelcomeActivity;
    }

    public final void onSplashScreenExit(SplashScreenViewProvider splashScreenViewProvider) {
        BaseWelcomeActivity.initSplashProgressIfSupported$lambda$0(this.f$0, splashScreenViewProvider);
    }
}

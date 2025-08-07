package com.microtech.aidexx.base;

import androidx.core.splashscreen.SplashScreen;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseWelcomeActivity$$ExternalSyntheticLambda1 implements SplashScreen.KeepOnScreenCondition {
    public final /* synthetic */ BaseWelcomeActivity f$0;

    public /* synthetic */ BaseWelcomeActivity$$ExternalSyntheticLambda1(BaseWelcomeActivity baseWelcomeActivity) {
        this.f$0 = baseWelcomeActivity;
    }

    public final boolean shouldKeepOnScreen() {
        return BaseWelcomeActivity.initSplashProgressIfSupported$lambda$1(this.f$0);
    }
}

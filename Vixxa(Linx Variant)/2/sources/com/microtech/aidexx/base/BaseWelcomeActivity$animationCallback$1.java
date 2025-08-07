package com.microtech.aidexx.base;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/base/BaseWelcomeActivity$animationCallback$1", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseWelcomeActivity.kt */
public final class BaseWelcomeActivity$animationCallback$1 extends Animatable2.AnimationCallback {
    final /* synthetic */ BaseWelcomeActivity<VM> this$0;

    BaseWelcomeActivity$animationCallback$1(BaseWelcomeActivity<VM> baseWelcomeActivity) {
        this.this$0 = baseWelcomeActivity;
    }

    public void onAnimationEnd(Drawable drawable) {
        super.onAnimationEnd(drawable);
        LogUtil.Companion.xLogI("onAnimationEnd isSupportSplashProgress=" + this.this$0.isSupportSplashProgress + " resourceLoaded=" + this.this$0.resourceLoaded, "BaseWelcomeActivity");
        this.this$0.isAnimationFinish = true;
        this.this$0.nextStepIfNeed();
    }
}

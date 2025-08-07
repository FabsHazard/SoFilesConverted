package com.microtech.aidexx.views.dialog.bottom;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/microtech/aidexx/views/dialog/bottom/BaseBottomPopupView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseBottomPopupView.kt */
public final class BaseBottomPopupView$dismiss$1 implements Animation.AnimationListener {
    final /* synthetic */ BaseBottomPopupView this$0;

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    BaseBottomPopupView$dismiss$1(BaseBottomPopupView baseBottomPopupView) {
        this.this$0 = baseBottomPopupView;
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.dismissImmediately();
    }
}

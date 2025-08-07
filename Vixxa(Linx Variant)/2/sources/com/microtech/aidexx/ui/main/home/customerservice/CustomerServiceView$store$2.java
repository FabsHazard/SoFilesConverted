package com.microtech.aidexx.ui.main.home.customerservice;

import android.animation.Animator;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/microtech/aidexx/ui/main/home/customerservice/CustomerServiceView$store$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomerServiceView.kt */
public final class CustomerServiceView$store$2 implements Animator.AnimatorListener {
    final /* synthetic */ CustomerServiceView this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    CustomerServiceView$store$2(CustomerServiceView customerServiceView) {
        this.this$0 = customerServiceView;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.this$0.isInMotion = false;
        CustomerServiceView customerServiceView = this.this$0;
        RelativeLayout access$getChild$p = customerServiceView.child;
        RelativeLayout relativeLayout = null;
        if (access$getChild$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            access$getChild$p = null;
        }
        int left = access$getChild$p.getLeft();
        RelativeLayout access$getChild$p2 = this.this$0.child;
        if (access$getChild$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            access$getChild$p2 = null;
        }
        int top = access$getChild$p2.getTop();
        RelativeLayout access$getChild$p3 = this.this$0.child;
        if (access$getChild$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            access$getChild$p3 = null;
        }
        int right = access$getChild$p3.getRight();
        RelativeLayout access$getChild$p4 = this.this$0.child;
        if (access$getChild$p4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
        } else {
            relativeLayout = access$getChild$p4;
        }
        customerServiceView.savePosition(left, top, right, relativeLayout.getBottom());
    }
}

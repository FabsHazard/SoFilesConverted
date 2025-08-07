package com.microtech.aidexx.ui.main.home.timetab;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/microtech/aidexx/ui/main/home/timetab/TimeTabLayout$select$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeTabLayout.kt */
public final class TimeTabLayout$select$2 implements Animator.AnimatorListener {
    final /* synthetic */ Ref.ObjectRef<TextView> $tvTarget;
    final /* synthetic */ TimeTabLayout this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
    }

    TimeTabLayout$select$2(Ref.ObjectRef<TextView> objectRef, TimeTabLayout timeTabLayout) {
        this.$tvTarget = objectRef;
        this.this$0 = timeTabLayout;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        TextView textView = (TextView) this.$tvTarget.element;
        if (textView != null) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        Context context = null;
        if (ThemeManager.INSTANCE.isLight()) {
            TextView textView = (TextView) this.$tvTarget.element;
            if (textView != null) {
                Context access$getMContext$p = this.this$0.mContext;
                if (access$getMContext$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = access$getMContext$p;
                }
                textView.setTextColor(ContextCompat.getColor(context, R.color.green_65));
                return;
            }
            return;
        }
        TextView textView2 = (TextView) this.$tvTarget.element;
        if (textView2 != null) {
            Context access$getMContext$p2 = this.this$0.mContext;
            if (access$getMContext$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = access$getMContext$p2;
            }
            textView2.setTextColor(ContextCompat.getColor(context, R.color.gray_e6));
        }
    }
}

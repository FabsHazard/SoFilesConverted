package com.microtech.aidexx.utils.adapter.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/anim/ScaleInAnimation;", "Lcom/microtech/aidexx/utils/adapter/anim/BaseAnimation;", "mFrom", "", "(F)V", "animators", "", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "(Landroid/view/View;)[Landroid/animation/Animator;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ScaleInAnimation.kt */
public final class ScaleInAnimation implements BaseAnimation {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DEFAULT_SCALE_FROM = 0.5f;
    private final float mFrom;

    public ScaleInAnimation() {
        this(0.0f, 1, (DefaultConstructorMarker) null);
    }

    public ScaleInAnimation(float f) {
        this.mFrom = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScaleInAnimation(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.5f : f);
    }

    public Animator[] animators(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{this.mFrom, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{this.mFrom, 1.0f});
        ofFloat2.setDuration(300);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNull(ofFloat);
        Intrinsics.checkNotNull(ofFloat2);
        return new Animator[]{ofFloat, ofFloat2};
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/anim/ScaleInAnimation$Companion;", "", "()V", "DEFAULT_SCALE_FROM", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ScaleInAnimation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

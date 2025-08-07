package com.microtech.aidexx.ui.main.home.timetab;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/timetab/AnimatorManager;", "", "()V", "createAlphaAnimator", "Landroid/animation/ObjectAnimator;", "target", "Landroid/view/View;", "from", "", "to", "createArgbAnimator", "Landroid/animation/ValueAnimator;", "", "duration", "", "createTransAnimator", "Landroidx/constraintlayout/widget/ConstraintLayout;", "value", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AnimatorManager.kt */
public final class AnimatorManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AnimatorManager INSTANCE = new AnimatorManager();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/timetab/AnimatorManager$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/ui/main/home/timetab/AnimatorManager;", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AnimatorManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimatorManager instance() {
            return AnimatorManager.INSTANCE;
        }
    }

    private AnimatorManager() {
    }

    public final ObjectAnimator createTransAnimator(ConstraintLayout constraintLayout, float f, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(constraintLayout, "translationY", new float[]{f});
        if (ofFloat != null) {
            ofFloat.setDuration(j);
        }
        ofFloat.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public final ObjectAnimator createAlphaAnimator(View view, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{f, f2});
        if (ofFloat != null) {
            ofFloat.setDuration(50);
        }
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public final ValueAnimator createArgbAnimator(int i, int i2, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setDuration(j);
        ofInt.setEvaluator(new ArgbEvaluator());
        Intrinsics.checkNotNull(ofInt);
        return ofInt;
    }
}

package com.microtech.aidexx.ui.main.home.timetab;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TimeTabLayout$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Ref.ObjectRef f$0;

    public /* synthetic */ TimeTabLayout$$ExternalSyntheticLambda1(Ref.ObjectRef objectRef) {
        this.f$0 = objectRef;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TimeTabLayout.unselect$lambda$1(this.f$0, valueAnimator);
    }
}

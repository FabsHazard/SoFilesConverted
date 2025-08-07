package com.kongzue.dialogx.dialogs;

import android.animation.ValueAnimator;
import com.kongzue.dialogx.dialogs.FullScreenDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FullScreenDialog$DialogImpl$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FullScreenDialog.DialogImpl f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ FullScreenDialog$DialogImpl$$ExternalSyntheticLambda0(FullScreenDialog.DialogImpl dialogImpl, int i) {
        this.f$0 = dialogImpl;
        this.f$1 = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m136lambda$doShowAnimRepeat$0$comkongzuedialogxdialogsFullScreenDialog$DialogImpl(this.f$1, valueAnimator);
    }
}

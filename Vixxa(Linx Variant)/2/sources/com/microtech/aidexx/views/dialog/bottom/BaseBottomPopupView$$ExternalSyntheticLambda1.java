package com.microtech.aidexx.views.dialog.bottom;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseBottomPopupView$$ExternalSyntheticLambda1 implements View.OnTouchListener {
    public final /* synthetic */ BaseBottomPopupView f$0;

    public /* synthetic */ BaseBottomPopupView$$ExternalSyntheticLambda1(BaseBottomPopupView baseBottomPopupView) {
        this.f$0 = baseBottomPopupView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return BaseBottomPopupView.onCancelableTouchListener$lambda$2(this.f$0, view, motionEvent);
    }
}

package com.microtech.aidexx.utils.blankj;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class KeyboardUtils$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ Window f$0;
    public final /* synthetic */ int[] f$1;
    public final /* synthetic */ View f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ KeyboardUtils$$ExternalSyntheticLambda0(Window window, int[] iArr, View view, int i) {
        this.f$0 = window;
        this.f$1 = iArr;
        this.f$2 = view;
        this.f$3 = i;
    }

    public final void onGlobalLayout() {
        KeyboardUtils.fixAndroidBug5497$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

package com.microtech.aidexx.utils.blankj;

import android.view.ViewTreeObserver;
import android.view.Window;
import com.microtech.aidexx.utils.blankj.KeyboardUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class KeyboardUtils$$ExternalSyntheticLambda1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ Window f$0;
    public final /* synthetic */ int[] f$1;
    public final /* synthetic */ KeyboardUtils.OnSoftInputChangedListener f$2;

    public /* synthetic */ KeyboardUtils$$ExternalSyntheticLambda1(Window window, int[] iArr, KeyboardUtils.OnSoftInputChangedListener onSoftInputChangedListener) {
        this.f$0 = window;
        this.f$1 = iArr;
        this.f$2 = onSoftInputChangedListener;
    }

    public final void onGlobalLayout() {
        KeyboardUtils.registerSoftInputChangedListener$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

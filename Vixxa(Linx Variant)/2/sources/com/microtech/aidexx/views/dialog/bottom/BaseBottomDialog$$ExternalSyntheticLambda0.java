package com.microtech.aidexx.views.dialog.bottom;

import android.view.View;
import com.microtech.aidexx.utils.blankj.KeyboardUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseBottomDialog$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;

    public /* synthetic */ BaseBottomDialog$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    public final void run() {
        KeyboardUtils.INSTANCE.showSoftInput(this.f$0);
    }
}

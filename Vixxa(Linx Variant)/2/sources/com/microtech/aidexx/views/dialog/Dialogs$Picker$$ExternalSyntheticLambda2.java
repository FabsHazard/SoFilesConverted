package com.microtech.aidexx.views.dialog;

import android.view.View;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.selector.base.OnOptionsSelectListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dialogs$Picker$$ExternalSyntheticLambda2 implements OnOptionsSelectListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ Dialogs$Picker$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onOptionsSelect(int i, int i2, int i3, View view) {
        Dialogs.Picker.singlePick$lambda$0(this.f$0, i, i2, i3, view);
    }
}

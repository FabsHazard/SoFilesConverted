package com.microtech.aidexx.views.dialog;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda0(Function0 function0) {
        this.f$0 = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.showMessage$lambda$4(this.f$0, dialogInterface, i);
    }
}

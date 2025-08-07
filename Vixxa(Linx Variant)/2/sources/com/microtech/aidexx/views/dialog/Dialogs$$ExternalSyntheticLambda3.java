package com.microtech.aidexx.views.dialog;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda3(Function0 function0, int i) {
        this.f$0 = function0;
        this.f$1 = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.showAlert$lambda$3(this.f$0, this.f$1, dialogInterface, i);
    }
}

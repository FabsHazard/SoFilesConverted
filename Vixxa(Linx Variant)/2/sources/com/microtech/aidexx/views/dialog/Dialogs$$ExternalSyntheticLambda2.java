package com.microtech.aidexx.views.dialog;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda2(Function0 function0, String str) {
        this.f$0 = function0;
        this.f$1 = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.showWhether$lambda$7(this.f$0, this.f$1, dialogInterface, i);
    }
}

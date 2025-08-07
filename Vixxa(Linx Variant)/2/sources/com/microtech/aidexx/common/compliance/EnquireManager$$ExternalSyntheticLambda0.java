package com.microtech.aidexx.common.compliance;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnquireManager$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ EnquireManager$$ExternalSyntheticLambda0(String str, Function0 function0) {
        this.f$0 = str;
        this.f$1 = function0;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EnquireManager.showEnquireOrNot$lambda$1(this.f$0, this.f$1, dialogInterface, i);
    }
}

package com.microtech.aidexx.utils.permission;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PermissionsUtil$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;

    public /* synthetic */ PermissionsUtil$$ExternalSyntheticLambda0(Activity activity) {
        this.f$0 = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        PermissionsUtil.showSystemPermissionsSettingDialog$lambda$1(this.f$0, dialogInterface, i);
    }
}

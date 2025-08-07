package com.microtech.aidexx.ui.setting.permission;

import android.view.View;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PermissionCheckUtil$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ SettingItemWidget f$1;

    public /* synthetic */ PermissionCheckUtil$$ExternalSyntheticLambda1(Function1 function1, SettingItemWidget settingItemWidget) {
        this.f$0 = function1;
        this.f$1 = settingItemWidget;
    }

    public final void onClick(View view) {
        PermissionCheckUtil.updateCheckItem$lambda$1(this.f$0, this.f$1, view);
    }
}

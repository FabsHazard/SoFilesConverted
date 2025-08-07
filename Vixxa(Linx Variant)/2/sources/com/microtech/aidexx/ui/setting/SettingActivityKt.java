package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getWelfareCenterUrl", "", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivityKt {
    public static final String getWelfareCenterUrl() {
        String token = MmkvManager.INSTANCE.getToken();
        return "http://35.179.178.176:4433/?token=" + token + "&userId=" + UserInfoManager.Companion.instance().userId();
    }
}

package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;

public class e implements DynamicModule.VersionPolicy {
    public static final String a = "e";

    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt(b.k) > 0) {
            Logger.i(a, "Prefer remote: The version of remote module " + str + ":" + remoteModuleInfo.getInt(b.k));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt(b.l) > 0) {
            Logger.i(a, "Choose local: The version of local module " + str + ":" + localModuleInfo.getInt(b.l));
            return localModuleInfo;
        }
        Logger.i(a, "Cannot get module info in remote or local.");
        return new Bundle();
    }
}

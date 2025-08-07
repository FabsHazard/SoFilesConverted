package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;

public class d implements DynamicModule.VersionPolicy {
    public static final String a = "d";

    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = a;
        Logger.i(str2, "The version of remote module " + str + ":" + remoteModuleInfo.getInt(b.k));
        Logger.i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(b.l));
        if (remoteModuleInfo.getInt(b.k) >= localModuleInfo.getInt(b.l)) {
            Logger.i(str2, "Choose remote module info.");
            return remoteModuleInfo;
        }
        Logger.i(str2, "Choose local module info.");
        return localModuleInfo;
    }
}

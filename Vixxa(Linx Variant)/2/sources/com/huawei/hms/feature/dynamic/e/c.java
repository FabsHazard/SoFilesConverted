package com.huawei.hms.feature.dynamic.e;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;

public class c implements DynamicModule.VersionPolicy {
    public static final String a = "c";

    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        DynamicModule.LoadingException loadingException;
        Bundle bundle;
        try {
            bundle = DynamicModule.getRemoteModuleInfo(context, str);
            loadingException = null;
        } catch (DynamicModule.LoadingException e) {
            loadingException = e.getBundle() != null ? new DynamicModule.LoadingException(e.getMessage(), e.getBundle()) : new DynamicModule.LoadingException(e.getMessage());
            Logger.w(a, "Get remote module info failed: " + e.getMessage() + ". try to query local.");
            bundle = new Bundle();
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = a;
        Logger.i(str2, "The version of remote module " + str + ":" + bundle.getInt(b.k));
        Logger.i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(b.l));
        if (localModuleInfo.getInt(b.l) > 0 && localModuleInfo.getInt(b.l) >= bundle.getInt(b.k)) {
            Logger.i(str2, "Choose local module info.");
            return localModuleInfo;
        } else if (loadingException == null || bundle.getInt(b.k) != 0) {
            Logger.i(str2, "Choose remote module info.");
            return bundle;
        } else {
            throw loadingException;
        }
    }
}

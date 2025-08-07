package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

public class a {
    public static String a() {
        return "6.0.7.300";
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.w("AgentUtil", "", (Throwable) e);
            return "";
        }
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return String.format(Locale.ROOT, str + "/%s", new Object[]{a()});
        }
        String packageName = (ContextHolder.getAppContext() == null ? context : ContextHolder.getAppContext()).getPackageName();
        String a = a(context);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.MODEL;
        Locale locale = Locale.ROOT;
        String str5 = "%s/%s (Linux; Android %s; %s) " + str + "/%s %s";
        String a2 = a();
        if (TextUtils.isEmpty(str2)) {
            str2 = "no_service_name";
        }
        return String.format(locale, str5, new Object[]{packageName, a, str3, str4, a2, str2});
    }

    public static String b(Context context, String str, String str2) {
        return a(context, str, str2);
    }
}

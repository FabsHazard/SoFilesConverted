package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

public class c {
    public static final String a = "HMSPkgManager";
    public static final List<String> b = new a();
    public static final int c = 8;
    public static final int d = 4;
    public static final int e = 5;

    public static class a extends ArrayList<String> {
        public a() {
            add("com.huawei.hwid");
            add("com.huawei.hwid.tv");
        }
    }

    public static class b implements PrivilegedAction {
        public final /* synthetic */ Field a;

        public b(Field field) {
            this.a = field;
        }

        public Object run() {
            this.a.setAccessible(true);
            return null;
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            Logger.e(a, "The given context is null.");
            return false;
        }
        for (String next : b) {
            try {
                if (context.getPackageManager().getPackageInfo(next, 0) != null) {
                    Logger.i(a, "The HMS Core is installed, pkgName:" + next);
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.w(a, "Query for HMS Core package name:" + next + " failed.");
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(a, "context is null or filePath is null.");
            return false;
        }
        try {
            if (!new File(str).exists()) {
                Logger.w(a, "the file does not exist.");
                return false;
            }
            String canonicalPath = new File(str).getCanonicalPath();
            if (canonicalPath.startsWith("/system/app/HFF")) {
                Logger.i(a, "HFF file path, need not to verify.");
                return true;
            }
            if (canonicalPath.startsWith("/data/data/")) {
                String[] split = canonicalPath.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                if (split.length >= 4) {
                    return b(context, split[3]);
                }
            } else {
                if (!canonicalPath.startsWith("/data/user_de/")) {
                    if (!canonicalPath.startsWith("/data/user/")) {
                        Logger.w(a, "illegal path.");
                    }
                }
                String[] split2 = canonicalPath.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
                if (split2.length >= 5) {
                    return b(context, split2[4]);
                }
            }
            return false;
        } catch (IOException unused) {
            Logger.e(a, "checkPathValidity IOException");
        }
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(a, "context is null or pkgName is null.");
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.e(a, "get PrivAppFlag err for " + str + ":" + e2.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            Logger.i(a, "Get pkg application null:" + str);
            return false;
        }
        try {
            Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new b(field));
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                Logger.i(a, "Get privFlag instance error.");
                return false;
            }
            int intValue = ((Integer) obj).intValue();
            Logger.d(a, "privFlag of " + str + " is:" + intValue);
            boolean z = (intValue & 8) != 0;
            Logger.i(a, "pkgName:" + str + ", isPrivApp:" + z);
            return z;
        } catch (IllegalAccessException | NoSuchFieldException e3) {
            Logger.e(a, "get Priv App Flag err for " + str + ":" + e3.getMessage());
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(a, "context is null or pkgName is null.");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            boolean z = (packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? false : true;
            Logger.i(a, "isHMSSystemApp:" + z);
            if (z) {
                Logger.i(a, "The HMS package:" + str + " is SystemApp");
                return true;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.e(a, "getSystemApp flag error for " + str + ":" + e2.getMessage());
        }
        return false;
    }
}

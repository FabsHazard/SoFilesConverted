package com.igexin.push.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.igexin.a.a.c.b;
import com.igexin.push.config.l;
import java.util.Arrays;

public class n {
    private static PackageInfo a;

    public static int a(Context context) {
        try {
            return b(context).applicationInfo.targetSdkVersion;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a() {
        return Build.BRAND;
    }

    public static PackageInfo b(Context context) throws PackageManager.NameNotFoundException {
        if (a != null) {
            b.a("PhoneInfoUtils｜getSelfPackageInfo cache", new Object[0]);
            return a;
        }
        synchronized (n.class) {
            if (a == null) {
                a = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
                b.a("PhoneInfoUtils｜ getSelfPackageInfo", new Object[0]);
            }
        }
        return a;
    }

    public static boolean b() {
        if ("*".equals(l.B)) {
            return true;
        }
        try {
            return Arrays.asList(l.B.toUpperCase().split(",")).contains(Build.BRAND.toUpperCase());
        } catch (Exception e) {
            b.a("PhoneInfoUtils|delAlarm " + l.B + " err " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static ServiceInfo[] c(Context context) {
        try {
            return b(context).services;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}

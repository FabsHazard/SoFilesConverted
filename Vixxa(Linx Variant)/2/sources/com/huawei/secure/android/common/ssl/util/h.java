package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class h {
    private static final String a = "h";

    public static String a(String str) {
        Context a2 = c.a();
        if (a2 == null) {
            return "";
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            g.b(a, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            g.b(a, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable unused) {
            g.b(a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context a2 = c.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            g.b(a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e) {
            g.b(a, "getVersion: " + e.getMessage());
            return 0;
        }
    }
}

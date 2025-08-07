package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* compiled from: LogsUtil */
public class o4 {
    private static final Pattern a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private static Throwable a(Throwable th) {
        return th;
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(str, a(str2, false));
        }
    }

    public static void c(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(str, a(str2, false));
        }
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.w(str, a(str2, false));
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.d(str, a(str2, false));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2) || th != null) {
            Log.w(str, a(str2, false), a(th));
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (a.matcher(String.valueOf(charAt)).matches()) {
                if (i % 2 == 0) {
                    charAt = '*';
                }
                i++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}

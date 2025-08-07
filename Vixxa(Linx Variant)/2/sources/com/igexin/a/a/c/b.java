package com.igexin.a.a.c;

import android.util.Log;
import com.huawei.hms.common.util.Logger;
import com.igexin.push.config.o;
import com.igexin.push.core.d;
import com.igexin.push.f.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b {
    public static boolean a = o.a.equals("debug");

    public static void a(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a || (d.M && d.N >= System.currentTimeMillis())) {
            if (objArr != null && objArr.length > 0) {
                str = String.format(str, objArr);
            }
            a.i().a(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(new Date()) + Logger.c + str);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.w(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }
}

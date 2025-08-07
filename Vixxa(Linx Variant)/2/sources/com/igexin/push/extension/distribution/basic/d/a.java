package com.igexin.push.extension.distribution.basic.d;

import android.content.SharedPreferences;
import com.igexin.push.extension.distribution.basic.c.e;

public class a {
    public static a a;
    private SharedPreferences b = e.a.getSharedPreferences("gx_sp", 0);

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static String b() {
        return e.a.getSharedPreferences("getui_sp", 0).getString("us", "");
    }

    public static String c() {
        return e.a.getSharedPreferences("getui_sp", 0).getString("uis", "");
    }
}

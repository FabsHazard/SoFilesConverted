package com.igexin.push.core.b;

import android.content.Context;
import android.content.SharedPreferences;

public class a {
    public static String a(Context context) {
        return d(context).getString("appId", "");
    }

    public static String b(Context context) {
        return d(context).getString("appKey", "");
    }

    public static String c(Context context) {
        return d(context).getString("appSecret", "");
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences("ups_gt_appinfo", 0);
    }
}

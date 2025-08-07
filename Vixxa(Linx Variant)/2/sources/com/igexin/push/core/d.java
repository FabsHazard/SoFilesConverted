package com.igexin.push.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.igexin.a.a.c.b;
import com.igexin.a.b.a;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.o;
import com.igexin.push.core.bean.PushTaskBean;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {
    public static String A = null;
    public static String B = null;
    public static String C = null;
    public static long D = -1;
    public static long E = 0;
    public static long F = -1;
    public static long G = 0;
    public static long H = 0;
    public static long I = 0;
    public static long J = 0;
    public static long K = 0;
    public static String L = null;
    public static boolean M = o.a.equals("debug");
    public static long N = 0;
    public static long O = 0;
    public static String P = null;
    public static long Q = 0;
    public static int R = 0;
    public static String S = null;
    public static String T = null;
    public static String U = null;
    public static String V = null;
    public static long W = 0;
    public static String X = null;
    public static byte[] Y = null;
    public static boolean Z = false;
    public static String a = "";
    private static Map<String, Integer> aA = null;
    private static String aB = "";
    public static boolean aa = false;
    public static boolean ab = false;
    public static Map<String, PushTaskBean> ac = null;
    public static Map<String, Integer> ad = null;
    public static HashMap<String, Long> ae = null;
    public static int af = 0;
    public static int ag = 0;
    public static int ah = 0;
    public static String ai = null;
    public static long aj = 0;
    public static String ak = null;
    public static String al = null;
    public static String am = null;
    public static String an = null;
    public static String ao = null;
    public static String ap = null;
    public static long aq = 0;
    public static boolean ar = false;
    public static int as = 0;
    public static int at = 0;
    public static byte[] au = null;
    public static String av = null;
    public static String aw = "";
    public static String ax = "";
    public static String ay = "";
    public static String az = null;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static Context e;
    public static AtomicBoolean f = new AtomicBoolean(false);
    public static boolean g = true;
    public static volatile boolean h = false;
    public static volatile boolean i;
    public static volatile boolean j = true;
    public static boolean k = true;
    public static volatile boolean l;
    public static volatile boolean m;
    public static boolean n = true;
    public static int o = 0;
    public static int p = 0;
    public static int q = 0;
    public static long r = 0;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w = Build.MODEL;
    public static String x;
    public static String y;
    public static String z;

    public static int a(String str, boolean z2) {
        int intValue;
        synchronized (d.class) {
            if (aA.get(str) == null) {
                aA.put(str, 0);
            }
            intValue = aA.get(str).intValue();
            if (z2) {
                intValue--;
                aA.put(str, Integer.valueOf(intValue));
                if (intValue == 0) {
                    aA.remove(str);
                }
            }
        }
        return intValue;
    }

    public static String a() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    public static void a(long j2) {
        r = j2;
        s = a.a(String.valueOf(j2));
    }

    public static boolean a(Context context) {
        e = context;
        c = context.getPackageName();
        d = com.igexin.push.util.d.c(context);
        az = "getui.permission.GetuiService." + c;
        if (!d()) {
            b.a("CoreRuntimeInfo|parseManifests failed", new Object[0]);
            return false;
        }
        Y = a.a(a + context.getPackageName()).getBytes();
        c();
        g = com.igexin.push.util.a.h();
        ac = new ConcurrentHashMap();
        ad = new ConcurrentHashMap();
        ae = new HashMap<>();
        i = new com.igexin.sdk.a.d(context).c();
        aA = new HashMap();
        e();
        ar = true;
        b.a("CoreRuntimeInfo|getui sdk init success, isPushOn = " + i, new Object[0]);
        return true;
    }

    public static boolean a(String str, Integer num, boolean z2) {
        synchronized (d.class) {
            int intValue = num.intValue();
            if (!z2 || aA.get(str) == null || (intValue = aA.get(str).intValue() + num.intValue()) != 0) {
                aA.put(str, Integer.valueOf(intValue));
                return true;
            }
            aA.remove(str);
            return false;
        }
    }

    public static Boolean b() {
        return Boolean.valueOf(aB.equals("*"));
    }

    private static void c() {
        File[] listFiles;
        try {
            File file = new File("/sdcard/libs/");
            if (file.exists() && file.isFile()) {
                b.a("CoreRuntimeInfo|libs is file not directory, delete libs file ++++", new Object[0]);
                file.delete();
            }
            if (!file.exists() && !file.mkdir()) {
                b.a("CoreRuntimeInfo|create libs directory failed ++++++", new Object[0]);
            }
            e.getFilesDir();
            File file2 = new File(CoreConsts.c + "/system/tmp/local");
            if (file2.exists() && (listFiles = file2.listFiles(new e())) != null && listFiles.length > 0) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        } catch (Throwable th) {
            b.a("CoreRuntimeInfo|initFile exception = " + th.toString(), new Object[0]);
            return;
        }
        V = e.getFilesDir().getPath();
        T = "/sdcard/libs//" + c + ".db";
        U = "/sdcard/libs//com.igexin.sdk.deviceId.db";
        S = "/sdcard/libs//" + c + ".properties";
        X = "/sdcard/libs//" + c + ".bin";
    }

    private static boolean d() {
        String a2 = com.igexin.push.core.b.a.a(e);
        if (TextUtils.isEmpty(a2)) {
            try {
                ApplicationInfo applicationInfo = e.getPackageManager().getApplicationInfo(c, 128);
                String a3 = com.igexin.push.util.b.a(applicationInfo);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    if (TextUtils.isEmpty(a3)) {
                        a3 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
                    }
                    if (a3 != null) {
                        a3 = a3.trim();
                    }
                    String string = applicationInfo.metaData.getString("GETUI_CUSTOM_TOKEN");
                    if (string != null) {
                        aB = string;
                    }
                }
                a2 = a3;
            } catch (Throwable th) {
                b.a("CoreRuntimeInfo|get ApplicationInfo meta data exception :" + th.toString(), new Object[0]);
                return false;
            }
        }
        if (TextUtils.isEmpty(a2)) {
            b.a("CoreRuntimeInfo|getui sdk init error, missing parm #####", new Object[0]);
            return false;
        }
        a = a2;
        b = SDKUrlConfig.getLocation();
        return true;
    }

    private static void e() {
        Cursor cursor = null;
        try {
            cursor = c.a().k().a(CrashHianalyticsData.MESSAGE, (String[]) null, (String[]) null, (String[]) null, (String) null);
            if (cursor != null) {
                at = cursor.getCount();
            }
            if (cursor == null) {
                return;
            }
        } catch (Throwable unused) {
            if (0 == 0) {
                return;
            }
        }
        cursor.close();
    }
}

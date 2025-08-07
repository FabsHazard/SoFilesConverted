package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class z {
    public static final String[] a = "@buglyAllChannel@".split(",");
    public static final String[] b = "@buglyAllChannelPriority@".split(",");
    private static ActivityManager c;

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (al.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[Catch:{ all -> 0x0053, all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r7) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "/proc/"
            r2.<init>(r3)     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "/cmdline"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x003c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003c }
            r1.<init>(r2)     // Catch:{ all -> 0x003c }
            r0 = 512(0x200, float:7.175E-43)
            char[] r2 = new char[r0]     // Catch:{ all -> 0x003a }
            r1.read(r2)     // Catch:{ all -> 0x003a }
            r3 = 0
            r4 = r3
        L_0x0024:
            if (r4 >= r0) goto L_0x002d
            char r5 = r2[r4]     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x002d
            int r4 = r4 + 1
            goto L_0x0024
        L_0x002d:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x003a }
            r0.<init>(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r7 = r0.substring(r3, r4)     // Catch:{ all -> 0x003a }
            r1.close()     // Catch:{ all -> 0x0039 }
        L_0x0039:
            return r7
        L_0x003a:
            r0 = move-exception
            goto L_0x0040
        L_0x003c:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0040:
            boolean r2 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x0049
            r0.printStackTrace()     // Catch:{ all -> 0x0053 }
        L_0x0049:
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ all -> 0x0052 }
        L_0x0052:
            return r7
        L_0x0053:
            r7 = move-exception
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ all -> 0x0059 }
        L_0x0059:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(int):java.lang.String");
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!(packageManager == null || applicationInfo == null || (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) == null)) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static boolean a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mActivities");
            declaredField2.setAccessible(true);
            for (Map.Entry value : ((Map) declaredField2.get(obj)).entrySet()) {
                Field declaredField3 = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("activity");
                declaredField3.setAccessible(true);
                Field declaredField4 = Activity.class.getDeclaredField("mResumed");
                declaredField4.setAccessible(true);
                if (((Boolean) declaredField4.get((Activity) declaredField3.get(value.getValue()))).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            al.b(th);
            return true;
        }
    }

    public static boolean a(ActivityManager activityManager) {
        if (activityManager == null) {
            al.c("is proc running, ActivityManager is null", new Object[0]);
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            al.c("running proc info list is empty, my proc not running.", new Object[0]);
            return false;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                al.c("my proc is running.", new Object[0]);
                return true;
            }
        }
        al.c("proc not in running proc info list, my proc not running.", new Object[0]);
        return false;
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                hashMap.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                hashMap.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                hashMap.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                hashMap.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                hashMap.put("BUGLY_AREA", obj8.toString());
            }
            return hashMap;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null) {
                if (str.length() != 0) {
                    String[] split = str.split(",");
                    for (int i = 0; i < split.length; i++) {
                        split[i] = split[i].trim();
                    }
                    return Arrays.asList(split);
                }
            }
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        if (c == null) {
            c = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            c.getMemoryInfo(memoryInfo);
            if (!memoryInfo.lowMemory) {
                return false;
            }
            al.c("Memory is low.", new Object[0]);
            return true;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }
}

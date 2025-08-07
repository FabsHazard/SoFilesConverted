package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: BUGLY */
public final class ab {
    private static final ArrayList<a> a = new ArrayList<a>() {
        {
            add(new l((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
            add(new m((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new k((byte) 0));
            add(new e((byte) 0));
            add(new j((byte) 0));
            add(new b((byte) 0));
            add(new d((byte) 0));
            add(new c((byte) 0));
        }
    };
    private static final Map<Integer, String> b = new HashMap<Integer, String>() {
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };
    private static final String[] c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (al.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (al.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    private static boolean p() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static String d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (al.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String a(Context context) {
        if (!(context == null || context.getApplicationInfo() == null)) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return "fail";
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith("x86")) {
                return "x86";
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return "fail";
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static long b(Context context) {
        long pss;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return 0;
            }
            pss = (long) activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
            return pss * 1024;
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[SYNTHETIC, Splitter:B:20:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long g() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x003a }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x003a }
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch:{ all -> 0x003a }
            r3.<init>(r4)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r3.readLine()     // Catch:{ all -> 0x0038 }
        L_0x0013:
            if (r2 == 0) goto L_0x002f
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x002a
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch:{ all -> 0x0038 }
            long r0 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x0038 }
            goto L_0x002f
        L_0x002a:
            java.lang.String r2 = r3.readLine()     // Catch:{ all -> 0x0038 }
            goto L_0x0013
        L_0x002f:
            r3.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0046
        L_0x0033:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0046
        L_0x0038:
            r2 = move-exception
            goto L_0x003e
        L_0x003a:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x003e:
            com.tencent.bugly.proguard.al.a(r2)     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ all -> 0x0033 }
        L_0x0046:
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            return r0
        L_0x004a:
            r0 = move-exception
            if (r3 == 0) goto L_0x0055
            r3.close()     // Catch:{ all -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0055:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.g():long");
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088 A[SYNTHETIC, Splitter:B:47:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098 A[SYNTHETIC, Splitter:B:54:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long i() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0079 }
            r2.<init>(r0)     // Catch:{ all -> 0x0079 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x0074 }
            r3 = 2048(0x800, float:2.87E-42)
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x0072 }
            if (r1 != 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x0023
        L_0x0019:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0023
            r0.printStackTrace()
        L_0x0023:
            r2.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0031
        L_0x0027:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0031
            r0.printStackTrace()
        L_0x0031:
            r0 = -1
            return r0
        L_0x0034:
            java.lang.String r3 = ":\\s+"
            r4 = 2
            java.lang.String[] r1 = r1.split(r3, r4)     // Catch:{ all -> 0x0072 }
            r3 = 1
            r1 = r1[r3]     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "kb"
            java.lang.String r4 = ""
            java.lang.String r1 = r1.replace(r3, r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0072 }
            long r3 = java.lang.Long.parseLong(r1)     // Catch:{ all -> 0x0072 }
            r5 = 1024(0x400, double:5.06E-321)
            long r3 = r3 * r5
            r0.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x0063
        L_0x0059:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0063
            r0.printStackTrace()
        L_0x0063:
            r2.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0071
        L_0x0067:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0071
            r0.printStackTrace()
        L_0x0071:
            return r3
        L_0x0072:
            r1 = move-exception
            goto L_0x007d
        L_0x0074:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x007d
        L_0x0079:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L_0x007d:
            boolean r3 = com.tencent.bugly.proguard.al.a(r1)     // Catch:{ all -> 0x00a9 }
            if (r3 != 0) goto L_0x0086
            r1.printStackTrace()     // Catch:{ all -> 0x00a9 }
        L_0x0086:
            if (r0 == 0) goto L_0x0096
            r0.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0096
        L_0x008c:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0096
            r0.printStackTrace()
        L_0x0096:
            if (r2 == 0) goto L_0x00a6
            r2.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a6
        L_0x009c:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x00a6
            r0.printStackTrace()
        L_0x00a6:
            r0 = -2
            return r0
        L_0x00a9:
            r1 = move-exception
            if (r0 == 0) goto L_0x00ba
            r0.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00ba
        L_0x00b0:
            r0 = move-exception
            boolean r3 = com.tencent.bugly.proguard.al.a(r0)
            if (r3 != 0) goto L_0x00ba
            r0.printStackTrace()
        L_0x00ba:
            if (r2 == 0) goto L_0x00ca
            r2.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00ca
        L_0x00c0:
            r0 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.a(r0)
            if (r2 != 0) goto L_0x00ca
            r0.printStackTrace()
        L_0x00ca:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.i():long");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.FileReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.FileReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f8 A[Catch:{ all -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fd A[SYNTHETIC, Splitter:B:81:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010d A[SYNTHETIC, Splitter:B:88:0x010d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long j() {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "kb"
            java.lang.String r2 = ":\\s+"
            java.lang.String r3 = "/proc/meminfo"
            r4 = 0
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x00f0 }
            r5.<init>(r3)     // Catch:{ all -> 0x00f0 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x00ee }
            r6 = 2048(0x800, float:2.87E-42)
            r3.<init>(r5, r6)     // Catch:{ all -> 0x00ee }
            r3.readLine()     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x00eb }
            r6 = -1
            if (r4 != 0) goto L_0x003d
            r3.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x002e
        L_0x0024:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x002e
            r0.printStackTrace()
        L_0x002e:
            r5.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x003c
        L_0x0032:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x003c
            r0.printStackTrace()
        L_0x003c:
            return r6
        L_0x003d:
            r8 = 2
            java.lang.String[] r4 = r4.split(r2, r8)     // Catch:{ all -> 0x00eb }
            r9 = 1
            r4 = r4[r9]     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r4.replace(r1, r0)     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00eb }
            long r10 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x00eb }
            r12 = 1024(0x400, double:5.06E-321)
            long r10 = r10 * r12
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x00eb }
            if (r4 != 0) goto L_0x007b
            r3.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x006c
        L_0x0062:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x006c
            r0.printStackTrace()
        L_0x006c:
            r5.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x007a
        L_0x0070:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x007a
            r0.printStackTrace()
        L_0x007a:
            return r6
        L_0x007b:
            java.lang.String[] r4 = r4.split(r2, r8)     // Catch:{ all -> 0x00eb }
            r4 = r4[r9]     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r4.replace(r1, r0)     // Catch:{ all -> 0x00eb }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00eb }
            long r14 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x00eb }
            long r14 = r14 * r12
            long r10 = r10 + r14
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x00eb }
            if (r4 != 0) goto L_0x00b6
            r3.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a7
        L_0x009d:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x00a7
            r0.printStackTrace()
        L_0x00a7:
            r5.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00b5
        L_0x00ab:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x00b5
            r0.printStackTrace()
        L_0x00b5:
            return r6
        L_0x00b6:
            java.lang.String[] r2 = r4.split(r2, r8)     // Catch:{ all -> 0x00eb }
            r2 = r2[r9]     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = r2.replace(r1, r0)     // Catch:{ all -> 0x00eb }
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x00eb }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x00eb }
            long r0 = r0 * r12
            long r10 = r10 + r0
            r3.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00dc
        L_0x00d2:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x00dc
            r0.printStackTrace()
        L_0x00dc:
            r5.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00ea
        L_0x00e0:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x00ea
            r0.printStackTrace()
        L_0x00ea:
            return r10
        L_0x00eb:
            r0 = move-exception
            r4 = r3
            goto L_0x00f2
        L_0x00ee:
            r0 = move-exception
            goto L_0x00f2
        L_0x00f0:
            r0 = move-exception
            r5 = r4
        L_0x00f2:
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x011e }
            if (r1 != 0) goto L_0x00fb
            r0.printStackTrace()     // Catch:{ all -> 0x011e }
        L_0x00fb:
            if (r4 == 0) goto L_0x010b
            r4.close()     // Catch:{ IOException -> 0x0101 }
            goto L_0x010b
        L_0x0101:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x010b
            r0.printStackTrace()
        L_0x010b:
            if (r5 == 0) goto L_0x011b
            r5.close()     // Catch:{ IOException -> 0x0111 }
            goto L_0x011b
        L_0x0111:
            r0 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x011b
            r0.printStackTrace()
        L_0x011b:
            r0 = -2
            return r0
        L_0x011e:
            r0 = move-exception
            if (r4 == 0) goto L_0x012f
            r4.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x012f
        L_0x0125:
            r1 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.a(r1)
            if (r2 != 0) goto L_0x012f
            r1.printStackTrace()
        L_0x012f:
            if (r5 == 0) goto L_0x013f
            r5.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x013f
        L_0x0135:
            r1 = move-exception
            boolean r2 = com.tencent.bugly.proguard.al.a(r1)
            if (r2 != 0) goto L_0x013f
            r1.printStackTrace()
        L_0x013f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.j():long");
    }

    public static long k() {
        if (!p()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (al.a(th)) {
                return -2;
            }
            th.printStackTrace();
            return -2;
        }
    }

    public static long l() {
        if (!p()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (al.a(th)) {
                return -2;
            }
            th.printStackTrace();
            return -2;
        }
    }

    public static String m() {
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r4) {
        /*
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r4.getSystemService(r1)     // Catch:{ Exception -> 0x0059 }
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch:{ Exception -> 0x0059 }
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0059 }
            if (r1 != 0) goto L_0x0012
            r4 = 0
            return r4
        L_0x0012:
            int r2 = r1.getType()     // Catch:{ Exception -> 0x0059 }
            r3 = 1
            if (r2 != r3) goto L_0x001c
            java.lang.String r4 = "WIFI"
            goto L_0x0064
        L_0x001c:
            int r1 = r1.getType()     // Catch:{ Exception -> 0x0059 }
            if (r1 != 0) goto L_0x0063
            java.lang.String r1 = "phone"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch:{ Exception -> 0x0059 }
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch:{ Exception -> 0x0059 }
            if (r4 == 0) goto L_0x0063
            int r4 = r4.getNetworkType()     // Catch:{ Exception -> 0x0059 }
            java.util.Map<java.lang.Integer, java.lang.String> r1 = b     // Catch:{ Exception -> 0x0059 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0059 }
            if (r1 != 0) goto L_0x0057
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = "MOBILE("
            r0.<init>(r2)     // Catch:{ Exception -> 0x0054 }
            java.lang.StringBuilder r4 = r0.append(r4)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r0 = ")"
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0054 }
            goto L_0x0063
        L_0x0054:
            r4 = move-exception
            r0 = r1
            goto L_0x005a
        L_0x0057:
            r0 = r1
            goto L_0x0063
        L_0x0059:
            r4 = move-exception
        L_0x005a:
            boolean r1 = com.tencent.bugly.proguard.al.a(r4)
            if (r1 != 0) goto L_0x0063
            r4.printStackTrace()
        L_0x0063:
            r4 = r0
        L_0x0064:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.c(android.content.Context):java.lang.String");
    }

    public static String d(Context context) {
        Iterator<a> it = a.iterator();
        while (it.hasNext()) {
            String a2 = it.next().a(context);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return null;
    }

    public static boolean e(Context context) {
        if (TextUtils.isEmpty(new i((byte) 0).a(context))) {
            return false;
        }
        return true;
    }

    public static boolean f(Context context) {
        if (TextUtils.isEmpty(new k((byte) 0).a(context))) {
            return false;
        }
        return true;
    }

    public static boolean n() {
        boolean z;
        String[] strArr = c;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || z;
    }

    public static boolean o() {
        float maxMemory = (float) ((((double) Runtime.getRuntime().maxMemory()) * 1.0d) / 1048576.0d);
        float f2 = (float) ((((double) Runtime.getRuntime().totalMemory()) * 1.0d) / 1048576.0d);
        float f3 = maxMemory - f2;
        al.c("maxMemory : %f", Float.valueOf(maxMemory));
        al.c("totalMemory : %f", Float.valueOf(f2));
        al.c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    /* compiled from: BUGLY */
    static abstract class a {
        public abstract String a(Context context);

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* compiled from: BUGLY */
    static class l extends a {
        private l() {
            super((byte) 0);
        }

        /* synthetic */ l(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.miui.ui.version.name");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "XiaoMi/MIUI/".concat(String.valueOf(a));
        }
    }

    /* compiled from: BUGLY */
    static class f extends a {
        private f() {
            super((byte) 0);
        }

        /* synthetic */ f(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.build.version.emui");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "HuaWei/EMOTION/".concat(String.valueOf(a));
        }
    }

    /* compiled from: BUGLY */
    static class g extends a {
        private g() {
            super((byte) 0);
        }

        /* synthetic */ g(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.lenovo.series");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "Lenovo/VIBE/".concat(String.valueOf(ap.a(context, "ro.build.version.incremental")));
        }
    }

    /* compiled from: BUGLY */
    static class m extends a {
        private m() {
            super((byte) 0);
        }

        /* synthetic */ m(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.build.nubia.rom.name");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "Zte/NUBIA/" + a + "_" + ap.a(context, "ro.build.nubia.rom.code");
        }
    }

    /* compiled from: BUGLY */
    static class h extends a {
        private h() {
            super((byte) 0);
        }

        /* synthetic */ h(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.meizu.product.model");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "Meizu/FLYME/" + ap.a(context, "ro.build.display.id");
        }
    }

    /* compiled from: BUGLY */
    static class i extends a {
        private i() {
            super((byte) 0);
        }

        /* synthetic */ i(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.build.version.opporom");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "Oppo/COLOROS/".concat(String.valueOf(a));
        }
    }

    /* compiled from: BUGLY */
    static class k extends a {
        private k() {
            super((byte) 0);
        }

        /* synthetic */ k(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.vivo.os.build.display.id");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "vivo/FUNTOUCH/".concat(String.valueOf(a));
        }
    }

    /* compiled from: BUGLY */
    static class e extends a {
        private e() {
            super((byte) 0);
        }

        /* synthetic */ e(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.aa.romver");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "htc/" + a + InternalZipConstants.ZIP_FILE_SEPARATOR + ap.a(context, "ro.build.description");
        }
    }

    /* compiled from: BUGLY */
    static class j extends a {
        private j() {
            super((byte) 0);
        }

        /* synthetic */ j(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.lewa.version");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "tcl/" + a + InternalZipConstants.ZIP_FILE_SEPARATOR + ap.a(context, "ro.build.display.id");
        }
    }

    /* compiled from: BUGLY */
    static class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.gn.gnromvernumber");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "amigo/" + a + InternalZipConstants.ZIP_FILE_SEPARATOR + ap.a(context, "ro.build.display.id");
        }
    }

    /* compiled from: BUGLY */
    static class d extends a {
        private d() {
            super((byte) 0);
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final String a(Context context) {
            String a = ap.a(context, "ro.build.tyd.kbstyle_version");
            if (ap.a(a) || a.equals("fail")) {
                return null;
            }
            return "dido/".concat(String.valueOf(a));
        }
    }

    /* compiled from: BUGLY */
    static class c extends a {
        private c() {
            super((byte) 0);
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final String a(Context context) {
            return ap.a(context, "ro.build.fingerprint") + InternalZipConstants.ZIP_FILE_SEPARATOR + ap.a(context, "ro.build.rom.id");
        }
    }
}

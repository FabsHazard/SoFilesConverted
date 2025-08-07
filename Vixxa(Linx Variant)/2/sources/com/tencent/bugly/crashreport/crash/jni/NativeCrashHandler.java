package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.microtech.aidexx.utils.TimeUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
import java.io.File;

/* compiled from: BUGLY */
public class NativeCrashHandler implements q {
    private static NativeCrashHandler a = null;
    private static int b = 1;
    /* access modifiers changed from: private */
    public static String g = null;
    /* access modifiers changed from: private */
    public static boolean n = true;
    /* access modifiers changed from: private */
    public final Context c;
    private final aa d;
    private final ak e;
    /* access modifiers changed from: private */
    public NativeExceptionHandler f;
    private final boolean h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public as m;

    private native String getSoCpuAbi();

    /* access modifiers changed from: protected */
    public native boolean appendNativeLog(String str, String str2, String str3);

    /* access modifiers changed from: protected */
    public native boolean appendWholeNativeLog(String str);

    /* access modifiers changed from: protected */
    public native String getNativeKeyValueList();

    /* access modifiers changed from: protected */
    public native String getNativeLog();

    /* access modifiers changed from: protected */
    public native boolean putNativeKeyValue(String str, String str2);

    /* access modifiers changed from: protected */
    public native String regist(String str, boolean z, int i2);

    /* access modifiers changed from: protected */
    public native String removeNativeKeyValue(String str);

    /* access modifiers changed from: protected */
    public native void setNativeInfo(int i2, String str);

    /* access modifiers changed from: protected */
    public native void testCrash();

    /* access modifiers changed from: protected */
    public native String unregist();

    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z, String str) {
        this.c = ap.a(context);
        if (ap.a(g)) {
            try {
                if (ap.a(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).c + "/app_bugly";
            }
            g = str;
        }
        this.m = asVar;
        this.d = aaVar;
        this.e = akVar;
        this.h = z;
        this.f = new bd(context, aaVar, asVar, ac.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (a == null) {
                a = new NativeCrashHandler(context, aaVar, asVar, akVar, z, str);
            }
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = g;
        }
        return str;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            g = str;
        }
    }

    public static void setShouldHandleInJava(boolean z) {
        n = z;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z));
        }
    }

    public static boolean isShouldHandleInJava() {
        return n;
    }

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|(3:11|12|(4:14|(1:18)|19|(1:21)))(2:28|(7:30|31|32|(1:34)(1:35)|36|(1:38)|(4:40|(1:42)|43|(1:45))))|48|49|50|51) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x012c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.k     // Catch:{ all -> 0x0132 }
            r1 = 0
            if (r0 == 0) goto L_0x000f
            java.lang.String r13 = "[Native] Native crash report has already registered."
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0132 }
            com.tencent.bugly.proguard.al.d(r13, r0)     // Catch:{ all -> 0x0132 }
            monitor-exit(r12)
            return
        L_0x000f:
            boolean r0 = r12.j     // Catch:{ all -> 0x0132 }
            r2 = 1
            if (r0 == 0) goto L_0x007e
            java.lang.String r0 = g     // Catch:{ all -> 0x0075 }
            int r3 = b     // Catch:{ all -> 0x0075 }
            java.lang.String r13 = r12.regist(r0, r13, r3)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x012c
            java.lang.String r0 = "[Native] Native Crash Report enable."
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0075 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ all -> 0x0075 }
            com.tencent.bugly.proguard.aa r0 = r12.d     // Catch:{ all -> 0x0075 }
            r0.u = r13     // Catch:{ all -> 0x0075 }
            java.lang.String r13 = "-"
            com.tencent.bugly.proguard.aa r0 = r12.d     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r0.u     // Catch:{ all -> 0x0075 }
            java.lang.String r13 = r13.concat(r0)     // Catch:{ all -> 0x0075 }
            boolean r0 = com.tencent.bugly.proguard.at.b     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x0055
            com.tencent.bugly.proguard.aa r0 = r12.d     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r0.h     // Catch:{ all -> 0x0075 }
            boolean r13 = r0.contains(r13)     // Catch:{ all -> 0x0075 }
            if (r13 != 0) goto L_0x0055
            com.tencent.bugly.proguard.aa r13 = r12.d     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r13.h     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "-"
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0075 }
            com.tencent.bugly.proguard.aa r3 = r12.d     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = r3.u     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0075 }
            r13.h = r0     // Catch:{ all -> 0x0075 }
        L_0x0055:
            java.lang.String r13 = "comInfo.sdkVersion %s"
            com.tencent.bugly.proguard.aa r0 = r12.d     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = r0.h     // Catch:{ all -> 0x0075 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0075 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r13, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0075 }
            r12.k = r2     // Catch:{ all -> 0x0075 }
            java.lang.String r13 = r12.getRunningCpuAbi()     // Catch:{ all -> 0x0075 }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x0073
            com.tencent.bugly.proguard.aa r0 = r12.d     // Catch:{ all -> 0x0075 }
            r0.e(r13)     // Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r12)
            return
        L_0x0075:
            java.lang.String r13 = "[Native] Failed to load Bugly SO file."
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0132 }
            com.tencent.bugly.proguard.al.c(r13, r0)     // Catch:{ all -> 0x0132 }
            goto L_0x012c
        L_0x007e:
            boolean r0 = r12.i     // Catch:{ all -> 0x0132 }
            if (r0 == 0) goto L_0x012c
            java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r3 = "registNativeExceptionHandler2"
            r4 = 4
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ all -> 0x012c }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r1] = r5     // Catch:{ all -> 0x012c }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5     // Catch:{ all -> 0x012c }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x012c }
            r6 = 2
            r4[r6] = r5     // Catch:{ all -> 0x012c }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x012c }
            r7 = 3
            r4[r7] = r5     // Catch:{ all -> 0x012c }
            java.lang.String r5 = g     // Catch:{ all -> 0x012c }
            java.lang.String r8 = com.tencent.bugly.proguard.ab.d()     // Catch:{ all -> 0x012c }
            r9 = 5
            if (r13 == 0) goto L_0x00a6
            r10 = r2
            goto L_0x00a7
        L_0x00a6:
            r10 = r9
        L_0x00a7:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x012c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x012c }
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r8, r10, r11}     // Catch:{ all -> 0x012c }
            java.lang.Object r0 = com.tencent.bugly.proguard.ap.a(r0, r3, r4, r5)     // Catch:{ all -> 0x012c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x012c }
            if (r0 != 0) goto L_0x00e8
            java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r3 = "registNativeExceptionHandler"
            java.lang.Class[] r4 = new java.lang.Class[r7]     // Catch:{ all -> 0x012c }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r1] = r5     // Catch:{ all -> 0x012c }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5     // Catch:{ all -> 0x012c }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x012c }
            r4[r6] = r5     // Catch:{ all -> 0x012c }
            java.lang.String r5 = g     // Catch:{ all -> 0x012c }
            java.lang.String r6 = com.tencent.bugly.proguard.ab.d()     // Catch:{ all -> 0x012c }
            com.tencent.bugly.proguard.aa.b()     // Catch:{ all -> 0x012c }
            int r7 = com.tencent.bugly.proguard.aa.B()     // Catch:{ all -> 0x012c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x012c }
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6, r7}     // Catch:{ all -> 0x012c }
            java.lang.Object r0 = com.tencent.bugly.proguard.ap.a(r0, r3, r4, r5)     // Catch:{ all -> 0x012c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x012c }
        L_0x00e8:
            if (r0 == 0) goto L_0x012c
            r12.k = r2     // Catch:{ all -> 0x012c }
            com.tencent.bugly.proguard.aa r3 = r12.d     // Catch:{ all -> 0x012c }
            r3.u = r0     // Catch:{ all -> 0x012c }
            java.lang.String r0 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r3 = "enableHandler"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x012c }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x012c }
            r4[r1] = r5     // Catch:{ all -> 0x012c }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x012c }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x012c }
            com.tencent.bugly.proguard.ap.a(r0, r3, r4, r5)     // Catch:{ all -> 0x012c }
            if (r13 == 0) goto L_0x0106
            r9 = r2
        L_0x0106:
            java.lang.String r13 = "com.tencent.feedback.eup.jni.NativeExceptionUpload"
            java.lang.String r0 = "setLogMode"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ all -> 0x012c }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x012c }
            r2[r1] = r3     // Catch:{ all -> 0x012c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x012c }
            java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch:{ all -> 0x012c }
            com.tencent.bugly.proguard.ap.a(r13, r0, r2, r3)     // Catch:{ all -> 0x012c }
            java.lang.String r13 = r12.getRunningCpuAbi()     // Catch:{ all -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x012c }
            if (r0 != 0) goto L_0x012a
            com.tencent.bugly.proguard.aa r0 = r12.d     // Catch:{ all -> 0x012c }
            r0.e(r13)     // Catch:{ all -> 0x012c }
        L_0x012a:
            monitor-exit(r12)
            return
        L_0x012c:
            r12.j = r1     // Catch:{ all -> 0x0132 }
            r12.i = r1     // Catch:{ all -> 0x0132 }
            monitor-exit(r12)
            return
        L_0x0132:
            r13 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0132 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    public synchronized void startNativeMonitor() {
        if (!this.j) {
            if (!this.i) {
                boolean a2 = ap.a(this.d.t);
                boolean z = !a2;
                if (at.b) {
                    String str = "Bugly_Native";
                    if (!a2) {
                        str = this.d.t;
                    }
                    boolean a3 = a(str, z);
                    this.j = a3;
                    if (!a3 && a2) {
                        this.i = a("NativeRQD", false);
                    }
                } else {
                    String str2 = "Bugly_Native";
                    String str3 = this.d.t;
                    if (a2) {
                        this.d.getClass();
                    } else {
                        str2 = str3;
                    }
                    this.j = a(str2, z);
                }
                if (this.j || this.i) {
                    a(this.h);
                    setNativeAppVersion(this.d.o);
                    setNativeAppChannel(this.d.s);
                    setNativeAppPackage(this.d.c);
                    setNativeUserId(this.d.f());
                    setNativeIsAppForeground(this.d.a());
                    setNativeLaunchTime(this.d.a);
                    return;
                }
                return;
            }
        }
        a(this.h);
    }

    public void checkUploadRecordCrash() {
        this.e.a(new Runnable() {
            public final void run() {
                if (!ap.b(NativeCrashHandler.this.c, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.n) {
                    boolean unused = NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a2 = be.a(NativeCrashHandler.this.c, NativeCrashHandler.g, NativeCrashHandler.this.f);
                if (a2 != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.m.a(a2, true)) {
                        NativeCrashHandler.this.m.b(a2, false);
                    }
                    be.a(false, NativeCrashHandler.g);
                }
                NativeCrashHandler.a();
                ap.c(NativeCrashHandler.this.c, "native_record_lock");
            }
        });
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                Throwable th2 = th;
                z2 = true;
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            al.d(th.getMessage(), new Object[0]);
            al.d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    private synchronized void d() {
        if (!this.k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.k = false;
                return;
            }
        } catch (Throwable unused) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
            this.j = false;
            this.i = false;
        }
    }

    public void testNativeCrash() {
        if (!this.j) {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        a(16, String.valueOf(z));
        a(17, String.valueOf(z2));
        a(18, String.valueOf(z3));
        testNativeCrash();
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void resendSigquit() {
        a(20, "");
    }

    public void unBlockSigquit(boolean z) {
        if (z) {
            a(21, "true");
        } else {
            a(21, "false");
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f;
    }

    protected static void a() {
        long b2 = ap.b() - at.i;
        long b3 = ap.b() + TimeUtils.oneDayMillis;
        File file = new File(g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                if (listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                al.a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        be.c(g);
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            d();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.l;
    }

    private synchronized void c(boolean z) {
        if (this.l != z) {
            al.a("user change native %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        ac a2 = ac.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().f;
        }
        if (isUserOpened != this.k) {
            al.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f != this.k) {
                al.d("server native changed to %b", Boolean.valueOf(strategyBean.f));
            }
        }
        boolean z = ac.a().c().f && this.l;
        if (z != this.k) {
            al.a("native changed to %b", Boolean.valueOf(z));
            b(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if (!((!this.i && !this.j) || str == null || str2 == null || str3 == null)) {
            try {
                if (this.j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public String getLogFromNative() {
        if (!this.i && !this.j) {
            return null;
        }
        try {
            if (this.j) {
                return getNativeLog();
            }
            return (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", (Class<?>[]) null, (Object[]) null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if (!((!this.i && !this.j) || str == null || str2 == null)) {
            try {
                if (this.j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (!this.j) {
            return false;
        }
        try {
            setNativeInfo(i2, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (al.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public void enableCatchAnrTrace() {
        b |= 2;
    }

    public void disableCatchAnrTrace() {
        b = 1;
    }

    public boolean isEnableCatchAnrTrace() {
        return (b & 2) == 2;
    }
}

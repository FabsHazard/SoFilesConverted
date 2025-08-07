package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;

/* compiled from: BUGLY */
public final class av implements Thread.UncaughtExceptionHandler {
    private static String h;
    private static final Object i = new Object();
    protected final Context a;
    protected final as b;
    protected final ac c;
    protected final aa d;
    protected Thread.UncaughtExceptionHandler e;
    protected Thread.UncaughtExceptionHandler f;
    protected boolean g = false;
    private int j;

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.a = context;
        this.b = asVar;
        this.c = acVar;
        this.d = aaVar;
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (!getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.f = defaultUncaughtExceptionHandler;
                    this.e = defaultUncaughtExceptionHandler;
                } else {
                    al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.e = defaultUncaughtExceptionHandler;
                }
            } else {
                return;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0119 A[Catch:{ all -> 0x014a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0129 A[Catch:{ all -> 0x014a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.bugly.crashreport.crash.CrashDetailBean b(java.lang.Thread r5, java.lang.Throwable r6, boolean r7, java.lang.String r8, byte[] r9, boolean r10) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x000c
            java.lang.String r5 = "We can do nothing with a null throwable."
            java.lang.Object[] r6 = new java.lang.Object[r0]
            com.tencent.bugly.proguard.al.d(r5, r6)
            r5 = 0
            return r5
        L_0x000c:
            com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = new com.tencent.bugly.crashreport.crash.CrashDetailBean
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r1.r = r2
            long r2 = com.tencent.bugly.proguard.ab.j()
            r1.C = r2
            long r2 = com.tencent.bugly.proguard.ab.f()
            r1.D = r2
            long r2 = com.tencent.bugly.proguard.ab.l()
            r1.E = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            long r2 = r2.k()
            r1.F = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            long r2 = r2.j()
            r1.G = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            long r2 = r2.l()
            r1.H = r2
            if (r7 != 0) goto L_0x0050
            int r2 = com.tencent.bugly.proguard.aa.B()
            r3 = 31
            if (r2 < r3) goto L_0x0050
            r2 = 0
            r1.I = r2
            goto L_0x0058
        L_0x0050:
            android.content.Context r2 = r4.a
            long r2 = com.tencent.bugly.proguard.ab.b(r2)
            r1.I = r2
        L_0x0058:
            long r2 = com.tencent.bugly.proguard.ab.g()
            r1.J = r2
            long r2 = com.tencent.bugly.proguard.ab.h()
            r1.K = r2
            byte[] r2 = com.tencent.bugly.proguard.ao.a()
            r1.y = r2
            byte[] r2 = r1.y
            if (r2 != 0) goto L_0x0070
            r2 = r0
            goto L_0x0073
        L_0x0070:
            byte[] r2 = r1.y
            int r2 = r2.length
        L_0x0073:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r3 = "user log size:%d"
            com.tencent.bugly.proguard.al.a((java.lang.String) r3, (java.lang.Object[]) r2)
            if (r7 == 0) goto L_0x0084
            r2 = r0
            goto L_0x0085
        L_0x0084:
            r2 = 2
        L_0x0085:
            r1.b = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r2 = r2.g()
            r1.e = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r2 = r2.o
            r1.f = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r2 = r2.q()
            r1.g = r2
            com.tencent.bugly.proguard.aa r2 = r4.d
            java.lang.String r2 = r2.f()
            r1.m = r2
            int r2 = com.tencent.bugly.proguard.at.h
            java.util.Map r10 = com.tencent.bugly.proguard.ap.a((boolean) r10, (int) r2)
            r1.z = r10
            com.tencent.bugly.proguard.aa r10 = r4.d
            java.lang.String r10 = r10.d
            r1.A = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = r5.getName()
            java.lang.StringBuilder r10 = r10.append(r2)
            java.lang.String r2 = "("
            java.lang.StringBuilder r10 = r10.append(r2)
            long r2 = r5.getId()
            java.lang.StringBuilder r5 = r10.append(r2)
            java.lang.String r10 = ")"
            java.lang.StringBuilder r5 = r5.append(r10)
            java.lang.String r5 = r5.toString()
            r1.B = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            java.lang.String r5 = r5.s()
            r1.L = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            java.util.Map r5 = r5.p()
            r1.h = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            java.util.Map r5 = r5.A()
            r1.i = r5
            com.tencent.bugly.proguard.aa r5 = r4.d
            long r2 = r5.a
            r1.Q = r2
            com.tencent.bugly.proguard.aa r5 = r4.d
            boolean r5 = r5.a()
            r1.R = r5
            a(r1, r6, r7)
            if (r7 != 0) goto L_0x012b
            r5 = 1
            if (r8 == 0) goto L_0x0110
            int r6 = r8.length()     // Catch:{ all -> 0x014a }
            if (r6 <= 0) goto L_0x0110
            r6 = r5
            goto L_0x0111
        L_0x0110:
            r6 = r0
        L_0x0111:
            if (r9 == 0) goto L_0x0117
            int r7 = r9.length     // Catch:{ all -> 0x014a }
            if (r7 <= 0) goto L_0x0117
            r0 = r5
        L_0x0117:
            if (r6 == 0) goto L_0x0127
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x014a }
            r6.<init>(r5)     // Catch:{ all -> 0x014a }
            r1.S = r6     // Catch:{ all -> 0x014a }
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.S     // Catch:{ all -> 0x014a }
            java.lang.String r6 = "UserData"
            r5.put(r6, r8)     // Catch:{ all -> 0x014a }
        L_0x0127:
            if (r0 == 0) goto L_0x012b
            r1.Y = r9     // Catch:{ all -> 0x014a }
        L_0x012b:
            com.tencent.bugly.proguard.aa r5 = r4.d     // Catch:{ all -> 0x014a }
            int r5 = r5.z()     // Catch:{ all -> 0x014a }
            r1.U = r5     // Catch:{ all -> 0x014a }
            com.tencent.bugly.proguard.aa r5 = r4.d     // Catch:{ all -> 0x014a }
            int r5 = r5.x     // Catch:{ all -> 0x014a }
            r1.V = r5     // Catch:{ all -> 0x014a }
            com.tencent.bugly.proguard.aa r5 = r4.d     // Catch:{ all -> 0x014a }
            java.util.Map r5 = r5.t()     // Catch:{ all -> 0x014a }
            r1.W = r5     // Catch:{ all -> 0x014a }
            com.tencent.bugly.proguard.aa r5 = r4.d     // Catch:{ all -> 0x014a }
            java.util.Map r5 = r5.y()     // Catch:{ all -> 0x014a }
            r1.X = r5     // Catch:{ all -> 0x014a }
            goto L_0x0158
        L_0x014a:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            java.lang.String r6 = "handle crash error %s"
            com.tencent.bugly.proguard.al.e(r6, r5)
        L_0x0158:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z) {
        String str;
        String name = th.getClass().getName();
        String a2 = a(th);
        al.e("stack frame :%d, has cause %b", Integer.valueOf(th.getStackTrace().length), Boolean.valueOf(th.getCause() != null));
        String str2 = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : str2;
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 == null || th2 == th) {
            crashDetailBean.n = name;
            if (at.a().i() && z) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str2 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.o = a2 + str2;
            crashDetailBean.p = stackTraceElement;
            str = a(th, at.h);
            crashDetailBean.q = str;
        } else {
            crashDetailBean.n = th2.getClass().getName();
            crashDetailBean.o = a(th2);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(":").append(a2).append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......\nCaused by:\n");
            sb.append(crashDetailBean.n).append(":").append(crashDetailBean.o).append("\n");
            str = a(th2, at.h);
            sb.append(str);
            crashDetailBean.q = sb.toString();
        }
        crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.z.put(crashDetailBean.B, str);
    }

    private static boolean a(Thread thread) {
        synchronized (i) {
            if (h != null) {
                if (thread.getName().equals(h)) {
                    return true;
                }
            }
            h = thread.getName();
            return false;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        String str2;
        Thread thread2 = thread;
        Throwable th2 = th;
        boolean z3 = z;
        if (z3) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f.uncaughtException(thread2, th2);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.e.uncaughtException(thread2, th2);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f.uncaughtException(thread2, th2);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } else {
                if (!this.c.b()) {
                    al.d("no remote but still store!", new Object[0]);
                }
                String str3 = "JAVA_CRASH";
                if (!this.c.c().f) {
                    if (this.c.b()) {
                        al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                        if (z3) {
                            str2 = str3;
                        } else {
                            str2 = "JAVA_CATCH";
                        }
                        as.a(str2, ap.a(), this.d.d, thread.getName(), ap.a(th), (CrashDetailBean) null);
                        if (z3) {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.e;
                            if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                                al.e("sys default last handle start!", new Object[0]);
                                this.e.uncaughtException(thread2, th2);
                                al.e("sys default last handle end!", new Object[0]);
                                return;
                            } else if (this.f != null) {
                                al.e("system handle start!", new Object[0]);
                                this.f.uncaughtException(thread2, th2);
                                al.e("system handle end!", new Object[0]);
                                return;
                            } else {
                                al.e("crashreport last handle start!", new Object[0]);
                                c();
                                al.e("crashreport last handle end!", new Object[0]);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                CrashDetailBean b2 = b(thread, th, z, str, bArr, z2);
                if (b2 == null) {
                    al.e("pkg crash datas fail!", new Object[0]);
                    if (z3) {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.e;
                        if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                            al.e("sys default last handle start!", new Object[0]);
                            this.e.uncaughtException(thread2, th2);
                            al.e("sys default last handle end!", new Object[0]);
                        } else if (this.f != null) {
                            al.e("system handle start!", new Object[0]);
                            this.f.uncaughtException(thread2, th2);
                            al.e("system handle end!", new Object[0]);
                        } else {
                            al.e("crashreport last handle start!", new Object[0]);
                            c();
                            al.e("crashreport last handle end!", new Object[0]);
                        }
                    }
                } else {
                    if (!z3) {
                        str3 = "JAVA_CATCH";
                    }
                    as.a(str3, ap.a(), this.d.d, thread.getName(), ap.a(th), b2);
                    if (!this.b.a(b2, z3)) {
                        this.b.b(b2, z3);
                    }
                    if (z3) {
                        this.b.a(b2);
                    }
                    if (z3) {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.e;
                        if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                            al.e("sys default last handle start!", new Object[0]);
                            this.e.uncaughtException(thread2, th2);
                            al.e("sys default last handle end!", new Object[0]);
                        } else if (this.f != null) {
                            al.e("system handle start!", new Object[0]);
                            this.f.uncaughtException(thread2, th2);
                            al.e("system handle end!", new Object[0]);
                        } else {
                            al.e("crashreport last handle start!", new Object[0]);
                            c();
                            al.e("crashreport last handle end!", new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            if (z3) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.e;
                if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.e.uncaughtException(thread2, th2);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f.uncaughtException(thread2, th2);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
            throw th3;
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (i) {
            a(thread, th, true, (String) null, (byte[]) null, this.d.Q);
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 == 0) goto L_0x0028
            boolean r0 = r3.f     // Catch:{ all -> 0x0025 }
            boolean r1 = r2.g     // Catch:{ all -> 0x0025 }
            if (r0 == r1) goto L_0x0028
            java.lang.String r0 = "java changed to %b"
            boolean r1 = r3.f     // Catch:{ all -> 0x0025 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0025 }
            java.lang.Object[] r1 = new java.lang.Object[]{r1}     // Catch:{ all -> 0x0025 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0025 }
            boolean r3 = r3.f     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x0021
            r2.a()     // Catch:{ all -> 0x0025 }
            monitor-exit(r2)
            return
        L_0x0021:
            r2.b()     // Catch:{ all -> 0x0025 }
            goto L_0x0028
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r3
        L_0x0028:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.a(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    private static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i3 = 0;
                while (i3 < length) {
                    StackTraceElement stackTraceElement = stackTrace[i3];
                    if (i2 <= 0 || sb.length() < i2) {
                        sb.append(stackTraceElement.toString()).append("\n");
                        i3++;
                    } else {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}

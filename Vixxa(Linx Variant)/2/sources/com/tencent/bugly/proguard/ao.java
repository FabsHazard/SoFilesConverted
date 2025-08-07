package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/* compiled from: BUGLY */
public final class ao {
    public static boolean a = true;
    public static boolean b = true;
    private static SimpleDateFormat c = null;
    private static int d = 30720;
    private static StringBuilder e = null;
    private static StringBuilder f = null;
    private static boolean g = false;
    private static a h = null;
    private static String i = null;
    private static String j = null;
    private static Context k = null;
    private static String l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    static {
        try {
            c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    /* access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        try {
            aa b2 = aa.b();
            if (b2 == null || b2.N == null) {
                return false;
            }
            return b2.N.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static String b() {
        try {
            aa b2 = aa.b();
            if (b2 == null || b2.N == null) {
                return null;
            }
            return b2.N.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r3) {
        /*
            java.lang.Class<com.tencent.bugly.proguard.ao> r0 = com.tencent.bugly.proguard.ao.class
            monitor-enter(r0)
            boolean r1 = m     // Catch:{ all -> 0x0078 }
            if (r1 != 0) goto L_0x0076
            if (r3 == 0) goto L_0x0076
            boolean r1 = b     // Catch:{ all -> 0x0078 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0076
        L_0x000e:
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()     // Catch:{ all -> 0x0071 }
            o = r1     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x0071 }
            f = r1     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r1.<init>(r2)     // Catch:{ all -> 0x0071 }
            e = r1     // Catch:{ all -> 0x0071 }
            k = r3     // Catch:{ all -> 0x0071 }
            com.tencent.bugly.proguard.aa r3 = com.tencent.bugly.proguard.aa.a((android.content.Context) r3)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = r3.d     // Catch:{ all -> 0x0071 }
            i = r1     // Catch:{ all -> 0x0071 }
            r3.getClass()     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = ""
            j = r3     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r3.<init>()     // Catch:{ all -> 0x0071 }
            android.content.Context r1 = k     // Catch:{ all -> 0x0071 }
            java.io.File r1 = r1.getFilesDir()     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = r1.getPath()     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "/buglylog_"
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = i     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "_"
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = j     // Catch:{ all -> 0x0071 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = ".txt"
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0071 }
            l = r3     // Catch:{ all -> 0x0071 }
            int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x0071 }
            p = r3     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r3 = 1
            m = r3     // Catch:{ all -> 0x0078 }
            monitor-exit(r0)
            return
        L_0x0076:
            monitor-exit(r0)
            return
        L_0x0078:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a(android.content.Context):void");
    }

    public static void a(int i2) {
        synchronized (q) {
            d = i2;
            if (i2 < 0) {
                d = 0;
            } else if (i2 > 30720) {
                d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            a(str, str2, message + 10 + ap.b(th));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(final java.lang.String r3, final java.lang.String r4, final java.lang.String r5) {
        /*
            java.lang.Class<com.tencent.bugly.proguard.ao> r0 = com.tencent.bugly.proguard.ao.class
            monitor-enter(r0)
            boolean r1 = m     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            boolean r1 = b     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x000c
            goto L_0x002e
        L_0x000c:
            boolean r1 = n     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x001c
            java.util.concurrent.ExecutorService r1 = o     // Catch:{ Exception -> 0x0028 }
            com.tencent.bugly.proguard.ao$1 r2 = new com.tencent.bugly.proguard.ao$1     // Catch:{ Exception -> 0x0028 }
            r2.<init>(r3, r4, r5)     // Catch:{ Exception -> 0x0028 }
            r1.execute(r2)     // Catch:{ Exception -> 0x0028 }
            monitor-exit(r0)
            return
        L_0x001c:
            java.util.concurrent.ExecutorService r1 = o     // Catch:{ Exception -> 0x0028 }
            com.tencent.bugly.proguard.ao$2 r2 = new com.tencent.bugly.proguard.ao$2     // Catch:{ Exception -> 0x0028 }
            r2.<init>(r3, r4, r5)     // Catch:{ Exception -> 0x0028 }
            r1.execute(r2)     // Catch:{ Exception -> 0x0028 }
            monitor-exit(r0)
            return
        L_0x0028:
            r3 = move-exception
            com.tencent.bugly.proguard.al.b(r3)     // Catch:{ all -> 0x0030 }
            monitor-exit(r0)
            return
        L_0x002e:
            monitor-exit(r0)
            return
        L_0x0030:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (a) {
                f(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a2 = a(str, str2, str3, (long) Process.myTid());
            synchronized (q) {
                try {
                    f.append(a2);
                    if (f.length() >= d) {
                        StringBuilder sb = f;
                        f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:19|20|21|(1:23)(2:24|(1:28))|29|(1:31)|32|33|34|35) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void g(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.Class<com.tencent.bugly.proguard.ao> r0 = com.tencent.bugly.proguard.ao.class
            monitor-enter(r0)
            int r1 = android.os.Process.myTid()     // Catch:{ all -> 0x0076 }
            long r1 = (long) r1     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = a(r5, r6, r7, r1)     // Catch:{ all -> 0x0076 }
            java.lang.Object r6 = q     // Catch:{ all -> 0x0076 }
            monitor-enter(r6)     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r7 = f     // Catch:{ all -> 0x0070 }
            r7.append(r5)     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r5 = f     // Catch:{ all -> 0x0070 }
            int r5 = r5.length()     // Catch:{ all -> 0x0070 }
            int r7 = d     // Catch:{ all -> 0x0070 }
            if (r5 > r7) goto L_0x0021
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)
            return
        L_0x0021:
            boolean r5 = g     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x0028
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)
            return
        L_0x0028:
            r5 = 1
            g = r5     // Catch:{ all -> 0x0070 }
            com.tencent.bugly.proguard.ao$a r5 = h     // Catch:{ all -> 0x0070 }
            if (r5 != 0) goto L_0x0039
            com.tencent.bugly.proguard.ao$a r5 = new com.tencent.bugly.proguard.ao$a     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = l     // Catch:{ all -> 0x0070 }
            r5.<init>(r7)     // Catch:{ all -> 0x0070 }
            h = r5     // Catch:{ all -> 0x0070 }
            goto L_0x005a
        L_0x0039:
            java.io.File r5 = r5.b     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x0055
            com.tencent.bugly.proguard.ao$a r5 = h     // Catch:{ all -> 0x0070 }
            java.io.File r5 = r5.b     // Catch:{ all -> 0x0070 }
            long r1 = r5.length()     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r5 = f     // Catch:{ all -> 0x0070 }
            int r5 = r5.length()     // Catch:{ all -> 0x0070 }
            long r3 = (long) r5     // Catch:{ all -> 0x0070 }
            long r1 = r1 + r3
            com.tencent.bugly.proguard.ao$a r5 = h     // Catch:{ all -> 0x0070 }
            long r3 = r5.c     // Catch:{ all -> 0x0070 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x005a
        L_0x0055:
            com.tencent.bugly.proguard.ao$a r5 = h     // Catch:{ all -> 0x0070 }
            r5.a()     // Catch:{ all -> 0x0070 }
        L_0x005a:
            com.tencent.bugly.proguard.ao$a r5 = h     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r7 = f     // Catch:{ all -> 0x0070 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0070 }
            boolean r5 = r5.a(r7)     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x0070
            java.lang.StringBuilder r5 = f     // Catch:{ all -> 0x0070 }
            r7 = 0
            r5.setLength(r7)     // Catch:{ all -> 0x0070 }
            g = r7     // Catch:{ all -> 0x0070 }
        L_0x0070:
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)
            return
        L_0x0073:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0073 }
            throw r5     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.g(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static String a(String str, String str2, String str3, long j2) {
        String str4;
        e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = c;
        if (simpleDateFormat != null) {
            str4 = simpleDateFormat.format(date);
        } else {
            str4 = date.toString();
        }
        e.append(str4).append(" ").append(p).append(" ").append(j2).append(" ").append(str).append(" ").append(str2).append(": ").append(str3).append("\u0001\r\n");
        return e.toString();
    }

    public static byte[] a() {
        if (!a) {
            return c();
        }
        if (!b) {
            return null;
        }
        return ap.a(f.toString(), "BuglyLog.txt");
    }

    private static byte[] c() {
        if (!b) {
            return null;
        }
        if (n) {
            al.a("[LogUtil] Get user log from native.", new Object[0]);
            String b2 = b();
            if (b2 != null) {
                al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b2.length()));
                return ap.a(b2, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb = new StringBuilder();
        synchronized (q) {
            a aVar = h;
            if (aVar != null && aVar.a && h.b != null && h.b.length() > 0) {
                sb.append(ap.a(h.b, 30720, true));
            }
            StringBuilder sb2 = f;
            if (sb2 != null && sb2.length() > 0) {
                sb.append(f.toString());
            }
        }
        return ap.a(sb.toString(), "BuglyLog.txt");
    }

    /* compiled from: BUGLY */
    public static class a {
        boolean a;
        File b;
        long c = 30720;
        private String d;
        private long e;

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.d = str;
                this.a = a();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            try {
                File file = new File(this.d);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.a = false;
                    return false;
                }
            } catch (Throwable th) {
                al.a(th);
                this.a = false;
                return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[SYNTHETIC, Splitter:B:19:0x0036] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(java.lang.String r10) {
            /*
                r9 = this;
                boolean r0 = r9.a
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002e }
                java.io.File r3 = r9.b     // Catch:{ all -> 0x002e }
                r4 = 1
                r2.<init>(r3, r4)     // Catch:{ all -> 0x002e }
                java.lang.String r0 = "UTF-8"
                byte[] r10 = r10.getBytes(r0)     // Catch:{ all -> 0x002b }
                r2.write(r10)     // Catch:{ all -> 0x002b }
                r2.flush()     // Catch:{ all -> 0x002b }
                r2.close()     // Catch:{ all -> 0x002b }
                long r5 = r9.e     // Catch:{ all -> 0x002b }
                int r10 = r10.length     // Catch:{ all -> 0x002b }
                long r7 = (long) r10     // Catch:{ all -> 0x002b }
                long r5 = r5 + r7
                r9.e = r5     // Catch:{ all -> 0x002b }
                r9.a = r4     // Catch:{ all -> 0x002b }
                r2.close()     // Catch:{ IOException -> 0x002a }
            L_0x002a:
                return r4
            L_0x002b:
                r10 = move-exception
                r0 = r2
                goto L_0x002f
            L_0x002e:
                r10 = move-exception
            L_0x002f:
                com.tencent.bugly.proguard.al.a(r10)     // Catch:{ all -> 0x003a }
                r9.a = r1     // Catch:{ all -> 0x003a }
                if (r0 == 0) goto L_0x0039
                r0.close()     // Catch:{ IOException -> 0x0039 }
            L_0x0039:
                return r1
            L_0x003a:
                r10 = move-exception
                if (r0 == 0) goto L_0x0040
                r0.close()     // Catch:{ IOException -> 0x0040 }
            L_0x0040:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ao.a.a(java.lang.String):boolean");
        }
    }
}

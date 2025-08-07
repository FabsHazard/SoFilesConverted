package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* compiled from: BUGLY */
public final class aq extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public static aq d;
    /* access modifiers changed from: private */
    public IntentFilter a = new IntentFilter();
    /* access modifiers changed from: private */
    public Context b;
    private String c;
    private boolean e = true;

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            if (d == null) {
                d = new aq();
            }
            aqVar = d;
        }
        return aqVar;
    }

    public final synchronized void a(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        al.c("add action %s", str);
    }

    public final synchronized void a(Context context) {
        this.b = context;
        ap.a((Runnable) new Runnable() {
            public final void run() {
                try {
                    al.a((Class) aq.d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        aq.this.b.registerReceiver(aq.d, aq.this.a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", (Handler) null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final synchronized void b(Context context) {
        try {
            al.a((Class) getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(android.content.Context r8, android.content.Intent r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r8 == 0) goto L_0x00af
            if (r9 == 0) goto L_0x00af
            java.lang.String r9 = r9.getAction()     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x00ac }
            if (r9 != 0) goto L_0x0014
            goto L_0x00af
        L_0x0014:
            boolean r9 = r7.e     // Catch:{ all -> 0x00ac }
            r1 = 1
            if (r9 == 0) goto L_0x001d
            r7.e = r0     // Catch:{ all -> 0x00ac }
            monitor-exit(r7)
            return r1
        L_0x001d:
            android.content.Context r9 = r7.b     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = com.tencent.bugly.proguard.ab.c(r9)     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = "is Connect BC "
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.al.c(r2, r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = "network %s changed to %s"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r3.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = r7.c     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r4}     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.al.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x00ac }
            if (r9 != 0) goto L_0x0055
            r8 = 0
            r7.c = r8     // Catch:{ all -> 0x00ac }
            monitor-exit(r7)
            return r1
        L_0x0055:
            java.lang.String r2 = r7.c     // Catch:{ all -> 0x00ac }
            r7.c = r9     // Catch:{ all -> 0x00ac }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.ac r5 = com.tencent.bugly.proguard.ac.a()     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.ai r6 = com.tencent.bugly.proguard.ai.a()     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.aa r8 = com.tencent.bugly.proguard.aa.a((android.content.Context) r8)     // Catch:{ all -> 0x00ac }
            if (r5 == 0) goto L_0x00a3
            if (r6 == 0) goto L_0x00a3
            if (r8 != 0) goto L_0x0070
            goto L_0x00a3
        L_0x0070:
            boolean r8 = r9.equals(r2)     // Catch:{ all -> 0x00ac }
            if (r8 != 0) goto L_0x00a1
            int r8 = com.tencent.bugly.proguard.at.a     // Catch:{ all -> 0x00ac }
            long r8 = r6.a((int) r8)     // Catch:{ all -> 0x00ac }
            long r3 = r3 - r8
            r8 = 30000(0x7530, double:1.4822E-319)
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a1
            java.lang.String r8 = "try to upload crash on network changed."
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.al.a((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.at r8 = com.tencent.bugly.proguard.at.a()     // Catch:{ all -> 0x00ac }
            if (r8 == 0) goto L_0x0095
            r2 = 0
            r8.a((long) r2)     // Catch:{ all -> 0x00ac }
        L_0x0095:
            java.lang.String r8 = "try to upload userinfo on network changed."
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.al.a((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.r r8 = com.tencent.bugly.proguard.s.b     // Catch:{ all -> 0x00ac }
            r8.b()     // Catch:{ all -> 0x00ac }
        L_0x00a1:
            monitor-exit(r7)
            return r1
        L_0x00a3:
            java.lang.String r8 = "not inited BC not work"
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ all -> 0x00ac }
            com.tencent.bugly.proguard.al.d(r8, r9)     // Catch:{ all -> 0x00ac }
            monitor-exit(r7)
            return r1
        L_0x00ac:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ac }
            throw r8
        L_0x00af:
            monitor-exit(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aq.a(android.content.Context, android.content.Intent):boolean");
    }
}

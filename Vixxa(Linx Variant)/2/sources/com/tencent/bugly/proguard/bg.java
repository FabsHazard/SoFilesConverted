package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: BUGLY */
public final class bg extends Thread {
    public bf a;
    public boolean b = true;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private int f = 1;
    private a g;

    /* compiled from: BUGLY */
    public interface a {
    }

    public final boolean a() {
        this.c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            al.b(e2);
        }
        al.d("MainHandlerChecker is reset to null.", new Object[0]);
        this.a = null;
        return true;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.c) {
            try {
                bf bfVar = this.a;
                boolean z = false;
                if (bfVar == null) {
                    al.c("Main handler checker is null. Stop thread monitor.", new Object[0]);
                    return;
                }
                if (bfVar.c) {
                    bfVar.c = false;
                    bfVar.d = SystemClock.uptimeMillis();
                    bfVar.a.post(bfVar);
                }
                a(bfVar);
                if (this.b) {
                    if (this.d) {
                        long b2 = bfVar.b();
                        if (b2 > 1510) {
                            if (b2 < 199990) {
                                boolean z2 = true;
                                if (b2 <= 5010) {
                                    this.f = 1;
                                    al.c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                                } else {
                                    int i = this.f;
                                    int i2 = i + 1;
                                    this.f = i2;
                                    if ((i & i2) != 0) {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        al.c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                                    }
                                }
                                z = z2;
                            }
                        }
                    }
                }
                if (z) {
                    bfVar.d();
                }
                if (this.g != null && this.d) {
                    bfVar.a();
                    bfVar.b();
                }
                ap.b(500 - ((System.currentTimeMillis() - currentTimeMillis) % 500));
            } catch (Exception e2) {
                al.b(e2);
            } catch (OutOfMemoryError e3) {
                al.b(e3);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.tencent.bugly.proguard.bf r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.d     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            boolean r0 = r2.e     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x001e
            boolean r3 = r3.a()     // Catch:{ all -> 0x0020 }
            if (r3 != 0) goto L_0x001e
            java.lang.String r3 = "Restart getting main stack trace."
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0020 }
            com.tencent.bugly.proguard.al.c(r3, r1)     // Catch:{ all -> 0x0020 }
            r3 = 1
            r2.d = r3     // Catch:{ all -> 0x0020 }
            r2.e = r0     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r2)
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bg.a(com.tencent.bugly.proguard.bf):void");
    }

    public final synchronized void c() {
        this.d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.e = true;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.a;
        if (bfVar != null) {
            bfVar.b = 5000;
        } else {
            this.a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            al.b(e2);
            return false;
        }
    }
}

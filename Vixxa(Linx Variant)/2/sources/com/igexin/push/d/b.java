package com.igexin.push.d;

import android.content.Intent;
import android.os.Bundle;
import com.igexin.push.config.l;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;
import com.igexin.push.util.a;

public class b {
    private int a;
    private int b;
    private boolean c;
    private int d;
    private long e;
    private int f;
    private long g;
    private d h;
    private i i;

    private b() {
        this.a = l.t;
        this.b = l.v;
        this.i = new f();
        this.h = a.c() ? d.WIFI : d.MOBILE;
    }

    public static b a() {
        return e.a;
    }

    private void a(int i2) {
        if (d.e != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.igexin.sdk.action.polling");
                Bundle bundle = new Bundle();
                bundle.putInt("code", i2);
                intent.putExtras(bundle);
                intent.setPackage(d.e.getPackageName());
                d.e.sendBroadcast(intent, d.az);
            } catch (Throwable unused) {
            }
        }
    }

    private void h() {
        com.igexin.a.a.c.b.a("ConnectModelCoordinator|reset current model = normal", new Object[0]);
        i iVar = this.i;
        if (iVar != null && !(iVar instanceof f)) {
            this.i = new f();
        }
        com.igexin.push.f.b.d.i().k();
        this.f = 0;
        this.d = 0;
        this.c = false;
        i.a().b(this.c);
    }

    private void i() {
        a(0);
    }

    private void j() {
        a(1);
    }

    public void a(boolean z) {
        this.c = z;
        com.igexin.a.a.c.b.a("ConnectModelCoordinator|init, current is polling model = " + z, new Object[0]);
        if (z) {
            com.igexin.push.f.b.d.i().j();
        }
    }

    public synchronized void b() {
        d dVar = a.c() ? d.WIFI : d.MOBILE;
        if (dVar != this.h) {
            com.igexin.a.a.c.b.a("ConnectModelCoordinator|net type changed " + this.h + "->" + dVar, new Object[0]);
            h();
            this.h = dVar;
        }
    }

    public i c() {
        return this.i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d() {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectModelCoordinator|read len = -1, interval = "
            monitor-enter(r5)
            boolean r1 = r5.c     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r5)
            return
        L_0x0009:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006d }
            long r3 = r5.e     // Catch:{ all -> 0x006d }
            long r1 = r1 - r3
            r3 = 20000(0x4e20, double:9.8813E-320)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x006b
            r3 = 200000(0x30d40, double:9.8813E-319)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x006b
            int r3 = r5.d     // Catch:{ all -> 0x006d }
            r4 = 1
            int r3 = r3 + r4
            r5.d = r3     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r3.<init>(r0)     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r0 = r3.append(r1)     // Catch:{ all -> 0x006d }
            java.lang.String r1 = ", disconnect ="
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x006d }
            int r1 = r5.d     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x006d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006d }
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x006d }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x006d }
            int r0 = r5.d     // Catch:{ all -> 0x006d }
            int r2 = r5.a     // Catch:{ all -> 0x006d }
            if (r0 < r2) goto L_0x006b
            java.lang.String r0 = "ConnectModelCoordinator|enter polling mode ####"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006d }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x006d }
            r5.i()     // Catch:{ all -> 0x006d }
            r5.c = r4     // Catch:{ all -> 0x006d }
            com.igexin.push.d.g r0 = new com.igexin.push.d.g     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            r5.i = r0     // Catch:{ all -> 0x006d }
            com.igexin.push.f.b.d r0 = com.igexin.push.f.b.d.i()     // Catch:{ all -> 0x006d }
            r0.j()     // Catch:{ all -> 0x006d }
            com.igexin.push.core.b.i r0 = com.igexin.push.core.b.i.a()     // Catch:{ all -> 0x006d }
            boolean r1 = r5.c     // Catch:{ all -> 0x006d }
            r0.b((boolean) r1)     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r5)
            return
        L_0x006d:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.b.d():void");
    }

    public synchronized void e() {
        if (this.c) {
            if (System.currentTimeMillis() - this.g >= 120000) {
                this.f++;
                com.igexin.a.a.c.b.a("ConnectModelCoordinator|polling mode, cur hearbeat =" + this.f, new Object[0]);
                if (this.f >= this.b) {
                    com.igexin.a.a.c.b.a("ConnectModelCoordinator|enter normal mode ####", new Object[0]);
                    j();
                    d.D = 0;
                    h();
                }
            }
            this.g = System.currentTimeMillis();
        }
    }

    public void f() {
        this.e = System.currentTimeMillis();
        if (this.c) {
            this.i = new g();
            com.igexin.push.f.b.d.i().j();
            this.f = 0;
        }
    }

    public void g() {
        i iVar;
        if (this.c && (iVar = this.i) != null && !(iVar instanceof f)) {
            this.i = new f();
        }
    }
}

package com.igexin.push.f;

import android.text.TextUtils;
import com.igexin.a.a.b.c;
import com.igexin.a.a.d.e;
import com.igexin.push.util.d;
import com.microtech.aidexx.utils.TimeUtils;
import java.util.ArrayList;

public class a extends e {
    private static a e;
    private ArrayList<String> a = new ArrayList<>();
    private ArrayList<String> b = new ArrayList<>();
    private long c = System.currentTimeMillis();
    private String d;

    private a() {
        super(-2147483637);
    }

    public static a i() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                    c.b().a(e, true, true);
                }
            }
        }
        return e;
    }

    public static void k() {
        a aVar = e;
        if (aVar != null) {
            aVar.j();
        }
    }

    private long u() {
        long currentTimeMillis = System.currentTimeMillis() - this.c;
        if ((currentTimeMillis >= TimeUtils.oneMinuteMillis && this.a.size() > 0) || this.a.size() >= 10) {
            return 0;
        }
        if (this.a.size() <= 0) {
            return Long.MAX_VALUE;
        }
        return TimeUtils.oneMinuteMillis - currentTimeMillis;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0 = new java.io.FileOutputStream(r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e6, code lost:
        if (r2 != null) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f3, code lost:
        if (r2 == null) goto L_0x00f6;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x009e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() {
        /*
            r6 = this;
            android.content.Context r0 = com.igexin.push.core.d.e
            if (r0 == 0) goto L_0x0105
            java.lang.String r0 = com.igexin.push.core.d.C
            if (r0 != 0) goto L_0x000a
            goto L_0x0105
        L_0x000a:
            monitor-enter(r6)
            java.util.ArrayList<java.lang.String> r0 = r6.b     // Catch:{ all -> 0x0102 }
            java.util.ArrayList<java.lang.String> r1 = r6.a     // Catch:{ all -> 0x0102 }
            r0.addAll(r1)     // Catch:{ all -> 0x0102 }
            java.util.ArrayList<java.lang.String> r0 = r6.a     // Catch:{ all -> 0x0102 }
            r0.clear()     // Catch:{ all -> 0x0102 }
            monitor-exit(r6)     // Catch:{ all -> 0x0102 }
            r6.w()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r6.d
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x002f
            boolean r0 = r0.mkdirs()
            if (r0 != 0) goto L_0x002f
            return
        L_0x002f:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd"
            java.util.Locale r2 = java.util.Locale.getDefault()
            r0.<init>(r1, r2)
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            java.lang.String r0 = r0.format(r1)
            java.lang.String r1 = com.igexin.push.core.d.c
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r4.<init>()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r5 = r6.d     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r5 = "/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.StringBuilder r1 = r4.append(r1)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r4 = "."
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r1 = ".log"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            if (r0 != 0) goto L_0x0084
            boolean r0 = r3.createNewFile()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            if (r0 != 0) goto L_0x0081
            return
        L_0x0081:
            com.igexin.a.a.c.a.a()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
        L_0x0084:
            byte[] r0 = com.igexin.a.a.c.a.b()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            if (r0 != 0) goto L_0x0090
            com.igexin.a.a.c.a.a()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r3.delete()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
        L_0x0090:
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch:{ all -> 0x009e }
            byte[] r1 = com.igexin.push.core.d.au     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "AES"
            r0.<init>(r1, r4)     // Catch:{ all -> 0x009e }
            javax.crypto.CipherOutputStream r0 = com.igexin.a.a.c.a.a(r3, r0)     // Catch:{ all -> 0x009e }
            goto L_0x00a4
        L_0x009e:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r1 = 1
            r0.<init>(r3, r1)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
        L_0x00a4:
            r2 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r0.<init>()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.util.ArrayList<java.lang.String> r1 = r6.b     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
        L_0x00b0:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            if (r3 == 0) goto L_0x00d3
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r4.<init>()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r4 = "\r\n"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r0.append(r3)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            goto L_0x00b0
        L_0x00d3:
            int r1 = r0.length()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            if (r1 <= 0) goto L_0x00e6
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            java.lang.String r1 = "UTF-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
            r2.write(r0)     // Catch:{ Exception -> 0x00f3, all -> 0x00ec }
        L_0x00e6:
            if (r2 == 0) goto L_0x00f6
        L_0x00e8:
            r2.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00f6
        L_0x00ec:
            r0 = move-exception
            if (r2 == 0) goto L_0x00f2
            r2.close()     // Catch:{ IOException -> 0x00f2 }
        L_0x00f2:
            throw r0
        L_0x00f3:
            if (r2 == 0) goto L_0x00f6
            goto L_0x00e8
        L_0x00f6:
            long r0 = java.lang.System.currentTimeMillis()
            r6.c = r0
            java.util.ArrayList<java.lang.String> r0 = r6.b
            r0.clear()
            return
        L_0x0102:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0102 }
            throw r0
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.v():void");
    }

    private void w() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = d.d(com.igexin.push.core.d.e);
        }
    }

    public synchronized void a(String str) {
        this.a.add(str);
        try {
            if (this.a.size() <= 1 || this.a.size() >= 10) {
                notify();
            }
        } catch (Throwable unused) {
        }
    }

    public void b() throws Exception {
        super.b();
        while (true) {
            try {
                synchronized (this) {
                    while (true) {
                        long u = u();
                        if (u == 0) {
                            break;
                        }
                        wait(u);
                    }
                    while (true) {
                    }
                }
                v();
            } catch (Throwable unused) {
                v();
                return;
            }
        }
    }

    public int b_() {
        return -2147483637;
    }

    public void d() {
        super.d();
        this.m = true;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public void e_() {
        super.e_();
        e = null;
    }

    public void j() {
        if (s() != null) {
            s().interrupt();
        }
    }
}

package com.huawei.hms.scankit.p;

import java.util.Map;
import kotlin.UByte;

/* compiled from: Decoder */
public final class u1 {
    private final p6 a = new p6(o3.l);

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r0.e();
        r0.a(true);
        r0.d();
        r0.c();
        r0.a();
        r3 = a(r0, r3);
        r3.a((java.lang.Object) new com.huawei.hms.scankit.p.l6(true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        throw com.huawei.hms.scankit.p.a.a();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.w1 a(com.huawei.hms.scankit.p.s r2, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r3) throws com.huawei.hms.scankit.p.a {
        /*
            r1 = this;
            com.huawei.hms.scankit.p.t r0 = new com.huawei.hms.scankit.p.t
            r0.<init>(r2)
            com.huawei.hms.scankit.p.w1 r2 = r1.a((com.huawei.hms.scankit.p.t) r0, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r3)     // Catch:{ a -> 0x000a }
            return r2
        L_0x000a:
            r0.e()     // Catch:{ a -> 0x0027 }
            r2 = 1
            r0.a(r2)     // Catch:{ a -> 0x0027 }
            r0.d()     // Catch:{ a -> 0x0027 }
            r0.c()     // Catch:{ a -> 0x0027 }
            r0.a()     // Catch:{ a -> 0x0027 }
            com.huawei.hms.scankit.p.w1 r3 = r1.a((com.huawei.hms.scankit.p.t) r0, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r3)     // Catch:{ a -> 0x0027 }
            com.huawei.hms.scankit.p.l6 r0 = new com.huawei.hms.scankit.p.l6     // Catch:{ a -> 0x0027 }
            r0.<init>(r2)     // Catch:{ a -> 0x0027 }
            r3.a((java.lang.Object) r0)     // Catch:{ a -> 0x0027 }
            return r3
        L_0x0027:
            com.huawei.hms.scankit.p.a r2 = com.huawei.hms.scankit.p.a.a()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.u1.a(com.huawei.hms.scankit.p.s, java.util.Map):com.huawei.hms.scankit.p.w1");
    }

    private w1 a(t tVar, Map<l1, ?> map) throws a {
        a8 d = tVar.d();
        c3 a2 = tVar.c().a();
        c1[] a3 = c1.a(tVar.b(), d, a2);
        int i = 0;
        for (c1 b : a3) {
            i += b.b();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (c1 c1Var : a3) {
            byte[] a4 = c1Var.a();
            int b2 = c1Var.b();
            a(a4, b2);
            int i3 = 0;
            while (i3 < b2) {
                bArr[i2] = a4[i3];
                i3++;
                i2++;
            }
        }
        return p1.a(bArr, d, a2, map);
    }

    private void a(byte[] bArr, int i) throws a {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & UByte.MAX_VALUE;
        }
        try {
            this.a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (a unused) {
            throw a.a();
        }
    }
}

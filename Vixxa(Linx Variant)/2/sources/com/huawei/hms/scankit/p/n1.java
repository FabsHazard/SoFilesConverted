package com.huawei.hms.scankit.p;

import android.util.Log;
import com.github.mikephil.charting.utils.Utils;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* compiled from: DecodeProcessor */
public class n1 {
    private p4 a;
    private p b;
    private p c;
    private p d;
    private boolean e = false;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    public m4 i;
    private float j = 1.778f;
    private int k = 0;
    private int l = 0;

    n1(p4 p4Var) {
        this.a = p4Var;
        this.b = new p(new q3(this.a));
        this.c = new p(new e4(this.a));
        this.i = new m4();
        this.e = false;
        this.g = 0.0f;
    }

    static s6 a(List<i2> list, n1 n1Var) {
        for (i2 next : list) {
            if (r3.b || ((double) next.h()) > 0.4d) {
                int j2 = (int) next.j();
                int k2 = (int) next.k();
                if (j2 > n1Var.a.c() / 3 && j2 < (n1Var.a.c() * 2) / 3 && k2 > n1Var.a.a() / 3 && k2 < (n1Var.a.a() * 2) / 3) {
                    float c2 = n1Var.c(n1Var.d);
                    s6 s6Var = new s6(1.0f);
                    s6Var.a(c2);
                    s6Var.a(next);
                    return s6Var;
                }
            }
        }
        return null;
    }

    public s6 b(List<BarcodeFormat> list, i2 i2Var) {
        s6 s6Var;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        if (i2Var != null) {
            try {
                s6Var = a5Var.b(this.b, this.c, this.d, hashMap, this.i, i2Var);
            } catch (a unused) {
                s6Var = null;
                Log.e("DecodeProcessor", "decode2d AIScanException");
                return s6Var;
            }
        } else {
            s6Var = a5Var.b(this.b, this.c, (p) null, hashMap, this.i, (i2) null);
        }
        try {
            if (!r3.c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
                float b2 = o8.b(this.a.c(), this.a.a(), s6Var.j());
                if (((double) Math.abs(1.0f - b2)) > 0.001d) {
                    this.h = b2;
                    this.e = true;
                }
            }
        } catch (a unused2) {
            Log.e("DecodeProcessor", "decode2d AIScanException");
            return s6Var;
        }
        return s6Var;
    }

    public s6 c(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        s6 s6Var = null;
        if (i2Var != null) {
            try {
                Log.i("DecodeProcessor", "decodeHarm start.");
                s6Var = a5Var.a(this.b, this.c, this.d, hashMap, this.i, i2Var);
            } catch (a unused) {
                Log.e("DecodeProcessor", "decodeHarm AIScanException");
            }
        }
        if (!r3.c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
            float b2 = o8.b(this.a.c(), this.a.a(), new u6[]{new u6(i2Var.d(), i2Var.e()), new u6(i2Var.d() + i2Var.f(), i2Var.e()), new u6(i2Var.d(), i2Var.e() + i2Var.c())});
            if (((double) Math.abs(1.0f - b2)) > 0.001d) {
                this.h = b2;
                this.e = true;
            }
            if (this.e) {
                Log.i("DecodeProcessor", "decodeHarm need zoom");
            }
        }
        return s6Var;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:57|58) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(1:16)|21|(3:29|(1:31)(2:32|(1:34)(1:35))|36)) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (com.huawei.hms.scankit.p.r3.q != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        r6 = r2.a(r0.i.g(r0.d, r8), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        android.util.Log.e("DecodeProcessor", "decodePdf417  AIScanException");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        r9 = (r29.i() + 180.0f) % 90.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        r4 = r4.a().c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r11 < 0) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        r9 = r9 * -2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0095, code lost:
        if (r9 > 87.0f) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        r9 = 2.0f * (90.0f - r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        r9 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        r2 = r2.a(new com.huawei.hms.scankit.p.p(new com.huawei.hms.scankit.p.e4(new com.huawei.hms.scankit.p.e6(com.huawei.hms.scankit.util.LoadOpencvJNIUtil.imageRotate(r4.b(), r4.a(), r4.c(), r4.a(), r4.c(), r9, 1.0d), r4.c(), r4.a(), 0, 0, r4.c(), r4.a(), false))), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r1 = r2.a(r0.i.b(r0.c, r7), r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0047 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0126 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.s6 d(java.util.List<com.huawei.hms.scankit.aiscan.common.BarcodeFormat> r28, com.huawei.hms.scankit.p.i2 r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            com.huawei.hms.scankit.p.a5 r2 = new com.huawei.hms.scankit.p.a5
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            com.huawei.hms.scankit.p.l1 r4 = com.huawei.hms.scankit.p.l1.POSSIBLE_FORMATS
            r5 = r28
            r3.put(r4, r5)
            r4 = 1067450368(0x3fa00000, float:1.25)
            java.lang.String r5 = "DecodeProcessor"
            r6 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x00fa
            com.huawei.hms.scankit.p.p r8 = r0.d     // Catch:{ a -> 0x0133 }
            if (r8 == 0) goto L_0x00e4
            int r8 = r8.e()     // Catch:{ a -> 0x0133 }
            com.huawei.hms.scankit.p.p r9 = r0.d     // Catch:{ a -> 0x0133 }
            int r9 = r9.c()     // Catch:{ a -> 0x0133 }
            int r8 = java.lang.Math.min(r8, r9)     // Catch:{ a -> 0x0133 }
            float r8 = (float) r8
            r9 = 1145569280(0x44480000, float:800.0)
            float r8 = r8 / r9
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0039
            r8 = r7
        L_0x0039:
            com.huawei.hms.scankit.p.m4 r4 = r0.i     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.p r9 = r0.d     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.p r4 = r4.h(r9, r8)     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.s6 r2 = r2.a(r4, r3)     // Catch:{ a -> 0x0047 }
            goto L_0x00eb
        L_0x0047:
            boolean r9 = com.huawei.hms.scankit.p.r3.q     // Catch:{ a -> 0x0058 }
            if (r9 == 0) goto L_0x005d
            com.huawei.hms.scankit.p.m4 r9 = r0.i     // Catch:{ a -> 0x0058 }
            com.huawei.hms.scankit.p.p r10 = r0.d     // Catch:{ a -> 0x0058 }
            com.huawei.hms.scankit.p.p r9 = r9.g(r10, r8)     // Catch:{ a -> 0x0058 }
            com.huawei.hms.scankit.p.s6 r6 = r2.a(r9, r3)     // Catch:{ a -> 0x0058 }
            goto L_0x005d
        L_0x0058:
            java.lang.String r9 = "decodePdf417  AIScanException"
            android.util.Log.e(r5, r9)     // Catch:{ a -> 0x00f6 }
        L_0x005d:
            float r9 = r29.i()     // Catch:{ a -> 0x00f6 }
            r10 = 1127481344(0x43340000, float:180.0)
            float r9 = r9 + r10
            r10 = 1119092736(0x42b40000, float:90.0)
            float r9 = r9 % r10
            boolean r11 = com.huawei.hms.scankit.p.r3.c     // Catch:{ a -> 0x00f6 }
            if (r11 == 0) goto L_0x00ec
            float r11 = r29.h()     // Catch:{ a -> 0x00f6 }
            double r11 = (double) r11     // Catch:{ a -> 0x00f6 }
            r13 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x00ec
            r11 = 1077936128(0x40400000, float:3.0)
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r12 = 1118699520(0x42ae0000, float:87.0)
            if (r11 < 0) goto L_0x0085
            int r13 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r13 <= 0) goto L_0x00ec
        L_0x0085:
            com.huawei.hms.scankit.p.o r4 = r4.a()     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.p4 r4 = r4.c()     // Catch:{ a -> 0x00f6 }
            if (r11 >= 0) goto L_0x0093
            r10 = -1073741824(0xffffffffc0000000, float:-2.0)
            float r9 = r9 * r10
            goto L_0x009d
        L_0x0093:
            int r11 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x009c
            float r10 = r10 - r9
            r9 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 * r10
            goto L_0x009d
        L_0x009c:
            r9 = 0
        L_0x009d:
            r15 = r9
            byte[] r10 = r4.b()     // Catch:{ a -> 0x00f6 }
            int r11 = r4.a()     // Catch:{ a -> 0x00f6 }
            int r12 = r4.c()     // Catch:{ a -> 0x00f6 }
            int r13 = r4.a()     // Catch:{ a -> 0x00f6 }
            int r14 = r4.c()     // Catch:{ a -> 0x00f6 }
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            byte[] r19 = com.huawei.hms.scankit.util.LoadOpencvJNIUtil.imageRotate(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.e6 r9 = new com.huawei.hms.scankit.p.e6     // Catch:{ a -> 0x00f6 }
            int r20 = r4.c()     // Catch:{ a -> 0x00f6 }
            int r21 = r4.a()     // Catch:{ a -> 0x00f6 }
            int r24 = r4.c()     // Catch:{ a -> 0x00f6 }
            int r25 = r4.a()     // Catch:{ a -> 0x00f6 }
            r26 = 0
            r22 = 0
            r23 = 0
            r18 = r9
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.p r4 = new com.huawei.hms.scankit.p.p     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.e4 r10 = new com.huawei.hms.scankit.p.e4     // Catch:{ a -> 0x00f6 }
            r10.<init>(r9)     // Catch:{ a -> 0x00f6 }
            r4.<init>(r10)     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.s6 r2 = r2.a(r4, r3)     // Catch:{ a -> 0x00f6 }
            goto L_0x00eb
        L_0x00e4:
            com.huawei.hms.scankit.p.p r4 = r0.b     // Catch:{ a -> 0x0133 }
            com.huawei.hms.scankit.p.s6 r2 = r2.a(r4, r3)     // Catch:{ a -> 0x0133 }
            r8 = r7
        L_0x00eb:
            r6 = r2
        L_0x00ec:
            if (r6 == 0) goto L_0x00f8
            com.huawei.hms.scankit.p.u6[] r2 = r6.j()     // Catch:{ a -> 0x00f6 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r2, (float) r8, (com.huawei.hms.scankit.p.i2) r1)     // Catch:{ a -> 0x00f6 }
            goto L_0x0138
        L_0x00f6:
            r7 = r8
            goto L_0x0133
        L_0x00f8:
            r7 = r8
            goto L_0x0138
        L_0x00fa:
            com.huawei.hms.scankit.p.p r1 = r0.b     // Catch:{ a -> 0x0133 }
            int r1 = r1.e()     // Catch:{ a -> 0x0133 }
            com.huawei.hms.scankit.p.p r8 = r0.b     // Catch:{ a -> 0x0133 }
            int r8 = r8.c()     // Catch:{ a -> 0x0133 }
            int r1 = java.lang.Math.min(r1, r8)     // Catch:{ a -> 0x0133 }
            r8 = 1080(0x438, float:1.513E-42)
            if (r1 <= r8) goto L_0x0118
            float r1 = (float) r1
            r8 = 1149698048(0x44870000, float:1080.0)
            float r1 = r1 / r8
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r7 = r1
        L_0x0118:
            com.huawei.hms.scankit.p.m4 r1 = r0.i     // Catch:{ a -> 0x0126 }
            com.huawei.hms.scankit.p.p r4 = r0.b     // Catch:{ a -> 0x0126 }
            com.huawei.hms.scankit.p.p r1 = r1.a(r4, r7)     // Catch:{ a -> 0x0126 }
            com.huawei.hms.scankit.p.s6 r1 = r2.a(r1, r3)     // Catch:{ a -> 0x0126 }
        L_0x0124:
            r6 = r1
            goto L_0x0138
        L_0x0126:
            com.huawei.hms.scankit.p.m4 r1 = r0.i     // Catch:{ a -> 0x0133 }
            com.huawei.hms.scankit.p.p r4 = r0.c     // Catch:{ a -> 0x0133 }
            com.huawei.hms.scankit.p.p r1 = r1.b(r4, r7)     // Catch:{ a -> 0x0133 }
            com.huawei.hms.scankit.p.s6 r1 = r2.a(r1, r3)     // Catch:{ a -> 0x0133 }
            goto L_0x0124
        L_0x0133:
            java.lang.String r1 = "decodePdf417 AIScanException"
            android.util.Log.e(r5, r1)
        L_0x0138:
            r1 = 0
            com.huawei.hms.scankit.p.s6 r1 = r0.a((com.huawei.hms.scankit.p.s6) r6, (float) r7, (int) r1, (int) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.d(java.util.List, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public s6 e(List<BarcodeFormat> list, i2 i2Var) {
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        if (i2Var != null) {
            r3.l = true;
            s6 a2 = a((Map<l1, Object>) hashMap, i2Var);
            r3.l = false;
            if (a2 != null && a2.k() == null && r3.p) {
                r3.m = true;
                a2 = g(list, i2Var);
                r3.m = false;
            }
            if (a2 != null && a2.k() == null && r3.q) {
                r3.n = true;
                a2 = a((Map<l1, Object>) hashMap, i2Var);
                r3.n = false;
            }
            if ((a2 != null && a2.k() != null) || !r3.r) {
                return a2;
            }
            r3.o = true;
            s6 a3 = a((Map<l1, Object>) hashMap, i2Var);
            r3.o = false;
            return a3;
        }
        s6 a4 = a((Map<l1, Object>) hashMap);
        if (a4 != null && a4.k() == null && r3.q) {
            r3.m = true;
            a4 = a((Map<l1, Object>) hashMap);
            r3.m = false;
        }
        s6 s6Var = a4;
        if (s6Var == null || s6Var.k() != null || !r3.r) {
            return s6Var;
        }
        r3.n = true;
        s6 a5 = a((Map<l1, Object>) hashMap);
        r3.n = false;
        return a5;
    }

    public s6 f(List<BarcodeFormat> list, i2 i2Var) {
        p4 p4Var;
        float f2;
        p pVar;
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        if (i2Var != null) {
            try {
                p4Var = this.d.a().c();
            } catch (a unused) {
                Log.e("DecodeProcessor", "decodeQRMulti AIScanException");
                return null;
            }
        } else {
            p4Var = this.a;
        }
        if (!r3.a || (this.b.e() <= 800 && this.b.c() <= 800)) {
            f2 = 1.0f;
        } else {
            f2 = ((float) (this.b.e() > this.b.c() ? this.b.e() : this.b.c())) / 800.0f;
            p4Var = this.i.h(new p(new q3(p4Var)), f2).a().c();
        }
        p4 p4Var2 = p4Var;
        float f3 = f2;
        if (p4Var2 != null) {
            if (!r3.a || r3.b) {
                pVar = new p(new q3(p4Var2));
            } else {
                s a2 = a(p4Var2.b(), p4Var2.c(), p4Var2.a(), false);
                pVar = new p(new q3(p4Var2));
                pVar.a(a2);
            }
            a5 a5Var = new a5();
            try {
                s6 a3 = a5Var.a(pVar, hashMap);
                if (a3 == null || a3.k() == null) {
                    throw a.a();
                }
                k2.a(a3.j(), f3, i2Var);
                return a3;
            } catch (a unused2) {
                return a(a5Var, p4Var2, pVar, (Map<l1, Object>) hashMap, f3, i2Var);
            }
        } else {
            throw a.a();
        }
    }

    public s6 g(List<BarcodeFormat> list, i2 i2Var) {
        p pVar;
        s6 s6Var;
        p pVar2;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        float f2 = 1.0f;
        if (i2Var == null) {
            if (!r3.a || (this.b.e() <= 500 && this.b.c() <= 500)) {
                pVar = this.b;
            } else {
                f2 = ((float) (this.b.e() > this.b.c() ? this.b.e() : this.b.c())) / 500.0f;
                pVar = this.i.c(this.b, f2);
            }
        } else if (!r3.a || (pVar2 = this.d) == null || (pVar2.e() <= 500 && this.d.c() <= 500)) {
            pVar = this.d;
        } else {
            f2 = ((float) (this.d.e() > this.d.c() ? this.d.e() : this.d.c())) / 500.0f;
            pVar = this.i.g(this.d, f2);
        }
        try {
            s6Var = a5Var.a(pVar, hashMap);
            if (s6Var != null) {
                try {
                    if (s6Var.k() != null) {
                        k2.a(s6Var.j(), f2, i2Var);
                        return s6Var;
                    }
                } catch (a unused) {
                    Log.e("DecodeProcessor", "decodeQRSimple AIScanException");
                    return s6Var;
                }
            }
        } catch (a unused2) {
            s6Var = null;
            Log.e("DecodeProcessor", "decodeQRSimple AIScanException");
            return s6Var;
        }
        return s6Var;
    }

    public s6 h(List<BarcodeFormat> list, i2 i2Var) {
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        s6 s6Var = null;
        if (i2Var != null) {
            try {
                s6Var = a5Var.c(this.d, this.i, hashMap, i2Var);
            } catch (a unused) {
                Log.e("DecodeProcessor", "decode2d AIScanException");
            }
        }
        if (!r3.c && s6Var != null && s6Var.k() == null && s6Var.j() != null && s6Var.j().length >= 3) {
            float b2 = o8.b(this.a.c(), this.a.a(), s6Var.j());
            if (((double) Math.abs(1.0f - b2)) > 0.001d) {
                this.h = b2;
                this.e = true;
            }
        }
        return s6Var;
    }

    public p a() {
        return this.b;
    }

    static s6 a(n1 n1Var) {
        float c2 = n1Var.c(n1Var.b);
        s6 s6Var = new s6(1.0f);
        s6Var.b(c2);
        s6Var.b(new i2(false, 0.0f, 0.0f, (float) n1Var.b.e(), (float) n1Var.b.e(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        return s6Var;
    }

    private p b(p pVar) {
        int e2 = pVar.e();
        int c2 = pVar.c();
        if (e2 < c2) {
            if (((double) (((float) c2) / ((float) e2))) <= 1.2d) {
                return pVar;
            }
            int i2 = (int) (((double) e2) * 1.2d);
            int i3 = (c2 - i2) / 2;
            this.l = i3;
            return pVar.a(0, i3, e2, i2);
        } else if (((double) (((float) e2) / ((float) c2))) <= 1.2d) {
            return pVar;
        } else {
            int i4 = (int) (((double) c2) * 1.2d);
            int i5 = (e2 - i4) / 2;
            this.k = i5;
            return pVar.a(i5, 0, i4, c2);
        }
    }

    public static boolean a(List<i2> list, boolean z) {
        if (z || r3.b) {
            r3.y = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
            r3.z = 0;
            return false;
        }
        float[] a2 = a(list.get(0));
        float a3 = a(a2);
        r3.y = a2;
        if (a3 >= 0.6f) {
            r3.z++;
        } else {
            r3.z = 1;
        }
        o4.c("DecodeProcessor", "iou: " + a3 + " focusAreaFrameCount: " + r3.z);
        if (r3.z < 8) {
            return false;
        }
        o4.c("DecodeProcessor", "need area focus");
        r3.z = 1;
        return true;
    }

    public float c(p pVar) {
        byte[] b2 = (pVar == null || (pVar.a() == null && pVar.a().c() == null)) ? null : pVar.a().c().b();
        if (b2 == null) {
            return 1.0f;
        }
        int e2 = pVar.e();
        int c2 = pVar.c();
        long j2 = 0;
        for (int i2 = c2 / 4; i2 < (c2 * 3) / 4; i2++) {
            for (int i3 = e2 / 4; i3 < (e2 * 3) / 4; i3++) {
                j2 += (long) (b2[(i2 * e2) + i3] & UByte.MAX_VALUE);
            }
        }
        return (float) ((j2 / ((long) b2.length)) * 4);
    }

    public float e() {
        return this.g;
    }

    public void b(i2 i2Var) {
        try {
            if (r3.a) {
                k2.a(r3.b, this.b, i2Var);
                this.d = i2Var.l;
            }
        } catch (a unused) {
            Log.e("DecodeProcessor", "cropAndRotate AIScanException");
        }
    }

    public boolean b() {
        return this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x009c A[SYNTHETIC, Splitter:B:41:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.s6 a(java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r14, com.huawei.hms.scankit.p.i2 r15) {
        /*
            r13 = this;
            com.huawei.hms.scankit.p.a5 r4 = new com.huawei.hms.scankit.p.a5
            r4.<init>()
            com.huawei.hms.scankit.p.p r0 = r13.d
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            r8 = 1
            com.huawei.hms.scankit.p.r3.h = r8
            int r0 = r0.e()
            com.huawei.hms.scankit.p.p r2 = r13.d
            int r2 = r2.c()
            if (r0 <= r2) goto L_0x0021
            com.huawei.hms.scankit.p.p r0 = r13.d
            int r0 = r0.e()
            goto L_0x0027
        L_0x0021:
            com.huawei.hms.scankit.p.p r0 = r13.d
            int r0 = r0.c()
        L_0x0027:
            boolean r2 = com.huawei.hms.scankit.p.r3.a
            r9 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0044
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 <= r2) goto L_0x0044
            float r0 = (float) r0
            r2 = 1140457472(0x43fa0000, float:500.0)
            float r0 = r0 / r2
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x003a
            r0 = r9
        L_0x003a:
            com.huawei.hms.scankit.p.m4 r2 = r13.i
            com.huawei.hms.scankit.p.p r3 = r13.d
            com.huawei.hms.scankit.p.p r2 = r2.g(r3, r0)
            r10 = r0
            goto L_0x0047
        L_0x0044:
            com.huawei.hms.scankit.p.p r2 = r13.d
            r10 = r9
        L_0x0047:
            r11 = 3
            boolean r0 = com.huawei.hms.scankit.p.r3.o     // Catch:{ a -> 0x00af }
            if (r0 == 0) goto L_0x0063
            com.huawei.hms.scankit.p.o r0 = r2.a()     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.p4 r0 = r0.c()     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.p4 r0 = com.huawei.hms.scankit.p.j7.b(r0)     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.p r3 = new com.huawei.hms.scankit.p.p     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.q3 r5 = new com.huawei.hms.scankit.p.q3     // Catch:{ a -> 0x00af }
            r5.<init>(r0)     // Catch:{ a -> 0x00af }
            r3.<init>(r5)     // Catch:{ a -> 0x00af }
            r2 = r3
        L_0x0063:
            com.huawei.hms.scankit.p.s6 r0 = r4.a(r2, r14)     // Catch:{ a -> 0x00af }
            if (r0 == 0) goto L_0x0098
            java.lang.String r3 = r0.k()     // Catch:{ a -> 0x0095 }
            if (r3 != 0) goto L_0x0098
            com.huawei.hms.scankit.p.u6[] r3 = r0.j()     // Catch:{ a -> 0x0095 }
            if (r3 == 0) goto L_0x0098
            com.huawei.hms.scankit.p.u6[] r3 = r0.j()     // Catch:{ a -> 0x0095 }
            int r3 = r3.length     // Catch:{ a -> 0x0095 }
            if (r3 < r11) goto L_0x0098
            com.huawei.hms.scankit.p.s6 r3 = new com.huawei.hms.scankit.p.s6     // Catch:{ a -> 0x0095 }
            com.huawei.hms.scankit.p.u6[] r5 = r0.j()     // Catch:{ a -> 0x0095 }
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r6 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE     // Catch:{ a -> 0x0095 }
            r3.<init>(r1, r1, r5, r6)     // Catch:{ a -> 0x0095 }
            r1 = 6
            double[] r1 = new double[r1]     // Catch:{ a -> 0x0092 }
            r1 = {0, 0, 0, 0, 0, 4607182418800017408} // fill-array     // Catch:{ a -> 0x0092 }
            com.huawei.hms.scankit.p.s6 r0 = r13.a((com.huawei.hms.scankit.p.p) r2, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r14, (com.huawei.hms.scankit.p.s6) r0, (double[]) r1)     // Catch:{ a -> 0x0092 }
            goto L_0x0099
        L_0x0092:
            r1 = r2
            r2 = r0
            goto L_0x00b3
        L_0x0095:
            r3 = r1
            r1 = r0
            goto L_0x00b0
        L_0x0098:
            r3 = r1
        L_0x0099:
            r1 = r0
            if (r1 == 0) goto L_0x00aa
            java.lang.String r0 = r1.k()     // Catch:{ a -> 0x00b0 }
            if (r0 == 0) goto L_0x00aa
            com.huawei.hms.scankit.p.u6[] r0 = r1.j()     // Catch:{ a -> 0x00b0 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r0, (float) r10, (com.huawei.hms.scankit.p.i2) r15)     // Catch:{ a -> 0x00b0 }
            return r1
        L_0x00aa:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x00b0 }
            throw r0     // Catch:{ a -> 0x00b0 }
        L_0x00af:
            r3 = r1
        L_0x00b0:
            r12 = r2
            r2 = r1
            r1 = r12
        L_0x00b3:
            r0 = r13
            r5 = r14
            r6 = r10
            r7 = r15
            com.huawei.hms.scankit.p.s6 r14 = r0.a((com.huawei.hms.scankit.p.p) r1, (com.huawei.hms.scankit.p.s6) r2, (com.huawei.hms.scankit.p.s6) r3, (com.huawei.hms.scankit.p.a5) r4, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r5, (float) r6, (com.huawei.hms.scankit.p.i2) r7)
            if (r14 == 0) goto L_0x00c4
            java.lang.String r0 = r14.k()
            if (r0 == 0) goto L_0x00c4
            return r14
        L_0x00c4:
            boolean r0 = com.huawei.hms.scankit.p.r3.c
            if (r0 != 0) goto L_0x0105
            if (r14 == 0) goto L_0x0105
            com.huawei.hms.scankit.p.u6[] r0 = r14.j()
            if (r0 == 0) goto L_0x0105
            com.huawei.hms.scankit.p.u6[] r0 = r14.j()
            int r0 = r0.length
            if (r0 < r11) goto L_0x0105
            com.huawei.hms.scankit.p.u6[] r0 = r14.j()
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r0, (float) r10, (com.huawei.hms.scankit.p.i2) r15)
            com.huawei.hms.scankit.p.p4 r15 = r13.a
            int r15 = r15.c()
            com.huawei.hms.scankit.p.p4 r0 = r13.a
            int r0 = r0.a()
            com.huawei.hms.scankit.p.u6[] r1 = r14.j()
            float r15 = com.huawei.hms.scankit.p.o8.a(r15, r0, r1)
            float r9 = r9 - r15
            float r0 = java.lang.Math.abs(r9)
            double r0 = (double) r0
            r2 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0105
            r13.f = r15
            r13.e = r8
        L_0x0105:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(java.util.Map, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public boolean b(List<i2> list) {
        int i2;
        for (i2 next : list) {
            boolean z = next.g() == 1.0f && ((double) next.h()) > 0.7d;
            boolean z2 = next.g() == 1.0f && ((double) next.h()) > 0.4d;
            boolean z3 = next.g() == 2.0f && ((double) next.h()) > 0.7d;
            boolean z4 = next.g() == 3.0f && ((double) next.h()) > 0.7d;
            boolean z5 = next.g() == 6.0f && ((double) next.h()) > 0.7d;
            boolean z6 = next.g() == 7.0f && ((double) next.h()) > 0.7d;
            if (z2 || z3 || z4 || z5 || z6) {
                if (z || a(this.b, next) || (i2 = r3.k) > 4) {
                    r3.k = 0;
                    float b2 = o8.b(this.a.c(), this.a.a(), new u6[]{new u6(next.d(), next.e()), new u6(next.d() + next.f(), next.e()), new u6(next.d(), next.e() + next.c())});
                    if (b2 > 1.001f) {
                        this.g = b2;
                        this.e = true;
                    }
                } else {
                    r3.k = i2 + 2;
                }
            }
        }
        return this.e;
    }

    public float c() {
        return this.f;
    }

    public boolean c(List<i2> list) {
        int i2;
        for (i2 next : list) {
            boolean z = next.g() == 1.0f && ((double) next.h()) > 0.7d;
            boolean z2 = next.g() == 1.0f && ((double) next.h()) > 0.4d;
            boolean z3 = next.g() == 2.0f && ((double) next.h()) > 0.7d;
            boolean z4 = next.g() == 3.0f && ((double) next.h()) > 0.7d;
            boolean z5 = next.g() == 4.0f && ((double) next.h()) > 0.7d;
            boolean z6 = next.g() == 5.0f && ((double) next.h()) > 0.7d;
            boolean z7 = next.g() == 6.0f && ((double) next.h()) > 0.7d;
            boolean z8 = next.g() == 7.0f && ((double) next.h()) > 0.7d;
            if (z2 || z3 || z4 || z7 || z8 || z5 || z6) {
                if (z || a(this.b, next) || (i2 = r3.k) > 4) {
                    r3.k = 0;
                    float b2 = o8.b(this.a.c(), this.a.a(), new u6[]{new u6(next.d(), next.e()), new u6(next.d() + next.f(), next.e()), new u6(next.d(), next.e() + next.c())});
                    if (b2 > 1.001f) {
                        this.g = b2;
                        return true;
                    }
                } else {
                    r3.k = i2 + 2;
                }
            }
        }
        return this.e;
    }

    public float d() {
        return this.h;
    }

    static boolean b(p pVar, i2 i2Var) {
        if (r3.a && !r3.b) {
            float d2 = i2Var.d();
            float e2 = i2Var.e();
            float f2 = i2Var.f();
            float c2 = i2Var.c();
            float f3 = d2 - ((f2 * 0.2f) / 2.0f);
            float f4 = 0.0f;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            float f5 = e2 - ((0.2f * c2) / 2.0f);
            if (f5 >= 0.0f) {
                f4 = f5;
            }
            float f6 = (f2 * 1.2f) + f3;
            if (f6 > ((float) pVar.e())) {
                f6 = (float) pVar.e();
            }
            float f7 = (c2 * 1.2f) + f4;
            if (f7 > ((float) pVar.c())) {
                f7 = (float) pVar.c();
            }
            float f8 = f6 - f3;
            float f9 = f7 - f4;
            if (f8 < ((float) pVar.e()) / 2.0f && f9 < ((float) pVar.c()) / 2.0f) {
                List<i2> a2 = k2.a(r3.b, pVar.a((int) f3, (int) f4, (int) f8, (int) f9), 0, true);
                if (a2.isEmpty() || a2.get(0).g() != 6.0f) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public static float a(float[] fArr) {
        float[] fArr2 = r3.y;
        float f2 = fArr2[3];
        float f3 = fArr2[1];
        float f4 = (fArr2[2] - fArr2[0]) * (f2 - f3);
        if (((double) f4) == Utils.DOUBLE_EPSILON) {
            return 0.0f;
        }
        float f5 = fArr[2] - fArr[0];
        float f6 = fArr[3];
        float f7 = fArr[1];
        float f8 = f4 + (f5 * (f6 - f7));
        float max = Math.max(f3, f7);
        float min = Math.min(r3.y[3], fArr[3]);
        float max2 = Math.max(r3.y[0], fArr[0]);
        float min2 = Math.min(r3.y[2], fArr[2]);
        if (max >= min || max2 >= min2) {
            return 0.0f;
        }
        float f9 = (min - max) * (min2 - max2);
        return (f9 / (f8 - f9)) * 1.0f;
    }

    public static float[] a(i2 i2Var) {
        int i2 = i2Var.s;
        int i3 = i2Var.r;
        return new float[]{(float) i2, (float) i3, (float) (i2 + i2Var.q), (float) (i3 + i2Var.p)};
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2 A[Catch:{ a -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00aa A[Catch:{ a -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f1 A[Catch:{ a -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9 A[Catch:{ a -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015d A[Catch:{ a -> 0x01b1, a -> 0x01ec }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r22, com.huawei.hms.scankit.p.s6 r23, com.huawei.hms.scankit.p.s6 r24, com.huawei.hms.scankit.p.a5 r25, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r26, float r27, com.huawei.hms.scankit.p.i2 r28) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = 0
            boolean r7 = com.huawei.hms.scankit.p.r3.a     // Catch:{ a -> 0x0070 }
            if (r7 == 0) goto L_0x0067
            byte[] r7 = r22.d()     // Catch:{ a -> 0x0070 }
            int r8 = r22.e()     // Catch:{ a -> 0x0070 }
            int r9 = r22.c()     // Catch:{ a -> 0x0070 }
            com.huawei.hms.scankit.p.s r7 = a((byte[]) r7, (int) r8, (int) r9, (boolean) r6)     // Catch:{ a -> 0x0070 }
            r1.a(r7)     // Catch:{ a -> 0x0070 }
            com.huawei.hms.scankit.p.s6 r7 = r2.a(r1, r3)     // Catch:{ a -> 0x0070 }
            if (r7 == 0) goto L_0x0055
            java.lang.String r8 = r7.k()     // Catch:{ a -> 0x0072 }
            if (r8 != 0) goto L_0x0055
            com.huawei.hms.scankit.p.u6[] r8 = r7.j()     // Catch:{ a -> 0x0072 }
            if (r8 == 0) goto L_0x0055
            com.huawei.hms.scankit.p.u6[] r8 = r7.j()     // Catch:{ a -> 0x0072 }
            int r8 = r8.length     // Catch:{ a -> 0x0072 }
            r9 = 3
            if (r8 < r9) goto L_0x0055
            com.huawei.hms.scankit.p.s6 r8 = new com.huawei.hms.scankit.p.s6     // Catch:{ a -> 0x0072 }
            com.huawei.hms.scankit.p.u6[] r9 = r7.j()     // Catch:{ a -> 0x0072 }
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r10 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE     // Catch:{ a -> 0x0072 }
            r11 = 0
            r8.<init>(r11, r11, r9, r10)     // Catch:{ a -> 0x0072 }
            r9 = 6
            double[] r9 = new double[r9]     // Catch:{ a -> 0x0074 }
            r9 = {0, 0, 0, 0, 0, 4607182418800017408} // fill-array     // Catch:{ a -> 0x0074 }
            com.huawei.hms.scankit.p.s6 r7 = r0.a((com.huawei.hms.scankit.p.p) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r3, (com.huawei.hms.scankit.p.s6) r7, (double[]) r9)     // Catch:{ a -> 0x0074 }
            goto L_0x0057
        L_0x0055:
            r8 = r24
        L_0x0057:
            if (r7 == 0) goto L_0x006b
            java.lang.String r9 = r7.k()     // Catch:{ a -> 0x0074 }
            if (r9 == 0) goto L_0x006b
            com.huawei.hms.scankit.p.u6[] r9 = r7.j()     // Catch:{ a -> 0x0074 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r9, (float) r4, (com.huawei.hms.scankit.p.i2) r5)     // Catch:{ a -> 0x0074 }
            return r7
        L_0x0067:
            r7 = r23
            r8 = r24
        L_0x006b:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0074 }
            throw r9     // Catch:{ a -> 0x0074 }
        L_0x0070:
            r7 = r23
        L_0x0072:
            r8 = r24
        L_0x0074:
            java.lang.String r9 = "DecodeProcessor"
            if (r7 == 0) goto L_0x007e
            java.lang.String r10 = r7.k()
            if (r10 != 0) goto L_0x00b4
        L_0x007e:
            boolean r10 = com.huawei.hms.scankit.p.r3.c
            if (r10 == 0) goto L_0x00b4
            boolean r10 = com.huawei.hms.scankit.p.r3.b
            if (r10 != 0) goto L_0x00b4
            byte[] r10 = r22.d()     // Catch:{ a -> 0x00af }
            int r11 = r22.e()     // Catch:{ a -> 0x00af }
            int r12 = r22.c()     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.p r10 = a(r10, r11, r12)     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.s6 r10 = r2.a(r10, r3)     // Catch:{ a -> 0x00af }
            if (r10 == 0) goto L_0x00aa
            java.lang.String r11 = r10.k()     // Catch:{ a -> 0x00af }
            if (r11 == 0) goto L_0x00aa
            com.huawei.hms.scankit.p.u6[] r11 = r10.j()     // Catch:{ a -> 0x00af }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r11, (float) r4, (com.huawei.hms.scankit.p.i2) r5)     // Catch:{ a -> 0x00af }
            return r10
        L_0x00aa:
            com.huawei.hms.scankit.p.a r10 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x00af }
            throw r10     // Catch:{ a -> 0x00af }
        L_0x00af:
            java.lang.String r10 = "decodeQRUseDetResHard sharpenMethod AIScanException"
            android.util.Log.e(r9, r10)
        L_0x00b4:
            if (r7 == 0) goto L_0x00bc
            java.lang.String r10 = r7.k()
            if (r10 != 0) goto L_0x0103
        L_0x00bc:
            boolean r10 = com.huawei.hms.scankit.p.r3.x
            if (r10 != 0) goto L_0x00c8
            boolean r10 = com.huawei.hms.scankit.p.r3.c
            if (r10 != 0) goto L_0x0103
            boolean r10 = com.huawei.hms.scankit.p.r3.q
            if (r10 == 0) goto L_0x0103
        L_0x00c8:
            com.huawei.hms.scankit.p.e4 r10 = new com.huawei.hms.scankit.p.e4     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.o r1 = r22.a()     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.p4 r1 = r1.c()     // Catch:{ a -> 0x00fe }
            r10.<init>(r1)     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.p r1 = new com.huawei.hms.scankit.p.p     // Catch:{ a -> 0x00fe }
            r1.<init>(r10)     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.s r10 = r1.b()     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.s r10 = r10.d()     // Catch:{ a -> 0x00fe }
            r1.a(r10)     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.s6 r1 = r2.a(r1, r3)     // Catch:{ a -> 0x00fe }
            if (r1 == 0) goto L_0x00f9
            java.lang.String r10 = r1.k()     // Catch:{ a -> 0x00fe }
            if (r10 == 0) goto L_0x00f9
            com.huawei.hms.scankit.p.u6[] r10 = r1.j()     // Catch:{ a -> 0x00fe }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r10, (float) r4, (com.huawei.hms.scankit.p.i2) r5)     // Catch:{ a -> 0x00fe }
            return r1
        L_0x00f9:
            com.huawei.hms.scankit.p.a r1 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x00fe }
            throw r1     // Catch:{ a -> 0x00fe }
        L_0x00fe:
            java.lang.String r1 = "decodeQRUseDetResHard InvMethod AIScanException"
            android.util.Log.e(r9, r1)
        L_0x0103:
            if (r7 == 0) goto L_0x010b
            java.lang.String r1 = r7.k()
            if (r1 != 0) goto L_0x01f1
        L_0x010b:
            boolean r1 = com.huawei.hms.scankit.p.r3.l
            if (r1 == 0) goto L_0x01f1
            boolean r1 = com.huawei.hms.scankit.p.r3.b
            if (r1 != 0) goto L_0x01f1
            float r1 = r28.d()     // Catch:{ a -> 0x01ec }
            r4 = 0
            float r1 = java.lang.Math.max(r1, r4)     // Catch:{ a -> 0x01ec }
            int r1 = (int) r1     // Catch:{ a -> 0x01ec }
            float r7 = r28.e()     // Catch:{ a -> 0x01ec }
            float r4 = java.lang.Math.max(r7, r4)     // Catch:{ a -> 0x01ec }
            int r4 = (int) r4     // Catch:{ a -> 0x01ec }
            float r7 = r28.f()     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.p4 r10 = r0.a     // Catch:{ a -> 0x01ec }
            int r10 = r10.c()     // Catch:{ a -> 0x01ec }
            int r10 = r10 - r1
            float r10 = (float) r10     // Catch:{ a -> 0x01ec }
            float r7 = java.lang.Math.min(r7, r10)     // Catch:{ a -> 0x01ec }
            int r7 = (int) r7     // Catch:{ a -> 0x01ec }
            float r5 = r28.c()     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.p4 r10 = r0.a     // Catch:{ a -> 0x01ec }
            int r10 = r10.a()     // Catch:{ a -> 0x01ec }
            int r10 = r10 - r4
            float r10 = (float) r10     // Catch:{ a -> 0x01ec }
            float r5 = java.lang.Math.min(r5, r10)     // Catch:{ a -> 0x01ec }
            int r5 = (int) r5     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.p4 r10 = r0.a     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.p4 r10 = r10.a(r1, r4, r7, r5)     // Catch:{ a -> 0x01ec }
            byte[] r10 = r10.b()     // Catch:{ a -> 0x01ec }
            r11 = 8
            float[] r11 = new float[r11]     // Catch:{ a -> 0x01ec }
            byte[] r5 = com.huawei.hms.scankit.util.LoadOpencvJNIUtil.QRCornerDetect(r10, r7, r5, r11)     // Catch:{ a -> 0x01ec }
            int r7 = r5.length     // Catch:{ a -> 0x01ec }
            if (r7 == 0) goto L_0x01f1
            com.huawei.hms.scankit.p.e6 r7 = new com.huawei.hms.scankit.p.e6     // Catch:{ a -> 0x01ec }
            r19 = 256(0x100, float:3.59E-43)
            r20 = 0
            r14 = 256(0x100, float:3.59E-43)
            r15 = 256(0x100, float:3.59E-43)
            r16 = 0
            r17 = 0
            r18 = 256(0x100, float:3.59E-43)
            r12 = r7
            r13 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.k5 r10 = new com.huawei.hms.scankit.p.k5     // Catch:{ a -> 0x01ec }
            r10.<init>(r7)     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.p r7 = new com.huawei.hms.scankit.p.p     // Catch:{ a -> 0x01ec }
            r7.<init>(r10)     // Catch:{ a -> 0x01ec }
            r10 = 4
            com.huawei.hms.scankit.p.s6 r12 = r2.a(r7, r3)     // Catch:{ a -> 0x01b1 }
            if (r12 == 0) goto L_0x01ac
            java.lang.String r13 = r12.k()     // Catch:{ a -> 0x01b1 }
            if (r13 == 0) goto L_0x01ac
            com.huawei.hms.scankit.p.u6[] r13 = new com.huawei.hms.scankit.p.u6[r10]     // Catch:{ a -> 0x01b1 }
            r14 = r6
        L_0x018c:
            if (r14 >= r10) goto L_0x01a8
            com.huawei.hms.scankit.p.u6 r15 = new com.huawei.hms.scankit.p.u6     // Catch:{ a -> 0x01b1 }
            int r16 = r14 * 2
            r17 = r11[r16]     // Catch:{ a -> 0x01b1 }
            float r10 = (float) r1     // Catch:{ a -> 0x01b1 }
            float r10 = r17 + r10
            int r16 = r16 + 1
            r16 = r11[r16]     // Catch:{ a -> 0x01b1 }
            float r6 = (float) r4     // Catch:{ a -> 0x01b1 }
            float r6 = r16 + r6
            r15.<init>(r10, r6)     // Catch:{ a -> 0x01b1 }
            r13[r14] = r15     // Catch:{ a -> 0x01b1 }
            int r14 = r14 + 1
            r6 = 0
            r10 = 4
            goto L_0x018c
        L_0x01a8:
            r12.b((com.huawei.hms.scankit.p.u6[]) r13)     // Catch:{ a -> 0x01b1 }
            return r12
        L_0x01ac:
            com.huawei.hms.scankit.p.a r6 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x01b1 }
            throw r6     // Catch:{ a -> 0x01b1 }
        L_0x01b1:
            r6 = 256(0x100, float:3.59E-43)
            r10 = 0
            com.huawei.hms.scankit.p.s r5 = a((byte[]) r5, (int) r6, (int) r6, (boolean) r10)     // Catch:{ a -> 0x01ec }
            r7.a(r5)     // Catch:{ a -> 0x01ec }
            com.huawei.hms.scankit.p.s6 r2 = r2.a(r7, r3)     // Catch:{ a -> 0x01ec }
            if (r2 == 0) goto L_0x01e7
            java.lang.String r3 = r2.k()     // Catch:{ a -> 0x01ec }
            if (r3 == 0) goto L_0x01e7
            r3 = 4
            com.huawei.hms.scankit.p.u6[] r5 = new com.huawei.hms.scankit.p.u6[r3]     // Catch:{ a -> 0x01ec }
            r6 = r10
        L_0x01cb:
            if (r6 >= r3) goto L_0x01e3
            com.huawei.hms.scankit.p.u6 r7 = new com.huawei.hms.scankit.p.u6     // Catch:{ a -> 0x01ec }
            int r10 = r6 * 2
            r12 = r11[r10]     // Catch:{ a -> 0x01ec }
            float r13 = (float) r1     // Catch:{ a -> 0x01ec }
            float r12 = r12 + r13
            int r10 = r10 + 1
            r10 = r11[r10]     // Catch:{ a -> 0x01ec }
            float r13 = (float) r4     // Catch:{ a -> 0x01ec }
            float r10 = r10 + r13
            r7.<init>(r12, r10)     // Catch:{ a -> 0x01ec }
            r5[r6] = r7     // Catch:{ a -> 0x01ec }
            int r6 = r6 + 1
            goto L_0x01cb
        L_0x01e3:
            r2.b((com.huawei.hms.scankit.p.u6[]) r5)     // Catch:{ a -> 0x01ec }
            return r2
        L_0x01e7:
            com.huawei.hms.scankit.p.a r1 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x01ec }
            throw r1     // Catch:{ a -> 0x01ec }
        L_0x01ec:
            java.lang.String r1 = "decodeQRUseDetResHard CornerMethod AIScanException"
            android.util.Log.e(r9, r1)
        L_0x01f1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.s6, com.huawei.hms.scankit.p.a5, java.util.Map, float, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.s6 a(java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r14) {
        /*
            r13 = this;
            com.huawei.hms.scankit.p.a5 r1 = new com.huawei.hms.scankit.p.a5
            r1.<init>()
            com.huawei.hms.scankit.p.p4 r0 = r13.a
            boolean r2 = com.huawei.hms.scankit.p.r3.a
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0087
            com.huawei.hms.scankit.p.p r2 = r13.b
            int r2 = r2.e()
            r3 = 800(0x320, float:1.121E-42)
            if (r2 > r3) goto L_0x001f
            com.huawei.hms.scankit.p.p r2 = r13.b
            int r2 = r2.c()
            if (r2 <= r3) goto L_0x0087
        L_0x001f:
            com.huawei.hms.scankit.p.p r0 = r13.b
            int r0 = r0.e()
            com.huawei.hms.scankit.p.p r2 = r13.b
            int r2 = r2.c()
            int r0 = java.lang.Math.max(r0, r2)
            float r0 = (float) r0
            r2 = 1145569280(0x44480000, float:800.0)
            float r0 = r0 / r2
            boolean r2 = com.huawei.hms.scankit.p.r3.c
            if (r2 == 0) goto L_0x0075
            com.huawei.hms.scankit.p.p r2 = r13.b
            int r2 = r2.e()
            float r2 = (float) r2
            com.huawei.hms.scankit.p.p r3 = r13.b
            int r3 = r3.c()
            float r3 = (float) r3
            float r4 = r13.j
            float r3 = r3 * r4
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0061
            com.huawei.hms.scankit.p.p r2 = r13.b
            int r2 = r2.c()
            float r2 = (float) r2
            com.huawei.hms.scankit.p.p r3 = r13.b
            int r3 = r3.e()
            float r3 = (float) r3
            float r4 = r13.j
            float r3 = r3 * r4
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0075
        L_0x0061:
            com.huawei.hms.scankit.p.p r0 = r13.b
            int r0 = r0.e()
            com.huawei.hms.scankit.p.p r2 = r13.b
            int r2 = r2.c()
            int r0 = java.lang.Math.min(r0, r2)
            float r0 = (float) r0
            r2 = 1146552320(0x44570000, float:860.0)
            float r0 = r0 / r2
        L_0x0075:
            com.huawei.hms.scankit.p.m4 r2 = r13.i
            com.huawei.hms.scankit.p.p r3 = r13.b
            com.huawei.hms.scankit.p.p r2 = r2.d(r3, r0)
            com.huawei.hms.scankit.p.o r2 = r2.a()
            com.huawei.hms.scankit.p.p4 r2 = r2.c()
            r9 = r0
            goto L_0x0089
        L_0x0087:
            r2 = r0
            r9 = r8
        L_0x0089:
            r0 = 0
            if (r2 != 0) goto L_0x008d
            return r0
        L_0x008d:
            com.huawei.hms.scankit.p.p r3 = new com.huawei.hms.scankit.p.p
            com.huawei.hms.scankit.p.q3 r4 = new com.huawei.hms.scankit.p.q3
            r4.<init>(r2)
            r3.<init>(r4)
            com.huawei.hms.scankit.p.p4 r4 = r13.a
            com.huawei.hms.scankit.p.j6.a((com.huawei.hms.scankit.p.p4) r4)
            r10 = 3
            r11 = 0
            boolean r4 = com.huawei.hms.scankit.p.r3.a     // Catch:{ a -> 0x00e2 }
            if (r4 == 0) goto L_0x00b5
            byte[] r4 = r2.b()     // Catch:{ a -> 0x00e2 }
            int r5 = r2.c()     // Catch:{ a -> 0x00e2 }
            int r6 = r2.a()     // Catch:{ a -> 0x00e2 }
            com.huawei.hms.scankit.p.s r4 = a((byte[]) r4, (int) r5, (int) r6, (boolean) r11)     // Catch:{ a -> 0x00e2 }
            r3.a(r4)     // Catch:{ a -> 0x00e2 }
        L_0x00b5:
            com.huawei.hms.scankit.p.s6 r3 = r1.a(r3, r14)     // Catch:{ a -> 0x00e2 }
            if (r3 == 0) goto L_0x00c6
            java.lang.String r4 = r3.k()     // Catch:{ a -> 0x00e2 }
            if (r4 == 0) goto L_0x00c6
            com.huawei.hms.scankit.p.s6 r14 = r13.a((com.huawei.hms.scankit.p.s6) r3, (float) r9, (int) r11, (int) r11)     // Catch:{ a -> 0x00e2 }
            return r14
        L_0x00c6:
            if (r3 == 0) goto L_0x00e9
            com.huawei.hms.scankit.p.u6[] r4 = r3.j()     // Catch:{ a -> 0x00e2 }
            if (r4 == 0) goto L_0x00e9
            com.huawei.hms.scankit.p.u6[] r4 = r3.j()     // Catch:{ a -> 0x00e2 }
            int r4 = r4.length     // Catch:{ a -> 0x00e2 }
            if (r4 < r10) goto L_0x00e9
            com.huawei.hms.scankit.p.s6 r4 = new com.huawei.hms.scankit.p.s6     // Catch:{ a -> 0x00e2 }
            com.huawei.hms.scankit.p.u6[] r3 = r3.j()     // Catch:{ a -> 0x00e2 }
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r5 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE     // Catch:{ a -> 0x00e2 }
            r4.<init>(r0, r0, r3, r5)     // Catch:{ a -> 0x00e2 }
            r12 = r4
            goto L_0x00ea
        L_0x00e2:
            java.lang.String r3 = "DecodeProcessor"
            java.lang.String r4 = "decodeQRUseFullImg AIScanException"
            android.util.Log.e(r3, r4)
        L_0x00e9:
            r12 = r0
        L_0x00ea:
            if (r12 != 0) goto L_0x00f4
            com.huawei.hms.scankit.p.s6 r3 = new com.huawei.hms.scankit.p.s6
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r4 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE
            r3.<init>(r0, r0, r0, r4)
            goto L_0x00f5
        L_0x00f4:
            r3 = r12
        L_0x00f5:
            boolean r0 = com.huawei.hms.scankit.p.r3.c
            if (r0 == 0) goto L_0x0102
            r6 = 0
            r7 = 0
            r0 = r13
            r4 = r14
            r5 = r9
            com.huawei.hms.scankit.p.s6 r3 = r0.a((com.huawei.hms.scankit.p.a5) r1, (com.huawei.hms.scankit.p.p4) r2, (com.huawei.hms.scankit.p.s6) r3, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r4, (float) r5, (int) r6, (int) r7)
        L_0x0102:
            if (r3 == 0) goto L_0x010b
            java.lang.String r14 = r3.k()
            if (r14 == 0) goto L_0x010b
            return r3
        L_0x010b:
            if (r3 == 0) goto L_0x0114
            com.huawei.hms.scankit.p.u6[] r14 = r3.j()
            if (r14 == 0) goto L_0x0114
            r12 = r3
        L_0x0114:
            boolean r14 = com.huawei.hms.scankit.p.r3.c
            if (r14 != 0) goto L_0x0152
            if (r12 == 0) goto L_0x0152
            com.huawei.hms.scankit.p.u6[] r14 = r12.j()
            if (r14 == 0) goto L_0x0152
            com.huawei.hms.scankit.p.u6[] r14 = r12.j()
            int r14 = r14.length
            if (r14 < r10) goto L_0x0152
            r13.a((com.huawei.hms.scankit.p.s6) r12, (float) r9, (int) r11, (int) r11)
            com.huawei.hms.scankit.p.p4 r14 = r13.a
            int r14 = r14.c()
            com.huawei.hms.scankit.p.p4 r0 = r13.a
            int r0 = r0.a()
            com.huawei.hms.scankit.p.u6[] r1 = r12.j()
            float r14 = com.huawei.hms.scankit.p.o8.a(r14, r0, r1)
            float r8 = r8 - r14
            float r0 = java.lang.Math.abs(r8)
            double r0 = (double) r0
            r2 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0152
            r13.f = r14
            r14 = 1
            r13.e = r14
        L_0x0152:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(java.util.Map):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A[SYNTHETIC, Splitter:B:31:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.a5 r15, com.huawei.hms.scankit.p.p4 r16, com.huawei.hms.scankit.p.s6 r17, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r18, float r19, int r20, int r21) {
        /*
            r14 = this;
            r7 = r14
            r4 = r17
            r5 = r18
            r6 = r19
            r0 = r20
            r1 = r21
            java.lang.String r2 = "decodeQRUseFullImgTryHard AIScanException"
            java.lang.String r3 = "DecodeProcessor"
            boolean r8 = com.huawei.hms.scankit.p.r3.a
            r9 = 0
            if (r8 == 0) goto L_0x0091
            r8 = 3
            com.huawei.hms.scankit.p.q3 r10 = new com.huawei.hms.scankit.p.q3     // Catch:{ a -> 0x004f }
            r11 = r16
            r10.<init>(r11)     // Catch:{ a -> 0x004d }
            com.huawei.hms.scankit.p.p r12 = new com.huawei.hms.scankit.p.p     // Catch:{ a -> 0x004d }
            r12.<init>(r10)     // Catch:{ a -> 0x004d }
            r10 = r15
            com.huawei.hms.scankit.p.s6 r9 = r15.a(r12, r5)     // Catch:{ a -> 0x004b }
            if (r9 == 0) goto L_0x0033
            java.lang.String r13 = r9.k()     // Catch:{ a -> 0x004b }
            if (r13 == 0) goto L_0x0033
            com.huawei.hms.scankit.p.s6 r0 = r14.a((com.huawei.hms.scankit.p.s6) r9, (float) r6, (int) r0, (int) r1)     // Catch:{ a -> 0x004b }
            return r0
        L_0x0033:
            if (r9 == 0) goto L_0x0049
            com.huawei.hms.scankit.p.u6[] r13 = r9.j()     // Catch:{ a -> 0x004b }
            if (r13 == 0) goto L_0x0049
            com.huawei.hms.scankit.p.u6[] r13 = r9.j()     // Catch:{ a -> 0x004b }
            int r13 = r13.length     // Catch:{ a -> 0x004b }
            if (r13 < r8) goto L_0x0049
            com.huawei.hms.scankit.p.u6[] r9 = r9.j()     // Catch:{ a -> 0x004b }
            r4.b((com.huawei.hms.scankit.p.u6[]) r9)     // Catch:{ a -> 0x004b }
        L_0x0049:
            r9 = r12
            goto L_0x0055
        L_0x004b:
            r9 = r12
            goto L_0x0052
        L_0x004d:
            r10 = r15
            goto L_0x0052
        L_0x004f:
            r10 = r15
            r11 = r16
        L_0x0052:
            android.util.Log.e(r3, r2)
        L_0x0055:
            if (r4 == 0) goto L_0x0082
            com.huawei.hms.scankit.p.u6[] r12 = r17.j()     // Catch:{ a -> 0x007f }
            if (r12 == 0) goto L_0x0082
            com.huawei.hms.scankit.p.u6[] r12 = r17.j()     // Catch:{ a -> 0x007f }
            int r12 = r12.length     // Catch:{ a -> 0x007f }
            if (r12 < r8) goto L_0x0082
            boolean r8 = com.huawei.hms.scankit.p.r3.m     // Catch:{ a -> 0x007f }
            if (r8 != 0) goto L_0x0082
            r8 = 6
            double[] r8 = new double[r8]     // Catch:{ a -> 0x007f }
            r8 = {0, 0, 0, 0, 0, 4607182418800017408} // fill-array     // Catch:{ a -> 0x007f }
            com.huawei.hms.scankit.p.s6 r8 = r14.a((com.huawei.hms.scankit.p.p) r9, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r5, (com.huawei.hms.scankit.p.s6) r4, (double[]) r8)     // Catch:{ a -> 0x007f }
            if (r8 == 0) goto L_0x0082
            java.lang.String r12 = r8.k()     // Catch:{ a -> 0x007f }
            if (r12 == 0) goto L_0x0082
            com.huawei.hms.scankit.p.s6 r0 = r14.a((com.huawei.hms.scankit.p.s6) r8, (float) r6, (int) r0, (int) r1)     // Catch:{ a -> 0x007f }
            return r0
        L_0x007f:
            android.util.Log.e(r3, r2)
        L_0x0082:
            r0 = r14
            r1 = r9
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            com.huawei.hms.scankit.p.s6 r9 = r0.a((com.huawei.hms.scankit.p.p) r1, (com.huawei.hms.scankit.p.a5) r2, (com.huawei.hms.scankit.p.p4) r3, (com.huawei.hms.scankit.p.s6) r4, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r5, (float) r6)
        L_0x0091:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.a5, com.huawei.hms.scankit.p.p4, com.huawei.hms.scankit.p.s6, java.util.Map, float, int, int):com.huawei.hms.scankit.p.s6");
    }

    private s6 a(p pVar, a5 a5Var, p4 p4Var, s6 s6Var, Map<l1, Object> map, float f2) {
        s6 s6Var2 = null;
        try {
            j6.a(this.a, s6Var);
            if (r3.c && r3.v[1]) {
                r3.s = true;
                s6Var2 = a5Var.a(this.b, map);
                r3.s = false;
                if (!(s6Var2 == null || s6Var2.k() == null)) {
                    return a(s6Var2, f2, 0, 0);
                }
            }
        } catch (a unused) {
            r3.s = false;
        }
        float e2 = ((float) pVar.e()) / ((float) pVar.c());
        if (e2 < 1.0f) {
            e2 = 1.0f / e2;
        }
        if (!r3.m && !r3.n) {
            double d2 = (double) e2;
            if (d2 > 1.27d && d2 < 1.272d) {
                r3.u = true;
                try {
                    s6Var2 = a5Var.a(new p(new e4(p4Var)), map);
                    if (!(s6Var2 == null || s6Var2.k() == null)) {
                        return a(s6Var2, f2, 0, 0);
                    }
                } catch (a unused2) {
                    Log.e("DecodeProcessor", "decodeQRUseFullImgTryHardSpecialCase AIScanException");
                }
                r3.u = false;
            }
        }
        return s6Var2;
    }

    private s6 a(a5 a5Var, p4 p4Var, p pVar, Map<l1, Object> map, float f2, i2 i2Var) throws a {
        p pVar2;
        s6 s6Var = null;
        if (r3.a && !r3.b) {
            try {
                pVar2 = new p(new q3(p4Var));
                try {
                    s6 a2 = a5Var.a(pVar2, map);
                    if (a2 != null) {
                        try {
                            if (a2.k() != null) {
                                k2.a(a2.j(), f2, i2Var);
                                return a2;
                            }
                        } catch (a unused) {
                            s6Var = a2;
                            pVar = pVar2;
                            Log.e("DecodeProcessor", "decodeQRMultiHard AIScanException");
                            pVar2 = pVar;
                            try {
                                s6Var = a(pVar2, map, s6Var, new double[]{Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d});
                                k2.a(s6Var.j(), f2, i2Var);
                                return s6Var;
                            } catch (a unused2) {
                                Log.e("DecodeProcessor", "decodeQRMultiHard AIScanException");
                            }
                        }
                    }
                    s6Var = a2;
                } catch (a unused3) {
                    pVar = pVar2;
                    Log.e("DecodeProcessor", "decodeQRMultiHard AIScanException");
                    pVar2 = pVar;
                    s6Var = a(pVar2, map, s6Var, new double[]{Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d});
                    k2.a(s6Var.j(), f2, i2Var);
                    return s6Var;
                }
            } catch (a unused4) {
                Log.e("DecodeProcessor", "decodeQRMultiHard AIScanException");
                pVar2 = pVar;
                s6Var = a(pVar2, map, s6Var, new double[]{Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d});
                k2.a(s6Var.j(), f2, i2Var);
                return s6Var;
            }
            if (!(s6Var == null || s6Var.j() == null || s6Var.j().length < 3)) {
                s6Var = a(pVar2, map, s6Var, new double[]{Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d});
                if (!(s6Var == null || s6Var.k() == null)) {
                    k2.a(s6Var.j(), f2, i2Var);
                    return s6Var;
                }
            }
        }
        p pVar3 = new p(new e4(p4Var));
        try {
            s6 a3 = a5Var.a(pVar3, map);
            if (a3 == null || a3.k() == null) {
                throw a.a();
            }
            k2.a(a3.j(), f2, i2Var);
            return a3;
        } catch (a unused5) {
            if (!(!r3.a || r3.b || s6Var == null || s6Var.j() == null || s6Var.j().length < 3 || (s6Var = a(pVar3, map, s6Var, new double[]{Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d})) == null || s6Var.k() == null)) {
                k2.a(s6Var.j(), f2, i2Var);
            }
            return s6Var;
        }
    }

    public s6 a(List<BarcodeFormat> list, i2 i2Var) {
        s6 s6Var;
        a5 a5Var = new a5();
        HashMap hashMap = new HashMap();
        hashMap.put(l1.POSSIBLE_FORMATS, list);
        if (r3.c) {
            hashMap.put(l1.PHOTO_MODE, Boolean.valueOf(r3.c));
        }
        if (i2Var != null) {
            try {
                s6Var = a5Var.a(this.b, this.d, (Map<l1, Object>) hashMap, this.i, i2Var);
            } catch (a unused) {
                Log.e("DecodeProcessor", "decode1d AIScanException");
                s6Var = null;
            }
        } else {
            s6Var = a5Var.a(this.b, (p) null, (Map<l1, Object>) hashMap, this.i, (i2) null);
        }
        s6 s6Var2 = s6Var;
        if (s6Var2 != null || r3.b || i2Var == null || !r3.c || ((double) i2Var.h()) >= 0.8d) {
            return s6Var2;
        }
        float i2 = i2Var.i() % 180.0f;
        boolean z = true;
        boolean z2 = ((double) i2Var.c()) > ((double) this.b.c()) * 0.97d && ((i2 < 5.0f && i2 > -5.0f) || i2 < -175.0f || i2 > 175.0f);
        if (((double) i2Var.b()) <= ((double) this.b.e()) * 0.97d || ((i2 >= 95.0f || i2 <= 85.0f) && (i2 >= -85.0f || i2 <= -95.0f))) {
            z = false;
        }
        if (!z2 && !z) {
            return s6Var2;
        }
        this.i.a();
        try {
            return a5Var.a(this.b, (p) null, (Map<l1, Object>) hashMap, this.i, (i2) null);
        } catch (a unused2) {
            Log.e("DecodeProcessor", "decode1d AIScanException");
            return s6Var2;
        }
    }

    public List<i2> a(int i2, boolean z) {
        List<i2> list;
        ArrayList arrayList = new ArrayList();
        if (!r3.a) {
            return arrayList;
        }
        boolean z2 = r3.b;
        if (!z2) {
            byte[] c2 = y4.c();
            byte[] a2 = y4.a();
            byte[] b2 = y4.b();
            LoadOpencvJNIUtil.setModel(c2, c2.length, a2, a2.length, b2, b2.length);
            p pVar = this.b;
            long currentTimeMillis = System.currentTimeMillis() % 10;
            boolean z3 = true;
            boolean z4 = currentTimeMillis % 2 == 0;
            if (currentTimeMillis % 3 != 0) {
                z3 = false;
            }
            if (i2 == 0 && !r3.c && z4) {
                pVar = b(this.b);
            } else if (i2 == 0 && !r3.c && z3) {
                pVar = a(b(this.b));
            }
            list = k2.a(r3.b, pVar, i2, z);
        } else {
            list = k2.a(z2, this.b, i2, z);
        }
        List<i2> list2 = list;
        a(list2);
        return list2;
    }

    private p a(p pVar) {
        int e2 = pVar.e();
        int c2 = pVar.c();
        int i2 = (int) (((double) e2) * 0.75d);
        int i3 = (int) (((double) c2) * 0.75d);
        int i4 = (e2 - i2) / 2;
        this.k += i4;
        int i5 = (c2 - i3) / 2;
        this.l += i5;
        return pVar.a(i4, i5, i2, i3);
    }

    private void a(List<i2> list) {
        for (i2 next : list) {
            next.a(this.a.c(), this.a.a(), (float) this.k, (float) this.l);
            float min = Math.min(Math.abs(next.i() % 90.0f), 90.0f - Math.abs(next.i() % 90.0f));
            if (next.c() * next.f() > ((float) this.a.a()) * 0.9f * ((float) this.a.c()) && min < 5.0f) {
                next.b((float) this.a.c(), (float) this.a.a());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[Catch:{ a -> 0x0091, a -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c A[Catch:{ a -> 0x0091, a -> 0x00cd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r17, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r18, com.huawei.hms.scankit.p.s6 r19, double[] r20) throws com.huawei.hms.scankit.p.a {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            if (r0 != 0) goto L_0x000a
            r0 = 0
            return r0
        L_0x000a:
            com.huawei.hms.scankit.p.a5 r3 = new com.huawei.hms.scankit.p.a5
            r3.<init>()
            r4 = 0
            int[] r5 = new int[]{r4, r4}
            r6 = r19
            byte[] r8 = com.huawei.hms.scankit.p.k7.a((com.huawei.hms.scankit.p.p) r0, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r1, (com.huawei.hms.scankit.p.s6) r6, (int[]) r5, (double[]) r2)
            com.huawei.hms.scankit.p.e6 r15 = new com.huawei.hms.scankit.p.e6
            r13 = r5[r4]
            r7 = 1
            r14 = r5[r7]
            r12 = 0
            r5 = 0
            r11 = 0
            r7 = r15
            r9 = r13
            r10 = r14
            r4 = r15
            r15 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            com.huawei.hms.scankit.p.p r5 = new com.huawei.hms.scankit.p.p
            com.huawei.hms.scankit.p.q3 r7 = new com.huawei.hms.scankit.p.q3
            r7.<init>(r4)
            r5.<init>(r7)
            com.huawei.hms.scankit.p.s6 r5 = r3.a(r5, r1)     // Catch:{ a -> 0x005e }
            if (r5 == 0) goto L_0x0059
            java.lang.String r6 = r5.k()     // Catch:{ a -> 0x005f }
            if (r6 == 0) goto L_0x0059
            com.huawei.hms.scankit.p.u6[] r6 = r5.j()     // Catch:{ a -> 0x005f }
            int r7 = r17.e()     // Catch:{ a -> 0x005f }
            int r8 = r17.c()     // Catch:{ a -> 0x005f }
            com.huawei.hms.scankit.p.u6[] r6 = com.huawei.hms.scankit.p.k7.a((com.huawei.hms.scankit.p.u6[]) r6, (int) r7, (int) r8, (double[]) r2)     // Catch:{ a -> 0x005f }
            r5.a()     // Catch:{ a -> 0x005f }
            r5.b((com.huawei.hms.scankit.p.u6[]) r6)     // Catch:{ a -> 0x005f }
            return r5
        L_0x0059:
            com.huawei.hms.scankit.p.a r6 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x005f }
            throw r6     // Catch:{ a -> 0x005f }
        L_0x005e:
            r5 = r6
        L_0x005f:
            com.huawei.hms.scankit.p.p r6 = new com.huawei.hms.scankit.p.p
            com.huawei.hms.scankit.p.e4 r7 = new com.huawei.hms.scankit.p.e4
            r7.<init>(r4)
            r6.<init>(r7)
            com.huawei.hms.scankit.p.s6 r5 = r3.a(r6, r1)     // Catch:{ a -> 0x0091 }
            if (r5 == 0) goto L_0x008c
            java.lang.String r7 = r5.k()     // Catch:{ a -> 0x0091 }
            if (r7 == 0) goto L_0x008c
            com.huawei.hms.scankit.p.u6[] r7 = r5.j()     // Catch:{ a -> 0x0091 }
            int r8 = r17.e()     // Catch:{ a -> 0x0091 }
            int r9 = r17.c()     // Catch:{ a -> 0x0091 }
            com.huawei.hms.scankit.p.u6[] r7 = com.huawei.hms.scankit.p.k7.a((com.huawei.hms.scankit.p.u6[]) r7, (int) r8, (int) r9, (double[]) r2)     // Catch:{ a -> 0x0091 }
            r5.a()     // Catch:{ a -> 0x0091 }
            r5.b((com.huawei.hms.scankit.p.u6[]) r7)     // Catch:{ a -> 0x0091 }
            return r5
        L_0x008c:
            com.huawei.hms.scankit.p.a r7 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0091 }
            throw r7     // Catch:{ a -> 0x0091 }
        L_0x0091:
            byte[] r7 = r4.b()
            int r8 = r4.c()
            int r4 = r4.a()
            r9 = 0
            com.huawei.hms.scankit.p.s r4 = a((byte[]) r7, (int) r8, (int) r4, (boolean) r9)
            r6.a(r4)
            com.huawei.hms.scankit.p.s6 r5 = r3.a(r6, r1)     // Catch:{ a -> 0x00cd }
            if (r5 == 0) goto L_0x00c8
            java.lang.String r1 = r5.k()     // Catch:{ a -> 0x00cd }
            if (r1 == 0) goto L_0x00c8
            com.huawei.hms.scankit.p.u6[] r1 = r5.j()     // Catch:{ a -> 0x00cd }
            int r3 = r17.e()     // Catch:{ a -> 0x00cd }
            int r0 = r17.c()     // Catch:{ a -> 0x00cd }
            com.huawei.hms.scankit.p.u6[] r0 = com.huawei.hms.scankit.p.k7.a((com.huawei.hms.scankit.p.u6[]) r1, (int) r3, (int) r0, (double[]) r2)     // Catch:{ a -> 0x00cd }
            r5.a()     // Catch:{ a -> 0x00cd }
            r5.b((com.huawei.hms.scankit.p.u6[]) r0)     // Catch:{ a -> 0x00cd }
            return r5
        L_0x00c8:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x00cd }
            throw r0     // Catch:{ a -> 0x00cd }
        L_0x00cd:
            java.lang.String r0 = "DecodeProcessor"
            java.lang.String r1 = "rotatedQRBinarizer  AIScanException"
            android.util.Log.e(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.n1.a(com.huawei.hms.scankit.p.p, java.util.Map, com.huawei.hms.scankit.p.s6, double[]):com.huawei.hms.scankit.p.s6");
    }

    private s6 a(s6 s6Var, float f2, int i2, int i3) {
        if (!(s6Var == null || s6Var.j().length != 4 || (Math.abs(f2 - 1.0f) < 1.0E-6f && i2 == 0 && i3 == 0))) {
            u6[] u6VarArr = new u6[4];
            for (int i4 = 0; i4 < 4; i4++) {
                u6VarArr[i4] = new u6((s6Var.j()[i4].b() * f2) + ((float) i2), (s6Var.j()[i4].c() * f2) + ((float) i3));
            }
            s6Var.a();
            s6Var.a(u6VarArr);
        }
        return s6Var;
    }

    public static s a(byte[] bArr, int i2, int i3, boolean z) throws a {
        int i4 = i2 / 11;
        byte[] adaptivebinary = LoadOpencvJNIUtil.adaptivebinary(bArr, i3, i2, (i4 + (i4 % 2)) - 1, z);
        if (adaptivebinary != null) {
            s sVar = new s(i2, i3);
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    if (adaptivebinary[(i5 * i2) + i6] == 0) {
                        sVar.c(i6, i5);
                    }
                }
            }
            return sVar;
        }
        throw a.a();
    }

    public static p a(byte[] bArr, int i2, int i3) throws a {
        byte[] sharpen = LoadOpencvJNIUtil.sharpen(bArr, i3, i2);
        if (sharpen != null) {
            return new p(new e4(new e6(sharpen, i2, i3, 0, 0, i2, i3, false)));
        }
        throw a.a();
    }

    private static boolean a(p pVar, i2 i2Var) {
        if (r3.a && !r3.b) {
            float d2 = i2Var.d();
            float e2 = i2Var.e();
            float f2 = i2Var.f();
            float c2 = i2Var.c();
            float f3 = d2 - ((f2 * 0.2f) / 2.0f);
            float f4 = 0.0f;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            float f5 = e2 - ((0.2f * c2) / 2.0f);
            if (f5 >= 0.0f) {
                f4 = f5;
            }
            float f6 = (f2 * 1.2f) + f3;
            if (f6 > ((float) pVar.e())) {
                f6 = (float) pVar.e();
            }
            float f7 = (c2 * 1.2f) + f4;
            if (f7 > ((float) pVar.c())) {
                f7 = (float) pVar.c();
            }
            float f8 = f6 - f3;
            float f9 = f7 - f4;
            if (f8 < ((float) pVar.e()) / 2.0f && f9 < ((float) pVar.c()) / 2.0f) {
                for (i2 next : k2.a(r3.b, pVar.a((int) f3, (int) f4, (int) f8, (int) f9), 0, true)) {
                    boolean z = next.g() == 1.0f && ((double) next.h()) > 0.5d;
                    boolean z2 = i2Var.g() == 2.0f && next.g() == 2.0f && ((double) next.h()) > 0.7d;
                    boolean z3 = i2Var.g() == 3.0f && next.g() == 3.0f && ((double) next.h()) > 0.7d;
                    boolean z4 = i2Var.g() == 7.0f && next.g() == 7.0f && ((double) next.h()) > 0.7d;
                    boolean z5 = i2Var.g() == 6.0f && next.g() == 6.0f && ((double) next.h()) > 0.7d;
                    if (z || z2 || z3 || z4) {
                        return true;
                    }
                    if (z5) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}

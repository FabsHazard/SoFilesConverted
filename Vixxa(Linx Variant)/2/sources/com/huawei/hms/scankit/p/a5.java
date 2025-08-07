package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader */
public final class a5 implements o6 {
    public static boolean a(s6 s6Var, float f, float f2) {
        double abs = (double) (Math.abs(s6Var.j()[0].b() - s6Var.j()[1].b()) / f);
        return (abs < 0.55d && ((double) f2) > 1.5d) || abs < 0.3d;
    }

    public s6 b(p pVar, p pVar2, p pVar3, Map<l1, ?> map, m4 m4Var, i2 i2Var) throws a {
        if (pVar3 != null) {
            return b(pVar3, m4Var, map, i2Var);
        }
        return a(pVar, pVar2, m4Var, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r6.a(com.huawei.hms.scankit.p.n1.a(r6.d(), r6.e(), r6.c(), true));
        r7 = a(r6, a(r8), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r7 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        com.huawei.hms.scankit.p.k2.a(r7.j(), r0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        throw com.huawei.hms.scankit.p.a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r7 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        throw com.huawei.hms.scankit.p.a.a();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.s6 c(com.huawei.hms.scankit.p.p r6, com.huawei.hms.scankit.p.m4 r7, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r8, com.huawei.hms.scankit.p.i2 r9) throws com.huawei.hms.scankit.p.a {
        /*
            r5 = this;
            int r0 = r6.e()
            int r1 = r6.c()
            if (r0 >= r1) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            r0 = r1
        L_0x000c:
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r1 = 1140457472(0x43fa0000, float:500.0)
            float r0 = r0 / r1
            com.huawei.hms.scankit.p.p r6 = r7.g(r6, r0)
            com.huawei.hms.scankit.p.o6[] r7 = r5.a(r8)     // Catch:{ a -> 0x0034 }
            com.huawei.hms.scankit.p.s6 r7 = r5.a((com.huawei.hms.scankit.p.p) r6, (com.huawei.hms.scankit.p.o6[]) r7, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r8)     // Catch:{ a -> 0x0034 }
            if (r7 == 0) goto L_0x002f
            java.lang.String r1 = r7.k()     // Catch:{ a -> 0x0035 }
            if (r1 == 0) goto L_0x002f
            com.huawei.hms.scankit.p.u6[] r1 = r7.j()     // Catch:{ a -> 0x0035 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r1, (float) r0, (com.huawei.hms.scankit.p.i2) r9)     // Catch:{ a -> 0x0035 }
            return r7
        L_0x002f:
            com.huawei.hms.scankit.p.a r1 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0035 }
            throw r1     // Catch:{ a -> 0x0035 }
        L_0x0034:
            r7 = 0
        L_0x0035:
            byte[] r1 = r6.d()     // Catch:{ a -> 0x0066 }
            int r2 = r6.e()     // Catch:{ a -> 0x0066 }
            int r3 = r6.c()     // Catch:{ a -> 0x0066 }
            r4 = 1
            com.huawei.hms.scankit.p.s r1 = com.huawei.hms.scankit.p.n1.a((byte[]) r1, (int) r2, (int) r3, (boolean) r4)     // Catch:{ a -> 0x0066 }
            r6.a(r1)     // Catch:{ a -> 0x0066 }
            com.huawei.hms.scankit.p.o6[] r1 = r5.a(r8)     // Catch:{ a -> 0x0066 }
            com.huawei.hms.scankit.p.s6 r7 = r5.a((com.huawei.hms.scankit.p.p) r6, (com.huawei.hms.scankit.p.o6[]) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r8)     // Catch:{ a -> 0x0066 }
            if (r7 == 0) goto L_0x0061
            java.lang.String r6 = r7.k()     // Catch:{ a -> 0x0066 }
            if (r6 == 0) goto L_0x0061
            com.huawei.hms.scankit.p.u6[] r6 = r7.j()     // Catch:{ a -> 0x0066 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r6, (float) r0, (com.huawei.hms.scankit.p.i2) r9)     // Catch:{ a -> 0x0066 }
            return r7
        L_0x0061:
            com.huawei.hms.scankit.p.a r6 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0066 }
            throw r6     // Catch:{ a -> 0x0066 }
        L_0x0066:
            if (r7 == 0) goto L_0x0069
            return r7
        L_0x0069:
            com.huawei.hms.scankit.p.a r6 = com.huawei.hms.scankit.p.a.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.c(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return a(pVar, a(map), map);
    }

    public o6[] a(Map<l1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(l1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new z4(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new j6());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new h1());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new h());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new r5());
            }
            if (collection.contains(BarcodeFormat.HARMONY_CODE)) {
                arrayList.add(new z3());
            }
            if (collection.contains(BarcodeFormat.WXCODE)) {
                arrayList.add(new m8());
            }
        }
        return (o6[]) arrayList.toArray(new o6[arrayList.size()]);
    }

    public s6 b(p pVar, m4 m4Var, Map<l1, ?> map, i2 i2Var) throws a {
        int e = pVar.e();
        int c = pVar.c();
        int i = e < c ? e : c;
        float f = 1.0f;
        float f2 = ((float) i) * 1.0f;
        float f3 = f2 / 128.0f;
        if (f3 < 1.0f && r3.c) {
            pVar = m4Var.e(pVar, f3);
        }
        p pVar2 = pVar;
        float f4 = f2 / 500.0f;
        if (f4 >= 1.0f) {
            f = f4;
        }
        try {
            s6 a = a(m4Var.g(pVar2, f), a(map), map);
            if (a == null || a.k() == null) {
                if (!r3.c && a != null && a.k() == null && a.j().length >= 3) {
                    u6[] u6VarArr = (u6[]) a.j().clone();
                }
                throw a.a();
            }
            k2.a(a.j(), f, i2Var);
            return a;
        } catch (a unused) {
            s6 a2 = a(i, pVar2, m4Var, map, i2Var);
            if (a2 != null) {
                if (0 != 0) {
                    a2.a();
                    a2.b((u6[]) null);
                    k2.a(a2.j(), f, i2Var);
                }
                return a2;
            }
            throw a.a();
        }
    }

    private s6 a(p pVar, o6[] o6VarArr, Map<l1, ?> map) throws a {
        if (o6VarArr != null) {
            int i = 0;
            while (i < o6VarArr.length) {
                try {
                    s6 a = o6VarArr[i].a(pVar, map);
                    if (!(a == null || a.j() == null)) {
                        int i2 = 0;
                        for (u6 u6Var : a.j()) {
                            if (u6Var != null) {
                                i2++;
                            }
                        }
                        if (i2 == 0) {
                            if (a.c() == BarcodeFormat.PDF_417) {
                                throw a.a();
                            }
                        }
                    }
                    return a;
                } catch (a unused) {
                    i++;
                }
            }
        }
        throw a.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r10, com.huawei.hms.scankit.p.p r11, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r12, com.huawei.hms.scankit.p.m4 r13, com.huawei.hms.scankit.p.i2 r14) throws com.huawei.hms.scankit.p.a {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.l1 r0 = com.huawei.hms.scankit.p.l1.PHOTO_MODE
            boolean r0 = r12.containsKey(r0)
            r1 = 2
            float[] r6 = new float[r1]
            r6 = {1065353216, 0} // fill-array
            r1 = 1
            r8 = 0
            if (r11 == 0) goto L_0x001b
            r2 = r9
            r3 = r11
            r4 = r13
            r5 = r12
            r7 = r14
            com.huawei.hms.scankit.p.s6 r11 = r2.a((com.huawei.hms.scankit.p.p) r3, (com.huawei.hms.scankit.p.m4) r4, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r5, (float[]) r6, (com.huawei.hms.scankit.p.i2) r7)
        L_0x0019:
            r12 = r8
            goto L_0x0031
        L_0x001b:
            if (r0 != 0) goto L_0x0024
            boolean r11 = com.huawei.hms.scankit.p.r3.a
            if (r11 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r11 = 0
            goto L_0x0019
        L_0x0024:
            com.huawei.hms.scankit.p.s6 r11 = r9.a((com.huawei.hms.scankit.p.p) r10, (com.huawei.hms.scankit.p.m4) r13, (java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object>) r12, (float[]) r6)
            r12 = r6[r1]
            r13 = 1065353216(0x3f800000, float:1.0)
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L_0x0019
            r12 = r1
        L_0x0031:
            if (r11 == 0) goto L_0x0060
            if (r12 == 0) goto L_0x005f
            com.huawei.hms.scankit.p.u6[] r12 = r11.j()
            if (r12 == 0) goto L_0x005f
        L_0x003b:
            int r13 = r12.length
            if (r8 >= r13) goto L_0x005f
            r13 = r12[r8]
            if (r13 == 0) goto L_0x005c
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6
            r14 = r12[r8]
            float r14 = r14.c()
            int r0 = r10.c()
            int r0 = r0 - r1
            float r0 = (float) r0
            r2 = r12[r8]
            float r2 = r2.b()
            float r0 = r0 - r2
            r13.<init>(r14, r0)
            r12[r8] = r13
        L_0x005c:
            int r8 = r8 + 1
            goto L_0x003b
        L_0x005f:
            return r11
        L_0x0060:
            com.huawei.hms.scankit.p.a r10 = com.huawei.hms.scankit.p.a.a()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.p, java.util.Map, com.huawei.hms.scankit.p.m4, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r11, com.huawei.hms.scankit.p.m4 r12, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r13, float[] r14, com.huawei.hms.scankit.p.i2 r15) throws com.huawei.hms.scankit.p.a {
        /*
            r10 = this;
            float r0 = r15.n()
            int r1 = r11.e()
            int r2 = r11.c()
            if (r1 >= r2) goto L_0x0013
            int r1 = r11.e()
            goto L_0x0017
        L_0x0013:
            int r1 = r11.c()
        L_0x0017:
            float r1 = (float) r1
            r2 = 1140457472(0x43fa0000, float:500.0)
            float r2 = r1 / r2
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x0023
            r2 = r3
        L_0x0023:
            com.huawei.hms.scankit.p.p r4 = r12.g(r11, r2)
            com.huawei.hms.scankit.p.o6[] r5 = r10.a(r13)
            float r6 = r15.a()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x003e
            float r6 = r15.b()
            float r7 = r15.a()
            float r6 = r6 / r7
            goto L_0x003f
        L_0x003e:
            r6 = r3
        L_0x003f:
            r7 = 0
            com.huawei.hms.scankit.p.s6 r8 = r10.a((com.huawei.hms.scankit.p.p) r4, (com.huawei.hms.scankit.p.o6[]) r5, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r13)     // Catch:{ a -> 0x0053 }
            float r9 = r0 / r2
            boolean r9 = a((com.huawei.hms.scankit.p.s6) r8, (float) r9, (float) r6)     // Catch:{ a -> 0x0052 }
            if (r9 != 0) goto L_0x004d
            goto L_0x00a5
        L_0x004d:
            com.huawei.hms.scankit.p.a r8 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0053 }
            throw r8     // Catch:{ a -> 0x0053 }
        L_0x0052:
            r7 = r8
        L_0x0053:
            boolean r8 = com.huawei.hms.scankit.p.r3.p
            if (r8 == 0) goto L_0x00a4
            r2 = 1132068864(0x437a0000, float:250.0)
            float r1 = r1 / r2
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r3 = r1
        L_0x0060:
            com.huawei.hms.scankit.p.p r4 = r12.f(r11, r3)
            com.huawei.hms.scankit.p.l1 r11 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM     // Catch:{ a -> 0x0084 }
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ a -> 0x0084 }
            r13.put(r11, r1)     // Catch:{ a -> 0x0084 }
            com.huawei.hms.scankit.p.p r11 = r12.e(r4)     // Catch:{ a -> 0x0084 }
            com.huawei.hms.scankit.p.s6 r8 = r10.a((com.huawei.hms.scankit.p.p) r11, (com.huawei.hms.scankit.p.o6[]) r5, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r13)     // Catch:{ a -> 0x0084 }
            float r11 = r0 / r3
            boolean r11 = a((com.huawei.hms.scankit.p.s6) r8, (float) r11, (float) r6)     // Catch:{ a -> 0x0084 }
            if (r11 != 0) goto L_0x007f
            goto L_0x009d
        L_0x007f:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0084 }
            throw r11     // Catch:{ a -> 0x0084 }
        L_0x0084:
            com.huawei.hms.scankit.p.l1 r11 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13.put(r11, r1)
            com.huawei.hms.scankit.p.p r11 = r12.f(r4)
            com.huawei.hms.scankit.p.s6 r8 = r10.a((com.huawei.hms.scankit.p.p) r11, (com.huawei.hms.scankit.p.o6[]) r5, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r13)
            float r0 = r0 / r3
            boolean r11 = a((com.huawei.hms.scankit.p.s6) r8, (float) r0, (float) r6)
            if (r11 != 0) goto L_0x009f
        L_0x009d:
            r2 = r3
            goto L_0x00a5
        L_0x009f:
            com.huawei.hms.scankit.p.a r11 = com.huawei.hms.scankit.p.a.a()
            throw r11
        L_0x00a4:
            r8 = r7
        L_0x00a5:
            r11 = 0
            r14[r11] = r2
            if (r8 == 0) goto L_0x00b1
            com.huawei.hms.scankit.p.s r11 = r4.b()
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.s) r11, (com.huawei.hms.scankit.p.s6) r8, (float) r2, (com.huawei.hms.scankit.p.i2) r15)
        L_0x00b1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, float[], com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|(2:35|25)(1:36)) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (com.huawei.hms.scankit.p.r3.p != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r11.put(com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM, 1);
        r10 = a(r10.d(r9), r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r10 = r5;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0066 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r9, com.huawei.hms.scankit.p.m4 r10, java.util.Map<com.huawei.hms.scankit.p.l1, java.lang.Object> r11, float[] r12) throws com.huawei.hms.scankit.p.a {
        /*
            r8 = this;
            int r0 = r9.c()
            int r1 = r9.e()
            int r0 = java.lang.Math.min(r0, r1)
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r2 = 1149698048(0x44870000, float:1080.0)
            float r0 = r0 / r2
            boolean r2 = com.huawei.hms.scankit.p.r3.a
            if (r2 == 0) goto L_0x001c
            com.huawei.hms.scankit.p.p r9 = r10.a(r9, r0)
            goto L_0x0028
        L_0x001c:
            r2 = 1069547520(0x3fc00000, float:1.5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0023
            r1 = r0
        L_0x0023:
            com.huawei.hms.scankit.p.p r9 = r10.a(r9, r1)
            r0 = r1
        L_0x0028:
            com.huawei.hms.scankit.p.o6[] r1 = r8.a(r11)
            boolean r2 = com.huawei.hms.scankit.p.r3.b
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L_0x0044
            boolean r2 = com.huawei.hms.scankit.p.r3.a
            if (r2 == 0) goto L_0x0044
            com.huawei.hms.scankit.p.l1 r10 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r11.put(r10, r2)
            com.huawei.hms.scankit.p.s6 r10 = r8.a((com.huawei.hms.scankit.p.p) r9, (com.huawei.hms.scankit.p.o6[]) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11)
            goto L_0x0080
        L_0x0044:
            r2 = r3
            r5 = r4
        L_0x0046:
            r6 = 2
            if (r2 >= r6) goto L_0x007f
            r6 = 1
            if (r2 != r6) goto L_0x005d
            com.huawei.hms.scankit.p.p r7 = com.huawei.hms.scankit.p.l4.a(r9)
            com.huawei.hms.scankit.p.p r7 = r10.c(r7)     // Catch:{ a -> 0x007c }
            com.huawei.hms.scankit.p.s6 r5 = r8.a((com.huawei.hms.scankit.p.p) r7, (com.huawei.hms.scankit.p.o6[]) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11)     // Catch:{ a -> 0x007c }
            r7 = 1073741824(0x40000000, float:2.0)
            r12[r6] = r7     // Catch:{ a -> 0x007c }
            goto L_0x007f
        L_0x005d:
            com.huawei.hms.scankit.p.p r7 = r10.b(r9)     // Catch:{ a -> 0x0066 }
            com.huawei.hms.scankit.p.s6 r10 = r8.a((com.huawei.hms.scankit.p.p) r7, (com.huawei.hms.scankit.p.o6[]) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11)     // Catch:{ a -> 0x0066 }
            goto L_0x0080
        L_0x0066:
            boolean r7 = com.huawei.hms.scankit.p.r3.p     // Catch:{ a -> 0x007c }
            if (r7 == 0) goto L_0x007c
            com.huawei.hms.scankit.p.l1 r7 = com.huawei.hms.scankit.p.l1.PHOTO_MODE_NUM     // Catch:{ a -> 0x007c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ a -> 0x007c }
            r11.put(r7, r6)     // Catch:{ a -> 0x007c }
            com.huawei.hms.scankit.p.p r6 = r10.d(r9)     // Catch:{ a -> 0x007c }
            com.huawei.hms.scankit.p.s6 r10 = r8.a((com.huawei.hms.scankit.p.p) r6, (com.huawei.hms.scankit.p.o6[]) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11)     // Catch:{ a -> 0x007c }
            goto L_0x0080
        L_0x007c:
            int r2 = r2 + 1
            goto L_0x0046
        L_0x007f:
            r10 = r5
        L_0x0080:
            if (r10 == 0) goto L_0x0089
            com.huawei.hms.scankit.p.s r9 = r9.b()
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.s) r9, (com.huawei.hms.scankit.p.s6) r10, (float) r0, (com.huawei.hms.scankit.p.i2) r4)
        L_0x0089:
            r12[r3] = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, float[]):com.huawei.hms.scankit.p.s6");
    }

    public s6 a(p pVar, p pVar2, p pVar3, Map<l1, ?> map, m4 m4Var, i2 i2Var) throws a {
        s6 a = pVar3 != null ? a(pVar3, m4Var, map, i2Var) : null;
        if (a != null) {
            return a;
        }
        throw a.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082 A[Catch:{ a -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a A[Catch:{ a -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.p r9, com.huawei.hms.scankit.p.m4 r10, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r11, com.huawei.hms.scankit.p.i2 r12) throws com.huawei.hms.scankit.p.a {
        /*
            r8 = this;
            int r0 = r9.e()
            int r1 = r9.c()
            if (r0 >= r1) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            r0 = r1
        L_0x000c:
            float r0 = (float) r0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            r1 = 1147207680(0x44610000, float:900.0)
            float r0 = r0 / r1
            com.huawei.hms.scankit.p.p r9 = r10.i(r9, r0)
            r10 = 0
            r1 = 0
            com.huawei.hms.scankit.p.o6[] r2 = r8.a(r11)     // Catch:{ a -> 0x005d }
            com.huawei.hms.scankit.p.s6 r2 = r8.a((com.huawei.hms.scankit.p.p) r9, (com.huawei.hms.scankit.p.o6[]) r2, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11)     // Catch:{ a -> 0x005d }
            if (r2 == 0) goto L_0x0031
            java.lang.String r3 = r2.k()     // Catch:{ a -> 0x0058 }
            if (r3 == 0) goto L_0x0031
            com.huawei.hms.scankit.p.u6[] r3 = r2.j()     // Catch:{ a -> 0x0058 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r3, (float) r0, (com.huawei.hms.scankit.p.i2) r12)     // Catch:{ a -> 0x0058 }
            return r2
        L_0x0031:
            boolean r3 = com.huawei.hms.scankit.p.r3.c     // Catch:{ a -> 0x0058 }
            if (r3 != 0) goto L_0x0052
            if (r2 == 0) goto L_0x0052
            java.lang.String r3 = r2.k()     // Catch:{ a -> 0x0058 }
            if (r3 != 0) goto L_0x0052
            com.huawei.hms.scankit.p.u6[] r3 = r2.j()     // Catch:{ a -> 0x0058 }
            int r3 = r3.length     // Catch:{ a -> 0x0058 }
            r4 = 3
            if (r3 < r4) goto L_0x0052
            r3 = 1
            com.huawei.hms.scankit.p.u6[] r4 = r2.j()     // Catch:{ a -> 0x0059 }
            java.lang.Object r4 = r4.clone()     // Catch:{ a -> 0x0059 }
            com.huawei.hms.scankit.p.u6[] r4 = (com.huawei.hms.scankit.p.u6[]) r4     // Catch:{ a -> 0x0059 }
            r10 = r4
            goto L_0x0053
        L_0x0052:
            r3 = r1
        L_0x0053:
            com.huawei.hms.scankit.p.a r4 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0059 }
            throw r4     // Catch:{ a -> 0x0059 }
        L_0x0058:
            r3 = r1
        L_0x0059:
            r7 = r2
            r2 = r10
            r10 = r7
            goto L_0x005f
        L_0x005d:
            r2 = r10
            r3 = r1
        L_0x005f:
            byte[] r4 = r9.d()     // Catch:{ a -> 0x008f }
            int r5 = r9.e()     // Catch:{ a -> 0x008f }
            int r6 = r9.c()     // Catch:{ a -> 0x008f }
            com.huawei.hms.scankit.p.s r1 = com.huawei.hms.scankit.p.n1.a((byte[]) r4, (int) r5, (int) r6, (boolean) r1)     // Catch:{ a -> 0x008f }
            r9.a(r1)     // Catch:{ a -> 0x008f }
            com.huawei.hms.scankit.p.o6[] r1 = r8.a(r11)     // Catch:{ a -> 0x008f }
            com.huawei.hms.scankit.p.s6 r10 = r8.a((com.huawei.hms.scankit.p.p) r9, (com.huawei.hms.scankit.p.o6[]) r1, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r11)     // Catch:{ a -> 0x008f }
            if (r10 == 0) goto L_0x008a
            java.lang.String r9 = r10.k()     // Catch:{ a -> 0x008f }
            if (r9 == 0) goto L_0x008a
            com.huawei.hms.scankit.p.u6[] r9 = r10.j()     // Catch:{ a -> 0x008f }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r9, (float) r0, (com.huawei.hms.scankit.p.i2) r12)     // Catch:{ a -> 0x008f }
            return r10
        L_0x008a:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x008f }
            throw r9     // Catch:{ a -> 0x008f }
        L_0x008f:
            if (r10 == 0) goto L_0x00a1
            if (r3 == 0) goto L_0x00a0
            r10.a()
            r10.b((com.huawei.hms.scankit.p.u6[]) r2)
            com.huawei.hms.scankit.p.u6[] r9 = r10.j()
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r9, (float) r0, (com.huawei.hms.scankit.p.i2) r12)
        L_0x00a0:
            return r10
        L_0x00a1:
            com.huawei.hms.scankit.p.a r9 = com.huawei.hms.scankit.p.a.a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r8 = a(r8.f(r1), r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r8 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        com.huawei.hms.scankit.p.k2.a(r8.j(), r6, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        throw com.huawei.hms.scankit.p.a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r6 = a(new com.huawei.hms.scankit.p.p(new com.huawei.hms.scankit.p.e4(r7.a().c())), r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        com.huawei.hms.scankit.p.k2.a(r6.j(), 1.0f, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        return r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(int r6, com.huawei.hms.scankit.p.p r7, com.huawei.hms.scankit.p.m4 r8, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r9, com.huawei.hms.scankit.p.i2 r10) throws com.huawei.hms.scankit.p.a {
        /*
            r5 = this;
            float r6 = (float) r6
            r0 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 * r0
            r1 = 1132068864(0x437a0000, float:250.0)
            float r6 = r6 / r1
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x000c
            r6 = r0
        L_0x000c:
            com.huawei.hms.scankit.p.p r1 = r8.f(r7, r6)
            com.huawei.hms.scankit.p.o6[] r2 = r5.a(r9)
            com.huawei.hms.scankit.p.p r3 = r8.e(r1)     // Catch:{ a -> 0x0031 }
            com.huawei.hms.scankit.p.s6 r3 = r5.a((com.huawei.hms.scankit.p.p) r3, (com.huawei.hms.scankit.p.o6[]) r2, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r9)     // Catch:{ a -> 0x0031 }
            if (r3 == 0) goto L_0x002c
            java.lang.String r4 = r3.k()     // Catch:{ a -> 0x0031 }
            if (r4 == 0) goto L_0x002c
            com.huawei.hms.scankit.p.u6[] r4 = r3.j()     // Catch:{ a -> 0x0031 }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r4, (float) r6, (com.huawei.hms.scankit.p.i2) r10)     // Catch:{ a -> 0x0031 }
            return r3
        L_0x002c:
            com.huawei.hms.scankit.p.a r3 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x0031 }
            throw r3     // Catch:{ a -> 0x0031 }
        L_0x0031:
            com.huawei.hms.scankit.p.p r8 = r8.f(r1)     // Catch:{ a -> 0x004e }
            com.huawei.hms.scankit.p.s6 r8 = r5.a((com.huawei.hms.scankit.p.p) r8, (com.huawei.hms.scankit.p.o6[]) r2, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r9)     // Catch:{ a -> 0x004e }
            if (r8 == 0) goto L_0x0049
            java.lang.String r1 = r8.k()     // Catch:{ a -> 0x004e }
            if (r1 == 0) goto L_0x0049
            com.huawei.hms.scankit.p.u6[] r1 = r8.j()     // Catch:{ a -> 0x004e }
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r1, (float) r6, (com.huawei.hms.scankit.p.i2) r10)     // Catch:{ a -> 0x004e }
            return r8
        L_0x0049:
            com.huawei.hms.scankit.p.a r6 = com.huawei.hms.scankit.p.a.a()     // Catch:{ a -> 0x004e }
            throw r6     // Catch:{ a -> 0x004e }
        L_0x004e:
            com.huawei.hms.scankit.p.p r6 = new com.huawei.hms.scankit.p.p
            com.huawei.hms.scankit.p.e4 r8 = new com.huawei.hms.scankit.p.e4
            com.huawei.hms.scankit.p.o r7 = r7.a()
            com.huawei.hms.scankit.p.p4 r7 = r7.c()
            r8.<init>(r7)
            r6.<init>(r8)
            com.huawei.hms.scankit.p.s6 r6 = r5.a((com.huawei.hms.scankit.p.p) r6, (com.huawei.hms.scankit.p.o6[]) r2, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r9)
            if (r6 == 0) goto L_0x0073
            java.lang.String r7 = r6.k()
            if (r7 == 0) goto L_0x0073
            com.huawei.hms.scankit.p.u6[] r7 = r6.j()
            com.huawei.hms.scankit.p.k2.a((com.huawei.hms.scankit.p.u6[]) r7, (float) r0, (com.huawei.hms.scankit.p.i2) r10)
        L_0x0073:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a5.a(int, com.huawei.hms.scankit.p.p, com.huawei.hms.scankit.p.m4, java.util.Map, com.huawei.hms.scankit.p.i2):com.huawei.hms.scankit.p.s6");
    }

    public s6 a(p pVar, p pVar2, m4 m4Var, Map<l1, ?> map) throws a {
        p pVar3;
        int e = pVar.e();
        int c = pVar.c();
        int i = e < c ? e : c;
        float f = 1.0f;
        float f2 = (((float) i) * 1.0f) / 1080.0f;
        if (f2 <= 1.0f) {
            f2 = 1.0f;
        }
        if (r3.a) {
            pVar3 = m4Var.a(pVar, f2);
        } else {
            if (f2 > 1.5f) {
                f = f2;
            }
            float f3 = f;
            pVar3 = m4Var.a(pVar, f);
            f2 = f3;
        }
        try {
            s6 a = a(pVar3, a(map), map);
            if (a == null || a.k() == null) {
                if (!r3.c && a != null && a.k() == null && a.j().length >= 3) {
                    u6[] u6VarArr = (u6[]) a.j().clone();
                }
                throw a.a();
            }
            k2.a(a.j(), f2, (i2) null);
            return a;
        } catch (a unused) {
            s6 a2 = a(i, m4Var, pVar, pVar2, map);
            if (a2 != null) {
                if (0 != 0) {
                    a2.a();
                    a2.b((u6[]) null);
                }
                return a2;
            }
            throw a.a();
        }
    }

    private s6 a(int i, m4 m4Var, p pVar, p pVar2, Map<l1, ?> map) throws a {
        o6[] a = a(map);
        float f = 1.0f;
        try {
            if (r3.a) {
                float f2 = (((float) i) * 1.0f) / 500.0f;
                if (f2 <= 1.0f) {
                    f2 = 1.0f;
                }
                s6 a2 = a(m4Var.g(m4Var.g(pVar, f2)), a, map);
                if (!(a2 == null || a2.k() == null)) {
                    k2.a(a2.j(), f2, (i2) null);
                    return a2;
                }
            }
            throw a.a();
        } catch (a unused) {
            float f3 = (((float) i) * 1.0f) / 1080.0f;
            if (f3 > 1.0f) {
                f = f3;
            }
            s6 a3 = a(m4Var.b(pVar2, f), a, map);
            if (!(a3 == null || a3.k() == null)) {
                k2.a(a3.j(), f, (i2) null);
            }
            return a3;
        }
    }
}

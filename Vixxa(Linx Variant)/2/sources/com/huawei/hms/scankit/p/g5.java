package com.huawei.hms.scankit.p;

import java.util.Arrays;
import java.util.Map;

/* compiled from: OneDReader */
public abstract class g5 implements o6 {
    private s6 b(p pVar, Map<l1, ?> map) throws a {
        int e = pVar.e();
        int c = pVar.c();
        r rVar = new r(e);
        int max = Math.max(1, c >> 5);
        int i = c / 2;
        if (map != null) {
            l1 l1Var = l1.PHOTO_MODE_NUM;
            if (map.containsKey(l1Var)) {
                i += (((Integer) map.get(l1Var)).intValue() * max) / 3;
            }
        }
        int i2 = i;
        int i3 = 0;
        while (i3 < 15) {
            int i4 = i3 + 1;
            int i5 = i4 / 2;
            if ((i3 & 1) != 0) {
                i5 = -i5;
            }
            int i6 = i2 + (i5 * max);
            if (i6 < 0 || i6 >= c) {
                break;
            }
            s6 a = a(pVar, rVar, map, i6, e);
            if (a != null && a.k() != null) {
                return a;
            }
            i3 = i4;
        }
        throw a.a();
    }

    public abstract s6 a(int i, r rVar, Map<l1, ?> map) throws a;

    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return b(pVar, map);
    }

    private s6 a(p pVar, r rVar, Map<l1, ?> map, int i, int i2) throws a {
        int i3 = 0;
        while (true) {
            int i4 = 3;
            if (i3 >= 3) {
                return null;
            }
            if (i3 == 0) {
                try {
                    rVar = pVar.a(i, rVar);
                } catch (a unused) {
                    continue;
                }
            } else if (i3 == 1) {
                rVar = pVar.b().a(i, rVar);
                i4 = 1;
            } else if (i3 == 2) {
                if (!r3.t) {
                    continue;
                    i3++;
                } else {
                    rVar = pVar.a(i, 1);
                }
            }
            if (a(rVar.d())) {
                s6 a = a(rVar, !r3.c ? 1 : i4, map, i, i2);
                if (!(a == null || a.k() == null)) {
                    return a;
                }
            } else {
                continue;
            }
            i3++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0094 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.s6 a(com.huawei.hms.scankit.p.r r19, int r20, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r23
            r1 = 0
            r3 = r20
            r2 = r21
            r4 = r1
        L_0x0008:
            if (r4 >= r3) goto L_0x00a2
            if (r4 != 0) goto L_0x000f
            r19.c()
        L_0x000f:
            r5 = 1
            if (r4 != r5) goto L_0x0015
            r19.i()
        L_0x0015:
            r6 = 2
            if (r4 != r6) goto L_0x001e
            r19.g()
            r19.j()
        L_0x001e:
            r7 = r1
        L_0x001f:
            if (r7 >= r6) goto L_0x0098
            if (r7 != r5) goto L_0x0045
            r19.h()
            if (r2 == 0) goto L_0x0045
            com.huawei.hms.scankit.p.l1 r8 = com.huawei.hms.scankit.p.l1.NEED_RESULT_POINT_CALLBACK
            boolean r9 = r2.containsKey(r8)
            if (r9 == 0) goto L_0x0045
            java.util.EnumMap r9 = new java.util.EnumMap
            java.lang.Class<com.huawei.hms.scankit.p.l1> r10 = com.huawei.hms.scankit.p.l1.class
            r9.<init>(r10)
            r9.putAll(r2)
            r9.remove(r8)
            r8 = r18
            r10 = r22
            r2 = r9
            r9 = r19
            goto L_0x004b
        L_0x0045:
            r8 = r18
            r9 = r19
            r10 = r22
        L_0x004b:
            com.huawei.hms.scankit.p.s6 r11 = r8.a((int) r10, (com.huawei.hms.scankit.p.r) r9, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r2)     // Catch:{ a -> 0x008f }
            if (r7 != r5) goto L_0x0087
            com.huawei.hms.scankit.p.u6[] r12 = r11.j()     // Catch:{ a -> 0x008f }
            if (r12 == 0) goto L_0x0087
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6     // Catch:{ a -> 0x008f }
            float r14 = (float) r0     // Catch:{ a -> 0x008f }
            r15 = r12[r1]     // Catch:{ a -> 0x008f }
            float r15 = r15.b()     // Catch:{ a -> 0x008f }
            float r15 = r14 - r15
            r16 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 - r16
            r17 = r12[r1]     // Catch:{ a -> 0x008f }
            float r6 = r17.c()     // Catch:{ a -> 0x008f }
            r13.<init>(r15, r6)     // Catch:{ a -> 0x008f }
            r12[r1] = r13     // Catch:{ a -> 0x008f }
            com.huawei.hms.scankit.p.u6 r6 = new com.huawei.hms.scankit.p.u6     // Catch:{ a -> 0x008f }
            r13 = r12[r5]     // Catch:{ a -> 0x008f }
            float r13 = r13.b()     // Catch:{ a -> 0x008f }
            float r14 = r14 - r13
            float r14 = r14 - r16
            r13 = r12[r5]     // Catch:{ a -> 0x008f }
            float r13 = r13.c()     // Catch:{ a -> 0x008f }
            r6.<init>(r14, r13)     // Catch:{ a -> 0x008f }
            r12[r5] = r6     // Catch:{ a -> 0x008f }
        L_0x0087:
            boolean r6 = a((com.huawei.hms.scankit.p.s6) r11, (int) r0)     // Catch:{ a -> 0x008f }
            if (r6 != 0) goto L_0x008e
            goto L_0x0094
        L_0x008e:
            return r11
        L_0x008f:
            if (r7 != r5) goto L_0x0094
            r19.h()
        L_0x0094:
            int r7 = r7 + 1
            r6 = 2
            goto L_0x001f
        L_0x0098:
            r8 = r18
            r9 = r19
            r10 = r22
            int r4 = r4 + 1
            goto L_0x0008
        L_0x00a2:
            r8 = r18
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.g5.a(com.huawei.hms.scankit.p.r, int, java.util.Map, int, int):com.huawei.hms.scankit.p.s6");
    }

    private static boolean a(int[] iArr) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length && i < 20; i3++) {
            int i4 = iArr[i3];
            i += Integer.bitCount((i2 | (i4 << 1)) ^ i4);
            i2 = (iArr[i3] >> 31) & 1;
        }
        if (i >= 20) {
            return true;
        }
        return false;
    }

    private static boolean a(s6 s6Var, int i) {
        u6[] j = s6Var.j();
        if (Math.abs(((double) j[1].b()) - ((double) j[0].b())) / ((double) i) > 0.4d) {
            return true;
        }
        return false;
    }

    protected static void a(r rVar, int i, int[] iArr) throws a {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int e = rVar.e();
        if (i < e) {
            boolean z = !rVar.b(i);
            while (i < e) {
                if (rVar.b(i) == z) {
                    i2++;
                    if (i2 == length) {
                        break;
                    } else if (i2 < 0 || i2 >= iArr.length) {
                        throw a.a();
                    } else {
                        iArr[i2] = 1;
                        z = !z;
                    }
                } else if (i2 < 0 || i2 >= iArr.length) {
                    throw a.a();
                } else {
                    iArr[i2] = iArr[i2] + 1;
                }
                i++;
            }
            if (i2 == length) {
                return;
            }
            if (i2 != length - 1 || i != e) {
                throw a.a();
            }
            return;
        }
        throw a.a();
    }

    protected static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}

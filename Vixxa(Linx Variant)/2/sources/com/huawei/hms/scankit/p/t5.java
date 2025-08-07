package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: PDF417ScanningDecoder */
public final class t5 {
    private static final a3 a = new a3();

    public static w1 a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, int i, int i2, Map<l1, ?> map) throws a {
        a0 a0Var;
        z1 b;
        a0 a0Var2 = new a0(sVar, u6Var, u6Var2, u6Var3, u6Var4);
        b2 b2Var = null;
        b2 b2Var2 = null;
        boolean z = true;
        while (true) {
            a0Var = a0Var2;
            if (u6Var != null) {
                b2Var = a(sVar, a0Var, u6Var, true, i, i2);
            }
            if (u6Var3 != null) {
                b2Var2 = a(sVar, a0Var, u6Var3, false, i, i2);
            }
            b = b(b2Var, b2Var2);
            if (b != null) {
                a0Var2 = b.i();
                if (!z || a0Var2 == null || (a0Var2.f() >= a0Var.f() && a0Var2.d() <= a0Var.d())) {
                    b.a(a0Var);
                    int f = b.f() + 1;
                    b.a(0, (a2) b2Var);
                    b.a(f, (a2) b2Var2);
                    a(b, b2Var, a0Var, f, sVar, i, i2);
                } else {
                    z = false;
                }
            } else {
                throw a.a();
            }
        }
        b.a(a0Var);
        int f2 = b.f() + 1;
        b.a(0, (a2) b2Var);
        b.a(f2, (a2) b2Var2);
        a(b, b2Var, a0Var, f2, sVar, i, i2);
        return a(b, map);
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static z1 b(b2 b2Var, b2 b2Var2) throws a {
        k a2;
        if ((b2Var == null && b2Var2 == null) || (a2 = a(b2Var, b2Var2)) == null) {
            return null;
        }
        return new z1(a2, a0.a(a(b2Var), a(b2Var2)));
    }

    private static int c(int i) {
        return 2 << i;
    }

    private static int b(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static int[] b(s sVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
            } else if (i3 >= i2) {
                break;
            }
            if (i6 >= 8) {
                break;
            } else if (sVar.b(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (!(i3 == i && i6 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int b(int i) {
        return a(a(i));
    }

    private static void a(z1 z1Var, b2 b2Var, a0 a0Var, int i, s sVar, int i2, int i3) {
        a2 b2Var2;
        int i4;
        int i5;
        int i6;
        a2 a2Var;
        int i7;
        int i8;
        z1 z1Var2 = z1Var;
        a0 a0Var2 = a0Var;
        int i9 = i;
        boolean z = b2Var != null;
        int i10 = i2;
        int i11 = i3;
        for (int i12 = 1; i12 <= i9; i12++) {
            int i13 = z ? i12 : i9 - i12;
            if (z1Var2.a(i13) == null) {
                if (i13 == 0 || i13 == i9) {
                    b2Var2 = new b2(a0Var2, i13 == 0);
                } else {
                    b2Var2 = new a2(a0Var2);
                }
                a2 a2Var2 = b2Var2;
                z1Var2.a(i13, a2Var2);
                int i14 = -1;
                int i15 = i10;
                int i16 = i11;
                int f = a0Var.f();
                int i17 = -1;
                while (f <= a0Var.d()) {
                    int a2 = a(z1Var2, i13, f, z);
                    if (a2 >= 0 && a2 <= a0Var.c()) {
                        i5 = a2;
                    } else if (i17 == i14) {
                        i7 = i17;
                        i6 = f;
                        i8 = i15;
                        i4 = i14;
                        a2Var = a2Var2;
                        i15 = i8;
                        i5 = i7;
                        f = i6 + 1;
                        a2Var2 = a2Var;
                        i17 = i5;
                        i14 = i4;
                    } else {
                        i5 = i17;
                    }
                    i7 = i17;
                    int i18 = f;
                    int i19 = i16;
                    int i20 = i15;
                    i4 = i14;
                    a2Var = a2Var2;
                    x0 a3 = a(sVar, a0Var.e(), a0Var.c(), z, i5, i18, i20, i19);
                    i6 = i18;
                    if (a3 != null) {
                        a2Var.a(i6, a3);
                        int min = Math.min(i20, a3.f());
                        i16 = Math.max(i19, a3.f());
                        i15 = min;
                        f = i6 + 1;
                        a2Var2 = a2Var;
                        i17 = i5;
                        i14 = i4;
                    } else {
                        i16 = i19;
                        i8 = i20;
                        i15 = i8;
                        i5 = i7;
                        f = i6 + 1;
                        a2Var2 = a2Var;
                        i17 = i5;
                        i14 = i4;
                    }
                }
                i10 = i15;
                i11 = i16;
            }
        }
    }

    private static a0 a(b2 b2Var) throws a {
        int[] d;
        if (b2Var == null || (d = b2Var.d()) == null) {
            return null;
        }
        int b = b(d);
        int i = 0;
        int i2 = 0;
        for (int i3 : d) {
            i2 += b - i3;
            if (i3 > 0) {
                break;
            }
        }
        x0[] b2 = b2Var.b();
        int i4 = 0;
        while (i2 > 0 && b2[i4] == null) {
            i2--;
            i4++;
        }
        for (int length = d.length - 1; length >= 0; length--) {
            int i5 = d[length];
            i += b - i5;
            if (i5 > 0) {
                break;
            }
        }
        int length2 = b2.length - 1;
        while (i > 0 && b2[length2] == null) {
            i--;
            length2--;
        }
        return b2Var.a().a(i2, i, b2Var.e());
    }

    private static k a(b2 b2Var, b2 b2Var2) throws a {
        k c;
        k c2;
        if (b2Var == null || (c = b2Var.c()) == null) {
            if (b2Var2 == null) {
                return null;
            }
            return b2Var2.c();
        } else if (b2Var2 == null || (c2 = b2Var2.c()) == null || c.a() == c2.a() || c.b() == c2.b() || c.c() == c2.c()) {
            return c;
        } else {
            return null;
        }
    }

    private static b2 a(s sVar, a0 a0Var, u6 u6Var, boolean z, int i, int i2) {
        int i3;
        boolean z2 = z;
        b2 b2Var = new b2(a0Var, z2);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int b = (int) u6Var.b();
            int c = (int) u6Var.c();
            while (c <= a0Var.d() && c >= a0Var.f()) {
                x0 a2 = a(sVar, 0, sVar.e(), z, b, c, i, i2);
                if (a2 != null) {
                    b2Var.a(c, a2);
                    if (z2) {
                        i3 = a2.d();
                    } else {
                        i3 = a2.b();
                    }
                    b = i3;
                }
                c += i5;
            }
            i4++;
        }
        return b2Var;
    }

    private static void a(z1 z1Var, m[][] mVarArr) throws a {
        m mVar = mVarArr[0][1];
        int[] a2 = mVar.a();
        int f = (z1Var.f() * z1Var.h()) - c(z1Var.g());
        if (a2.length == 0) {
            if (f < 1 || f > 928) {
                throw a.a();
            }
            mVar.a(f);
        } else if (a2[0] != f) {
            mVar.a(f);
        }
    }

    private static w1 a(z1 z1Var, Map<l1, ?> map) throws a {
        m[][] a2 = a(z1Var);
        a(z1Var, a2);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(z1Var.h() * z1Var.f())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < z1Var.h(); i++) {
            int i2 = 0;
            while (i2 < z1Var.f()) {
                int i3 = i2 + 1;
                int[] a3 = a2[i][i3].a();
                int f = (z1Var.f() * i) + i2;
                if (a3.length == 0) {
                    arrayList.add(Integer.valueOf(f));
                } else if (a3.length == 1) {
                    iArr[f] = a3[0];
                } else {
                    arrayList3.add(Integer.valueOf(f));
                    arrayList2.add(a3);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return a(z1Var.g(), iArr, n5.a((Collection<Integer>) arrayList), n5.a((Collection<Integer>) arrayList3), iArr2, map);
    }

    private static w1 a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4, Map<l1, ?> map) throws a {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return a(iArr, i, iArr2, map);
                } catch (a unused) {
                    if (length != 0) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                break;
                            }
                            int i6 = iArr5[i5];
                            if (i6 < iArr4[i5].length - 1) {
                                iArr5[i5] = i6 + 1;
                                break;
                            }
                            iArr5[i5] = 0;
                            if (i5 != length - 1) {
                                i5++;
                            } else {
                                throw a.a();
                            }
                        }
                        i2 = i3;
                    } else {
                        throw a.a();
                    }
                }
            } else {
                throw a.a();
            }
        }
    }

    private static m[][] a(z1 z1Var) throws a {
        int c;
        int h = z1Var.h();
        int[] iArr = new int[2];
        iArr[1] = z1Var.f() + 2;
        iArr[0] = h;
        m[][] mVarArr = (m[][]) Array.newInstance(m.class, iArr);
        for (m[] mVarArr2 : mVarArr) {
            int i = 0;
            while (true) {
                if (i >= mVarArr2.length) {
                    break;
                }
                mVarArr2[i] = new m();
                i++;
            }
        }
        int i2 = 0;
        for (a2 a2Var : z1Var.j()) {
            if (a2Var != null) {
                for (x0 x0Var : a2Var.b()) {
                    if (x0Var != null && (c = x0Var.c()) >= 0 && c < mVarArr.length) {
                        mVarArr[c][i2].a(x0Var.e());
                    }
                }
            }
            i2++;
        }
        return mVarArr;
    }

    private static boolean a(z1 z1Var, int i) {
        return i >= 0 && i <= z1Var.f() + 1;
    }

    private static int a(z1 z1Var, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        x0 a2 = a(z1Var, i4) ? z1Var.a(i4).a(i2) : null;
        if (a2 != null) {
            return z ? a2.b() : a2.d();
        }
        x0 b = z1Var.a(i).b(i2);
        if (b != null) {
            return z ? b.d() : b.b();
        }
        if (a(z1Var, i4)) {
            b = z1Var.a(i4).b(i2);
        }
        if (b != null) {
            return z ? b.b() : b.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!a(z1Var, i)) {
                return z ? z1Var.i().e() : z1Var.i().c();
            }
            for (x0 x0Var : z1Var.a(i).b()) {
                if (x0Var != null) {
                    return (z ? x0Var.b() : x0Var.d()) + (i3 * i5 * (x0Var.b() - x0Var.d()));
                }
            }
            i5++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = com.huawei.hms.scankit.p.m5.d(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.huawei.hms.scankit.p.x0 a(com.huawei.hms.scankit.p.s r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = a((com.huawei.hms.scankit.p.s) r7, (int) r8, (int) r9, (boolean) r10, (int) r11, (int) r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = b(r0, r1, r2, r3, r4, r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = com.huawei.hms.scankit.p.s4.a((int[]) r7)
            if (r10 == 0) goto L_0x001b
            int r10 = r11 + r9
            goto L_0x0039
        L_0x001b:
            r10 = 0
        L_0x001c:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 >= r12) goto L_0x0034
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001c
        L_0x0034:
            int r10 = r11 - r9
            r6 = r11
            r11 = r10
            r10 = r6
        L_0x0039:
            boolean r9 = a((int) r9, (int) r13, (int) r14)
            if (r9 != 0) goto L_0x0040
            return r8
        L_0x0040:
            int r7 = com.huawei.hms.scankit.p.m5.d(r7)
            int r9 = com.huawei.hms.scankit.p.n5.a((int) r7)
            r12 = -1
            if (r9 != r12) goto L_0x004c
            return r8
        L_0x004c:
            com.huawei.hms.scankit.p.x0 r8 = new com.huawei.hms.scankit.p.x0
            int r7 = b((int) r7)
            r8.<init>(r11, r10, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.t5.a(com.huawei.hms.scankit.p.s, int, int, boolean, int, int, int, int):com.huawei.hms.scankit.p.x0");
    }

    private static int a(s sVar, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z) {
                    if (i6 >= i2) {
                        continue;
                        break;
                    }
                } else if (i6 < i) {
                    continue;
                    break;
                }
                if (z != sVar.b(i6, i4)) {
                    continue;
                    break;
                } else if (Math.abs(i3 - i6) > 2) {
                    return i3;
                } else {
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    private static w1 a(int[] iArr, int i, int[] iArr2, Map<l1, ?> map) throws a, a {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int a2 = a(iArr, iArr2, i2);
            a(iArr, i2);
            w1 a3 = q1.a(iArr, String.valueOf(i), map);
            a3.b(Integer.valueOf(a2));
            a3.a(Integer.valueOf(iArr2.length));
            return a3;
        }
        throw a.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i) throws a {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return a.a(iArr, i, iArr2);
        }
        throw a.a();
    }

    private static void a(int[] iArr, int i) throws a {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw a.a();
            } else if (i2 != 0) {
            } else {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    private static int[] a(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}

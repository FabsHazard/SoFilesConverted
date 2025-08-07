package com.huawei.hms.scankit.p;

import java.util.Locale;

/* compiled from: Encoder */
public final class x2 {
    private static final int[] a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public static f a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        r rVar;
        int i6;
        r a2 = new c4(bArr).a();
        int e = ((a2.e() * i) / 100) + 11;
        int e2 = a2.e() + e;
        int i7 = 32;
        int i8 = 4;
        if (i2 != 0) {
            z = i2 < 0;
            i4 = Math.abs(i2);
            if (z) {
                i7 = 4;
            }
            if (i4 <= i7) {
                i5 = a(i4, z);
                i3 = a[i4];
                int i9 = i5 - (i5 % i3);
                rVar = a(a2, i3);
                if (rVar.e() + e > i9) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (z && rVar.e() > i3 * 64) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        } else {
            r rVar2 = null;
            int i10 = 0;
            int i11 = 0;
            while (i10 <= 32) {
                boolean z2 = i10 <= 3;
                int i12 = z2 ? i10 + 1 : i10;
                int a3 = a(i12, z2);
                if (e2 <= a3) {
                    if (rVar2 == null || i11 != a[i12]) {
                        int i13 = a[i12];
                        i11 = i13;
                        rVar2 = a(a2, i13);
                    }
                    int i14 = a3 - (a3 % i11);
                    if ((!z2 || rVar2.e() <= i11 * 64) && rVar2.e() + e <= i14) {
                        rVar = rVar2;
                        i3 = i11;
                        z = z2;
                        i4 = i12;
                        i5 = a3;
                    }
                }
                i10++;
                i8 = 4;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        r b = b(rVar, i5, i3);
        int e3 = rVar.e() / i3;
        r a4 = a(z, i4, e3);
        int i15 = (z ? 11 : 14) + (i4 * 4);
        int[] iArr = new int[i15];
        int i16 = 2;
        if (z) {
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[i17] = i17;
            }
            i6 = i15;
        } else {
            int i18 = i15 / 2;
            i6 = i15 + 1 + (((i18 - 1) / 15) * 2);
            int i19 = i6 / 2;
            for (int i20 = 0; i20 < i18; i20++) {
                int i21 = (i20 / 15) + i20;
                iArr[(i18 - i20) - 1] = (i19 - i21) - 1;
                iArr[i18 + i20] = i21 + i19 + 1;
            }
        }
        s sVar = new s(i6);
        int i22 = 0;
        int i23 = 0;
        while (i22 < i4) {
            int i24 = ((i4 - i22) * i8) + (z ? 9 : 12);
            int i25 = 0;
            while (i25 < i24) {
                int i26 = i25 * 2;
                int i27 = 0;
                while (i27 < i16) {
                    if (b.b(i23 + i26 + i27)) {
                        int i28 = i22 * 2;
                        sVar.c(iArr[i28 + i27], iArr[i28 + i25]);
                    }
                    if (b.b((i24 * 2) + i23 + i26 + i27)) {
                        int i29 = i22 * 2;
                        sVar.c(iArr[i29 + i25], iArr[((i15 - 1) - i29) - i27]);
                    }
                    if (b.b((i24 * 4) + i23 + i26 + i27)) {
                        int i30 = (i15 - 1) - (i22 * 2);
                        sVar.c(iArr[i30 - i27], iArr[i30 - i25]);
                    }
                    if (b.b((i24 * 6) + i23 + i26 + i27)) {
                        int i31 = i22 * 2;
                        sVar.c(iArr[((i15 - 1) - i31) - i25], iArr[i31 + i27]);
                    }
                    i27++;
                    i16 = 2;
                }
                i25++;
                i16 = 2;
            }
            i23 += i24 * 8;
            i22++;
            i8 = 4;
            i16 = 2;
        }
        a(sVar, z, i6, a4);
        if (z) {
            a(sVar, i6 / 2, 5);
        } else {
            int i32 = i6 / 2;
            a(sVar, i32, 7);
            int i33 = 0;
            int i34 = 0;
            while (i33 < (i15 / 2) - 1) {
                for (int i35 = i32 & 1; i35 < i6; i35 += 2) {
                    int i36 = i32 - i34;
                    sVar.c(i36, i35);
                    int i37 = i32 + i34;
                    sVar.c(i37, i35);
                    sVar.c(i35, i36);
                    sVar.c(i35, i37);
                }
                i33 += 15;
                i34 += 16;
            }
        }
        f fVar = new f();
        fVar.a(z);
        fVar.c(i6);
        fVar.b(i4);
        fVar.a(e3);
        fVar.a(sVar);
        return fVar;
    }

    private static r b(r rVar, int i, int i2) {
        q6 q6Var = new q6(a(i2));
        int i3 = i / i2;
        int[] a2 = a(rVar, i2, i3);
        q6Var.a(a2, i3 - (rVar.e() / i2));
        r rVar2 = new r();
        rVar2.a(0, i % i2);
        for (int a3 : a2) {
            rVar2.a(a3, i2);
        }
        return rVar2;
    }

    private static void a(s sVar, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                sVar.c(i5, i4);
                sVar.c(i5, i6);
                sVar.c(i4, i5);
                sVar.c(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        sVar.c(i7, i7);
        int i8 = i7 + 1;
        sVar.c(i8, i7);
        sVar.c(i7, i8);
        int i9 = i + i2;
        sVar.c(i9, i7);
        sVar.c(i9, i8);
        sVar.c(i9, i9 - 1);
    }

    static r a(boolean z, int i, int i2) {
        r rVar = new r();
        if (z) {
            rVar.a(i - 1, 2);
            rVar.a(i2 - 1, 6);
            return b(rVar, 28, 4);
        }
        rVar.a(i - 1, 5);
        rVar.a(i2 - 1, 11);
        return b(rVar, 40, 4);
    }

    private static void a(s sVar, boolean z, int i, r rVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (rVar.b(i3)) {
                    sVar.c(i4, i2 - 5);
                }
                if (rVar.b(i3 + 7)) {
                    sVar.c(i2 + 5, i4);
                }
                if (rVar.b(20 - i3)) {
                    sVar.c(i4, i2 + 5);
                }
                if (rVar.b(27 - i3)) {
                    sVar.c(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (rVar.b(i3)) {
                sVar.c(i5, i2 - 7);
            }
            if (rVar.b(i3 + 10)) {
                sVar.c(i2 + 7, i5);
            }
            if (rVar.b(29 - i3)) {
                sVar.c(i5, i2 + 7);
            }
            if (rVar.b(39 - i3)) {
                sVar.c(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static int[] a(r rVar, int i, int i2) {
        int[] iArr = new int[i2];
        int e = rVar.e() / i;
        for (int i3 = 0; i3 < e; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= rVar.b((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static o3 a(int i) {
        if (i == 4) {
            return o3.k;
        }
        if (i == 6) {
            return o3.j;
        }
        if (i == 8) {
            return o3.n;
        }
        if (i == 10) {
            return o3.i;
        }
        if (i == 12) {
            return o3.h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    static r a(r rVar, int i) {
        r rVar2 = new r();
        int e = rVar.e();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < e) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= e || rVar.b(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                rVar2.a(i7, i);
            } else if (i7 == 0) {
                rVar2.a(i4 | 1, i);
            } else {
                rVar2.a(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return rVar2;
    }
}

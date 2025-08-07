package com.huawei.hms.scankit.p;

/* compiled from: BitMatrixParser */
final class v {
    private final s a;
    private final s b;
    private final z7 c;

    v(s sVar) throws a {
        int c2 = sVar.c();
        if (c2 < 8 || c2 > 144 || (c2 & 1) != 0) {
            throw a.a();
        }
        this.c = b(sVar);
        s a2 = a(sVar);
        this.a = a2;
        this.b = new s(a2.e(), a2.c());
    }

    private static z7 b(s sVar) throws a {
        return z7.a(sVar.c(), sVar.e());
    }

    private int c(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << true;
        int i5 = i2 - 1;
        if (a(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return a(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int d(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (a(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return a(3, i7, i, i2) ? i10 | 1 : i10;
    }

    /* access modifiers changed from: package-private */
    public z7 a() {
        return this.c;
    }

    private int[] a(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        while (true) {
            if (i < i2 && i3 >= 0 && !this.b.b(i3, i)) {
                bArr[i5] = (byte) b(i, i3, i2, i4);
                i5++;
            }
            int i6 = i - 2;
            int i7 = i3 + 2;
            if (i6 < 0 || i7 >= i4) {
                int i8 = i - 1;
                int i9 = i3 + 5;
            } else {
                i = i6;
                i3 = i7;
            }
        }
        int i82 = i - 1;
        int i92 = i3 + 5;
        while (true) {
            if (i82 >= 0 && i92 < i4 && !this.b.b(i92, i82)) {
                bArr[i5] = (byte) b(i82, i92, i2, i4);
                i5++;
            }
            int i10 = i82 + 2;
            int i11 = i92 - 2;
            if (i10 < i2 && i11 >= 0) {
                i82 = i10;
                i92 = i11;
            }
        }
        return new int[]{i82 + 5, i92 - 1, i5};
    }

    /* access modifiers changed from: package-private */
    public byte[] b() throws a {
        byte[] bArr = new byte[this.c.g()];
        int c2 = this.a.c();
        int e = this.a.e();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 4;
        while (true) {
            if (i3 == c2 && i == 0 && !z) {
                bArr[i2] = (byte) a(c2, e);
                i3 -= 2;
                i += 2;
                i2++;
                z = true;
            } else {
                int i4 = c2 - 2;
                if (i3 == i4 && i == 0 && (e & 3) != 0 && !z2) {
                    bArr[i2] = (byte) b(c2, e);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z2 = true;
                } else if (i3 == c2 + 4 && i == 2 && (e & 7) == 0 && !z3) {
                    bArr[i2] = (byte) c(c2, e);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z3 = true;
                } else if (i3 == i4 && i == 0 && (e & 7) == 4 && !z4) {
                    bArr[i2] = (byte) d(c2, e);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z4 = true;
                } else {
                    int[] a2 = a(i3, c2, i, e, bArr, i2);
                    i3 = a2[0];
                    int i5 = a2[1];
                    i2 = a2[2];
                    i = i5;
                }
            }
            if (i3 >= c2 && i >= e) {
                break;
            }
        }
        if (i2 == this.c.g()) {
            return bArr;
        }
        throw a.a();
    }

    private boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.b.c(i2, i);
        return this.a.b(i2, i);
    }

    private int a(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << true;
        if (a(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (a(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << true;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private s a(s sVar) {
        int f = this.c.f();
        int e = this.c.e();
        if (sVar.c() == f) {
            int c2 = this.c.c();
            int b2 = this.c.b();
            int i = f / c2;
            int i2 = e / b2;
            s sVar2 = new s(i2 * b2, i * c2);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * c2;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * b2;
                    for (int i7 = 0; i7 < c2; i7++) {
                        int i8 = ((c2 + 2) * i3) + 1 + i7;
                        int i9 = i4 + i7;
                        for (int i10 = 0; i10 < b2; i10++) {
                            if (sVar.b(((b2 + 2) * i5) + 1 + i10, i8)) {
                                sVar2.c(i6 + i10, i9);
                            }
                        }
                        s sVar3 = sVar;
                    }
                    s sVar4 = sVar;
                }
                s sVar5 = sVar;
            }
            return sVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int b(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << true;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return a(1, i9, i, i2) ? i10 | 1 : i10;
    }
}

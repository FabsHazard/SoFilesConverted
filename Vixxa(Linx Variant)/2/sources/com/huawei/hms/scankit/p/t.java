package com.huawei.hms.scankit.p;

/* compiled from: BitMatrixParser */
final class t {
    private final s a;
    private a8 b;
    private m3 c;
    private boolean d;

    t(s sVar) throws a {
        int c2 = sVar.c();
        if (c2 < 21 || (c2 & 3) != 1) {
            throw a.a();
        }
        this.a = sVar;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.a.b(i2, i) : this.a.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* access modifiers changed from: package-private */
    public byte[] b() throws a {
        m3 c2 = c();
        a8 d2 = d();
        f1 f1Var = f1.values()[c2.b()];
        int c3 = this.a.c();
        f1Var.a(this.a, c3);
        s a2 = d2.a();
        byte[] bArr = new byte[d2.l()];
        int i = c3 - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < c3; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!a2.b(i9, i7)) {
                        i5++;
                        i4 <<= 1;
                        if (this.a.b(i9, i7)) {
                            i4 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i3] = (byte) i4;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == d2.l()) {
            return bArr;
        }
        throw a.a();
    }

    /* access modifiers changed from: package-private */
    public m3 c() throws a {
        m3 m3Var = this.c;
        if (m3Var != null) {
            return m3Var;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int c2 = this.a.c();
        int i5 = c2 - 7;
        for (int i6 = c2 - 1; i6 >= i5; i6--) {
            i = a(8, i6, i);
        }
        for (int i7 = c2 - 8; i7 < c2; i7++) {
            i = a(i7, 8, i);
        }
        m3 a3 = m3.a(a2, i);
        this.c = a3;
        if (a3 != null) {
            return a3;
        }
        throw a.a();
    }

    /* access modifiers changed from: package-private */
    public a8 d() throws a {
        a8 a8Var = this.b;
        if (a8Var != null) {
            return a8Var;
        }
        int c2 = this.a.c();
        int i = (c2 - 17) / 4;
        if (i <= 6) {
            return a8.b(i);
        }
        int i2 = c2 - 11;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = c2 - 9; i6 >= i2; i6--) {
                i4 = a(i6, i5, i4);
            }
        }
        a8 a2 = a8.a(i4);
        if (a2 == null || a2.k() != c2) {
            for (int i7 = 5; i7 >= 0; i7--) {
                for (int i8 = c2 - 9; i8 >= i2; i8--) {
                    i3 = a(i7, i8, i3);
                }
            }
            a8 a3 = a8.a(i3);
            if (a3 == null || a3.k() != c2) {
                throw a.a();
            }
            this.b = a3;
            return a3;
        }
        this.b = a2;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.c != null) {
            f1.values()[this.c.b()].a(this.a, this.a.c());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }

    /* access modifiers changed from: package-private */
    public void a() throws a {
        if (this.a != null) {
            int i = 0;
            while (i < this.a.e()) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < this.a.c(); i3++) {
                    if (this.a.b(i, i3) != this.a.b(i3, i)) {
                        this.a.a(i3, i);
                        this.a.a(i, i3);
                    }
                }
                i = i2;
            }
            return;
        }
        throw a.a();
    }
}

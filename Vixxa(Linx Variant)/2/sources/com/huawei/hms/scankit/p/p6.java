package com.huawei.hms.scankit.p;

/* compiled from: ReedSolomonDecoder */
public final class p6 {
    private final o3 a;

    public p6(o3 o3Var) {
        this.a = o3Var;
    }

    public void a(int[] iArr, int i) throws a {
        p3 p3Var = new p3(this.a, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            o3 o3Var = this.a;
            int a2 = p3Var.a(o3Var.a(o3Var.a() + i3));
            iArr2[(i - 1) - i3] = a2;
            if (a2 != 0) {
                z = false;
            }
        }
        if (!z) {
            p3[] a3 = a(this.a.b(i, 1), new p3(this.a, iArr2), i);
            p3 p3Var2 = a3[0];
            p3 p3Var3 = a3[1];
            int[] a4 = a(p3Var2);
            int[] a5 = a(p3Var3, a4);
            while (i2 < a4.length) {
                int length = (iArr.length - 1) - this.a.c(a4[i2]);
                if (length >= 0) {
                    iArr[length] = o3.a(iArr[length], a5[i2]);
                    i2++;
                } else {
                    throw a.a("Bad error location");
                }
            }
        }
    }

    private p3[] a(p3 p3Var, p3 p3Var2, int i) throws a {
        if (p3Var.b() >= p3Var2.b()) {
            p3 p3Var3 = p3Var2;
            p3Var2 = p3Var;
            p3Var = p3Var3;
        }
        p3 d = this.a.d();
        p3 p3Var4 = d;
        p3 b = this.a.b();
        while (p3Var.b() >= i / 2) {
            if (!p3Var.c()) {
                p3 d2 = this.a.d();
                int b2 = this.a.b(p3Var.b(p3Var.b()));
                while (p3Var2.b() >= p3Var.b() && !p3Var2.c()) {
                    int b3 = p3Var2.b() - p3Var.b();
                    int c = this.a.c(p3Var2.b(p3Var2.b()), b2);
                    d2 = d2.a(this.a.b(b3, c));
                    p3Var2 = p3Var2.a(p3Var.a(b3, c));
                }
                p3 a2 = d2.c(b).a(p3Var4);
                if (p3Var2.b() < p3Var.b()) {
                    p3 p3Var5 = p3Var2;
                    p3Var2 = p3Var;
                    p3Var = p3Var5;
                    p3 p3Var6 = a2;
                    p3Var4 = b;
                    b = p3Var6;
                } else {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
            } else {
                throw a.a("r_{i-1} was zero");
            }
        }
        int b4 = b.b(0);
        if (b4 != 0) {
            int b5 = this.a.b(b4);
            return new p3[]{b.c(b5), p3Var.c(b5)};
        }
        throw a.a("sigmaTilde(0) was zero");
    }

    private int[] a(p3 p3Var) throws a {
        int b = p3Var.b();
        if (b == 1) {
            return new int[]{p3Var.b(1)};
        }
        int[] iArr = new int[b];
        int i = 0;
        for (int i2 = 1; i2 < this.a.c() && i < b; i2++) {
            if (p3Var.a(i2) == 0) {
                iArr[i] = this.a.b(i2);
                i++;
            }
        }
        if (i == b) {
            return iArr;
        }
        throw a.a("Error locator degree does not match number of roots");
    }

    private int[] a(p3 p3Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int b = this.a.b(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c = this.a.c(iArr[i3], b);
                    i2 = this.a.c(i2, (c & 1) == 0 ? c | 1 : c & -2);
                }
            }
            iArr2[i] = this.a.c(p3Var.a(b), this.a.b(i2));
            if (this.a.a() != 0) {
                iArr2[i] = this.a.c(iArr2[i], b);
            }
        }
        return iArr2;
    }
}

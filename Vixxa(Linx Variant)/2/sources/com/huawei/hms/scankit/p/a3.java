package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrection */
public final class a3 {
    private final w4 a = w4.f;

    public int a(int[] iArr, int i, int[] iArr2) throws a {
        x4 x4Var = new x4(this.a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        boolean z = false;
        for (int i3 = i; i3 > 0; i3--) {
            int a2 = x4Var.a(this.a.a(i3));
            iArr3[i - i3] = a2;
            if (a2 != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        x4 a3 = this.a.a();
        if (iArr2 != null) {
            for (int length : iArr2) {
                int a4 = this.a.a((iArr.length - 1) - length);
                w4 w4Var = this.a;
                a3 = a3.b(new x4(w4Var, new int[]{w4Var.d(0, a4), 1}));
            }
        }
        x4[] a5 = a(this.a.b(i, 1), new x4(this.a, iArr3), i);
        x4 x4Var2 = a5[0];
        x4 x4Var3 = a5[1];
        int[] a6 = a(x4Var2);
        int[] a7 = a(x4Var3, x4Var2, a6);
        while (i2 < a6.length) {
            int length2 = (iArr.length - 1) - this.a.c(a6[i2]);
            if (length2 >= 0) {
                iArr[length2] = this.a.d(iArr[length2], a7[i2]);
                i2++;
            } else {
                throw a.a();
            }
        }
        return a6.length;
    }

    private x4[] a(x4 x4Var, x4 x4Var2, int i) throws a {
        if (x4Var.a() >= x4Var2.a()) {
            x4 x4Var3 = x4Var2;
            x4Var2 = x4Var;
            x4Var = x4Var3;
        }
        x4 c = this.a.c();
        x4 x4Var4 = c;
        x4 a2 = this.a.a();
        while (x4Var.a() >= i / 2) {
            if (!x4Var.b()) {
                x4 c2 = this.a.c();
                int b = this.a.b(x4Var.b(x4Var.a()));
                while (x4Var2.a() >= x4Var.a() && !x4Var2.b()) {
                    int a3 = x4Var2.a() - x4Var.a();
                    int c3 = this.a.c(x4Var2.b(x4Var2.a()), b);
                    c2 = c2.a(this.a.b(a3, c3));
                    x4Var2 = x4Var2.c(x4Var.a(a3, c3));
                }
                x4 x4Var5 = x4Var2;
                x4Var2 = x4Var;
                x4Var = x4Var5;
                x4 c4 = c2.b(a2).c(x4Var4).c();
                x4Var4 = a2;
                a2 = c4;
            } else {
                throw a.a();
            }
        }
        int b2 = a2.b(0);
        if (b2 != 0) {
            int b3 = this.a.b(b2);
            return new x4[]{a2.c(b3), x4Var.c(b3)};
        }
        throw a.a();
    }

    private int[] a(x4 x4Var) throws a {
        int a2 = x4Var.a();
        int[] iArr = new int[a2];
        int i = 0;
        for (int i2 = 1; i2 < this.a.b() && i < a2; i2++) {
            if (x4Var.a(i2) == 0) {
                iArr[i] = this.a.b(i2);
                i++;
            }
        }
        if (i == a2) {
            return iArr;
        }
        throw a.a();
    }

    private int[] a(x4 x4Var, x4 x4Var2, int[] iArr) {
        int a2 = x4Var2.a();
        int[] iArr2 = new int[a2];
        for (int i = 1; i <= a2; i++) {
            iArr2[a2 - i] = this.a.c(i, x4Var2.b(i));
        }
        x4 x4Var3 = new x4(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int b = this.a.b(iArr[i2]);
            iArr3[i2] = this.a.c(this.a.d(0, x4Var.a(b)), this.a.b(x4Var3.a(b)));
        }
        return iArr3;
    }
}

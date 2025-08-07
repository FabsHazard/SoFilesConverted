package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* compiled from: DetectionResult */
final class z1 {
    private final k a;
    private final a2[] b;
    private a0 c;
    private final int d;

    z1(k kVar, a0 a0Var) {
        this.a = kVar;
        int a2 = kVar.a();
        this.d = a2;
        this.c = a0Var;
        this.b = new a2[(a2 + 2)];
    }

    private void a(a2 a2Var) throws a {
        if (a2Var != null) {
            try {
                ((b2) a2Var).a(this.a);
            } catch (ClassCastException unused) {
                throw a.a();
            }
        }
    }

    private int b() {
        c();
        return d() + e();
    }

    private void c() {
        a2[] a2VarArr = this.b;
        a2 a2Var = a2VarArr[0];
        if (a2Var != null && a2VarArr[this.d + 1] != null) {
            x0[] b2 = a2Var.b();
            x0[] b3 = this.b[this.d + 1].b();
            for (int i = 0; i < b2.length; i++) {
                x0 x0Var = b2[i];
                if (!(x0Var == null || b3[i] == null || x0Var.c() != b3[i].c())) {
                    for (int i2 = 1; i2 <= this.d; i2++) {
                        x0 x0Var2 = this.b[i2].b()[i];
                        if (x0Var2 != null) {
                            x0Var2.b(b2[i].c());
                            if (!x0Var2.g()) {
                                this.b[i2].b()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int d() {
        a2 a2Var = this.b[0];
        if (a2Var == null) {
            return 0;
        }
        x0[] b2 = a2Var.b();
        int i = 0;
        for (int i2 = 0; i2 < b2.length; i2++) {
            x0 x0Var = b2[i2];
            if (x0Var != null) {
                int c2 = x0Var.c();
                int i3 = 0;
                for (int i4 = 1; i4 < this.d + 1 && i3 < 2; i4++) {
                    x0 x0Var2 = this.b[i4].b()[i2];
                    if (x0Var2 != null) {
                        i3 = a(c2, i3, x0Var2);
                        if (!x0Var2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    private int e() {
        a2 a2Var = this.b[this.d + 1];
        if (a2Var == null) {
            return 0;
        }
        x0[] b2 = a2Var.b();
        int i = 0;
        for (int i2 = 0; i2 < b2.length; i2++) {
            x0 x0Var = b2[i2];
            if (x0Var != null) {
                int c2 = x0Var.c();
                int i3 = 0;
                for (int i4 = this.d + 1; i4 > 0 && i3 < 2; i4--) {
                    x0 x0Var2 = this.b[i4].b()[i2];
                    if (x0Var2 != null) {
                        i3 = a(c2, i3, x0Var2);
                        if (!x0Var2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.a.b();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.a.c();
    }

    /* access modifiers changed from: package-private */
    public a0 i() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public a2[] j() throws a {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = 928;
        while (true) {
            int a2 = a();
            if (a2 > 0 && a2 < i) {
                i = a2;
            }
        }
        return this.b;
    }

    public String toString() {
        a2[] a2VarArr = this.b;
        a2 a2Var = a2VarArr[0];
        if (a2Var == null) {
            a2Var = a2VarArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        int i = 0;
        while (i < a2Var.b().length) {
            try {
                formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    a2 a2Var2 = this.b[i2];
                    if (a2Var2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        x0 x0Var = a2Var2.b()[i];
                        if (x0Var == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(x0Var.c()), Integer.valueOf(x0Var.e())});
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
                i++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
        throw th;
    }

    private int a() {
        int b2 = b();
        if (b2 == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            x0[] b3 = this.b[i].b();
            for (int i2 = 0; i2 < b3.length; i2++) {
                x0 x0Var = b3[i2];
                if (x0Var != null && !x0Var.g()) {
                    a(i, i2, b3);
                }
            }
        }
        return b2;
    }

    private static int a(int i, int i2, x0 x0Var) {
        if (x0Var == null || x0Var.g()) {
            return i2;
        }
        if (!x0Var.a(i)) {
            return i2 + 1;
        }
        x0Var.b(i);
        return 0;
    }

    private void a(int i, int i2, x0[] x0VarArr) {
        x0 x0Var = x0VarArr[i2];
        x0[] b2 = this.b[i - 1].b();
        a2 a2Var = this.b[i + 1];
        x0[] b3 = a2Var != null ? a2Var.b() : b2;
        x0[] x0VarArr2 = new x0[14];
        x0VarArr2[2] = b2[i2];
        x0VarArr2[3] = b3[i2];
        int i3 = 0;
        if (i2 > 0) {
            int i4 = i2 - 1;
            x0VarArr2[0] = x0VarArr[i4];
            x0VarArr2[4] = b2[i4];
            x0VarArr2[5] = b3[i4];
        }
        if (i2 > 1) {
            int i5 = i2 - 2;
            x0VarArr2[8] = x0VarArr[i5];
            x0VarArr2[10] = b2[i5];
            x0VarArr2[11] = b3[i5];
        }
        if (i2 < x0VarArr.length - 1) {
            int i6 = i2 + 1;
            x0VarArr2[1] = x0VarArr[i6];
            x0VarArr2[6] = b2[i6];
            x0VarArr2[7] = b3[i6];
        }
        if (i2 < x0VarArr.length - 2) {
            int i7 = i2 + 2;
            x0VarArr2[9] = x0VarArr[i7];
            x0VarArr2[12] = b2[i7];
            x0VarArr2[13] = b3[i7];
        }
        while (i3 < 14 && !a(x0Var, x0VarArr2[i3])) {
            i3++;
        }
    }

    private static boolean a(x0 x0Var, x0 x0Var2) {
        if (x0Var2 == null || !x0Var2.g() || x0Var2.a() != x0Var.a()) {
            return false;
        }
        x0Var.b(x0Var2.c());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(a0 a0Var) {
        this.c = a0Var;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, a2 a2Var) {
        this.b[i] = a2Var;
    }

    /* access modifiers changed from: package-private */
    public a2 a(int i) {
        return this.b[i];
    }
}

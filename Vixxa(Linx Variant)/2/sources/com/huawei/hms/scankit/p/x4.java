package com.huawei.hms.scankit.p;

/* compiled from: ModulusPoly */
final class x4 {
    private final w4 a;
    private final int[] b;

    x4(w4 w4Var, int[] iArr) {
        if (iArr.length != 0) {
            this.a = w4Var;
            int length = iArr.length;
            int i = 1;
            if (length <= 1 || iArr[0] != 0) {
                this.b = iArr;
                return;
            }
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.b = new int[]{0};
                return;
            }
            int i2 = length - i;
            int[] iArr2 = new int[i2];
            this.b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public x4 c(x4 x4Var) {
        if (!this.a.equals(x4Var.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (x4Var.b()) {
            return this;
        } else {
            return a(x4Var.c());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int a2 = a(); a2 >= 0; a2--) {
            int b2 = b(a2);
            if (b2 != 0) {
                if (b2 < 0) {
                    sb.append(" - ");
                    b2 = -b2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (a2 == 0 || b2 != 1) {
                    sb.append(b2);
                }
                if (a2 != 0) {
                    if (a2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(a2);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int a(int i) {
        if (i == 0) {
            return b(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int a2 : this.b) {
                i2 = this.a.a(i2, a2);
            }
            return i2;
        }
        int[] iArr = this.b;
        int i3 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            w4 w4Var = this.a;
            i3 = w4Var.a(w4Var.c(i, i3), this.b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public x4 b(x4 x4Var) {
        if (!this.a.equals(x4Var.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b() || x4Var.b()) {
            return this.a.c();
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = x4Var.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    w4 w4Var = this.a;
                    iArr3[i4] = w4Var.a(iArr3[i4], w4Var.c(i2, iArr2[i3]));
                }
            }
            return new x4(this.a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public x4 c() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.a.d(0, this.b[i]);
        }
        return new x4(this.a, iArr);
    }

    /* access modifiers changed from: package-private */
    public x4 c(int i) {
        if (i == 0) {
            return this.a.c();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.c(this.b[i2], i);
        }
        return new x4(this.a, iArr);
    }

    /* access modifiers changed from: package-private */
    public x4 a(x4 x4Var) {
        if (!this.a.equals(x4Var.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (b()) {
            return x4Var;
        } else {
            if (x4Var.b()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = x4Var.b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = this.a.a(iArr2[i - length], iArr[i]);
            }
            return new x4(this.a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public x4 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.a.c();
        } else {
            int length = this.b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.c(this.b[i3], i2);
            }
            return new x4(this.a, iArr);
        }
    }
}

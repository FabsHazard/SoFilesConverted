package com.huawei.hms.scankit.p;

/* compiled from: GenericGFPoly */
final class p3 {
    private final o3 a;
    private final int[] b;

    p3(o3 o3Var, int[] iArr) {
        if (iArr.length != 0) {
            this.a = o3Var;
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
    public int[] a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b2 = b(); b2 >= 0; b2--) {
            int b3 = b(b2);
            if (b3 != 0) {
                if (b3 < 0) {
                    sb.append(" - ");
                    b3 = -b3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b2 == 0 || b3 != 1) {
                    int c = this.a.c(b3);
                    if (c == 0) {
                        sb.append('1');
                    } else if (c == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(c);
                    }
                }
                if (b2 != 0) {
                    if (b2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b2);
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
                i2 = o3.a(i2, a2);
            }
            return i2;
        }
        int[] iArr = this.b;
        int i3 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = o3.a(this.a.c(i, i3), this.b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public p3 c(p3 p3Var) {
        if (!this.a.equals(p3Var.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c() || p3Var.c()) {
            return this.a.d();
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = p3Var.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = o3.a(iArr3[i4], this.a.c(i2, iArr2[i3]));
                }
            }
            return new p3(this.a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public p3[] b(p3 p3Var) {
        if (!this.a.equals(p3Var.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!p3Var.c()) {
            p3 d = this.a.d();
            int b2 = this.a.b(p3Var.b(p3Var.b()));
            p3 p3Var2 = this;
            while (p3Var2.b() >= p3Var.b() && !p3Var2.c()) {
                int b3 = p3Var2.b() - p3Var.b();
                int c = this.a.c(p3Var2.b(p3Var2.b()), b2);
                p3 a2 = p3Var.a(b3, c);
                d = d.a(this.a.b(b3, c));
                p3Var2 = p3Var2.a(a2);
            }
            return new p3[]{d, p3Var2};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    /* access modifiers changed from: package-private */
    public p3 a(p3 p3Var) {
        if (!this.a.equals(p3Var.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c()) {
            return p3Var;
        } else {
            if (p3Var.c()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = p3Var.b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = o3.a(iArr2[i - length], iArr[i]);
            }
            return new p3(this.a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public p3 c(int i) {
        if (i == 0) {
            return this.a.d();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.c(this.b[i2], i);
        }
        return new p3(this.a, iArr);
    }

    /* access modifiers changed from: package-private */
    public p3 a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.a.d();
        } else {
            int length = this.b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.c(this.b[i3], i2);
            }
            return new p3(this.a, iArr);
        }
    }
}

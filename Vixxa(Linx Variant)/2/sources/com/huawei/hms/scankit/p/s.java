package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: BitMatrix */
public final class s implements Cloneable {
    private final int a;
    private final int b;
    private final int c;
    private final int[] d;

    public s(int i) {
        this(i, i);
    }

    public void a(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (w7.a(this.d, i3)) {
            int[] iArr = this.d;
            iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
        }
    }

    public boolean b(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (!w7.a(this.d, i3) || ((this.d[i3] >>> (i & 31)) & 1) == 0) {
            return false;
        }
        return true;
    }

    public void c(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (w7.a(this.d, i3)) {
            int[] iArr = this.d;
            iArr[i3] = (1 << (i & 31)) | iArr[i3];
        }
    }

    public s d() {
        int[] iArr = new int[this.d.length];
        int i = 0;
        while (true) {
            int[] iArr2 = this.d;
            if (i >= iArr2.length) {
                return new s(this.a, this.b, this.c, iArr);
            }
            iArr[i] = ~iArr2[i];
            i++;
        }
    }

    public int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (this.a == sVar.a && this.b == sVar.b && this.c == sVar.c && Arrays.equals(this.d, sVar.d)) {
            return true;
        }
        return false;
    }

    public void f() {
        int e = e();
        int c2 = c();
        r rVar = new r(e);
        r rVar2 = new r(e);
        for (int i = 0; i < (c2 + 1) / 2; i++) {
            rVar = a(i, rVar);
            int i2 = (c2 - 1) - i;
            rVar2 = a(i2, rVar2);
            rVar.h();
            rVar2.h();
            b(i, rVar2);
            b(i2, rVar);
        }
    }

    public int hashCode() {
        int i = this.a;
        return (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public s(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = i;
        this.b = i2;
        int i3 = (i + 31) / 32;
        this.c = i3;
        this.d = new int[(i3 * i2)];
    }

    public void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    public void b(int i, r rVar) {
        int[] d2 = rVar.d();
        int[] iArr = this.d;
        int i2 = this.c;
        System.arraycopy(d2, 0, iArr, i * i2, i2);
    }

    public int c() {
        return this.b;
    }

    /* renamed from: b */
    public s clone() {
        return new s(this.a, this.b, this.c, (int[]) this.d.clone());
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.b || i5 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public s(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }

    public r a(int i, r rVar) {
        if (rVar == null || rVar.e() < this.a) {
            rVar = new r(this.a);
        } else {
            rVar.a();
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            rVar.b(i3 * 32, this.d[i2 + i3]);
        }
        return rVar;
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                sb.append(b(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}

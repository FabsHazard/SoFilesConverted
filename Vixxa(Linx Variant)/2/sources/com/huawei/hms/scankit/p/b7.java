package com.huawei.hms.scankit.p;

import java.util.LinkedList;
import java.util.Locale;

/* compiled from: State */
final class b7 {
    static final b7 e = new b7(i7.b, 0, 0, 0);
    private final int a;
    private final i7 b;
    private final int c;
    private final int d;

    private b7(i7 i7Var, int i, int i2, int i3) {
        this.b = i7Var;
        this.a = i;
        this.c = i2;
        this.d = i3;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.a;
    }

    public String toString() {
        String[] strArr = c4.b;
        if (w7.a(strArr, this.a)) {
            return String.format(Locale.ENGLISH, "%s bits=%d bytes=%d", new Object[]{strArr[this.a], Integer.valueOf(this.d), Integer.valueOf(this.c)});
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* access modifiers changed from: package-private */
    public b7 a(int i, int i2) {
        int i3 = this.d;
        i7 i7Var = this.b;
        int i4 = this.a;
        if (i != i4) {
            int i5 = c4.c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            i7Var = i7Var.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new b7(i7Var.a(i2, i8), i, 0, i3 + i8);
    }

    /* access modifiers changed from: package-private */
    public b7 b(int i, int i2) {
        i7 i7Var = this.b;
        int i3 = this.a;
        int i4 = i3 == 2 ? 4 : 5;
        if (i3 >= 0) {
            int[][] iArr = c4.e;
            if (i3 < iArr.length && i > 0) {
                int[] iArr2 = iArr[i3];
                if (i < iArr2.length) {
                    i7Var = i7Var.a(iArr2[i], i4);
                }
            }
        }
        return new b7(i7Var.a(i2, 5), this.a, 0, this.d + i4 + 5);
    }

    /* access modifiers changed from: package-private */
    public b7 a(int i) {
        i7 i7Var = this.b;
        int i2 = this.a;
        int i3 = this.d;
        if (i2 == 4 || i2 == 2) {
            int i4 = c4.c[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            i7Var = i7Var.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.c;
        b7 b7Var = new b7(i7Var, i2, i7 + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return b7Var.c == 2078 ? b7Var.b(i + 1) : b7Var;
    }

    /* access modifiers changed from: package-private */
    public b7 b(int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return this;
        }
        return new b7(this.b.b(i - i2, i2), this.a, 0, this.d);
    }

    /* access modifiers changed from: package-private */
    public boolean a(b7 b7Var) {
        int i;
        int i2 = this.d + (c4.c[this.a][b7Var.a] >> 16);
        int i3 = b7Var.c;
        if (i3 > 0 && ((i = this.c) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= b7Var.d;
    }

    /* access modifiers changed from: package-private */
    public r a(byte[] bArr) {
        LinkedList<i7> linkedList = new LinkedList<>();
        for (i7 i7Var = b(bArr.length).b; i7Var != null; i7Var = i7Var.a()) {
            linkedList.addFirst(i7Var);
        }
        r rVar = new r();
        for (i7 a2 : linkedList) {
            a2.a(rVar, bArr);
        }
        return rVar;
    }
}

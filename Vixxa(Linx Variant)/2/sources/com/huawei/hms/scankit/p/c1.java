package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.a8;

/* compiled from: DataBlock */
final class c1 {
    private final int a;
    private final byte[] b;

    private c1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static c1[] a(byte[] bArr, a8 a8Var, c3 c3Var) {
        if (bArr.length == a8Var.l()) {
            a8.b a2 = a8Var.a(c3Var);
            a8.a[] a3 = a2.a();
            int i = 0;
            for (a8.a a4 : a3) {
                i += a4.a();
            }
            c1[] c1VarArr = new c1[i];
            int i2 = 0;
            for (a8.a aVar : a3) {
                int i3 = 0;
                while (i3 < aVar.a()) {
                    int b2 = aVar.b();
                    c1VarArr[i2] = new c1(b2, new byte[(a2.b() + b2)]);
                    i3++;
                    i2++;
                }
            }
            int length = c1VarArr[0].b.length;
            int i4 = i - 1;
            while (i4 >= 0 && c1VarArr[i4].b.length != length) {
                i4--;
            }
            int i5 = i4 + 1;
            int b3 = length - a2.b();
            int i6 = 0;
            for (int i7 = 0; i7 < b3; i7++) {
                int i8 = 0;
                while (i8 < i2) {
                    c1VarArr[i8].b[i7] = bArr[i6];
                    i8++;
                    i6++;
                }
            }
            int i9 = i5;
            while (i9 < i2) {
                c1VarArr[i9].b[b3] = bArr[i6];
                i9++;
                i6++;
            }
            int length2 = c1VarArr[0].b.length;
            while (b3 < length2) {
                int i10 = 0;
                while (i10 < i2) {
                    c1VarArr[i10].b[i10 < i5 ? b3 : b3 + 1] = bArr[i6];
                    i10++;
                    i6++;
                }
                b3++;
            }
            return c1VarArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public byte[] a() {
        return this.b;
    }
}

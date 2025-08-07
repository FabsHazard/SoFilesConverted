package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.b8;

/* compiled from: DataBlock */
final class d1 {
    private final int a;
    private final byte[] b;

    private d1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static d1[] a(byte[] bArr, b8 b8Var, b3 b3Var) {
        if (bArr.length == b8Var.e()) {
            b8.b a2 = b8Var.a(b3Var);
            b8.a[] a3 = a2.a();
            int i = 0;
            for (b8.a a4 : a3) {
                i += a4.a();
            }
            d1[] d1VarArr = new d1[i];
            int i2 = 0;
            for (b8.a aVar : a3) {
                int i3 = 0;
                while (i3 < aVar.a()) {
                    int b2 = aVar.b();
                    d1VarArr[i2] = new d1(b2, new byte[(a2.b() + b2)]);
                    i3++;
                    i2++;
                }
            }
            int length = d1VarArr[0].b.length;
            int i4 = i - 1;
            while (i4 >= 0 && d1VarArr[i4].b.length != length) {
                i4--;
            }
            return a(d1VarArr, bArr, length, a2, i2, i4 + 1);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.a;
    }

    private static d1[] a(d1[] d1VarArr, byte[] bArr, int i, b8.b bVar, int i2, int i3) {
        int b2 = i - bVar.b();
        int i4 = 0;
        for (int i5 = 0; i5 < b2; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                d1VarArr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        int i7 = i3;
        while (i7 < i2) {
            d1VarArr[i7].b[b2] = bArr[i4];
            i7++;
            i4++;
        }
        int length = d1VarArr[0].b.length;
        while (b2 < length) {
            int i8 = 0;
            while (i8 < i2) {
                int i9 = i8 < i3 ? b2 : b2 + 1;
                if (i8 < 0 || i8 >= d1VarArr.length || !w7.a(d1VarArr[i8].b, i9) || !w7.a(bArr, i4)) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                d1VarArr[i8].b[i9] = bArr[i4];
                i8++;
                i4++;
            }
            b2++;
        }
        return d1VarArr;
    }

    /* access modifiers changed from: package-private */
    public byte[] a() {
        return this.b;
    }
}

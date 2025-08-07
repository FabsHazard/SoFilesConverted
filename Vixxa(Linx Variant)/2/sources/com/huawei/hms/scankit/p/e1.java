package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.z7;

/* compiled from: DataBlock */
final class e1 {
    private final int a;
    private final byte[] b;

    private e1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static e1[] a(byte[] bArr, z7 z7Var) {
        z7.c d = z7Var.d();
        z7.b[] a2 = d.a();
        int i = 0;
        for (z7.b a3 : a2) {
            i += a3.a();
        }
        e1[] e1VarArr = new e1[i];
        int i2 = 0;
        for (z7.b bVar : a2) {
            int i3 = 0;
            while (i3 < bVar.a()) {
                int b2 = bVar.b();
                e1VarArr[i2] = new e1(b2, new byte[(d.b() + b2)]);
                i3++;
                i2++;
            }
        }
        int length = e1VarArr[0].b.length - d.b();
        int i4 = length - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = 0;
            while (i7 < i2) {
                e1VarArr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        boolean z = z7Var.h() == 24;
        int i8 = z ? 8 : i2;
        int i9 = 0;
        while (i9 < i8) {
            e1VarArr[i9].b[i4] = bArr[i5];
            i9++;
            i5++;
        }
        int length2 = e1VarArr[0].b.length;
        while (length < length2) {
            int i10 = 0;
            while (i10 < i2) {
                int i11 = z ? (i10 + 8) % i2 : i10;
                e1VarArr[i11].b[(!z || i11 <= 7) ? length : length - 1] = bArr[i5];
                i10++;
                i5++;
            }
            length++;
        }
        if (i5 == bArr.length) {
            return e1VarArr;
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

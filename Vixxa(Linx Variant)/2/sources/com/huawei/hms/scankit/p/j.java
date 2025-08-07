package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix */
public final class j {
    private final l[] a;
    private int b;
    private final int c;
    private final int d;

    j(int i, int i2) {
        this.a = new l[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.a[i3] = new l(((i2 + 4) * 17) + 1);
        }
        this.d = i2 * 17;
        this.c = i;
        this.b = -1;
    }

    /* access modifiers changed from: package-private */
    public l a() {
        int i = this.b;
        if (i >= 0) {
            l[] lVarArr = this.a;
            if (i < lVarArr.length) {
                return lVarArr[i];
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.b++;
    }

    public byte[][] a(int i, int i2) {
        int i3 = this.c * i2;
        int[] iArr = new int[2];
        iArr[1] = this.d * i;
        iArr[0] = i3;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.a[i4 / i2].a(i);
        }
        return bArr;
    }
}

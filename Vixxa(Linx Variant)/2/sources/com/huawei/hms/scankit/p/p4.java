package com.huawei.hms.scankit.p;

import kotlin.UByte;

/* compiled from: LuminanceSource */
public abstract class p4 {
    private final int a;
    private final int b;

    protected p4(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract p4 a(int i, int i2, int i3, int i4);

    public abstract byte[] a(int i, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.a;
    }

    public final String toString() {
        int i = this.a;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArr = a(i2, bArr);
            for (int i3 = 0; i3 < this.a; i3++) {
                byte b2 = bArr[i3] & UByte.MAX_VALUE;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}

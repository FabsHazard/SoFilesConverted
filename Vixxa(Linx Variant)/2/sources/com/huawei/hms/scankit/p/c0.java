package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ByteMatrix */
public final class c0 {
    private final byte[][] a;
    private final int b;
    private final int c;

    public c0(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.b = i;
        this.c = i2;
    }

    public byte a(int i, int i2) {
        if (w7.a(this.a, i2) && w7.a(this.a[i2], i)) {
            return this.a[i2][i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            byte[] bArr = this.a[i];
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b2 = bArr[i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append(10);
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.a;
    }

    public void a(int i, int i2, int i3) {
        if (!w7.a(this.a, i2) || !w7.a(this.a[i2], i)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.a[i2][i] = (byte) i3;
    }

    public void a(int i, int i2, boolean z) {
        if (!w7.a(this.a, i2) || !w7.a(this.a[i2], i)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.a[i2][i] = z ? (byte) 1 : 0;
    }

    public void a(byte b2) {
        for (byte[] fill : this.a) {
            Arrays.fill(fill, b2);
        }
    }
}

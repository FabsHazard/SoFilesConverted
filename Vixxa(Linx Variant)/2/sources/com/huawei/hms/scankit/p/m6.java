package com.huawei.hms.scankit.p;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* compiled from: RGBLuminanceSource */
public final class m6 extends p4 {
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public m6(int i, int i2, ByteBuffer byteBuffer) {
        super(i, i2);
        this.d = i;
        this.e = i2;
        this.f = 0;
        this.g = 0;
        byte[] array = byteBuffer.array();
        int i3 = i * i2;
        this.c = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 4;
            if ((array[i5 + 3] & UByte.MAX_VALUE) == 0) {
                this.c[i4] = -1;
            } else {
                this.c[i4] = (byte) ((((((array[i5] & UByte.MAX_VALUE) * 306) + ((array[i5 + 1] & UByte.MAX_VALUE) * 601)) + ((array[i5 + 2] & UByte.MAX_VALUE) * 117)) + 512) >> 10);
            }
        }
    }

    public byte[] a(int i, byte[] bArr) {
        if (i < 0 || i >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int c2 = c();
        if (bArr == null || bArr.length < c2) {
            bArr = new byte[c2];
        }
        System.arraycopy(this.c, ((i + this.g) * this.d) + this.f, bArr, 0, c2);
        return bArr;
    }

    public byte[] b() {
        int c2 = c();
        int a = a();
        int i = this.d;
        if (c2 == i && a == this.e) {
            return this.c;
        }
        int i2 = c2 * a;
        byte[] bArr = new byte[i2];
        int i3 = (this.g * i) + this.f;
        if (c2 == i) {
            System.arraycopy(this.c, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < a; i4++) {
            System.arraycopy(this.c, i3, bArr, i4 * c2, c2);
            i3 += this.d;
        }
        return bArr;
    }

    public p4 a(int i, int i2, int i3, int i4) {
        return new m6(this.c, this.d, this.e, this.f + i, this.g + i2, i3, i4);
    }

    private m6(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }
}

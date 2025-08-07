package com.huawei.hms.scankit.p;

import kotlin.UByte;

/* compiled from: BitSource */
public final class w {
    private final byte[] a;
    private int b;
    private int c;

    public w(byte[] bArr) {
        this.a = bArr;
    }

    public int a(int i) {
        if (i < 1 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.c;
        byte b2 = 0;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            int i6 = w7.a(this.a, this.b) ? (((255 >> (8 - i4)) << i5) & this.a[this.b]) >> i5 : 0;
            i -= i4;
            int i7 = this.c + i4;
            this.c = i7;
            if (i7 == 8) {
                this.c = 0;
                this.b++;
            }
            b2 = i6;
        }
        if (i > 0) {
            while (i >= 8) {
                if (w7.a(this.a, this.b)) {
                    b2 = (b2 << 8) | (this.a[this.b] & UByte.MAX_VALUE);
                }
                this.b++;
                i -= 8;
            }
            if (i > 0) {
                int i8 = 8 - i;
                int i9 = (255 >> i8) << i8;
                if (w7.a(this.a, this.b)) {
                    b2 = ((i9 & this.a[this.b]) >> i8) | (b2 << i);
                }
                this.c += i;
            }
        }
        return b2;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public int a() {
        return ((this.a.length - this.b) * 8) - this.c;
    }
}

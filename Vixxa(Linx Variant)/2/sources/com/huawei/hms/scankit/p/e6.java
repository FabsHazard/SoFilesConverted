package com.huawei.hms.scankit.p;

/* compiled from: PlanarYUVLuminanceSource */
public final class e6 extends p4 {
    private final byte[] c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public e6(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        if (z) {
            a(i5, i6);
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
        int i4 = 0;
        if (c2 == i) {
            try {
                System.arraycopy(this.c, i3, bArr, 0, i2);
                return bArr;
            } catch (ArrayIndexOutOfBoundsException | Exception unused) {
                return null;
            }
        } else {
            while (i4 < a) {
                try {
                    System.arraycopy(this.c, i3, bArr, i4 * c2, c2);
                    i3 += this.d;
                    i4++;
                } catch (ArrayIndexOutOfBoundsException | Exception unused2) {
                    return null;
                }
            }
            return bArr;
        }
    }

    public p4 a(int i, int i2, int i3, int i4) {
        return new e6(this.c, this.d, this.e, this.f + i, this.g + i2, i3, i4, false);
    }

    private void a(int i, int i2) {
        byte[] bArr = this.c;
        int i3 = (this.g * this.d) + this.f;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                if (w7.a(bArr, i7) && w7.a(bArr, i6)) {
                    byte b = bArr[i7];
                    bArr[i7] = bArr[i6];
                    bArr[i6] = b;
                }
                i7++;
                i6--;
            }
            i4++;
            i3 += this.d;
        }
    }
}

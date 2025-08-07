package com.huawei.hms.scankit.p;

import kotlin.UByte;

/* compiled from: BinaryBitmap */
public final class p {
    private final o a;
    private s b;

    public p(o oVar) {
        if (oVar != null) {
            this.a = oVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public r a(int i, int i2) throws a {
        int i3;
        int e = e();
        if (e >= 45) {
            r rVar = new r(e);
            byte[] bArr = new byte[e];
            a().c().a(i, bArr);
            int[] iArr = new int[e];
            int[] iArr2 = new int[e];
            int i4 = bArr[0] & UByte.MAX_VALUE;
            iArr[0] = i4;
            iArr2[0] = i4 * i4;
            for (int i5 = 1; i5 < e; i5++) {
                iArr[i5] = iArr[i5 - 1] + (bArr[i5] & UByte.MAX_VALUE);
            }
            if (i2 != 0) {
                return a(45, e, iArr, iArr2, bArr, 22);
            }
            int i6 = 23;
            while (true) {
                i3 = e - 22;
                if (i6 >= i3) {
                    break;
                }
                if ((bArr[i6] & UByte.MAX_VALUE) + 5 < (iArr[i6 + 22] - iArr[i6 - 23]) / 45) {
                    rVar.g(i6);
                }
                i6++;
            }
            if (rVar.b(23)) {
                rVar.c(0, 23);
            }
            if (rVar.b(e - 23)) {
                rVar.c(i3, e);
            }
            return rVar;
        }
        throw a.a();
    }

    public s b() throws a {
        if (this.b == null) {
            this.b = this.a.a();
        }
        return this.b;
    }

    public int c() {
        return this.a.b();
    }

    public byte[] d() {
        return this.a.c().b();
    }

    public int e() {
        return this.a.d();
    }

    private r a(int i, int i2, int[] iArr, int[] iArr2, byte[] bArr, int i3) {
        int i4;
        int i5 = i;
        int i6 = i2;
        r rVar = new r(i6);
        for (int i7 = 1; i7 < i6; i7++) {
            int i8 = iArr2[i7 - 1];
            byte b2 = bArr[i7];
            iArr2[i7] = i8 + ((b2 & UByte.MAX_VALUE) * (b2 & UByte.MAX_VALUE));
        }
        int i9 = i3 + 1;
        int i10 = i9;
        while (true) {
            i4 = i6 - i3;
            if (i10 >= i4) {
                break;
            }
            int i11 = i10 + i3;
            int i12 = (i10 - i3) - 1;
            double d = (double) (iArr[i11] - iArr[i12]);
            double d2 = (double) i5;
            if (((double) (bArr[i10] & UByte.MAX_VALUE)) <= (d / d2) * ((((double) 0.5f) * (Math.sqrt((((double) (iArr2[i11] - iArr2[i12])) - ((d * d) / d2)) / ((double) (i5 - 1))) / ((double) 127))) + 1.0d)) {
                rVar.g(i10);
            }
            i10++;
        }
        if (rVar.b(i9)) {
            rVar.c(0, i9);
        }
        if (rVar.b(i4 - 1)) {
            rVar.c(i4, i6);
        }
        return rVar;
    }

    public r a(int i, r rVar) throws a {
        return this.a.a(i, rVar);
    }

    public void a(s sVar) {
        this.b = sVar;
    }

    public p a(int i, int i2, int i3, int i4) {
        return new p(this.a.a(this.a.c().a(i, i2, i3, i4)));
    }

    public o a() {
        return this.a;
    }
}

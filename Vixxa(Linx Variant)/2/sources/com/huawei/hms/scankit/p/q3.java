package com.huawei.hms.scankit.p;

import kotlin.UByte;

/* compiled from: GlobalHistogramBinarizer */
public class q3 extends o {
    private static final byte[] d = new byte[0];
    private byte[] b = d;
    private final int[] c = new int[32];

    public q3(p4 p4Var) {
        super(p4Var);
    }

    public r a(int i, r rVar) throws a {
        p4 c2 = c();
        int c3 = c2.c();
        if (rVar == null || rVar.e() < c3) {
            rVar = new r(c3);
        } else {
            rVar.a();
        }
        a(c3);
        byte[] a = c2.a(i, this.b);
        int[] iArr = this.c;
        for (int i2 = 0; i2 < c3; i2++) {
            int i3 = (a[i2] & UByte.MAX_VALUE) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int a2 = a(iArr, false);
        if (c3 < 3) {
            for (int i4 = 0; i4 < c3; i4++) {
                if ((a[i4] & UByte.MAX_VALUE) < a2) {
                    rVar.g(i4);
                }
            }
        } else {
            int i5 = 1;
            byte b2 = a[0] & UByte.MAX_VALUE;
            byte b3 = a[1] & UByte.MAX_VALUE;
            while (i5 < c3 - 1) {
                int i6 = i5 + 1;
                byte b4 = a[i6] & UByte.MAX_VALUE;
                if ((((b3 * 4) - b2) - b4) / 2 < a2) {
                    rVar.g(i5);
                }
                b2 = b3;
                i5 = i6;
                b3 = b4;
            }
        }
        return rVar;
    }

    public s a() throws a {
        p4 c2 = c();
        int c3 = c2.c();
        int a = c2.a();
        a(c3);
        int[] iArr = this.c;
        for (int i = 1; i < 5; i++) {
            byte[] a2 = c2.a((a * i) / 5, this.b);
            int i2 = (c3 * 4) / 5;
            for (int i3 = c3 / 5; i3 < i2; i3++) {
                int i4 = (a2[i3] & UByte.MAX_VALUE) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a3 = a(iArr, true);
        byte[] b2 = c2.b();
        int i5 = (c3 + 31) / 32;
        int[] iArr2 = new int[(i5 * a)];
        for (int i6 = 0; i6 < a; i6++) {
            int i7 = i6 * c3;
            for (int i8 = 0; i8 < c3; i8++) {
                if ((b2[i7 + i8] & UByte.MAX_VALUE) < a3) {
                    int i9 = (i6 * i5) + (i8 >> 5);
                    iArr2[i9] = iArr2[i9] | (1 << (i8 & 31));
                }
            }
        }
        return new s(c3, a, i5, iArr2);
    }

    public o a(p4 p4Var) {
        return new q3(p4Var);
    }

    private void a(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }

    private static int a(int[] iArr, boolean z) throws a {
        int length = iArr.length;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        int i12 = i3 - i6;
        if (i12 > length / 16) {
            int i13 = i3 - 1;
            int i14 = -1;
            int i15 = i13;
            while (i13 > i6) {
                int i16 = i13 - i6;
                int i17 = i16 * i16 * (i3 - i13) * (i2 - iArr[i13]);
                if (i17 > i14) {
                    i15 = i13;
                    i14 = i17;
                }
                i13--;
            }
            if (z) {
                if (i15 < 10 && i14 < 100000 && i12 < 10) {
                    z2 = true;
                }
                r3.t = z2;
            }
            return i15 << 3;
        }
        throw a.a();
    }
}

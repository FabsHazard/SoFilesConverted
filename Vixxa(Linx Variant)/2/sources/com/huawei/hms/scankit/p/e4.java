package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import kotlin.UByte;

/* compiled from: HybridBinarizer */
public final class e4 extends q3 {
    private static int f = 3;
    private static int g = 8;
    private static int h = 7;
    private static int i = 40;
    private static int j = 24;
    private s e;

    public e4(p4 p4Var) {
        super(p4Var);
        a(r3.n);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private void a(boolean z) {
        if (z) {
            f = 2;
            g = 4;
            h = 3;
            i = 20;
            return;
        }
        f = 3;
        g = 8;
        h = 7;
        i = 40;
    }

    public s a() throws a {
        s sVar = this.e;
        if (sVar != null) {
            return sVar;
        }
        p4 c = c();
        int c2 = c.c();
        int a = c.a();
        int i2 = i;
        if (c2 < i2 || a < i2) {
            this.e = super.a();
        } else {
            byte[] b = c.b();
            int i3 = f;
            int i4 = c2 >> i3;
            int i5 = h;
            if ((c2 & i5) != 0) {
                i4++;
            }
            int i6 = a >> i3;
            if ((i5 & a) != 0) {
                i6++;
            }
            int i7 = i6;
            this.e = a(b, i4, i7, c2, a, a(b, i4, i7, c2, a));
        }
        return this.e;
    }

    public o a(p4 p4Var) {
        return new e4(p4Var);
    }

    private static s a(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr) {
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i3;
        int i11 = i4;
        int[] iArr2 = new int[(i9 * i10)];
        for (int i12 = 0; i12 < i10; i12++) {
            int a = a(i12, 2, i10 - 3);
            for (int i13 = 0; i13 < i9; i13++) {
                int a2 = a(i13, 2, i9 - 3);
                int[] iArr3 = iArr[a + 2];
                int i14 = a2 + 2;
                int i15 = iArr3[i14];
                if (a == 2 && a2 == 2) {
                    i8 = 0;
                    i7 = 0;
                } else {
                    if (a == 2) {
                        i6 = 0;
                        i7 = iArr3[a2 - 3];
                        i8 = 0;
                    } else if (a2 == 2) {
                        i8 = iArr[a - 3][i14];
                        i7 = 0;
                    } else {
                        int[] iArr4 = iArr[a - 3];
                        int i16 = a2 - 3;
                        i6 = iArr4[i16];
                        int i17 = iArr4[i14];
                        i7 = iArr3[i16];
                        i8 = i17;
                    }
                    iArr2[(i12 * i9) + i13] = (((i15 + i6) - i8) - i7) / 25;
                }
                i6 = i7;
                iArr2[(i12 * i9) + i13] = (((i15 + i6) - i8) - i7) / 25;
            }
        }
        return new s(i11, i5, (i11 + 31) / 32, a(bArr, iArr2, i2, i3, i4, i5));
    }

    private static int[] a(byte[] bArr, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i4;
        int i8 = i5;
        int i9 = (i7 + 31) / 32;
        int i10 = i9 * i8;
        int[] iArr2 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr2[i11] = 0;
        }
        int i12 = g;
        for (int i13 = 0; i13 < i8; i13++) {
            int i14 = i13 / i12;
            for (int i15 = 0; i15 < i7; i15++) {
                if ((bArr[(i13 * i7) + i15] & UByte.MAX_VALUE) <= iArr[(i14 * i2) + (i15 / i12)] && (i6 = (i13 * i9) + (i15 / 32)) < i10) {
                    iArr2[i6] = iArr2[i6] | (1 << (i15 & 31));
                }
            }
        }
        return iArr2;
    }

    private static int[][] a(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = g;
        int i10 = i5 - i9;
        int i11 = i8 - i9;
        int[] iArr = new int[2];
        char c = 1;
        iArr[1] = i6;
        int i12 = 0;
        iArr[0] = i7;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int[] iArr3 = new int[2];
        iArr3[1] = i6;
        iArr3[0] = i7;
        int[][] iArr4 = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
        int i13 = 0;
        while (i13 < i7) {
            int i14 = i13 << f;
            if (i14 > i10) {
                i14 = i10;
            }
            int i15 = i12;
            int i16 = i15;
            while (i15 < i6) {
                int i17 = i15 << f;
                byte[] bArr2 = bArr;
                if (i17 > i11) {
                    i17 = i11;
                }
                int[] a = a(i17, i14, i8, bArr2);
                int i18 = a[i12];
                int i19 = a[c];
                int i20 = a[2];
                int i21 = i18 >> (f * 2);
                if (i20 - i19 <= j) {
                    i21 = i19 / 2;
                    if (i13 > 0 && i15 > 0) {
                        int[] iArr5 = iArr4[i13 - 1];
                        int i22 = i15 - 1;
                        int i23 = ((iArr5[i15] + (iArr4[i13][i22] * 2)) + iArr5[i22]) / 4;
                        if (i19 < i23) {
                            i21 = i23;
                        }
                    }
                }
                i16 += i21;
                iArr4[i13][i15] = i21;
                if (i13 == 0 && i15 == 0) {
                    iArr2[i13][i15] = i21;
                } else if (i13 == 0) {
                    iArr2[i13][i15] = i16;
                } else {
                    iArr2[i13][i15] = iArr2[i13 - 1][i15] + i16;
                }
                i15++;
                c = 1;
                i12 = 0;
            }
            byte[] bArr3 = bArr;
            i13++;
            c = 1;
            i12 = 0;
        }
        return iArr2;
    }

    private static int[] a(int i2, int i3, int i4, byte[] bArr) {
        int i5 = (i3 * i4) + i2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 255;
        while (i6 < g) {
            for (int i10 = 0; i10 < g; i10++) {
                byte b = bArr[i5 + i10] & UByte.MAX_VALUE;
                i7 += b;
                if (b < i9) {
                    i9 = b;
                }
                if (b > i8) {
                    i8 = b;
                }
            }
            if (i8 - i9 <= j) {
                i6++;
                i5 += i4;
            }
            while (true) {
                i6++;
                i5 += i4;
                if (i6 >= g) {
                    break;
                }
                for (int i11 = 0; i11 < g; i11++) {
                    i7 += bArr[i5 + i11] & UByte.MAX_VALUE;
                }
            }
            i6++;
            i5 += i4;
        }
        return new int[]{i7, i9, i8};
    }
}

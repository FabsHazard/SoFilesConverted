package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder */
final class m5 {
    private static final float[][] a;

    static {
        int i;
        int length = n5.b.length;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = length;
        a = (float[][]) Array.newInstance(Float.TYPE, iArr);
        int i2 = 0;
        while (true) {
            int[] iArr2 = n5.b;
            if (i2 < iArr2.length) {
                int i3 = iArr2[i2];
                int i4 = i3 & 1;
                int i5 = 0;
                while (i5 < 8) {
                    float f = 0.0f;
                    while (true) {
                        i = i3 & 1;
                        if (i != i4) {
                            break;
                        }
                        f += 1.0f;
                        i3 >>= 1;
                    }
                    a[i2][7 - i5] = f / 17.0f;
                    i5++;
                    i4 = i;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private static int a(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j2 = j << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j = j2 | ((long) i3);
            }
        }
        return (int) j;
    }

    private static int b(int[] iArr) {
        int a2 = s4.a(iArr);
        float[] fArr = new float[8];
        if (a2 > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = ((float) iArr[i]) / ((float) a2);
            }
        }
        float f = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = n5.b[i3];
                f = f2;
            }
            i3++;
        }
    }

    private static int c(int[] iArr) {
        int a2 = a(iArr);
        if (n5.a(a2) == -1) {
            return -1;
        }
        return a2;
    }

    static int d(int[] iArr) {
        int c = c(e(iArr));
        if (c != -1) {
            return c;
        }
        return b(iArr);
    }

    private static int[] e(int[] iArr) {
        float a2 = (float) s4.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            float f = (a2 / 34.0f) + ((((float) i3) * a2) / 17.0f);
            int i4 = iArr[i2];
            if (((float) (i + i4)) <= f) {
                i += i4;
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }
}

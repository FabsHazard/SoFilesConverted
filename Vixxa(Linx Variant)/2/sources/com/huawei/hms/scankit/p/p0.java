package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* compiled from: CodaBarReader */
public final class p0 extends g5 {
    public static final char[] e = "0123456789-$:/.+ABCD".toCharArray();
    public static final int[] f = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] g = {'A', 'B', 'C', 'D'};
    private final StringBuilder a = new StringBuilder(20);
    private int[] b = new int[80];
    private int c = 0;
    private int d;

    private int b() throws a {
        for (int i = 1; i < this.c; i += 2) {
            int b2 = b(i);
            if (b2 != -1 && a(g, e[b2])) {
                int i2 = 0;
                for (int i3 = i; i3 < i + 7; i3++) {
                    i2 += this.b[i3];
                }
                if (i == 1 || this.b[i - 1] >= i2 / 2) {
                    return i;
                }
            }
        }
        throw a.a();
    }

    private void c(int i) throws a {
        int i2 = 0;
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.a.length() - 1;
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = f[this.a.charAt(i4)];
            for (int i6 = 6; i6 >= 0; i6--) {
                int i7 = (i6 & 1) + ((i5 & 1) * 2);
                iArr[i7] = iArr[i7] + this.b[i3 + i6];
                iArr2[i7] = iArr2[i7] + 1;
                i5 >>= 1;
            }
            if (i4 >= length) {
                break;
            }
            i3 += 8;
            i4++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i8 = 0; i8 < 2; i8++) {
            fArr2[i8] = 0.0f;
            int i9 = i8 + 2;
            float f2 = ((float) iArr[i8]) / ((float) iArr2[i8]);
            int i10 = iArr[i9];
            int i11 = iArr2[i9];
            float f3 = (f2 + (((float) i10) / ((float) i11))) / 2.0f;
            fArr2[i9] = f3;
            fArr[i8] = f3;
            fArr[i9] = ((((float) i10) * 2.0f) + 1.5f) / ((float) i11);
        }
        int i12 = i;
        loop3:
        while (true) {
            int i13 = f[this.a.charAt(i2)];
            int i14 = 6;
            while (i14 >= 0) {
                int i15 = (i14 & 1) + ((i13 & 1) * 2);
                float f4 = (float) this.b[i12 + i14];
                if (f4 >= fArr2[i15] && f4 <= fArr[i15]) {
                    i13 >>= 1;
                    i14--;
                }
            }
            if (i2 < length) {
                i12 += 8;
                i2++;
            } else {
                return;
            }
        }
        throw a.a();
    }

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        Arrays.fill(this.b, 0);
        a(rVar);
        int[] a2 = a();
        int i2 = a2[0];
        int i3 = a2[1];
        for (int i4 = 0; i4 < this.a.length(); i4++) {
            StringBuilder sb = this.a;
            sb.setCharAt(i4, e[sb.charAt(i4)]);
        }
        char charAt = this.a.charAt(0);
        char[] cArr = g;
        if (a(cArr, charAt)) {
            StringBuilder sb2 = this.a;
            if (!a(cArr, sb2.charAt(sb2.length() - 1))) {
                throw a.a();
            } else if (this.a.length() > 3) {
                int i5 = this.d;
                for (int i6 = 0; i6 < i2; i6++) {
                    i5 += this.b[i6];
                }
                float f2 = (float) i5;
                while (i2 < i3 - 1) {
                    i5 += this.b[i2];
                    i2++;
                }
                float f3 = (float) i;
                return new s6(this.a.toString(), (byte[]) null, new u6[]{new u6(f2, f3), new u6((float) i5, f3)}, BarcodeFormat.CODABAR);
            } else {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    private int b(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i3 = i; i3 < i2; i3++) {
            hashSet.add(Integer.valueOf(iArr[i3]));
        }
        int i4 = 0;
        int i5 = 0;
        for (Integer intValue : hashSet) {
            i5 += intValue.intValue();
        }
        if (hashSet.size() > 0) {
            int size = i5 / hashSet.size();
            int i6 = 128;
            int i7 = 0;
            for (int i8 = 0; i8 < 7; i8++) {
                i6 >>= 1;
                if (iArr[i + i8] > size) {
                    i7 |= i6;
                }
            }
            while (true) {
                int[] iArr2 = f;
                if (i4 >= iArr2.length) {
                    break;
                } else if (iArr2[i4] == i7) {
                    return i4;
                } else {
                    i4++;
                }
            }
        }
        return -1;
    }

    private int[] a() throws a {
        int i;
        int b2 = b();
        int i2 = 0;
        this.a.setLength(0);
        int i3 = b2;
        while (true) {
            int b3 = b(i3);
            if (b3 != -1) {
                this.a.append((char) b3);
                i = i3 + 8;
                if ((this.a.length() <= 1 || !a(g, e[b3])) && i < this.c) {
                    i3 = i;
                }
            } else {
                throw a.a();
            }
        }
        int i4 = this.b[i3 + 7];
        for (int i5 = -8; i5 < -1; i5++) {
            i2 += this.b[i + i5];
        }
        if (i >= this.c || i4 >= i2 / 2) {
            c(b2);
            return new int[]{b2, i};
        }
        throw a.a();
    }

    private void a(r rVar) throws a {
        int i = 0;
        this.c = 0;
        int d2 = rVar.d(0);
        this.d = d2;
        int e2 = rVar.e();
        if (d2 < e2) {
            boolean z = true;
            while (d2 < e2) {
                if (rVar.b(d2) != z) {
                    i++;
                } else {
                    a(i);
                    z = !z;
                    i = 1;
                }
                d2++;
            }
            a(i);
            return;
        }
        throw a.a();
    }

    private void a(int i) throws a {
        try {
            int[] iArr = this.b;
            int i2 = this.c;
            iArr[i2] = i;
            int i3 = i2 + 1;
            this.c = i3;
            if (i3 >= iArr.length) {
                int[] iArr2 = new int[(i3 * 2)];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.b = iArr2;
            }
        } catch (NumberFormatException unused) {
            throw a.a();
        }
    }

    public static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}

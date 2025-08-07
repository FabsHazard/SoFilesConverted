package com.huawei.hms.scankit.p;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: UPCEReader */
public final class s7 extends q7 {
    private static final int[] i = {1, 1, 1, 1, 1, 1};
    public static final int[][] j = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] h = new int[4];

    private int b(r rVar, int[] iArr, int i2, int[][] iArr2) throws a {
        g5.a(rVar, i2, iArr);
        int length = iArr2.length;
        float f = 0.45f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float a = g5.a(iArr, iArr2[i4], 0.7f);
            if (a < f) {
                i3 = i4;
                f = a;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw a.a();
    }

    public boolean a(int i2, int i3, r rVar) {
        return rVar.a(i3, (i3 - i2) + i3, false, true);
    }

    /* access modifiers changed from: protected */
    public int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        StringBuilder sb2 = sb;
        int[] iArr2 = this.h;
        int i2 = 0;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e = rVar.e();
        int i3 = iArr[1];
        float f = 10000.0f;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        while (i4 < 6 && i3 < e) {
            int b = b(rVar, iArr2, i3, q7.g);
            sb2.append((char) ((b % 10) + 48));
            int i6 = i2;
            float f3 = 0.0f;
            while (true) {
                int[] iArr3 = q7.g[b];
                if (i6 >= iArr3.length) {
                    break;
                }
                f3 += (float) iArr3[i6];
                i6++;
            }
            float f4 = ((float) (((iArr2[i2] + iArr2[1]) + iArr2[2]) + iArr2[3])) / f3;
            if (f4 > f2) {
                f2 = f4;
            }
            if (f4 < f) {
                f = f4;
            }
            int length = iArr2.length;
            while (i2 < length) {
                i3 += iArr2[i2];
                i2++;
            }
            if (b >= 10) {
                i5 |= 1 << (5 - i4);
            }
            i4++;
            i2 = 0;
        }
        if (((double) (f2 / f)) <= 2.89d) {
            a(sb2, i5);
            return i3;
        }
        throw a.a();
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX:
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG:
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF:
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public int[] a(r rVar, int i2) throws a {
        return q7.a(rVar, i2, true, i);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str) throws a {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i2) throws a {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == j[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw a.a();
    }

    /* access modifiers changed from: package-private */
    public BarcodeFormat a() {
        return BarcodeFormat.UPC_E;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int[] iArr, int[] iArr2) throws a {
        int i2 = iArr[1];
        int i3 = iArr[0];
        double d = ((double) (i2 - i3)) / 3.0d;
        int i4 = iArr2[1];
        int i5 = iArr2[0];
        double d2 = ((double) (i4 - i5)) / 6.0d;
        if (((double) Math.abs(((int) Math.round(((double) (i4 - i3)) / (((double) ((i4 - i5) + (i2 - i3))) / 9.0d))) - 51)) > 10.200000000000001d || Math.abs(1.0d - (d / d2)) >= 0.2d) {
            return false;
        }
        return true;
    }
}

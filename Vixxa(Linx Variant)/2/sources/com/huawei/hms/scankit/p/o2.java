package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: EAN13Reader */
public final class o2 extends q7 {
    public static final int[] j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] h = new int[4];
    private String i = "";

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, r rVar) {
        return rVar.a(i3, (i3 - i2) + i3, false, false);
    }

    /* access modifiers changed from: protected */
    public int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e = rVar.e();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < e; i4++) {
            int a = q7.a(rVar, iArr2, i2, q7.g);
            sb.append((char) ((a % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (a >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        a(sb, i3);
        this.i = sb.substring(0, 1);
        int i6 = q7.a(rVar, i2, true, q7.d)[1];
        for (int i7 = 0; i7 < 6 && i6 < e; i7++) {
            sb.append((char) (q7.a(rVar, iArr2, i6, q7.f) + 48));
            for (int i8 : iArr2) {
                i6 += i8;
            }
        }
        if (a(sb)) {
            return i6;
        }
        throw a.a();
    }

    /* access modifiers changed from: package-private */
    public BarcodeFormat a() {
        return BarcodeFormat.EAN_13;
    }

    private static void a(StringBuilder sb, int i2) throws a {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == j[i3]) {
                sb.insert(0, (char) (i3 + 48));
                return;
            }
        }
        throw a.a();
    }

    private static boolean a(StringBuilder sb) {
        int i2;
        int charAt = sb.charAt(sb.length() - 1) - '0';
        int i3 = 0;
        for (int i4 = 0; i4 < sb.length() - 1; i4++) {
            if (i4 % 2 == 0) {
                i2 = sb.charAt(i4) - '0';
            } else {
                i2 = (sb.charAt(i4) - '0') * 3;
            }
            i3 += i2;
        }
        if ((i3 + charAt) % 10 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int[] iArr, int[] iArr2) throws a {
        int i2 = iArr2[1];
        int i3 = iArr[1];
        int i4 = iArr[0];
        int round = (int) Math.round(((double) (i2 - i4)) / (((double) ((i2 - iArr2[0]) + (i3 - i4))) / 6.0d));
        if (this.i.equals("0")) {
            if (((double) Math.abs(round - 95)) <= 18.05d || ((double) Math.abs(round - 113)) <= 21.47d) {
                return true;
            }
            return false;
        } else if (((double) Math.abs(round - 95)) <= 18.05d) {
            return true;
        } else {
            return false;
        }
    }
}

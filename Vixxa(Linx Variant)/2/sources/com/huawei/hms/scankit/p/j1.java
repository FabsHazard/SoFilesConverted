package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: DataMatrixWriter */
public final class j1 implements l8 {
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<u2, ?> map) {
        l2 l2Var;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        } else {
            e7 e7Var = e7.FORCE_SQUARE;
            l2 l2Var2 = null;
            int i3 = 4;
            if (map != null) {
                e7 e7Var2 = (e7) map.get(u2.DATA_MATRIX_SHAPE);
                if (e7Var2 != null) {
                    e7Var = e7Var2;
                }
                l2 l2Var3 = (l2) map.get(u2.MIN_SIZE);
                if (l2Var3 == null) {
                    l2Var3 = null;
                }
                l2 l2Var4 = (l2) map.get(u2.MAX_SIZE);
                if (l2Var4 != null) {
                    l2Var2 = l2Var4;
                }
                u2 u2Var = u2.MARGIN;
                if (map.containsKey(u2Var)) {
                    i3 = Integer.parseInt(map.get(u2Var).toString());
                }
                l2Var = l2Var2;
                l2Var2 = l2Var3;
            } else {
                l2Var = null;
            }
            String a = d4.a(str, e7Var, l2Var2, l2Var);
            d7 a2 = d7.a(a.length(), e7Var, l2Var2, l2Var, true);
            y1 y1Var = new y1(z2.a(a, a2), a2.f(), a2.e());
            y1Var.a();
            return a(y1Var, a2, i, i2, i3);
        }
    }

    private static s a(y1 y1Var, d7 d7Var, int i, int i2, int i3) {
        d7 d7Var2 = d7Var;
        int f = d7Var.f();
        int e = d7Var.e();
        c0 c0Var = new c0(d7Var.h(), d7Var.g());
        int i4 = 0;
        for (int i5 = 0; i5 < e; i5++) {
            if (i5 % d7Var2.e == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < d7Var.h(); i7++) {
                    c0Var.a(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < f; i9++) {
                if (i9 % d7Var2.d == 0) {
                    c0Var.a(i8, i4, true);
                    i8++;
                }
                y1 y1Var2 = y1Var;
                c0Var.a(i8, i4, y1Var.a(i9, i5));
                int i10 = i8 + 1;
                int i11 = d7Var2.d;
                if (i9 % i11 == i11 - 1) {
                    c0Var.a(i10, i4, i5 % 2 == 0);
                    i8 += 2;
                } else {
                    i8 = i10;
                }
            }
            y1 y1Var3 = y1Var;
            int i12 = i4 + 1;
            int i13 = d7Var2.e;
            if (i5 % i13 == i13 - 1) {
                int i14 = 0;
                for (int i15 = 0; i15 < d7Var.h(); i15++) {
                    c0Var.a(i14, i12, true);
                    i14++;
                }
                i4 += 2;
            } else {
                i4 = i12;
            }
        }
        return a(c0Var, i, i2, i3);
    }

    private static s a(c0 c0Var, int i, int i2, int i3) {
        s sVar;
        int c = c0Var.c();
        int b = c0Var.b();
        int i4 = i3 * 2;
        int i5 = c + i4;
        int i6 = i4 + b;
        int max = Math.max(i, i5);
        int max2 = Math.max(i2, i6);
        int min = Math.min(max / i5, max2 / i6);
        int i7 = (max - (c * min)) / 2;
        int i8 = (max2 - (b * min)) / 2;
        if (i2 < b || i < c) {
            sVar = new s(c, b);
            i7 = 0;
            i8 = 0;
        } else {
            sVar = new s(i, i2);
        }
        sVar.a();
        int i9 = 0;
        while (i9 < b) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < c) {
                if (c0Var.a(i10, i9) == 1) {
                    sVar.a(i11, i8, min, min);
                }
                i10++;
                i11 += min;
            }
            i9++;
            i8 += min;
        }
        return sVar;
    }
}

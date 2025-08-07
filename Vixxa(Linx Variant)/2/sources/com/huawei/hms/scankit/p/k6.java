package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: QRCodeWriter */
public final class k6 implements l8 {
    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<u2, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            b3 b3Var = b3.L;
            Boolean bool = Boolean.FALSE;
            int i3 = 4;
            if (map != null) {
                u2 u2Var = u2.ERROR_CORRECTION;
                if (map.containsKey(u2Var)) {
                    b3Var = b3.valueOf(map.get(u2Var).toString());
                }
                u2 u2Var2 = u2.MARGIN;
                if (map.containsKey(u2Var2)) {
                    i3 = Integer.parseInt(map.get(u2Var2).toString());
                }
                u2 u2Var3 = u2.LOGO;
                if (map.containsKey(u2Var3)) {
                    bool = (Boolean) map.get(u2Var3);
                }
            }
            return a(w2.a(str, b3Var, map), i, i2, i3, bool.booleanValue());
        }
    }

    private static s a(h6 h6Var, int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        c0 a = h6Var.a();
        if (a != null) {
            int c = a.c();
            int b = a.b();
            if (z) {
                i6 = Math.max(i, c);
                i5 = Math.max(i2, b);
                int i7 = i3 * 2;
                i4 = Math.min((i6 - i7) / c, (i5 - i7) / b);
            } else {
                int i8 = i3 * 2;
                int i9 = c + i8;
                int i10 = i8 + b;
                i6 = Math.max(i, i9);
                i5 = Math.max(i2, i10);
                i4 = Math.min(i6 / i9, i5 / i10);
            }
            int i11 = (i6 - (c * i4)) / 2;
            int i12 = (i5 - (b * i4)) / 2;
            s sVar = new s(i6, i5);
            int i13 = 0;
            while (i13 < b) {
                int i14 = 0;
                int i15 = i11;
                while (i14 < c) {
                    if (a.a(i14, i13) == 1) {
                        sVar.a(i15, i12, i4, i4);
                    }
                    i14++;
                    i15 += i4;
                }
                i13++;
                i12 += i4;
            }
            return sVar;
        }
        throw new IllegalStateException();
    }
}

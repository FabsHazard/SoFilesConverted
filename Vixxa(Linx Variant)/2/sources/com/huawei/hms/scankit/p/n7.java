package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;

/* compiled from: UPCEANExtension2Support */
final class n7 {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    n7() {
    }

    /* access modifiers changed from: package-private */
    public s6 a(int i, r rVar, int[] iArr) throws a {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int a2 = a(rVar, iArr, sb);
        float f = (float) i;
        return new s6(sb.toString(), (byte[]) null, new u6[]{new u6(((float) (iArr[0] + iArr[1])) / 2.0f, f), new u6((float) a2, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int e = rVar.e();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 2 && i < e; i3++) {
            int a2 = q7.a(rVar, iArr2, i, q7.g);
            sb.append((char) ((a2 % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (a2 >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                i = rVar.d(rVar.c(i));
            }
        }
        if (sb.length() == 2) {
            try {
                if (Integer.parseInt(sb.toString()) % 4 == i2) {
                    return i;
                }
                throw a.a();
            } catch (NumberFormatException unused) {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }
}

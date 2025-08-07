package com.huawei.hms.scankit.p;

import com.github.mikephil.charting.utils.Utils;
import kotlin.UByte;

/* compiled from: OtsuBinarizer */
public final class k5 extends q3 {
    private s e;
    private p4 f;

    public k5(p4 p4Var) {
        super(p4Var);
        this.f = p4Var;
    }

    public s a() {
        s sVar = this.e;
        if (sVar != null) {
            return sVar;
        }
        p4 c = c();
        int c2 = c.c();
        int a = c.a();
        byte[] b = c.b();
        s sVar2 = new s(c2, a);
        byte[] b2 = this.f.b();
        int c3 = this.f.c();
        int a2 = this.f.a();
        int i = 256;
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < a2; i2++) {
            int i3 = i2 * c3;
            for (int i4 = 0; i4 < c3; i4++) {
                byte b3 = b2[i3 + i4] & UByte.MAX_VALUE;
                iArr[b3] = iArr[b3] + 1;
            }
        }
        int i5 = 0;
        byte b4 = 0;
        double d = Utils.DOUBLE_EPSILON;
        while (i5 < i) {
            int i6 = 0;
            int i7 = 0;
            double d2 = Utils.DOUBLE_EPSILON;
            while (i6 < i5) {
                int i8 = iArr[i6];
                i7 += i8;
                d2 += (double) (i8 * i6);
                i6++;
                iArr = iArr;
                i = 256;
            }
            int[] iArr2 = iArr;
            int i9 = 0;
            double d3 = Utils.DOUBLE_EPSILON;
            int i10 = i5;
            for (int i11 = i; i10 < i11; i11 = 256) {
                int i12 = iArr2[i10];
                i9 += i12;
                d3 += (double) (i12 * i10);
                i10++;
                i7 = i7;
            }
            int i13 = i7;
            double d4 = (double) i13;
            int i14 = c3;
            int i15 = a2;
            double d5 = (double) (c3 * a2);
            double d6 = d4 / d5;
            byte[] bArr = b;
            double d7 = (double) i9;
            double d8 = d7 / d5;
            double d9 = i13 > 0 ? d2 / d4 : Utils.DOUBLE_EPSILON;
            double d10 = i9 > 0 ? d3 / d7 : Utils.DOUBLE_EPSILON;
            double d11 = (d6 * d9) + (d8 * d10);
            double d12 = d9 - d11;
            double d13 = d10 - d11;
            double d14 = (d6 * d12 * d12) + (d8 * d13 * d13);
            if (d14 > d) {
                b4 = i5;
                d = d14;
            }
            i5++;
            b = bArr;
            c3 = i14;
            iArr = iArr2;
            a2 = i15;
            i = 256;
        }
        byte[] bArr2 = b;
        for (int i16 = 0; i16 < a; i16++) {
            int i17 = i16 * c2;
            for (int i18 = 0; i18 < c2; i18++) {
                if ((bArr2[i17 + i18] & UByte.MAX_VALUE) <= b4) {
                    sVar2.c(i18, i16);
                }
            }
        }
        this.e = sVar2;
        return sVar2;
    }
}

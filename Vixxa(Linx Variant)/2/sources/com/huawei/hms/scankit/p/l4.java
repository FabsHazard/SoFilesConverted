package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import kotlin.UByte;

/* compiled from: ImageResize */
public class l4 {
    public static int a(int i, int i2, int i3) {
        return i >= i2 ? i2 : i <= i3 ? i3 : i;
    }

    public static p a(p pVar) {
        int e = pVar.e();
        int c = pVar.c();
        byte[] d = pVar.d();
        byte[] bArr = new byte[(e * c)];
        for (int i = 0; i < c; i++) {
            for (int i2 = 0; i2 < e; i2++) {
                bArr[(((i2 * c) + c) - i) - 1] = d[(i * e) + i2];
            }
        }
        return new p(new e4(new e6(bArr, c, e, 0, 0, c, e, false)));
    }

    public static p a(p pVar, float f) {
        if (f == 1.0f) {
            return pVar;
        }
        int c = pVar.c();
        int e = pVar.e();
        int i = (int) (((float) e) / f);
        int i2 = (int) (((float) c) / f);
        byte[] d = pVar.d();
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            double a = (double) (((float) a(i5 % i, i - 1, i4)) * f);
            double a2 = (double) (((float) a(i5 / i, i2 - 1, i4)) * f);
            double floor = Math.floor(a);
            int i6 = i5;
            double floor2 = Math.floor(a2);
            double d2 = a - floor;
            double d3 = a2 - floor2;
            int i7 = e - 1;
            int i8 = i3;
            int a3 = a((int) floor, i7, 0);
            int i9 = c - 1;
            int a4 = a((int) floor2, i9, 0);
            int i10 = a4 * e;
            int i11 = c;
            double d4 = 1.0d - d2;
            double d5 = 1.0d - d3;
            int i12 = a3 + 1;
            byte[] bArr2 = bArr;
            int i13 = a4 + 1;
            bArr2[i6] = (byte) (((int) ((((double) (d[i10 + a3] & UByte.MAX_VALUE)) * d4 * d5) + (((double) (d[i10 + a(i12, i7, 0)] & UByte.MAX_VALUE)) * d2 * d5) + (((double) (d[(a(i13, i9, 0) * e) + a3] & UByte.MAX_VALUE)) * d4 * d3) + (((double) (d[(a(i13, i9, 0) * e) + a(i12, i7, 0)] & UByte.MAX_VALUE)) * d2 * d3))) & 255);
            i5 = i6 + 1;
            i4 = 0;
            i3 = i8;
            i = i;
            c = i11;
            i2 = i2;
            bArr = bArr2;
        }
        byte[] bArr3 = bArr;
        return new p(new e4(new e6(bArr, i, i2, 0, 0, i, i2, false)));
    }

    public static p a(boolean z, p pVar, float f) {
        if (f == 1.0f) {
            return pVar;
        }
        int c = pVar.c();
        int e = pVar.e();
        int i = (int) (((float) e) / f);
        int i2 = (int) (((float) c) / f);
        return new p(new e4(new e6(LoadOpencvJNIUtil.imageResize(pVar.d(), c, e, i2, i), i, i2, 0, 0, i, i2, false)));
    }
}

package com.huawei.hms.scankit.p;

/* compiled from: DefaultGridSampler */
public final class x1 extends s3 {
    public s a(s sVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws a {
        return a(sVar, i, i2, d6.a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16), false);
    }

    public s b(s sVar, int i, int i2, d6 d6Var) throws a {
        if (i <= 0 || i2 <= 0) {
            throw a.a();
        }
        s sVar2 = new s(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            float f = ((float) i4) + 0.5f;
            for (int i5 = 0; i5 < i3; i5 += 2) {
                fArr[i5] = ((float) (i5 / 2)) + 0.5f;
                fArr[i5 + 1] = f;
            }
            if (!r3.p || !r3.m) {
                d6Var.a(fArr);
            } else {
                d6Var.b(fArr);
            }
            int e = sVar.e();
            int c = sVar.c();
            int i6 = 0;
            while (i6 < i3) {
                try {
                    int i7 = (int) fArr[i6];
                    int i8 = (int) fArr[i6 + 1];
                    if (i7 >= -1 && i7 <= e && i8 >= -1) {
                        if (i8 <= c) {
                            if (sVar.b(i7, i8)) {
                                sVar2.c(i6 / 2, i4);
                            }
                            i6 += 2;
                        }
                    }
                    sVar2.c(i6 / 2, i4);
                    i6 += 2;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw a.a();
                }
            }
        }
        return sVar2;
    }

    public s a(s sVar, int i, int i2, d6 d6Var, boolean z) throws a {
        boolean z2 = r3.n;
        if ((!z2 || !z) && ((z2 || z) && !r3.u)) {
            return a(sVar, i, i2, d6Var);
        }
        return b(sVar, i, i2, d6Var);
    }

    public s a(s sVar, int i, int i2, d6 d6Var) throws a {
        int i3 = i;
        int i4 = i2;
        d6 d6Var2 = d6Var;
        if (i3 <= 0 || i4 <= 0) {
            throw a.a();
        }
        s sVar2 = new s(i3, i4);
        int i5 = 0;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = i5;
            while (i7 < i3) {
                float f = (float) i7;
                float f2 = (float) i6;
                float f3 = f2 + 0.5f;
                float f4 = f + 0.5f;
                float[] fArr = new float[10];
                fArr[i5] = (f - 0.2f) + 0.5f;
                fArr[1] = f3;
                fArr[2] = f + 0.2f + 0.5f;
                fArr[3] = f3;
                fArr[4] = f4;
                fArr[5] = (f2 - 0.2f) + 0.5f;
                fArr[6] = f4;
                fArr[7] = f2 + 0.2f + 0.5f;
                fArr[8] = f4;
                fArr[9] = f3;
                if (!r3.p || !r3.m) {
                    d6Var2.a(fArr);
                } else {
                    d6Var2.b(fArr);
                }
                int e = sVar.e();
                int c = sVar.c();
                int i8 = i5;
                int i9 = i8;
                while (i8 < 5) {
                    int i10 = i8 * 2;
                    try {
                        int i11 = (int) fArr[i10];
                        int i12 = (int) fArr[i10 + 1];
                        if (i11 >= -1 && i11 <= e && i12 >= -1) {
                            if (i12 <= c) {
                                if (sVar.b(i11, i12)) {
                                    i9++;
                                }
                                i8++;
                            }
                        }
                        s sVar3 = sVar;
                        i8++;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw a.a();
                    }
                }
                s sVar4 = sVar;
                if (i9 >= 3) {
                    sVar2.c(i7, i6);
                }
                i7++;
                i5 = 0;
            }
            s sVar5 = sVar;
            i6++;
            i5 = 0;
        }
        return sVar2;
    }
}

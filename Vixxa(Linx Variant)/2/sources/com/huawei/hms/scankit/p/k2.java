package com.huawei.hms.scankit.p;

import com.github.mikephil.charting.utils.Utils;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.List;

/* compiled from: DetectorRotate */
public class k2 {
    private static d5 a;
    private static p b;

    public static List<i2> a(boolean z, p pVar, int i, boolean z2) {
        int e = pVar.e();
        int c = pVar.c();
        byte[] b2 = pVar.a().c().b();
        d5 d5Var = new d5();
        a = d5Var;
        d5Var.a(z, b2, c, e, i, z2);
        return a.a;
    }

    public static boolean a(boolean z, p pVar, i2 i2Var) throws a {
        float f;
        i2 i2Var2 = i2Var;
        int e = pVar.e();
        int c = pVar.c();
        float[] fArr = {i2Var.j(), i2Var.k(), i2Var.f(), i2Var.c()};
        if (z) {
            i2Var2.n = Math.max(i2Var.m(), i2Var.l());
            i2Var2.o = Math.min(i2Var.m(), i2Var.l());
            f = i2Var.i();
            if (i2Var.g() == 11.0f || i2Var.g() == 0.0f) {
                f = 0.0f;
            }
            i2Var2.v = Math.max(fArr[2], fArr[3]);
            i2Var2.r = (int) Math.max(((double) fArr[0]) - (((double) fArr[2]) * 0.5d), Utils.DOUBLE_EPSILON);
            i2Var2.s = (int) Math.max(((double) fArr[1]) - (((double) fArr[3]) * 0.5d), Utils.DOUBLE_EPSILON);
        } else {
            f = i2Var.i();
            i2Var2.v = Math.max(fArr[2], fArr[3]);
            i2Var2.r = (int) i2Var.d();
            i2Var2.s = (int) i2Var.e();
        }
        i2Var2.p = Math.min(e - i2Var2.r, (int) fArr[2]);
        int min = Math.min(c - i2Var2.s, (int) fArr[3]);
        i2Var2.q = min;
        int i = i2Var2.p;
        if (i <= 0 || min <= 0) {
            throw a.a("crop_w <= 0 || crop_h <= 0");
        }
        p a2 = pVar.a(i2Var2.r, i2Var2.s, i, min);
        b = a2;
        a(a2, f, i2Var2, fArr);
        return true;
    }

    private static void a(p pVar, float f, i2 i2Var, float[] fArr) {
        byte[] bArr;
        float f2;
        float f3;
        float f4 = f;
        i2 i2Var2 = i2Var;
        float radians = (float) Math.toRadians((double) f4);
        double d = (double) radians;
        int abs = (int) ((((double) i2Var2.p) * Math.abs(Math.sin(d))) + (((double) i2Var2.q) * Math.abs(Math.cos(d))));
        int abs2 = (int) ((((double) i2Var2.q) * Math.abs(Math.sin(d))) + (((double) i2Var2.p) * Math.abs(Math.cos(d))));
        float[] fArr2 = i2Var2.m;
        fArr2[0] = ((float) abs2) * 0.5f;
        fArr2[1] = ((float) abs) * 0.5f;
        fArr2[2] = ((float) (abs2 - i2Var2.p)) * 0.5f;
        fArr2[3] = ((float) (abs - i2Var2.q)) * 0.5f;
        fArr2[4] = radians;
        if (!r3.b) {
            bArr = LoadOpencvJNIUtil.removeMoirePattern(pVar.a().c().b(), i2Var2.q, i2Var2.p);
        } else {
            bArr = pVar.a().c().b();
        }
        byte[] bArr2 = bArr;
        if (f4 == 0.0f) {
            i2Var2.t = 0;
            i2Var2.u = 0;
            int i = i2Var2.p;
            int i2 = i2Var2.q;
            i2Var2.l = new p(new q3(new e6(bArr2, i, i2, 0, 0, i, i2, false)));
            return;
        }
        int i3 = abs2;
        int i4 = abs;
        p pVar2 = new p(new q3(new e6(LoadOpencvJNIUtil.imageRotate(bArr2, i2Var2.q, i2Var2.p, abs, abs2, f, 1.0d), abs2, abs, 0, 0, i3, i4, false)));
        if ((i2Var.g() == 3.0f || i2Var.g() == 4.0f) && pVar2.c() > pVar2.e()) {
            f3 = Math.min(fArr[2], fArr[3]);
            f2 = Math.max(fArr[2], fArr[3]);
        } else {
            f3 = Math.max(fArr[2], fArr[3]);
            f2 = Math.min(fArr[2], fArr[3]);
        }
        i2Var2.t = (int) Math.max((((double) i3) * 0.5d) - (((double) f3) * 0.5d), Utils.DOUBLE_EPSILON);
        i2Var2.u = (int) Math.max((((double) i4) * 0.5d) - (((double) f2) * 0.5d), Utils.DOUBLE_EPSILON);
        i2Var2.l = pVar2.a(i2Var2.t, i2Var2.u, Math.min(i3 - i2Var2.t, (int) f3), Math.min(i4 - i2Var2.u, (int) f2));
    }

    public static void a(s sVar, s6 s6Var, float f, i2 i2Var) {
        int i;
        int i2;
        u6[] j = s6Var.j();
        float min = Math.min(j[0].b(), j[1].b());
        float max = Math.max(j[0].b(), j[1].b());
        float c = j[0].c();
        if (max > ((float) (sVar.e() - 1))) {
            max = (float) (sVar.e() - 1);
        }
        float f2 = max;
        float c2 = c > ((float) (sVar.c() - 1)) ? (float) (sVar.c() - 1) : c;
        int c3 = sVar.c();
        try {
            int[] a2 = a(sVar, j, min, f2, c2, c3, new int[c3]);
            i2 = a2[0];
            i = a2[1];
        } catch (IndexOutOfBoundsException unused) {
            i2 = (int) j[0].c();
            i = (int) j[0].c();
        }
        float f3 = (float) i2;
        float f4 = (float) i;
        u6[] u6VarArr = {new u6(min, f3), new u6(f2, f3), new u6(f2, f4), new u6(min, f4)};
        if (i2Var != null) {
            a(u6VarArr, f, i2Var);
        }
        s6Var.a();
        s6Var.a(u6VarArr);
    }

    private static int[] a(s sVar, u6[] u6VarArr, float f, float f2, float f3, int i, int[] iArr) {
        int i2;
        int i3;
        int i4;
        int i5 = (int) f;
        int i6 = i5;
        int i7 = 0;
        while (true) {
            i2 = ((int) f2) - 1;
            if (i6 >= i2) {
                break;
            }
            int i8 = (int) f3;
            boolean b2 = sVar.b(i6, i8);
            i6++;
            if (sVar.b(i6, i8) ^ b2) {
                i7++;
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            int i11 = i5;
            int i12 = 0;
            while (i11 < i2) {
                boolean b3 = sVar.b(i11, i10);
                i11++;
                if (b3 ^ sVar.b(i11, i10)) {
                    i12++;
                }
            }
            float f4 = (float) i7;
            if (((float) i12) > 1.5f * f4) {
                i12 = 0;
            }
            if (((float) i12) < f4 * 0.5f) {
                i12 = 0;
            }
            iArr[i10] = i12;
            if (i12 > i9) {
                i9 = i12;
            }
        }
        if (i9 > 0) {
            float[] fArr = new float[i];
            for (int i13 = 0; i13 < i; i13++) {
                fArr[i13] = ((float) iArr[i13]) / ((float) i9);
            }
            float f5 = 0.0f;
            for (int i14 = 0; i14 < i; i14++) {
                f5 += fArr[i14];
            }
            float f6 = f5 / ((float) i);
            if (((double) f6) > 1.0d) {
                f6 = 0.99f;
            }
            i4 = (int) f3;
            i3 = i4;
            while (true) {
                if (i3 < 0) {
                    i3 = 0;
                    break;
                } else if (fArr[i3] < f6) {
                    break;
                } else {
                    i3--;
                }
            }
            while (true) {
                if (i4 >= i) {
                    i4 = 0;
                    break;
                } else if (fArr[i4] < f6) {
                    break;
                } else {
                    i4++;
                }
            }
        } else {
            i4 = 0;
            i3 = 0;
        }
        if (i3 == 0 && i4 == 0) {
            i3 = ((int) u6VarArr[0].c()) + -10 < 0 ? 0 : ((int) u6VarArr[0].c()) - 10;
            i4 = i - 1;
            if (((int) u6VarArr[0].c()) + 10 <= i4) {
                i4 = ((int) u6VarArr[0].c()) + 10;
            }
        }
        return new int[]{i3, i4};
    }

    private static u6 a(float f, float f2, i2 i2Var) {
        float[] fArr = i2Var.m;
        if (fArr == null || fArr.length != 5) {
            return new u6(f, f2);
        }
        double d = (double) (f - fArr[0]);
        double d2 = (double) (-fArr[4]);
        float f3 = i2Var.m[0];
        float[] fArr2 = i2Var.m;
        return new u6((((float) ((int) (((d * Math.cos(d2)) + (((double) (f2 - i2Var.m[1])) * Math.sin(d2))) + ((double) f3)))) - fArr2[2]) + ((float) i2Var.r), (((float) ((int) (((((double) (-(f - f3))) * Math.sin(d2)) + (((double) (f2 - i2Var.m[1])) * Math.cos(d2))) + ((double) i2Var.m[1])))) - fArr2[3]) + ((float) i2Var.s));
    }

    public static void a(u6[] u6VarArr, float f, i2 i2Var) {
        if (i2Var != null && u6VarArr != null) {
            for (int i = 0; i < u6VarArr.length; i++) {
                u6VarArr[i] = a((u6VarArr[i].b() * f) + ((float) i2Var.t), (u6VarArr[i].c() * f) + ((float) i2Var.u), i2Var);
            }
        }
    }
}

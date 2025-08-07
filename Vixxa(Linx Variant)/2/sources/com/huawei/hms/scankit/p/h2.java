package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Detector */
public class h2 {
    private final s a;
    private v6 b;

    public h2(s sVar) {
        this.a = sVar;
    }

    private static float b(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public final f3[] a(Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        this.b = v6Var;
        return new j3(this.a, v6Var).a(map);
    }

    public static boolean a(f3 f3Var, f3 f3Var2, f3 f3Var3) {
        float[] fArr = new float[3];
        a(f3Var, f3Var2, f3Var3, fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float sqrt = (float) Math.sqrt((double) f2);
        float sqrt2 = (float) Math.sqrt((double) f3);
        float sqrt3 = (float) Math.sqrt((double) f);
        if (sqrt / sqrt2 >= 1.8f || sqrt2 / sqrt >= 1.8f || b(sqrt, sqrt2, sqrt3) <= a(f3Var.e(), f3Var2.e(), f3Var3.e()) * 6.0f) {
            return false;
        }
        float f4 = ((f2 + f3) - f) / ((sqrt * 2.0f) * sqrt2);
        float f5 = sqrt3 * 2.0f;
        float f6 = ((f + f2) - f3) / (sqrt * f5);
        float f7 = ((f + f3) - f2) / (f5 * sqrt2);
        if (Math.abs(f4) > 0.342f || f6 < 0.5736f || f6 > 0.8191f || f7 < 0.5736f || f7 > 0.8191f) {
            return false;
        }
        return true;
    }

    private static void a(f3 f3Var, f3 f3Var2, f3 f3Var3, float[] fArr) {
        float b2 = f3Var.b() - f3Var2.b();
        float c = f3Var.c() - f3Var2.c();
        float f = (b2 * b2) + (c * c);
        float b3 = f3Var.b() - f3Var3.b();
        float c2 = f3Var.c() - f3Var3.c();
        float f2 = (b3 * b3) + (c2 * c2);
        float b4 = f3Var2.b() - f3Var3.b();
        float c3 = f3Var2.c() - f3Var3.c();
        float f3 = (b4 * b4) + (c3 * c3);
        if (f > f3 && f > f2) {
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
        } else if (f3 <= f || f3 <= f2) {
            fArr[0] = f2;
            fArr[1] = f;
            fArr[2] = f3;
        } else {
            fArr[0] = f3;
            fArr[1] = f;
            fArr[2] = f2;
        }
    }

    private static float a(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean a(f3[] f3VarArr, f3[] f3VarArr2, int[] iArr) {
        f3 f3Var = f3VarArr[0];
        f3 f3Var2 = f3VarArr[1];
        f3 f3Var3 = f3VarArr[2];
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        float b2 = (f3Var3.b() - f3Var2.b()) + f3Var.b();
        float c = (f3Var3.c() - f3Var2.c()) + f3Var.c();
        float e = ((f3Var.e() + f3Var2.e()) + f3Var3.e()) / 3.0f;
        for (int i4 = 0; i4 < f3VarArr2.length; i4++) {
            if (!(i4 == i || i4 == i2 || i4 == i3)) {
                f3 f3Var4 = f3VarArr2[i4];
                float b3 = b2 - f3Var4.b();
                float c2 = c - f3Var4.c();
                if (((float) Math.sqrt((double) ((b3 * b3) + (c2 * c2)))) < 10.0f * e) {
                    return true;
                }
            }
        }
        return false;
    }
}

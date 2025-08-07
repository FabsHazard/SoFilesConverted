package com.huawei.hms.scankit.p;

import java.util.Map;

/* compiled from: Detector */
public class e2 {
    private static final int[] g = {210, 236, 264, 244, 270, 280};
    private static final int[] h = {21, 25, 29, 33, 37, 41};
    private final s a;
    private v6 b;
    private g3 c;
    private g3 d;
    private g3 e;
    private g3 f;

    public e2(s sVar) {
        this.a = sVar;
    }

    private float b(int i, int i2, s sVar) throws a {
        int c2 = sVar.c();
        int[] iArr = new int[5];
        for (int i3 = 0; i3 < 5; i3++) {
            iArr[i3] = 0;
        }
        int i4 = i;
        while (i4 >= 0 && sVar.b(i2, i4)) {
            iArr[2] = iArr[2] + 1;
            i4--;
        }
        if (i4 >= 0) {
            while (i4 >= 0 && !sVar.b(i2, i4)) {
                iArr[1] = iArr[1] + 1;
                i4--;
            }
            if (i4 >= 0) {
                while (i4 >= 0 && sVar.b(i2, i4)) {
                    iArr[0] = iArr[0] + 1;
                    i4--;
                }
                int i5 = i + 1;
                while (i5 < c2 && sVar.b(i2, i5)) {
                    iArr[2] = iArr[2] + 1;
                    i5++;
                }
                if (i5 != c2) {
                    while (i5 < c2 && !sVar.b(i2, i5)) {
                        iArr[3] = iArr[3] + 1;
                        i5++;
                    }
                    if (i5 != c2) {
                        while (i5 < c2 && sVar.b(i2, i5)) {
                            iArr[4] = iArr[4] + 1;
                            i5++;
                        }
                        return ((float) ((((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4])) / 6.0f;
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    public final g3[] a(Map<l1, ?> map) throws a {
        v6 v6Var = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        this.b = v6Var;
        return new h3(this.a, v6Var).a(map);
    }

    public final int a(g3[] g3VarArr, g3 g3Var) throws a {
        this.c = g3VarArr[0];
        this.d = g3VarArr[1];
        g3 g3Var2 = g3VarArr[2];
        this.e = g3Var2;
        if (g3Var == null) {
            this.f = new g3((g3Var2.b() - this.d.b()) + this.c.b(), (this.e.c() - this.d.c()) + this.c.c(), 6.0f);
        } else {
            this.f = g3Var;
        }
        float a2 = a((u6) this.d, (u6) this.e, (u6) this.c, this.a);
        if (a2 >= 1.0f) {
            int a3 = a((u6) this.d, (u6) this.e, (u6) this.c, a2);
            if (a3 >= 0 && a3 <= 7) {
                return a3;
            }
            throw a.a();
        }
        throw a.a();
    }

    public final j2 a(int i) throws a {
        s sVar;
        int i2 = i - 1;
        double d2 = (double) g[i2];
        float cos = (float) ((Math.cos(0.7853981633974483d) * d2) + 300.0d);
        float cos2 = (float) (300.0d - (d2 * Math.cos(0.7853981633974483d)));
        s a2 = a(this.a, a(this.d, this.e, this.c, this.f, new u6(cos2, cos2), new u6(cos, cos2), new u6(cos2, cos), new u6(cos, cos)), 600);
        int i3 = h[i2];
        s sVar2 = new s(i3, i3);
        switch (i) {
            case 1:
                sVar = e8.a(sVar2, a2, i3, 300.0d);
                break;
            case 2:
                sVar = h8.a(sVar2, a2, i3, 300.0d);
                break;
            case 3:
                sVar = g8.a(sVar2, a2, i3, 300.0d);
                break;
            case 4:
                sVar = d8.a(sVar2, a2, i3, 300.0d);
                break;
            case 5:
                sVar = c8.a(sVar2, a2, i3, 300.0d);
                break;
            case 6:
                sVar = f8.a(sVar2, a2, i3, 300.0d);
                break;
            default:
                throw a.a();
        }
        return new j2(sVar, new u6[]{this.c, this.d, this.e, this.f});
    }

    private static d6 a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, u6 u6Var5, u6 u6Var6, u6 u6Var7, u6 u6Var8) throws a {
        return d6.a(u6Var5.b(), u6Var5.c(), u6Var6.b(), u6Var6.c(), u6Var8.b(), u6Var8.c(), u6Var7.b(), u6Var7.c(), u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), u6Var4.b(), u6Var4.c(), u6Var3.b(), u6Var3.c());
    }

    private static s a(s sVar, d6 d6Var, int i) throws a {
        return s3.a().a(sVar, i, i, d6Var, false);
    }

    private static int a(u6 u6Var, u6 u6Var2, u6 u6Var3, float f2) throws a {
        float a2 = ((u6.a(u6Var, u6Var2) / f2) + (u6.a(u6Var, u6Var3) / f2)) / 2.0f;
        if (a2 >= 28.1f && a2 <= 31.1f) {
            return 1;
        }
        if (a2 >= 31.7f && a2 <= 34.7f) {
            return 2;
        }
        if (a2 >= 35.9f && a2 <= 38.9f) {
            return 3;
        }
        if (a2 >= 41.7f && a2 <= 44.7f) {
            return 4;
        }
        if (a2 >= 46.3f && a2 <= 49.3f) {
            return 5;
        }
        if (a2 < 54.4f || a2 > 57.4f) {
            return Math.round((a2 - 25.0f) / 4.0f);
        }
        return 6;
    }

    /* access modifiers changed from: protected */
    public final float a(u6 u6Var, u6 u6Var2, u6 u6Var3, s sVar) throws a {
        return (((((a((int) u6Var.b(), (int) u6Var.c(), sVar) + a((int) u6Var2.b(), (int) u6Var2.c(), sVar)) + a((int) u6Var3.b(), (int) u6Var3.c(), sVar)) + b((int) u6Var.c(), (int) u6Var.b(), sVar)) + b((int) u6Var2.c(), (int) u6Var2.b(), sVar)) + b((int) u6Var3.c(), (int) u6Var3.b(), sVar)) / 6.0f;
    }

    private float a(int i, int i2, s sVar) throws a {
        int e2 = sVar.e();
        int[] iArr = new int[5];
        for (int i3 = 0; i3 < 5; i3++) {
            iArr[i3] = 0;
        }
        int i4 = i;
        while (i4 >= 0 && sVar.b(i4, i2)) {
            iArr[2] = iArr[2] + 1;
            i4--;
        }
        if (i4 >= 0) {
            while (i4 >= 0 && !sVar.b(i4, i2)) {
                iArr[1] = iArr[1] + 1;
                i4--;
            }
            if (i4 >= 0) {
                while (i4 >= 0 && sVar.b(i4, i2)) {
                    iArr[0] = iArr[0] + 1;
                    i4--;
                }
                int i5 = i + 1;
                while (i5 < e2 && sVar.b(i5, i2)) {
                    iArr[2] = iArr[2] + 1;
                    i5++;
                }
                if (i5 != e2) {
                    while (i5 < e2 && !sVar.b(i5, i2)) {
                        iArr[3] = iArr[3] + 1;
                        i5++;
                    }
                    if (i5 != e2) {
                        while (i5 < e2 && sVar.b(i5, i2)) {
                            iArr[4] = iArr[4] + 1;
                            i5++;
                        }
                        return ((float) ((((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4])) / 6.0f;
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }
}

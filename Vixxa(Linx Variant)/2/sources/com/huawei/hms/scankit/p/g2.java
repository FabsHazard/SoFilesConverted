package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Map;

/* compiled from: Detector */
public class g2 {
    private final s a;
    private v6 b;

    public g2(s sVar) {
        this.a = sVar;
    }

    private static d6 a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4, u6 u6Var5, int i) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = ((float) i) - 3.5f;
        if (u6Var4 != null) {
            float b2 = u6Var4.b();
            float c = u6Var4.c();
            f2 = b2;
            f = c;
            f4 = u6Var5.b();
            f3 = u6Var5.c();
        } else {
            f2 = (u6Var2.b() - u6Var.b()) + u6Var3.b();
            f = (u6Var2.c() - u6Var.c()) + u6Var3.c();
            f4 = f5;
            f3 = f4;
        }
        return d6.a(3.5f, 3.5f, f5, 3.5f, f4, f3, 3.5f, f5, u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), f2, f, u6Var3.b(), u6Var3.c());
    }

    private float b(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float a2 = a(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        if (i == i5) {
            return Float.NaN;
        }
        int i6 = 0;
        if (i5 < 0) {
            f = ((float) i) / ((float) (i - i5));
            i5 = 0;
        } else if (i5 >= this.a.e()) {
            f = ((float) ((this.a.e() - 1) - i)) / ((float) (i5 - i));
            i5 = this.a.e() - 1;
        } else {
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i7 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i2 == i7) {
            return Float.NaN;
        }
        if (i7 < 0) {
            f2 = f3 / ((float) (i2 - i7));
        } else if (i7 >= this.a.c()) {
            f2 = ((float) ((this.a.c() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.a.c() - 1;
        } else {
            i6 = i7;
            f2 = 1.0f;
        }
        float a3 = a(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f2)), i6);
        if (((double) Math.max(a2, a3)) > ((double) Math.min(a2, a3)) * 1.5d) {
            return Float.NaN;
        }
        return (a2 + a3) - 1.0f;
    }

    private static s a(s sVar, d6 d6Var, int i) throws a {
        return s3.a().a(sVar, i, i, d6Var, true);
    }

    private static int a(u6 u6Var, u6 u6Var2, u6 u6Var3, float f) throws a {
        int i;
        try {
            i = ((s4.a(u6.a(u6Var, u6Var2) / f) + s4.a(u6.a(u6Var, u6Var3) / f)) / 2) + 7;
            int i2 = i & 3;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return i;
                    }
                    throw a.a();
                }
                return i - 1;
            }
        } catch (a unused) {
            int a2 = (((int) (u6.a(u6Var, u6Var2) / f)) + ((int) (u6.a(u6Var, u6Var3) / f))) / 2;
            i = a2 + 7;
            int i3 = i & 3;
            if (i3 != 0) {
                if (i3 != 2) {
                    return i3 != 3 ? i : a2 + 9;
                }
            }
        }
        return i + 1;
    }

    public final j2 a(Map<l1, ?> map) throws a {
        this.b = map == null ? null : (v6) map.get(l1.NEED_RESULT_POINT_CALLBACK);
        return a(new i3(this.a, this.b).b());
    }

    /* access modifiers changed from: protected */
    public final j2 a(k3 k3Var) throws a {
        e3 b2 = k3Var.b();
        e3 c = k3Var.c();
        e3 a2 = k3Var.a();
        try {
            float a3 = a((u6) b2, (u6) c, (u6) a2);
            if (a3 >= 1.0f) {
                return a(b2, c, a2, a3);
            }
            throw a.a();
        } catch (a unused) {
            float e = ((b2.e() + c.e()) + a2.e()) / 3.0f;
            if (e >= 1.0f) {
                return a(b2, c, a2, e);
            }
            throw a.a();
        }
    }

    private j2 a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f) throws a {
        d[] dVarArr;
        d[] dVarArr2;
        char c;
        d[] dVarArr3;
        int i;
        d6 d6Var;
        u6[] u6VarArr;
        int a2 = a((u6) e3Var, (u6) e3Var2, (u6) e3Var3, f);
        r3.w.push(Integer.valueOf(a2));
        b8 b2 = b8.b(a2);
        if (r3.s && r3.c) {
            return a(e3Var, e3Var2, e3Var3, f, a2);
        }
        int d = b2.d() - 7;
        int length = b2.c().length;
        int i2 = length * length;
        d[] dVarArr4 = new d[i2];
        d[] dVarArr5 = new d[i2];
        d[] dVarArr6 = new d[2];
        if (b2.c().length > 0) {
            dVarArr3 = dVarArr6;
            c = 2;
            dVarArr2 = dVarArr5;
            dVarArr = dVarArr4;
            i = a(e3Var, e3Var2, e3Var3, f, a2, b2, dVarArr4, dVarArr5, length, d, dVarArr3);
        } else {
            dVarArr3 = dVarArr6;
            c = 2;
            dVarArr2 = dVarArr5;
            dVarArr = dVarArr4;
            i = 0;
        }
        d dVar = dVarArr3[0];
        d6 a3 = a(e3Var, e3Var2, e3Var3, dVar, dVarArr3[1], a2);
        if (!r3.p || !r3.m) {
            d6Var = a3;
        } else {
            d6Var = a3;
            a(a3, length, a2, e3Var, e3Var2, e3Var3, dVarArr, i, dVarArr2);
        }
        s a4 = a(this.a, d6Var, a2);
        if (dVar == null) {
            u6VarArr = new u6[3];
            u6VarArr[0] = e3Var3;
            u6VarArr[1] = e3Var;
            u6VarArr[c] = e3Var2;
        } else {
            u6VarArr = new u6[4];
            u6VarArr[0] = e3Var3;
            u6VarArr[1] = e3Var;
            u6VarArr[c] = e3Var2;
            u6VarArr[3] = dVar;
        }
        float f2 = (float) a2;
        float[] fArr = new float[8];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[c] = f2;
        fArr[3] = 0.0f;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = 0.0f;
        fArr[7] = f2;
        d6Var.a(fArr);
        u6 u6Var = new u6(fArr[0], fArr[1], e3Var.d());
        u6 u6Var2 = new u6(fArr[c], fArr[3], e3Var2.d());
        u6 u6Var3 = new u6(fArr[4], fArr[5], e3Var3.d());
        u6[] u6VarArr2 = new u6[4];
        u6VarArr2[0] = a(new u6(fArr[6], fArr[7]));
        u6VarArr2[1] = a(u6Var);
        u6VarArr2[c] = a(u6Var2);
        u6VarArr2[3] = a(u6Var3);
        return new j2(a4, u6VarArr, u6VarArr2, f);
    }

    private int a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f, int i, b8 b8Var, d[] dVarArr, d[] dVarArr2, int i2, int i3, d[] dVarArr3) {
        int i4;
        int i5;
        float f2 = f;
        int i6 = i2;
        int i7 = i3;
        float b2 = (e3Var2.b() - e3Var.b()) + e3Var3.b();
        float c = (e3Var2.c() - e3Var.c()) + e3Var3.c();
        float f3 = (float) i7;
        float f4 = 3.0f / f3;
        float f5 = 1.0f - f4;
        int b3 = (int) (e3Var.b() + ((b2 - e3Var.b()) * f5));
        int c2 = (int) (e3Var.c() + (f5 * (c - e3Var.c())));
        if (!r3.v[0] || i7 != 22) {
            i5 = 4;
            i4 = 16;
        } else {
            i4 = 8;
            i5 = 2;
        }
        int i8 = i5;
        while (i8 <= i4) {
            try {
                dVarArr3[0] = a(f2, b3, c2, (float) i8);
                break;
            } catch (a unused) {
                i8 <<= 1;
            }
        }
        float f6 = ((float) i) - 6.5f;
        dVarArr3[1] = new d(f6, f6, e3Var3.e());
        d dVar = dVarArr3[0];
        if (dVar != null && s4.a((float) b3, (float) c2, dVar.b(), dVarArr3[0].c()) > f2 * 4.0f) {
            dVarArr3[0] = null;
        }
        if (dVarArr3[0] == null && i6 > 2) {
            int i9 = i6 - 2;
            dVarArr3[1] = new d(((float) b8Var.c()[i9]) + 0.5f, f6, e3Var3.e());
            int c3 = (int) (e3Var3.c() - (f4 * (e3Var3.c() - e3Var.c())));
            int b4 = (int) ((((((float) b8Var.c()[i9]) - 3.0f) / f3) * (e3Var2.b() - e3Var.b())) + e3Var3.b());
            while (i5 <= i4) {
                try {
                    dVarArr3[0] = a(f2, b4, c3, (float) i5);
                    break;
                } catch (a unused2) {
                    i5 <<= 1;
                }
            }
            d dVar2 = dVarArr3[0];
            if (dVar2 != null && s4.a((float) b4, (float) c3, dVar2.b(), dVarArr3[0].c()) > f2 * 4.0f) {
                dVarArr3[0] = null;
            }
        }
        if (!r3.p || !r3.m) {
            return 0;
        }
        return a(b8Var, i3, e3Var2, e3Var, e3Var3, f, i2, 0, dVarArr, dVarArr2);
    }

    private int a(b8 b8Var, int i, e3 e3Var, e3 e3Var2, e3 e3Var3, float f, int i2, int i3, d[] dVarArr, d[] dVarArr2) {
        int i4;
        int i5;
        int i6;
        float f2;
        int i7 = i2;
        int i8 = i3;
        int i9 = 0;
        while (i9 < i7) {
            int i10 = 1;
            if (i9 == 0) {
                i5 = i7 - 1;
                i4 = 1;
            } else {
                i5 = i7;
                i4 = 0;
            }
            if (i9 != i7 - 1) {
                i10 = i4;
            }
            float f3 = 3.0f;
            float f4 = (float) i;
            float b2 = (((((float) b8Var.c()[i9]) - 3.0f) * (e3Var.b() - e3Var2.b())) / f4) + e3Var2.b();
            float c = (((((float) b8Var.c()[i9]) - 3.0f) * (e3Var.c() - e3Var2.c())) / f4) + e3Var2.c();
            while (i10 < i5) {
                int c2 = (int) (c - (((((float) b8Var.c()[i10]) - f3) * (e3Var2.c() - e3Var3.c())) / f4));
                int b3 = (int) (b2 - (((((float) b8Var.c()[i10]) - f3) * (e3Var2.b() - e3Var3.b())) / f4));
                int i11 = 4;
                int i12 = 4;
                while (true) {
                    if (i12 > i11) {
                        float f5 = f;
                        i6 = i5;
                        f2 = b2;
                        break;
                    }
                    int i13 = (i9 * i7) + i10;
                    try {
                        dVarArr[i13] = a(f, b3, c2, (float) i12);
                        i6 = i5;
                        try {
                            f2 = b2;
                            try {
                                dVarArr2[i13] = new d(((float) b8Var.c()[i9]) + 0.5f, ((float) b8Var.c()[i10]) + 0.5f, e3Var3.e());
                                i8++;
                                break;
                            } catch (a unused) {
                                continue;
                            }
                        } catch (a unused2) {
                            f2 = b2;
                            i12 <<= 1;
                            i7 = i2;
                            b2 = f2;
                            i5 = i6;
                            i11 = 4;
                        }
                    } catch (a unused3) {
                        i6 = i5;
                        f2 = b2;
                        i12 <<= 1;
                        i7 = i2;
                        b2 = f2;
                        i5 = i6;
                        i11 = 4;
                    }
                    i12 <<= 1;
                    i7 = i2;
                    b2 = f2;
                    i5 = i6;
                    i11 = 4;
                }
                i10++;
                i7 = i2;
                b2 = f2;
                i5 = i6;
                f3 = 3.0f;
            }
            float f6 = f;
            i9++;
            i7 = i2;
        }
        return i8;
    }

    private void a(d6 d6Var, int i, int i2, e3 e3Var, e3 e3Var2, e3 e3Var3, d[] dVarArr, int i3, d[] dVarArr2) {
        int i4 = i3 + 3;
        int i5 = i4 * 2;
        float[] fArr = new float[i5];
        float[] fArr2 = new float[i5];
        fArr[0] = e3Var.b();
        fArr[1] = e3Var.c();
        fArr[2] = e3Var2.b();
        fArr[3] = e3Var2.c();
        fArr[4] = e3Var3.b();
        fArr[5] = e3Var3.c();
        fArr2[0] = 3.5f;
        fArr2[1] = 3.5f;
        float f = ((float) i2) - 3.5f;
        fArr2[2] = f;
        fArr2[3] = 3.5f;
        fArr2[4] = 3.5f;
        fArr2[5] = f;
        int i6 = 6;
        int i7 = 6;
        for (int i8 = 0; i8 < i * i; i8++) {
            d dVar = dVarArr[i8];
            if (dVar != null) {
                int i9 = i7 + 1;
                fArr[i7] = dVar.b();
                i7 += 2;
                fArr[i9] = dVarArr[i8].c();
                int i10 = i6 + 1;
                fArr2[i6] = dVarArr2[i8].b();
                i6 += 2;
                fArr2[i10] = dVarArr2[i8].c();
            }
        }
        float[] QuadFitting = LoadOpencvJNIUtil.QuadFitting(fArr2, i4, fArr);
        if (QuadFitting.length != 0) {
            d6Var.a(QuadFitting[0], QuadFitting[1], QuadFitting[2], QuadFitting[3], QuadFitting[4], QuadFitting[5], QuadFitting[6], QuadFitting[7], QuadFitting[8], QuadFitting[9], QuadFitting[10], QuadFitting[11], QuadFitting[12], QuadFitting[13]);
        }
    }

    private j2 a(e3 e3Var, e3 e3Var2, e3 e3Var3, float f, int i) {
        int i2 = i;
        s sVar = new s(i2, i2);
        float f2 = (float) i2;
        float c = ((float) this.a.c()) / f2;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                double d = ((double) c) * 0.5d;
                int i5 = (int) (((double) (((float) i4) * c)) + d);
                int i6 = (int) (((double) (((float) i3) * c)) + d);
                if (i5 < -1 || i5 > this.a.e() || i6 < -1 || i6 > this.a.c()) {
                    sVar.c(i4, i3);
                } else if (this.a.b(i5, i6)) {
                    sVar.c(i4, i3);
                }
            }
        }
        u6[] u6VarArr = {e3Var3, e3Var, e3Var2};
        float[] fArr = {0.0f, 0.0f, f2, 0.0f, f2, f2, 0.0f, f2};
        a(e3Var, e3Var2, e3Var3, (u6) null, (u6) null, i).a(fArr);
        return new j2(sVar, u6VarArr, new u6[]{a(new u6(fArr[6], fArr[7])), a(new u6(fArr[0], fArr[1])), a(new u6(fArr[2], fArr[3])), a(new u6(fArr[4], fArr[5]))}, f);
    }

    /* access modifiers changed from: protected */
    public final float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        return (a(u6Var, u6Var2) + a(u6Var, u6Var3)) / 2.0f;
    }

    private float a(u6 u6Var, u6 u6Var2) {
        float b2 = b((int) u6Var.b(), (int) u6Var.c(), (int) u6Var2.b(), (int) u6Var2.c());
        float b3 = b((int) u6Var2.b(), (int) u6Var2.c(), (int) u6Var.b(), (int) u6Var.c());
        if (Float.isNaN(b2)) {
            return b3 / 7.0f;
        }
        return Float.isNaN(b3) ? b2 / 7.0f : (b2 + b3) / 14.0f;
    }

    private float a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        g2 g2Var;
        boolean z2;
        boolean z3 = true;
        boolean z4 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z4) {
            i7 = i;
            i8 = i2;
            i5 = i3;
            i6 = i4;
        } else {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i6 - i8);
        int abs2 = Math.abs(i5 - i7);
        int i11 = 2;
        int i12 = (-abs) / 2;
        int i13 = -1;
        int i14 = i8 < i6 ? 1 : -1;
        if (i7 < i5) {
            i13 = 1;
        }
        int i15 = i6 + i14;
        int i16 = i8;
        int i17 = i7;
        int i18 = 0;
        while (true) {
            if (i16 == i15) {
                i9 = i15;
                i10 = i11;
                break;
            }
            int i19 = z4 ? i17 : i16;
            int i20 = z4 ? i16 : i17;
            if (i18 == z3) {
                z = z4;
                z2 = z3;
                i9 = i15;
                g2Var = this;
            } else {
                g2Var = this;
                z = z4;
                i9 = i15;
                z2 = false;
            }
            if (z2 == g2Var.a.b(i19, i20)) {
                if (i18 == 2) {
                    return s4.a(i16, i17, i8, i7);
                }
                i18++;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (i17 == i5) {
                    i10 = 2;
                    break;
                }
                i17 += i13;
                i12 -= abs;
            }
            i16 += i14;
            i15 = i9;
            z4 = z;
            z3 = true;
            i11 = 2;
        }
        if (i18 == i10) {
            return s4.a(i9, i5, i8, i7);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final d a(float f, int i, int i2, float f2) throws a {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.a.e() - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.a.c() - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                return new e(this.a, max, max2, min, min2, f, this.b).a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private u6 a(u6 u6Var) {
        float b2 = u6Var.b();
        float c = u6Var.c();
        int e = this.a.e() - 1;
        int c2 = this.a.c() - 1;
        if (b2 < 0.0f) {
            b2 = 0.0f;
        }
        float f = (float) e;
        if (b2 > f) {
            b2 = f;
        }
        if (c < 0.0f) {
            c = 0.0f;
        }
        float f2 = (float) c2;
        if (c > f2) {
            c = f2;
        }
        return new u6(b2, c, u6Var.d());
    }
}

package com.huawei.hms.scankit.p;

/* compiled from: PerspectiveTransform */
public final class d6 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s = 0.0f;
    private float t = 0.0f;
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;

    public d6(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f2;
        this.b = f5;
        this.c = f8;
        this.d = f3;
        this.e = f6;
        this.f = f9;
        this.g = f4;
        this.h = f7;
        this.i = f10;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.m = f5;
        this.n = f6;
        this.o = f7;
        this.p = f8;
        this.q = f9;
        this.r = f10;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.m = f5;
        this.n = f6;
        this.o = f7;
        this.p = f8;
        this.q = f9;
        this.r = f10;
        this.s = f11;
        this.t = f12;
        this.u = f13;
        this.v = f14;
        this.w = f15;
    }

    public void b(float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f2 = fArr[i2];
            int i3 = i2 + 1;
            float f3 = fArr[i3];
            float f4 = (this.t * f2) + (this.u * f3) + (this.v * f2 * f2) + (this.w * f3 * f3) + 1.0f;
            fArr[i2] = (((((this.j * f2) + (this.k * f3)) + ((this.l * f2) * f2)) + ((this.m * f3) * f3)) + this.n) / f4;
            fArr[i3] = (((((this.o * f2) + (this.p * f3)) + ((this.q * f2) * f2)) + ((this.r * f3) * f3)) + this.s) / f4;
        }
    }

    public static d6 b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new d6(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new d6((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    public static d6 a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return b(f10, f11, f12, f13, f14, f15, f16, f17).a(a(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public void a(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = this.c;
        float f5 = this.d;
        float f6 = this.e;
        float f7 = this.f;
        float f8 = this.g;
        float f9 = this.h;
        float f10 = this.i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr2[i2];
            int i3 = i2 + 1;
            float f12 = fArr2[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr2[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr2[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    public static d6 a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return b(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    /* access modifiers changed from: package-private */
    public d6 a() {
        float f2 = this.e;
        float f3 = this.i;
        float f4 = this.f;
        float f5 = this.h;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.g;
        float f8 = this.d;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.c;
        float f12 = this.b;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.a;
        return new d6(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    /* access modifiers changed from: package-private */
    public d6 a(d6 d6Var) {
        d6 d6Var2 = d6Var;
        float f2 = this.a;
        float f3 = d6Var2.a;
        float f4 = this.d;
        float f5 = d6Var2.b;
        float f6 = this.g;
        float f7 = d6Var2.c;
        float f8 = (f2 * f3) + (f4 * f5) + (f6 * f7);
        float f9 = d6Var2.d;
        float f10 = d6Var2.e;
        float f11 = d6Var2.f;
        float f12 = (f2 * f9) + (f4 * f10) + (f6 * f11);
        float f13 = d6Var2.g;
        float f14 = d6Var2.h;
        float f15 = d6Var2.i;
        float f16 = (f2 * f13) + (f4 * f14) + (f6 * f15);
        float f17 = this.b;
        float f18 = f16;
        float f19 = this.e;
        float f20 = f12;
        float f21 = this.h;
        float f22 = (f17 * f3) + (f19 * f5) + (f21 * f7);
        float f23 = (f21 * f15) + (f17 * f13) + (f19 * f14);
        float f24 = this.c;
        float f25 = this.f;
        float f26 = (f3 * f24) + (f5 * f25);
        float f27 = this.i;
        float f28 = (f24 * f13) + (f25 * f14) + (f27 * f15);
        return new d6(f8, f20, f18, f22, (f17 * f9) + (f19 * f10) + (f21 * f11), f23, (f7 * f27) + f26, (f9 * f24) + (f10 * f25) + (f11 * f27), f28);
    }
}

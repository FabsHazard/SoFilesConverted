package com.huawei.hms.scankit.p;

/* compiled from: DetectorResult */
public class i2 implements Comparable<i2> {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    public p l;
    public float[] m = new float[5];
    public float n = 0.0f;
    public float o = 0.0f;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public float v = 0.0f;

    public i2(boolean z, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f6;
        this.f = f7;
        this.k = f11;
        if (z) {
            this.g = f8;
            this.h = f9;
            this.j = f10;
            return;
        }
        this.i = f10;
        this.j = f9;
    }

    private float a(float f2, int i2, int i3) {
        float f3 = (float) i2;
        if (f2 <= f3) {
            f2 = f3;
        }
        float f4 = (float) (i3 - 1);
        return f2 < f4 ? f2 : f4;
    }

    public void a(int i2, int i3, float f2, float f3) {
        float f4 = this.a + f2;
        this.a = f4;
        float f5 = this.b + f3;
        this.b = f5;
        if (f4 < 0.0f) {
            this.c += f4;
        }
        if (f5 < 0.0f) {
            this.d += f5;
        }
        this.e += f2;
        this.f += f3;
        this.a = a(f4, 0, i2);
        this.e = a(this.e, 0, i2);
        this.b = a(this.b, 0, i3);
        this.f = a(this.f, 0, i3);
        float f6 = this.a;
        float f7 = ((float) i2) - f2;
        if (this.c + f6 >= f7) {
            this.c = (f7 - 1.0f) - f6;
        }
        float f8 = this.b;
        float f9 = ((float) i3) - f3;
        if (this.d + f8 >= f9) {
            this.d = (f9 - 1.0f) - f8;
        }
    }

    public void b(float f2, float f3) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = f2;
        this.d = f3;
        this.e = f2 / 2.0f;
        this.f = f3 / 2.0f;
        this.g = f2;
        this.h = f3;
        this.j = 0.0f;
    }

    public float c() {
        return this.d;
    }

    public float d() {
        return this.a;
    }

    public float e() {
        return this.b;
    }

    public float f() {
        return this.c;
    }

    public float g() {
        return this.k;
    }

    public float h() {
        return this.i;
    }

    public float i() {
        return this.j;
    }

    public float j() {
        return this.e;
    }

    public float k() {
        return this.f;
    }

    public float l() {
        return this.h;
    }

    public float m() {
        return this.g;
    }

    public float n() {
        return this.v;
    }

    public float b() {
        return this.n;
    }

    public void a(float f2, float f3) {
        this.a += f2;
        this.b += f3;
        this.e += f2;
        this.f += f3;
    }

    public float a() {
        return this.o;
    }

    /* renamed from: a */
    public int compareTo(i2 i2Var) {
        return Float.compare((-i2Var.g()) + i2Var.h(), (-g()) + h());
    }
}

package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;

/* compiled from: Particle */
public class w5 {
    private float a = 1.0f;
    private float b;
    private float c;
    private int d = 255;
    private float e = 0.0f;
    private float f = 0.0f;
    private int g = 255;
    private long h;
    private float i;
    private float j;
    private float k = 1.0f;
    private float l;
    private float m;
    private int n;
    private int o;
    private long p;
    private int q = 0;
    private f4 r;

    public w5(Bitmap bitmap) {
        if (bitmap != null) {
            this.n = bitmap.getWidth() / 2;
            this.o = bitmap.getHeight() / 2;
        }
    }

    public void a(long j2, float f2, float f3, long j3, f4 f4Var) {
        float f4 = f2 - ((float) this.n);
        this.l = f4;
        float f5 = f3 - ((float) this.o);
        this.m = f5;
        this.i = f4;
        this.j = f5;
        this.p = j2;
        this.h = j3;
        this.r = f4Var;
    }

    public void b(float f2) {
        this.k = f2;
    }

    public float c() {
        return this.i;
    }

    public float d() {
        return this.j;
    }

    public int e() {
        return this.d;
    }

    public float f() {
        return this.k;
    }

    public int b() {
        return this.q;
    }

    public void b(int i2) {
        this.q = i2;
    }

    public boolean a(long j2) {
        long j3 = j2 - this.h;
        if (j3 > this.p) {
            return false;
        }
        float f2 = (float) j3;
        float f3 = (float) (j3 * j3);
        this.i = this.l + (this.e * f2) + (this.b * f3);
        this.j = this.m + (this.f * f2) + (this.c * f3);
        this.r.a(this, j3);
        return true;
    }

    public int a() {
        return this.g;
    }

    public void a(int i2) {
        this.g = i2;
    }

    public void a(float f2) {
        this.a = f2;
    }
}

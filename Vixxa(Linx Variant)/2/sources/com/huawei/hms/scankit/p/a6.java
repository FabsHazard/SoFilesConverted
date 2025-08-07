package com.huawei.hms.scankit.p;

/* compiled from: ParticleScale */
public class a6 implements g4 {
    private final float a;
    private final float b;

    public a6(float f, float f2) {
        this.b = f;
        this.a = f2;
    }

    public void a(w5 w5Var) {
        float f = this.a;
        float f2 = this.b;
        if (f != f2) {
            f = n6.a(f - f2) + this.b;
        }
        w5Var.b(f);
        w5Var.a(f);
    }
}

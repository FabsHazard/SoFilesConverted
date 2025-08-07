package com.huawei.hms.scankit.p;

/* compiled from: FinderPattern */
public final class g3 extends u6 {
    private final float e;
    private final int f;

    g3(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    public int a() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public boolean b(float f2, float f3, float f4) {
        if (Math.abs(f3 - c()) > f2 || Math.abs(f4 - b()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.e);
        if (abs <= 1.0f || abs <= this.e) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public g3 c(float f2, float f3, float f4) {
        int i = this.f;
        int i2 = i + 1;
        float b = (((float) i) * b()) + f3;
        float f5 = (float) i2;
        return new g3(b / f5, ((((float) this.f) * c()) + f2) / f5, ((((float) this.f) * this.e) + f4) / f5, i2);
    }

    public float e() {
        return this.e;
    }

    private g3(float f2, float f3, float f4, int i) {
        super(f2, f3);
        this.e = f4;
        this.f = i;
    }
}

package com.huawei.hms.scankit.p;

/* compiled from: FinderPattern */
public final class e3 extends u6 {
    private final float e;
    private final int f;
    private final boolean g;

    e3(float f2, float f3, float f4, boolean z) {
        this(f2, f3, f4, z, 1);
    }

    /* access modifiers changed from: package-private */
    public e3 a(float f2, float f3, float f4, boolean z) {
        int i = this.f;
        int i2 = i + 1;
        float b = (((float) i) * b()) + f3;
        float f5 = (float) i2;
        float f6 = b / f5;
        float c = ((((float) this.f) * c()) + f2) / f5;
        float f7 = ((((float) this.f) * this.e) + f4) / f5;
        boolean z2 = this.g;
        return new e3(f6, c, f7, z2 ? z : z2, i2);
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

    public boolean d() {
        return this.g;
    }

    public float e() {
        return this.e;
    }

    public e3(float f2, float f3, float f4, boolean z, int i) {
        super(f2, f3, i);
        this.e = f4;
        this.f = i;
        this.g = z;
    }
}

package com.huawei.hms.scankit.p;

/* compiled from: AlignmentPattern */
public final class d extends u6 {
    private final float e;

    d(float f, float f2, float f3) {
        super(f, f2);
        this.e = f3;
    }

    /* access modifiers changed from: package-private */
    public boolean b(float f, float f2, float f3) {
        if (Math.abs(f2 - c()) > f || Math.abs(f3 - b()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.e);
        if (abs <= 1.0f || abs <= this.e) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public d c(float f, float f2, float f3) {
        return new d((b() + f2) / 2.0f, (c() + f) / 2.0f, (this.e + f3) / 2.0f);
    }
}

package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;

/* compiled from: OpacityAnimator */
public class j5 implements f4 {
    private final int a;
    private final int b;
    private final long c;
    private final long d;
    private final float e;
    private final Interpolator f;

    public j5(int i, int i2, long j, long j2, Interpolator interpolator) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = (float) (j2 - j);
        this.f = interpolator;
    }

    private int a(w5 w5Var) {
        int i = this.b;
        return i == -1 ? w5Var.e() : i;
    }

    private int b(w5 w5Var) {
        int i = this.a;
        return i == -1 ? w5Var.a() : i;
    }

    private int c(w5 w5Var) {
        return a(w5Var) - b(w5Var);
    }

    public void a(w5 w5Var, long j) {
        if (j >= this.c && j <= this.d && Float.compare(this.e, 0.0f) != 0) {
            w5Var.a((int) (((float) b(w5Var)) + (((float) c(w5Var)) * this.f.getInterpolation(((float) (j - this.c)) / this.e))));
        }
    }
}

package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
import java.math.BigDecimal;

/* compiled from: CubicBezierInterpolator */
public class b1 implements Interpolator {
    private static final BigDecimal e;
    private static final BigDecimal f;
    private static final float g;
    private float a;
    private float b;
    private float c;
    private float d;

    static {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(1.0f));
        e = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(Long.toString(4000));
        f = bigDecimal2;
        g = bigDecimal.divide(bigDecimal2, 20, 4).floatValue();
    }

    public b1(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
    }

    private long a(float f2) {
        long j = 0;
        long j2 = 4000;
        while (j <= j2) {
            long j3 = (j + j2) >>> 1;
            int i = (b(g * ((float) j3)) > f2 ? 1 : (b(g * ((float) j3)) == f2 ? 0 : -1));
            if (i < 0) {
                j = j3 + 1;
            } else if (i <= 0) {
                return j3;
            } else {
                j2 = j3 - 1;
            }
        }
        return j;
    }

    private float b(float f2) {
        float f3 = 1.0f - f2;
        float f4 = 3.0f * f3;
        return (f3 * f4 * f2 * this.a) + (f4 * f2 * f2 * this.c) + (f2 * f2 * f2);
    }

    private float c(float f2) {
        float f3 = 1.0f - f2;
        float f4 = 3.0f * f3;
        return (f3 * f4 * f2 * this.b) + (f4 * f2 * f2 * this.d) + (f2 * f2 * f2);
    }

    public float getInterpolation(float f2) {
        return c(g * ((float) a(f2)));
    }

    public String toString() {
        return a();
    }

    private String a() {
        StringBuilder sb = new StringBuilder("CubicBezierInterpolator  mControlPoint1x = ");
        sb.append(this.a);
        sb.append(", mControlPoint1y = ").append(this.b);
        sb.append(", mControlPoint2x = ").append(this.c);
        sb.append(", mControlPoint2y = ").append(this.d);
        return sb.toString();
    }
}

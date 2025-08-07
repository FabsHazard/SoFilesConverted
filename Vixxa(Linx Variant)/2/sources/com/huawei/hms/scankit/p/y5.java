package com.huawei.hms.scankit.p;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.List;

/* compiled from: ParticleEffect */
public class y5 {
    private long a = 0;
    private long b = 0;
    private int c = 0;
    private int d = 0;
    private int e;
    private float f;
    private Rect g;
    private b6 h;

    public y5(b6 b6Var, Rect rect, int i, float f2, int[] iArr) {
        this.h = b6Var;
        this.g = rect;
        this.e = i;
        if (iArr != null && iArr.length >= 2) {
            this.c = iArr[0];
            this.d = iArr[1];
        }
        this.f = f2;
        c();
    }

    private void a() {
        b6 b6Var = this.h;
        if (b6Var != null) {
            b6Var.a();
        }
    }

    private int b() {
        float a2 = n6.a(1.0f);
        int red = Color.red(this.c);
        int blue = Color.blue(this.c);
        int green = Color.green(this.c);
        return Color.rgb((int) (((float) red) + (((float) (Color.red(this.d) - red)) * a2) + 0.5f), (int) (((float) green) + (((float) (Color.green(this.d) - green)) * a2) + 0.5f), (int) (((float) blue) + (((float) (Color.blue(this.d) - blue)) * a2) + 0.5f));
    }

    private void c() {
        Rect rect;
        a();
        this.b = 0;
        this.a = System.currentTimeMillis();
        b6 b6Var = this.h;
        if (b6Var != null && (rect = this.g) != null) {
            b6Var.a(rect, this.e);
        }
    }

    public void a(Canvas canvas, Rect rect) {
        if (this.h != null && canvas != null && rect != null) {
            long currentTimeMillis = this.b + (System.currentTimeMillis() - this.a);
            this.b = currentTimeMillis;
            this.h.b(currentTimeMillis);
            List<w5> c2 = this.h.c();
            if (c2 != null && !c2.isEmpty()) {
                a(canvas, rect, c2);
                this.a = System.currentTimeMillis();
            }
        }
    }

    private void a(Canvas canvas, Rect rect, List<w5> list) {
        for (w5 next : list) {
            Paint paint = new Paint();
            if (next.b() == 0) {
                next.b(b());
            }
            paint.setColor(next.b());
            boolean z = next.d() > ((float) Math.max(rect.top, rect.bottom)) || next.d() < ((float) Math.min(rect.top, rect.bottom));
            float f2 = 0.0f;
            if (!(rect.height() == 0 || rect.width() == 0 || z)) {
                f2 = (((float) rect.bottom) - next.d()) / ((float) rect.height());
            }
            int a2 = (int) (((float) next.a()) * Math.abs(f2));
            if (a2 > 0) {
                paint.setAlpha(a2);
                canvas.drawCircle(next.c(), next.d(), next.f() * this.f, paint);
            }
        }
    }
}

package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleSystem */
public class b6 {
    private static final Object r = new Object();
    private final ArrayList<w5> a = new ArrayList<>();
    private final ArrayList<w5> b = new ArrayList<>();
    private int c;
    private long d;
    private boolean e;
    private float f;
    private int[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m = false;
    private Path n;
    private PathMeasure o;
    private x5 p = new x5();
    private z5 q = new z5();

    public b6(int i2, long j2) {
        a(i2, j2);
        a((Bitmap) null);
    }

    private void a(g4 g4Var) {
        if (this.q == null) {
            this.q = new z5();
        }
        this.q.a(g4Var);
    }

    public b6 b(float f2, float f3) {
        a((g4) new a6(f2, f3));
        return this;
    }

    public List<w5> c() {
        List<w5> unmodifiableList;
        synchronized (r) {
            unmodifiableList = Collections.unmodifiableList(this.b);
        }
        return unmodifiableList;
    }

    public void b(long j2) {
        boolean z = this.e;
        float f2 = this.f * ((float) j2);
        ArrayList arrayList = new ArrayList();
        synchronized (r) {
            while (z) {
                if (this.a.isEmpty() || ((float) this.h) >= f2) {
                    break;
                }
                a(j2);
            }
            Iterator<w5> it = this.b.iterator();
            while (it.hasNext()) {
                w5 next = it.next();
                if (!next.a(j2)) {
                    it.remove();
                    arrayList.add(next);
                }
            }
        }
        this.a.addAll(arrayList);
    }

    public b6 a(int i2, int i3, long j2, long j3, Interpolator interpolator) {
        a((f4) new j5(i2, i3, j2, j3, interpolator));
        return this;
    }

    private void a(f4 f4Var) {
        if (this.p == null) {
            this.p = new x5();
        }
        this.p.a(f4Var);
    }

    private void a(int i2, long j2) {
        this.g = new int[2];
        this.c = i2;
        this.d = j2;
    }

    private void a(Bitmap bitmap) {
        for (int i2 = 0; i2 < this.c; i2++) {
            this.a.add(new w5(bitmap));
        }
    }

    public void a(Rect rect, int i2) {
        a(rect);
        a(i2);
    }

    private void a(int i2) {
        synchronized (r) {
            this.h = 0;
        }
        this.f = ((float) i2) / 1000.0f;
        this.e = true;
    }

    private void b() {
        ArrayList arrayList;
        synchronized (r) {
            arrayList = new ArrayList(this.b);
        }
        this.a.addAll(arrayList);
    }

    private void a(Rect rect) {
        int i2 = rect.left - this.g[0];
        this.j = i2;
        this.i = i2 + rect.width();
        int i3 = rect.top - this.g[1];
        this.l = i3;
        this.k = i3 + rect.height();
    }

    private void a(long j2) {
        PathMeasure pathMeasure;
        w5 remove = this.a.remove(0);
        this.q.a(remove);
        if (!this.m || (pathMeasure = this.o) == null) {
            remove.a(this.d, (float) a(this.j, this.i), (float) a(this.l, this.k), j2, this.p);
        } else {
            float[] a2 = a(0.0f, pathMeasure.getLength());
            remove.a(this.d, (float) ((int) a2[0]), (float) ((int) a2[1]), j2, this.p);
        }
        synchronized (r) {
            this.b.add(remove);
            this.h++;
        }
    }

    private int a(int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        if (i2 < i3) {
            return n6.a(i3 - i2) + i2;
        }
        return n6.a(i2 - i3) + i3;
    }

    private float[] a(float f2, float f3) {
        float f4;
        if (Float.compare(f2, f3) <= 0) {
            f4 = n6.a(f3 - f2) + f2;
        } else {
            f4 = f3 + n6.a(f2 - f3);
        }
        if (this.o == null) {
            this.o = new PathMeasure(this.n, true);
        }
        float[] fArr = new float[2];
        this.o.getPosTan(f4, fArr, (float[]) null);
        float f5 = fArr[0];
        int[] iArr = this.g;
        fArr[0] = f5 - ((float) iArr[0]);
        fArr[1] = fArr[1] - ((float) iArr[1]);
        return fArr;
    }

    public void a() {
        b();
    }
}

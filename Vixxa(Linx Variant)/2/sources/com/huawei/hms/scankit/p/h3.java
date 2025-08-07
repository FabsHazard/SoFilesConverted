package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: FinderPatternFinder */
public class h3 {
    private final s a;
    private final List<g3> b = new ArrayList();
    private final int[] c = new int[5];
    private final v6 d;

    /* compiled from: FinderPatternFinder */
    private static final class b implements Comparator<g3>, Serializable {
        private b() {
        }

        /* renamed from: a */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Float.compare(g3Var2.e(), g3Var.e());
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class c implements Comparator<g3>, Serializable {
        private c() {
        }

        /* renamed from: a */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Integer.compare(g3Var2.a(), g3Var.a());
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class d implements Comparator<g3>, Serializable {
        private final float a;

        /* renamed from: a */
        public int compare(g3 g3Var, g3 g3Var2) {
            return Float.compare(Math.abs(g3Var.e() - this.a), Math.abs(g3Var2.e() - this.a));
        }

        private d(float f) {
            this.a = f;
        }
    }

    public h3(s sVar, v6 v6Var) {
        this.a = sVar;
        this.d = v6Var;
    }

    protected static boolean b(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 6) {
            return false;
        }
        float f = ((float) i) / 6.0f;
        float f2 = f / 1.5f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 2.0f) - ((float) iArr[2])) >= 2.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    protected static boolean c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 6) {
            return false;
        }
        float f = ((float) i) / 6.0f;
        float f2 = f / 1.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 2.0f) - ((float) iArr[2])) >= 2.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    private void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    /* access modifiers changed from: package-private */
    public final g3[] a(Map<l1, ?> map) throws a {
        int c2 = this.a.c();
        int e = this.a.e();
        int[] iArr = new int[5];
        for (int i = 0; i < c2; i++) {
            a(iArr);
            int i2 = 0;
            for (int i3 = 0; i3 < e; i3++) {
                if (this.a.b(i3, i)) {
                    if ((i2 & 1) == 1) {
                        i2++;
                    }
                    iArr[i2] = iArr[i2] + 1;
                } else if ((i2 & 1) != 0) {
                    iArr[i2] = iArr[i2] + 1;
                } else if (i2 == 4) {
                    if (!b(iArr)) {
                        d(iArr);
                    } else if (!a(iArr, i, i3)) {
                        d(iArr);
                    } else {
                        a(iArr);
                        i2 = 0;
                    }
                    i2 = 3;
                } else {
                    i2++;
                    iArr[i2] = iArr[i2] + 1;
                }
            }
            if (b(iArr)) {
                a(iArr, i, e);
            }
        }
        return b();
    }

    private float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        s sVar = this.a;
        int c2 = sVar.c();
        int[] a2 = a();
        int i8 = i;
        while (i8 >= 0 && sVar.b(i2, i8)) {
            a2[2] = a2[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !sVar.b(i2, i8)) {
            int i9 = a2[1];
            if (i9 > i3) {
                break;
            }
            a2[1] = i9 + 1;
            i8--;
        }
        if (i8 < 0 || a2[1] > i3) {
            return Float.NaN;
        }
        while (i8 >= 0 && sVar.b(i2, i8) && (i7 = a2[0]) <= i3) {
            a2[0] = i7 + 1;
            i8--;
        }
        if (a2[0] > i3) {
            return Float.NaN;
        }
        int i10 = i + 1;
        while (i10 < c2 && sVar.b(i2, i10)) {
            a2[2] = a2[2] + 1;
            i10++;
        }
        if (i10 == c2) {
            return Float.NaN;
        }
        while (i10 < c2 && !sVar.b(i2, i10) && (i6 = a2[3]) < i3) {
            a2[3] = i6 + 1;
            i10++;
        }
        if (i10 == c2 || a2[3] >= i3) {
            return Float.NaN;
        }
        while (i10 < c2 && sVar.b(i2, i10) && (i5 = a2[4]) < i3) {
            a2[4] = i5 + 1;
            i10++;
        }
        int i11 = a2[4];
        if (i11 < i3 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + i11) - i4) * 5 < i4 * 2 && b(a2)) {
            return a(a2, i10);
        }
        return Float.NaN;
    }

    private static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    private int[] a() {
        a(this.c);
        return this.c;
    }

    private void a(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    private boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] a2 = a();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.a.b(i2 - i6, i - i6)) {
            a2[2] = a2[2] + 1;
            i6++;
        }
        if (a2[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.a.b(i2 - i6, i - i6)) {
            a2[1] = a2[1] + 1;
            i6++;
        }
        if (a2[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.a.b(i2 - i6, i - i6)) {
            a2[0] = a2[0] + 1;
            i6++;
        }
        if (a2[0] == 0) {
            return false;
        }
        int c2 = this.a.c();
        int e = this.a.e();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 < c2 && (i5 = i2 + i7) < e && this.a.b(i5, i8)) {
                a2[2] = a2[2] + 1;
                i7++;
            }
        }
        while (true) {
            int i9 = i + i7;
            if (i9 < c2 && (i4 = i2 + i7) < e && !this.a.b(i4, i9)) {
                a2[3] = a2[3] + 1;
                i7++;
            }
        }
        if (a2[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 < c2 && (i3 = i2 + i7) < e && this.a.b(i3, i10)) {
                a2[4] = a2[4] + 1;
                i7++;
            }
        }
        if (a2[4] == 0) {
            return false;
        }
        return c(a2);
    }

    private g3[] b() throws a {
        int i = 0;
        while (i < this.b.size()) {
            g3 g3Var = this.b.get(i);
            if (g3Var.e() <= 5.0f && g3Var.a() <= 2) {
                this.b.remove(i);
                i--;
            }
            i++;
        }
        int size = this.b.size();
        int i2 = 3;
        if (size >= 3) {
            if (size >= 4) {
                float f = 0.0f;
                float f2 = 0.0f;
                for (g3 a2 : this.b) {
                    f2 += (float) a2.a();
                }
                float f3 = f2 / ((float) size);
                int i3 = 0;
                while (i3 < this.b.size() && this.b.size() > 4) {
                    if (((float) this.b.get(i3).a()) <= 0.5f * f3) {
                        this.b.remove(i3);
                        i3--;
                    }
                    i3++;
                }
                int size2 = this.b.size();
                float f4 = 0.0f;
                for (g3 e : this.b) {
                    float e2 = e.e();
                    f += e2;
                    f4 += e2 * e2;
                }
                float f5 = (float) size2;
                float f6 = f / f5;
                float sqrt = (float) Math.sqrt((double) ((f4 / f5) - (f6 * f6)));
                Collections.sort(this.b, new d(f6));
                float max = Math.max(0.36f * f6, sqrt);
                int i4 = 0;
                while (i4 < this.b.size() && this.b.size() > 4) {
                    if (Math.abs(this.b.get(i4).e() - f6) > max) {
                        this.b.remove(i4);
                        i4--;
                    }
                    i4++;
                }
                int size3 = this.b.size();
                if (size3 >= 4) {
                    Collections.sort(this.b, new c());
                    if (size3 > 4 && this.b.get(3).a() - this.b.get(4).a() > 2) {
                        while (4 < this.b.size()) {
                            this.b.remove(4);
                        }
                    }
                    double[] dArr = new double[3];
                    while (i2 < this.b.size()) {
                        dArr[0] = a(this.b.get(0), this.b.get(1));
                        dArr[1] = a(this.b.get(1), this.b.get(i2));
                        dArr[2] = a(this.b.get(0), this.b.get(i2));
                        Arrays.sort(dArr);
                        double d2 = dArr[1];
                        double d3 = dArr[0];
                        double sqrt2 = ((d2 + d3) - dArr[2]) / ((Math.sqrt(d3) * 2.0d) * Math.sqrt(dArr[1]));
                        dArr[0] = a(this.b.get(0), this.b.get(2));
                        dArr[1] = a(this.b.get(2), this.b.get(i2));
                        dArr[2] = a(this.b.get(0), this.b.get(i2));
                        Arrays.sort(dArr);
                        double d4 = dArr[1];
                        double d5 = dArr[0];
                        double sqrt3 = ((d4 + d5) - dArr[2]) / ((Math.sqrt(d5) * 2.0d) * Math.sqrt(dArr[1]));
                        if (Math.abs(sqrt2) > 0.25d || Math.abs(sqrt3) > 0.25d) {
                            this.b.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                }
            }
            Collections.sort(this.b, new b());
            List<g3> list = this.b;
            return (g3[]) list.toArray(new g3[list.size()]);
        }
        throw a.a();
    }

    private float a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        s sVar = this.a;
        int e = sVar.e();
        int[] a2 = a();
        int i8 = i;
        while (i8 >= 0 && sVar.b(i8, i2)) {
            a2[2] = a2[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !sVar.b(i8, i2)) {
            int i9 = a2[1];
            if (i9 > i3) {
                break;
            }
            a2[1] = i9 + 1;
            i8--;
        }
        if (i8 < 0 || a2[1] > i3) {
            return Float.NaN;
        }
        while (i8 >= 0 && sVar.b(i8, i2) && (i7 = a2[0]) <= i3) {
            a2[0] = i7 + 1;
            i8--;
        }
        if (a2[0] > i3) {
            return Float.NaN;
        }
        int i10 = i + 1;
        while (i10 < e && sVar.b(i10, i2)) {
            a2[2] = a2[2] + 1;
            i10++;
        }
        if (i10 == e) {
            return Float.NaN;
        }
        while (i10 < e && !sVar.b(i10, i2) && (i6 = a2[3]) < i3) {
            a2[3] = i6 + 1;
            i10++;
        }
        if (i10 == e || a2[3] >= i3) {
            return Float.NaN;
        }
        while (i10 < e && sVar.b(i10, i2) && (i5 = a2[4]) < i3) {
            a2[4] = i5 + 1;
            i10++;
        }
        int i11 = a2[4];
        if (i11 < i3 && Math.abs(((((a2[0] + a2[1]) + a2[2]) + a2[3]) + i11) - i4) * 5 < i4 && b(a2)) {
            return a(a2, i10);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i2);
        float b2 = b(i, a2, iArr[2], i4);
        if (!Float.isNaN(b2)) {
            int i5 = (int) b2;
            float a3 = a(a2, i5, iArr[2], i4);
            if (!Float.isNaN(a3) && a(i5, (int) a3)) {
                float f = ((float) i4) / 6.0f;
                while (true) {
                    if (i3 < this.b.size()) {
                        g3 g3Var = this.b.get(i3);
                        if (g3Var.b(f, b2, a3)) {
                            this.b.set(i3, g3Var.c(b2, a3, f));
                            break;
                        }
                        i3++;
                    } else {
                        g3 g3Var2 = new g3(a3, b2, f);
                        this.b.add(g3Var2);
                        v6 v6Var = this.d;
                        if (v6Var != null) {
                            v6Var.a(g3Var2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static double a(g3 g3Var, g3 g3Var2) {
        double b2 = (double) (g3Var.b() - g3Var2.b());
        double c2 = (double) (g3Var.c() - g3Var2.c());
        return (b2 * b2) + (c2 * c2);
    }
}

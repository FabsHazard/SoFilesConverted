package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder */
final class e {
    private final s a;
    private final List<d> b = new ArrayList(5);
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final int[] h;
    private final v6 i;

    e(s sVar, int i2, int i3, int i4, int i5, float f2, v6 v6Var) {
        this.a = sVar;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f2;
        this.h = new int[3];
        this.i = v6Var;
    }

    /* access modifiers changed from: package-private */
    public d a() throws a {
        d a2;
        int i2 = this.c;
        int i3 = this.f;
        int i4 = this.e + i2;
        int i5 = this.d + (i3 / 2);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            int[] iArr = {0, 0, 0};
            int i8 = i2;
            while (i8 < i4 && !this.a.b(i8, i7)) {
                i8++;
            }
            d a3 = a(i7, i8, i4, iArr);
            if (a3 != null) {
                return a3;
            }
            if (a(iArr) && (a2 = a(iArr, i7, i4)) != null) {
                return a2;
            }
        }
        if (!this.b.isEmpty()) {
            return this.b.get(0);
        }
        throw a.a();
    }

    private d a(int i2, int i3, int i4, int[] iArr) {
        d a2;
        int i5 = 0;
        while (i3 < i4) {
            if (!this.a.b(i3, i2)) {
                if (i5 == 1) {
                    i5++;
                }
                iArr[i5] = iArr[i5] + 1;
            } else if (i5 == 1) {
                iArr[1] = iArr[1] + 1;
            } else if (i5 != 2) {
                i5++;
                iArr[i5] = iArr[i5] + 1;
            } else if (a(iArr) && (a2 = a(iArr, i2, i3)) != null) {
                return a2;
            } else {
                iArr[0] = iArr[2];
                iArr[1] = 1;
                iArr[2] = 0;
                i5 = 1;
            }
            i3++;
        }
        return null;
    }

    private static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f2 = this.g;
        float f3 = (3.0f * f2) / 4.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }

    private float a(int i2, int i3, int i4, int i5) {
        int i6;
        s sVar = this.a;
        int c2 = sVar.c();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i7 = i2;
        while (i7 >= 0 && sVar.b(i3, i7)) {
            int i8 = iArr[1];
            if (i8 > i4) {
                break;
            }
            iArr[1] = i8 + 1;
            i7--;
        }
        if (i7 < 0 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i7 >= 0 && !sVar.b(i3, i7)) {
            int i9 = iArr[0];
            if (i9 > i4) {
                break;
            }
            iArr[0] = i9 + 1;
            i7--;
        }
        if (iArr[0] > i4) {
            return Float.NaN;
        }
        int i10 = i2 + 1;
        while (i10 < c2 && sVar.b(i3, i10)) {
            int i11 = iArr[1];
            if (i11 > i4) {
                break;
            }
            iArr[1] = i11 + 1;
            i10++;
        }
        if (i10 == c2 || iArr[1] > i4) {
            return Float.NaN;
        }
        while (i10 < c2 && !sVar.b(i3, i10)) {
            int i12 = iArr[2];
            if (i12 > i4) {
                break;
            }
            iArr[2] = i12 + 1;
            i10++;
        }
        int i13 = iArr[2];
        if (i13 <= i4 && (i6 = iArr[0] + iArr[1] + i13) < i5 * 3 && i6 * 3 > i5 && a(iArr)) {
            return a(iArr, i10);
        }
        return Float.NaN;
    }

    private d a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float a2 = a(iArr, i3);
        float a3 = a(i2, (int) a2, iArr[1] * 3, i4);
        if (Float.isNaN(a3)) {
            return null;
        }
        float f2 = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (d next : this.b) {
            if (next.b(f2, a3, a2)) {
                return next.c(a3, a2, f2);
            }
        }
        d dVar = new d(a2, a3, f2);
        this.b.add(dVar);
        v6 v6Var = this.i;
        if (v6Var == null) {
            return null;
        }
        v6Var.a(dVar);
        return null;
    }
}

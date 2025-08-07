package com.huawei.hms.scankit.p;

import kotlin.text.Typography;

/* compiled from: Detector */
public final class c2 {
    private static final int[] g = {3808, 476, 2107, 1799};
    private final s a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    /* compiled from: Detector */
    static final class a {
        /* access modifiers changed from: private */
        public final int a;
        /* access modifiers changed from: private */
        public final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* access modifiers changed from: package-private */
        public u6 c() {
            return new u6((float) this.a, (float) this.b);
        }

        public String toString() {
            return "<" + this.a + ' ' + this.b + Typography.greater;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.b;
        }
    }

    public c2(s sVar) {
        this.a = sVar;
    }

    private a b() {
        u6 u6Var;
        u6 u6Var2;
        u6 u6Var3;
        u6 u6Var4;
        u6 u6Var5;
        u6 u6Var6;
        u6 u6Var7;
        u6 u6Var8;
        try {
            u6[] a2 = new j8(this.a).a();
            u6Var3 = a2[0];
            u6Var2 = a2[1];
            u6Var = a2[2];
            u6Var4 = a2[3];
        } catch (a unused) {
            int e2 = this.a.e() / 2;
            int c2 = this.a.c() / 2;
            int i = e2 + 7;
            int i2 = c2 - 7;
            u6 c3 = a(new a(i, i2), false, 1, -1).c();
            int i3 = c2 + 7;
            u6 c4 = a(new a(i, i3), false, 1, 1).c();
            int i4 = e2 - 7;
            u6 c5 = a(new a(i4, i3), false, -1, 1).c();
            u6Var4 = a(new a(i4, i2), false, -1, -1).c();
            u6 u6Var9 = c4;
            u6Var = c5;
            u6Var3 = c3;
            u6Var2 = u6Var9;
        }
        int a3 = s4.a((((u6Var3.b() + u6Var4.b()) + u6Var2.b()) + u6Var.b()) / 4.0f);
        int a4 = s4.a((((u6Var3.c() + u6Var4.c()) + u6Var2.c()) + u6Var.c()) / 4.0f);
        try {
            u6[] a5 = new j8(this.a, 15, a3, a4).a();
            u6Var6 = a5[0];
            u6Var5 = a5[1];
            u6Var7 = a5[2];
            u6Var8 = a5[3];
        } catch (a unused2) {
            int i5 = a3 + 7;
            int i6 = a4 - 7;
            u6Var6 = a(new a(i5, i6), false, 1, -1).c();
            int i7 = a4 + 7;
            u6Var5 = a(new a(i5, i7), false, 1, 1).c();
            int i8 = a3 - 7;
            u6Var7 = a(new a(i8, i7), false, -1, 1).c();
            u6Var8 = a(new a(i8, i6), false, -1, -1).c();
        }
        return new a(s4.a((((u6Var6.b() + u6Var8.b()) + u6Var5.b()) + u6Var7.b()) / 4.0f), s4.a((((u6Var6.c() + u6Var8.c()) + u6Var5.c()) + u6Var7.c()) / 4.0f));
    }

    public g a(boolean z) throws a {
        u6[] a2 = a(b());
        if (z) {
            u6 u6Var = a2[0];
            a2[0] = a2[2];
            a2[2] = u6Var;
        }
        a(a2);
        s sVar = this.a;
        int i = this.f;
        return new g(a(sVar, a2[i % 4], a2[(i + 1) % 4], a2[(i + 2) % 4], a2[(i + 3) % 4]), b(a2), this.b, this.d, this.c);
    }

    private void a(u6[] u6VarArr) throws a {
        long j;
        long j2;
        if (!a(u6VarArr[0]) || !a(u6VarArr[1]) || !a(u6VarArr[2]) || !a(u6VarArr[3])) {
            throw a.a();
        }
        int i = this.e * 2;
        int[] iArr = {a(u6VarArr[0], u6VarArr[1], i), a(u6VarArr[1], u6VarArr[2], i), a(u6VarArr[2], u6VarArr[3], i), a(u6VarArr[3], u6VarArr[0], i)};
        this.f = a(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.f + i2) % 4];
            if (this.b) {
                j2 = j3 << 7;
                j = (long) ((i3 >> 1) & 127);
            } else {
                j2 = j3 << 10;
                j = (long) (((i3 >> 2) & 992) + ((i3 >> 1) & 31));
            }
            j3 = j2 + j;
        }
        int a2 = a(j3, this.b);
        if (this.b) {
            this.c = (a2 >> 6) + 1;
            this.d = (a2 & 63) + 1;
            return;
        }
        this.c = (a2 >> 11) + 1;
        this.d = (a2 & 2047) + 1;
    }

    private u6[] b(u6[] u6VarArr) {
        return a(u6VarArr, this.e * 2, a());
    }

    private boolean b(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int b2 = b(aVar8, aVar5);
        if (b2 != 0 && b(aVar5, aVar6) == b2 && b(aVar6, aVar7) == b2 && b(aVar7, aVar8) == b2) {
            return true;
        }
        return false;
    }

    private int b(a aVar, a aVar2) {
        float a2 = a(aVar, aVar2);
        float a3 = ((float) (aVar2.a() - aVar.a())) / a2;
        float b2 = ((float) (aVar2.b() - aVar.b())) / a2;
        float a4 = (float) aVar.a();
        float b3 = (float) aVar.b();
        boolean b4 = this.a.b(aVar.a(), aVar.b());
        int ceil = (int) Math.ceil((double) a2);
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < ceil; i2++) {
            a4 += a3;
            b3 += b2;
            if (this.a.b(s4.a(a4), s4.a(b3)) != b4) {
                i++;
            }
        }
        float f2 = ((float) i) / a2;
        if (f2 > 0.1f && f2 < 0.9f) {
            return 0;
        }
        if (f2 <= 0.1f) {
            z = true;
        }
        return z == b4 ? 1 : -1;
    }

    private static int a(int[] iArr, int i) throws a {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw a.a();
    }

    private static int a(long j, boolean z) throws a {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new p6(o3.k).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (a unused) {
            throw a.a();
        }
    }

    private u6[] a(a aVar) throws a {
        int i = 1;
        this.e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z = true;
        while (this.e < 9) {
            a a2 = a(aVar5, z, i, -1);
            a a3 = a(aVar4, z, i, i);
            a a4 = a(aVar3, z, -1, i);
            a a5 = a(aVar2, z, -1, -1);
            if (this.e > 2) {
                double a6 = (double) ((a(a5, a2) * ((float) this.e)) / (a(aVar2, aVar5) * ((float) (this.e + 2))));
                if (a6 < 0.75d) {
                    break;
                } else if (a6 > 1.25d) {
                    break;
                } else if (!a(a2, a3, a4, a5)) {
                    break;
                } else if (!b(a2, a3, a4, a5)) {
                    int i2 = this.e;
                    if (i2 == 5 || i2 == 7) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            z = !z;
            this.e++;
            aVar2 = a5;
            aVar5 = a2;
            aVar4 = a3;
            aVar3 = a4;
            i = 1;
        }
        int i3 = this.e;
        if (i3 == 5 || i3 == 7) {
            this.b = i3 == 5;
            u6[] u6VarArr = {new u6(((float) aVar5.a()) + 0.5f, ((float) aVar5.b()) - 0.5f), new u6(((float) aVar4.a()) + 0.5f, ((float) aVar4.b()) + 0.5f), new u6(((float) aVar3.a()) - 0.5f, ((float) aVar3.b()) + 0.5f), new u6(((float) aVar2.a()) - 0.5f, ((float) aVar2.b()) - 0.5f)};
            int i4 = this.e * 2;
            return a(u6VarArr, i4 - 3, i4);
        }
        throw a.a();
    }

    private s a(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) throws a {
        s3 a2 = s3.a();
        int a3 = a();
        int i = a3;
        int i2 = a3;
        float f2 = ((float) a3) / 2.0f;
        float f3 = (float) this.e;
        float f4 = f2 - f3;
        float f5 = f2 + f3;
        return a2.a(sVar, i2, i, f4, f4, f5, f4, f5, f5, f4, f5, u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c(), u6Var3.b(), u6Var3.c(), u6Var4.b(), u6Var4.c());
    }

    private int a(u6 u6Var, u6 u6Var2, int i) {
        float a2 = a(u6Var, u6Var2);
        float f2 = a2 / ((float) i);
        float b2 = u6Var.b();
        float c2 = u6Var.c();
        float b3 = ((u6Var2.b() - u6Var.b()) * f2) / a2;
        float c3 = (f2 * (u6Var2.c() - u6Var.c())) / a2;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f3 = (float) i3;
            if (this.a.b(s4.a((f3 * b3) + b2), s4.a((f3 * c3) + c2))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a((int) Math.ceil((double) (((float) (((aVar.a + aVar2.a) + aVar3.a) + aVar4.a)) / 4.0f)), (int) Math.ceil((double) (((float) (((aVar.b + aVar2.b) + aVar3.b) + aVar4.b)) / 4.0f)));
        float a2 = a(aVar5, aVar);
        float a3 = a(aVar5, aVar2);
        float a4 = a(aVar5, aVar3);
        float a5 = a(aVar5, aVar4);
        double d2 = (double) (a2 / a3);
        if (d2 <= 0.75d || d2 >= 1.25d) {
            return false;
        }
        double d3 = (double) (a2 / a4);
        if (d3 <= 0.75d || d3 >= 1.25d) {
            return false;
        }
        double d4 = (double) (a2 / a5);
        return d4 > 0.75d && d4 < 1.25d;
    }

    private a a(a aVar, boolean z, int i, int i2) {
        int a2 = aVar.a() + i;
        int b2 = aVar.b();
        while (true) {
            b2 += i2;
            if (!a(a2, b2) || this.a.b(a2, b2) != z) {
                int i3 = a2 - i;
                int i4 = b2 - i2;
            } else {
                a2 += i;
            }
        }
        int i32 = a2 - i;
        int i42 = b2 - i2;
        while (a(i32, i42) && this.a.b(i32, i42) == z) {
            i32 += i;
        }
        int i5 = i32 - i;
        while (a(i5, i42) && this.a.b(i5, i42) == z) {
            i42 += i2;
        }
        return new a(i5, i42 - i2);
    }

    private static u6[] a(u6[] u6VarArr, int i, int i2) {
        float f2 = ((float) i2) / (((float) i) * 2.0f);
        float b2 = u6VarArr[0].b() - u6VarArr[2].b();
        float c2 = u6VarArr[0].c() - u6VarArr[2].c();
        float b3 = (u6VarArr[0].b() + u6VarArr[2].b()) / 2.0f;
        float c3 = (u6VarArr[0].c() + u6VarArr[2].c()) / 2.0f;
        float f3 = b2 * f2;
        float f4 = c2 * f2;
        u6 u6Var = new u6(b3 + f3, c3 + f4);
        u6 u6Var2 = new u6(b3 - f3, c3 - f4);
        float b4 = u6VarArr[1].b() - u6VarArr[3].b();
        float c4 = u6VarArr[1].c() - u6VarArr[3].c();
        float b5 = (u6VarArr[1].b() + u6VarArr[3].b()) / 2.0f;
        float c5 = (u6VarArr[1].c() + u6VarArr[3].c()) / 2.0f;
        float f5 = b4 * f2;
        float f6 = f2 * c4;
        return new u6[]{u6Var, new u6(b5 + f5, c5 + f6), u6Var2, new u6(b5 - f5, c5 - f6)};
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.a.e() && i2 > 0 && i2 < this.a.c();
    }

    private boolean a(u6 u6Var) {
        return a(s4.a(u6Var.b()), s4.a(u6Var.c()));
    }

    private static float a(a aVar, a aVar2) {
        return s4.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.b(), u6Var.c(), u6Var2.b(), u6Var2.c());
    }

    private int a() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }
}

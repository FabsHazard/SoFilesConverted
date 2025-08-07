package com.huawei.hms.scankit.p;

/* compiled from: DetectionResultRowIndicatorColumn */
final class b2 extends a2 {
    private final boolean c;

    b2(a0 a0Var, boolean z) {
        super(a0Var);
        this.c = z;
    }

    private void b(k kVar) {
        a0 a = a();
        u6 g = this.c ? a.g() : a.h();
        u6 a2 = this.c ? a.a() : a.b();
        int c2 = c((int) a2.c());
        x0[] b = b();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int c3 = c((int) g.c()); c3 < c2; c3++) {
            x0 x0Var = b[c3];
            if (x0Var != null) {
                x0Var.h();
                int c4 = x0Var.c() - i;
                if (c4 == 0) {
                    i2++;
                } else {
                    if (c4 == 1) {
                        i3 = Math.max(i3, i2);
                        i = x0Var.c();
                    } else if (x0Var.c() >= kVar.c()) {
                        b[c3] = null;
                    } else {
                        i = x0Var.c();
                    }
                    i2 = 1;
                }
            }
        }
    }

    private void f() {
        for (x0 x0Var : b()) {
            if (x0Var != null) {
                x0Var.h();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(k kVar) throws a {
        x0[] b = b();
        f();
        a(b, kVar);
        a0 a = a();
        u6 g = this.c ? a.g() : a.h();
        u6 a2 = this.c ? a.a() : a.b();
        int c2 = c((int) g.c());
        int c3 = c((int) a2.c());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (c2 < c3) {
            x0 x0Var = b[c2];
            if (x0Var != null) {
                int c4 = x0Var.c() - i;
                if (c4 == 0) {
                    i2++;
                } else {
                    if (c4 == 1) {
                        i3 = Math.max(i3, i2);
                        i = x0Var.c();
                    } else if (c4 < 0 || x0Var.c() >= kVar.c() || c4 > c2) {
                        b[c2] = null;
                    } else {
                        if (i3 > 2) {
                            c4 *= i3 - 2;
                        }
                        boolean z = c4 >= c2;
                        for (int i4 = 1; i4 <= c4 && !z; i4++) {
                            z = b[c2 - i4] != null;
                        }
                        if (z) {
                            b[c2] = null;
                        } else {
                            i = x0Var.c();
                        }
                    }
                    i2 = 1;
                }
            }
            c2++;
        }
    }

    /* access modifiers changed from: package-private */
    public k c() throws a {
        x0[] b = b();
        m mVar = new m();
        m mVar2 = new m();
        m mVar3 = new m();
        m mVar4 = new m();
        for (x0 x0Var : b) {
            if (x0Var != null) {
                x0Var.h();
                int e = x0Var.e() % 30;
                int c2 = x0Var.c();
                if (!this.c) {
                    c2 += 2;
                }
                int i = c2 % 3;
                if (i == 0) {
                    mVar2.a((e * 3) + 1);
                } else if (i == 1) {
                    mVar4.a(e / 3);
                    mVar3.a(e % 3);
                } else if (i == 2) {
                    mVar.a(e + 1);
                } else {
                    throw a.a();
                }
            }
        }
        if (mVar.a().length == 0 || mVar2.a().length == 0 || mVar3.a().length == 0 || mVar4.a().length == 0 || mVar.a()[0] < 1 || mVar2.a()[0] + mVar3.a()[0] < 3 || mVar2.a()[0] + mVar3.a()[0] > 90) {
            return null;
        }
        k kVar = new k(mVar.a()[0], mVar2.a()[0], mVar3.a()[0], mVar4.a()[0]);
        a(b, kVar);
        return kVar;
    }

    /* access modifiers changed from: package-private */
    public int[] d() throws a {
        int c2;
        k c3 = c();
        if (c3 == null) {
            return null;
        }
        b(c3);
        int c4 = c3.c();
        int[] iArr = new int[c4];
        for (x0 x0Var : b()) {
            if (x0Var != null && (c2 = x0Var.c()) < c4) {
                iArr[c2] = iArr[c2] + 1;
            }
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.c;
    }

    public String toString() {
        return "IsLeft: " + this.c + 10 + super.toString();
    }

    private void a(x0[] x0VarArr, k kVar) throws a {
        for (int i = 0; i < x0VarArr.length; i++) {
            x0 x0Var = x0VarArr[i];
            if (x0Var != null) {
                int e = x0Var.e() % 30;
                int c2 = x0Var.c();
                if (c2 > kVar.c()) {
                    x0VarArr[i] = null;
                } else {
                    if (!this.c) {
                        c2 += 2;
                    }
                    int i2 = c2 % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw a.a();
                            } else if (e + 1 != kVar.a()) {
                                x0VarArr[i] = null;
                            }
                        } else if (e / 3 != kVar.b() || e % 3 != kVar.d()) {
                            x0VarArr[i] = null;
                        }
                    } else if ((e * 3) + 1 != kVar.e()) {
                        x0VarArr[i] = null;
                    }
                }
            }
        }
    }
}

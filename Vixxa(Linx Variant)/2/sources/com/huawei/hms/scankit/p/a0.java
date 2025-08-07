package com.huawei.hms.scankit.p;

/* compiled from: BoundingBox */
final class a0 {
    private final s a;
    private final u6 b;
    private final u6 c;
    private final u6 d;
    private final u6 e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    a0(s sVar, u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) throws a {
        boolean z = false;
        boolean z2 = u6Var == null || u6Var2 == null;
        z = (u6Var3 == null || u6Var4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                u6Var = new u6(0.0f, u6Var3.c());
                u6Var2 = new u6(0.0f, u6Var4.c());
            } else if (z) {
                u6Var3 = new u6((float) (sVar.e() - 1), u6Var.c());
                u6Var4 = new u6((float) (sVar.e() - 1), u6Var2.c());
            }
            this.a = sVar;
            this.b = u6Var;
            this.c = u6Var2;
            this.d = u6Var3;
            this.e = u6Var4;
            this.f = (int) Math.min(u6Var.b(), u6Var2.b());
            this.g = (int) Math.max(u6Var3.b(), u6Var4.b());
            this.h = (int) Math.min(u6Var.c(), u6Var3.c());
            this.i = (int) Math.max(u6Var2.c(), u6Var4.c());
            return;
        }
        throw a.a();
    }

    static a0 a(a0 a0Var, a0 a0Var2) throws a {
        if (a0Var == null) {
            return a0Var2;
        }
        return a0Var2 == null ? a0Var : new a0(a0Var.a, a0Var.b, a0Var.c, a0Var2.d, a0Var2.e);
    }

    /* access modifiers changed from: package-private */
    public u6 b() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public u6 g() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public u6 h() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.a0 a(int r13, int r14, boolean r15) throws com.huawei.hms.scankit.p.a {
        /*
            r12 = this;
            com.huawei.hms.scankit.p.u6 r0 = r12.b
            com.huawei.hms.scankit.p.u6 r1 = r12.c
            com.huawei.hms.scankit.p.u6 r2 = r12.d
            com.huawei.hms.scankit.p.u6 r3 = r12.e
            if (r13 <= 0) goto L_0x0029
            if (r15 == 0) goto L_0x000e
            r4 = r0
            goto L_0x000f
        L_0x000e:
            r4 = r2
        L_0x000f:
            float r5 = r4.c()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x0018
            r5 = 0
        L_0x0018:
            com.huawei.hms.scankit.p.u6 r13 = new com.huawei.hms.scankit.p.u6
            float r4 = r4.b()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0026
            r8 = r13
            goto L_0x002a
        L_0x0026:
            r10 = r13
            r8 = r0
            goto L_0x002b
        L_0x0029:
            r8 = r0
        L_0x002a:
            r10 = r2
        L_0x002b:
            if (r14 <= 0) goto L_0x005b
            if (r15 == 0) goto L_0x0032
            com.huawei.hms.scankit.p.u6 r13 = r12.c
            goto L_0x0034
        L_0x0032:
            com.huawei.hms.scankit.p.u6 r13 = r12.e
        L_0x0034:
            float r0 = r13.c()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.huawei.hms.scankit.p.s r14 = r12.a
            int r14 = r14.c()
            if (r0 < r14) goto L_0x004a
            com.huawei.hms.scankit.p.s r14 = r12.a
            int r14 = r14.c()
            int r0 = r14 + -1
        L_0x004a:
            com.huawei.hms.scankit.p.u6 r14 = new com.huawei.hms.scankit.p.u6
            float r13 = r13.b()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x0058
            r9 = r14
            goto L_0x005c
        L_0x0058:
            r11 = r14
            r9 = r1
            goto L_0x005d
        L_0x005b:
            r9 = r1
        L_0x005c:
            r11 = r3
        L_0x005d:
            com.huawei.hms.scankit.p.a0 r13 = new com.huawei.hms.scankit.p.a0
            com.huawei.hms.scankit.p.s r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.a0.a(int, int, boolean):com.huawei.hms.scankit.p.a0");
    }

    a0(a0 a0Var) {
        this.a = a0Var.a;
        this.b = a0Var.g();
        this.c = a0Var.a();
        this.d = a0Var.h();
        this.e = a0Var.b();
        this.f = a0Var.e();
        this.g = a0Var.c();
        this.h = a0Var.f();
        this.i = a0Var.d();
    }

    /* access modifiers changed from: package-private */
    public u6 a() {
        return this.c;
    }
}

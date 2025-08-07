package com.huawei.hms.scankit.p;

/* compiled from: Token */
abstract class i7 {
    static final i7 b = new a7((i7) null, 0, 0);
    private final i7 a;

    i7(i7 i7Var) {
        this.a = i7Var;
    }

    /* access modifiers changed from: package-private */
    public final i7 a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(r rVar, byte[] bArr);

    /* access modifiers changed from: package-private */
    public final i7 b(int i, int i2) {
        return new q(this, i, i2);
    }

    /* access modifiers changed from: package-private */
    public final i7 a(int i, int i2) {
        return new a7(this, i, i2);
    }
}

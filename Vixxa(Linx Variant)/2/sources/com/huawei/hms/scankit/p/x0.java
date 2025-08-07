package com.huawei.hms.scankit.p;

import com.huawei.hms.common.util.Logger;

/* compiled from: Codeword */
final class x0 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private int e = -1;

    x0(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.b - this.a;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return a(this.e);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + Logger.c + this.d;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.e = i;
    }
}

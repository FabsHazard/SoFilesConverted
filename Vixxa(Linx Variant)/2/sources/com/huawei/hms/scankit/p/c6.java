package com.huawei.hms.scankit.p;

/* compiled from: Patch */
public class c6 implements Comparable<c6> {
    public i2 a;
    public int b;

    public c6(i2 i2Var, int i) {
        this.a = i2Var;
        this.b = i;
    }

    /* renamed from: a */
    public int compareTo(c6 c6Var) {
        return Float.compare((-c6Var.a.g()) + c6Var.a.h(), (-this.a.g()) + this.a.h());
    }
}

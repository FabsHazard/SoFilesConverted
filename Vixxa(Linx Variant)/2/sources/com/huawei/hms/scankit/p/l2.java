package com.huawei.hms.scankit.p;

/* compiled from: Dimension */
public final class l2 {
    private final int a;
    private final int b;

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        if (this.a == l2Var.a && this.b == l2Var.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 32713) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}

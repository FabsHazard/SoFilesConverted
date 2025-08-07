package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrectionLevel */
public enum b3 {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final b3[] f = null;
    private final int a;

    static {
        b3 b3Var;
        b3 b3Var2;
        b3 b3Var3;
        b3 b3Var4;
        f = new b3[]{b3Var2, b3Var, b3Var4, b3Var3};
    }

    private b3(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public static b3 a(int i) {
        if (i >= 0) {
            b3[] b3VarArr = f;
            if (i < b3VarArr.length) {
                return b3VarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}

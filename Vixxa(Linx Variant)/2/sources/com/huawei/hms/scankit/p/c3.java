package com.huawei.hms.scankit.p;

/* compiled from: ErrorCorrectionLevel */
public enum c3 {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final c3[] f = null;
    private final int a;

    static {
        c3 c3Var;
        c3 c3Var2;
        c3 c3Var3;
        c3 c3Var4;
        f = new c3[]{c3Var2, c3Var, c3Var4, c3Var3};
    }

    private c3(int i) {
        this.a = i;
    }

    public static c3 a(int i) {
        if (i >= 0) {
            c3[] c3VarArr = f;
            if (i < c3VarArr.length) {
                return c3VarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}

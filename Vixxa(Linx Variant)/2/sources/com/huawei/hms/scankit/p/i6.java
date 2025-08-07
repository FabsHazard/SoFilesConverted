package com.huawei.hms.scankit.p;

/* compiled from: QRCodeDecoderMetaData */
public final class i6 {
    private final boolean a;

    i6(boolean z) {
        this.a = z;
    }

    public void a(u6[] u6VarArr) {
        if (this.a && u6VarArr != null && u6VarArr.length >= 3) {
            u6 u6Var = u6VarArr[0];
            u6VarArr[0] = u6VarArr[2];
            u6VarArr[2] = u6Var;
        }
    }
}

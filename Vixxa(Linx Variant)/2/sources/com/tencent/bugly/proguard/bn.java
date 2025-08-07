package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public final class bn extends m implements Cloneable {
    static byte[] d;
    public byte a;
    public String b;
    public byte[] c;

    public final void a(StringBuilder sb, int i) {
    }

    public bn() {
        this.a = 0;
        this.b = "";
        this.c = null;
    }

    public bn(byte b2, String str, byte[] bArr) {
        this.a = b2;
        this.b = str;
        this.c = bArr;
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.b(1, true);
        if (d == null) {
            byte[] bArr = new byte[1];
            d = bArr;
            bArr[0] = 0;
        }
        this.c = kVar.c(2, false);
    }
}

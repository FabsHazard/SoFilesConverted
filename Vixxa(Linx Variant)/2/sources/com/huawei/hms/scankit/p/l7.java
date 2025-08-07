package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: UPCAReader */
public final class l7 extends q7 {
    private final q7 h = new o2();

    public boolean a(int i, int i2, r rVar) {
        return rVar.a(i2, (i2 - i) + i2, false, false);
    }

    public s6 a(int i, r rVar, int[] iArr, Map<l1, ?> map) throws a {
        return a(this.h.a(i, rVar, iArr, map));
    }

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        return a(this.h.a(i, rVar, map));
    }

    public s6 a(p pVar, Map<l1, ?> map) throws a {
        return a(this.h.a(pVar, map));
    }

    /* access modifiers changed from: package-private */
    public BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    /* access modifiers changed from: protected */
    public int a(r rVar, int[] iArr, StringBuilder sb) throws a {
        return this.h.a(rVar, iArr, sb);
    }

    private static s6 a(s6 s6Var) throws a {
        String k = s6Var.k();
        if (k.charAt(0) == '0') {
            return new s6(k.substring(1), (byte[]) null, s6Var.j(), BarcodeFormat.UPC_A);
        }
        throw a.a();
    }

    /* access modifiers changed from: package-private */
    public boolean a(int[] iArr, int[] iArr2) throws a {
        int i = iArr2[1];
        int i2 = iArr[1];
        int i3 = iArr[0];
        if (Math.abs(((int) Math.round(((double) (i - i3)) / (((double) ((i - iArr2[0]) + (i2 - i3))) / 6.0d))) - 113) <= 5) {
            return true;
        }
        return false;
    }
}

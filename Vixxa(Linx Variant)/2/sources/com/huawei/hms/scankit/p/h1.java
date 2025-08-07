package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: DataMatrixReader */
public final class h1 implements o6 {
    private static final u6[] b = new u6[0];
    private final t1 a = new t1();

    public s6 a(p pVar, Map<l1, ?> map) throws a {
        j2 a2 = new d2(pVar.b()).a();
        try {
            w1 a3 = this.a.a(a2.a(), map);
            return new s6(a3.d(), a3.c(), a2.d(), BarcodeFormat.DATA_MATRIX);
        } catch (a e) {
            if (a2.d() == null || r3.c) {
                throw e;
            }
            double sqrt = Math.sqrt(Math.pow((double) (a2.d()[0].b() - a2.d()[1].b()), 2.0d) + Math.pow((double) (a2.d()[0].c() - a2.d()[1].c()), 2.0d));
            double sqrt2 = Math.sqrt(Math.pow((double) (a2.d()[0].b() - a2.d()[3].b()), 2.0d) + Math.pow((double) (a2.d()[0].c() - a2.d()[3].c()), 2.0d));
            if (this.a.a() != null && Math.abs(sqrt - sqrt2) / sqrt < 0.1d) {
                return new s6((String) null, (byte[]) null, a2.d(), BarcodeFormat.DATA_MATRIX);
            }
            throw e;
        }
    }
}

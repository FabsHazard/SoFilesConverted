package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: ParserRegister */
public class v5 {
    private static final t6[] a = {new t2(), new n4(), new f7(), new w6(), new k8(), new z(), new x7(), new y7(), new t3(), new u7(), new q4(), new x(), new c(), new i4(), new g6(), new n2()};

    public static HmsScan a(s6 s6Var) {
        if (s6Var == null) {
            return null;
        }
        for (t6 b : a) {
            HmsScan b2 = b.b(s6Var);
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }
}

package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader */
public final class r5 implements o6 {
    private static final s6[] a = new s6[0];

    private static int b(u6 u6Var, u6 u6Var2) {
        if (u6Var == null || u6Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(u6Var.b() - u6Var2.b());
    }

    public s6 a(p pVar, Map<l1, ?> map) throws a {
        s6 s6Var;
        s6[] a2 = a(pVar, map, false);
        if (a2.length != 0 && (s6Var = a2[0]) != null) {
            return s6Var;
        }
        throw a.a();
    }

    private static int b(u6[] u6VarArr) {
        return Math.min(Math.min(b(u6VarArr[0], u6VarArr[4]), (b(u6VarArr[6], u6VarArr[2]) * 17) / 18), Math.min(b(u6VarArr[1], u6VarArr[5]), (b(u6VarArr[7], u6VarArr[3]) * 17) / 18));
    }

    private static s6[] a(p pVar, Map<l1, ?> map, boolean z) throws a {
        ArrayList arrayList = new ArrayList();
        o5 a2 = f2.a(pVar, map, z);
        for (u6[] next : a2.b()) {
            w1 a3 = t5.a(a2.a(), next[4], next[5], next[6], next[7], b(next), a(next), map);
            if (f2.a()) {
                for (int i = 0; i < next.length; i++) {
                    if (next[i] != null) {
                        next[i] = new u6(((float) (pVar.e() - 1)) - next[i].b(), ((float) (pVar.c() - 1)) - next[i].c());
                    }
                }
            }
            if (next.length == 8) {
                u6 u6Var = next[0];
                if (u6Var == null && next[1] == null && next[4] == null && next[5] == null) {
                    next[0] = next[6];
                    next[1] = next[7];
                    next[4] = next[2];
                    next[5] = next[3];
                } else if (next[2] == null && next[3] == null && next[6] == null && next[7] == null) {
                    next[2] = next[4];
                    next[3] = next[5];
                    next[6] = u6Var;
                    next[7] = next[1];
                }
                arrayList.add(new s6(a3.d(), a3.c(), next, BarcodeFormat.PDF_417));
            } else {
                throw a.a("pdf417 points size incorrect!");
            }
        }
        return (s6[]) arrayList.toArray(a);
    }

    private static int a(u6 u6Var, u6 u6Var2) {
        if (u6Var == null || u6Var2 == null) {
            return 0;
        }
        return (int) Math.abs(u6Var.b() - u6Var2.b());
    }

    private static int a(u6[] u6VarArr) {
        return Math.max(Math.max(a(u6VarArr[0], u6VarArr[4]), (a(u6VarArr[6], u6VarArr[2]) * 17) / 18), Math.max(a(u6VarArr[1], u6VarArr[5]), (a(u6VarArr[7], u6VarArr[3]) * 17) / 18));
    }
}

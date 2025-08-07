package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: HarmonyCodeDecoder */
public class z3 implements o6 {
    private Map<l1, Object> a = new EnumMap(l1.class);
    private final u1 b = new u1();

    private s6 a(int i, e2 e2Var, Map<l1, ?> map) throws a {
        int i2 = 1;
        int max = Math.max(1, i - 2);
        int min = Math.min(6, i + 2);
        int max2 = Math.max(Math.abs(i - max), Math.abs(i - min));
        int i3 = 0;
        j2 j2Var = null;
        while (i3 <= max2 * 2) {
            i += i3 * i2;
            if (i >= max && i <= min) {
                try {
                    j2Var = e2Var.a(i);
                    w1 a2 = this.b.a(j2Var.a(), map);
                    if (a2.d() != null) {
                        return new s6(a2.d(), a2.c(), j2Var.d(), BarcodeFormat.HARMONY_CODE);
                    }
                } catch (a unused) {
                    continue;
                }
            }
            i3++;
            i2 *= -1;
        }
        if (j2Var == null || j2Var.d().length <= 3) {
            return null;
        }
        return new s6((String) null, (byte[]) null, j2Var.d(), BarcodeFormat.HARMONY_CODE);
    }

    private s6 a(int i, int i2, g3[] g3VarArr, e2 e2Var, Map<l1, ?> map) throws a {
        char c;
        int i3 = i;
        e2 e2Var2 = e2Var;
        char c2 = 0;
        int i4 = 0;
        while (i4 <= i3 - 2) {
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 <= i3 - 1) {
                int i7 = i6 + 1;
                for (int i8 = i7; i8 <= i3; i8++) {
                    int i9 = i2;
                    int i10 = i3;
                    while (i10 < i9) {
                        g3[] g3VarArr2 = new g3[3];
                        g3VarArr2[c2] = g3VarArr[i4];
                        g3VarArr2[1] = g3VarArr[i6];
                        g3VarArr2[2] = g3VarArr[i8];
                        u6.a(g3VarArr2);
                        g3 g3Var = g3VarArr[i10];
                        try {
                            float b2 = (g3VarArr2[2].b() - g3VarArr2[1].b()) + g3VarArr2[c2].b();
                            float c3 = (g3VarArr2[2].c() - g3VarArr2[1].c()) + g3VarArr2[c2].c();
                            try {
                                float max = Math.max(Math.abs(g3VarArr2[1].b() - g3VarArr2[c2].b()), Math.abs(g3VarArr2[1].b() - g3VarArr2[2].b()));
                                c = 0;
                                try {
                                    float max2 = Math.max(Math.abs(g3VarArr2[1].c() - g3VarArr2[0].c()), Math.abs(g3VarArr2[1].c() - g3VarArr2[2].c()));
                                    if (Math.abs(b2 - g3Var.b()) < max / 2.0f) {
                                        if (Math.abs(c3 - g3Var.c()) < max2 / 2.0f) {
                                            try {
                                                s6 a2 = a(e2Var2.a(g3VarArr2, g3Var), e2Var2, map);
                                                if (a2 != null) {
                                                    return a2;
                                                }
                                                i10++;
                                                c2 = c;
                                            } catch (a unused) {
                                                continue;
                                            }
                                        }
                                    }
                                } catch (a unused2) {
                                }
                            } catch (a unused3) {
                                c = 0;
                            }
                            Map<l1, ?> map2 = map;
                        } catch (a unused4) {
                            Map<l1, ?> map3 = map;
                            c = c2;
                        }
                        i10++;
                        c2 = c;
                    }
                    Map<l1, ?> map4 = map;
                    char c4 = c2;
                }
                int i11 = i2;
                Map<l1, ?> map5 = map;
                i6 = i7;
            }
            int i12 = i2;
            Map<l1, ?> map6 = map;
            i4 = i5;
        }
        throw a.a();
    }

    public s6 a(p pVar, Map<l1, ?> map) throws a {
        e2 e2Var = new e2(pVar.b());
        g3[] a2 = e2Var.a(map);
        int length = a2.length;
        if (length == 3) {
            u6.a(a2);
            s6 a3 = a(e2Var.a(a2, (g3) null), e2Var, map);
            if (a3 != null) {
                return a3;
            }
        } else {
            if (length == 4) {
                g3[] g3VarArr = new g3[3];
                for (int i = 0; i < 3; i++) {
                    g3VarArr[i] = a2[i];
                }
                u6.a(g3VarArr);
                s6 a4 = a(e2Var.a(g3VarArr, a2[3]), e2Var, map);
                if (a4 != null) {
                    return a4;
                }
            } else {
                float e = ((a2[0].e() + a2[1].e()) + a2[2].e()) / 3.0f;
                float e2 = a2[length - 1].e();
                int i2 = length - 2;
                while (i2 > 2 && Math.abs(a2[i2].e() - e) >= Math.abs(a2[i2].e() - e2)) {
                    int i3 = length - i2;
                    e2 = ((((float) (i3 - 1)) * e2) + a2[i2].e()) / ((float) i3);
                    i2--;
                }
                return a(i2, length, a2, e2Var, map);
            }
        }
        throw a.a();
    }
}

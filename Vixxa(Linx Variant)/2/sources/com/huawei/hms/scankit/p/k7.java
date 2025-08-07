package com.huawei.hms.scankit.p;

import com.github.mikephil.charting.utils.Utils;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

/* compiled from: TwoDimDecoder */
public class k7 {
    public static byte[] a(p pVar, Map<l1, Object> map, s6 s6Var, int[] iArr, double[] dArr) throws a {
        Collection collection = null;
        if (pVar == null) {
            return null;
        }
        if (map != null) {
            collection = (Collection) map.get(l1.POSSIBLE_FORMATS);
        }
        if ((collection == null || collection.contains(BarcodeFormat.QR_CODE) || collection.contains(BarcodeFormat.PDF_417)) && s6Var != null && s6Var.k() == null) {
            if (collection != null) {
                collection.clear();
                l1 l1Var = l1.POSSIBLE_FORMATS;
                map.remove(l1Var);
                collection.add(s6Var.c());
                map.put(l1Var, collection);
            } else if (map != null) {
                l1 l1Var2 = l1.POSSIBLE_FORMATS;
                map.remove(l1Var2);
                Vector vector = new Vector();
                vector.add(s6Var.c());
                map.put(l1Var2, vector);
            }
            float f = 3.0f / r3.i;
            if (f < 1.0f) {
                f = 1.0f;
            }
            dArr[5] = (double) f;
            return a(pVar, s6Var.j(), dArr, iArr);
        }
        iArr[0] = pVar.e();
        iArr[1] = pVar.c();
        return pVar.d();
    }

    private static byte[] a(p pVar, u6[] u6VarArr, double[] dArr, int[] iArr) throws a {
        if (u6VarArr == null) {
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            return pVar.d();
        }
        int e = pVar.e();
        int c = pVar.c();
        int i = e;
        int i2 = c;
        int i3 = 0;
        int i4 = 0;
        for (u6 u6Var : u6VarArr) {
            if (u6Var != null) {
                if (((int) u6Var.b()) < i) {
                    i = (int) u6Var.b();
                }
                if (((int) u6Var.c()) < i2) {
                    i2 = (int) u6Var.c();
                }
                if (((int) u6Var.b()) > i3) {
                    i3 = (int) u6Var.b();
                }
                if (((int) u6Var.c()) > i4) {
                    i4 = (int) u6Var.c();
                }
            }
        }
        return a(u6VarArr, pVar, iArr, (float) Math.max(i3 - i, i4 - i2), dArr);
    }

    private static byte[] a(u6[] u6VarArr, p pVar, int[] iArr, float f, double[] dArr) throws a {
        float f2 = f;
        float b = u6VarArr[0].b();
        float b2 = u6VarArr[1].b();
        float b3 = u6VarArr[2].b();
        float c = u6VarArr[0].c();
        float c2 = u6VarArr[1].c();
        float c3 = u6VarArr[2].c();
        if (b < 0.0f || b2 < 0.0f || b3 < 0.0f || c < 0.0f || c2 < 0.0f || c3 < 0.0f || b > ((float) pVar.e()) || b2 > ((float) pVar.e()) || b3 > ((float) pVar.e()) || c > ((float) pVar.c()) || c2 > ((float) pVar.c()) || c3 > ((float) pVar.c())) {
            p pVar2 = pVar;
            iArr[0] = pVar.e();
            iArr[1] = pVar.c();
            throw a.a();
        }
        int i = ((int) (c + c3)) / 2;
        int i2 = (int) (((float) (((int) (b + b3)) / 2)) - f2);
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = (int) (((float) i) - f2);
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = ((int) f2) * 2;
        int e = i2 + i4 <= pVar.e() ? i4 : pVar.e() - i2;
        if (i3 + i4 > pVar.c()) {
            i4 = pVar.c() - i3;
        }
        p a = pVar.a(i2, i3, e, i4);
        double degrees = dArr[0] + Math.toDegrees(a(u6VarArr[0], u6VarArr[1])) + 90.0d;
        dArr[0] = degrees;
        dArr[1] = (double) i2;
        dArr[2] = (double) i3;
        double d = (double) e;
        dArr[3] = d;
        double d2 = (double) i4;
        dArr[4] = d2;
        double radians = Math.toRadians(degrees);
        int abs = (int) (((Math.abs(Math.sin(radians)) * d) + (Math.abs(Math.cos(radians)) * d2)) * dArr[5]);
        int abs2 = (int) (((d2 * Math.abs(Math.sin(radians))) + (d * Math.abs(Math.cos(radians)))) * dArr[5]);
        iArr[0] = abs2;
        iArr[1] = abs;
        byte[] imageRotate = LoadOpencvJNIUtil.imageRotate(a.d(), a.c(), a.e(), abs, abs2, (float) dArr[0], dArr[5]);
        if (imageRotate != null) {
            return imageRotate;
        }
        iArr[0] = pVar.e();
        iArr[1] = pVar.c();
        return pVar.d();
    }

    public static double a(u6 u6Var, u6 u6Var2) {
        return Math.atan2((double) (u6Var2.c() - u6Var.c()), (double) (u6Var2.b() - u6Var.b()));
    }

    public static u6[] a(u6[] u6VarArr, int i, int i2, double[] dArr) {
        double d;
        int i3;
        u6[] u6VarArr2;
        u6[] u6VarArr3 = u6VarArr;
        u6 u6Var = null;
        if (u6VarArr3 == null) {
            return null;
        }
        double d2 = dArr[3];
        int i4 = d2 != Utils.DOUBLE_EPSILON ? (int) d2 : i;
        double d3 = dArr[4];
        int i5 = d3 != Utils.DOUBLE_EPSILON ? (int) d3 : i2;
        double d4 = dArr[5];
        u6[] u6VarArr4 = new u6[u6VarArr3.length];
        int i6 = 0;
        double radians = Math.toRadians(dArr[0]);
        double cos = Math.cos(radians) * d4;
        double sin = Math.sin(radians) * d4;
        double d5 = (double) i5;
        double d6 = (double) i4;
        double abs = (((Math.abs(sin) - sin) * d5) + ((Math.abs(cos) - cos) * d6)) / 2.0d;
        double d7 = -sin;
        double abs2 = ((d5 * (Math.abs(cos) - cos)) + (d6 * (Math.abs(sin) + sin))) / 2.0d;
        while (i6 < u6VarArr3.length) {
            u6 u6Var2 = u6VarArr3[i6];
            if (u6Var2 != null) {
                u6 u6Var3 = u6Var2;
                u6VarArr2 = u6VarArr4;
                i3 = i6;
                double b = (((((double) u6Var2.b()) - abs) * cos) + ((abs2 - ((double) u6Var3.c())) * sin)) / ((cos * cos) - (sin * d7));
                double c = sin == Utils.DOUBLE_EPSILON ? (((double) u6Var3.c()) - abs2) / cos : ((((double) u6Var3.b()) - abs) - (cos * b)) / sin;
                d = d7;
                u6VarArr2[i3] = new u6((float) (Math.round(b) + ((long) ((int) dArr[1]))), (float) (Math.round(c) + ((long) ((int) dArr[2]))));
                u6Var = null;
            } else {
                d = d7;
                u6VarArr2 = u6VarArr4;
                i3 = i6;
                u6VarArr2[i3] = u6Var;
            }
            i6 = i3 + 1;
            d7 = d;
            u6VarArr4 = u6VarArr2;
        }
        return u6VarArr4;
    }
}

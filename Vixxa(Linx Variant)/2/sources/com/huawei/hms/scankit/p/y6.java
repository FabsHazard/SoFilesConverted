package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;

/* compiled from: ScanParser */
public class y6 {
    public static HmsScan a(s6 s6Var) {
        HmsScan a;
        if (s6Var == null) {
            return null;
        }
        if (!r3.f || (a = v5.a(s6Var)) == null) {
            return new HmsScan(s6Var.k(), t6.a(s6Var.c()), s6Var.k(), HmsScan.PURE_TEXT_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, (z6) null).setZoomValue((double) s6Var.l());
        }
        return a;
    }

    public static HmsScan[] a(s6[] s6VarArr) {
        if (s6VarArr == null || s6VarArr.length <= 0) {
            return new HmsScan[0];
        }
        HmsScan[] hmsScanArr = new HmsScan[s6VarArr.length];
        for (int i = 0; i < s6VarArr.length; i++) {
            hmsScanArr[i] = a(s6VarArr[i]);
        }
        return hmsScanArr;
    }
}

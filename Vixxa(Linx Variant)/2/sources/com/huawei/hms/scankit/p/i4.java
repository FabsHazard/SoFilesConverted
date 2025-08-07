package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: ISBNResultParser */
public final class i4 extends t6 {
    public HmsScan b(s6 s6Var) {
        if (t6.a(s6Var.c()) != HmsScanBase.EAN13_SCAN_TYPE) {
            return null;
        }
        String a = t6.a(s6Var);
        if (a.length() != 13) {
            return null;
        }
        if (a.startsWith("978") || a.startsWith("979")) {
            return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a, HmsScan.ISBN_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, (z6) null);
        }
        return null;
    }
}

package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.util.regex.Pattern;

/* compiled from: ProductResultParser */
public final class g6 extends t6 {
    private static final Pattern b = Pattern.compile("\\d+");

    protected static boolean a(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && b.matcher(charSequence).matches();
    }

    public HmsScan b(s6 s6Var) {
        int a = t6.a(s6Var.c());
        if (a != HmsScanBase.EAN13_SCAN_TYPE && a != HmsScanBase.EAN8_SCAN_TYPE && a != HmsScanBase.UPCCODE_A_SCAN_TYPE && a != HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return null;
        }
        String a2 = t6.a(s6Var);
        if (!a(a2, a2.length())) {
            return null;
        }
        return new HmsScan(a2, t6.a(s6Var.c()), a2, HmsScan.ARTICLE_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, (z6) null);
    }
}

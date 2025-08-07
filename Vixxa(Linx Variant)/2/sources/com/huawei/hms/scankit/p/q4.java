package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Pattern;

/* compiled from: MarketResultParser */
public final class q4 extends t6 {
    private static final Pattern b = Pattern.compile("market://[\\s\\S]*", 2);

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a) || !b.matcher(a).matches()) {
            return null;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.LinkUrl("", "")));
    }
}

package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HTTPResultParser */
public final class t3 extends t6 {
    private static final Pattern b = Pattern.compile("(?:http:|http//|https://)([\\s\\S]+)", 2);
    private static final Pattern c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (!b.matcher(a).matches()) {
            return null;
        }
        Matcher matcher = c.matcher(a);
        if (matcher.matches()) {
            a = a.substring(0, 4) + "://" + matcher.group(1);
        }
        String a2 = t6.a(a);
        if (a2.length() == 7) {
            return null;
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a2, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.LinkUrl("", a2)));
    }
}

package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: URIResultParser */
public final class u7 extends t6 {
    private static final Pattern b = Pattern.compile("(?:uri|url):([\\s\\S]*)", 2);
    private static final Pattern c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a) || !b.matcher(a).matches()) {
            return null;
        }
        String substring = a.substring(4);
        Matcher matcher = c.matcher(substring);
        if (matcher.matches()) {
            substring = substring.substring(0, 4) + "://" + matcher.group(1);
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), t6.a(substring), HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.LinkUrl("", "")));
    }
}

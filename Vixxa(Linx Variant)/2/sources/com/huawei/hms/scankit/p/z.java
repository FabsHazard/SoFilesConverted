package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BookmarkDoCoMoResultParser */
public final class z extends t6 {
    private static final Pattern b = Pattern.compile("(?:MEBKM:)([\\s\\S]+)", 2);
    private static final Pattern c = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        Matcher matcher = b.matcher(a);
        if (!matcher.matches()) {
            return null;
        }
        String[] split = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String a2 = a(split, "TITLE:");
        String a3 = t6.a(a(split, "URL:"));
        if (a3.length() == 0) {
            return null;
        }
        Matcher matcher2 = c.matcher(a3);
        if (matcher2.matches()) {
            a3 = a3.substring(0, 4) + "://" + matcher2.group(1);
        }
        String str = a3;
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.URL_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.LinkUrl(a2, str)));
    }
}

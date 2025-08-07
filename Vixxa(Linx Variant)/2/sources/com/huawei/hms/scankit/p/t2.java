package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: EmailContentAddressResultParser */
public final class t2 extends t6 {
    private static final Pattern b = Pattern.compile("(?:MATMSG:TO:|mailto:|SMTP:)([\\s\\S]+)", 2);
    private static final Pattern c = Pattern.compile("mailto:([\\s\\S]+)\\?subject=([\\s\\S]+)&body=([\\s\\S]+)", 2);
    private static final Pattern d = Pattern.compile("MATMSG:TO:([\\s\\S]+);SUB:([\\s\\S]+);BODY:([\\s\\S]+)", 2);
    private static final Pattern e = Pattern.compile("SMTP:([\\s\\S]+):([\\s\\S]+):([\\s\\S]+)", 2);

    static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public HmsScan b(s6 s6Var) {
        String str;
        String str2;
        String str3;
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a) || !b.matcher(a).matches()) {
            return null;
        }
        try {
            Matcher matcher = c.matcher(a);
            Matcher matcher2 = d.matcher(a);
            Matcher matcher3 = e.matcher(a);
            if (matcher.matches()) {
                String group = matcher.group(1);
                str2 = matcher.group(2);
                str3 = matcher.group(3);
                str = group;
            } else if (matcher2.matches()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(2);
                str = group2;
                String group4 = matcher2.group(3);
                str2 = group3;
                str3 = group4;
            } else {
                if (matcher3.matches()) {
                    String group5 = matcher3.group(1);
                    str2 = matcher3.group(2);
                    str = group5;
                    str3 = matcher3.group(3);
                }
                return null;
            }
            return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str, HmsScan.EMAIL_CONTENT_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.EmailContent(str, c(str2), c(str3), HmsScan.EmailContent.OTHER_USE_TYPE)));
        } catch (Exception | RuntimeException unused) {
        }
    }
}

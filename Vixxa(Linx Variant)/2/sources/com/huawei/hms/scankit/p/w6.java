package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Pattern;

/* compiled from: SMSTOMMSTOResultParser */
public final class w6 extends t6 {
    private static final Pattern b = Pattern.compile("(?:mmsto|smsto):([\\s\\S]+)", 2);

    public HmsScan b(s6 s6Var) {
        String str;
        String str2;
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a) || !b.matcher(a).matches()) {
            return null;
        }
        String substring = a.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(0, indexOf);
            str2 = substring.substring(indexOf + 1);
        } else {
            str = substring;
            str2 = "";
        }
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str2.isEmpty() ? str : str + "\n" + str2, HmsScan.SMS_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.SmsContent(str2, str)));
    }
}

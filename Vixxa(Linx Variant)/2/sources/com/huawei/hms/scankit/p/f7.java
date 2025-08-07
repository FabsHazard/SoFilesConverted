package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: TelPhoneNumberResultParser */
public final class f7 extends t6 {
    private static final Pattern b = Pattern.compile("tel:([\\s\\S]+)", 2);

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        Matcher matcher = b.matcher(a);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), group, HmsScan.TEL_PHONE_NUMBER_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, group)));
    }
}

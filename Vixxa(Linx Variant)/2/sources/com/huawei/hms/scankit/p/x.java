package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BizcardResultParser */
public final class x extends t6 {
    private static final Pattern b = Pattern.compile("(?:BIZCARD:)([\\s\\S]+)", 2);

    private static HmsScan.PeopleName a(String str, String str2, String str3) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.givenName = str;
        peopleName.familyName = str2;
        peopleName.fullName = str3;
        return peopleName;
    }

    private static HmsScan.AddressInfo[] c(String str) {
        if (str == null || str.isEmpty()) {
            return new HmsScan.AddressInfo[0];
        }
        return new HmsScan.AddressInfo[]{new HmsScan.AddressInfo(new String[]{str}, HmsScan.AddressInfo.OTHER_USE_TYPE)};
    }

    private static HmsScan.EmailContent[] d(String str) {
        if (str == null || str.isEmpty()) {
            return new HmsScan.EmailContent[0];
        }
        return new HmsScan.EmailContent[]{new HmsScan.EmailContent(str, "", "", HmsScan.EmailContent.OTHER_USE_TYPE)};
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
        String a2 = a(split, "N:");
        String a3 = a(split, "X:");
        String trim = (a2 + " " + a3).trim();
        String a4 = a(split, "T:");
        String a5 = a(split, "C:");
        String a6 = a(split, "A:");
        String a7 = a(split, "B:");
        String a8 = a(split, "M:");
        HmsScan.ContactDetail contactDetail = r8;
        HmsScan.ContactDetail contactDetail2 = new HmsScan.ContactDetail(a(a2, a3, trim), a4, a5, b(a7, a(split, "F:"), a8), d(a(split, "E:")), c(a6), new String[0], (String) null);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), trim, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(contactDetail));
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return t6.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.TelPhoneNumber[] b(String str, String str2, String str3) {
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[0];
        ArrayList arrayList = new ArrayList(3);
        if (str != null && !str.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OFFICE_USE_TYPE, str));
        }
        if (str2 != null && !str2.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.FAX_USE_TYPE, str2));
        }
        if (str3 != null && !str3.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE, str3));
        }
        return (HmsScan.TelPhoneNumber[]) arrayList.toArray(telPhoneNumberArr);
    }
}

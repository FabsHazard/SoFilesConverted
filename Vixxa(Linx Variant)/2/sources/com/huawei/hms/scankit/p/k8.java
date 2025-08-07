package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WifiResultParser */
public final class k8 extends t6 {
    private static final Pattern b = Pattern.compile("WIFI:[^:]", 2);
    static final String[] c = new String[0];

    static String[] a(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i = 0;
        while (i < length) {
            int indexOf = str2.indexOf(str, i);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = true;
            ArrayList arrayList2 = arrayList;
            int i2 = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i2);
                if (indexOf2 < 0) {
                    i2 = str2.length();
                } else if (a(str2, indexOf2) % 2 != 0) {
                    i2 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String b2 = t6.b(str2.substring(length2, indexOf2));
                    if (z) {
                        b2 = b2.trim();
                    }
                    arrayList2.add(b2);
                    i2 = indexOf2 + 1;
                }
                z2 = false;
            }
            i = i2;
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(c);
    }

    private static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("WEP")) {
            return 2;
        }
        if ((str.equalsIgnoreCase("WPA") | str.equalsIgnoreCase("WPA2") | str.equalsIgnoreCase("WPA/WPA2")) || str.equalsIgnoreCase("WPA2/WPA")) {
            return 1;
        }
        if (str.equalsIgnoreCase("SAE")) {
            return 3;
        }
        return 0;
    }

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        Matcher matcher = b.matcher(a);
        if (matcher.find() && matcher.start() == 0) {
            String substring = a.substring(5);
            if (!substring.endsWith(";")) {
                substring = substring + ";";
            }
            String b2 = b("S:", substring, ';', false);
            if (b2 != null && !b2.isEmpty()) {
                String b3 = b("P:", substring, ';', false);
                return new HmsScan(s6Var.k(), t6.a(s6Var.c()), b2 + ((b3 == null || b3.isEmpty()) ? "" : " " + b3), HmsScan.WIFI_CONNECT_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.WiFiConnectionInfo(b2, b3, c(b("T:", substring, ';', false)))));
            }
        }
        return null;
    }

    private String b(String str, String str2, char c2, boolean z) {
        String str3;
        String[] a = a(str, str2, c2, z);
        if (a == null || a.length == 0 || (str3 = a[0]) == null) {
            return "";
        }
        return str3;
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = i - 1;
        int i3 = 0;
        while (i2 >= 0 && charSequence.charAt(i2) == '\\') {
            i3++;
            i2--;
        }
        return i3;
    }
}

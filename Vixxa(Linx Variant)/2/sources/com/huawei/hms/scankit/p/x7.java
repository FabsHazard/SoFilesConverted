package com.huawei.hms.scankit.p;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: VCardResultParser */
public final class x7 extends t6 {
    private static final Pattern b = Pattern.compile("\r?\n[ \t]");
    private static final Pattern c = Pattern.compile(ContainerUtils.KEY_VALUE_DELIMITER);
    private static final Pattern d = Pattern.compile(";");
    private static final Pattern e = Pattern.compile("(?<!\\\\);+");
    static final String[] f = new String[0];

    protected static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return c2 - '7';
    }

    static int a(int i, String str, boolean z) {
        int indexOf;
        while (true) {
            indexOf = str.indexOf(10, i);
            if (indexOf >= 0) {
                if (indexOf < str.length() - 1) {
                    int i2 = indexOf + 1;
                    if (str.charAt(i2) == ' ' || str.charAt(i2) == 9) {
                        i = indexOf + 2;
                    }
                }
                if (!z || (!a(indexOf, 1, str) && !a(indexOf, 2, str))) {
                    break;
                }
                i = indexOf + 1;
            } else {
                break;
            }
        }
        return indexOf;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            int i2 = HmsScan.TelPhoneNumber.OTHER_USE_TYPE;
            HmsScan.TelPhoneNumber telPhoneNumber = new HmsScan.TelPhoneNumber(i2, strArr2[i]);
            String str = strArr[i];
            if (str != null) {
                if (str.equals("WORK")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.OFFICE_USE_TYPE;
                } else if (strArr[i].equals("HOME")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                } else if (strArr[i].equals("CELL")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE;
                } else if (strArr[i].equals("FAX")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.FAX_USE_TYPE;
                } else {
                    telPhoneNumber.useType = i2;
                }
            }
            telPhoneNumberArr[i] = telPhoneNumber;
        }
        return telPhoneNumberArr;
    }

    public HmsScan b(s6 s6Var) {
        String str;
        String a;
        String a2 = t6.a(s6Var);
        if (!a2.startsWith("BEGIN:VCARD") || (a = a("N", str, true, false)) == null || a.isEmpty() || a.split(";").length == 0) {
            return null;
        }
        String a3 = a("FN", (str = a2 + "\n"), true, false);
        if (a3 == null || a3.isEmpty()) {
            a3 = c(a);
        }
        String str2 = a3;
        List<List<String>> b2 = b("TEL", str, true, false);
        List<List<String>> b3 = b("EMAIL", str, true, false);
        List<List<String>> b4 = b("ADR", str, true, true);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), str2, HmsScan.CONTACT_DETAIL_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.ContactDetail(a(a, str2), a("TITLE", str, true, false), a("ORG", str, true, true), c(b((Collection<List<String>>) b2), a((Collection<List<String>>) b2)), b(b((Collection<List<String>>) b3), a((Collection<List<String>>) b3)), a(b((Collection<List<String>>) b4), a((Collection<List<String>>) b4)), a((Collection<List<String>>) b("URL", str, true, false)), (String) null)));
    }

    static void a(String str, boolean z, boolean z2, String str2, boolean z3, List<String> list, List<List<String>> list2) {
        String str3;
        if (z) {
            str = str.trim();
        }
        if (z2) {
            str3 = a((CharSequence) str, str2);
            if (z3) {
                str3 = e.matcher(str3).replaceAll(" ").trim();
            }
        } else {
            if (z3) {
                str = e.matcher(str).replaceAll(" ").trim();
            }
            str3 = b.matcher(str).replaceAll("");
        }
        if (list == null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str3);
            list2.add(arrayList);
            return;
        }
        list.add(0, str3);
        list2.add(list);
    }

    private static String c(String str) {
        int indexOf;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArr = new String[5];
        int i = 0;
        int i2 = 0;
        while (i < 4 && (indexOf = str.indexOf(59, i2)) >= 0) {
            strArr[i] = str.substring(i2, indexOf);
            i++;
            i2 = indexOf + 1;
        }
        strArr[i] = str.substring(i2);
        StringBuilder sb = new StringBuilder(100);
        a(strArr, 3, sb);
        a(strArr, 1, sb);
        a(strArr, 2, sb);
        a(strArr, 0, sb);
        a(strArr, 4, sb);
        return sb.toString().trim();
    }

    private static String a(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt2 = charSequence.charAt(i);
            if (!(charAt2 == 10 || charAt2 == 13)) {
                if (charAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (!(i >= length - 2 || (charAt = charSequence.charAt(i + 1)) == 13 || charAt == 10)) {
                    i += 2;
                    char charAt3 = charSequence.charAt(i);
                    int a = a(charAt);
                    int a2 = a(charAt3);
                    if (a >= 0 && a2 >= 0) {
                        byteArrayOutputStream.write((a << 4) + a2);
                    }
                }
            }
            i++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    static List<List<String>> b(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        String str2;
        boolean z3;
        String str3 = str;
        int length = str.length();
        Pattern compile = Pattern.compile("(?:^|\n)" + charSequence + "(?:;([^:\n(?![ |\t])]*))?:");
        int i = 0;
        ArrayList arrayList2 = null;
        while (i < length) {
            Matcher matcher = compile.matcher(str3);
            if (i > 0) {
                i--;
            }
            if (!matcher.find(i)) {
                break;
            }
            int end = matcher.end(0);
            String group = matcher.group(1);
            if (group != null) {
                z3 = false;
                ArrayList arrayList3 = null;
                String str4 = null;
                for (String str5 : d.split(group)) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList(1);
                    }
                    arrayList3.add(str5);
                    String[] split = c.split(str5, 2);
                    if (split.length > 1) {
                        if ("ENCODING".equalsIgnoreCase(split[0]) && "QUOTED-PRINTABLE".equalsIgnoreCase(split[1])) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(split[0])) {
                            str4 = split[1];
                        }
                    }
                }
                arrayList = arrayList3;
                str2 = str4;
            } else {
                z3 = false;
                str2 = null;
                arrayList = null;
            }
            int a = a(end, str3, z3);
            if (a < 0) {
                a = length;
            } else if (a > end) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (a >= 1 && str3.charAt(a - 1) == 13) {
                    a--;
                }
                a(str3.substring(end, a), z, z3, str2, z2, arrayList, arrayList2);
            }
            i = a + 1;
        }
        return arrayList2;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String a(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> b2 = b(charSequence, str, z, z2);
        String str2 = "";
        if (b2 != null && !b2.isEmpty()) {
            for (List next : b2) {
                if (next.get(0) != null && !((String) next.get(0)).isEmpty()) {
                    str2 = (String) next.get(0);
                }
            }
        }
        return str2;
    }

    private static String[] b(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List next : collection) {
            String str2 = (String) next.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i = 1;
                while (true) {
                    if (i >= next.size()) {
                        str = null;
                        break;
                    }
                    str = (String) next.get(i);
                    int indexOf = str.indexOf(61);
                    if (indexOf < 0) {
                        break;
                    } else if ("TYPE".equals(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    } else {
                        i++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(f);
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = (String) list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(f);
    }

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        if (str != null) {
            String[] split = str.split(";");
            if (split.length > 0) {
                peopleName.familyName = split[0];
            }
            if (split.length > 1) {
                peopleName.givenName = split[1];
            }
            if (split.length > 2) {
                peopleName.middleName = split[2];
            }
            if (split.length > 3) {
                peopleName.namePrefix = split[3];
            }
            if (split.length > 4) {
                peopleName.nameSuffix = split[4];
            }
        }
        if (str2 != null) {
            peopleName.fullName = str2;
        }
        return peopleName;
    }

    private static HmsScan.EmailContent[] b(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            HmsScan.EmailContent emailContent = new HmsScan.EmailContent(strArr2[i], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            String str = strArr[i];
            if (str != null) {
                if (str.equals("WORK")) {
                    emailContent.addressType = HmsScan.EmailContent.OFFICE_USE_TYPE;
                } else if (strArr[i].equals("HOME")) {
                    emailContent.addressType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                }
            }
            emailContentArr[i] = emailContent;
        }
        return emailContentArr;
    }

    private static HmsScan.AddressInfo[] a(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            HmsScan.AddressInfo addressInfo = new HmsScan.AddressInfo(new String[]{strArr2[i]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            String str = strArr[i];
            if (str != null) {
                if (str.equals("WORK")) {
                    addressInfo.addressType = HmsScan.AddressInfo.OFFICE_TYPE;
                } else if (strArr[i].equals("HOME")) {
                    addressInfo.addressType = HmsScan.AddressInfo.RESIDENTIAL_USE_TYPE;
                }
            }
            addressInfoArr[i] = addressInfo;
        }
        return addressInfoArr;
    }

    private static void a(String[] strArr, int i, StringBuilder sb) {
        String str = strArr[i];
        if (str != null && !str.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(strArr[i]);
        }
    }

    private static boolean a(int i, int i2, String str) {
        return i >= i2 && str.charAt(i - i2) == '=';
    }
}

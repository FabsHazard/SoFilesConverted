package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import java.util.List;

/* compiled from: VEventResultParser */
public final class y7 extends t6 {
    private static void a(String[] strArr, HmsScan.EventTime eventTime) {
        if (strArr != null && strArr.length != 0) {
            for (String a : strArr) {
                d3.a(a, eventTime);
            }
        }
    }

    public HmsScan b(s6 s6Var) {
        String a = t6.a(s6Var);
        if (!a.startsWith("BEGIN:VEVENT")) {
            return null;
        }
        String str = a + "\n";
        String a2 = a("SUMMARY", str, true);
        String a3 = a("LOCATION", str, true);
        String a4 = a("ORGANIZER", str, true);
        String a5 = a("DESCRIPTION", str, true);
        String a6 = a("STATUS", str, true);
        String[] b = b("DTSTART", str, true);
        String[] b2 = b("DTEND", str, true);
        HmsScan.EventTime eventTime = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        HmsScan.EventTime eventTime2 = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        a(b, eventTime);
        a(b2, eventTime2);
        return new HmsScan(s6Var.k(), t6.a(s6Var.c()), a2, HmsScan.EVENT_INFO_FORM, s6Var.i(), t6.a(s6Var.j()), (HmsScanAnalyzerOptions) null, new z6(new HmsScan.EventInfo(a2, eventTime, eventTime2, a3, a5, a4, a6)));
    }

    private static String a(CharSequence charSequence, String str, boolean z) {
        List<List<String>> b = x7.b(charSequence, str, z, false);
        return (b == null || b.isEmpty()) ? "" : (String) b.get(b.size() - 1).get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> b = x7.b(charSequence, str, z, false);
        if (b == null || b.isEmpty()) {
            return new String[0];
        }
        int size = b.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) b.get(i).get(0);
        }
        return strArr;
    }
}

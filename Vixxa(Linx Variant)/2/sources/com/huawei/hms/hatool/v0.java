package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

public class v0 implements g {
    private Context a = q0.i();
    private String b;
    private String c;
    private String d;

    public v0(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    private void a(String str, List<b1> list) {
        Pair<String, String> a2 = n1.a(str);
        new u(list, (String) a2.first, (String) a2.second, this.d).a();
    }

    public void run() {
        v.c("hmsSdk", "eventReportTask is running");
        boolean a2 = c0.a(this.a);
        if (a2) {
            v.c("hmsSdk", "workKey is refresh,begin report all data");
            this.c = "alltype";
        }
        try {
            Map<String, List<b1>> a3 = c1.a(this.a, this.b, this.c);
            if (a3.size() == 0) {
                v.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.b, this.c);
                if ("alltype".equals(this.c)) {
                    d.a(this.a, "stat_v2_1", new String[0]);
                    d.a(this.a, "cached_v2_1", new String[0]);
                    return;
                }
                String a4 = n1.a(this.b, this.c);
                d.a(this.a, "stat_v2_1", a4);
                d.a(this.a, "cached_v2_1", a4);
                return;
            }
            for (Map.Entry next : a3.entrySet()) {
                a((String) next.getKey(), (List) next.getValue());
            }
            if ("alltype".equals(this.c)) {
                d.a(this.a, "stat_v2_1", new String[0]);
                d.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a5 = n1.a(this.b, this.c);
                d.a(this.a, "stat_v2_1", a5);
                d.a(this.a, "cached_v2_1", a5);
            }
            if (a2) {
                v.c("hmsSdk", "refresh local key");
                o0.d().b();
            }
        } catch (IllegalArgumentException e) {
            v.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());
            if ("alltype".equals(this.c)) {
                d.a(this.a, "stat_v2_1", new String[0]);
                d.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a6 = n1.a(this.b, this.c);
                d.a(this.a, "stat_v2_1", a6);
                d.a(this.a, "cached_v2_1", a6);
            }
        } catch (Exception e2) {
            v.e("hmsSdk", "readEventRecords handData Exception:" + e2.getMessage());
            if ("alltype".equals(this.c)) {
                d.a(this.a, "stat_v2_1", new String[0]);
                d.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a7 = n1.a(this.b, this.c);
                d.a(this.a, "stat_v2_1", a7);
                d.a(this.a, "cached_v2_1", a7);
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.c)) {
                d.a(this.a, "stat_v2_1", new String[0]);
                d.a(this.a, "cached_v2_1", new String[0]);
            } else {
                String a8 = n1.a(this.b, this.c);
                d.a(this.a, "stat_v2_1", a8);
                d.a(this.a, "cached_v2_1", a8);
            }
            throw th;
        }
    }
}

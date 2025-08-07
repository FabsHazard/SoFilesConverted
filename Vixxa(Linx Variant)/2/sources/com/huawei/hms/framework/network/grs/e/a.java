package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.j.c;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static final String e = "a";
    private static final Map<String, Map<String, Map<String, String>>> f = new ConcurrentHashMap(16);
    private final Map<String, Long> a = new ConcurrentHashMap(16);
    private final c b;
    private final c c;
    private final g d;

    public a(c cVar, c cVar2, g gVar) {
        this.c = cVar2;
        this.b = cVar;
        this.d = gVar;
        gVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l = this.a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l)) {
            bVar.a(2);
            return;
        }
        if (e.a(l, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS)) {
            this.d.a(new c(grsBaseInfo, context), (b) null, str, this.c);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.a.get(str), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS)) {
            this.d.a(new c(grsBaseInfo, context), (b) null, (String) null, this.c);
        }
    }

    public c a() {
        return this.b;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f;
        Map map2 = map.get(grsParasKey);
        if (map2 == null || map2.isEmpty()) {
            Logger.i(e, "Cache size is: " + map.size());
            return new HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return (Map) map2.get(str);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.b.b(grsParasKey + CrashHianalyticsData.TIME, "0");
        this.a.remove(grsParasKey + CrashHianalyticsData.TIME);
        Map<String, Map<String, Map<String, String>>> map = f;
        map.remove(grsParasKey);
        Logger.i(e, "Cache size is: " + map.size());
        this.d.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, c cVar) {
        if (dVar.f() == 2) {
            Logger.w(e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.b.a(grsParasKey, "")));
            } else {
                this.b.b(grsParasKey, dVar.j());
                f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                this.b.b(grsParasKey + "ETag", dVar.e());
            }
            this.b.b(grsParasKey + CrashHianalyticsData.TIME, dVar.a());
            this.a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.b.b("geoipCountryCode", dVar.j());
            this.b.b("geoipCountryCodetime", dVar.a());
        }
        Logger.i(e, "Cache size is: " + f.size());
    }

    public g b() {
        return this.d;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a2 = this.b.a(grsParasKey, "");
        String a3 = this.b.a(grsParasKey + CrashHianalyticsData.TIME, "0");
        long j = 0;
        if (!TextUtils.isEmpty(a3) && a3.matches("\\d+")) {
            try {
                j = Long.parseLong(a3);
            } catch (NumberFormatException e2) {
                Logger.w(e, "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e2);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f;
        map.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a2));
        Logger.i(e, "Cache size is: " + map.size());
        this.a.put(grsParasKey, Long.valueOf(j));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.c;
    }
}

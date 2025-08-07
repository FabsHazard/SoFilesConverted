package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

public class e {

    class a implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ JSONArray c;

        a(long j, ArrayList arrayList, JSONArray jSONArray) {
            this.a = j;
            this.b = arrayList;
            this.c = jSONArray;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0035 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x0018  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                com.huawei.hms.framework.network.grs.g.j.a r0 = new com.huawei.hms.framework.network.grs.g.j.a
                r0.<init>()
                long r1 = r4.a
                java.lang.String r3 = "total_time"
                r0.put((java.lang.String) r3, (long) r1)
                java.util.ArrayList r1 = r4.b
                java.util.Iterator r1 = r1.iterator()
            L_0x0012:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0035
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                boolean r3 = r2.o()
                if (r3 != 0) goto L_0x002a
                boolean r3 = r2.m()
                if (r3 == 0) goto L_0x0012
            L_0x002a:
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r2)
                r0.put(r2)
                r1.remove()
                goto L_0x0057
            L_0x0035:
                java.util.ArrayList r1 = r4.b
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0057
                java.util.ArrayList r1 = r4.b
                int r2 = r1.size()
                int r2 = r2 + -1
                java.lang.Object r1 = r1.get(r2)
                com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.g.d) r1
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r1)
                r0.put(r2)
                java.util.ArrayList r2 = r4.b
                r2.remove(r1)
            L_0x0057:
                java.util.ArrayList r1 = r4.b
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0080
                java.util.ArrayList r1 = r4.b
                java.util.Iterator r1 = r1.iterator()
            L_0x0065:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0080
                java.lang.Object r2 = r1.next()
                com.huawei.hms.framework.network.grs.g.d r2 = (com.huawei.hms.framework.network.grs.g.d) r2
                org.json.JSONObject r3 = new org.json.JSONObject
                java.util.LinkedHashMap r2 = com.huawei.hms.framework.network.grs.g.e.b(r2)
                r3.<init>(r2)
                org.json.JSONArray r2 = r4.c
                r2.put(r3)
                goto L_0x0065
            L_0x0080:
                org.json.JSONArray r1 = r4.c
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0093
                org.json.JSONArray r1 = r4.c
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "failed_info"
                r0.put((java.lang.String) r2, (java.lang.String) r1)
            L_0x0093:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.util.LinkedHashMap r2 = r0.get()
                r1.<init>(r2)
                java.lang.Object[] r1 = new java.lang.Object[]{r1}
                java.lang.String r2 = "HaReportHelper"
                java.lang.String r3 = "grssdk report data to aiops is: %s"
                com.huawei.hms.framework.common.Logger.d(r2, r3, r1)
                com.huawei.hms.framework.common.hianalytics.HianalyticsHelper r1 = com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance()
                java.util.LinkedHashMap r0 = r0.get()
                java.lang.String r2 = "grs_request"
                r1.onEvent(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.e.a.run():void");
        }
    }

    public static void a(ArrayList<d> arrayList, long j, JSONArray jSONArray, Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j, arrayList, jSONArray));
        }
    }

    /* access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d = dVar.d();
        if (d != null) {
            linkedHashMapPack.put("error_code", (long) ExceptionCode.getErrorCodeFromException(d));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d.getClass().getSimpleName());
            linkedHashMapPack.put(CrashHianalyticsData.MESSAGE, StringUtils.anonymizeMessage(d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", (long) dVar.b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, (long) dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
        } catch (MalformedURLException e) {
            Logger.w("HaReportHelper", "report host MalformedURLException", (Throwable) e);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}

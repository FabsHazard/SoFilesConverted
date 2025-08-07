package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: BUGLY */
public final class ag {
    private final SimpleDateFormat a;
    private final ad b;

    /* compiled from: BUGLY */
    public static class a {
        /* access modifiers changed from: private */
        public static final ag a = new ag((byte) 0);
    }

    /* synthetic */ ag(byte b2) {
        this();
    }

    private ag() {
        this.a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.b = new ad();
    }

    public final void a(List<c> list) {
        if (list == null || list.isEmpty()) {
            al.d("sla batch report event is null", new Object[0]);
            return;
        }
        al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        for (c b2 : list) {
            b b3 = b(b2);
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        e(arrayList);
        b((List<b>) arrayList);
    }

    public final void b(final List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new Runnable() {
                public final void run() {
                    ag.c(list);
                }
            });
        } else {
            c(list);
        }
    }

    static void c(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch report data is empty", new Object[0]);
            return;
        }
        al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
        if (list.size() > 30) {
            list = list.subList(0, 29);
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            arrayList.add(bVar.c);
        }
        Pair<Integer, String> a2 = ad.a((List<String>) arrayList);
        al.c("sla batch report result, rspCode:%s rspMsg:%s", a2.first, a2.second);
        if (((Integer) a2.first).intValue() == 200) {
            d(list);
        }
    }

    private static void e(List<b> list) {
        for (b next : list) {
            al.c("sla save id:%s time:%s msg:%s", next.a, Long.valueOf(next.b), next.c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", next.a);
                contentValues.put("_tm", Long.valueOf(next.b));
                contentValues.put("_dt", next.c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    public static void d(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch delete list is null", new Object[0]);
            return;
        }
        al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
        try {
            String str = "_id in (" + a(",", list) + ")";
            al.c("sla batch delete where:%s", str);
            w.a().a("t_sla", str);
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("'");
        sb.append(it.next().a).append("'");
        while (it.hasNext()) {
            sb.append(str);
            sb.append("'").append(it.next().a).append("'");
        }
        return sb.toString();
    }

    public static List<b> a() {
        Cursor a2 = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (a2 == null) {
            return null;
        }
        if (a2.getCount() <= 0) {
            a2.close();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a2.moveToNext()) {
            try {
                b bVar = new b();
                bVar.a = a2.getString(a2.getColumnIndex("_id"));
                bVar.b = a2.getLong(a2.getColumnIndex("_tm"));
                bVar.c = a2.getString(a2.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
        }
        a2.close();
        return arrayList;
    }

    /* compiled from: BUGLY */
    public static class c {
        String a;
        String b;
        long c;
        boolean d;
        long e;
        String f;
        String g;

        public c(String str, String str2, long j, boolean z, long j2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = z;
            this.e = j2;
            this.f = str3;
            this.g = str4;
        }

        public c() {
        }
    }

    /* compiled from: BUGLY */
    public static class b {
        String a;
        public long b;
        public String c;

        public final String toString() {
            return "SLAData{uuid='" + this.a + "', time=" + this.b + ", data='" + this.c + "'}";
        }
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.b)) {
            al.d("sla report event is null", new Object[0]);
            return;
        }
        al.c("sla report single event", new Object[0]);
        a((List<c>) Collections.singletonList(cVar));
    }

    private b b(c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.b)) {
            al.d("sla convert event is null", new Object[0]);
            return null;
        }
        aa b2 = aa.b();
        if (b2 == null) {
            al.d("sla convert failed because ComInfoManager is null", new Object[0]);
            return null;
        }
        String str = "&app_version=" + b2.o + "&app_name=" + b2.q + "&app_bundle_id=" + b2.c + "&client_type=android&user_id=" + b2.f() + "&sdk_version=" + b2.h + "&event_code=" + cVar.b + "&event_result=" + (cVar.d ? 1 : 0) + "&event_time=" + this.a.format(new Date(cVar.c)) + "&event_cost=" + cVar.e + "&device_id=" + b2.g() + "&debug=" + (b2.D ? 1 : 0) + "&param_0=" + cVar.f + "&param_1=" + cVar.a + "&param_2=" + (b2.M ? "rqd" : "ext") + "&param_4=" + b2.e();
        if (!TextUtils.isEmpty(cVar.g)) {
            str = str + "&param_3=" + cVar.g;
        }
        al.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.a, cVar.b, Long.valueOf(cVar.c), Boolean.valueOf(cVar.d), Long.valueOf(cVar.e), cVar.f, cVar.g);
        b bVar = new b();
        bVar.a = cVar.a + "-" + cVar.b;
        bVar.b = cVar.c;
        bVar.c = str;
        return bVar;
    }
}

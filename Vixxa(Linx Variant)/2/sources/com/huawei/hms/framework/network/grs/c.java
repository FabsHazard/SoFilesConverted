package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.f.b;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class c {
    /* access modifiers changed from: private */
    public static final String i = "c";
    private static final ExecutorService j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    /* access modifiers changed from: private */
    public static long k = (-TimeUnit.DAYS.toMillis(2));
    /* access modifiers changed from: private */
    public GrsBaseInfo a;
    private Context b;
    /* access modifiers changed from: private */
    public g c;
    /* access modifiers changed from: private */
    public com.huawei.hms.framework.network.grs.e.a d;
    /* access modifiers changed from: private */
    public com.huawei.hms.framework.network.grs.e.c e;
    /* access modifiers changed from: private */
    public com.huawei.hms.framework.network.grs.e.c f;
    /* access modifiers changed from: private */
    public a g;
    private FutureTask<Boolean> h = null;

    class a implements Callable<Boolean> {
        final /* synthetic */ Context a;
        final /* synthetic */ GrsBaseInfo b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.a = context;
            this.b = grsBaseInfo;
        }

        public Boolean call() {
            g unused = c.this.c = new g();
            com.huawei.hms.framework.network.grs.e.c unused2 = c.this.e = new com.huawei.hms.framework.network.grs.e.c(this.a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            com.huawei.hms.framework.network.grs.e.c unused3 = c.this.f = new com.huawei.hms.framework.network.grs.e.c(this.a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar = c.this;
            com.huawei.hms.framework.network.grs.e.a unused4 = cVar.d = new com.huawei.hms.framework.network.grs.e.a(cVar.e, c.this.f, c.this.c);
            c cVar2 = c.this;
            a unused5 = cVar2.g = new a(cVar2.a, c.this.d, c.this.c, c.this.f);
            if (b.a(this.a.getPackageName()) == null) {
                new b(this.a, true).a(this.b);
            }
            String c2 = new com.huawei.hms.framework.network.grs.g.j.c(this.b, this.a).c();
            Logger.v(c.i, "scan serviceSet is: " + c2);
            String a2 = c.this.f.a("services", "");
            String a3 = h.a(a2, c2);
            if (!TextUtils.isEmpty(a3)) {
                c.this.f.b("services", a3);
                Logger.i(c.i, "postList is:" + StringUtils.anonymizeMessage(a3));
                Logger.i(c.i, "currentServices:" + StringUtils.anonymizeMessage(a2));
                if (!a3.equals(a2)) {
                    c.this.c.a(c.this.a.getGrsParasKey(true, true, this.a));
                    c.this.c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.b, this.a), (String) null, c.this.f);
                }
            }
            if (TimeUnit.MILLISECONDS.toHours(SystemClock.elapsedRealtime() - c.k) > 24) {
                c cVar3 = c.this;
                cVar3.a(cVar3.e.a());
                long unused6 = c.k = SystemClock.elapsedRealtime();
            }
            c.this.d.b(this.b, this.a);
            return true;
        }
    }

    c(Context context, GrsBaseInfo grsBaseInfo) {
        this.b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.b, grsBaseInfo2));
        this.h = futureTask;
        j.execute(futureTask);
        Logger.i(i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    c(GrsBaseInfo grsBaseInfo) {
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.a = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e2) {
            Logger.w(i, "GrsClient catch CloneNotSupportedException", (Throwable) e2);
            this.a = grsBaseInfo.copy();
        }
    }

    /* access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(i, "sp's content is empty.");
            return;
        }
        for (String next : map.keySet()) {
            if (next.endsWith(CrashHianalyticsData.TIME)) {
                String a2 = this.e.a(next, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(a2);
                    } catch (NumberFormatException e2) {
                        Logger.w(i, "convert expire time from String to Long catch NumberFormatException.", (Throwable) e2);
                    }
                }
                if (!b(j2)) {
                    Logger.i(i, "init interface auto clear some invalid sp's data.");
                    String substring = next.substring(0, next.length() - 4);
                    this.e.a(substring);
                    this.e.a(next);
                    this.e.a(substring + "ETag");
                }
            }
        }
    }

    private boolean b(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8, TimeUnit.SECONDS).booleanValue();
        } catch (CancellationException unused) {
            Logger.i(i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e2) {
            e = e2;
            str2 = i;
            str = "init compute task failed.";
            Logger.w(str2, str, e);
            return false;
        } catch (InterruptedException e3) {
            e = e3;
            str2 = i;
            str = "init compute task interrupted.";
            Logger.w(str2, str, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(i, "init compute task timed out");
            return false;
        } catch (Exception e4) {
            e = e4;
            str2 = i;
            str = "init compute task occur unknown Exception";
            Logger.w(str2, str, e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String a(String str, String str2) {
        if (this.a == null || str == null || str2 == null) {
            Logger.w(i, "invalid para!");
            return null;
        } else if (e()) {
            return this.g.a(str, str2, this.b);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> a(String str) {
        if (this.a != null && str != null) {
            return e() ? this.g.a(str, this.b) : new HashMap();
        }
        Logger.w(i, "invalid para!");
        return new HashMap();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (e()) {
            String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
            this.e.a(grsParasKey);
            this.e.a(grsParasKey + CrashHianalyticsData.TIME);
            this.e.a(grsParasKey + "ETag");
            this.c.a(grsParasKey);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(i, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, iQueryUrlsCallBack, this.b);
        } else {
            Logger.i(i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(i, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, str2, iQueryUrlCallBack, this.b);
        } else {
            Logger.i(i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass() || !(obj instanceof c)) {
            return false;
        }
        return this.a.compare(((c) obj).a);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.a) == null || (context = this.b) == null) {
            return false;
        }
        this.d.a(grsBaseInfo, context);
        return true;
    }
}

package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;

/* compiled from: BUGLY */
public final class ac {
    public static int a = 1000;
    public static long b = 259200000;
    private static ac d;
    /* access modifiers changed from: private */
    public static String i;
    public final ak c;
    private final List<o> e;
    private final StrategyBean f;
    /* access modifiers changed from: private */
    public StrategyBean g = null;
    /* access modifiers changed from: private */
    public Context h;

    private ac(Context context, List<o> list) {
        this.h = context;
        if (aa.a(context) != null) {
            String str = aa.a(context).H;
            if ("oversea".equals(str)) {
                StrategyBean.a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f = new StrategyBean();
        this.e = list;
        this.c = ak.a();
    }

    public static synchronized ac a(Context context, List<o> list) {
        ac acVar;
        synchronized (ac.class) {
            if (d == null) {
                d = new ac(context, list);
            }
            acVar = d;
        }
        return acVar;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = d;
        }
        return acVar;
    }

    public final synchronized boolean b() {
        return this.g != null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.g;
        if (strategyBean != null) {
            if (!ap.c(strategyBean.q)) {
                this.g.q = StrategyBean.a;
            }
            if (!ap.c(this.g.r)) {
                this.g.r = StrategyBean.b;
            }
            return this.g;
        }
        if (!ap.a(i) && ap.c(i)) {
            this.f.q = i;
            this.f.r = i;
        }
        return this.f;
    }

    /* access modifiers changed from: protected */
    public final void a(StrategyBean strategyBean, boolean z) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z);
        for (o next : this.e) {
            try {
                al.c("[Strategy] Notify %s", next.getClass().getName());
                next.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (ap.a(str) || !ap.c(str)) {
            al.d("URL user set is invalid.", new Object[0]);
        } else {
            i = str;
        }
    }

    public final void a(bt btVar) {
        int i2;
        bt btVar2 = btVar;
        if (btVar2 != null) {
            if (this.g == null || btVar2.h != this.g.o) {
                StrategyBean strategyBean = new StrategyBean();
                strategyBean.f = btVar2.a;
                strategyBean.h = btVar2.c;
                strategyBean.g = btVar2.b;
                if (ap.a(i) || !ap.c(i)) {
                    if (ap.c(btVar2.d)) {
                        al.c("[Strategy] Upload url changes to %s", btVar2.d);
                        strategyBean.q = btVar2.d;
                    }
                    if (ap.c(btVar2.e)) {
                        al.c("[Strategy] Exception upload url changes to %s", btVar2.e);
                        strategyBean.r = btVar2.e;
                    }
                }
                if (btVar2.f != null && !ap.a(btVar2.f.a)) {
                    strategyBean.s = btVar2.f.a;
                }
                if (btVar2.h != 0) {
                    strategyBean.o = btVar2.h;
                }
                if (!(btVar2 == null || btVar2.g == null || btVar2.g.size() <= 0)) {
                    strategyBean.t = btVar2.g;
                    String str = btVar2.g.get("B11");
                    strategyBean.i = str != null && str.equals("1");
                    String str2 = btVar2.g.get("B3");
                    if (str2 != null) {
                        strategyBean.w = Long.parseLong(str2);
                    }
                    strategyBean.p = (long) btVar2.l;
                    strategyBean.v = (long) btVar2.l;
                    String str3 = btVar2.g.get("B27");
                    if (str3 != null && str3.length() > 0) {
                        try {
                            int parseInt = Integer.parseInt(str3);
                            if (parseInt > 0) {
                                strategyBean.u = parseInt;
                            }
                        } catch (Exception e2) {
                            if (!al.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    String str4 = btVar2.g.get("B25");
                    strategyBean.k = str4 != null && str4.equals("1");
                }
                al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.f), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.j), Boolean.valueOf(strategyBean.m), Boolean.valueOf(strategyBean.n), Long.valueOf(strategyBean.p), Boolean.valueOf(strategyBean.k), Long.valueOf(strategyBean.o));
                this.g = strategyBean;
                if (!ap.c(btVar2.d)) {
                    i2 = 0;
                    al.c("[Strategy] download url is null", new Object[0]);
                    this.g.q = "";
                } else {
                    i2 = 0;
                }
                if (!ap.c(btVar2.e)) {
                    al.c("[Strategy] download crashurl is null", new Object[i2]);
                    this.g.r = "";
                }
                w.a().b(2);
                y yVar = new y();
                yVar.b = 2;
                yVar.a = strategyBean.d;
                yVar.e = strategyBean.e;
                yVar.g = ap.a((Parcelable) strategyBean);
                w.a().a(yVar);
                a(strategyBean, true);
            }
        }
    }

    public static StrategyBean d() {
        List<y> a2 = w.a().a(2);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        y yVar = a2.get(0);
        if (yVar.g != null) {
            return (StrategyBean) ap.a(yVar.g, StrategyBean.CREATOR);
        }
        return null;
    }
}

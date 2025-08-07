package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class au {
    /* access modifiers changed from: private */
    public static au a;
    private ac b;
    private aa c;
    private as d;
    private Context e;

    static /* synthetic */ void a(au auVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        Thread thread2;
        String str4;
        String str5;
        au auVar2 = auVar;
        int i2 = i;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        Map map2 = map;
        if (thread == null) {
            thread2 = Thread.currentThread();
        } else {
            thread2 = thread;
        }
        int i3 = 5;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else if (i2 != 8) {
            al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        if (!auVar2.b.b()) {
            al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
        }
        StrategyBean c2 = auVar2.b.c();
        if (!c2.f) {
            if (auVar2.b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(str4, ap.a(), auVar2.c.d, thread2.getName(), str6 + "\n" + str7 + "\n" + str8, (CrashDetailBean) null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
        }
        if (i2 == 5 || i2 == 6) {
            try {
                if (!c2.k) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    return;
                }
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return;
            } finally {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            }
        } else if (i2 == 8) {
            if (!c2.l) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
        }
        if (i2 != 8) {
            i3 = i2;
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = ab.j();
        crashDetailBean.D = ab.f();
        crashDetailBean.E = ab.l();
        crashDetailBean.F = auVar2.c.k();
        crashDetailBean.G = auVar2.c.j();
        crashDetailBean.H = auVar2.c.l();
        crashDetailBean.I = ab.b(auVar2.e);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        crashDetailBean.b = i3;
        crashDetailBean.e = auVar2.c.g();
        crashDetailBean.f = auVar2.c.o;
        crashDetailBean.g = auVar2.c.q();
        crashDetailBean.m = auVar2.c.f();
        crashDetailBean.n = String.valueOf(str);
        crashDetailBean.o = String.valueOf(str2);
        String str9 = "";
        if (str8 != null) {
            String[] split = str8.split("\n");
            if (split.length > 0) {
                str9 = split[0];
            }
            str5 = str8;
        } else {
            str5 = str9;
        }
        crashDetailBean.p = str9;
        crashDetailBean.q = str5;
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.z = ap.a(auVar2.c.Q, at.h);
        crashDetailBean.A = auVar2.c.d;
        crashDetailBean.B = thread2.getName() + "(" + thread2.getId() + ")";
        crashDetailBean.L = auVar2.c.s();
        crashDetailBean.h = auVar2.c.p();
        crashDetailBean.Q = auVar2.c.a;
        crashDetailBean.R = auVar2.c.a();
        crashDetailBean.U = auVar2.c.z();
        crashDetailBean.V = auVar2.c.x;
        crashDetailBean.W = auVar2.c.t();
        crashDetailBean.X = auVar2.c.y();
        crashDetailBean.y = ao.a();
        if (crashDetailBean.S == null) {
            crashDetailBean.S = new LinkedHashMap();
        }
        if (map2 != null) {
            crashDetailBean.S.putAll(map2);
        }
        as.a(str4, ap.a(), auVar2.c.d, thread2.getName(), str6 + "\n" + str7 + "\n" + str8, crashDetailBean);
        if (!auVar2.d.a(crashDetailBean, !at.a().B)) {
            auVar2.d.b(crashDetailBean, false);
        }
        al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
    }

    private au(Context context) {
        at a2 = at.a();
        if (a2 != null) {
            this.b = ac.a();
            this.c = aa.a(context);
            this.d = a2.r;
            this.e = context;
            ak.a().a(new Runnable() {
                public final void run() {
                    au.a(au.this);
                }
            });
        }
    }

    public static au a(Context context) {
        if (a == null) {
            a = new au(context);
        }
        return a;
    }

    public static void a(Thread thread, int i, String str, String str2, String str3, Map<String, String> map) {
        final Thread thread2 = thread;
        final int i2 = i;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Map<String, String> map2 = map;
        ak.a().a(new Runnable() {
            public final void run() {
                try {
                    if (au.a == null) {
                        al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        au.a(au.a, thread2, i2, str4, str5, str6, map2);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                    al.e("[ExtraCrashManager] Crash error %s %s %s", str4, str5, str6);
                }
            }
        });
    }

    static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            String str = "com.tencent.bugly";
            auVar.c.getClass();
            if (!"".equals("")) {
                str = "com.tencent.bugly.";
            }
            ap.a(cls, "sdkPackageName", (Object) str);
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }
}

package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
public final class at {
    private static at C = null;
    public static int a = 0;
    public static boolean b = false;
    public static int d = 2;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 3000;
    public static int h = 20480;
    public static long i = 604800000;
    public static String j = null;
    public static boolean k = false;
    public static String l = null;
    public static int m = 5000;
    public static boolean n = true;
    public static boolean o = false;
    public static String p;
    public static String q;
    public int A = 31;
    public boolean B = false;
    public final Context c;
    public final as r;
    public final av s;
    public final NativeCrashHandler t;
    public final ac u;
    public final ak v;
    public final ay w;
    public BuglyStrategy.a x;
    public aw y;
    public Boolean z;

    private at(Context context, ak akVar, boolean z2, BuglyStrategy.a aVar) {
        a = 1004;
        Context a2 = ap.a(context);
        this.c = a2;
        ac a3 = ac.a();
        this.u = a3;
        this.v = akVar;
        this.x = aVar;
        this.y = null;
        as asVar = new as(a2, ai.a(), w.a(), a3, aVar);
        this.r = asVar;
        aa a4 = aa.a(a2);
        this.s = new av(a2, asVar, a3, a4);
        NativeCrashHandler instance = NativeCrashHandler.getInstance(a2, a4, asVar, a3, akVar, z2, (String) null);
        this.t = instance;
        a4.N = instance;
        if (ay.f == null) {
            ay.f = new ay(a2, a3, a4, akVar, asVar);
        }
        this.w = ay.f;
    }

    public static synchronized at a(Context context, boolean z2, BuglyStrategy.a aVar) {
        at atVar;
        synchronized (at.class) {
            if (C == null) {
                C = new at(context, ak.a(), z2, aVar);
            }
            atVar = C;
        }
        return atVar;
    }

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            atVar = C;
        }
        return atVar;
    }

    public final void d() {
        this.t.setUserOpened(false);
    }

    public final void e() {
        this.t.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.w.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.w.b(false);
    }

    public final synchronized void a(boolean z2, boolean z3, boolean z4) {
        this.t.testNativeCrash(z2, z3, z4);
    }

    public final boolean i() {
        return this.w.a.get();
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.r.b(crashDetailBean);
    }

    public final void a(long j2) {
        ak.a().a(new Thread() {
            public final void run() {
                ArrayList arrayList;
                if (!ap.b(at.this.c, "local_crash_lock")) {
                    al.c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                ag a2 = ag.a.a;
                List<ag.b> a3 = ag.a();
                if (a3 == null || a3.isEmpty()) {
                    al.c("sla local data is null", new Object[0]);
                } else {
                    al.c("sla load local data list size:%s", Integer.valueOf(a3.size()));
                    Iterator<ag.b> it = a3.iterator();
                    ArrayList arrayList2 = new ArrayList();
                    while (it.hasNext()) {
                        ag.b next = it.next();
                        if (next.b < ap.b() - 604800000) {
                            al.c("sla local data is expired:%s", next.c);
                            arrayList2.add(next);
                            it.remove();
                        }
                    }
                    ag.d(arrayList2);
                    a2.b(a3);
                }
                List<CrashDetailBean> a4 = as.a();
                if (a4 == null || a4.size() <= 0) {
                    al.c("no crash need to be uploaded at this start", new Object[0]);
                } else {
                    al.c("Size of crash list: %s", Integer.valueOf(a4.size()));
                    int size = a4.size();
                    if (((long) size) > 20) {
                        ArrayList arrayList3 = new ArrayList();
                        Collections.sort(a4);
                        for (int i = 0; ((long) i) < 20; i++) {
                            arrayList3.add(a4.get((size - 1) - i));
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = a4;
                    }
                    at.this.r.a(arrayList, 0, false, false, false);
                }
                ap.c(at.this.c, "local_crash_lock");
            }
        }, j2);
    }

    public final boolean j() {
        return (this.A & 16) > 0;
    }

    public final boolean k() {
        return (this.A & 8) > 0;
    }

    public final synchronized void b() {
        this.s.a();
        e();
        f();
    }

    public final synchronized void c() {
        this.s.b();
        d();
        g();
    }

    public final synchronized void h() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    ap.b(5000);
                    i2 = i3;
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return;
                }
            }
        }
    }
}

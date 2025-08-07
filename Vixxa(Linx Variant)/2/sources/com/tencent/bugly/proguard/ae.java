package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ae {
    public static bu a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.a = userInfoBean.e;
        buVar.e = userInfoBean.j;
        buVar.d = userInfoBean.c;
        buVar.c = userInfoBean.d;
        buVar.h = userInfoBean.o == 1;
        int i = userInfoBean.b;
        if (i == 1) {
            buVar.b = 1;
        } else if (i == 2) {
            buVar.b = 4;
        } else if (i == 3) {
            buVar.b = 2;
        } else if (i == 4) {
            buVar.b = 3;
        } else if (i == 8) {
            buVar.b = 8;
        } else if (userInfoBean.b < 10 || userInfoBean.b >= 20) {
            al.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
            return null;
        } else {
            buVar.b = (byte) userInfoBean.b;
        }
        buVar.f = new HashMap();
        if (userInfoBean.p >= 0) {
            buVar.f.put("C01", new StringBuilder().append(userInfoBean.p).toString());
        }
        if (userInfoBean.q >= 0) {
            buVar.f.put("C02", new StringBuilder().append(userInfoBean.q).toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (Map.Entry next : userInfoBean.r.entrySet()) {
                buVar.f.put("C03_" + ((String) next.getKey()), next.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (Map.Entry next2 : userInfoBean.s.entrySet()) {
                buVar.f.put("C04_" + ((String) next2.getKey()), next2.getValue());
            }
        }
        buVar.f.put("A36", new StringBuilder().append(true ^ userInfoBean.l).toString());
        buVar.f.put("F02", new StringBuilder().append(userInfoBean.g).toString());
        buVar.f.put("F03", new StringBuilder().append(userInfoBean.h).toString());
        buVar.f.put("F04", userInfoBean.j);
        buVar.f.put("F05", new StringBuilder().append(userInfoBean.i).toString());
        buVar.f.put("F06", userInfoBean.m);
        buVar.f.put("F10", new StringBuilder().append(userInfoBean.k).toString());
        al.c("summary type %d vm:%d", Byte.valueOf(buVar.b), Integer.valueOf(buVar.f.size()));
        return buVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T t = (m) cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                t.a(kVar);
                return t;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bq a(Context context, int i, byte[] bArr) {
        aa b = aa.b();
        StrategyBean c = ac.a().c();
        if (b == null || c == null) {
            al.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            bq bqVar = new bq();
            synchronized (b) {
                bqVar.a = b.b;
                bqVar.b = b.e();
                bqVar.c = b.c;
                bqVar.d = b.o;
                bqVar.e = b.s;
                bqVar.f = b.h;
                bqVar.g = i;
                if (bArr == null) {
                    bArr = "".getBytes();
                }
                bqVar.h = bArr;
                bqVar.i = b.h();
                bqVar.j = b.k;
                bqVar.k = new HashMap();
                bqVar.l = b.d();
                bqVar.m = c.o;
                bqVar.o = b.g();
                bqVar.p = ab.c(context);
                bqVar.q = System.currentTimeMillis();
                bqVar.s = b.i();
                bqVar.v = b.g();
                bqVar.w = bqVar.p;
                b.getClass();
                bqVar.n = "com.tencent.bugly";
                bqVar.k.put("A26", b.s());
                bqVar.k.put("A62", new StringBuilder().append(aa.C()).toString());
                bqVar.k.put("A63", new StringBuilder().append(aa.D()).toString());
                bqVar.k.put("F11", new StringBuilder().append(b.J).toString());
                bqVar.k.put("F12", new StringBuilder().append(b.I).toString());
                bqVar.k.put("D3", b.q);
                if (p.b != null) {
                    for (o next : p.b) {
                        if (!(next.versionKey == null || next.version == null)) {
                            bqVar.k.put(next.versionKey, next.version);
                        }
                    }
                }
                bqVar.k.put("G15", ap.d("G15", ""));
                bqVar.k.put("G10", ap.d("G10", ""));
                bqVar.k.put("D4", ap.d("D4", "0"));
            }
            Map<String, String> x = b.x();
            if (x != null) {
                for (Map.Entry next2 : x.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) next2.getValue())) {
                        bqVar.k.put(next2.getKey(), next2.getValue());
                    }
                }
            }
            return bqVar;
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", obj);
            return eVar.a();
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static br a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object b = eVar.b("detail", new br());
                if (br.class.isInstance(b)) {
                    return br.class.cast(b);
                }
                return null;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.a.position()];
            System.arraycopy(lVar.a.array(), 0, bArr, 0, lVar.a.position());
            return bArr;
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}

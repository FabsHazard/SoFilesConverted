package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.a.a.b.c;
import com.igexin.a.a.c.a.f;
import com.igexin.a.a.d.e;
import com.igexin.assist.sdk.a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.d.b;
import com.igexin.push.d.c.k;
import com.microtech.aidexx.utils.TimeUtils;

public class m extends a {
    private void b() {
        f.a().a("Login successed with cid = " + d.s);
        b.a().f();
        com.igexin.a.a.c.b.a("loginRsp|" + d.s + "|success", new Object[0]);
        com.igexin.a.a.c.b.a("isCidBroadcasted|" + d.m, new Object[0]);
        if (!d.m) {
            r.a().c();
            d.m = true;
        }
        d.l = true;
        r.a().b();
        e.a().c();
        if (TextUtils.isEmpty(d.y)) {
            e.a().d();
        }
        com.igexin.push.util.d.f();
        a();
        d();
        i.a().b();
        e();
        f();
    }

    private void c() {
        com.igexin.a.a.c.b.a("loginRsp|" + d.s + "|failed", new Object[0]);
        f.a().a("Login " + d.s + " failed");
        com.igexin.a.a.c.b.a("LoginResultAction login failed, clear session or cid", new Object[0]);
        i.a().c();
        com.igexin.push.core.m.a().c();
    }

    private void d() {
        try {
            if ((System.currentTimeMillis() - d.J) - TimeUtils.oneDayMillis > 0) {
                com.igexin.a.a.c.b.a("LoginResultAction, over 24h, start get sdk cfg", new Object[0]);
                c.b().a(new com.igexin.push.f.a.c(new com.igexin.push.core.c.b(SDKUrlConfig.getConfigServiceUrl())), false, true);
            }
        } catch (Exception unused) {
        }
    }

    private void e() {
        if (!d.s.equals(d.t)) {
            d.t = d.s;
        }
    }

    private void f() {
        if (a.i(d.e)) {
            c.b().a(new n(this), false, true);
        }
    }

    public void a() {
        boolean z = (System.currentTimeMillis() - d.G) - TimeUtils.oneDayMillis > 0;
        boolean a = com.igexin.a.b.a.a(d.A, d.z);
        boolean equals = d.s.equals(d.t);
        com.igexin.a.a.c.b.a("LoginResultAction|isOverOneDay = " + z + ", isDeviceTokenDiff = " + (!a) + ", isCidDiff = " + (!equals), new Object[0]);
        if (z || !a || !equals) {
            e.a().e();
        }
    }

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof k)) {
            return true;
        }
        d.D = 0;
        if (d.l) {
            return true;
        }
        com.igexin.push.c.i.a().d().h();
        if (((k) obj).a) {
            b();
            return true;
        }
        c();
        return true;
    }
}

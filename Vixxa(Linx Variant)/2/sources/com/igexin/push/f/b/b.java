package com.igexin.push.f.b;

import com.igexin.push.core.a.e;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.core.h;
import java.util.concurrent.TimeUnit;

public class b extends g {
    private static b a;

    public b() {
        super(h.a().b());
        this.n = true;
    }

    public static b i() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public final int b_() {
        return -2147483642;
    }

    public void c() {
        super.c();
        if (!this.j) {
            j();
        }
    }

    public void d() {
    }

    /* access modifiers changed from: protected */
    public void d_() {
        e.a().k();
        d.F = System.currentTimeMillis();
        if (d.l) {
            com.igexin.a.a.c.b.a("heartbeatReq", new Object[0]);
            c.a().j().b();
            return;
        }
        com.igexin.a.a.c.b.a("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!", new Object[0]);
        j();
    }

    public void j() {
        a(h.a().b(), TimeUnit.MILLISECONDS);
    }

    public void k() {
    }
}

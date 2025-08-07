package com.igexin.push.f.b;

import com.igexin.a.a.b.c;
import com.igexin.push.core.a.e;
import com.microtech.aidexx.utils.TimeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class a extends g {
    private static a b;
    private List<c> a = new ArrayList();

    private a() {
        super(TimeUtils.oneMinuteMillis);
        this.n = true;
    }

    public static a i() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void j() {
        a(360000, TimeUnit.MILLISECONDS);
    }

    public boolean a(c cVar) {
        List<c> list = this.a;
        return list != null && !list.contains(cVar) && this.a.add(cVar);
    }

    public int b_() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void d_() {
        e.a().k();
        for (c next : this.a) {
            if (next.b()) {
                next.a();
                next.a(System.currentTimeMillis());
            }
        }
        j();
        c.b().a((Object) this);
    }
}

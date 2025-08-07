package com.igexin.push.core.a;

import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.igexin.a.a.c.b;
import com.igexin.a.a.d.e;
import com.igexin.push.config.k;
import com.igexin.push.core.b.i;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.core.m;
import com.igexin.push.d.c.o;

public class t extends a {
    private static final String a = (k.a + "_RegisterResultAction");

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            d.D = 0;
            b.a("register resp |" + oVar.a + Logger.c + d.r, new Object[0]);
            b.a("register resp cid = " + oVar.c + " device id = " + oVar.d, new Object[0]);
            if (oVar.a != d.r) {
                d.m = false;
                StringBuilder sb = new StringBuilder();
                String str = a;
                b.a(sb.append(str).append(" change session : from [").append(d.r).append("] to [").append(oVar.a).append("]").toString(), new Object[0]);
                b.a(str + " change cid : from [" + d.s + "] to [" + oVar.c + "]", new Object[0]);
                if (TextUtils.isEmpty(oVar.c) || TextUtils.isEmpty(oVar.d)) {
                    i.a().a(oVar.a);
                } else {
                    i.a().a(oVar.c, oVar.d, oVar.a);
                }
                d.G = 0;
            }
            b.a("loginReqAfterRegister|new session:" + d.r + ", cid :" + d.s + ", devId :" + d.y, new Object[0]);
            com.igexin.push.d.c.i d = m.a().d();
            c.a().i().a("S-" + d.a, d, true);
        }
        return true;
    }
}

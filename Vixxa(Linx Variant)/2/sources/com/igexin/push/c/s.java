package com.igexin.push.c;

import android.text.TextUtils;
import com.igexin.push.core.d;

public class s extends o implements r {
    private static s e;

    private s() {
        super(d.al, d.an);
        this.d.a(true);
    }

    public static synchronized s a() {
        s sVar;
        synchronized (s.class) {
            if (e == null) {
                e = new s();
            }
            sVar = e;
        }
        return sVar;
    }

    public void a(g gVar, j jVar) {
        k a;
        if (jVar != null && !TextUtils.isEmpty(jVar.a()) && (a = a(jVar.a())) != null) {
            b(jVar);
            a.d();
            l();
            if (gVar == g.a) {
                k();
            }
        }
    }

    public void a(j jVar) {
    }

    public h b() {
        return h.WIFI;
    }

    public r c() {
        return this;
    }
}

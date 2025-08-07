package com.igexin.push.core.a;

import com.igexin.a.a.c.b;
import com.igexin.a.a.d.e;
import com.igexin.push.core.m;
import com.igexin.push.d.c.h;

public class l extends a {
    private static final String a = "com.igexin.push.core.a.l";

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            boolean z = hVar.a == 0;
            StringBuilder sb = new StringBuilder();
            String str = a;
            b.a(sb.append(str).append("|KeyNego result = ").append(hVar.a).toString(), new Object[0]);
            if (z) {
                b.a(str + "|KeyNego success and login", new Object[0]);
                m.a().c();
            }
        }
        return true;
    }
}

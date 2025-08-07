package com.igexin.push.core.f;

import java.util.HashMap;
import java.util.Map;

public class b {
    private static b b;
    private Map<Long, a> a = new HashMap();

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private void d(a aVar) {
        if (aVar != null) {
            this.a.put(aVar.a(), aVar);
        }
    }

    public a a(Long l) {
        return this.a.get(l);
    }

    public void a(a aVar) {
        if (aVar != null) {
            d(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            aVar.c();
            c(aVar);
        }
    }

    public void c(a aVar) {
        if (aVar != null) {
            this.a.remove(aVar.a());
        }
    }
}

package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

public final class y {
    private static y b;
    private volatile Map<String, p0> a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new p0());
        }
        return this.a.get(str);
    }

    public static y a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        synchronized (y.class) {
            if (b == null) {
                b = new y();
            }
        }
    }

    public p0 a(String str, long j) {
        p0 a2 = a(str);
        a2.a(j);
        return a2;
    }
}

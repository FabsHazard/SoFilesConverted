package com.igexin.push.core.c;

import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.n;
import com.igexin.push.core.a.r;
import com.igexin.push.core.b.i;
import com.igexin.push.f.a.b;
import com.igexin.push.util.h;
import org.json.JSONArray;

public class a extends b {
    public static JSONArray b;
    public final String a = getClass().getName();

    public a(String str, JSONArray jSONArray) {
        super(str);
        a(jSONArray);
    }

    public void a(Exception exc) {
        i.a().b(System.currentTimeMillis());
        com.igexin.a.a.c.b.a("-> get idc config " + exc.toString(), new Object[0]);
    }

    public void a(JSONArray jSONArray) {
        b = jSONArray;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(com.igexin.a.b.a.c(h.a(bArr, 0)));
                com.igexin.a.a.c.b.a("->get idc config server resp data : ".concat(str), new Object[0]);
                com.igexin.push.config.a.a().b(str);
                n.a(str, true);
                i.a().b(0);
                com.igexin.push.config.a.a().a(b.toString());
                SDKUrlConfig.setIdcConfigUrl(r.a(b));
            } catch (Exception e) {
                i.a().b(System.currentTimeMillis());
                throw e;
            }
        }
    }

    public int b_() {
        return 0;
    }
}

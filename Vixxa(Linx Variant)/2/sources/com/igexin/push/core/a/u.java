package com.igexin.push.core.a;

import com.igexin.a.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.b.i;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

public class u extends b {
    private static final String a = k.a;

    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("response_deviceid")) {
                return true;
            }
            String string = jSONObject.getString("deviceid");
            b.a(a + " get devid resp, devid : " + string + ", save 2db and file", new Object[0]);
            i.a().b(string);
            if (d.y != null) {
                c.a().j().e();
            }
            b.a("deviceidRsp|" + d.y, new Object[0]);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}

package com.igexin.push.core.a;

import com.igexin.a.a.c.b;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.a;
import com.igexin.push.core.d;
import com.igexin.push.core.w;
import com.igexin.push.d.c.m;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

public class p extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        e a;
        String str;
        try {
            m mVar = (m) obj;
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("pushmessage")) {
                byte[] bArr = mVar.f instanceof byte[] ? (byte[]) mVar.f : null;
                String string = jSONObject.getString("taskid");
                b.a("getui receive message : %s", jSONObject);
                if (bArr == null || !a.i(d.e)) {
                    w.a().a(jSONObject, bArr, true);
                } else {
                    com.igexin.push.core.b.d dVar = new com.igexin.push.core.b.d(d.e);
                    if (!dVar.a(string)) {
                        dVar.b(string);
                        w.a().a(jSONObject, bArr, true);
                        a = e.a();
                        str = "10";
                    } else {
                        a = e.a();
                        str = "1" + MessageManger.getInstance().getBrandCode(d.e);
                    }
                    a.a(jSONObject, str);
                }
            }
        } catch (Exception e) {
            b.a("PushmessageAction|" + e.toString(), new Object[0]);
        }
        return true;
    }
}

package com.igexin.push.extension.distribution.basic.a;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.extension.distribution.basic.b.d;
import com.igexin.push.util.b;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import org.json.JSONObject;

public class h implements a {
    public com.igexin.push.core.a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        d dVar = (d) baseAction;
        try {
            Intent a = b.a(dVar.a(), 0);
            a.setPackage(com.igexin.push.core.d.e.getPackageName());
            a.addFlags(268435456);
            if (com.igexin.push.extension.distribution.basic.g.b.a(a, com.igexin.push.core.d.e)) {
                return com.igexin.push.core.a.success;
            }
            com.igexin.a.a.c.b.a("EXT-StartMyActivity|execute failed, activity not exist", new Object[0]);
            e.a().a(pushTaskBean.getId(), pushTaskBean.getMessageId(), dVar.b());
            return com.igexin.push.core.a.stop;
        } catch (Throwable th) {
            com.igexin.a.a.c.b.a("EXT-StartMyActivity|execute exception = " + th.toString(), new Object[0]);
            e.a().a(pushTaskBean.getId(), pushTaskBean.getMessageId(), dVar.b());
            return com.igexin.push.core.a.stop;
        }
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has(TransmitterActivityKt.OPERATION_TYPE) || !jSONObject.has("uri") || !jSONObject.has("do_failed")) {
                return null;
            }
            String string = jSONObject.getString("uri");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            d dVar = new d();
            dVar.setType("startmyactivity");
            dVar.setActionId(jSONObject.getString("actionid"));
            dVar.setDoActionId(jSONObject.getString("do"));
            dVar.a(string);
            dVar.b(jSONObject.getString("do_failed"));
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        e a;
        String id;
        String messageId;
        String b;
        d dVar = (d) baseAction;
        try {
            Intent a2 = b.a(dVar.a(), 0);
            a2.setPackage(com.igexin.push.core.d.e.getPackageName());
            a2.addFlags(268435456);
            if (com.igexin.push.extension.distribution.basic.g.b.a(a2, com.igexin.push.core.d.e)) {
                com.igexin.push.core.d.e.startActivity(a2);
                a = e.a();
                id = pushTaskBean.getTaskId();
                messageId = pushTaskBean.getMessageId();
                b = dVar.getDoActionId();
            } else {
                com.igexin.a.a.c.b.a("EXT-StartMyActivity|execute failed, activity not exist", new Object[0]);
                a = e.a();
                id = pushTaskBean.getId();
                messageId = pushTaskBean.getMessageId();
                b = dVar.b();
            }
            a.a(id, messageId, b);
            return true;
        } catch (Throwable th) {
            com.igexin.a.a.c.b.a("EXT-StartMyActivity|execute exception = " + th.getMessage(), new Object[0]);
            e.a().a(pushTaskBean.getId(), pushTaskBean.getMessageId(), dVar.b());
            return true;
        }
    }
}

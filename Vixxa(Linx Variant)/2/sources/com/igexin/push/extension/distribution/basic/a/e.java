package com.igexin.push.extension.distribution.basic.a;

import android.os.Handler;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.extension.distribution.basic.b.b;
import org.json.JSONObject;

public class e implements a {
    public com.igexin.push.core.a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return com.igexin.push.core.a.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            return b.a(jSONObject.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        b bVar = (b) baseAction;
        new Handler().postDelayed(new f(this, bVar, pushTaskBean), bVar.a());
        return true;
    }
}

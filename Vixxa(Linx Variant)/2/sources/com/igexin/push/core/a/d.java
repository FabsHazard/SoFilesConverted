package com.igexin.push.core.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.igexin.push.a.a.c;
import com.igexin.push.config.a;
import com.igexin.push.config.l;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

public class d extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("block_client") || !jSONObject.has(TypedValues.TransitionType.S_DURATION)) {
                return true;
            }
            long j = jSONObject.getLong(TypedValues.TransitionType.S_DURATION) * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            if (j == 0) {
                return true;
            }
            l.c = currentTimeMillis + j;
            a.a().e();
            c.c().d();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}

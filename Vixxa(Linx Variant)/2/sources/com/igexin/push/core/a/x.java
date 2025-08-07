package com.igexin.push.core.a;

import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.igexin.a.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.r;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

public class x extends b {
    private static final String a = (k.a + "_UnBindAliasResultAction");

    public boolean a(Object obj, JSONObject jSONObject) {
        b.a(a + "|unbind alias result resp data = " + jSONObject, new Object[0]);
        if (jSONObject == null) {
            return true;
        }
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("response_unbind")) {
                return true;
            }
            r.a().c(jSONObject.getString("sn"), jSONObject.getString(WiseOpenHianalyticsData.UNION_RESULT));
            return true;
        } catch (Exception e) {
            b.a(a + Logger.c + e.toString(), new Object[0]);
            return true;
        }
    }
}

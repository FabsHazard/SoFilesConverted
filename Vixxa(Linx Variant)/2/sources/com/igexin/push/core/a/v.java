package com.igexin.push.core.a;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.b;
import com.igexin.push.core.r;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

public class v extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("sendmessage_feedback")) {
                return true;
            }
            String string = jSONObject.getString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID);
            String string2 = jSONObject.getString("taskid");
            String string3 = jSONObject.getString("actionid");
            String string4 = jSONObject.getString(WiseOpenHianalyticsData.UNION_RESULT);
            long j = jSONObject.getLong("timestamp");
            b.a("SendMessageFeedbackAction|appid:" + string + "|taskid:" + string2 + "|actionid:" + string3, new Object[0]);
            r.a().a(string, string2, string3, string4, j);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}

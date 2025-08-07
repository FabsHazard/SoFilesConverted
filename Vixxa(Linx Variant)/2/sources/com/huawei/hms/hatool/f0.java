package com.huawei.hms.hatool;

import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import org.json.JSONObject;

public class f0 extends k0 {
    private String g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.d);
        jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, this.a);
        jSONObject.put("hmac", this.g);
        jSONObject.put("chifer", this.f);
        jSONObject.put("timestamp", this.b);
        jSONObject.put("servicetag", this.c);
        jSONObject.put("requestid", this.e);
        return jSONObject;
    }

    public void g(String str) {
        this.g = str;
    }
}

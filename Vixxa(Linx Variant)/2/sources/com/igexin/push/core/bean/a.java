package com.igexin.push.core.bean;

import android.os.Build;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.igexin.push.config.l;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.d;
import com.igexin.push.core.x;
import com.igexin.push.util.n;
import com.igexin.sdk.PushConsts;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f = "open";
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public long n;

    public a() {
        if (d.c != null) {
            this.f += ":" + d.c;
        }
        this.e = "4.4.3.13";
        this.b = d.v;
        this.c = d.u;
        this.d = d.x;
        this.a = d.w;
        this.h = "ANDROID";
        this.j = "android" + Build.VERSION.RELEASE;
        this.k = "MDP";
        this.g = d.y;
        this.n = System.currentTimeMillis();
        this.l = d.z;
        this.m = n.a();
        if (com.igexin.assist.sdk.a.j(d.e) && l.H) {
            StringBuilder sb = new StringBuilder("FCM-");
            String str = this.m;
            this.m = sb.append(str == null ? "" : str).toString();
        }
    }

    public static String a(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = aVar.a;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        jSONObject.put("model", str);
        String str3 = aVar.b;
        if (str3 == null) {
            str3 = str2;
        }
        jSONObject.put("sim", str3);
        String str4 = aVar.c;
        if (str4 == null) {
            str4 = str2;
        }
        jSONObject.put("imei", str4);
        String str5 = aVar.d;
        if (str5 == null) {
            str5 = str2;
        }
        jSONObject.put("mac", str5);
        String str6 = aVar.e;
        if (str6 == null) {
            str6 = str2;
        }
        jSONObject.put(WiseOpenHianalyticsData.UNION_VERSION, str6);
        String str7 = aVar.f;
        if (str7 == null) {
            str7 = str2;
        }
        jSONObject.put("channelid", str7);
        jSONObject.put(TransmitterActivityKt.OPERATION_TYPE, "ANDROID");
        String str8 = aVar.k;
        if (str8 == null) {
            str8 = str2;
        }
        jSONObject.put("app", str8);
        StringBuilder sb = new StringBuilder("ANDROID-");
        String str9 = aVar.g;
        if (str9 == null) {
            str9 = str2;
        }
        jSONObject.put("deviceid", sb.append(str9).toString());
        String str10 = aVar.l;
        if (str10 == null) {
            str10 = str2;
        }
        jSONObject.put("device_token", str10);
        String str11 = aVar.m;
        if (str11 == null) {
            str11 = str2;
        }
        jSONObject.put("brand", str11);
        String str12 = aVar.j;
        if (str12 == null) {
            str12 = str2;
        }
        jSONObject.put("system_version", str12);
        String str13 = aVar.i;
        if (str13 == null) {
            str13 = str2;
        }
        jSONObject.put("cell", str13);
        jSONObject.put("aid", str2);
        jSONObject.put("adid", str2);
        String name = x.a().b(d.e).getName();
        if (!CoreConsts.p.equals(name)) {
            jSONObject.put("us", name);
        }
        jSONObject.put("ua", x.a().d(d.e));
        if (d.av != null) {
            str2 = d.av;
        }
        jSONObject.put("oaid", str2);
        jSONObject.put("notification_enabled", com.igexin.push.util.a.a(d.e) ? 1 : 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PushConsts.CMD_ACTION, "addphoneinfo");
        jSONObject2.put("id", String.valueOf(aVar.n));
        jSONObject2.put(TransmitterActivityKt.BLE_INFO, jSONObject);
        return jSONObject2.toString();
    }
}

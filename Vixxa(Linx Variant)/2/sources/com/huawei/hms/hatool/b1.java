package com.huawei.hms.hatool;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import org.json.JSONObject;

public class b1 implements o1 {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TransmitterActivityKt.OPERATION_TYPE, this.a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.c));
        return jSONObject;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            this.c = jSONObject.optString("properties");
            this.c = n.a(this.c, o0.d().a());
            this.a = jSONObject.optString(TransmitterActivityKt.OPERATION_TYPE);
            this.d = jSONObject.optString("eventtime");
            this.e = jSONObject.optString("event_session_name");
            this.f = jSONObject.optString("first_session_event");
        }
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.a;
    }

    public void c(String str) {
        this.d = str;
    }

    public JSONObject d() {
        JSONObject a2 = a();
        a2.put("properties", n.b(this.c, o0.d().a()));
        return a2;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.e = str;
    }
}

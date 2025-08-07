package com.huawei.hms.hatool;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h1 implements o1 {
    private List<b1> a;
    private k0 b;
    private t0 c;
    private o1 d;
    private String e = "";
    private String f;

    public h1(String str) {
        this.f = str;
    }

    public JSONObject a() {
        String str;
        List<b1> list = this.a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.b == null || this.c == null || this.d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a2 = this.d.a();
            a2.put("properties", this.c.a());
            try {
                a2.put("events_global_properties", new JSONObject(this.e));
            } catch (JSONException unused) {
                a2.put("events_global_properties", this.e);
            }
            jSONObject2.put("events_common", a2);
            JSONArray jSONArray = new JSONArray();
            for (b1 a3 : this.a) {
                JSONObject a4 = a3.a();
                if (a4 != null) {
                    jSONArray.put(a4);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String a5 = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f);
                if (TextUtils.isEmpty(a5)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, a5);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.b = k0Var;
    }

    public void a(l lVar) {
        this.d = lVar;
    }

    public void a(t0 t0Var) {
        this.c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public void a(List<b1> list) {
        this.a = list;
    }
}

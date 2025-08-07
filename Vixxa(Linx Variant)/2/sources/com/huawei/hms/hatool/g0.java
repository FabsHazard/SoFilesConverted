package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g0 {
    private static g0 c;
    private Context a;
    private final Object b = new Object();

    private g0() {
    }

    public static g0 a() {
        if (c == null) {
            b();
        }
        return c;
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void b() {
        synchronized (g0.class) {
            if (c == null) {
                c = new g0();
            }
        }
    }

    public void a(Context context) {
        synchronized (this.b) {
            if (this.a == null) {
                this.a = context;
                e.a().a(context);
            }
        }
    }

    public void a(String str, int i) {
        e.a().a(str, i);
    }

    public void a(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i, str2, a((Map<String, String>) linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public void b(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        String str3 = str;
        int i2 = i;
        String str4 = str2;
        e.a().a(str3, i2, str4, a((Map<String, String>) linkedHashMap), System.currentTimeMillis());
    }
}

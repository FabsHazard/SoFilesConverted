package com.huawei.agconnect.config.impl;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class h implements d {
    private final JSONObject a;

    h(InputStream inputStream, String str) {
        this.a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private void a(String str) {
        try {
            JSONObject b = b(str);
            if (b != null) {
                String a2 = a("/configuration_version", "");
                BigDecimal bigDecimal = new BigDecimal("0.0");
                try {
                    bigDecimal = BigDecimal.valueOf(Double.parseDouble(a2));
                } catch (NumberFormatException unused) {
                    Log.d("InputStreamReader", "configuration_version to double error");
                }
                if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                    this.a.getJSONObject("client").put("app_id", b.getString("app_id"));
                } else if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                    Iterator<String> keys = b.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!"package_name".equals(next)) {
                            a(next, b.get(next), this.a);
                        }
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str != null && obj != null && jSONObject != null) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
                }
                return;
            }
            jSONObject.put(str, obj);
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.a.getJSONArray("appInfos");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    public String a(String str, String str2) {
        if (str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return str2;
        }
        String[] split = str.split(InternalZipConstants.ZIP_FILE_SEPARATOR);
        try {
            JSONObject jSONObject = this.a;
            for (int i = 1; i < split.length; i++) {
                if (i == split.length - 1) {
                    return jSONObject.get(split[i]).toString();
                }
                jSONObject = jSONObject.getJSONObject(split[i]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.a.toString().hashCode() + '}';
    }
}

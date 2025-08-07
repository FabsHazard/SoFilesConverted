package com.igexin.push.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.igexin.a.a.c.b;
import java.util.Iterator;
import org.json.JSONObject;

public class d {
    private static final Object b = new Object();
    private static final Object c = new Object();
    private SharedPreferences a;

    public d(Context context) {
        if (context != null) {
            this.a = context.getSharedPreferences("gx_msg_sp", 0);
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            if (jSONObject.length() >= 150) {
                Iterator<String> keys = jSONObject.keys();
                boolean z = false;
                long j = Long.MAX_VALUE;
                String str = null;
                while (keys.hasNext()) {
                    String next = keys.next();
                    long j2 = jSONObject.getLong(next);
                    if (j > j2) {
                        str = next;
                        j = j2;
                    }
                    if (j2 < System.currentTimeMillis() - 432000000) {
                        keys.remove();
                        z = true;
                    }
                }
                if (!z && str != null) {
                    jSONObject.remove(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        try {
            if (jSONObject.length() >= 20) {
                Iterator<String> keys = jSONObject.keys();
                boolean z = false;
                long j = Long.MAX_VALUE;
                String str = null;
                while (keys.hasNext()) {
                    String next = keys.next();
                    long parseLong = Long.parseLong(jSONObject.getJSONObject(next).getString("timestamp"));
                    if (j > parseLong) {
                        str = next;
                        j = parseLong;
                    }
                    if (parseLong < System.currentTimeMillis() - 432000000) {
                        keys.remove();
                        z = true;
                    }
                }
                if (!z && str != null) {
                    jSONObject.remove(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public JSONObject a() {
        try {
            String string = this.a.getString("taskIdList", "");
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, org.json.JSONObject r5) {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.a
            if (r0 == 0) goto L_0x003e
            if (r5 == 0) goto L_0x003e
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x000d
            goto L_0x003e
        L_0x000d:
            java.lang.Object r0 = b
            monitor-enter(r0)
            org.json.JSONObject r1 = r3.b()     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x001b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
        L_0x001b:
            int r2 = r1.length()     // Catch:{ all -> 0x0039 }
            if (r2 <= 0) goto L_0x0024
            r3.b((org.json.JSONObject) r1)     // Catch:{ all -> 0x0039 }
        L_0x0024:
            r1.put(r4, r5)     // Catch:{ all -> 0x0039 }
            android.content.SharedPreferences r4 = r3.a     // Catch:{ all -> 0x0039 }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = "usfdl"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0039 }
            r4.putString(r5, r1)     // Catch:{ all -> 0x0039 }
            r4.apply()     // Catch:{ all -> 0x0039 }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return
        L_0x003b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r4
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.d.a(java.lang.String, org.json.JSONObject):void");
    }

    public boolean a(String str) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject a2 = a();
                if (a2 != null && a2.has(str)) {
                    b.a("sp task " + str + " already exists", new Object[0]);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public JSONObject b() {
        try {
            String string = this.a.getString("usfdl", "");
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r5) {
        /*
            r4 = this;
            android.content.SharedPreferences r0 = r4.a
            if (r0 == 0) goto L_0x0040
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x000b
            goto L_0x0040
        L_0x000b:
            java.lang.Object r0 = c
            monitor-enter(r0)
            org.json.JSONObject r1 = r4.a()     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x0019
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x003b }
            r1.<init>()     // Catch:{ all -> 0x003b }
        L_0x0019:
            int r2 = r1.length()     // Catch:{ all -> 0x003b }
            if (r2 <= 0) goto L_0x0022
            r4.a((org.json.JSONObject) r1)     // Catch:{ all -> 0x003b }
        L_0x0022:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003b }
            r1.put(r5, r2)     // Catch:{ all -> 0x003b }
            android.content.SharedPreferences r5 = r4.a     // Catch:{ all -> 0x003b }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "taskIdList"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003b }
            r5.putString(r2, r1)     // Catch:{ all -> 0x003b }
            r5.apply()     // Catch:{ all -> 0x003b }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return
        L_0x003d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r5
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.d.b(java.lang.String):void");
    }

    public JSONObject c() {
        synchronized (b) {
            try {
                String string = this.a.getString("usfdl", "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(keys.next());
                    if (jSONObject2.has("timestamp")) {
                        if (Long.parseLong(jSONObject2.getString("timestamp")) >= System.currentTimeMillis() - 432000000) {
                        }
                    }
                    keys.remove();
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public void c(String str) {
        try {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("gx_vendor_token", str);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r4 = this;
            java.lang.Object r0 = b
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r4.a     // Catch:{ all -> 0x0015 }
            if (r1 == 0) goto L_0x0015
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = "usfdl"
            java.lang.String r3 = ""
            r1.putString(r2, r3)     // Catch:{ all -> 0x0015 }
            r1.apply()     // Catch:{ all -> 0x0015 }
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.d.d():void");
    }

    public String e() {
        try {
            return this.a.getString("gx_vendor_token", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }
}

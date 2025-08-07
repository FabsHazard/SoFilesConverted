package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {
    public c(Context context, boolean z) {
        this.e = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.d = true;
        }
    }

    private List<b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b bVar = new b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add((String) jSONArray.get(i));
                        }
                        bVar.a((Set<String>) hashSet);
                        arrayList.add(bVar);
                    }
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    public int a(String str) {
        this.a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.a.b(string);
            this.a.a(j);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    public int b(String str) {
        JSONObject jSONObject;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() == 0) {
                return 0;
            }
            this.b.addAll(a(jSONObject));
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x010a A[Catch:{ JSONException -> 0x011d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "countryGroup"
            java.lang.String r2 = "countryOrAreaGroup"
            java.lang.String r3 = "countryGroups"
            java.lang.String r4 = "countryOrAreaGroups"
            java.lang.String r5 = "LocalManagerV1"
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x011d }
            r7 = r20
            r6.<init>(r7)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r7 = "services"
            org.json.JSONObject r6 = r6.getJSONObject(r7)     // Catch:{ JSONException -> 0x011d }
            java.util.Iterator r7 = r6.keys()     // Catch:{ JSONException -> 0x011d }
        L_0x001d:
            boolean r8 = r7.hasNext()     // Catch:{ JSONException -> 0x011d }
            r9 = 0
            if (r8 == 0) goto L_0x011c
            java.lang.Object r8 = r7.next()     // Catch:{ JSONException -> 0x011d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x011d }
            com.huawei.hms.framework.network.grs.local.model.c r10 = new com.huawei.hms.framework.network.grs.local.model.c     // Catch:{ JSONException -> 0x011d }
            r10.<init>()     // Catch:{ JSONException -> 0x011d }
            r10.b(r8)     // Catch:{ JSONException -> 0x011d }
            java.util.Set<java.lang.String> r11 = r1.f     // Catch:{ JSONException -> 0x011d }
            boolean r11 = r11.contains(r8)     // Catch:{ JSONException -> 0x011d }
            if (r11 != 0) goto L_0x001d
            java.util.Set<java.lang.String> r11 = r1.f     // Catch:{ JSONException -> 0x011d }
            r11.add(r8)     // Catch:{ JSONException -> 0x011d }
            boolean r11 = r1.e     // Catch:{ JSONException -> 0x011d }
            if (r11 == 0) goto L_0x001d
            org.json.JSONObject r11 = r6.getJSONObject(r8)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r12 = "routeBy"
            java.lang.String r12 = r11.getString(r12)     // Catch:{ JSONException -> 0x011d }
            r10.c(r12)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r12 = "servings"
            org.json.JSONArray r12 = r11.getJSONArray(r12)     // Catch:{ JSONException -> 0x011d }
        L_0x0056:
            int r13 = r12.length()     // Catch:{ JSONException -> 0x011d }
            if (r9 >= r13) goto L_0x00df
            java.lang.Object r13 = r12.get(r9)     // Catch:{ JSONException -> 0x011d }
            org.json.JSONObject r13 = (org.json.JSONObject) r13     // Catch:{ JSONException -> 0x011d }
            com.huawei.hms.framework.network.grs.local.model.d r14 = new com.huawei.hms.framework.network.grs.local.model.d     // Catch:{ JSONException -> 0x011d }
            r14.<init>()     // Catch:{ JSONException -> 0x011d }
            boolean r15 = r13.has(r2)     // Catch:{ JSONException -> 0x011d }
            if (r15 == 0) goto L_0x0072
            java.lang.String r15 = r13.getString(r2)     // Catch:{ JSONException -> 0x011d }
            goto L_0x0084
        L_0x0072:
            boolean r15 = r13.has(r0)     // Catch:{ JSONException -> 0x011d }
            if (r15 == 0) goto L_0x007d
            java.lang.String r15 = r13.getString(r0)     // Catch:{ JSONException -> 0x011d }
            goto L_0x0084
        L_0x007d:
            java.lang.String r15 = "maybe this service routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r5, r15)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r15 = "no-country"
        L_0x0084:
            r14.a((java.lang.String) r15)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r15 = "addresses"
            org.json.JSONObject r13 = r13.getJSONObject(r15)     // Catch:{ JSONException -> 0x011d }
            java.util.concurrent.ConcurrentHashMap r15 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ JSONException -> 0x011d }
            r16 = r0
            r0 = 16
            r15.<init>(r0)     // Catch:{ JSONException -> 0x011d }
            java.util.Iterator r0 = r13.keys()     // Catch:{ JSONException -> 0x011d }
        L_0x009a:
            boolean r17 = r0.hasNext()     // Catch:{ JSONException -> 0x011d }
            if (r17 == 0) goto L_0x00cb
            java.lang.Object r17 = r0.next()     // Catch:{ JSONException -> 0x011d }
            r20 = r0
            r0 = r17
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x011d }
            java.lang.String r17 = r13.getString(r0)     // Catch:{ JSONException -> 0x011d }
            boolean r18 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x011d }
            if (r18 != 0) goto L_0x00c8
            boolean r17 = android.text.TextUtils.isEmpty(r17)     // Catch:{ JSONException -> 0x011d }
            if (r17 != 0) goto L_0x00c8
            r17 = r2
            java.lang.String r2 = r13.getString(r0)     // Catch:{ JSONException -> 0x011d }
            r15.put(r0, r2)     // Catch:{ JSONException -> 0x011d }
            r0 = r20
            r2 = r17
            goto L_0x009a
        L_0x00c8:
            r0 = r20
            goto L_0x009a
        L_0x00cb:
            r17 = r2
            r14.a((java.util.Map<java.lang.String, java.lang.String>) r15)     // Catch:{ JSONException -> 0x011d }
            java.lang.String r0 = r14.b()     // Catch:{ JSONException -> 0x011d }
            r10.a(r0, r14)     // Catch:{ JSONException -> 0x011d }
            int r9 = r9 + 1
            r0 = r16
            r2 = r17
            goto L_0x0056
        L_0x00df:
            r16 = r0
            r17 = r2
            boolean r0 = r11.has(r4)     // Catch:{ JSONException -> 0x011d }
            r2 = 0
            if (r0 == 0) goto L_0x00ef
            org.json.JSONObject r0 = r11.getJSONObject(r4)     // Catch:{ JSONException -> 0x011d }
            goto L_0x00f9
        L_0x00ef:
            boolean r0 = r11.has(r3)     // Catch:{ JSONException -> 0x011d }
            if (r0 == 0) goto L_0x00fe
            org.json.JSONObject r0 = r11.getJSONObject(r3)     // Catch:{ JSONException -> 0x011d }
        L_0x00f9:
            java.util.List r2 = r1.a(r2, r0)     // Catch:{ JSONException -> 0x011d }
            goto L_0x0103
        L_0x00fe:
            java.lang.String r0 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.v(r5, r0)     // Catch:{ JSONException -> 0x011d }
        L_0x0103:
            r10.a((java.util.List<com.huawei.hms.framework.network.grs.local.model.b>) r2)     // Catch:{ JSONException -> 0x011d }
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.a     // Catch:{ JSONException -> 0x011d }
            if (r0 != 0) goto L_0x0111
            com.huawei.hms.framework.network.grs.local.model.a r0 = new com.huawei.hms.framework.network.grs.local.model.a     // Catch:{ JSONException -> 0x011d }
            r0.<init>()     // Catch:{ JSONException -> 0x011d }
            r1.a = r0     // Catch:{ JSONException -> 0x011d }
        L_0x0111:
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.a     // Catch:{ JSONException -> 0x011d }
            r0.a(r8, r10)     // Catch:{ JSONException -> 0x011d }
            r0 = r16
            r2 = r17
            goto L_0x001d
        L_0x011c:
            return r9
        L_0x011d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r2 = "parse 1.0 services failed maybe because of json style.please check! %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r5, (java.lang.String) r2, (java.lang.Object[]) r0)
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.c.e(java.lang.String):int");
    }
}

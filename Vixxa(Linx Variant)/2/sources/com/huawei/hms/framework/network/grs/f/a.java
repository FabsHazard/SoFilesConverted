package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {
    protected com.huawei.hms.framework.network.grs.local.model.a a;
    protected List<b> b;
    protected Map<String, String> c = new ConcurrentHashMap(16);
    protected boolean d = false;
    protected boolean e = false;
    protected Set<String> f = new HashSet(16);

    private Map<String, String> a(List<b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (b next : list) {
            if (next.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), next.b());
            }
            if (next.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), next.b());
            }
            if (next.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), next.b());
            }
            if (next.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, next.b());
            }
        }
        return concurrentHashMap;
    }

    private int b(String str, Context context) {
        if (f(c.a(str, context)) != 0) {
            return -1;
        }
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    private int f(String str) {
        int b2;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.e && (b2 = b(str)) != 0) {
            return b2;
        }
        int a2 = a(str);
        return a2 != 0 ? a2 : e(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r0 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = c(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int g(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0008
            r2 = -1
            return r2
        L_0x0008:
            boolean r0 = r1.e
            if (r0 == 0) goto L_0x001d
            java.util.List<com.huawei.hms.framework.network.grs.local.model.b> r0 = r1.b
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001d
        L_0x0016:
            int r0 = r1.c(r2)
            if (r0 == 0) goto L_0x001d
            return r0
        L_0x001d:
            int r2 = r1.d(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.g(java.lang.String):int");
    }

    public abstract int a(String str);

    /* access modifiers changed from: package-private */
    public int a(String str, Context context) {
        return b(new StringBuilder().append(GrsApp.getInstance().getBrand(InternalZipConstants.ZIP_FILE_SEPARATOR)).append(str).toString(), context) != 0 ? -1 : 0;
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.a;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        Map<String, String> a2 = a(context, aVar, grsBaseInfo, str, z);
        if (a2 != null) {
            return a2.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public List<b> a(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                b bVar = new b();
                bVar.b(jSONObject.getString("id"));
                bVar.c(jSONObject.getString("name"));
                bVar.a(jSONObject.getString("description"));
                if (jSONObject.has("countriesOrAreas")) {
                    jSONArray2 = jSONObject.getJSONArray("countriesOrAreas");
                } else if (jSONObject.has("countries")) {
                    jSONArray2 = jSONObject.getJSONArray("countries");
                } else {
                    Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    jSONArray2 = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray2 != null) {
                    if (jSONArray2.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            hashSet.add((String) jSONArray2.get(i2));
                        }
                        bVar.a((Set<String>) hashSet);
                        arrayList.add(bVar);
                        i++;
                    }
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return new ArrayList();
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a2 = aVar2.a(str);
        if (a2 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String b2 = e.b(context, aVar, a2.b(), grsBaseInfo, z);
        if (b2 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a2.b());
            return null;
        }
        List<b> a3 = a2.a();
        d a4 = a2.a(((a3 == null || a3.size() == 0) ? this.c : a(a3, grsBaseInfo, b2)).get(b2));
        if (a4 == null) {
            return null;
        }
        return a4.a();
    }

    public void a(Context context, List<String> list) {
        if (list != null && list.size() > 0) {
            for (String next : list) {
                if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", next)) {
                    int g = g(c.a(GrsApp.getInstance().getBrand(InternalZipConstants.ZIP_FILE_SEPARATOR) + next, context));
                    Object[] objArr = {next};
                    if (g == 0) {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", objArr);
                    } else {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", objArr);
                    }
                }
            }
        }
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.c.put("no_route_country", "no-country");
        List<b> list = this.b;
        if (list != null && !list.isEmpty()) {
            for (b next : this.b) {
                if (next.a().contains(grsBaseInfo.getIssueCountry())) {
                    this.c.put(grsBaseInfo.getIssueCountry(), next.b());
                }
                if (next.a().contains(grsBaseInfo.getRegCountry())) {
                    this.c.put(grsBaseInfo.getRegCountry(), next.b());
                }
                if (next.a().contains(grsBaseInfo.getSerCountry())) {
                    this.c.put(grsBaseInfo.getSerCountry(), next.b());
                }
            }
            this.b = null;
        }
    }

    public abstract int b(String str);

    public Set<String> b() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(org.json.JSONArray r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x00f5
            int r0 = r15.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x00f5
        L_0x000a:
            r0 = 0
            r1 = r0
        L_0x000c:
            int r2 = r15.length()
            if (r1 >= r2) goto L_0x00f5
            org.json.JSONObject r2 = r15.getJSONObject(r1)
            com.huawei.hms.framework.network.grs.local.model.c r3 = new com.huawei.hms.framework.network.grs.local.model.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.b(r4)
            java.util.Set<java.lang.String> r5 = r14.f
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L_0x00f1
            java.util.Set<java.lang.String> r5 = r14.f
            r5.add(r4)
            boolean r5 = r14.e
            if (r5 == 0) goto L_0x00f1
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.c(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = r0
        L_0x0045:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto L_0x00be
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            com.huawei.hms.framework.network.grs.local.model.d r9 = new com.huawei.hms.framework.network.grs.local.model.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L_0x0065
        L_0x0060:
            java.lang.String r8 = r7.getString(r10)
            goto L_0x0079
        L_0x0065:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L_0x006e
            goto L_0x0060
        L_0x006e:
            java.lang.Object[] r10 = new java.lang.Object[]{r4}
            java.lang.String r11 = "maybe this service{%s} routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r8, r11, r10)
            java.lang.String r8 = "no-country"
        L_0x0079:
            r9.a((java.lang.String) r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L_0x008d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00b1
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L_0x008d
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x008d
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L_0x008d
        L_0x00b1:
            r9.a((java.util.Map<java.lang.String, java.lang.String>) r8)
            java.lang.String r7 = r9.b()
            r3.a(r7, r9)
            int r6 = r6 + 1
            goto L_0x0045
        L_0x00be:
            java.lang.String r5 = "countryOrAreaGroups"
            boolean r6 = r2.has(r5)
            if (r6 == 0) goto L_0x00cf
        L_0x00c6:
            org.json.JSONArray r2 = r2.getJSONArray(r5)
            java.util.List r2 = r14.a((org.json.JSONArray) r2)
            goto L_0x00de
        L_0x00cf:
            java.lang.String r5 = "countryGroups"
            boolean r6 = r2.has(r5)
            if (r6 == 0) goto L_0x00d8
            goto L_0x00c6
        L_0x00d8:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.i(r8, r2)
            r2 = 0
        L_0x00de:
            r3.a((java.util.List<com.huawei.hms.framework.network.grs.local.model.b>) r2)
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.a
            if (r2 != 0) goto L_0x00ec
            com.huawei.hms.framework.network.grs.local.model.a r2 = new com.huawei.hms.framework.network.grs.local.model.a
            r2.<init>()
            r14.a = r2
        L_0x00ec:
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.a
            r2.a(r4, r3)
        L_0x00f1:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.b(org.json.JSONArray):void");
    }

    public int c(String str) {
        JSONArray jSONArray;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            this.b.addAll(a(jSONArray));
            return 0;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    public boolean c() {
        return this.d;
    }

    public int d(String str) {
        try {
            b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    public abstract int e(String str);
}

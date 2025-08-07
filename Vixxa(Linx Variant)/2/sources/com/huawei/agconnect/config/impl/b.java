package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b implements AGConnectOptions {
    private final String a;
    private final Context b;
    private final String c;
    private final AGCRoutePolicy d;
    private final d e;
    private final e f;
    private final Map<String, String> g;
    private final List<Service> h;
    private final Map<String, String> i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.b = context;
        str = str == null ? context.getPackageName() : str;
        this.c = str;
        if (inputStream != null) {
            this.e = new h(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.e = new k(context, str);
        }
        this.f = new e(this.e);
        if (aGCRoutePolicy == AGCRoutePolicy.UNKNOWN || !"1.0".equals(this.e.a("/configuration_version", (String) null))) {
            this.d = (aGCRoutePolicy == null || aGCRoutePolicy == AGCRoutePolicy.UNKNOWN) ? Utils.getRoutePolicyFromJson(this.e.a("/region", (String) null), this.e.a("/agcgw/url", (String) null)) : aGCRoutePolicy;
            this.g = Utils.fixKeyPathMap(map);
            this.h = list;
            this.a = str2 == null ? b() : str2;
            return;
        }
        throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.i.containsKey(str)) {
            return this.i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String processOption = jsonProcessor.processOption(this);
        this.i.put(str, processOption);
        return processOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.c + "', routePolicy=" + this.d + ", reader=" + this.e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.h;
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    public Context getContext() {
        return this.b;
    }

    public String getIdentifier() {
        return this.a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i2) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i2)));
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public String getPackageName() {
        return this.c;
    }

    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String a2 = a(fixPath);
        if (a2 != null) {
            return a2;
        }
        String a3 = this.e.a(fixPath, str2);
        return e.a(a3) ? this.f.a(a3, str2) : a3;
    }
}

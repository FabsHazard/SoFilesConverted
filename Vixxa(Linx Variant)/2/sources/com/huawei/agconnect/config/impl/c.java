package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

public class c extends AGConnectServicesConfig {
    private final Context a;
    private final String b;
    private LazyInputStream c;
    private volatile d d;
    private final Object e = new Object();
    private AGCRoutePolicy f = AGCRoutePolicy.UNKNOWN;
    private final Map<String, String> g = new HashMap();
    private volatile e h;

    public c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) {
            public InputStream get(Context context) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return InternalZipConstants.ZIP_FILE_SEPARATOR + str.substring(i);
    }

    private void a() {
        if (this.d == null) {
            synchronized (this.e) {
                if (this.d == null) {
                    LazyInputStream lazyInputStream = this.c;
                    if (lazyInputStream != null) {
                        this.d = new h(lazyInputStream.loadInputStream(), "UTF-8");
                        this.c.close();
                        this.c = null;
                    } else {
                        this.d = new k(this.a, this.b);
                    }
                    this.h = new e(this.d);
                }
                b();
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f != AGCRoutePolicy.UNKNOWN) {
            return;
        }
        if (this.d != null) {
            this.f = Utils.getRoutePolicyFromJson(this.d.a("/region", (String) null), this.d.a("/agcgw/url", (String) null));
        } else {
            Log.w("AGConnectServiceConfig", "get route fail , config not ready");
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    public Context getContext() {
        return this.a;
    }

    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i)));
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public String getPackageName() {
        return this.b;
    }

    public AGCRoutePolicy getRoutePolicy() {
        if (this.f == null) {
            this.f = AGCRoutePolicy.UNKNOWN;
        }
        if (this.f == AGCRoutePolicy.UNKNOWN && this.d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy = this.f;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (str != null) {
            if (this.d == null) {
                a();
            }
            String a2 = a(str);
            String str3 = this.g.get(a2);
            if (str3 != null) {
                return str3;
            }
            String b2 = b(a2);
            if (b2 != null) {
                return b2;
            }
            String a3 = this.d.a(a2, str2);
            return e.a(a3) ? this.h.a(a3, str2) : a3;
        }
        throw new NullPointerException("path must not be null.");
    }

    public void overlayWith(LazyInputStream lazyInputStream) {
        this.c = lazyInputStream;
    }

    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.a, inputStream));
    }

    public void setParam(String str, String str2) {
        this.g.put(Utils.fixPath(str), str2);
    }

    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f = aGCRoutePolicy;
    }
}

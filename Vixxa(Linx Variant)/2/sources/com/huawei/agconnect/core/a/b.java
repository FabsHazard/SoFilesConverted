package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.config.impl.a;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b extends AGConnectInstance {
    private static List<Service> a;
    private static final Object b = new Object();
    private static final Map<String, AGConnectInstance> c = new HashMap();
    private static String d;
    private final AGConnectOptions e;
    private final d f;
    private final d g;

    public b(AGConnectOptions aGConnectOptions) {
        this.e = aGConnectOptions;
        if (a == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        this.f = new d(a, aGConnectOptions.getContext());
        d dVar = new d((List<Service>) null, aGConnectOptions.getContext());
        this.g = dVar;
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            dVar.a(((com.huawei.agconnect.config.impl.b) aGConnectOptions).a(), aGConnectOptions.getContext());
        }
    }

    public static AGConnectInstance a() {
        String str = d;
        if (str == null) {
            str = Utils.DEFAULT_NAME;
        }
        return a(str);
    }

    public static AGConnectInstance a(AGConnectOptions aGConnectOptions) {
        return a(aGConnectOptions, false);
    }

    private static AGConnectInstance a(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance aGConnectInstance;
        synchronized (b) {
            Map<String, AGConnectInstance> map = c;
            aGConnectInstance = map.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z) {
                aGConnectInstance = new b(aGConnectOptions);
                map.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    public static AGConnectInstance a(String str) {
        AGConnectInstance aGConnectInstance;
        synchronized (b) {
            aGConnectInstance = c.get(str);
            if (aGConnectInstance == null) {
                if (Utils.DEFAULT_NAME.equals(str)) {
                    Log.w("AGC_Instance", "please call `initialize()` first");
                } else {
                    Log.w("AGC_Instance", "not find instance for : " + str);
                }
            }
        }
        return aGConnectInstance;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            if (c.size() > 0) {
                Log.w("AGC_Instance", "Repeated invoking initialize");
            } else {
                a(context, (AGConnectOptions) AGConnectServicesConfig.fromContext(context));
            }
        }
    }

    private static synchronized void a(Context context, AGConnectOptions aGConnectOptions) {
        synchronized (b.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGC_Instance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            b();
            a.a(context);
            if (a == null) {
                a = new c(context).a();
            }
            a(aGConnectOptions, true);
            d = aGConnectOptions.getIdentifier();
            Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + aGConnectOptions.getRoutePolicy().getRouteName());
            a.a();
        }
    }

    public static synchronized void a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (b.class) {
            b(context, aGConnectOptionsBuilder);
            a(context, aGConnectOptionsBuilder.build(context));
        }
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() {
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() {
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    private static void b(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                String utils = Utils.toString(aGConnectOptionsBuilder.getInputStream(), "UTF-8");
                aGConnectOptionsBuilder.getInputStream().reset();
                fromContext.overlayWith((InputStream) new ByteArrayInputStream(utils.getBytes(Charset.forName("UTF-8"))));
            } catch (IOException unused) {
                Log.e("AGC_Instance", "input stream set to AGConnectServicesConfig fail");
            }
        }
        for (Map.Entry next : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            fromContext.setParam((String) next.getKey(), (String) next.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != AGCRoutePolicy.UNKNOWN) {
            fromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    public void a(final CustomAuthProvider customAuthProvider) {
        this.g.a((List<Service>) Collections.singletonList(Service.builder((Class<?>) AuthProvider.class, (Object) new AuthProvider() {
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            public Task<Token> getTokens(boolean z) {
                return customAuthProvider.getTokens(z);
            }

            public String getUid() {
                return "";
            }

            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()), this.e.getContext());
    }

    public void a(final CustomCredentialsProvider customCredentialsProvider) {
        this.g.a((List<Service>) Collections.singletonList(Service.builder((Class<?>) CredentialsProvider.class, (Object) new CredentialsProvider() {
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            public Task<Token> getTokens(boolean z) {
                return customCredentialsProvider.getTokens(z);
            }
        }).build()), this.e.getContext());
    }

    public Context getContext() {
        return this.e.getContext();
    }

    public String getIdentifier() {
        return this.e.getIdentifier();
    }

    public AGConnectOptions getOptions() {
        return this.e;
    }

    public <T> T getService(Class<? super T> cls) {
        T a2 = this.g.a((AGConnectInstance) this, (Class<?>) cls);
        return a2 != null ? a2 : this.f.a((AGConnectInstance) this, (Class<?>) cls);
    }
}

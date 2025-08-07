package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b {
    private static final Map<String, b> b = new ConcurrentHashMap(16);
    private static final Object c = new Object();
    private a a;

    public b(Context context, boolean z) {
        a(context, z);
        b.put(context.getPackageName(), this);
    }

    public static b a(String str) {
        return b.get(str);
    }

    private void a(Context context, boolean z) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        List arrayList = list == null ? new ArrayList() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.a = new d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.a = new d(context, appConfigName, z);
        }
        if (!this.a.c() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.a = new c(context, z);
        }
        this.a.a(context, (List<String>) arrayList);
    }

    public a a() {
        return this.a.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        String a2;
        synchronized (c) {
            a2 = this.a.a(context, aVar, grsBaseInfo, str, str2, z);
        }
        return a2;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        Map<String, String> a2;
        synchronized (c) {
            a2 = this.a.a(context, aVar, grsBaseInfo, str, z);
        }
        return a2;
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.a.a(grsBaseInfo);
    }

    public Set<String> b() {
        return this.a.b();
    }
}

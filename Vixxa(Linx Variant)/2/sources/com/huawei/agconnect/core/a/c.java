package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
    private final Context a;

    private static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        /* renamed from: a */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    c(Context context) {
        this.a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (ServiceRegistrar) Class.forName(str).newInstance();
            }
            Log.e("ServiceRegistrarParser", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e) {
            sb = new StringBuilder("Can not found service class, ").append(e.getMessage());
            Log.e("ServiceRegistrarParser", sb.toString());
            return null;
        } catch (InstantiationException e2) {
            sb2 = new StringBuilder("instantiate service class exception ");
            str2 = e2.getLocalizedMessage();
            sb = sb2.append(str2);
            Log.e("ServiceRegistrarParser", sb.toString());
            return null;
        } catch (IllegalAccessException e3) {
            sb2 = new StringBuilder("instantiate service class exception ");
            str2 = e3.getLocalizedMessage();
            sb = sb2.append(str2);
            Log.e("ServiceRegistrarParser", sb.toString());
            return null;
        }
    }

    private List<String> b() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle c = c();
        if (c == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : c.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(c.getString(str))) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder("registrar configuration format error:");
                        str = e.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new StringBuilder("registrar configuration error, ");
                    Log.e("ServiceRegistrarParser", sb.append(str).toString());
                }
            }
        }
        ArrayList<Map.Entry> arrayList2 = new ArrayList<>(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        for (Map.Entry key : arrayList2) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    private Bundle c() {
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(this.a, ServiceDiscovery.class), 128);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
    }

    public List<Service> a() {
        Log.i("ServiceRegistrarParser", "getServices");
        List<String> b = b();
        ArrayList arrayList = new ArrayList();
        for (String a2 : b) {
            ServiceRegistrar a3 = a(a2);
            if (a3 != null) {
                a3.initialize(this.a);
                List<Service> services = a3.getServices(this.a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}

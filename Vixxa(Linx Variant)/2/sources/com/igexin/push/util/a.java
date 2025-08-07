package com.igexin.push.util;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.common.util.Logger;
import com.igexin.a.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.bean.c;
import com.igexin.push.core.d;
import com.igexin.sdk.PushBuildConfig;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    private static final String a = "com.igexin.push.util.a";
    private static Integer b;

    private static void a(Map<String, c> map, String str) {
        map.remove(str);
        for (String next : map.get(str).b()) {
            c cVar = map.get(next);
            if (cVar != null) {
                cVar.e();
                if (cVar.c() == 0) {
                    a(map, next);
                }
            }
        }
    }

    public static boolean a() {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(l.i)) {
                return false;
            }
            for (String d : l.i.split(",")) {
                if (d(d)) {
                    return false;
                }
            }
            if (PushBuildConfig.sdk_conf_debug_level.equals(l.j)) {
                return false;
            }
            String[] split = l.j.split(",");
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", new Class[]{String.class});
            method.setAccessible(true);
            for (String a2 : split) {
                if (a(cls, method, a2)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long r4) {
        /*
            int r0 = com.igexin.push.config.l.b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.Date r0 = new java.util.Date
            r0.<init>(r4)
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r4.setTime(r0)
            r5 = 11
            int r4 = r4.get(r5)
            int r5 = com.igexin.push.config.l.a
            int r0 = com.igexin.push.config.l.b
            int r5 = r5 + r0
            r0 = 24
            if (r5 < r0) goto L_0x0023
            int r5 = r5 + -24
        L_0x0023:
            int r2 = com.igexin.push.config.l.a
            r3 = 1
            if (r2 >= r5) goto L_0x002f
            int r0 = com.igexin.push.config.l.a
            if (r4 < r0) goto L_0x003f
            if (r4 >= r5) goto L_0x003f
            return r3
        L_0x002f:
            int r2 = com.igexin.push.config.l.a
            if (r2 <= r5) goto L_0x003f
            if (r4 < 0) goto L_0x0038
            if (r4 >= r5) goto L_0x0038
            return r3
        L_0x0038:
            int r5 = com.igexin.push.config.l.a
            if (r4 < r5) goto L_0x003f
            if (r4 >= r0) goto L_0x003f
            return r3
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(long):boolean");
    }

    public static boolean a(Context context) {
        try {
            return ((Boolean) NotificationManager.class.getDeclaredMethod("areNotificationsEnabled", new Class[0]).invoke((NotificationManager) context.getSystemService("notification"), new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean a(Context context, Class cls) {
        if (context == null) {
            try {
                Log.e(a, "context can not set null ");
                return false;
            } catch (Throwable th) {
                b.a(a + Logger.c + th.toString(), new Object[0]);
                return false;
            }
        } else {
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent(context, cls), 0);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() > 0) {
                    if (packageManager.getActivityInfo(new ComponentName(context.getPackageName(), cls.getName()), 128).theme == 16973840) {
                        return true;
                    }
                    Log.e(a, cls.getName() + " need set theme Theme.Translucent.NoTitleBar");
                    return false;
                }
            }
            Log.e(a, "not regist " + cls.getName() + "in manifest");
            return false;
        }
    }

    public static boolean a(Intent intent, Context context) {
        if (!(intent == null || context == null)) {
            try {
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                return queryIntentServices != null && queryIntentServices.size() > 0;
            } catch (Throwable th) {
                b.a(a + Logger.c + th.toString(), new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(Class<?> cls, Method method, String str) {
        try {
            return method.invoke(cls, new Object[]{str}) != null;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean a(String str) {
        try {
            return d.e.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T extends Service> boolean a(String str, Context context, Class<T> cls) {
        if (cls == null) {
            try {
                if (!a(new Intent(context, Class.forName(CoreConsts.p)), context)) {
                    com.igexin.a.a.c.a.c.a().a("call - > initialize, parameter [userServiceName] is null use default PushService, but didn't find class \"com.igexin.sdk.PushService\", please check your AndroidManifest");
                    return false;
                }
            } catch (Throwable th) {
                b.a(a + Logger.c + th.toString(), new Object[0]);
                return false;
            }
        }
        if (cls != null && CoreConsts.p.equals(cls.getName()) && !a(new Intent(context, cls), context)) {
            com.igexin.a.a.c.a.c.a().a("call - > initialize, parameter [userServiceName] is default PushService, but didn't find class \"com.igexin.sdk.PushService\", please check your AndroidManifest");
            return false;
        } else if (cls != null && !a(new Intent(context, cls), context)) {
            com.igexin.a.a.c.a.c.a().a("call - > initialize, parameter [userServiceName] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
            return false;
        } else if (cls == null) {
            return true;
        } else {
            Class.forName(cls.getName());
            return true;
        }
    }

    public static boolean a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String string;
        String str4 = "buttons";
        String str5 = TransmitterActivityKt.OPERATION_TYPE;
        String str6 = "actionid";
        try {
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                c cVar = new c();
                if (jSONObject2.has(str6)) {
                    cVar.a(jSONObject2.getString(str6));
                    if (hashMap.containsKey(cVar.a())) {
                        return true;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject2.has(str5)) {
                        String string2 = jSONObject2.getString(str5);
                        str3 = str5;
                        str2 = str6;
                        if ("popup".equals(string2)) {
                            if (jSONObject2.has(str4)) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray(str4);
                                str = str4;
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    if (((JSONObject) jSONArray2.get(i2)).has("do")) {
                                        arrayList.add(((JSONObject) jSONArray2.get(i2)).getString("do"));
                                    }
                                }
                            } else {
                                str = str4;
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a((List<String>) arrayList);
                            hashMap.put(cVar.a(), cVar);
                            i++;
                            str5 = str3;
                            str6 = str2;
                            str4 = str;
                        } else {
                            str = str4;
                            if ("startapp".equals(string2)) {
                                if (jSONObject2.has("noinstall_action")) {
                                    arrayList.add(jSONObject2.getString("noinstall_action"));
                                }
                                if (jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else if ("checkapp".equals(string2)) {
                                if (jSONObject2.has("do_installed")) {
                                    arrayList.add(jSONObject2.getString("do_installed"));
                                }
                                if (jSONObject2.has("do_uninstalled")) {
                                    string = jSONObject2.getString("do_uninstalled");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else if ("checkversions".equals(string2)) {
                                if (jSONObject2.has("do_match")) {
                                    arrayList.add(jSONObject2.getString("do_match"));
                                }
                                if (jSONObject2.has("do_dismatch")) {
                                    arrayList.add(jSONObject2.getString("do_dismatch"));
                                }
                                if (jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else if ("startintent".equals(string2)) {
                                if (jSONObject2.has("do_failed")) {
                                    arrayList.add(jSONObject2.getString("do_failed"));
                                }
                                if (jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else {
                                if (!"null".equals(string2) && jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            }
                        }
                        arrayList.add(string);
                        cVar.a((List<String>) arrayList);
                        hashMap.put(cVar.a(), cVar);
                        i++;
                        str5 = str3;
                        str6 = str2;
                        str4 = str;
                    }
                }
                str = str4;
                str3 = str5;
                str2 = str6;
                i++;
                str5 = str3;
                str6 = str2;
                str4 = str;
            }
            ArrayList<c> arrayList2 = new ArrayList<>(hashMap.values());
            for (Map.Entry value : hashMap.entrySet()) {
                List<String> b2 = ((c) value.getValue()).b();
                if (b2 != null) {
                    for (String str7 : b2) {
                        c cVar2 = (c) hashMap.get(str7);
                        if (cVar2 != null) {
                            cVar2.d();
                            if (arrayList2.contains(cVar2)) {
                                arrayList2.remove(cVar2);
                            }
                        }
                    }
                }
            }
            for (c a2 : arrayList2) {
                a((Map<String, c>) hashMap, a2.a());
            }
            if (hashMap.size() <= 0) {
                return false;
            }
            b.a(a + "|action_chains have loop nodeMap not empty", new Object[0]);
            return true;
        } catch (Throwable th) {
            b.a(a + "|isHaveLoop exception :" + th.toString(), new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r4) throws com.igexin.sdk.GetuiPushException {
        /*
            if (r4 == 0) goto L_0x0127
            android.content.Context r4 = r4.getApplicationContext()
            android.content.pm.ApplicationInfo r0 = r4.getApplicationInfo()
            int r0 = r0.flags
            r0 = r0 & 2
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            android.content.pm.PackageInfo r0 = com.igexin.push.util.n.b(r4)     // Catch:{ NameNotFoundException -> 0x004e }
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x004e }
            java.lang.String r1 = com.igexin.push.util.b.a((android.content.pm.ApplicationInfo) r0)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r0 == 0) goto L_0x003f
            android.os.Bundle r2 = r0.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            if (r2 != 0) goto L_0x0022
            goto L_0x003f
        L_0x0022:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r2 == 0) goto L_0x0030
            android.os.Bundle r0 = r0.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            java.lang.String r1 = "PUSH_APPID"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ NameNotFoundException -> 0x004e }
        L_0x0030:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r0 != 0) goto L_0x0037
            goto L_0x0052
        L_0x0037:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x004e }
            java.lang.String r1 = "未配置个推APPID"
            r0.<init>(r1)     // Catch:{ NameNotFoundException -> 0x004e }
            throw r0     // Catch:{ NameNotFoundException -> 0x004e }
        L_0x003f:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ NameNotFoundException -> 0x004e }
            if (r0 != 0) goto L_0x0046
            goto L_0x0052
        L_0x0046:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x004e }
            java.lang.String r1 = "未配置META-DATA"
            r0.<init>(r1)     // Catch:{ NameNotFoundException -> 0x004e }
            throw r0     // Catch:{ NameNotFoundException -> 0x004e }
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            java.lang.Class<com.igexin.sdk.PushService> r0 = com.igexin.sdk.PushService.class
            android.util.Pair r0 = com.igexin.push.util.b.a((android.content.Context) r4, (java.lang.Class) r0)
            java.lang.Object r0 = r0.first
            android.content.pm.ServiceInfo r0 = (android.content.pm.ServiceInfo) r0
            if (r0 == 0) goto L_0x011f
            java.lang.String r1 = r0.processName
            java.lang.String r2 = ":pushservice"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto L_0x0117
            java.lang.String r0 = r0.permission
            java.lang.String r1 = "android.permission.BIND_JOB_SERVICE"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x010f
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x00e6 }
            r3 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r0 == 0) goto L_0x00ea
            java.lang.String[] r0 = r0.requestedPermissions     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r0 == 0) goto L_0x00de
            int r2 = r0.length     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r2 == 0) goto L_0x00de
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "android.permission.INTERNET"
            boolean r2 = r0.contains(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            boolean r2 = r0.contains(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r2 == 0) goto L_0x00ce
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r2 = r0.contains(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r2 == 0) goto L_0x00c6
            java.lang.String r2 = "android.permission.ACCESS_WIFI_STATE"
            boolean r2 = r0.contains(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r2 == 0) goto L_0x00be
            java.lang.String r2 = "android.permission.VIBRATE"
            boolean r0 = r0.contains(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            if (r0 == 0) goto L_0x00b6
            goto L_0x00ea
        L_0x00b6:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "未在Manifest中配置所需权限：android.permission.VIBRATE"
            r0.<init>(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            throw r0     // Catch:{ NameNotFoundException -> 0x00e6 }
        L_0x00be:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "未在Manifest中配置所需权限：android.permission.ACCESS_WIFI_STATE"
            r0.<init>(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            throw r0     // Catch:{ NameNotFoundException -> 0x00e6 }
        L_0x00c6:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "未在Manifest中配置所需权限：android.permission.ACCESS_NETWORK_STATE"
            r0.<init>(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            throw r0     // Catch:{ NameNotFoundException -> 0x00e6 }
        L_0x00ce:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "未在Manifest中配置所需权限：android.permission.READ_PHONE_STATE"
            r0.<init>(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            throw r0     // Catch:{ NameNotFoundException -> 0x00e6 }
        L_0x00d6:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "未在Manifest中配置所需权限：android.permission.INTERNET"
            r0.<init>(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            throw r0     // Catch:{ NameNotFoundException -> 0x00e6 }
        L_0x00de:
            com.igexin.sdk.GetuiPushException r0 = new com.igexin.sdk.GetuiPushException     // Catch:{ NameNotFoundException -> 0x00e6 }
            java.lang.String r2 = "Manifest中无权限配置"
            r0.<init>(r2)     // Catch:{ NameNotFoundException -> 0x00e6 }
            throw r0     // Catch:{ NameNotFoundException -> 0x00e6 }
        L_0x00e6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ea:
            java.lang.Class<com.igexin.sdk.GTIntentService> r0 = com.igexin.sdk.GTIntentService.class
            android.util.Pair r4 = com.igexin.push.util.b.a((android.content.Context) r4, (java.lang.Class) r0)
            java.lang.Object r4 = r4.first
            android.content.pm.ServiceInfo r4 = (android.content.pm.ServiceInfo) r4
            if (r4 == 0) goto L_0x0107
            java.lang.String r4 = r4.permission
            boolean r4 = r1.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00ff
            return
        L_0x00ff:
            com.igexin.sdk.GetuiPushException r4 = new com.igexin.sdk.GetuiPushException
            java.lang.String r0 = "自定义GTIntentService需配置BIND_JOB_SERVICE权限"
            r4.<init>(r0)
            throw r4
        L_0x0107:
            com.igexin.sdk.GetuiPushException r4 = new com.igexin.sdk.GetuiPushException
            java.lang.String r0 = "未找到自定义GTIntentService"
            r4.<init>(r0)
            throw r4
        L_0x010f:
            com.igexin.sdk.GetuiPushException r4 = new com.igexin.sdk.GetuiPushException
            java.lang.String r0 = "PushService需配置BIND_JOB_SERVICE权限"
            r4.<init>(r0)
            throw r4
        L_0x0117:
            com.igexin.sdk.GetuiPushException r4 = new com.igexin.sdk.GetuiPushException
            java.lang.String r0 = "PushService需配置在pushservice进程"
            r4.<init>(r0)
            throw r4
        L_0x011f:
            com.igexin.sdk.GetuiPushException r4 = new com.igexin.sdk.GetuiPushException
            java.lang.String r0 = "未集成com.igexin.sdk.PushService"
            r4.<init>(r0)
            throw r4
        L_0x0127:
            com.igexin.sdk.GetuiPushException r4 = new com.igexin.sdk.GetuiPushException
            java.lang.String r0 = "传入的context为空"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.b(android.content.Context):void");
    }

    public static boolean b() {
        return System.currentTimeMillis() > l.c;
    }

    public static boolean b(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (!TextUtils.isEmpty(l.y)) {
                if (!PushBuildConfig.sdk_conf_debug_level.equals(l.y)) {
                    List<String> asList = Arrays.asList(l.y.split(","));
                    if (asList.isEmpty()) {
                        return false;
                    }
                    for (String startsWith : asList) {
                        if (str.startsWith(startsWith)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean c() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) d.e.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean c(Context context) {
        if (b == null) {
            b = (context.getApplicationInfo().flags & 2) == 0 ? -1 : 1;
        }
        return b.intValue() > 0;
    }

    public static boolean c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(l.A)) {
                if (!PushBuildConfig.sdk_conf_debug_level.equals(l.A)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(Arrays.asList(l.A.split(",")));
                    if (arrayList.isEmpty()) {
                        return false;
                    }
                    for (String contains : arrayList) {
                        if (str.contains(contains)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void d() {
        NetworkInfo.State state = ((ConnectivityManager) d.e.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            d.p = 1;
        } else {
            d.p = 0;
        }
    }

    private static boolean d(String str) {
        try {
            d.e.getPackageManager().getLaunchIntentForPackage(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e() {
        d.q = ((PowerManager) d.e.getSystemService("power")).isScreenOn() ? 1 : 0;
    }

    public static boolean f() {
        String str = l.L;
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            if ("*".equals(str)) {
                return false;
            }
            String lowerCase = n.a().toLowerCase();
            if (TextUtils.isEmpty(lowerCase)) {
                return true;
            }
            for (String lowerCase2 : str.split(",")) {
                if (lowerCase.contains(lowerCase2.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g() {
        try {
            for (String lowerCase : l.x.split(",")) {
                if (Build.MODEL.toLowerCase().contains(lowerCase.toLowerCase())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean h() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.e.getSystemService("connectivity");
            if (connectivityManager == null) {
                b.a(a + "|ConnectivityManager is null", new Object[0]);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            StringBuilder sb = new StringBuilder();
            String str = a;
            b.a(sb.append(str).append("|activeNetworkInfo = ").append(activeNetworkInfo).toString(), new Object[0]);
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                b.a(str + "|network available = false", new Object[0]);
                return false;
            }
            b.a(str + (activeNetworkInfo.getType() == 0 ? "mobile" : activeNetworkInfo.getType() == 1 ? "wifi" : PushBuildConfig.sdk_conf_debug_level) + "|connected", new Object[0]);
            return true;
        } catch (Throwable th) {
            b.a(a + "|network available ex =" + th.toString(), new Object[0]);
        }
    }

    public static boolean i() {
        return System.currentTimeMillis() >= 1182566108138L;
    }

    public static boolean j() {
        String str = l.K;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : str.split(",")) {
                if (str2.contains(Logger.c)) {
                    if (str2.contains("~")) {
                        String substring = str2.substring(0, str2.indexOf(Logger.c));
                        String[] split = str2.substring(str2.indexOf(Logger.c) + 1).split("~");
                        if (split.length == 2) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (n.a().equalsIgnoreCase(substring) && Build.VERSION.SDK_INT >= parseInt && Build.VERSION.SDK_INT <= parseInt2) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}

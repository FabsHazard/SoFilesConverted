package com.microtech.aidexx.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.microtech.aidexx.ui.main.MainActivity;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nJ\u0018\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J\u001c\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u0006\u0010\u001c\u001a\u00020\u0006J\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001bJ\u001a\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001bJO\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001b2.\u0010\"\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$0#\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010$¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/microtech/aidexx/utils/ActivityUtil;", "", "()V", "HARMONY_OS", "", "finishAll", "", "finishToMain", "getActivityList", "", "Landroid/app/Activity;", "getActivityThread", "getActivityThreadInActivityThreadStaticField", "getActivityThreadInActivityThreadStaticMethod", "getUid", "", "context", "Landroid/content/Context;", "isColorOS", "", "isForeground", "activity", "className", "isHarmonyOS", "isMIUI", "isServiceRunning", "serviceClass", "Ljava/lang/Class;", "recreateAll", "toActivity", "bundle", "Landroid/os/Bundle;", "cls", "clazz", "data", "", "Lkotlin/Pair;", "(Landroid/content/Context;Ljava/lang/Class;[Lkotlin/Pair;)V", "toSystemHome", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ActivityUtil.kt */
public final class ActivityUtil {
    private static final String HARMONY_OS = "harmony";
    public static final ActivityUtil INSTANCE = new ActivityUtil();

    private ActivityUtil() {
    }

    public final void finishToMain() {
        for (Activity next : getActivityList()) {
            if (!(next instanceof MainActivity)) {
                next.finish();
            }
        }
    }

    public final void finishAll() {
        for (Activity finish : getActivityList()) {
            finish.finish();
        }
    }

    public final void recreateAll() {
        for (Activity recreate : getActivityList()) {
            recreate.recreate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<android.app.Activity> getActivityList() {
        /*
            r10 = this;
            java.lang.String r0 = "getDeclaredField(...)"
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            r2 = 0
            java.lang.Object r3 = r10.getActivityThread()     // Catch:{ Exception -> 0x008e }
            if (r3 != 0) goto L_0x0011
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x008e }
            return r1
        L_0x0011:
            java.lang.Class r4 = r3.getClass()     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "mActivities"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch:{ Exception -> 0x008e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ Exception -> 0x008e }
            r5 = 1
            r4.setAccessible(r5)     // Catch:{ Exception -> 0x008e }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x008e }
            boolean r4 = r3 instanceof java.util.Map     // Catch:{ Exception -> 0x008e }
            if (r4 == 0) goto L_0x002d
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x008e }
            goto L_0x002e
        L_0x002d:
            r3 = r2
        L_0x002e:
            if (r3 != 0) goto L_0x0033
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x008e }
            return r1
        L_0x0033:
            java.util.Collection r3 = r3.values()     // Catch:{ Exception -> 0x008e }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x008e }
            r4 = r2
        L_0x003c:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x008b }
            if (r6 == 0) goto L_0x00a8
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x008b }
            if (r6 == 0) goto L_0x004d
            java.lang.Class r7 = r6.getClass()     // Catch:{ Exception -> 0x008b }
            goto L_0x004e
        L_0x004d:
            r7 = r2
        L_0x004e:
            if (r7 == 0) goto L_0x0057
            java.lang.String r8 = "activity"
            java.lang.reflect.Field r8 = r7.getDeclaredField(r8)     // Catch:{ Exception -> 0x008b }
            goto L_0x0058
        L_0x0057:
            r8 = r2
        L_0x0058:
            if (r8 != 0) goto L_0x005b
            goto L_0x005e
        L_0x005b:
            r8.setAccessible(r5)     // Catch:{ Exception -> 0x008b }
        L_0x005e:
            if (r8 == 0) goto L_0x0065
            java.lang.Object r8 = r8.get(r6)     // Catch:{ Exception -> 0x008b }
            goto L_0x0066
        L_0x0065:
            r8 = r2
        L_0x0066:
            java.lang.String r9 = "null cannot be cast to non-null type android.app.Activity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)     // Catch:{ Exception -> 0x008b }
            android.app.Activity r8 = (android.app.Activity) r8     // Catch:{ Exception -> 0x008b }
            if (r4 != 0) goto L_0x0087
            java.lang.String r9 = "paused"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r9)     // Catch:{ Exception -> 0x008b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ Exception -> 0x008b }
            r7.setAccessible(r5)     // Catch:{ Exception -> 0x008b }
            boolean r6 = r7.getBoolean(r6)     // Catch:{ Exception -> 0x008b }
            if (r6 != 0) goto L_0x0083
            r4 = r8
            goto L_0x003c
        L_0x0083:
            r1.addFirst(r8)     // Catch:{ Exception -> 0x008b }
            goto L_0x003c
        L_0x0087:
            r1.addFirst(r8)     // Catch:{ Exception -> 0x008b }
            goto L_0x003c
        L_0x008b:
            r0 = move-exception
            r2 = r4
            goto L_0x008f
        L_0x008e:
            r0 = move-exception
        L_0x008f:
            com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Get activity list fail : "
            r4.<init>(r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            r3.eAiDEX(r0)
            r4 = r2
        L_0x00a8:
            if (r4 == 0) goto L_0x00ad
            r1.addFirst(r4)
        L_0x00ad:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.ActivityUtil.getActivityList():java.util.List");
    }

    private final Object getActivityThread() {
        Object activityThreadInActivityThreadStaticField = getActivityThreadInActivityThreadStaticField();
        return activityThreadInActivityThreadStaticField == null ? getActivityThreadInActivityThreadStaticMethod() : activityThreadInActivityThreadStaticField;
    }

    private final Object getActivityThreadInActivityThreadStaticField() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private final Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    public final boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
            return Intrinsics.areEqual((Object) HARMONY_OS, method.invoke(cls, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isMIUI() {
        return StringsKt.equals("Xiaomi", Build.MANUFACTURER, true);
    }

    public final boolean isColorOS() {
        String str = Build.BRAND;
        if (StringsKt.equals("OPPO", str, true) || StringsKt.equals("OnePlus", str, true) || StringsKt.equals("realme", str, true)) {
            return true;
        }
        return false;
    }

    public final boolean isServiceRunning(Context context, Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        if (context == null) {
            return false;
        }
        Object systemService = context.getApplicationContext().getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE);
        if (runningServices != null && !runningServices.isEmpty()) {
            for (ActivityManager.RunningServiceInfo next : runningServices) {
                if (getUid(context) == next.uid && Intrinsics.areEqual((Object) cls.getName(), (Object) next.service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private final int getUid(Context context) {
        if (context == null) {
            return -1;
        }
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    return next.uid;
                }
            }
        }
        return -1;
    }

    public final boolean isForeground(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return isForeground(activity, name);
    }

    public final boolean isForeground(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        if (context != null && !TextUtils.isEmpty(str)) {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) systemService).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                ComponentName componentName = runningTasks.get(0).topActivity;
                Intrinsics.checkNotNull(componentName);
                return Intrinsics.areEqual((Object) str, (Object) componentName.getClassName());
            }
        }
        return false;
    }

    public final void toActivity(Context context, Class<?> cls, Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(pairArr, "data");
        Intent intent = new Intent(context, cls);
        for (Pair<String, ? extends Object> pair : pairArr) {
            Object second = pair.getSecond();
            if (second instanceof Boolean) {
                Object second2 = pair.getSecond();
                Intrinsics.checkNotNull(second2, "null cannot be cast to non-null type kotlin.Boolean");
                intent.putExtra(pair.getFirst(), ((Boolean) second2).booleanValue());
            } else if (second instanceof Byte) {
                Object second3 = pair.getSecond();
                Intrinsics.checkNotNull(second3, "null cannot be cast to non-null type kotlin.Byte");
                intent.putExtra(pair.getFirst(), ((Byte) second3).byteValue());
            } else if (second instanceof Integer) {
                Object second4 = pair.getSecond();
                Intrinsics.checkNotNull(second4, "null cannot be cast to non-null type kotlin.Int");
                intent.putExtra(pair.getFirst(), ((Integer) second4).intValue());
            } else if (second instanceof Short) {
                Object second5 = pair.getSecond();
                Intrinsics.checkNotNull(second5, "null cannot be cast to non-null type kotlin.Short");
                intent.putExtra(pair.getFirst(), ((Short) second5).shortValue());
            } else if (second instanceof Long) {
                Object second6 = pair.getSecond();
                Intrinsics.checkNotNull(second6, "null cannot be cast to non-null type kotlin.Long");
                intent.putExtra(pair.getFirst(), ((Long) second6).longValue());
            } else if (second instanceof Float) {
                Object second7 = pair.getSecond();
                Intrinsics.checkNotNull(second7, "null cannot be cast to non-null type kotlin.Float");
                intent.putExtra(pair.getFirst(), ((Float) second7).floatValue());
            } else if (second instanceof Double) {
                Object second8 = pair.getSecond();
                Intrinsics.checkNotNull(second8, "null cannot be cast to non-null type kotlin.Double");
                intent.putExtra(pair.getFirst(), ((Double) second8).doubleValue());
            } else if (second instanceof Character) {
                Object second9 = pair.getSecond();
                Intrinsics.checkNotNull(second9, "null cannot be cast to non-null type kotlin.Char");
                intent.putExtra(pair.getFirst(), ((Character) second9).charValue());
            } else if (second instanceof String) {
                Object second10 = pair.getSecond();
                Intrinsics.checkNotNull(second10, "null cannot be cast to non-null type kotlin.String");
                intent.putExtra(pair.getFirst(), (String) second10);
            } else if (second instanceof Serializable) {
                Object second11 = pair.getSecond();
                Intrinsics.checkNotNull(second11, "null cannot be cast to non-null type java.io.Serializable");
                intent.putExtra(pair.getFirst(), (Serializable) second11);
            } else if (second instanceof Parcelable) {
                Object second12 = pair.getSecond();
                Intrinsics.checkNotNull(second12, "null cannot be cast to non-null type android.os.Parcelable");
                intent.putExtra(pair.getFirst(), (Parcelable) second12);
            }
        }
        context.startActivity(intent);
    }

    public final void toActivity(Context context, Bundle bundle, Class<?> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intent intent = new Intent(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final void toActivity(Context context, Class<?> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "cls");
        context.startActivity(new Intent(context, cls));
    }

    public final void toSystemHome(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }
}

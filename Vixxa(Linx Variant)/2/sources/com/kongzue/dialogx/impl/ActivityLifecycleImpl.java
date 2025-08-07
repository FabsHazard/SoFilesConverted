package com.kongzue.dialogx.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.util.DialogXFloatingWindowActivity;
import java.lang.reflect.Field;

public class ActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {
    private static ActivityLifecycleImpl activityLifecycle;
    private static Application application;
    private onActivityResumeCallBack onActivityResumeCallBack;

    public interface onActivityResumeCallBack {
        void getActivity(Activity activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public ActivityLifecycleImpl(onActivityResumeCallBack onactivityresumecallback) {
        this.onActivityResumeCallBack = onactivityresumecallback;
    }

    public static void init(Context context, onActivityResumeCallBack onactivityresumecallback) {
        if (context != null) {
            Application applicationContext = getApplicationContext(context);
            if (applicationContext == null) {
                DialogX.error("DialogX 未初始化(E1)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
                return;
            }
            application = applicationContext;
            ActivityLifecycleImpl activityLifecycleImpl = activityLifecycle;
            if (activityLifecycleImpl != null) {
                applicationContext.unregisterActivityLifecycleCallbacks(activityLifecycleImpl);
            }
            ActivityLifecycleImpl activityLifecycleImpl2 = new ActivityLifecycleImpl(onactivityresumecallback);
            activityLifecycle = activityLifecycleImpl2;
            applicationContext.registerActivityLifecycleCallbacks(activityLifecycleImpl2);
            return;
        }
        Application application2 = application;
        if (application2 != null) {
            init(application2, onactivityresumecallback);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0045, code lost:
        return (android.app.Application) r0.getDeclaredMethod("getApplication", new java.lang.Class[0]).invoke(r0.getDeclaredMethod("currentActivityThread", new java.lang.Class[0]).invoke((java.lang.Object) null, new java.lang.Object[0]), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        return (android.app.Application) java.lang.Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new java.lang.Class[0]).invoke((java.lang.Object) null, (java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        com.kongzue.dialogx.DialogX.error("DialogX.init: 初始化异常，请确保init方法内传入的Context是有效的。");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = java.lang.Class.forName("android.app.ActivityThread");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.Application getApplicationContext(android.content.Context r5) {
        /*
            java.lang.String r0 = "android.app.ActivityThread"
            if (r5 == 0) goto L_0x000b
            android.content.Context r5 = r5.getApplicationContext()
            android.app.Application r5 = (android.app.Application) r5
            return r5
        L_0x000b:
            r5 = 0
            r1 = 0
            java.lang.Class r2 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r3 = "currentApplication"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0023 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ Exception -> 0x0023 }
            r3 = r5
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r2 = r2.invoke(r5, r5)     // Catch:{ Exception -> 0x0023 }
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ Exception -> 0x0023 }
            return r2
        L_0x0023:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r2 = "currentActivityThread"
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0046 }
            java.lang.reflect.Method r2 = r0.getDeclaredMethod(r2, r3)     // Catch:{ Exception -> 0x0046 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0046 }
            java.lang.Object r2 = r2.invoke(r5, r3)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r3 = "getApplication"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0046 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x0046 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0046 }
            java.lang.Object r0 = r0.invoke(r2, r3)     // Catch:{ Exception -> 0x0046 }
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ Exception -> 0x0046 }
            return r0
        L_0x0046:
            java.lang.String r0 = "android.app.AppGlobals"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = "getInitialApplication"
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x005e }
            java.lang.reflect.Method r0 = r0.getMethod(r2, r1)     // Catch:{ Exception -> 0x005e }
            r1 = r5
            java.lang.Object[] r1 = (java.lang.Object[]) r1     // Catch:{ Exception -> 0x005e }
            java.lang.Object r0 = r0.invoke(r5, r5)     // Catch:{ Exception -> 0x005e }
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ Exception -> 0x005e }
            return r0
        L_0x005e:
            java.lang.String r0 = "DialogX.init: 初始化异常，请确保init方法内传入的Context是有效的。"
            com.kongzue.dialogx.DialogX.error(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.impl.ActivityLifecycleImpl.getApplicationContext(android.content.Context):android.app.Application");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        return (android.app.Application) java.lang.Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new java.lang.Class[0]).invoke((java.lang.Object) null, (java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r0 = java.lang.Class.forName("android.app.ActivityThread");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        return (android.app.Application) r0.getDeclaredMethod("getApplication", new java.lang.Class[0]).invoke(r0.getDeclaredMethod("currentActivityThread", new java.lang.Class[0]).invoke((java.lang.Object) null, new java.lang.Object[0]), new java.lang.Object[0]);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.Application getApplicationContext() {
        /*
            java.lang.String r0 = "android.app.ActivityThread"
            android.app.Application r1 = application
            if (r1 == 0) goto L_0x0007
            return r1
        L_0x0007:
            r1 = 0
            r2 = 0
            java.lang.Class r3 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x001f }
            java.lang.String r4 = "currentApplication"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x001f }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x001f }
            r4 = r1
            java.lang.Object[] r4 = (java.lang.Object[]) r4     // Catch:{ Exception -> 0x001f }
            java.lang.Object r3 = r3.invoke(r1, r1)     // Catch:{ Exception -> 0x001f }
            android.app.Application r3 = (android.app.Application) r3     // Catch:{ Exception -> 0x001f }
            return r3
        L_0x001f:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r3 = "currentActivityThread"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0042 }
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x0042 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r3 = r3.invoke(r1, r4)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r4 = "getApplication"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0042 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0042 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r0 = r0.invoke(r3, r4)     // Catch:{ Exception -> 0x0042 }
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ Exception -> 0x0042 }
            return r0
        L_0x0042:
            java.lang.String r0 = "android.app.AppGlobals"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x005a }
            java.lang.String r3 = "getInitialApplication"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x005a }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r2)     // Catch:{ Exception -> 0x005a }
            r2 = r1
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x005a }
            java.lang.Object r0 = r0.invoke(r1, r1)     // Catch:{ Exception -> 0x005a }
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ Exception -> 0x005a }
            return r0
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.impl.ActivityLifecycleImpl.getApplicationContext():android.app.Application");
    }

    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap.size() < 1) {
                return null;
            }
            for (Object next : arrayMap.values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(next);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        onActivityResumeCallBack onactivityresumecallback = this.onActivityResumeCallBack;
        if (onactivityresumecallback != null && !(activity instanceof DialogXFloatingWindowActivity)) {
            onactivityresumecallback.getActivity(activity);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (application == null) {
            BaseDialog.init(activity);
        }
    }

    public void onActivityPreResumed(Activity activity) {
        super.onActivityPreResumed(activity);
        if (Build.VERSION.SDK_INT >= 29) {
            callOnResume(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (!activity.isDestroyed() && !activity.isFinishing() && !(activity instanceof DialogXFloatingWindowActivity)) {
            if (Build.VERSION.SDK_INT < 29) {
                callOnResume(activity);
            }
            BaseDialog.onActivityResume(activity);
        }
    }

    private void callOnResume(Activity activity) {
        onActivityResumeCallBack onactivityresumecallback;
        if (!activity.isDestroyed() && !activity.isFinishing() && !(activity instanceof DialogXFloatingWindowActivity) && (onactivityresumecallback = this.onActivityResumeCallBack) != null) {
            onactivityresumecallback.getActivity(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (BaseDialog.getTopActivity() == activity) {
            BaseDialog.cleanContext();
        }
        if (Build.VERSION.SDK_INT < 29) {
            BaseDialog.recycleDialog(activity);
        }
    }

    public void onActivityPreDestroyed(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            BaseDialog.recycleDialog(activity);
        }
    }

    public static boolean isExemptActivities(Activity activity) {
        if (activity == null) {
            return true;
        }
        for (String contains : DialogX.unsupportedActivitiesPackageNames) {
            if (activity.getClass().getName().contains(contains)) {
                return true;
            }
        }
        return false;
    }
}

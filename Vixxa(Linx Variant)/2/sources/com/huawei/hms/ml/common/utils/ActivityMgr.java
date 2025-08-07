package com.huawei.hms.ml.common.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = new ActivityMgr();
    private WeakReference<Activity> activity;

    public void onActivityDestroyed(Activity activity2) {
    }

    public void onActivityPaused(Activity activity2) {
    }

    public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity2) {
    }

    private ActivityMgr() {
    }

    public void init(Application application) {
        if (application == null) {
            SmartLog.w("ActivityMgr", "init failed for app is null");
            return;
        }
        ActivityMgr activityMgr = INST;
        application.unregisterActivityLifecycleCallbacks(activityMgr);
        application.registerActivityLifecycleCallbacks(activityMgr);
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public void onActivityCreated(Activity activity2, Bundle bundle) {
        SmartLog.d("ActivityMgr", "onCreated:" + toString(activity2));
        this.activity = new WeakReference<>(activity2);
    }

    public void onActivityStarted(Activity activity2) {
        SmartLog.d("ActivityMgr", "onStarted:" + toString(activity2));
        this.activity = new WeakReference<>(activity2);
    }

    public void onActivityResumed(Activity activity2) {
        SmartLog.d("ActivityMgr", "onResumed:" + toString(activity2));
        this.activity = new WeakReference<>(activity2);
    }

    private static String toString(Object obj) {
        return obj == null ? "null" : obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }
}

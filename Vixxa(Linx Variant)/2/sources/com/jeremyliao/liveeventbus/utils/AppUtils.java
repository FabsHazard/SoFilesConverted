package com.jeremyliao.liveeventbus.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.FileProvider;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppUtils {
    private static final ActivityLifecycleImpl ACTIVITY_LIFECYCLE = new ActivityLifecycleImpl();
    private static final String PERMISSION_ACTIVITY_CLASS_NAME = "com.blankj.utilcode.util.PermissionUtils$PermissionActivity";
    private static Application sApplication;

    public interface OnActivityDestroyedListener {
        void onActivityDestroyed(Activity activity);
    }

    public interface OnAppStatusChangedListener {
        void onBackground();

        void onForeground();
    }

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void init(Context context) {
        if (context == null) {
            init(getApplicationByReflect());
        } else {
            init((Application) context.getApplicationContext());
        }
    }

    public static void init(Application application) {
        if (sApplication == null) {
            if (application == null) {
                sApplication = getApplicationByReflect();
            } else {
                sApplication = application;
            }
            sApplication.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE);
        } else if (application != null && application.getClass() != sApplication.getClass()) {
            Application application2 = sApplication;
            ActivityLifecycleImpl activityLifecycleImpl = ACTIVITY_LIFECYCLE;
            application2.unregisterActivityLifecycleCallbacks(activityLifecycleImpl);
            activityLifecycleImpl.mActivityList.clear();
            sApplication = application;
            application.registerActivityLifecycleCallbacks(activityLifecycleImpl);
        }
    }

    public static Application getApp() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        Application applicationByReflect = getApplicationByReflect();
        init(applicationByReflect);
        return applicationByReflect;
    }

    private static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    static ActivityLifecycleImpl getActivityLifecycle() {
        return ACTIVITY_LIFECYCLE;
    }

    static LinkedList<Activity> getActivityList() {
        return ACTIVITY_LIFECYCLE.mActivityList;
    }

    static Context getTopActivityOrApp() {
        if (!isAppForeground()) {
            return getApp();
        }
        Activity topActivity = ACTIVITY_LIFECYCLE.getTopActivity();
        return topActivity == null ? getApp() : topActivity;
    }

    static boolean isAppForeground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) getApp().getSystemService("activity");
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() == 0)) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.importance == 100) {
                    return next.processName.equals(getApp().getPackageName());
                }
            }
        }
        return false;
    }

    static class ActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {
        final LinkedList<Activity> mActivityList = new LinkedList<>();
        private int mConfigCount = 0;
        final Map<Activity, Set<OnActivityDestroyedListener>> mDestroyedListenerMap = new HashMap();
        private int mForegroundCount = 0;
        private boolean mIsBackground = false;
        final Map<Object, OnAppStatusChangedListener> mStatusListenerMap = new HashMap();

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        ActivityLifecycleImpl() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            setTopActivity(activity);
        }

        public void onActivityStarted(Activity activity) {
            if (!this.mIsBackground) {
                setTopActivity(activity);
            }
            int i = this.mConfigCount;
            if (i < 0) {
                this.mConfigCount = i + 1;
            } else {
                this.mForegroundCount++;
            }
        }

        public void onActivityResumed(Activity activity) {
            setTopActivity(activity);
            if (this.mIsBackground) {
                this.mIsBackground = false;
                postStatus(true);
            }
        }

        public void onActivityStopped(Activity activity) {
            if (activity.isChangingConfigurations()) {
                this.mConfigCount--;
                return;
            }
            int i = this.mForegroundCount - 1;
            this.mForegroundCount = i;
            if (i <= 0) {
                this.mIsBackground = true;
                postStatus(false);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            this.mActivityList.remove(activity);
            consumeOnActivityDestroyedListener(activity);
            fixSoftInputLeaks(activity);
        }

        /* access modifiers changed from: package-private */
        public Activity getTopActivity() {
            Activity last;
            if (!this.mActivityList.isEmpty() && (last = this.mActivityList.getLast()) != null) {
                return last;
            }
            Activity topActivityByReflect = getTopActivityByReflect();
            if (topActivityByReflect != null) {
                setTopActivity(topActivityByReflect);
            }
            return topActivityByReflect;
        }

        /* access modifiers changed from: package-private */
        public void addOnAppStatusChangedListener(Object obj, OnAppStatusChangedListener onAppStatusChangedListener) {
            this.mStatusListenerMap.put(obj, onAppStatusChangedListener);
        }

        /* access modifiers changed from: package-private */
        public void removeOnAppStatusChangedListener(Object obj) {
            this.mStatusListenerMap.remove(obj);
        }

        /* access modifiers changed from: package-private */
        public void removeOnActivityDestroyedListener(Activity activity) {
            if (activity != null) {
                this.mDestroyedListenerMap.remove(activity);
            }
        }

        /* access modifiers changed from: package-private */
        public void addOnActivityDestroyedListener(Activity activity, OnActivityDestroyedListener onActivityDestroyedListener) {
            Set set;
            if (activity != null && onActivityDestroyedListener != null) {
                if (!this.mDestroyedListenerMap.containsKey(activity)) {
                    set = new HashSet();
                    this.mDestroyedListenerMap.put(activity, set);
                } else {
                    set = this.mDestroyedListenerMap.get(activity);
                    if (set.contains(onActivityDestroyedListener)) {
                        return;
                    }
                }
                set.add(onActivityDestroyedListener);
            }
        }

        private void postStatus(boolean z) {
            OnAppStatusChangedListener next;
            if (!this.mStatusListenerMap.isEmpty()) {
                Iterator<OnAppStatusChangedListener> it = this.mStatusListenerMap.values().iterator();
                while (it.hasNext() && (next = it.next()) != null) {
                    if (z) {
                        next.onForeground();
                    } else {
                        next.onBackground();
                    }
                }
            }
        }

        private void setTopActivity(Activity activity) {
            if (!AppUtils.PERMISSION_ACTIVITY_CLASS_NAME.equals(activity.getClass().getName())) {
                if (!this.mActivityList.contains(activity)) {
                    this.mActivityList.addLast(activity);
                } else if (!this.mActivityList.getLast().equals(activity)) {
                    this.mActivityList.remove(activity);
                    this.mActivityList.addLast(activity);
                }
            }
        }

        private void consumeOnActivityDestroyedListener(Activity activity) {
            Iterator<Map.Entry<Activity, Set<OnActivityDestroyedListener>>> it = this.mDestroyedListenerMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (next.getKey() == activity) {
                    for (OnActivityDestroyedListener onActivityDestroyed : (Set) next.getValue()) {
                        onActivityDestroyed.onActivityDestroyed(activity);
                    }
                    it.remove();
                }
            }
        }

        private Activity getTopActivityByReflect() {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivityList");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    return null;
                }
                for (Object next : map.values()) {
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
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
            }
        }

        private static void fixSoftInputLeaks(Activity activity) {
            InputMethodManager inputMethodManager;
            if (activity != null && (inputMethodManager = (InputMethodManager) AppUtils.getApp().getSystemService("input_method")) != null) {
                String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
                for (int i = 0; i < 4; i++) {
                    try {
                        Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                        if (declaredField != null) {
                            if (!declaredField.isAccessible()) {
                                declaredField.setAccessible(true);
                            }
                            Object obj = declaredField.get(inputMethodManager);
                            if (obj instanceof View) {
                                if (((View) obj).getRootView() == activity.getWindow().getDecorView().getRootView()) {
                                    declaredField.set(inputMethodManager, (Object) null);
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static final class FileProvider4UtilCode extends FileProvider {
        public boolean onCreate() {
            AppUtils.init(getContext());
            return true;
        }
    }
}

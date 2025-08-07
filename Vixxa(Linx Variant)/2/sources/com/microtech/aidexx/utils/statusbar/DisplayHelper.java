package com.microtech.aidexx.utils.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import com.huawei.hms.feature.dynamic.f.e;
import java.lang.reflect.Method;
import java.util.Locale;

public class DisplayHelper {
    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
    private static final String HUAWAI_DISPLAY_NOTCH_STATUS = "display_notch_status";
    private static final String TAG = "QMUIDisplayHelper";
    private static final String VIVO_NAVIGATION_GESTURE = "navigation_gesture_on";
    private static final String XIAOMI_DISPLAY_NOTCH_STATUS = "force_black";
    private static final String XIAOMI_FULLSCREEN_GESTURE = "force_fsg_nav_bar";
    private static Boolean sHasCamera = null;

    public static boolean isElevationSupported() {
        return true;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int dpToPx(int i) {
        return (int) ((((float) i) * DENSITY) + 0.5f);
    }

    public static int pxToDp(float f) {
        return (int) ((f / DENSITY) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float getFontDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        int i = getDisplayMetrics(context).heightPixels;
        return (!DeviceHelper.isXiaomi() || !xiaomiNavigationGestureEnabled(context)) ? i : i + getResourceNavHeight(context);
    }

    public static int[] getRealScreenSize(Context context) {
        return doGetRealScreenSize(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int[] doGetRealScreenSize(android.content.Context r8) {
        /*
            java.lang.String r0 = "window"
            java.lang.Object r8 = r8.getSystemService(r0)
            android.view.WindowManager r8 = (android.view.WindowManager) r8
            android.view.Display r8 = r8.getDefaultDisplay()
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            r8.getMetrics(r0)
            int r1 = r0.widthPixels
            int r0 = r0.heightPixels
            r2 = 0
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawWidth"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0045 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r3 = r3.invoke(r8, r4)     // Catch:{ Exception -> 0x0045 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0045 }
            int r1 = r3.intValue()     // Catch:{ Exception -> 0x0045 }
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r4 = "getRawHeight"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0045 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r3 = r3.invoke(r8, r4)     // Catch:{ Exception -> 0x0045 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0045 }
            int r0 = r3.intValue()     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ Exception -> 0x0067 }
            r3.<init>()     // Catch:{ Exception -> 0x0067 }
            r8.getRealSize(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.Class<android.view.Display> r4 = android.view.Display.class
            java.lang.String r5 = "getRealSize"
            r6 = 1
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0067 }
            java.lang.Class<android.graphics.Point> r7 = android.graphics.Point.class
            r6[r2] = r7     // Catch:{ Exception -> 0x0067 }
            java.lang.reflect.Method r2 = r4.getMethod(r5, r6)     // Catch:{ Exception -> 0x0067 }
            java.lang.Object[] r4 = new java.lang.Object[]{r3}     // Catch:{ Exception -> 0x0067 }
            r2.invoke(r8, r4)     // Catch:{ Exception -> 0x0067 }
            int r1 = r3.x     // Catch:{ Exception -> 0x0067 }
            int r0 = r3.y     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            int[] r8 = new int[]{r1, r0}
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.statusbar.DisplayHelper.doGetRealScreenSize(android.content.Context):int[]");
    }

    public static int getUsefulScreenWidth(Activity activity) {
        return getUsefulScreenWidth(activity, NotchHelper.hasNotch(activity));
    }

    public static int getUsefulScreenWidth(View view) {
        return getUsefulScreenWidth(view.getContext(), NotchHelper.hasNotch(view));
    }

    public static int getUsefulScreenWidth(Context context, boolean z) {
        boolean z2 = false;
        int i = getRealScreenSize(context)[0];
        if (context.getResources().getConfiguration().orientation == 2) {
            z2 = true;
        }
        return !z ? (!z2 || !DeviceHelper.isEssentialPhone() || Build.VERSION.SDK_INT >= 26) ? i : i - (StatusBarHelper.getStatusbarHeight(context) * 2) : (!z2 || !DeviceHelper.isHuawei() || huaweiIsNotchSetToShowInSetting(context)) ? i : i - NotchHelper.getNotchSizeInHuawei(context)[1];
    }

    public static int getUsefulScreenHeight(Activity activity) {
        return getUsefulScreenHeight(activity, NotchHelper.hasNotch(activity));
    }

    public static int getUsefulScreenHeight(View view) {
        return getUsefulScreenHeight(view.getContext(), NotchHelper.hasNotch(view));
    }

    private static int getUsefulScreenHeight(Context context, boolean z) {
        boolean z2 = true;
        int i = getRealScreenSize(context)[1];
        if (context.getResources().getConfiguration().orientation != 1) {
            z2 = false;
        }
        return (z || !z2 || !DeviceHelper.isEssentialPhone() || Build.VERSION.SDK_INT >= 26) ? i : i - (StatusBarHelper.getStatusbarHeight(context) * 2);
    }

    public static boolean isNavMenuExist(Context context) {
        return !ViewConfiguration.get(context).hasPermanentMenuKey() && !KeyCharacterMap.deviceHasKey(4);
    }

    public static int dp2px(Context context, int i) {
        return (int) (((double) (getDensity(context) * ((float) i))) + 0.5d);
    }

    public static int sp2px(Context context, int i) {
        return (int) (((double) (getFontDensity(context) * ((float) i))) + 0.5d);
    }

    public static int px2dp(Context context, int i) {
        return (int) (((double) (((float) i) / getDensity(context))) + 0.5d);
    }

    public static int px2sp(Context context, int i) {
        return (int) (((double) (((float) i) / getFontDensity(context))) + 0.5d);
    }

    public static boolean hasStatusBar(Context context) {
        if (!(context instanceof Activity) || (((Activity) context).getWindow().getAttributes().flags & 1024) != 1024) {
            return true;
        }
        return false;
    }

    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getStatusBarHeight(Context context) {
        if (DeviceHelper.isXiaomi()) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            int parseInt = Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString());
            if (parseInt > 0) {
                return context.getResources().getDimensionPixelSize(parseInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getNavMenuHeight(Context context) {
        if (!isNavMenuExist(context)) {
            return 0;
        }
        int resourceNavHeight = getResourceNavHeight(context);
        if (resourceNavHeight >= 0) {
            return resourceNavHeight;
        }
        return getRealScreenSize(context)[1] - getScreenHeight(context);
    }

    private static int getResourceNavHeight(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static final boolean hasCamera(Context context) {
        if (sHasCamera == null) {
            PackageManager packageManager = context.getPackageManager();
            sHasCamera = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.camera.front") || packageManager.hasSystemFeature("android.hardware.camera"));
        }
        return sHasCamera.booleanValue();
    }

    public static boolean hasHardwareMenuKey(Context context) {
        return ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static boolean hasInternet(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static boolean isPackageExist(Context context, String str) {
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean isSdcardReady() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String getCurCountryLan(Context context) {
        Locale locale = context.getResources().getConfiguration().getLocales().get(0);
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean isZhCN(Context context) {
        return context.getResources().getConfiguration().getLocales().get(0).getCountry().equalsIgnoreCase(e.e);
    }

    public static void setFullScreen(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(512);
        window.addFlags(1024);
    }

    public static void cancelFullScreen(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(1024);
        window.clearFlags(512);
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean hasNavigationBar(Context context) {
        if (!deviceHasNavigationBar()) {
            return false;
        }
        if (DeviceHelper.isVivo()) {
            return vivoNavigationGestureEnabled(context);
        }
        return true;
    }

    private static boolean deviceHasNavigationBar() {
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("hasNavigationBar", new Class[0]);
            declaredMethod2.setAccessible(true);
            return ((Boolean) declaredMethod2.invoke(invoke, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vivoNavigationGestureEnabled(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), VIVO_NAVIGATION_GESTURE, 0) != 0;
    }

    public static boolean xiaomiNavigationGestureEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), XIAOMI_FULLSCREEN_GESTURE, 0) != 0;
    }

    public static boolean huaweiIsNotchSetToShowInSetting(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), HUAWAI_DISPLAY_NOTCH_STATUS, 0) == 0;
    }

    public static boolean xiaomiIsNotchSetToShowInSetting(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), XIAOMI_DISPLAY_NOTCH_STATUS, 0) == 0;
    }
}

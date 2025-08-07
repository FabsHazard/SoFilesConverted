package com.microtech.aidexx.utils.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarHelper {
    private static final int STATUS_BAR_DEFAULT_HEIGHT_DP = 25;
    private static StatusBarType mStatusBarType = StatusBarType.Default;
    private static int sStatusBarHeight = -1;
    private static Integer sTransparentValue = null;
    public static float sVirtualDensity = -1.0f;
    public static float sVirtualDensityDpi = -1.0f;

    private enum StatusBarType {
        Default,
        Miui,
        Flyme,
        Android6
    }

    public static void translucent(Activity activity) {
        translucent(activity.getWindow());
    }

    public static void translucent(Window window) {
        translucent(window, (int) BasicMeasure.EXACTLY);
    }

    private static boolean supportTranslucent() {
        return !DeviceHelper.isEssentialPhone() || Build.VERSION.SDK_INT >= 26;
    }

    public static void translucent(Activity activity, int i) {
        translucent(activity.getWindow(), i);
    }

    public static void translucent(Window window, int i) {
        if (supportTranslucent()) {
            if (NotchHelper.isNotchOfficialSupport()) {
                handleDisplayCutoutMode(window);
            }
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static int retainSystemUiFlag(Window window, int i, int i2) {
        return (window.getDecorView().getSystemUiVisibility() & i2) == i2 ? i | i2 : i;
    }

    private static void handleDisplayCutoutMode(final Window window) {
        View decorView = window.getDecorView();
        if (decorView == null) {
            return;
        }
        if (ViewCompat.isAttachedToWindow(decorView)) {
            realHandleDisplayCutoutMode(window, decorView);
        } else {
            decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewDetachedFromWindow(View view) {
                }

                public void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    StatusBarHelper.realHandleDisplayCutoutMode(window, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void realHandleDisplayCutoutMode(Window window, View view) {
        if (view.getRootWindowInsets() != null && view.getRootWindowInsets().getDisplayCutout() != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
    }

    public static boolean setStatusBarLightMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (mStatusBarType != StatusBarType.Default) {
            return setStatusBarLightMode(activity, mStatusBarType);
        }
        if (isMIUICustomStatusBarLightModeImpl()) {
            mStatusBarType = StatusBarType.Miui;
            return true;
        } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
            mStatusBarType = StatusBarType.Flyme;
            return true;
        } else {
            Android6SetStatusBarLightMode(activity.getWindow(), true);
            mStatusBarType = StatusBarType.Android6;
            return true;
        }
    }

    private static boolean setStatusBarLightMode(Activity activity, StatusBarType statusBarType) {
        if (statusBarType == StatusBarType.Miui) {
            return MIUISetStatusBarLightMode(activity.getWindow(), true);
        }
        if (statusBarType == StatusBarType.Flyme) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }
        if (statusBarType == StatusBarType.Android6) {
            return Android6SetStatusBarLightMode(activity.getWindow(), true);
        }
        return false;
    }

    public static boolean setStatusBarDarkMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (mStatusBarType == StatusBarType.Default) {
            return true;
        }
        if (mStatusBarType == StatusBarType.Miui) {
            return MIUISetStatusBarLightMode(activity.getWindow(), false);
        }
        if (mStatusBarType == StatusBarType.Flyme) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }
        if (mStatusBarType == StatusBarType.Android6) {
            return Android6SetStatusBarLightMode(activity.getWindow(), false);
        }
        return true;
    }

    private static boolean Android6SetStatusBarLightMode(Window window, boolean z) {
        if (Build.VERSION.SDK_INT > 30) {
            WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z);
        } else {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
        if (!DeviceHelper.isMIUIV9()) {
            return true;
        }
        MIUISetStatusBarLightMode(window, z);
        return true;
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            if (z) {
                method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
            } else {
                method.invoke(window, new Object[]{0, Integer.valueOf(i)});
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isMIUICustomStatusBarLightModeImpl() {
        DeviceHelper.isMIUIV9();
        return DeviceHelper.isMIUIV5() || DeviceHelper.isMIUIV6() || DeviceHelper.isMIUIV7() || DeviceHelper.isMIUIV8();
    }

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            Android6SetStatusBarLightMode(window, z);
            if (DeviceHelper.isFlymeLowerThan(7)) {
                try {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                    Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    int i = declaredField.getInt((Object) null);
                    int i2 = declaredField2.getInt(attributes);
                    declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                    window.setAttributes(attributes);
                    return true;
                } catch (Exception unused) {
                }
            } else if (DeviceHelper.isFlyme()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullScreen(Activity activity) {
        try {
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Integer getStatusBarAPITransparentValue(Context context) {
        Integer num = sTransparentValue;
        if (num != null) {
            return num;
        }
        String str = null;
        for (String str2 : context.getPackageManager().getSystemSharedLibraryNames()) {
            if ("touchwiz".equals(str2)) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
            } else if (str2.startsWith("com.sonyericsson.navigationbar")) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT";
            }
        }
        if (str != null) {
            try {
                Field field = View.class.getField(str);
                if (field != null && field.getType() == Integer.TYPE) {
                    sTransparentValue = Integer.valueOf(field.getInt((Object) null));
                }
            } catch (Exception unused) {
            }
        }
        return sTransparentValue;
    }

    public static int getStatusbarHeight(Context context) {
        if (sStatusBarHeight == -1) {
            initStatusBarHeight(context);
        }
        return sStatusBarHeight;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.reflect.Field} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initStatusBarHeight(android.content.Context r5) {
        /*
            r0 = 0
            java.lang.String r1 = "com.android.internal.R$dimen"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x002b }
            java.lang.Object r2 = r1.newInstance()     // Catch:{ all -> 0x002b }
            boolean r3 = com.microtech.aidexx.utils.statusbar.DeviceHelper.isMeizu()     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x001c
            java.lang.String r3 = "status_bar_height_large"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0025 }
        L_0x001c:
            if (r0 != 0) goto L_0x0033
            java.lang.String r3 = "status_bar_height"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0025 }
            goto L_0x0033
        L_0x0025:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r2
            r2 = r4
            goto L_0x002e
        L_0x002b:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002e:
            r2.printStackTrace()
            r2 = r0
            r0 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x0052
            if (r2 == 0) goto L_0x0052
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004e }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x004e }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ all -> 0x004e }
            int r0 = r1.getDimensionPixelSize(r0)     // Catch:{ all -> 0x004e }
            sStatusBarHeight = r0     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            int r0 = sStatusBarHeight
            if (r0 > 0) goto L_0x0070
            float r0 = sVirtualDensity
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0067
            r0 = 25
            int r5 = com.microtech.aidexx.utils.statusbar.DisplayHelper.dp2px(r5, r0)
            sStatusBarHeight = r5
            goto L_0x0070
        L_0x0067:
            r5 = 1103626240(0x41c80000, float:25.0)
            float r0 = r0 * r5
            r5 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r5
            int r5 = (int) r0
            sStatusBarHeight = r5
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.statusbar.StatusBarHelper.initStatusBarHeight(android.content.Context):void");
    }

    public static void setVirtualDensity(float f) {
        sVirtualDensity = f;
    }

    public static void setVirtualDensityDpi(float f) {
        sVirtualDensityDpi = f;
    }
}

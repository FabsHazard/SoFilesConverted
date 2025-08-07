package com.microtech.aidexx.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.microtech.aidexx.AidexxApp;

public class DensityUtils {
    private DensityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, AidexxApp.instance.getResources().getDisplayMetrics());
    }

    public static float dp2pix(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float sp2px(float f) {
        return TypedValue.applyDimension(2, f, AidexxApp.instance.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static float px2sp(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getWindowHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getWindowWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}

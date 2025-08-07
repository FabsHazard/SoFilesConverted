package com.microtech.aidexx.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetUtil {
    public static boolean isNetAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        activeNetworkInfo.isAvailable();
        return true;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getTypeName();
        }
        return null;
    }

    public static int getAPNType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
            return 2;
        }
        if (subtype == 3 || subtype == 8) {
            return 3;
        }
        if (subtype == 5 && !telephonyManager.isNetworkRoaming()) {
            return 3;
        }
        if (subtype == 1 || subtype == 2 || subtype != 4) {
            return 4;
        }
        telephonyManager.isNetworkRoaming();
        return 4;
    }
}

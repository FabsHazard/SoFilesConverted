package com.microtech.aidexx.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class DeviceInfoHelper {
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000b A[Catch:{ all -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getMacByJavaAPI() {
        /*
            r0 = 0
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ all -> 0x006e }
        L_0x0005:
            boolean r2 = r1.hasMoreElements()     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x0072
            java.lang.Object r2 = r1.nextElement()     // Catch:{ all -> 0x006e }
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "wlan0"
            java.lang.String r4 = r2.getName()     // Catch:{ all -> 0x006e }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x006e }
            if (r3 != 0) goto L_0x0029
            java.lang.String r3 = "eth0"
            java.lang.String r4 = r2.getName()     // Catch:{ all -> 0x006e }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x006e }
            if (r3 == 0) goto L_0x0005
        L_0x0029:
            byte[] r1 = r2.getHardwareAddress()     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x006d
            int r2 = r1.length     // Catch:{ all -> 0x006e }
            if (r2 != 0) goto L_0x0033
            goto L_0x006d
        L_0x0033:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r2.<init>()     // Catch:{ all -> 0x006e }
            int r3 = r1.length     // Catch:{ all -> 0x006e }
            r4 = 0
        L_0x003a:
            if (r4 >= r3) goto L_0x0052
            byte r5 = r1[r4]     // Catch:{ all -> 0x006e }
            java.lang.String r6 = "%02X:"
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)     // Catch:{ all -> 0x006e }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x006e }
            java.lang.String r5 = java.lang.String.format(r6, r5)     // Catch:{ all -> 0x006e }
            r2.append(r5)     // Catch:{ all -> 0x006e }
            int r4 = r4 + 1
            goto L_0x003a
        L_0x0052:
            int r1 = r2.length()     // Catch:{ all -> 0x006e }
            if (r1 <= 0) goto L_0x0061
            int r1 = r2.length()     // Catch:{ all -> 0x006e }
            int r1 = r1 + -1
            r2.deleteCharAt(r1)     // Catch:{ all -> 0x006e }
        L_0x0061:
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x006e }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x006e }
            java.lang.String r0 = r1.toLowerCase(r2)     // Catch:{ all -> 0x006e }
        L_0x006d:
            return r0
        L_0x006e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0072:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.DeviceInfoHelper.getMacByJavaAPI():java.lang.String");
    }

    public static String osVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String deviceName() {
        return Build.BRAND + Build.MODEL;
    }

    public static String installVersion(Context context) {
        return getPackageInfo(context).versionName;
    }

    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo == null ? new PackageInfo() : packageInfo;
    }

    public static String installVersionCode(Context context) {
        return String.valueOf(getPackageInfo(context).versionCode);
    }

    public static String SerialNumber() {
        return Build.SERIAL;
    }
}

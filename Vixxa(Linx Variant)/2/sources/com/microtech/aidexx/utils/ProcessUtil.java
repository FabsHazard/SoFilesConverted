package com.microtech.aidexx.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import java.util.List;

public class ProcessUtil {
    public static boolean isMainProcess(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageName().equals(getCurrentProcessName(context));
    }

    public static String getCurrentProcessName(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                str = next.processName;
            }
        }
        return str;
    }

    public static void setWebDataDirectorySuffix(Application application) {
        if (application != null) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String processName = getProcessName(application);
                    if (!application.getPackageName().equals(processName)) {
                        WebView.setDataDirectorySuffix(processName);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!(context == null || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null || runningAppProcesses.isEmpty())) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == Process.myPid()) {
                    return next.processName;
                }
            }
        }
        return null;
    }

    public static boolean isInstalled(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}

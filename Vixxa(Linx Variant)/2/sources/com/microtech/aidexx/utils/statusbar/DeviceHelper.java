package com.microtech.aidexx.utils.statusbar;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceHelper {
    /* access modifiers changed from: private */
    public static final String BRAND = Build.BRAND.toLowerCase();
    private static final String CPU_FILE_PATH_0 = "/sys/devices/system/cpu/";
    private static final String CPU_FILE_PATH_1 = "/sys/devices/system/cpu/possible";
    private static final String CPU_FILE_PATH_2 = "/sys/devices/system/cpu/present";
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };
    private static final String FLYME = "flyme";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    /* access modifiers changed from: private */
    public static final String[] MEIZUBOARD = {"m9", "M9", "mx", "MX"};
    private static final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";
    private static final String TAG = "QMUIDeviceHelper";
    private static final String ZTEC2016 = "zte c2016";
    private static final String ZUKZ1 = "zuk z1";
    private static final OnceReadValue<Void, Boolean> isEssentialPhoneValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            return Boolean.valueOf(DeviceHelper.BRAND.contains("essential"));
        }
    };
    private static final OnceReadValue<Void, Boolean> isFlymeValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            DeviceHelper.checkReadInfo();
            return Boolean.valueOf(!TextUtils.isEmpty(DeviceHelper.sFlymeVersionName) && DeviceHelper.sFlymeVersionName.contains(DeviceHelper.FLYME));
        }
    };
    private static final OnceReadValue<Void, Boolean> isHuaweiValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            return Boolean.valueOf(DeviceHelper.BRAND.contains("huawei") || DeviceHelper.BRAND.contains("honor"));
        }
    };
    private static boolean isInfoReaded = false;
    private static final OnceReadValue<Void, Boolean> isMeizuValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            DeviceHelper.checkReadInfo();
            return Boolean.valueOf(DeviceHelper.isPhone(DeviceHelper.MEIZUBOARD) || DeviceHelper.isFlyme());
        }
    };
    private static final OnceReadValue<Context, Boolean> isMiuiFullDisplayValue = new OnceReadValue<Context, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Context context) {
            boolean z = false;
            if (DeviceHelper.isMIUI() && Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    };
    private static final OnceReadValue<Void, Boolean> isOppoValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            return Boolean.valueOf(DeviceHelper.BRAND.contains("oppo"));
        }
    };
    private static final OnceReadValue<Void, Boolean> isVivoValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            return Boolean.valueOf(DeviceHelper.BRAND.contains("vivo") || DeviceHelper.BRAND.contains("bbk"));
        }
    };
    private static final OnceReadValue<Void, Boolean> isXiaomiValue = new OnceReadValue<Void, Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean read(Void voidR) {
            return Boolean.valueOf(Build.MANUFACTURER.equalsIgnoreCase("xiaomi"));
        }
    };
    private static double sBatteryCapacity = -1.0d;
    private static int sCpuCoreCount = -1;
    private static long sExtraStorageSize = -1;
    /* access modifiers changed from: private */
    public static String sFlymeVersionName;
    private static long sInnerStorageSize = -1;
    private static boolean sIsTabletChecked = false;
    private static boolean sIsTabletValue = false;
    private static String sMiuiVersionName;
    private static long sTotalMemory = -1;

    /* access modifiers changed from: private */
    public static void checkReadInfo() {
        FileInputStream fileInputStream;
        Exception e;
        if (!isInfoReaded) {
            isInfoReaded = true;
            Properties properties = new Properties();
            if (Build.VERSION.SDK_INT < 26) {
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                    try {
                        properties.load(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    Exception exc = e3;
                    fileInputStream = null;
                    e = exc;
                    try {
                        Log.printErrStackTrace(TAG, e, "read file error", new Object[0]);
                        LangHelper.close(fileInputStream);
                        Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                        sMiuiVersionName = getLowerCaseName(properties, declaredMethod, KEY_MIUI_VERSION_NAME);
                        sFlymeVersionName = getLowerCaseName(properties, declaredMethod, KEY_FLYME_VERSION_NAME);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        LangHelper.close(fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    LangHelper.close(fileInputStream2);
                    throw th;
                }
                LangHelper.close(fileInputStream);
            }
            try {
                Method declaredMethod2 = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                sMiuiVersionName = getLowerCaseName(properties, declaredMethod2, KEY_MIUI_VERSION_NAME);
                sFlymeVersionName = getLowerCaseName(properties, declaredMethod2, KEY_FLYME_VERSION_NAME);
            } catch (Exception e4) {
                Log.printErrStackTrace(TAG, e4, "read SystemProperties error", new Object[0]);
            }
        }
    }

    private static boolean _isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isTablet(Context context) {
        if (sIsTabletChecked) {
            return sIsTabletValue;
        }
        boolean _isTablet = _isTablet(context);
        sIsTabletValue = _isTablet;
        sIsTabletChecked = true;
        return _isTablet;
    }

    public static boolean isFlyme() {
        return isFlymeValue.get(null).booleanValue();
    }

    public static boolean isMIUI() {
        checkReadInfo();
        return !TextUtils.isEmpty(sMiuiVersionName);
    }

    public static boolean isMIUIV5() {
        checkReadInfo();
        return "v5".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV6() {
        checkReadInfo();
        return "v6".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV7() {
        checkReadInfo();
        return "v7".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV8() {
        checkReadInfo();
        return "v8".equals(sMiuiVersionName);
    }

    public static boolean isMIUIV9() {
        checkReadInfo();
        return "v9".equals(sMiuiVersionName);
    }

    public static boolean isFlymeLowerThan(int i) {
        return isFlymeLowerThan(i, 0, 0);
    }

    public static boolean isFlymeLowerThan(int i, int i2, int i3) {
        boolean z;
        checkReadInfo();
        String str = sFlymeVersionName;
        if (str != null && !str.equals("")) {
            try {
                Matcher matcher = Pattern.compile("(\\d+\\.){2}\\d").matcher(sFlymeVersionName);
                if (matcher.find()) {
                    String group = matcher.group();
                    if (group.length() > 0) {
                        String[] split = group.split("\\.");
                        z = split.length >= 1 && Integer.parseInt(split[0]) < i;
                        try {
                            if (split.length >= 2 && i2 > 0 && Integer.parseInt(split[1]) < i) {
                                z = true;
                            }
                            if (split.length >= 3 && i3 > 0 && Integer.parseInt(split[2]) < i) {
                                z = true;
                            }
                        } catch (Throwable unused) {
                        }
                        if (isMeizu() || !z) {
                            return false;
                        }
                        return true;
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        z = false;
        if (isMeizu()) {
        }
        return false;
    }

    public static boolean isMeizu() {
        return isMeizuValue.get(null).booleanValue();
    }

    public static boolean isXiaomi() {
        return isXiaomiValue.get(null).booleanValue();
    }

    public static boolean isVivo() {
        return isVivoValue.get(null).booleanValue();
    }

    public static boolean isOppo() {
        return isOppoValue.get(null).booleanValue();
    }

    public static boolean isHuawei() {
        return isHuaweiValue.get(null).booleanValue();
    }

    public static boolean isEssentialPhone() {
        return isEssentialPhoneValue.get(null).booleanValue();
    }

    public static boolean isMiuiFullDisplay(Context context) {
        return isMiuiFullDisplayValue.get(context).booleanValue();
    }

    /* access modifiers changed from: private */
    public static boolean isPhone(String[] strArr) {
        checkReadInfo();
        String str = Build.BOARD;
        if (str == null) {
            return false;
        }
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static long getTotalMemory(Context context) {
        long j = sTotalMemory;
        if (j != -1) {
            return j;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            sTotalMemory = memoryInfo.totalMem;
        }
        return sTotalMemory;
    }

    public static long getInnerStorageSize() {
        long j = sInnerStorageSize;
        if (j != -1) {
            return j;
        }
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory == null) {
            return 0;
        }
        long totalSpace = dataDirectory.getTotalSpace();
        sInnerStorageSize = totalSpace;
        return totalSpace;
    }

    public static boolean hasExtraStorage() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long getExtraStorageSize() {
        long j = sExtraStorageSize;
        if (j != -1) {
            return j;
        }
        if (!hasExtraStorage()) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        sExtraStorageSize = blockSizeLong;
        return blockSizeLong;
    }

    public static long getTotalStorageSize() {
        return getInnerStorageSize() + getExtraStorageSize();
    }

    public static int getCpuCoreCount() {
        int i;
        int i2 = sCpuCoreCount;
        if (i2 != -1) {
            return i2;
        }
        try {
            i = getCoresFromFile(CPU_FILE_PATH_1);
            if (i == 0) {
                i = getCoresFromFile(CPU_FILE_PATH_2);
            }
            if (i == 0) {
                i = getCoresFromCPUFiles(CPU_FILE_PATH_0);
            }
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            i = 1;
        }
        sCpuCoreCount = i;
        return i;
    }

    private static int getCoresFromCPUFiles(String str) {
        File[] listFiles = new File(str).listFiles(CPU_FILTER);
        if (listFiles == null) {
            return 0;
        }
        return listFiles.length;
    }

    private static int getCoresFromFile(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, StandardCharsets.UTF_8));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                if (readLine != null) {
                    if (readLine.matches("0-[\\d]+$")) {
                        int parseInt = Integer.parseInt(readLine.substring(2)) + 1;
                        LangHelper.close(fileInputStream2);
                        return parseInt;
                    }
                }
                LangHelper.close(fileInputStream2);
                return 0;
            } catch (IOException unused) {
                fileInputStream = fileInputStream2;
                LangHelper.close(fileInputStream);
                return 0;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                LangHelper.close(fileInputStream);
                throw th;
            }
        } catch (IOException unused2) {
            LangHelper.close(fileInputStream);
            return 0;
        } catch (Throwable th2) {
            th = th2;
            LangHelper.close(fileInputStream);
            throw th;
        }
    }

    public static boolean isFloatWindowOpAllowed(Context context) {
        return checkOp(context, 24);
    }

    public static double getBatteryCapacity(Context context) {
        double d = sBatteryCapacity;
        double d2 = -1.0d;
        if (d != -1.0d) {
            return d;
        }
        try {
            Class<?> cls = Class.forName(POWER_PROFILE_CLASS);
            d2 = ((Double) cls.getMethod("getBatteryCapacity", new Class[0]).invoke(cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}), new Object[0])).doubleValue();
        } catch (Exception unused) {
        }
        sBatteryCapacity = d2;
        return d2;
    }

    private static boolean checkOp(Context context, int i) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            if (((Integer) appOpsManager.getClass().getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String getLowerCaseName(Properties properties, Method method, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (String) method.invoke((Object) null, new Object[]{str});
            } catch (Exception unused) {
            }
        }
        return property != null ? property.toLowerCase() : property;
    }
}

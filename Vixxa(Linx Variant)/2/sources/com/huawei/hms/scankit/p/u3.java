package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.os.EnvironmentCompat;
import com.huawei.hms.feature.dynamic.f.e;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.util.LinkedHashMap;

/* compiled from: HaLog */
abstract class u3 {
    static String d = "FORMAT_UNKNOWN";
    static String e = "OTHER";
    static SparseArray<String> f = new a();
    static SparseArray<String> g = new b();
    Context a;
    LinkedHashMap<String, String> b = new LinkedHashMap<>();
    volatile long c;

    /* compiled from: HaLog */
    class a extends SparseArray<String> {
        a() {
            put(HmsScanBase.AZTEC_SCAN_TYPE, "AZTEC");
            put(HmsScanBase.CODABAR_SCAN_TYPE, "CODABAR");
            put(HmsScanBase.CODE39_SCAN_TYPE, "CODE39");
            put(HmsScanBase.CODE93_SCAN_TYPE, "CODE93");
            put(HmsScanBase.CODE128_SCAN_TYPE, "CODE128");
            put(HmsScanBase.DATAMATRIX_SCAN_TYPE, "DATAMATRIX");
            put(HmsScanBase.EAN8_SCAN_TYPE, "EAN8");
            put(HmsScanBase.EAN13_SCAN_TYPE, "EAN13");
            put(HmsScanBase.ITF14_SCAN_TYPE, "ITF14");
            put(HmsScanBase.PDF417_SCAN_TYPE, "PDF417");
            put(HmsScanBase.QRCODE_SCAN_TYPE, "QRCODE");
            put(HmsScanBase.UPCCODE_A_SCAN_TYPE, "UPCCODE_A");
            put(HmsScanBase.UPCCODE_E_SCAN_TYPE, "UPCCODE_E");
            put(HmsScanBase.FORMAT_UNKNOWN, u3.d);
        }
    }

    /* compiled from: HaLog */
    class b extends SparseArray<String> {
        b() {
            put(HmsScan.ARTICLE_NUMBER_FORM, "ARTICLE_NUMBER");
            put(HmsScan.EMAIL_CONTENT_FORM, "EMAIL_CONTENT");
            put(HmsScan.TEL_PHONE_NUMBER_FORM, "TEL_PHONE_NUMBER");
            put(HmsScan.PURE_TEXT_FORM, "PURE_TEXT");
            put(HmsScan.SMS_FORM, "SMS");
            put(HmsScan.URL_FORM, "URL");
            put(HmsScan.WIFI_CONNECT_INFO_FORM, "WIFI_CONNECT_INFO");
            put(HmsScan.EVENT_INFO_FORM, "EVENT_INFO");
            put(HmsScan.CONTACT_DETAIL_FORM, "CONTACT_DETAIL");
            put(HmsScan.DRIVER_INFO_FORM, "DRIVER_INFO");
            put(HmsScan.LOCATION_COORDINATE_FORM, "LOCATION_COORDINATE");
            put(HmsScan.ISBN_NUMBER_FORM, "ISBN_NUMBER");
            put(-1, u3.e);
        }
    }

    u3(Bundle bundle, Context context) {
        this.a = context;
        b(bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069 A[Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006c A[Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9 A[SYNTHETIC, Splitter:B:23:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af A[Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.os.Bundle r7) {
        /*
            r6 = this;
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "initValue Exception"
            java.lang.String r2 = "HaLog"
            android.content.Context r3 = r6.a     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r4 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r5 = "package"
            r4.put(r5, r3)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r4 = "appid"
            if (r7 == 0) goto L_0x0027
            boolean r5 = r7.containsKey(r4)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            if (r5 == 0) goto L_0x0027
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r5 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r7 = r7.getString(r4)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            r5.put(r4, r7)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            goto L_0x002c
        L_0x0027:
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            r7.put(r4, r3)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
        L_0x002c:
            android.content.Context r7 = r6.a     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r3 = r7.getApplicationInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r4 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r5 = "appName"
            java.lang.CharSequence r7 = r3.loadLabel(r7)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r7 = r7.toString()     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            r4.put(r5, r7)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r4 = "version"
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r3 = r6.a((android.os.Bundle) r3)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            r7.put(r4, r3)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r7 = r6.d()     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r3 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r4 = "hmscoreVersion"
            r3.put(r4, r7)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r3 = r6.b     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            java.lang.String r4 = "isHMSCore"
            boolean r7 = r0.equals(r7)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            if (r7 == 0) goto L_0x006c
            java.lang.String r7 = "0"
            goto L_0x006e
        L_0x006c:
            java.lang.String r7 = "1"
        L_0x006e:
            r3.put(r4, r7)     // Catch:{ NameNotFoundException -> 0x0076, Exception -> 0x0072 }
            goto L_0x007b
        L_0x0072:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
            goto L_0x007b
        L_0x0076:
            java.lang.String r7 = "PackageManager.NameNotFoundException"
            com.huawei.hms.scankit.p.o4.b(r2, r7)
        L_0x007b:
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = "sdkName"
            java.lang.String r4 = "scankit"
            r7.put(r3, r4)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = "algopt"
            java.lang.String r4 = r6.b()     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r3, r4)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = "isFullSdk"
            java.lang.String r4 = "FULLSDK"
            r7.put(r3, r4)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = "cpAppVersion"
            java.lang.String r4 = r6.c()     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r3, r4)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            boolean r7 = com.huawei.hms.scankit.p.b4.a     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = "apkVersion"
            if (r7 != 0) goto L_0x00af
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r3, r0)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            goto L_0x00b6
        L_0x00af:
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = com.huawei.hms.scankit.p.b4.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r3, r0)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
        L_0x00b6:
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "service"
            java.lang.String r3 = "com.huawei.hms.scankit"
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "operator"
            android.content.Context r3 = r6.a     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.b(r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "networkType"
            android.content.Context r3 = r6.a     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.a(r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "countryCode"
            android.content.Context r3 = r6.a     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r4 = 0
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.a(r3, r4)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "deviceType"
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.c()     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "emuiVersion"
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.d()     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "androidVersion"
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.a()     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r7 = r6.b     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            java.lang.String r0 = "deviceCategory"
            java.lang.String r3 = com.huawei.hms.scankit.p.b4.b()     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            r7.put(r0, r3)     // Catch:{ RuntimeException -> 0x0118, Exception -> 0x0114 }
            goto L_0x011d
        L_0x0114:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
            goto L_0x011d
        L_0x0118:
            java.lang.String r7 = "initValue RuntimeException"
            com.huawei.hms.scankit.p.o4.b(r2, r7)
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.u3.b(android.os.Bundle):void");
    }

    private String c() {
        try {
            return this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private String d() {
        try {
            return this.a.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    private boolean e() {
        try {
            String property = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN);
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getApplicationContext().getSystemService("phone");
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            String simCountryIso = telephonyManager.getSimCountryIso();
            if (!e.e.equalsIgnoreCase(property) || !e.e.equalsIgnoreCase(networkCountryIso) || !e.e.equalsIgnoreCase(simCountryIso)) {
                return false;
            }
            return true;
        } catch (Exception | RuntimeException unused) {
            return false;
        }
    }

    private boolean f() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (w7.b(this.a)) {
            Log.i("HaLog", "allowLog: forbidLog ");
            return false;
        }
        Log.i("HaLog", "allowLog: allowLog ");
        try {
            if (f() || e() || Settings.Secure.getInt(this.a.getContentResolver(), "hw_app_analytics_state", 0) == 1) {
                return true;
            }
            return false;
        } catch (Exception | RuntimeException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        String str;
        o4.c("HaLog", "update HiAnalyticsLogUtils.apk_mode " + b4.a + " HiAnalyticsLogUtils.apkVersion " + b4.b);
        if (b4.a && (str = b4.b) != null) {
            this.b.put("apkVersion", str);
        }
    }

    static String a(int i) {
        return f.get(i, d);
    }

    private String a(Bundle bundle) {
        String[] strArr = {"huawei_module_scankit_sdk_version", "com.huawei.hms.client.service.name:scan", "com.huawei.hms.client.service.name:scanplus", "com.huawei.hms.client.service.name:scankit"};
        if (bundle == null) {
            return "scankit:1.0.2.300";
        }
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (bundle.getString(str) != null) {
                return bundle.getString(str);
            }
        }
        return "scankit:1.0.2.300";
    }

    private String b() {
        if (Build.VERSION.SDK_INT == 24) {
            return "full-noso";
        }
        return "full";
    }

    static String b(int i) {
        return g.get(i, e);
    }
}

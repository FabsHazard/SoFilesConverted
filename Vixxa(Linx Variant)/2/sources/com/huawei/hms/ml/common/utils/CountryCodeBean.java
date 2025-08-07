package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

public class CountryCodeBean {
    private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    private static final int COUNTRYCODE_SIZE = 2;
    private static final String HONOR_VENDORCOUNTRY_SYSTEMPROP = "msc.sys.country";
    private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    private static final String LOCALE_INFO = "LOCALE_INFO";
    private static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
    private static final String SIM_COUNTRY = "SIM_COUNTRY";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String TAG = "CountryCodeBean";
    private static final String UNKNOWN = "UNKNOWN";
    private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    private static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    private String countryCode = "UNKNOWN";
    private String countrySource = "UNKNOWN";

    public CountryCodeBean(Context context, boolean z) {
        init(context, z);
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    private void init(Context context, boolean z) {
        if (context != null) {
            try {
                getVendorCountryCode();
                if (isCodeValidate()) {
                    SmartLog.d(TAG, "getCountryCode get country code from {%s}", "VENDOR_COUNTRY");
                    return;
                }
                getSimCountryCode(context, z);
                if (isCodeValidate()) {
                    SmartLog.d(TAG, "getCountryCode get country code from {%s}", "SIM_COUNTRY");
                    return;
                }
                getLocaleCountryCode();
                if (isCodeValidate()) {
                    SmartLog.d(TAG, "getCountryCode get country code from {%s}", "LOCALE_INFO");
                }
            } catch (Exception unused) {
                SmartLog.w(TAG, "get CountryCode error");
            }
        } else {
            throw new NullPointerException("context must be not null.Please provide app's Context");
        }
    }

    private boolean isCodeValidate() {
        return !"UNKNOWN".equals(this.countryCode);
    }

    private void checkCodeLenth() {
        String str = this.countryCode;
        if (str == null || str.length() != 2) {
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private void getVendorCountryCode() {
        this.countrySource = "VENDOR_COUNTRY";
        if ("HONOR".equals(Build.BRAND)) {
            this.countryCode = getProperty("get", HONOR_VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        } else {
            this.countryCode = getProperty("get", VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        }
        String str = TAG;
        SmartLog.e(str, "getVendorCountry=" + this.countryCode);
        if (SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) || SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(this.countryCode)) {
            SmartLog.e(str, "getVendorCountry equals eu or la ,not reliable");
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
            return;
        }
        checkCodeLenth();
    }

    private void getSimCountryCode(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
        if (telephonyManager != null) {
            if (!z || telephonyManager.getPhoneType() == 2) {
                this.countryCode = telephonyManager.getSimCountryIso();
                this.countrySource = "SIM_COUNTRY";
                SmartLog.e(TAG, "getSimCountryCode by not enableNetwork, countryCode=" + this.countryCode);
            } else {
                this.countryCode = telephonyManager.getNetworkCountryIso();
                this.countrySource = "NETWORK_COUNTRY";
                SmartLog.e(TAG, "getSimCountryCode by enableNetwork, countryCode=" + this.countryCode);
            }
        }
        checkCodeLenth();
    }

    private void getLocaleCountryCode() {
        this.countryCode = getProperty("get", LOCALE_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        this.countrySource = "LOCALE_INFO";
        String str = TAG;
        SmartLog.e(str, "getLocaleCountryCode=" + this.countryCode);
        if (!SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(this.countryCode)) {
            SmartLog.e(str, "getLocaleCountryCode from system language is not reliable.");
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private static String getProperty(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            SmartLog.w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            String str5 = (String) cls.getMethod(str, new Class[]{String.class, String.class}).invoke(cls, new Object[]{str2, str4});
            String str6 = str5;
            return str5;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            SmartLog.e(TAG, "getProperty catch exception: ", (Throwable) e2);
            return str4;
        }
    }
}

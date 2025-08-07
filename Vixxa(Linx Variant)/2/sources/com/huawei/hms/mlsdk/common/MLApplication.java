package com.huawei.hms.mlsdk.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hms.feature.dynamic.f.e;
import com.huawei.hms.ml.common.utils.ActivityMgr;
import com.huawei.hms.ml.common.utils.CountryCodeBean;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MLApplication {
    public static final String DEFAULT_APP_NAME = "_DEFAULT_";
    static final Map<String, MLApplication> INSTANCES = new HashMap();
    private static final Object LOCK = new Object();
    private static final String LOG_TAG = "MLApplication";
    public static final int REGION_DR_CHINA = 1002;
    public static final int REGION_DR_GERMAN = 1006;
    public static final int REGION_DR_RUSSIA = 1005;
    public static final int REGION_DR_SINGAPORE = 1007;
    public static final int REGION_DR_UNKNOWN = 1001;
    private static final Map<Integer, String> REGION_MAP;
    private String accessToken;
    private String apiKey;
    private final Context appContext;
    private final String appName;
    private final MLApplicationSetting appSetting;
    private boolean isAcessTokenSetByCP = false;
    private boolean setByCP = false;
    private int userRegion = 1001;

    public <T> T get(Class<T> cls) {
        return null;
    }

    static {
        HashMap hashMap = new HashMap();
        REGION_MAP = hashMap;
        hashMap.put(1002, e.e);
        hashMap.put(1007, "SG");
        hashMap.put(1006, "DE");
        hashMap.put(1005, "RU");
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public String getAppName() {
        return this.appName;
    }

    public MLApplicationSetting getAppSetting() {
        return this.appSetting;
    }

    public String toString() {
        return "appName=" + this.appName + ", appSetting=" + this.appSetting;
    }

    public static List<MLApplication> getAppList(Context context) {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList(INSTANCES.values());
        }
        return arrayList;
    }

    public static MLApplication getInstance() {
        MLApplication mLApplication;
        synchronized (LOCK) {
            mLApplication = INSTANCES.get(DEFAULT_APP_NAME);
            if (mLApplication == null) {
                mLApplication = initialize(AGConnectInstance.getInstance().getContext());
                if (mLApplication == null) {
                    throw new IllegalStateException("Please call MLApplication.initialize(Context) to initialize application first.");
                }
            }
        }
        return mLApplication;
    }

    public static MLApplication getInstance(String str) {
        MLApplication mLApplication;
        String str2;
        synchronized (LOCK) {
            mLApplication = INSTANCES.get(str);
            if (mLApplication == null) {
                List<String> allAppNames = getAllAppNames();
                if (allAppNames.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", allAppNames);
                }
                throw new IllegalStateException(String.format(Locale.ENGLISH, "application doesn't exist. current available application names:%s", new Object[]{str2}));
            }
        }
        return mLApplication;
    }

    public static MLApplication initialize(Context context) {
        MLApplication initialize;
        SmartLog.i(LOG_TAG, "initialize one para");
        synchronized (LOCK) {
            makeSureAGConnectInstanceInitialed(context);
            if (INSTANCES.containsKey(DEFAULT_APP_NAME)) {
                getInstance();
            }
            new MLApplicationSetting.Factory().create();
            initialize = initialize(context, MLApplicationSetting.fromResource(context));
        }
        return initialize;
    }

    public static MLApplication initialize(Context context, MLApplicationSetting mLApplicationSetting) {
        SmartLog.i(LOG_TAG, "initialize two para");
        return initialize(context, mLApplicationSetting, DEFAULT_APP_NAME);
    }

    public static MLApplication initialize(Context context, MLApplicationSetting mLApplicationSetting, String str) {
        Context context2;
        MLApplication mLApplication;
        if (context.getApplicationContext() == null) {
            context2 = context;
        } else {
            context2 = context.getApplicationContext();
        }
        synchronized (LOCK) {
            makeSureAGConnectInstanceInitialed(context2);
            if (mLApplicationSetting == null) {
                new MLApplicationSetting.Factory().create();
                mLApplicationSetting = MLApplicationSetting.fromResource(context);
            }
            mLApplication = new MLApplication(context2, str, mLApplicationSetting);
            INSTANCES.put(str, mLApplication);
            if (ActivityMgr.INST.getCurrentActivity() == null && (context2 instanceof Application)) {
                ActivityMgr.INST.init((Application) context2);
            }
        }
        return mLApplication;
    }

    protected MLApplication(Context context, String str, MLApplicationSetting mLApplicationSetting) {
        this.appContext = context;
        this.appName = str;
        this.appSetting = mLApplicationSetting;
    }

    private static void makeSureAGConnectInstanceInitialed(Context context) {
        if (AGConnectInstance.getInstance() == null) {
            AGConnectInstance.initialize(context);
        }
    }

    public boolean isDefault() {
        return DEFAULT_APP_NAME.equals(getAppName());
    }

    public String getUniqueKey() {
        return getUniqueKey(getAppName(), getAppSetting());
    }

    public static String getUniqueKey(String str, MLApplicationSetting mLApplicationSetting) {
        String str2 = null;
        String encodeToString = str != null ? Base64.encodeToString(str.getBytes(Charset.defaultCharset()), 11) : null;
        if (!(mLApplicationSetting == null || mLApplicationSetting.getAppId() == null)) {
            str2 = Base64.encodeToString(mLApplicationSetting.getAppId().getBytes(Charset.defaultCharset()), 11);
        }
        return encodeToString + "+" + str2;
    }

    private static List<String> getAllAppNames() {
        ArrayList arrayList = new ArrayList();
        synchronized (LOCK) {
            for (MLApplication appName2 : INSTANCES.values()) {
                arrayList.add(appName2.getAppName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (getAppSetting() != null) {
            bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, getAppSetting().getAppId());
            bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.APP_NAME, readManifest(getAppContext()));
            bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, getAppSetting().getPackageName());
            bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.ML_SDK_VERSION, getAppSetting().getMLSdkVersion());
            bundle.putBoolean(MLApplicationSetting.BundleKeyConstants.AppInfo.OPEN_HA, getAppSetting().getAcceptHa().booleanValue());
            bundle.putString(MLApplicationSetting.BundleKeyConstants.AppInfo.COUNTRY_CODE, new CountryCodeBean(this.appContext, false).getCountryCode());
        } else {
            SmartLog.w(LOG_TAG, "APP setting is null.");
        }
        return bundle;
    }

    private static String readManifest(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            SmartLog.e(LOG_TAG, "PackageManager NameNotFoundException");
            return "";
        } catch (Resources.NotFoundException unused2) {
            SmartLog.e(LOG_TAG, "Resources NotFoundException");
            return "";
        } catch (Exception unused3) {
            SmartLog.e(LOG_TAG, "readManifest Exception");
            return "";
        }
    }

    private static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public void setAccessToken(String str) {
        SmartLog.i(LOG_TAG, "set a tkn");
        synchronized (LOCK) {
            this.accessToken = str;
            this.isAcessTokenSetByCP = true;
        }
    }

    public String getAuthorizationToken() {
        synchronized (LOCK) {
            if (!this.isAcessTokenSetByCP) {
                String apiKey2 = getApiKey();
                return apiKey2;
            } else if (!TextUtils.isEmpty(this.accessToken)) {
                String str = this.accessToken;
                return str;
            } else {
                throw new NullPointerException("access token is empty");
            }
        }
    }

    public void setApiKey(String str) {
        SmartLog.i(LOG_TAG, "set a ky");
        synchronized (LOCK) {
            this.apiKey = str;
            this.setByCP = true;
            if (!isDefault()) {
                getInstance().setApiKey(str);
                getInstance().setApiKeyByCP(true);
            }
        }
    }

    public String getApiKey() {
        String str;
        String str2;
        SmartLog.i(LOG_TAG, "get ky flag: " + this.setByCP);
        synchronized (LOCK) {
            if (!getInstance().isSetByCP() || (str = this.apiKey) == null || str.length() == 0) {
                throw new NullPointerException("please set your app apiKey");
            }
            str2 = this.apiKey;
        }
        return str2;
    }

    public boolean isSetByCP() {
        return this.setByCP;
    }

    public void setApiKeyByCP(boolean z) {
        this.setByCP = z;
    }

    public String getCountryCode() {
        Map<Integer, String> map = REGION_MAP;
        if (map.containsKey(Integer.valueOf(this.userRegion))) {
            return map.get(Integer.valueOf(this.userRegion));
        }
        return null;
    }

    public void setUserRegion(int i) throws IllegalArgumentException {
        SmartLog.i(LOG_TAG, "set userRegion: " + i);
        synchronized (LOCK) {
            if (REGION_MAP.containsKey(Integer.valueOf(i))) {
                this.userRegion = i;
            } else {
                throw new IllegalArgumentException("region is not available");
            }
        }
    }
}

package com.huawei.hms.framework.common.hianalytics;

import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class HianalyticsHelper {
    private static final String DEAULT_HA_SERVICE_TAG = "_default_config_tag";
    private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;
    private static volatile HianalyticsHelper instance;
    private HiAnalyticsInstance defaultInstance = null;
    private HiAnalyticsInstance hInstance = null;
    private String haTag = HWID_HA_SERVICE_TAG;
    private boolean hasHMSBI;
    private boolean hasHianalytics;
    private boolean isEnablePrivacyPolicy = false;
    private ReportCallBack reportCallback;
    private ExecutorService reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");

    public interface ReportCallBack {
        void onReport(int i, String str, LinkedHashMap<String, String> linkedHashMap);
    }

    private HianalyticsHelper() {
        try {
            HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG);
            this.hasHianalytics = true;
        } catch (Throwable unused) {
            Logger.i(TAG, "Hianalytics sdk not found");
            this.hasHianalytics = false;
        }
        if (!this.hasHianalytics) {
            tryHMSBIInit(ContextHolder.getAppContext());
        }
        Logger.v(TAG, "this time the ha %s, mini %s", Boolean.valueOf(this.hasHianalytics), Boolean.valueOf(this.hasHMSBI));
    }

    private void tryHMSBIInit(Context context) {
        if (context == null) {
            Logger.i(TAG, "the appContext hasn't init");
            return;
        }
        try {
            HMSBIInitializer.getInstance(context).initBI();
            this.hasHMSBI = true;
        } catch (NoClassDefFoundError unused) {
            Logger.w(TAG, "maybe you need add base sdk!");
        } catch (Throwable unused2) {
            Logger.w(TAG, "the hms base has other error!");
        }
    }

    public void setHaTag(String str) {
        this.haTag = str;
    }

    public void enablePrivacyPolicy(boolean z) {
        this.isEnablePrivacyPolicy = z;
    }

    public static HianalyticsHelper getInstance() {
        if (instance == null) {
            synchronized (HianalyticsHelper.class) {
                if (instance == null) {
                    instance = new HianalyticsHelper();
                }
            }
        }
        return instance;
    }

    @Deprecated
    public boolean isEnableReport(Context context) {
        if (this.reportCallback != null || this.hasHMSBI) {
            return true;
        }
        if (!this.hasHianalytics) {
            return false;
        }
        return isEnableReportNoSeed(context);
    }

    public boolean isEnableReportNoSeed(Context context) {
        if (this.reportCallback != null || this.hasHMSBI) {
            return true;
        }
        if (!this.hasHianalytics) {
            Logger.i(TAG, "Hianalytics sdk need to be initialized");
            return false;
        } else if (context == null) {
            Logger.i(TAG, "HianalyticsHelper context can't be null");
            return false;
        } else if (this.isEnablePrivacyPolicy) {
            return isHianalyticsOk();
        } else {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), USER_EXPERIENCE_INVOLVED, -1) == 1) {
                    return isHianalyticsOk();
                }
            } catch (IllegalStateException unused) {
                Logger.w(TAG, "the setting has illegalStateException");
            } catch (Throwable unused2) {
                Logger.w(TAG, "the setting has other error");
            }
            Logger.i(TAG, "user experience involved needs to be opened");
            return false;
        }
    }

    private boolean isHianalyticsOk() {
        if (HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG)) {
            if (this.defaultInstance == null) {
                this.defaultInstance = HiAnalyticsManager.getInstanceByTag(DEAULT_HA_SERVICE_TAG);
            }
            if (this.defaultInstance != null) {
                return true;
            }
            return false;
        }
        if (this.hInstance == null) {
            this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
        }
        if (this.hInstance != null) {
            return true;
        }
        return false;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        onEvent(linkedHashMap, str, 1);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str, int i) {
        HiAnalyticsInstance hiAnalyticsInstance;
        if (linkedHashMap != null) {
            Logger.v(TAG, "data = %s", linkedHashMap);
            ReportCallBack reportCallBack = this.reportCallback;
            if (reportCallBack != null) {
                reportCallBack.onReport(i, str, linkedHashMap);
                return;
            }
            if (this.hasHMSBI) {
                onNewEvent(ContextHolder.getAppContext(), str, linkedHashMap, i);
            } else if (i == 0) {
                Logger.v(TAG, "the base sdk isn't exsit, and reportType is %s", Integer.valueOf(i));
                return;
            }
            if (this.hasHianalytics) {
                if (!HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG) || (hiAnalyticsInstance = this.defaultInstance) == null) {
                    HiAnalyticsInstance hiAnalyticsInstance2 = this.hInstance;
                    if (hiAnalyticsInstance2 != null) {
                        hiAnalyticsInstance2.onEvent(1, str, linkedHashMap);
                    } else {
                        Logger.e(TAG, "the ha has error,has init but is null!");
                    }
                } else {
                    hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
                }
            }
        }
    }

    private void onNewEvent(Context context, String str, Map map, int i) {
        if (context != null && map != null) {
            Logger.v(TAG, "data = %s", map);
            try {
                HiAnalyticsUtils.getInstance().onNewEvent(context, str, map, i);
            } catch (NoSuchMethodError unused) {
                Logger.w(TAG, "may be you need upgrade stats sdk");
            } catch (Throwable unused2) {
                Logger.i(TAG, "the stats has other error,pls check it");
            }
        }
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        onEvent(linkedHashMap, HianalyticsBaseData.EVENT_ID);
    }

    public ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public void executeReportHa(HianalyticsBaseData hianalyticsBaseData, String str) {
        getReportExecutor().execute(new HianalyticsRunnable(hianalyticsBaseData, str));
    }

    public void reportException(final Throwable th, final String str) {
        if (getInstance().isEnableReportNoSeed(ContextHolder.getAppContext())) {
            final String name = Thread.currentThread().getName();
            try {
                this.reportExecutor.submit(new Runnable() {
                    public void run() {
                        CrashHianalyticsData crashHianalyticsData = new CrashHianalyticsData();
                        crashHianalyticsData.put(HianalyticsBaseData.SDK_VERSION, "6.0.7.300");
                        crashHianalyticsData.put(CrashHianalyticsData.CRASH_TYPE, "exception");
                        crashHianalyticsData.put(CrashHianalyticsData.THREAD_NAME, name);
                        crashHianalyticsData.put(CrashHianalyticsData.EXCEPTION_NAME, th.getClass().getName());
                        crashHianalyticsData.put(CrashHianalyticsData.MESSAGE, StringUtils.anonymizeMessage(th.getMessage()));
                        crashHianalyticsData.put(CrashHianalyticsData.STACK_TRACE, StringUtils.getTraceInfo(th));
                        HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), str);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.i(TAG, "reportException error RejectedExecutionException");
            } catch (Exception unused2) {
                Logger.i(TAG, "reportException error!", th);
            }
        }
    }

    public void reportData(Context context, LinkedHashMap<String, String> linkedHashMap, String str, int i) {
        if (isEnableReportNoSeed(context)) {
            onEvent(linkedHashMap, str, i);
        }
    }

    public void setReportCallback(ReportCallBack reportCallBack) {
        this.reportCallback = reportCallBack;
    }

    private static class HianalyticsRunnable implements Runnable {
        private final HianalyticsBaseData data;
        private final String event;

        HianalyticsRunnable(HianalyticsBaseData hianalyticsBaseData, String str) {
            this.data = hianalyticsBaseData;
            this.event = str;
        }

        public void run() {
            HianalyticsHelper.getInstance().onEvent(this.data.get(), this.event);
        }
    }
}

package com.huawei.hms.mlsdk.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.ml.common.utils.SmartLog;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;
import net.lingala.zip4j.util.InternalZipConstants;

public class AgConnectInfo {
    private String apiKey;
    private String appMLKitGrsPolicy;
    private String applicationId;
    private String certFingerprint;
    private List<String> haCollectorUrls;
    private List<String> mlServiceUrls;
    private String packageName;
    private String projectId;
    private String region;

    private static final class AgConnectKey {
        public static final String ANALYTICS_COLLECTOR_URL = "service/analytics/collector_url";
        public static final String API_KEY = "client/api_key";
        public static final String APPLICATION_ID = "client/app_id";
        public static final String APP_MLKIT_GRS_POLICY = "processing_location_policy/mlkit";
        public static final String ML_SERVICE_URL = "service/ml/mlservice_url";
        public static final String PACKAGE_NAME = "client/package_name";
        public static final String PROJECT_ID = "client/project_id";
        public static final String REGION = "region";

        private AgConnectKey() {
        }
    }

    public AgConnectInfo(Context context) {
        this.mlServiceUrls = new ArrayList();
        this.haCollectorUrls = new ArrayList();
        context = context == null ? AGConnectInstance.getInstance().getContext() : context;
        if (context != null) {
            AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "context: " + context);
            this.region = fromContext.getString(AgConnectKey.REGION);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "region: " + this.region);
            String string = fromContext.getString(AgConnectKey.PACKAGE_NAME);
            this.packageName = string;
            if (string == null) {
                this.packageName = context.getPackageName();
            } else {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "packageName: " + this.packageName);
            }
            String string2 = fromContext.getString(AgConnectKey.APPLICATION_ID);
            this.applicationId = string2;
            if (string2 == null) {
                this.applicationId = this.packageName;
            } else {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "packageName: " + this.packageName);
            }
            String string3 = fromContext.getString(AgConnectKey.API_KEY);
            this.apiKey = string3;
            if (string3 != null) {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "apiKey: apiKey is secret");
            }
            String rawSignature = getRawSignature(context);
            this.certFingerprint = rawSignature;
            if (rawSignature != null) {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "certFingerprint: certFingerprint is secret");
            }
            String string4 = fromContext.getString(AgConnectKey.ML_SERVICE_URL);
            if (string4 != null) {
                for (String trim : string4.split(",")) {
                    String lowerCase = trim.trim().toLowerCase(Locale.ENGLISH);
                    if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                        lowerCase = "https://" + lowerCase;
                    }
                    if (!lowerCase.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                        lowerCase = lowerCase + InternalZipConstants.ZIP_FILE_SEPARATOR;
                    }
                    this.mlServiceUrls.add(lowerCase);
                }
            }
            String string5 = fromContext.getString(AgConnectKey.ANALYTICS_COLLECTOR_URL);
            if (string5 != null) {
                for (String trim2 : string5.split(",")) {
                    String lowerCase2 = trim2.trim().toLowerCase(Locale.ENGLISH);
                    if (!lowerCase2.startsWith("http://") && !lowerCase2.startsWith("https://")) {
                        lowerCase2 = "https://" + lowerCase2;
                    }
                    this.haCollectorUrls.add(lowerCase2);
                }
            }
            this.projectId = fromContext.getString(AgConnectKey.PROJECT_ID);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "project_id: " + this.projectId);
            this.appMLKitGrsPolicy = fromContext.getString(AgConnectKey.APP_MLKIT_GRS_POLICY);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "processing_location_policy/mlkit: " + this.appMLKitGrsPolicy);
            return;
        }
        throw new IllegalStateException("Context not found.");
    }

    public AgConnectInfo() {
        this((Context) null);
    }

    private String getRawSignature(Context context) {
        Signature signature;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                SmartLog.i("AgConnectInfo", "signature is null ");
                signature = null;
            } else {
                signature = signatureArr[0];
                SmartLog.i("AgConnectInfo", "signature is not null ");
            }
            if (signature != null) {
                return getSignatureString(signature, "SHA256");
            }
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final String getSignatureString(Signature signature, String str) {
        try {
            byte[] byteArray = signature.toByteArray();
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.reset();
            instance.update(byteArray);
            byte[] digest = instance.digest();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & UByte.MAX_VALUE).length() == 1) {
                    stringBuffer.append("0").append(Integer.toHexString(digest[i] & UByte.MAX_VALUE));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & UByte.MAX_VALUE));
                }
                if (i != digest.length - 1) {
                    stringBuffer.append(":");
                }
            }
            return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getRegion() {
        return this.region;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getCertFingerprint() {
        return this.certFingerprint;
    }

    public List<String> getMLServiceUrls() {
        return this.mlServiceUrls;
    }

    public List<String> getHaCollectorUrls() {
        return this.haCollectorUrls;
    }

    public String getAppMLKitGrsPolicy() {
        return this.appMLKitGrsPolicy;
    }

    public String getProjectId() {
        return this.projectId;
    }
}

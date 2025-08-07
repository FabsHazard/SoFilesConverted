package com.microtech.aidexx.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/common/Constants;", "", "()V", "AGP_URL", "", "getAGP_URL", "()Ljava/lang/String;", "AGP_URL_DOMAIN", "getAGP_URL_DOMAIN", "URL_HELPER_CENTER", "getURL_HELPER_CENTER", "getPrivacyPolicyUrl", "getUserServicePolicyUrl", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Constants.kt */
public final class Constants {
    private static final String AGP_URL = ("http://35.179.178.176:9098" + "/user/pdf");
    private static final String AGP_URL_DOMAIN = "http://35.179.178.176:9098";
    public static final Constants INSTANCE = new Constants();
    private static final String URL_HELPER_CENTER = "http://35.179.178.176:4433/h5/";

    private Constants() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getUserServicePolicyUrl() {
        /*
            r2 = this;
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r1 = 3
            com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo r0 = r0.getPolicyInfo(r1)
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getUrl()
            if (r0 != 0) goto L_0x0011
        L_0x000f:
            java.lang.String r0 = "http://35.179.178.176:19999/vcs/grx/policy/aidex-xgrxen_3_1.0.0_term_of_use.html"
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.Constants.getUserServicePolicyUrl():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getUrl();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPrivacyPolicyUrl() {
        /*
            r2 = this;
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r1 = 2
            com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo r0 = r0.getPolicyInfo(r1)
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getUrl()
            if (r0 != 0) goto L_0x0011
        L_0x000f:
            java.lang.String r0 = "http://35.179.178.176:19999/vcs/grx/policy/aidex-xgrxen_2_1.0.0_privacy-policy.html"
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.Constants.getPrivacyPolicyUrl():java.lang.String");
    }

    public final String getURL_HELPER_CENTER() {
        return URL_HELPER_CENTER;
    }

    public final String getAGP_URL_DOMAIN() {
        return AGP_URL_DOMAIN;
    }

    public final String getAGP_URL() {
        return AGP_URL;
    }
}

package com.microtech.aidexx.common.net;

import com.microtech.aidexx.common.net.ApiService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ApiService$Companion$$ExternalSyntheticLambda0 implements HostnameVerifier {
    public final boolean verify(String str, SSLSession sSLSession) {
        return ApiService.Companion.getOkHttpClient$lambda$5(str, sSLSession);
    }
}

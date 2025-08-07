package com.microtech.aidexx.common.net.interceptors;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.common.net.RSAUtil;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/common/net/interceptors/HeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HeaderInterceptor.kt */
public final class HeaderInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        Boolean bool = BuildConfig.isPre;
        Intrinsics.checkNotNullExpressionValue(bool, "isPre");
        if (bool.booleanValue()) {
            newBuilder.header(WiseOpenHianalyticsData.UNION_VERSION, "test");
        }
        String token = MmkvManager.INSTANCE.getToken();
        if (token.length() > 0) {
            newBuilder.header("x-token", token);
        }
        Boolean bool2 = BuildConfig.enableEncrypt;
        Intrinsics.checkNotNullExpressionValue(bool2, "enableEncrypt");
        newBuilder.header("encryption", bool2.booleanValue() ? "enabled" : "disable");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WiseOpenHianalyticsData.UNION_VERSION, "1.7.1");
        jSONObject.put("timestamp", System.currentTimeMillis());
        jSONObject.put("userId", UserInfoManager.Companion.instance().userId());
        String encryptByPublicKey = RSAUtil.encryptByPublicKey(jSONObject.toString(), RSAUtil.getPublicKey(RSAUtil.PUBLIC_KEY));
        Intrinsics.checkNotNull(encryptByPublicKey);
        newBuilder.header("app-version-check", encryptByPublicKey);
        newBuilder.header("app-info", "com.microtech.aidexx.grx1.mmoll,1.7.1");
        newBuilder.header("Accept-Language", LanguageResourceManager.INSTANCE.getCurLanguageTag());
        return chain.proceed(newBuilder.build());
    }
}

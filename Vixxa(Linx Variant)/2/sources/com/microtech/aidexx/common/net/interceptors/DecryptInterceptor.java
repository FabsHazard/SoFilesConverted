package com.microtech.aidexx.common.net.interceptors;

import com.microtech.aidexx.common.net.RSAUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/common/net/interceptors/DecryptInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DecryptInterceptor.kt */
public final class DecryptInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        if (proceed.body() == null) {
            return proceed;
        }
        ResponseBody body = proceed.body();
        Intrinsics.checkNotNull(body);
        if (body.contentType() == null) {
            return proceed;
        }
        ResponseBody body2 = proceed.body();
        Intrinsics.checkNotNull(body2);
        MediaType contentType = body2.contentType();
        ResponseBody body3 = proceed.body();
        Intrinsics.checkNotNull(body3);
        String decryptByPrivateKey = RSAUtil.decryptByPrivateKey(body3.string(), RSAUtil.getPrivateKey(RSAUtil.PRIVATE_KEY));
        Intrinsics.checkNotNullExpressionValue(decryptByPrivateKey, "decryptByPrivateKey(...)");
        return proceed.newBuilder().body(ResponseBody.Companion.create(decryptByPrivateKey, contentType)).build();
    }
}

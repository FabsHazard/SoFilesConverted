package com.microtech.aidexx.common.net.interceptors;

import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/common/net/interceptors/TokenInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TokenInterceptor.kt */
public final class TokenInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String header$default;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        CharSequence header$default2 = Response.header$default(proceed, "x-token", (String) null, 2, (Object) null);
        if (!(header$default2 == null || header$default2.length() == 0 || (header$default = Response.header$default(proceed, "x-token", (String) null, 2, (Object) null)) == null)) {
            MmkvManager.INSTANCE.saveToken(header$default);
        }
        return proceed;
    }
}

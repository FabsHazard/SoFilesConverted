package com.microtech.aidexx.common.net;

import com.microtech.aidexx.common.net.ApiService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ApiService.kt */
final class ApiService$Companion$okClient$2 extends Lambda implements Function0<OkHttpClient> {
    public static final ApiService$Companion$okClient$2 INSTANCE = new ApiService$Companion$okClient$2();

    ApiService$Companion$okClient$2() {
        super(0);
    }

    public final OkHttpClient invoke() {
        return ApiService.Companion.$$INSTANCE.getOkHttpClient();
    }
}

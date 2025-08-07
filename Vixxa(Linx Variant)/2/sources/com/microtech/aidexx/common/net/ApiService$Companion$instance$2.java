package com.microtech.aidexx.common.net;

import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.convert.GsonConverterFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import retrofit2.CallAdapter;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiService;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ApiService.kt */
final class ApiService$Companion$instance$2 extends Lambda implements Function0<ApiService> {
    public static final ApiService$Companion$instance$2 INSTANCE = new ApiService$Companion$instance$2();

    ApiService$Companion$instance$2() {
        super(0);
    }

    public final ApiService invoke() {
        return (ApiService) RetrofitBaseKt.buildRetrofit$default("http://35.179.178.176:8899", GsonConverterFactory.Companion.create(ApiService.Companion.$$INSTANCE.createGson(), new Function1<String, Throwable>(ApiService.Companion.$$INSTANCE) {
            public final Throwable invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "p0");
                return ((ApiService.Companion) this.receiver).checkBizCodeIsSuccess(str);
            }
        }, new Function1<Object, Unit>(ApiService.Companion.$$INSTANCE) {
            public final void invoke(Object obj) {
                ((ApiService.Companion) this.receiver).afterGsonConvert(obj);
            }
        }), ApiService.Companion.$$INSTANCE.getOkClient(), (CallAdapter.Factory) null, 8, (Object) null).create(ApiService.class);
    }
}

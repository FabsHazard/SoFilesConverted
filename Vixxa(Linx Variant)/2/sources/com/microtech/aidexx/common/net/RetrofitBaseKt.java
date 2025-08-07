package com.microtech.aidexx.common.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TAG_API_SERVICE", "", "buildRetrofit", "Lretrofit2/Retrofit;", "baseUrl", "convertFactory", "Lretrofit2/Converter$Factory;", "client", "Lokhttp3/OkHttpClient;", "apiCallAdapterFactory", "Lretrofit2/CallAdapter$Factory;", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: RetrofitBase.kt */
public final class RetrofitBaseKt {
    public static final String TAG_API_SERVICE = "RETROFIT_BASE";

    public static /* synthetic */ Retrofit buildRetrofit$default(String str, Converter.Factory factory, OkHttpClient okHttpClient, CallAdapter.Factory factory2, int i, Object obj) {
        if ((i & 4) != 0) {
            okHttpClient = null;
        }
        if ((i & 8) != 0) {
            factory2 = new ApiCallAdapterFactory();
        }
        return buildRetrofit(str, factory, okHttpClient, factory2);
    }

    public static final Retrofit buildRetrofit(String str, Converter.Factory factory, OkHttpClient okHttpClient, CallAdapter.Factory factory2) {
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(factory, "convertFactory");
        Intrinsics.checkNotNullParameter(factory2, "apiCallAdapterFactory");
        Retrofit.Builder addCallAdapterFactory = new Retrofit.Builder().addCallAdapterFactory(factory2);
        if (okHttpClient != null) {
            addCallAdapterFactory.client(okHttpClient);
        }
        Retrofit build = addCallAdapterFactory.addConverterFactory(factory).baseUrl(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}

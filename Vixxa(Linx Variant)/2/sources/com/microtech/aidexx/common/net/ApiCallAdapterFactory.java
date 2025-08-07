package com.microtech.aidexx.common.net;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RetrofitBase.kt */
public final class ApiCallAdapterFactory extends CallAdapter.Factory {
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "returnType");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual((Object) CallAdapter.Factory.getRawType(type), (Object) Call.class)) {
            throw new IllegalStateException((type + " must be retrofit2.Call.").toString());
        } else if (type instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Intrinsics.areEqual((Object) CallAdapter.Factory.getRawType(parameterUpperBound), (Object) ApiResult.class)) {
                throw new IllegalStateException((parameterUpperBound + " must be ApiResult.").toString());
            } else if (parameterUpperBound instanceof ParameterizedType) {
                Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                Intrinsics.checkNotNull(parameterUpperBound2);
                return new ApiCallAdapter<>(parameterUpperBound2);
            } else {
                throw new IllegalStateException((parameterUpperBound + " must be parameterized. Raw types are not supported").toString());
            }
        } else {
            throw new IllegalStateException((type + " must be parameterized. Raw types are not supported").toString());
        }
    }
}

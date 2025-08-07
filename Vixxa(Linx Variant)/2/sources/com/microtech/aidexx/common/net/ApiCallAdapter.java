package com.microtech.aidexx.common.net;

import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00030\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiCallAdapter;", "T", "Lretrofit2/CallAdapter;", "Lretrofit2/Call;", "Lcom/microtech/aidexx/common/net/ApiResult;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "adapt", "call", "responseType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RetrofitBase.kt */
public final class ApiCallAdapter<T> implements CallAdapter<T, Call<ApiResult<? extends T>>> {
    private final Type type;

    public ApiCallAdapter(Type type2) {
        Intrinsics.checkNotNullParameter(type2, TransmitterActivityKt.OPERATION_TYPE);
        this.type = type2;
    }

    public Type responseType() {
        return this.type;
    }

    public Call<ApiResult<T>> adapt(Call<T> call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        return new ApiCall<>(call);
    }
}

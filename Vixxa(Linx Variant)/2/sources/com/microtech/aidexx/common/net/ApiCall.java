package com.microtech.aidexx.common.net;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000bH\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiCall;", "T", "Lretrofit2/Call;", "Lcom/microtech/aidexx/common/net/ApiResult;", "delegate", "(Lretrofit2/Call;)V", "cancel", "", "clone", "enqueue", "callback", "Lretrofit2/Callback;", "execute", "Lretrofit2/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RetrofitBase.kt */
public final class ApiCall<T> implements Call<ApiResult<? extends T>> {
    private final Call<T> delegate;

    public ApiCall(Call<T> call) {
        Intrinsics.checkNotNullParameter(call, "delegate");
        this.delegate = call;
    }

    public void enqueue(Callback<ApiResult<T>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.delegate.enqueue(new ApiCall$enqueue$1(callback, this));
    }

    public Call<ApiResult<T>> clone() {
        Call<T> clone = this.delegate.clone();
        Intrinsics.checkNotNullExpressionValue(clone, "clone(...)");
        return new ApiCall<>(clone);
    }

    public Response<ApiResult<T>> execute() {
        throw new UnsupportedOperationException("Synchronous call is not supported");
    }

    public boolean isExecuted() {
        return this.delegate.isExecuted();
    }

    public void cancel() {
        this.delegate.cancel();
    }

    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    public Request request() {
        Request request = this.delegate.request();
        Intrinsics.checkNotNullExpressionValue(request, "request(...)");
        return request;
    }

    public Timeout timeout() {
        Timeout timeout = this.delegate.timeout();
        Intrinsics.checkNotNullExpressionValue(timeout, "timeout(...)");
        return timeout;
    }
}

package com.microtech.aidexx.common.net.entity;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "T", "", "code", "", "msg", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class BaseResponse<T> {
    private final int code;
    private T data;
    private final String msg;

    public static /* synthetic */ BaseResponse copy$default(BaseResponse baseResponse, int i, String str, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = baseResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = baseResponse.msg;
        }
        if ((i2 & 4) != 0) {
            t = baseResponse.data;
        }
        return baseResponse.copy(i, str, t);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final T component3() {
        return this.data;
    }

    public final BaseResponse<T> copy(int i, String str, T t) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        return new BaseResponse<>(i, str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseResponse)) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        return this.code == baseResponse.code && Intrinsics.areEqual((Object) this.msg, (Object) baseResponse.msg) && Intrinsics.areEqual((Object) this.data, (Object) baseResponse.data);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
        T t = this.data;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "BaseResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
    }

    public BaseResponse(int i, String str, T t) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        this.code = i;
        this.msg = str;
        this.data = t;
    }

    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseResponse(int i, String str, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, obj);
    }

    public final String getMsg() {
        return this.msg;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }
}

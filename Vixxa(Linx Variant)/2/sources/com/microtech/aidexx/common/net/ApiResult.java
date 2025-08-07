package com.microtech.aidexx.common.net;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0004*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiResult;", "R", "", "()V", "Companion", "Failure", "Success", "Lcom/microtech/aidexx/common/net/ApiResult$Failure;", "Lcom/microtech/aidexx/common/net/ApiResult$Success;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RetrofitBase.kt */
public abstract class ApiResult<R> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERR_CODE_DATA_NULL = "0";
    public static final String ERR_CODE_HTTP_CODE = "1";
    public static final String ERR_CODE_REQUEST_FAILURE = "2";
    public static final String ERR_CODE_SYSTEM = "3";

    public /* synthetic */ ApiResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApiResult() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiResult$Success;", "R", "Lcom/microtech/aidexx/common/net/ApiResult;", "result", "(Ljava/lang/Object;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/microtech/aidexx/common/net/ApiResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RetrofitBase.kt */
    public static final class Success<R> extends ApiResult<R> {
        private final R result;

        public static /* synthetic */ Success copy$default(Success success, R r, int i, Object obj) {
            if ((i & 1) != 0) {
                r = success.result;
            }
            return success.copy(r);
        }

        public final R component1() {
            return this.result;
        }

        public final Success<R> copy(R r) {
            return new Success<>(r);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.result, (Object) ((Success) obj).result);
        }

        public int hashCode() {
            R r = this.result;
            if (r == null) {
                return 0;
            }
            return r.hashCode();
        }

        public Success(R r) {
            super((DefaultConstructorMarker) null);
            this.result = r;
        }

        public final R getResult() {
            return this.result;
        }

        public String toString() {
            return "ApiResult.Success(result=" + this.result + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiResult$Failure;", "Lcom/microtech/aidexx/common/net/ApiResult;", "", "code", "", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMsg", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "isBizFail", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RetrofitBase.kt */
    public static final class Failure extends ApiResult {
        private final String code;
        private final String msg;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.code;
            }
            if ((i & 2) != 0) {
                str2 = failure.msg;
            }
            return failure.copy(str, str2);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final Failure copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            return new Failure(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) obj;
            return Intrinsics.areEqual((Object) this.code, (Object) failure.code) && Intrinsics.areEqual((Object) this.msg, (Object) failure.msg);
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.msg.hashCode();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
            this.code = str;
            this.msg = str2;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public String toString() {
            return "ApiResult.Failure(code=" + this.code + ", msg=" + this.msg + ')';
        }

        public final boolean isBizFail() {
            return !Intrinsics.areEqual((Object) this.code, (Object) "2");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiResult$Companion;", "", "()V", "ERR_CODE_DATA_NULL", "", "ERR_CODE_HTTP_CODE", "ERR_CODE_REQUEST_FAILURE", "ERR_CODE_SYSTEM", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RetrofitBase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.microtech.aidexx.common.net.repository;

import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\tJ*\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J+\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00070\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/ApiRepository;", "", "()V", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "checkAppUpdate", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOtaResource", "", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "downloadFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "", "downloadUrl", "downloadPath", "fileName", "saveOtaResultBatch", "", "otaInfoList", "Lcom/microtech/aidexx/common/net/entity/OtaInfo$OtaUploadInfo;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NetResult", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ApiRepository.kt */
public final class ApiRepository {
    public static final ApiRepository INSTANCE = new ApiRepository();
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    private ApiRepository() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "R", "", "()V", "Failure", "Loading", "Success", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Failure;", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Loading;", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Success;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ApiRepository.kt */
    public static abstract class NetResult<R> {
        public /* synthetic */ NetResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Loading;", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "", "value", "", "(I)V", "getValue", "()I", "setValue", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: ApiRepository.kt */
        public static final class Loading extends NetResult {
            private int value;

            public static /* synthetic */ Loading copy$default(Loading loading, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = loading.value;
                }
                return loading.copy(i);
            }

            public final int component1() {
                return this.value;
            }

            public final Loading copy(int i) {
                return new Loading(i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && this.value == ((Loading) obj).value;
            }

            public int hashCode() {
                return Integer.hashCode(this.value);
            }

            public String toString() {
                return "Loading(value=" + this.value + ')';
            }

            public Loading(int i) {
                super((DefaultConstructorMarker) null);
                this.value = i;
            }

            public final int getValue() {
                return this.value;
            }

            public final void setValue(int i) {
                this.value = i;
            }
        }

        private NetResult() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Success;", "R", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "result", "(Ljava/lang/Object;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: ApiRepository.kt */
        public static final class Success<R> extends NetResult<R> {
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

            public String toString() {
                return "Success(result=" + this.result + ')';
            }

            public Success(R r) {
                super((DefaultConstructorMarker) null);
                this.result = r;
            }

            public final R getResult() {
                return this.result;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult$Failure;", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "", "code", "", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMsg", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: ApiRepository.kt */
        public static final class Failure extends NetResult {
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

            public String toString() {
                return "Failure(code=" + this.code + ", msg=" + this.msg + ')';
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
        }
    }

    public final Object checkAppUpdate(Continuation<? super ApiResult<BaseResponse<UpgradeInfo>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ApiRepository$checkAppUpdate$2((Continuation<? super ApiRepository$checkAppUpdate$2>) null), continuation);
    }

    public final Flow<NetResult<String>> downloadFile(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "downloadUrl");
        Intrinsics.checkNotNullParameter(str2, "downloadPath");
        Intrinsics.checkNotNullParameter(str3, "fileName");
        return FlowKt.flowOn(FlowKt.flow(new ApiRepository$downloadFile$1(str, str2, str3, (Continuation<? super ApiRepository$downloadFile$1>) null)), Dispatchers.getIO());
    }

    public final Object saveOtaResultBatch(List<OtaInfo.OtaUploadInfo> list, Continuation<? super ApiResult<BaseResponse>> continuation) {
        return BuildersKt.withContext(dispatcher, new ApiRepository$saveOtaResultBatch$2(list, (Continuation<? super ApiRepository$saveOtaResultBatch$2>) null), continuation);
    }

    public final Object checkOtaResource(Continuation<? super ApiResult<BaseResponse<List<OtaResourceEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ApiRepository$checkOtaResource$2((Continuation<? super ApiRepository$checkOtaResource$2>) null), continuation);
    }
}

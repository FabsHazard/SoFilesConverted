package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.common.net.entity.ReqSaveOtaInfoRecords;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.ApiRepository$saveOtaResultBatch$2", f = "ApiRepository.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ApiRepository.kt */
final class ApiRepository$saveOtaResultBatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse>>, Object> {
    final /* synthetic */ List<OtaInfo.OtaUploadInfo> $otaInfoList;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ApiRepository$saveOtaResultBatch$2(List<OtaInfo.OtaUploadInfo> list, Continuation<? super ApiRepository$saveOtaResultBatch$2> continuation) {
        super(2, continuation);
        this.$otaInfoList = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ApiRepository$saveOtaResultBatch$2(this.$otaInfoList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<BaseResponse>> continuation) {
        return ((ApiRepository$saveOtaResultBatch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ApiService.Companion.getInstance().saveOtaResultBatch(new ReqSaveOtaInfoRecords(this.$otaInfoList), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

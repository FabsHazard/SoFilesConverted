package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.ReqModifyShareUserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.ShareAndFollowRepository$updateAuthorizationInfo$2", f = "ShareAndFollowRepository.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareAndFollowRepository.kt */
final class ShareAndFollowRepository$updateAuthorizationInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse<String>>>, Object> {
    final /* synthetic */ Integer $emergePushState;
    final /* synthetic */ Integer $hideState;
    final /* synthetic */ Integer $normalPushState;
    final /* synthetic */ String $providerAlias;
    final /* synthetic */ String $readerAlias;
    final /* synthetic */ String $userAuthorizationId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAndFollowRepository$updateAuthorizationInfo$2(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Continuation<? super ShareAndFollowRepository$updateAuthorizationInfo$2> continuation) {
        super(2, continuation);
        this.$providerAlias = str;
        this.$readerAlias = str2;
        this.$hideState = num;
        this.$emergePushState = num2;
        this.$normalPushState = num3;
        this.$userAuthorizationId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareAndFollowRepository$updateAuthorizationInfo$2(this.$providerAlias, this.$readerAlias, this.$hideState, this.$emergePushState, this.$normalPushState, this.$userAuthorizationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return ((ShareAndFollowRepository$updateAuthorizationInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ApiService.Companion.getInstance().updateAuthorizationInfo(new ReqModifyShareUserInfo(this.$providerAlias, this.$readerAlias, this.$hideState, this.$emergePushState, this.$normalPushState, this.$userAuthorizationId), this);
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

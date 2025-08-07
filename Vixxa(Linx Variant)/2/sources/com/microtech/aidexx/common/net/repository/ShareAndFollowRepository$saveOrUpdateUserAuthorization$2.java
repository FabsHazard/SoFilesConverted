package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.ReqShareUserInfo;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.ShareAndFollowRepository$saveOrUpdateUserAuthorization$2", f = "ShareAndFollowRepository.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareAndFollowRepository.kt */
final class ShareAndFollowRepository$saveOrUpdateUserAuthorization$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse<ShareUserInfo>>>, Object> {
    final /* synthetic */ String $userAlise;
    final /* synthetic */ String $userName;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAndFollowRepository$saveOrUpdateUserAuthorization$2(String str, String str2, Continuation<? super ShareAndFollowRepository$saveOrUpdateUserAuthorization$2> continuation) {
        super(2, continuation);
        this.$userAlise = str;
        this.$userName = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareAndFollowRepository$saveOrUpdateUserAuthorization$2(this.$userAlise, this.$userName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<BaseResponse<ShareUserInfo>>> continuation) {
        return ((ShareAndFollowRepository$saveOrUpdateUserAuthorization$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ApiService.Companion.getInstance().saveOrUpdateUserAuthorization(new ReqShareUserInfo(this.$userAlise, (Integer) null, (Integer) null, this.$userName, (Integer) null, 22, (DefaultConstructorMarker) null), this);
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

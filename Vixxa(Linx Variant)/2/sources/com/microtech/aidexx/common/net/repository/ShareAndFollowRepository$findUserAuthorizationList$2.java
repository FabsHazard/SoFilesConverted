package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.ReqGetShareOrFollowUsers;
import com.microtech.aidexx.common.net.entity.RequestEntityKt;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
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

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001*\u00020\u0005H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.ShareAndFollowRepository$findUserAuthorizationList$2", f = "ShareAndFollowRepository.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareAndFollowRepository.kt */
final class ShareAndFollowRepository$findUserAuthorizationList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse<List<? extends ShareUserInfo>>>>, Object> {
    final /* synthetic */ boolean $isShare;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareAndFollowRepository$findUserAuthorizationList$2(boolean z, Continuation<? super ShareAndFollowRepository$findUserAuthorizationList$2> continuation) {
        super(2, continuation);
        this.$isShare = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareAndFollowRepository$findUserAuthorizationList$2(this.$isShare, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<BaseResponse<List<ShareUserInfo>>>> continuation) {
        return ((ShareAndFollowRepository$findUserAuthorizationList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ReqGetShareOrFollowUsers reqGetShareOrFollowUsers = new ReqGetShareOrFollowUsers(this.$isShare ? "0" : "1");
            this.label = 1;
            obj = ApiService.Companion.getInstance().findUserAuthorizationList(RequestEntityKt.toQueryMap(reqGetShareOrFollowUsers), this);
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

package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00062\u0006\u0010\u000e\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\u00070\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J/\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u00062\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017Ja\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/common/net/repository/ShareAndFollowRepository;", "", "()V", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "deleteByIdsShareFollow", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "ids", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAuthorizationInfoById", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "userAuthorizationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findUserAuthorizationList", "isShare", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpdateUserAuthorization", "userName", "userAlise", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAuthorizationInfo", "providerAlias", "readerAlias", "hideState", "", "emergePushState", "normalPushState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareAndFollowRepository.kt */
public final class ShareAndFollowRepository {
    public static final ShareAndFollowRepository INSTANCE = new ShareAndFollowRepository();
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    private ShareAndFollowRepository() {
    }

    public static /* synthetic */ Object findUserAuthorizationList$default(ShareAndFollowRepository shareAndFollowRepository, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return shareAndFollowRepository.findUserAuthorizationList(z, continuation);
    }

    public final Object findUserAuthorizationList(boolean z, Continuation<? super ApiResult<BaseResponse<List<ShareUserInfo>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ShareAndFollowRepository$findUserAuthorizationList$2(z, (Continuation<? super ShareAndFollowRepository$findUserAuthorizationList$2>) null), continuation);
    }

    public final Object findAuthorizationInfoById(String str, Continuation<? super ApiResult<BaseResponse<ShareUserInfo>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ShareAndFollowRepository$findAuthorizationInfoById$2(str, (Continuation<? super ShareAndFollowRepository$findAuthorizationInfoById$2>) null), continuation);
    }

    public final Object saveOrUpdateUserAuthorization(String str, String str2, Continuation<? super ApiResult<BaseResponse<ShareUserInfo>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ShareAndFollowRepository$saveOrUpdateUserAuthorization$2(str2, str, (Continuation<? super ShareAndFollowRepository$saveOrUpdateUserAuthorization$2>) null), continuation);
    }

    public final Object deleteByIdsShareFollow(List<String> list, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ShareAndFollowRepository$deleteByIdsShareFollow$2(list, (Continuation<? super ShareAndFollowRepository$deleteByIdsShareFollow$2>) null), continuation);
    }

    public static /* synthetic */ Object updateAuthorizationInfo$default(ShareAndFollowRepository shareAndFollowRepository, String str, String str2, Integer num, Integer num2, Integer num3, String str3, Continuation continuation, int i, Object obj) {
        return shareAndFollowRepository.updateAuthorizationInfo((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, str3, continuation);
    }

    public final Object updateAuthorizationInfo(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new ShareAndFollowRepository$updateAuthorizationInfo$2(str, str2, num, num2, num3, str3, (Continuation<? super ShareAndFollowRepository$updateAuthorizationInfo$2>) null), continuation);
    }
}

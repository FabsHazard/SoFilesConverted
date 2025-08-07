package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.repository.ShareAndFollowRepository;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.utils.LogUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.HomeViewModel$getFollowers$2", f = "HomeViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$getFollowers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$getFollowers$2(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$getFollowers$2> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getFollowers$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((HomeViewModel$getFollowers$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ShareAndFollowRepository.findUserAuthorizationList$default(ShareAndFollowRepository.INSTANCE, false, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            ApiResult.Success success = (ApiResult.Success) apiResult;
            Collection collection = (Collection) ((BaseResponse) success.getResult()).getData();
            if (collection != null && !collection.isEmpty()) {
                this.this$0.getMFollowers().clear();
                List<ShareUserInfo> mFollowers = this.this$0.getMFollowers();
                Object data = ((BaseResponse) success.getResult()).getData();
                Intrinsics.checkNotNull(data);
                mFollowers.addAll((Collection) data);
                Iterable mFollowers2 = this.this$0.getMFollowers();
                if (!(mFollowers2 instanceof Collection) || !((Collection) mFollowers2).isEmpty()) {
                    Iterator it = mFollowers2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!((ShareUserInfo) it.next()).getHide()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        } else if (apiResult instanceof ApiResult.Failure) {
            ApiResult.Failure failure = (ApiResult.Failure) apiResult;
            LogUtil.Companion.d$default(LogUtil.Companion, "getFollowers fail code=" + failure.getCode() + " msg=" + failure.getMsg(), (String) null, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        z = false;
        return Boxing.boxBoolean(z);
    }
}

package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.WelfareInfo;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/entity/WelfareInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.HomeViewModel$getActivities$2", f = "HomeViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$getActivities$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WelfareInfo>, Object> {
    int label;

    HomeViewModel$getActivities$2(Continuation<? super HomeViewModel$getActivities$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getActivities$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WelfareInfo> continuation) {
        return ((HomeViewModel$getActivities$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ApiService.Companion.getInstance().getWelfareActivity(this);
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
            return (WelfareInfo) ((BaseResponse) ((ApiResult.Success) apiResult).getResult()).getData();
        }
        if (apiResult instanceof ApiResult.Failure) {
            ApiResult.Failure failure = (ApiResult.Failure) apiResult;
            LogUtil.Companion.d$default(LogUtil.Companion, "getFollowers fail code=" + failure.getCode() + " msg=" + failure.getMsg(), (String) null, 2, (Object) null);
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}

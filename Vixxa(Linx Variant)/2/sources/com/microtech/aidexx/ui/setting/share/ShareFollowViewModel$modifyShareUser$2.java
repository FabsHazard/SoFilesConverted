package com.microtech.aidexx.ui.setting.share;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.repository.ShareAndFollowRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$modifyShareUser$2", f = "ShareFollowViewModel.kt", i = {0}, l = {66, 70, 71}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: ShareFollowViewModel.kt */
final class ShareFollowViewModel$modifyShareUser$2 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $readerAlias;
    final /* synthetic */ String $userAuthorizationId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowViewModel$modifyShareUser$2(String str, String str2, Continuation<? super ShareFollowViewModel$modifyShareUser$2> continuation) {
        super(2, continuation);
        this.$readerAlias = str;
        this.$userAuthorizationId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareFollowViewModel$modifyShareUser$2 shareFollowViewModel$modifyShareUser$2 = new ShareFollowViewModel$modifyShareUser$2(this.$readerAlias, this.$userAuthorizationId, continuation);
        shareFollowViewModel$modifyShareUser$2.L$0 = obj;
        return shareFollowViewModel$modifyShareUser$2;
    }

    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return ((ShareFollowViewModel$modifyShareUser$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            this.L$0 = flowCollector;
            this.label = 1;
            obj2 = ShareAndFollowRepository.updateAuthorizationInfo$default(ShareAndFollowRepository.INSTANCE, (String) null, this.$readerAlias, (Integer) null, (Integer) null, (Integer) null, this.$userAuthorizationId, this, 29, (Object) null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj2;
        if (apiResult instanceof ApiResult.Success) {
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(Boxing.boxBoolean(true), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (apiResult instanceof ApiResult.Failure) {
            this.L$0 = null;
            this.label = 3;
            if (flowCollector.emit(Boxing.boxBoolean(false), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}

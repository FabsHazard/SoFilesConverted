package com.microtech.aidexx.service.push;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.repository.AccountRepository;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.service.push.GeTuiIntentService$onReceiveClientId$1", f = "GeTuiIntentService.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GeTuiIntentService.kt */
final class GeTuiIntentService$onReceiveClientId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clientid;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GeTuiIntentService$onReceiveClientId$1(String str, Continuation<? super GeTuiIntentService$onReceiveClientId$1> continuation) {
        super(2, continuation);
        this.$clientid = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GeTuiIntentService$onReceiveClientId$1(this.$clientid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GeTuiIntentService$onReceiveClientId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AccountRepository.INSTANCE.getuiLogin(this.$clientid, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((ApiResult) obj) instanceof ApiResult.Success) {
            LogUtil.Companion companion = LogUtil.Companion;
            String access$getTag$cp = GeTuiIntentService.tag;
            Intrinsics.checkNotNullExpressionValue(access$getTag$cp, "access$getTag$cp(...)");
            companion.d("cid 上传成功", access$getTag$cp);
        } else {
            LogUtil.Companion companion2 = LogUtil.Companion;
            String access$getTag$cp2 = GeTuiIntentService.tag;
            Intrinsics.checkNotNullExpressionValue(access$getTag$cp2, "access$getTag$cp(...)");
            companion2.xLogE("cid 上传失败", access$getTag$cp2);
        }
        return Unit.INSTANCE;
    }
}

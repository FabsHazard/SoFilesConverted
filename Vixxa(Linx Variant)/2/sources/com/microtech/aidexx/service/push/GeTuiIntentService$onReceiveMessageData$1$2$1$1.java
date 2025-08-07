package com.microtech.aidexx.service.push;

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
@DebugMetadata(c = "com.microtech.aidexx.service.push.GeTuiIntentService$onReceiveMessageData$1$2$1$1", f = "GeTuiIntentService.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GeTuiIntentService.kt */
final class GeTuiIntentService$onReceiveMessageData$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PushMessage $it;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GeTuiIntentService$onReceiveMessageData$1$2$1$1(PushMessage pushMessage, Continuation<? super GeTuiIntentService$onReceiveMessageData$1$2$1$1> continuation) {
        super(2, continuation);
        this.$it = pushMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GeTuiIntentService$onReceiveMessageData$1$2$1$1(this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GeTuiIntentService$onReceiveMessageData$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$it.applyMsg(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            LogUtil.Companion.d$default(LogUtil.Companion, "推送消息处理", (String) null, 2, (Object) null);
        } else {
            LogUtil.Companion companion = LogUtil.Companion;
            String access$getTag$cp = GeTuiIntentService.tag;
            Intrinsics.checkNotNullExpressionValue(access$getTag$cp, "access$getTag$cp(...)");
            companion.xLogE("推送消息处理失败", access$getTag$cp);
        }
        return Unit.INSTANCE;
    }
}

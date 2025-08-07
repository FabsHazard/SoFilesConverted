package com.microtech.aidexx.ui.setting.share;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$getQrCodeToShareMySelf$2", f = "ShareFollowViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ShareFollowViewModel.kt */
final class ShareFollowViewModel$getQrCodeToShareMySelf$2 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ShareFollowViewModel$getQrCodeToShareMySelf$2(Continuation<? super ShareFollowViewModel$getQrCodeToShareMySelf$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareFollowViewModel$getQrCodeToShareMySelf$2 shareFollowViewModel$getQrCodeToShareMySelf$2 = new ShareFollowViewModel$getQrCodeToShareMySelf$2(continuation);
        shareFollowViewModel$getQrCodeToShareMySelf$2.L$0 = obj;
        return shareFollowViewModel$getQrCodeToShareMySelf$2;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((ShareFollowViewModel$getQrCodeToShareMySelf$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit("", this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

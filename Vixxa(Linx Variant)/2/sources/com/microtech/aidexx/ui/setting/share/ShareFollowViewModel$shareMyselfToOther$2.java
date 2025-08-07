package com.microtech.aidexx.ui.setting.share;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$shareMyselfToOther$2", f = "ShareFollowViewModel.kt", i = {0}, l = {29, 30, 31}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: ShareFollowViewModel.kt */
final class ShareFollowViewModel$shareMyselfToOther$2 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userAlise;
    final /* synthetic */ String $userName;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowViewModel$shareMyselfToOther$2(String str, String str2, Continuation<? super ShareFollowViewModel$shareMyselfToOther$2> continuation) {
        super(2, continuation);
        this.$userName = str;
        this.$userAlise = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareFollowViewModel$shareMyselfToOther$2 shareFollowViewModel$shareMyselfToOther$2 = new ShareFollowViewModel$shareMyselfToOther$2(this.$userName, this.$userAlise, continuation);
        shareFollowViewModel$shareMyselfToOther$2.L$0 = obj;
        return shareFollowViewModel$shareMyselfToOther$2;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((ShareFollowViewModel$shareMyselfToOther$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006f
        L_0x001e:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0042
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.common.net.repository.ShareAndFollowRepository r9 = com.microtech.aidexx.common.net.repository.ShareAndFollowRepository.INSTANCE
            java.lang.String r5 = r8.$userName
            java.lang.String r6 = r8.$userAlise
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = r9.saveOrUpdateUserAuthorization(r5, r6, r7)
            if (r9 != r0) goto L_0x0042
            return r0
        L_0x0042:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
            boolean r4 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r5 = 0
            if (r4 == 0) goto L_0x0057
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.L$0 = r5
            r8.label = r3
            java.lang.Object r9 = r1.emit(r5, r9)
            if (r9 != r0) goto L_0x006f
            return r0
        L_0x0057:
            boolean r3 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r3 == 0) goto L_0x006f
            com.microtech.aidexx.common.net.ApiResult$Failure r9 = (com.microtech.aidexx.common.net.ApiResult.Failure) r9
            java.lang.String r9 = r9.getMsg()
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r8.L$0 = r5
            r8.label = r2
            java.lang.Object r9 = r1.emit(r9, r3)
            if (r9 != r0) goto L_0x006f
            return r0
        L_0x006f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$shareMyselfToOther$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

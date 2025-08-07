package com.microtech.aidexx.ui.setting.share;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$modifyFollowUser$2", f = "ShareFollowViewModel.kt", i = {0}, l = {49, 57, 58}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: ShareFollowViewModel.kt */
final class ShareFollowViewModel$modifyFollowUser$2 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $emergePushState;
    final /* synthetic */ Integer $hideState;
    final /* synthetic */ Integer $normalPushState;
    final /* synthetic */ String $providerAlias;
    final /* synthetic */ String $readerAlias;
    final /* synthetic */ String $userAuthorizationId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowViewModel$modifyFollowUser$2(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Continuation<? super ShareFollowViewModel$modifyFollowUser$2> continuation) {
        super(2, continuation);
        this.$providerAlias = str;
        this.$readerAlias = str2;
        this.$hideState = num;
        this.$emergePushState = num2;
        this.$normalPushState = num3;
        this.$userAuthorizationId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareFollowViewModel$modifyFollowUser$2 shareFollowViewModel$modifyFollowUser$2 = new ShareFollowViewModel$modifyFollowUser$2(this.$providerAlias, this.$readerAlias, this.$hideState, this.$emergePushState, this.$normalPushState, this.$userAuthorizationId, continuation);
        shareFollowViewModel$modifyFollowUser$2.L$0 = obj;
        return shareFollowViewModel$modifyFollowUser$2;
    }

    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return ((ShareFollowViewModel$modifyFollowUser$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x007a
        L_0x001e:
            java.lang.Object r1 = r13.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x004a
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            r1 = r14
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.common.net.repository.ShareAndFollowRepository r5 = com.microtech.aidexx.common.net.repository.ShareAndFollowRepository.INSTANCE
            java.lang.String r6 = r13.$providerAlias
            java.lang.String r7 = r13.$readerAlias
            java.lang.Integer r8 = r13.$hideState
            java.lang.Integer r9 = r13.$emergePushState
            java.lang.Integer r10 = r13.$normalPushState
            java.lang.String r11 = r13.$userAuthorizationId
            r12 = r13
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r13.L$0 = r1
            r13.label = r4
            java.lang.Object r14 = r5.updateAuthorizationInfo(r6, r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L_0x004a
            return r0
        L_0x004a:
            com.microtech.aidexx.common.net.ApiResult r14 = (com.microtech.aidexx.common.net.ApiResult) r14
            boolean r5 = r14 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r6 = 0
            if (r5 == 0) goto L_0x0063
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r2 = r13
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r13.L$0 = r6
            r13.label = r3
            java.lang.Object r14 = r1.emit(r14, r2)
            if (r14 != r0) goto L_0x007a
            return r0
        L_0x0063:
            boolean r14 = r14 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r14 == 0) goto L_0x007a
            r14 = 0
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            r3 = r13
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r13.L$0 = r6
            r13.label = r2
            java.lang.Object r14 = r1.emit(r14, r3)
            if (r14 != r0) goto L_0x007a
            return r0
        L_0x007a:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$modifyFollowUser$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

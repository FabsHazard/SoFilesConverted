package com.microtech.aidexx.ui.setting.share;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$loadData$2", f = "ShareFollowViewModel.kt", i = {0}, l = {21, 22, 23}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: ShareFollowViewModel.kt */
final class ShareFollowViewModel$loadData$2 extends SuspendLambda implements Function2<FlowCollector<? super List<ShareUserInfo>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isShare;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowViewModel$loadData$2(boolean z, Continuation<? super ShareFollowViewModel$loadData$2> continuation) {
        super(2, continuation);
        this.$isShare = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareFollowViewModel$loadData$2 shareFollowViewModel$loadData$2 = new ShareFollowViewModel$loadData$2(this.$isShare, continuation);
        shareFollowViewModel$loadData$2.L$0 = obj;
        return shareFollowViewModel$loadData$2;
    }

    public final Object invoke(FlowCollector<? super List<ShareUserInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ShareFollowViewModel$loadData$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007f
        L_0x001e:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0040
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.common.net.repository.ShareAndFollowRepository r8 = com.microtech.aidexx.common.net.repository.ShareAndFollowRepository.INSTANCE
            boolean r5 = r7.$isShare
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.findUserAuthorizationList(r5, r6)
            if (r8 != r0) goto L_0x0040
            return r0
        L_0x0040:
            com.microtech.aidexx.common.net.ApiResult r8 = (com.microtech.aidexx.common.net.ApiResult) r8
            boolean r4 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r5 = 0
            if (r4 == 0) goto L_0x006d
            com.microtech.aidexx.common.net.ApiResult$Success r8 = (com.microtech.aidexx.common.net.ApiResult.Success) r8
            java.lang.Object r8 = r8.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r8 = (com.microtech.aidexx.common.net.entity.BaseResponse) r8
            java.lang.Object r8 = r8.getData()
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x005e
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.List r8 = kotlin.collections.CollectionsKt.toMutableList(r8)
            goto L_0x005f
        L_0x005e:
            r8 = r5
        L_0x005f:
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.L$0 = r5
            r7.label = r3
            java.lang.Object r8 = r1.emit(r8, r2)
            if (r8 != r0) goto L_0x007f
            return r0
        L_0x006d:
            boolean r8 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r8 == 0) goto L_0x007f
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r5
            r7.label = r2
            java.lang.Object r8 = r1.emit(r5, r8)
            if (r8 != r0) goto L_0x007f
            return r0
        L_0x007f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$loadData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

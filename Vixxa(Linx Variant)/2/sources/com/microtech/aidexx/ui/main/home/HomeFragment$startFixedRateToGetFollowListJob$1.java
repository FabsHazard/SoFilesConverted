package com.microtech.aidexx.ui.main.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.HomeFragment$startFixedRateToGetFollowListJob$1", f = "HomeFragment.kt", i = {0}, l = {669, 669}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: HomeFragment.kt */
final class HomeFragment$startFixedRateToGetFollowListJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$startFixedRateToGetFollowListJob$1(HomeFragment homeFragment, Continuation<? super HomeFragment$startFixedRateToGetFollowListJob$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeFragment$startFixedRateToGetFollowListJob$1 homeFragment$startFixedRateToGetFollowListJob$1 = new HomeFragment$startFixedRateToGetFollowListJob$1(this.this$0, continuation);
        homeFragment$startFixedRateToGetFollowListJob$1.L$0 = obj;
        return homeFragment$startFixedRateToGetFollowListJob$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$startFixedRateToGetFollowListJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0058
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003e
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.microtech.aidexx.ui.main.home.HomeFragment r7 = r6.this$0
            com.microtech.aidexx.ui.setting.share.ShareFollowViewModel r7 = r7.getShareVm()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.fixedRateToGetFollowList(r4)
            if (r7 != r0) goto L_0x003e
            return r0
        L_0x003e:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            com.microtech.aidexx.ui.main.home.HomeFragment$startFixedRateToGetFollowListJob$1$1 r3 = new com.microtech.aidexx.ui.main.home.HomeFragment$startFixedRateToGetFollowListJob$1$1
            com.microtech.aidexx.ui.main.home.HomeFragment r4 = r6.this$0
            r5 = 0
            r3.<init>(r1, r4, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.L$0 = r5
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.collectLatest(r7, r3, r1)
            if (r7 != r0) goto L_0x0058
            return r0
        L_0x0058:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.HomeFragment$startFixedRateToGetFollowListJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

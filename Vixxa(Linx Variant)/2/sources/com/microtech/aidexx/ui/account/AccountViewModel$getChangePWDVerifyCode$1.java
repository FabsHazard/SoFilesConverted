package com.microtech.aidexx.ui.account;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel$getChangePWDVerifyCode$1", f = "AccountViewModel.kt", i = {0, 1}, l = {144, 146, 149, 150}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$getChangePWDVerifyCode$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$getChangePWDVerifyCode$1(String str, Continuation<? super AccountViewModel$getChangePWDVerifyCode$1> continuation) {
        super(2, continuation);
        this.$account = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountViewModel$getChangePWDVerifyCode$1 accountViewModel$getChangePWDVerifyCode$1 = new AccountViewModel$getChangePWDVerifyCode$1(this.$account, continuation);
        accountViewModel$getChangePWDVerifyCode$1.L$0 = obj;
        return accountViewModel$getChangePWDVerifyCode$1;
    }

    public final Object invoke(FlowCollector<? super Pair<Boolean, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((AccountViewModel$getChangePWDVerifyCode$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r5) goto L_0x002a
            if (r1 == r4) goto L_0x0022
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00ad
        L_0x0022:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x002a:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0052
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            boolean r9 = com.microtech.aidexx.common.ExtendsKt.isGp()
            if (r9 == 0) goto L_0x0055
            com.microtech.aidexx.common.net.repository.AccountRepository r9 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r4 = r8.$account
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = r9.sendUpdatePasswordEmailVerificationCode(r4, r6)
            if (r9 != r0) goto L_0x0052
            return r0
        L_0x0052:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
            goto L_0x0069
        L_0x0055:
            com.microtech.aidexx.common.net.repository.AccountRepository r9 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r6 = r8.$account
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = r9.sendResetPasswordPhoneVerificationCode(r6, r7)
            if (r9 != r0) goto L_0x0067
            return r0
        L_0x0067:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
        L_0x0069:
            boolean r4 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r6 = 0
            if (r4 == 0) goto L_0x0084
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r6)
            r2 = r8
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r8.L$0 = r6
            r8.label = r3
            java.lang.Object r9 = r1.emit(r9, r2)
            if (r9 != r0) goto L_0x00ad
            return r0
        L_0x0084:
            boolean r3 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r3 == 0) goto L_0x00ad
            r3 = 0
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            com.microtech.aidexx.common.net.ApiResult$Failure r9 = (com.microtech.aidexx.common.net.ApiResult.Failure) r9
            boolean r4 = r9.isBizFail()
            if (r4 == 0) goto L_0x009a
            java.lang.String r9 = r9.getMsg()
            goto L_0x009b
        L_0x009a:
            r9 = r6
        L_0x009b:
            kotlin.Pair r9 = kotlin.TuplesKt.to(r3, r9)
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r8.L$0 = r6
            r8.label = r2
            java.lang.Object r9 = r1.emit(r9, r3)
            if (r9 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel$getChangePWDVerifyCode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

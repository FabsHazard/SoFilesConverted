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
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel$changePWD$1", f = "AccountViewModel.kt", i = {0}, l = {156, 157, 159}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$changePWD$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ String $pwd;
    final /* synthetic */ String $verifyCode;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$changePWD$1(String str, String str2, String str3, Continuation<? super AccountViewModel$changePWD$1> continuation) {
        super(2, continuation);
        this.$pwd = str;
        this.$phoneNumber = str2;
        this.$verifyCode = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountViewModel$changePWD$1 accountViewModel$changePWD$1 = new AccountViewModel$changePWD$1(this.$pwd, this.$phoneNumber, this.$verifyCode, continuation);
        accountViewModel$changePWD$1.L$0 = obj;
        return accountViewModel$changePWD$1;
    }

    public final Object invoke(FlowCollector<? super Pair<Boolean, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((AccountViewModel$changePWD$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x001f
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0093
        L_0x001f:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x004b
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.utils.EncryptUtils$Companion r10 = com.microtech.aidexx.utils.EncryptUtils.Companion
            java.lang.String r5 = r9.$pwd
            java.lang.String r10 = r10.md5(r5)
            com.microtech.aidexx.common.net.repository.AccountRepository r5 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r6 = r9.$phoneNumber
            java.lang.String r7 = r9.$verifyCode
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r5.resetPasswordByVerificationCode(r6, r10, r7, r8)
            if (r10 != r0) goto L_0x004b
            return r0
        L_0x004b:
            com.microtech.aidexx.common.net.ApiResult r10 = (com.microtech.aidexx.common.net.ApiResult) r10
            boolean r5 = r10 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r6 = 0
            if (r5 == 0) goto L_0x006a
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.String r2 = ""
            kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r2)
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.L$0 = r6
            r9.label = r3
            java.lang.Object r10 = r1.emit(r10, r2)
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x006a:
            boolean r3 = r10 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r3 == 0) goto L_0x0093
            r3 = 0
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            com.microtech.aidexx.common.net.ApiResult$Failure r10 = (com.microtech.aidexx.common.net.ApiResult.Failure) r10
            boolean r4 = r10.isBizFail()
            if (r4 == 0) goto L_0x0080
            java.lang.String r10 = r10.getMsg()
            goto L_0x0081
        L_0x0080:
            r10 = r6
        L_0x0081:
            kotlin.Pair r10 = kotlin.TuplesKt.to(r3, r10)
            r3 = r9
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r9.L$0 = r6
            r9.label = r2
            java.lang.Object r10 = r1.emit(r10, r3)
            if (r10 != r0) goto L_0x0093
            return r0
        L_0x0093:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel$changePWD$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

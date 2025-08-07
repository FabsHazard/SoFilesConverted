package com.microtech.aidexx.ui.setting.profile;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileViewModel$getChangeAccountVerifyCode$1", f = "ProfileViewModel.kt", i = {0}, l = {244, 247, 249}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$getChangeAccountVerifyCode$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileViewModel$getChangeAccountVerifyCode$1(String str, ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$getChangeAccountVerifyCode$1> continuation) {
        super(2, continuation);
        this.$account = str;
        this.this$0 = profileViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$getChangeAccountVerifyCode$1 profileViewModel$getChangeAccountVerifyCode$1 = new ProfileViewModel$getChangeAccountVerifyCode$1(this.$account, this.this$0, continuation);
        profileViewModel$getChangeAccountVerifyCode$1.L$0 = obj;
        return profileViewModel$getChangeAccountVerifyCode$1;
    }

    public final Object invoke(FlowCollector<? super Pair<Boolean, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$getChangeAccountVerifyCode$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.Object} */
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
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x001f
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
            goto L_0x0090
        L_0x001f:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0041
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.microtech.aidexx.common.net.repository.AccountRepository r8 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r5 = r7.$account
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.sendChangePhoneVerificationCode(r5, r6)
            if (r8 != r0) goto L_0x0041
            return r0
        L_0x0041:
            com.microtech.aidexx.common.net.ApiResult r8 = (com.microtech.aidexx.common.net.ApiResult) r8
            boolean r5 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r6 = 0
            if (r5 == 0) goto L_0x0067
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel r8 = r7.this$0
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$countDownTimer$1 r8 = r8.countDownTimer
            r8.start()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r6)
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.L$0 = r6
            r7.label = r3
            java.lang.Object r8 = r1.emit(r8, r2)
            if (r8 != r0) goto L_0x0090
            return r0
        L_0x0067:
            boolean r3 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r3 == 0) goto L_0x0090
            r3 = 0
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            com.microtech.aidexx.common.net.ApiResult$Failure r8 = (com.microtech.aidexx.common.net.ApiResult.Failure) r8
            boolean r4 = r8.isBizFail()
            if (r4 == 0) goto L_0x007d
            java.lang.String r8 = r8.getMsg()
            goto L_0x007e
        L_0x007d:
            r8 = r6
        L_0x007e:
            kotlin.Pair r8 = kotlin.TuplesKt.to(r3, r8)
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r6
            r7.label = r2
            java.lang.Object r8 = r1.emit(r8, r3)
            if (r8 != r0) goto L_0x0090
            return r0
        L_0x0090:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel$getChangeAccountVerifyCode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

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
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileViewModel$updatePhoneOrEmail$1", f = "ProfileViewModel.kt", i = {0, 1}, l = {254, 256, 257, 259}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$updatePhoneOrEmail$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $account;
    final /* synthetic */ String $code;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileViewModel$updatePhoneOrEmail$1(String str, String str2, Continuation<? super ProfileViewModel$updatePhoneOrEmail$1> continuation) {
        super(2, continuation);
        this.$account = str;
        this.$code = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$updatePhoneOrEmail$1 profileViewModel$updatePhoneOrEmail$1 = new ProfileViewModel$updatePhoneOrEmail$1(this.$account, this.$code, continuation);
        profileViewModel$updatePhoneOrEmail$1.L$0 = obj;
        return profileViewModel$updatePhoneOrEmail$1;
    }

    public final Object invoke(FlowCollector<? super Pair<Boolean, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$updatePhoneOrEmail$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ae A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) {
        /*
            r33 = this;
            r0 = r33
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 == r7) goto L_0x002d
            if (r2 == r5) goto L_0x0025
            if (r2 == r4) goto L_0x0020
            if (r2 != r3) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r34)
            goto L_0x00d8
        L_0x0025:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r34)
            goto L_0x0097
        L_0x002d:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r34)
            r8 = r34
            goto L_0x0052
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r34)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            com.microtech.aidexx.common.net.repository.AccountRepository r8 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r9 = r0.$account
            java.lang.String r10 = r0.$code
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r8 = r8.updatePhoneOrEmail(r9, r10, r11)
            if (r8 != r1) goto L_0x0052
            return r1
        L_0x0052:
            com.microtech.aidexx.common.net.ApiResult r8 = (com.microtech.aidexx.common.net.ApiResult) r8
            boolean r9 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r9 == 0) goto L_0x00af
            com.microtech.aidexx.common.user.UserInfoManager$Companion r3 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r8 = r3.instance()
            java.lang.String r3 = r0.$account
            r26 = r3
            r30 = r0
            kotlin.coroutines.Continuation r30 = (kotlin.coroutines.Continuation) r30
            r0.L$0 = r2
            r0.label = r5
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 1966079(0x1dffff, float:2.755063E-39)
            r32 = 0
            java.lang.Object r3 = com.microtech.aidexx.common.user.UserInfoManager.updateProfile$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            if (r3 != r1) goto L_0x0097
            return r1
        L_0x0097:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            java.lang.String r5 = ""
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r5)
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r2 = r2.emit(r3, r5)
            if (r2 != r1) goto L_0x00d8
            return r1
        L_0x00af:
            boolean r4 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r4 == 0) goto L_0x00d8
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            com.microtech.aidexx.common.net.ApiResult$Failure r8 = (com.microtech.aidexx.common.net.ApiResult.Failure) r8
            boolean r5 = r8.isBizFail()
            if (r5 == 0) goto L_0x00c5
            java.lang.String r5 = r8.getMsg()
            goto L_0x00c6
        L_0x00c5:
            r5 = r6
        L_0x00c6:
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r2 = r2.emit(r4, r5)
            if (r2 != r1) goto L_0x00d8
            return r1
        L_0x00d8:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel$updatePhoneOrEmail$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

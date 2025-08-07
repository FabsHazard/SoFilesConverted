package com.microtech.aidexx.ui.setting.profile.health;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initView$1$1$1", f = "DiabetesInfoConfigActivity.kt", i = {}, l = {86, 95}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DiabetesInfoConfigActivity.kt */
final class DiabetesInfoConfigActivity$initView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiabetesInfoConfigActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiabetesInfoConfigActivity$initView$1$1$1(DiabetesInfoConfigActivity diabetesInfoConfigActivity, Continuation<? super DiabetesInfoConfigActivity$initView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = diabetesInfoConfigActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiabetesInfoConfigActivity$initView$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiabetesInfoConfigActivity$initView$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            r29 = this;
            r0 = r29
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0025
            if (r2 == r5) goto L_0x001e
            if (r2 != r4) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r30)
            goto L_0x00bc
        L_0x0016:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r30)
            r2 = r30
            goto L_0x00a5
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r30)
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel r6 = r2.getPVm()
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r2 = r2.diabetesTypeByDId
            if (r2 == 0) goto L_0x0048
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r7 = r2.length()
            if (r7 != 0) goto L_0x003f
            r2 = r3
        L_0x003f:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0048
            int r2 = java.lang.Integer.parseInt(r2)
            goto L_0x0049
        L_0x0048:
            r2 = -1
        L_0x0049:
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.Integer r2 = r2.diabetesTypeValue
            if (r2 == 0) goto L_0x005a
            int r2 = r2.intValue()
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r15 = r2.diabetesTypeDisplayName
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r16 = r2.diagnosisDate
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r17 = r2.complications
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r18 = r2.complicationsDisplayName
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r19 = r2.treatment
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r2 = r0.this$0
            java.lang.String r20 = r2.treatmentDisplayName
            r26 = r0
            kotlin.coroutines.Continuation r26 = (kotlin.coroutines.Continuation) r26
            r0.label = r5
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r27 = 507967(0x7c03f, float:7.11813E-40)
            r28 = 0
            java.lang.Object r2 = com.microtech.aidexx.ui.setting.profile.ProfileViewModel.modifyProfileInfo$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            if (r2 != r1) goto L_0x00a5
            return r1
        L_0x00a5:
            kotlinx.coroutines.flow.Flow r2 = (kotlinx.coroutines.flow.Flow) r2
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initView$1$1$1$2 r5 = new com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initView$1$1$1$2
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r6 = r0.this$0
            r5.<init>(r6, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.label = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.collectLatest(r2, r5, r3)
            if (r2 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initView$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

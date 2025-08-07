package com.microtech.aidexx.ui.setting.profile.health;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initData$1", f = "DiabetesInfoConfigActivity.kt", i = {0}, l = {69, 69}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: DiabetesInfoConfigActivity.kt */
final class DiabetesInfoConfigActivity$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DiabetesInfoConfigActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiabetesInfoConfigActivity$initData$1(DiabetesInfoConfigActivity diabetesInfoConfigActivity, Continuation<? super DiabetesInfoConfigActivity$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = diabetesInfoConfigActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DiabetesInfoConfigActivity$initData$1 diabetesInfoConfigActivity$initData$1 = new DiabetesInfoConfigActivity$initData$1(this.this$0, continuation);
        diabetesInfoConfigActivity$initData$1.L$0 = obj;
        return diabetesInfoConfigActivity$initData$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiabetesInfoConfigActivity$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            r4 = 0
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0044
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            com.microtech.aidexx.views.dialog.Dialogs.showWait$default(r7, r4, r3, r4)
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r7 = r6.this$0
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel r7 = r7.getPVm()
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.fetchAndSaveAllDiabetes(r5)
            if (r7 != r0) goto L_0x0044
            return r0
        L_0x0044:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initData$1$1 r3 = new com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initData$1$1
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity r5 = r6.this$0
            r3.<init>(r1, r5, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.collectLatest(r7, r3, r1)
            if (r7 != r0) goto L_0x005d
            return r0
        L_0x005d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

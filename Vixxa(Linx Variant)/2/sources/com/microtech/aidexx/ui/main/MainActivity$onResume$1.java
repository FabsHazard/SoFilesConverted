package com.microtech.aidexx.ui.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.MainActivity$onResume$1", f = "MainActivity.kt", i = {0, 1}, l = {163, 164, 174}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* compiled from: MainActivity.kt */
final class MainActivity$onResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$onResume$1(MainActivity mainActivity, Continuation<? super MainActivity$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivity$onResume$1 mainActivity$onResume$1 = new MainActivity$onResume$1(this.this$0, continuation);
        mainActivity$onResume$1.L$0 = obj;
        return mainActivity$onResume$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$onResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            java.lang.String r2 = "beginTransaction(...)"
            java.lang.String r3 = "PrivacyUpdateFragment"
            r4 = 0
            r5 = 0
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r8) goto L_0x0030
            if (r1 == r7) goto L_0x0028
            if (r1 != r6) goto L_0x0020
            java.lang.Object r0 = r10.L$0
            com.microtech.aidexx.ui.main.MainActivity r0 = (com.microtech.aidexx.ui.main.MainActivity) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00b3
        L_0x0020:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0028:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0064
        L_0x0030:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0054
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.microtech.aidexx.ota.OtaManager$Companion r11 = com.microtech.aidexx.ota.OtaManager.Companion
            com.microtech.aidexx.ota.OtaManager r11 = r11.instance()
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.L$0 = r1
            r10.label = r8
            java.lang.Object r11 = r11.checkOtaResource(r9)
            if (r11 != r0) goto L_0x0054
            return r0
        L_0x0054:
            com.microtech.aidexx.data.resource.AppUpgradeManager r11 = com.microtech.aidexx.data.resource.AppUpgradeManager.INSTANCE
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.L$0 = r1
            r10.label = r7
            java.lang.Object r11 = com.microtech.aidexx.data.resource.AppUpgradeManager.fetchVersionInfo$default(r11, r5, r9, r8, r4)
            if (r11 != r0) goto L_0x0064
            return r0
        L_0x0064:
            com.microtech.aidexx.common.net.entity.UpgradeInfo r11 = (com.microtech.aidexx.common.net.entity.UpgradeInfo) r11
            if (r11 == 0) goto L_0x0098
            com.microtech.aidexx.ui.main.MainActivity r0 = r10.this$0
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r0 = r0.beginTransaction()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.microtech.aidexx.ui.upgrade.AppUpdateFragment r1 = new com.microtech.aidexx.ui.upgrade.AppUpdateFragment
            r1.<init>()
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "upgradeInfo"
            android.os.Parcelable r11 = (android.os.Parcelable) r11
            r2.putParcelable(r3, r11)
            r1.setArguments(r2)
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            java.lang.String r11 = "AppUpdateFragment"
            r0.add((androidx.fragment.app.Fragment) r1, (java.lang.String) r11)
            int r11 = r0.commitAllowingStateLoss()
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            goto L_0x00d3
        L_0x0098:
            com.microtech.aidexx.ui.main.MainActivity r11 = r10.this$0
            androidx.fragment.app.FragmentManager r1 = r11.getSupportFragmentManager()
            androidx.fragment.app.Fragment r1 = r1.findFragmentByTag(r3)
            if (r1 != 0) goto L_0x00d3
            com.microtech.aidexx.data.resource.PrivacyUpdateManager r1 = com.microtech.aidexx.data.resource.PrivacyUpdateManager.INSTANCE
            r10.L$0 = r11
            r10.label = r6
            java.lang.Object r1 = com.microtech.aidexx.data.resource.PrivacyUpdateManager.checkPolicyUpdate$default(r1, r5, r10, r8, r4)
            if (r1 != r0) goto L_0x00b1
            return r0
        L_0x00b1:
            r0 = r11
            r11 = r1
        L_0x00b3:
            com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo r11 = (com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo) r11
            if (r11 == 0) goto L_0x00d3
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r0 = r0.beginTransaction()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.microtech.aidexx.ui.upgrade.PrivacyUpdateFragment r1 = new com.microtech.aidexx.ui.upgrade.PrivacyUpdateFragment
            r1.<init>(r11)
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r0.add((androidx.fragment.app.Fragment) r1, (java.lang.String) r3)
            int r11 = r0.commitAllowingStateLoss()
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
        L_0x00d3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.MainActivity$onResume$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

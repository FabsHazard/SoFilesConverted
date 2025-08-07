package com.microtech.aidexx.ui.welcome.guide.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment$checkAllPermission$1", f = "PermissionCheckFragment.kt", i = {0, 1, 2}, l = {63, 66, 68}, m = "invokeSuspend", n = {"baseActivity", "baseActivity", "baseActivity"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: PermissionCheckFragment.kt */
final class PermissionCheckFragment$checkAllPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PermissionCheckFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionCheckFragment$checkAllPermission$1(PermissionCheckFragment permissionCheckFragment, Continuation<? super PermissionCheckFragment$checkAllPermission$1> continuation) {
        super(2, continuation);
        this.this$0 = permissionCheckFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PermissionCheckFragment$checkAllPermission$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PermissionCheckFragment$checkAllPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r9v15, types: [java.lang.Object, androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0033
            if (r1 == r4) goto L_0x002b
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r0 = r8.L$0
            com.microtech.aidexx.base.BaseActivity r0 = (com.microtech.aidexx.base.BaseActivity) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00b5
        L_0x001b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0023:
            java.lang.Object r1 = r8.L$0
            com.microtech.aidexx.base.BaseActivity r1 = (com.microtech.aidexx.base.BaseActivity) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008d
        L_0x002b:
            java.lang.Object r1 = r8.L$0
            com.microtech.aidexx.base.BaseActivity r1 = (com.microtech.aidexx.base.BaseActivity) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0058
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r9)
            com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment r9 = r8.this$0
            androidx.fragment.app.FragmentActivity r9 = r9.requireActivity()
            java.lang.String r1 = "null cannot be cast to non-null type com.microtech.aidexx.base.BaseActivity<*, *>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r1)
            r1 = r9
            com.microtech.aidexx.base.BaseActivity r1 = (com.microtech.aidexx.base.BaseActivity) r1
            com.microtech.aidexx.utils.TimeUtils r9 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r6 = r9.genRandomLoadingTime()
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r9)
            if (r9 != r0) goto L_0x0058
            return r0
        L_0x0058:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r9 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment r4 = r8.this$0
            com.microtech.aidexx.views.SettingItemWidget r4 = r4.bluetoothItem
            if (r4 != 0) goto L_0x0068
            java.lang.String r4 = "bluetoothItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r5
        L_0x0068:
            com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment r6 = r8.this$0
            com.microtech.aidexx.views.SettingItemWidget r6 = r6.locationItem
            if (r6 != 0) goto L_0x0076
            java.lang.String r6 = "locationItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r6 = r5
        L_0x0076:
            r9.checkBluetooth(r1, r4, r6)
            com.microtech.aidexx.utils.TimeUtils r9 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r6 = r9.genRandomLoadingTime()
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r9)
            if (r9 != r0) goto L_0x008d
            return r0
        L_0x008d:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r9 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment r3 = r8.this$0
            com.microtech.aidexx.views.SettingItemWidget r3 = r3.notificationItem
            if (r3 != 0) goto L_0x009d
            java.lang.String r3 = "notificationItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r5
        L_0x009d:
            r9.checkNotification(r1, r3)
            com.microtech.aidexx.utils.TimeUtils r9 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r3 = r9.genRandomLoadingTime()
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r3, r9)
            if (r9 != r0) goto L_0x00b4
            return r0
        L_0x00b4:
            r0 = r1
        L_0x00b5:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r9 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment r1 = r8.this$0
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.batteryItem
            if (r1 != 0) goto L_0x00c5
            java.lang.String r1 = "batteryItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x00c6
        L_0x00c5:
            r5 = r1
        L_0x00c6:
            r9.checkBattery(r0, r5)
            com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment r9 = r8.this$0
            r0 = 0
            r9.isChecking = r0
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment$checkAllPermission$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

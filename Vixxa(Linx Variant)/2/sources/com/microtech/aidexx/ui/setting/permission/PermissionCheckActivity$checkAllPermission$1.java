package com.microtech.aidexx.ui.setting.permission;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity$checkAllPermission$1", f = "PermissionCheckActivity.kt", i = {}, l = {95, 97, 99, 101, 103, 105, 107, 109}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PermissionCheckActivity.kt */
final class PermissionCheckActivity$checkAllPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PermissionCheckActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionCheckActivity$checkAllPermission$1(PermissionCheckActivity permissionCheckActivity, Continuation<? super PermissionCheckActivity$checkAllPermission$1> continuation) {
        super(2, continuation);
        this.this$0 = permissionCheckActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PermissionCheckActivity$checkAllPermission$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PermissionCheckActivity$checkAllPermission$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r5 = r1;
        r1 = r1.netItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        if (r1 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("netItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r8.checkNetWork(r5, r1);
        r7.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r5 = r1;
        r1 = r1.bluetoothItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r1 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("bluetoothItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        r6 = r7.this$0.locationItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        if (r6 != null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("locationItem");
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        r8.checkBluetooth(r5, r1, r6);
        r7.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ab, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r5 = r1;
        r1 = r1.bluetoothItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b9, code lost:
        if (r1 != null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("bluetoothItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bf, code lost:
        r3 = r7.this$0.locationItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        if (r3 != null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("locationItem");
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        r8.checkBluetooth(r5, r1, r3);
        r7.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00de, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e0, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e1, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r2 = r1;
        r1 = r1.notificationItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ec, code lost:
        if (r1 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ee, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("notificationItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f4, code lost:
        r8.checkNotification(r2, r1);
        r7.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0109, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010a, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r2 = r1;
        r1 = r1.batteryItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0115, code lost:
        if (r1 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0117, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("batteryItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011d, code lost:
        r8.checkBattery(r2, r1);
        r7.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0130, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0132, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0133, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r2 = r1;
        r1 = r1.autoStartItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013e, code lost:
        if (r1 != null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0140, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("autoStartItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0146, code lost:
        r8.checkAutoStart(r2, r1);
        r7.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0159, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x015b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015c, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r1 = r7.this$0;
        r2 = r1;
        r1 = r1.storageItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0167, code lost:
        if (r1 != null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0169, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("storageItem");
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016f, code lost:
        r8.checkStorage(r2, r1);
        r7.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0183, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.microtech.aidexx.utils.TimeUtils.INSTANCE.genRandomLoadingTime(), r7) != r0) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0185, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0186, code lost:
        r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE;
        r0 = r7.this$0;
        r1 = r0;
        r0 = r0.cameraItem;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0191, code lost:
        if (r0 != null) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0193, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cameraItem");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0199, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019a, code lost:
        r8.checkCamera(r1, r4);
        r7.this$0.isChecking = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a5, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            java.lang.String r2 = "locationItem"
            java.lang.String r3 = "bluetoothItem"
            r4 = 0
            switch(r1) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0038;
                case 2: goto L_0x0034;
                case 3: goto L_0x002f;
                case 4: goto L_0x002a;
                case 5: goto L_0x0025;
                case 6: goto L_0x0020;
                case 7: goto L_0x001b;
                case 8: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0186
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x015c
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0133
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x010a
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00e1
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00ae
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007b
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0052
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r5 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1 = 1
            r7.label = r1
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r8 != r0) goto L_0x0052
            return r0
        L_0x0052:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r5 = r1
            com.microtech.aidexx.base.BaseActivity r5 = (com.microtech.aidexx.base.BaseActivity) r5
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.netItem
            if (r1 != 0) goto L_0x0065
            java.lang.String r1 = "netItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r4
        L_0x0065:
            r8.checkNetWork(r5, r1)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r5 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1 = 2
            r7.label = r1
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r8 != r0) goto L_0x007b
            return r0
        L_0x007b:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r5 = r1
            com.microtech.aidexx.base.BaseActivity r5 = (com.microtech.aidexx.base.BaseActivity) r5
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.bluetoothItem
            if (r1 != 0) goto L_0x008c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r4
        L_0x008c:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r6 = r7.this$0
            com.microtech.aidexx.views.SettingItemWidget r6 = r6.locationItem
            if (r6 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = r4
        L_0x0098:
            r8.checkBluetooth(r5, r1, r6)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r5 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r1 = 3
            r7.label = r1
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r8 != r0) goto L_0x00ae
            return r0
        L_0x00ae:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r5 = r1
            com.microtech.aidexx.base.BaseActivity r5 = (com.microtech.aidexx.base.BaseActivity) r5
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.bluetoothItem
            if (r1 != 0) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r4
        L_0x00bf:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r3 = r7.this$0
            com.microtech.aidexx.views.SettingItemWidget r3 = r3.locationItem
            if (r3 != 0) goto L_0x00cb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = r4
        L_0x00cb:
            r8.checkBluetooth(r5, r1, r3)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r1 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r3 = 4
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r1, r8)
            if (r8 != r0) goto L_0x00e1
            return r0
        L_0x00e1:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r2 = r1
            com.microtech.aidexx.base.BaseActivity r2 = (com.microtech.aidexx.base.BaseActivity) r2
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.notificationItem
            if (r1 != 0) goto L_0x00f4
            java.lang.String r1 = "notificationItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r4
        L_0x00f4:
            r8.checkNotification(r2, r1)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r1 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r3 = 5
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r1, r8)
            if (r8 != r0) goto L_0x010a
            return r0
        L_0x010a:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r2 = r1
            com.microtech.aidexx.base.BaseActivity r2 = (com.microtech.aidexx.base.BaseActivity) r2
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.batteryItem
            if (r1 != 0) goto L_0x011d
            java.lang.String r1 = "batteryItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r4
        L_0x011d:
            r8.checkBattery(r2, r1)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r1 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r3 = 6
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r1, r8)
            if (r8 != r0) goto L_0x0133
            return r0
        L_0x0133:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r2 = r1
            com.microtech.aidexx.base.BaseActivity r2 = (com.microtech.aidexx.base.BaseActivity) r2
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.autoStartItem
            if (r1 != 0) goto L_0x0146
            java.lang.String r1 = "autoStartItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r4
        L_0x0146:
            r8.checkAutoStart(r2, r1)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r1 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r3 = 7
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r1, r8)
            if (r8 != r0) goto L_0x015c
            return r0
        L_0x015c:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r1 = r7.this$0
            r2 = r1
            com.microtech.aidexx.base.BaseActivity r2 = (com.microtech.aidexx.base.BaseActivity) r2
            com.microtech.aidexx.views.SettingItemWidget r1 = r1.storageItem
            if (r1 != 0) goto L_0x016f
            java.lang.String r1 = "storageItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r4
        L_0x016f:
            r8.checkStorage(r2, r1)
            com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r1 = r8.genRandomLoadingTime()
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r3 = 8
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r1, r8)
            if (r8 != r0) goto L_0x0186
            return r0
        L_0x0186:
            com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil r8 = com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil.INSTANCE
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r0 = r7.this$0
            r1 = r0
            com.microtech.aidexx.base.BaseActivity r1 = (com.microtech.aidexx.base.BaseActivity) r1
            com.microtech.aidexx.views.SettingItemWidget r0 = r0.cameraItem
            if (r0 != 0) goto L_0x0199
            java.lang.String r0 = "cameraItem"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x019a
        L_0x0199:
            r4 = r0
        L_0x019a:
            r8.checkCamera(r1, r4)
            com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity r8 = r7.this$0
            r0 = 0
            r8.isChecking = r0
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.permission.PermissionCheckActivity$checkAllPermission$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

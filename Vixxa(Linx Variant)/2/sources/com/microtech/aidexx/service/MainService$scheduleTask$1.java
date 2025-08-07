package com.microtech.aidexx.service;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/microtech/aidexx/service/MainService$scheduleTask$1", "Ljava/util/TimerTask;", "run", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainService.kt */
public final class MainService$scheduleTask$1 extends TimerTask {
    final /* synthetic */ Ref.IntRef $count;
    final /* synthetic */ MainService this$0;

    MainService$scheduleTask$1(Ref.IntRef intRef, MainService mainService) {
        this.$count = intRef;
        this.this$0 = mainService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r2 = r1.getEntity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r21 = this;
            r0 = r21
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r1 = r1.instance()
            boolean r1 = r1.isLogin()
            if (r1 != 0) goto L_0x000f
            return
        L_0x000f:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "TimerTask -> count"
            r1.eAiDEX(r2)
            kotlin.jvm.internal.Ref$IntRef r1 = r0.$count
            int r1 = r1.element
            r2 = 18
            r3 = 0
            if (r1 != r2) goto L_0x0023
            kotlin.jvm.internal.Ref$IntRef r1 = r0.$count
            r1.element = r3
        L_0x0023:
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r1.getDefault()
            if (r1 == 0) goto L_0x0039
            boolean r2 = r1.isGettingTransmitterData()
            if (r2 == 0) goto L_0x0039
            r1.setGettingTransmitterData(r3)
            return
        L_0x0039:
            kotlin.jvm.internal.Ref$IntRef r2 = r0.$count
            int r2 = r2.element
            r4 = 3
            int r2 = r2 % r4
            r5 = 0
            if (r2 != 0) goto L_0x009b
            com.microtech.aidexx.service.MainService r2 = r0.this$0
            kotlinx.coroutines.CoroutineScope r2 = r2.serviceMainScope
            java.lang.String r6 = "serviceMainScope"
            if (r2 != 0) goto L_0x0051
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r7 = r5
            goto L_0x0052
        L_0x0051:
            r7 = r2
        L_0x0052:
            com.microtech.aidexx.service.MainService$scheduleTask$1$run$1 r2 = new com.microtech.aidexx.service.MainService$scheduleTask$1$run$1
            r2.<init>(r5)
            r10 = r2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            com.microtech.aidexx.service.MainService r2 = r0.this$0
            kotlinx.coroutines.CoroutineScope r2 = r2.serviceMainScope
            if (r2 != 0) goto L_0x006e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r7 = r5
            goto L_0x006f
        L_0x006e:
            r7 = r2
        L_0x006f:
            com.microtech.aidexx.service.MainService$scheduleTask$1$run$2 r2 = new com.microtech.aidexx.service.MainService$scheduleTask$1$run$2
            r2.<init>(r5)
            r10 = r2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            com.microtech.aidexx.service.MainService r2 = r0.this$0
            kotlinx.coroutines.CoroutineScope r2 = r2.serviceMainScope
            if (r2 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r7 = r5
            goto L_0x008c
        L_0x008b:
            r7 = r2
        L_0x008c:
            com.microtech.aidexx.service.MainService$scheduleTask$1$run$3 r2 = new com.microtech.aidexx.service.MainService$scheduleTask$1$run$3
            r2.<init>(r5)
            r10 = r2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
        L_0x009b:
            kotlin.jvm.internal.Ref$IntRef r2 = r0.$count
            int r2 = r2.element
            r6 = 6
            int r2 = r2 % r6
            r7 = 1
            if (r2 != 0) goto L_0x0237
            if (r1 == 0) goto L_0x00b1
            com.microtech.aidexx.db.entity.TransmitterEntity r2 = r1.getEntity()
            if (r2 == 0) goto L_0x00b1
            java.util.Date r2 = r2.getSensorStartTime()
            goto L_0x00b2
        L_0x00b1:
            r2 = r5
        L_0x00b2:
            if (r2 == 0) goto L_0x00d3
            com.microtech.aidexx.db.entity.TransmitterEntity r2 = r1.getEntity()
            java.lang.String r2 = r2.getId()
            if (r2 != 0) goto L_0x00d3
            com.microtech.aidexx.AidexxApp$Companion r2 = com.microtech.aidexx.AidexxApp.Companion
            kotlinx.coroutines.CoroutineScope r8 = r2.getMainScope()
            com.microtech.aidexx.service.MainService$scheduleTask$1$run$4 r2 = new com.microtech.aidexx.service.MainService$scheduleTask$1$run$4
            r2.<init>(r1, r5)
            r11 = r2
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
        L_0x00d3:
            com.microtech.aidexx.ui.setting.SettingsManager r2 = com.microtech.aidexx.ui.setting.SettingsManager.INSTANCE
            com.microtech.aidexx.db.entity.SettingsEntity r2 = r2.getSettingEntity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            if (r1 == 0) goto L_0x01ff
            boolean r8 = r1.isPaired()
            if (r8 == 0) goto L_0x01ff
            com.microtech.aidexx.ui.widget.WidgetUpdateManager$Companion r8 = com.microtech.aidexx.ui.widget.WidgetUpdateManager.Companion
            com.microtech.aidexx.ui.widget.WidgetUpdateManager r8 = r8.instance()
            com.microtech.aidexx.service.MainService r9 = r0.this$0
            android.content.Context r9 = (android.content.Context) r9
            r8.update(r9)
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r10 = r1.getLatestAdTime()
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x0138
            long r10 = r1.getLatestAdTime()
            long r10 = r8 - r10
            long r14 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r4)
            int r4 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r4 < 0) goto L_0x0138
            com.microtech.aidexx.utils.eventbus.EventBusManager r4 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
            kotlin.Pair r10 = new kotlin.Pair
            com.microtech.aidexx.utils.eventbus.DataChangedType r11 = com.microtech.aidexx.utils.eventbus.DataChangedType.DATA_STATE_DELETE
            com.microtech.aidexx.utils.eventbus.CgmDataState r15 = new com.microtech.aidexx.utils.eventbus.CgmDataState
            com.microtech.aidexx.common.user.UserInfoManager$Companion r14 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r14 = r14.instance()
            java.lang.String r17 = r14.userId()
            r18 = 3
            r19 = 0
            r16 = 0
            r20 = 0
            r14 = r15
            r3 = r15
            r15 = r16
            r16 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            r10.<init>(r11, r3)
            java.lang.String r3 = "EVENT_DATA_STATE_CHANGED"
            r4.send(r3, r10)
        L_0x0138:
            boolean r3 = r1.isSensorExpired()
            if (r3 != 0) goto L_0x01a7
            int r3 = r2.getSignalMissingSwitch()
            if (r3 != 0) goto L_0x01a7
            com.microtech.aidexx.service.MainService r3 = r0.this$0
            long r3 = r3.nextSignalLostCheckTime
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x01a7
            long r3 = r1.getLatestAdTime()
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x0168
            long r3 = r1.getLatestAdTime()
            long r3 = r8 - r3
            int r10 = r2.getSignalMissingAlertRate()
            long r10 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r10)
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x017a
        L_0x0168:
            long r3 = r1.getSignalLostFlag()
            long r3 = r8 - r3
            int r10 = r2.getSignalMissingAlertRate()
            long r10 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r10)
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x01a7
        L_0x017a:
            kotlin.jvm.functions.Function2 r3 = r1.getAlert()
            if (r3 == 0) goto L_0x0192
            com.microtech.aidexx.utils.TimeUtils r4 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            java.util.Date r10 = new java.util.Date
            r10.<init>()
            java.lang.String r4 = com.microtech.aidexx.utils.TimeUtils.dateHourMinute$default(r4, r10, r5, r7, r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r3.invoke(r4, r5)
        L_0x0192:
            com.microtech.aidexx.service.MainService r3 = r0.this$0
            int r2 = r2.getSignalMissingAlertRate()
            long r4 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r2)
            long r4 = r4 + r8
            r3.nextSignalLostCheckTime = r4
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r3 = "Signal lost alert"
            r2.eAiDEX(r3)
        L_0x01a7:
            com.microtech.aidexx.service.MainService r2 = r0.this$0
            long r2 = r2.nextSignalLostDialogCheckTime
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01ff
            long r2 = r1.getLatestAdTime()
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            r3 = 60
            if (r2 == 0) goto L_0x01c9
            long r4 = r1.getLatestAdTime()
            long r4 = r8 - r4
            long r10 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r3)
            int r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x01d7
        L_0x01c9:
            long r1 = r1.getSignalLostFlag()
            long r1 = r8 - r1
            long r4 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r3)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x01ff
        L_0x01d7:
            com.microtech.aidexx.AidexxApp$Companion r1 = com.microtech.aidexx.AidexxApp.Companion
            com.microtech.aidexx.AidexxApp r1 = r1.getInstance()
            boolean r1 = r1.isForeground()
            if (r1 == 0) goto L_0x01ff
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "Signal lost one hour"
            r1.eAiDEX(r2)
            com.microtech.aidexx.utils.eventbus.EventBusManager r1 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
            java.lang.String r2 = "EVENT_SIGNAL_LOST_CHECK"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r7)
            r1.send(r2, r4)
            com.microtech.aidexx.service.MainService r1 = r0.this$0
            long r2 = com.microtech.aidexx.common.ExtendsKt.minutesToMillis(r3)
            long r8 = r8 + r2
            r1.nextSignalLostDialogCheckTime = r8
        L_0x01ff:
            com.microtech.aidexx.service.MainService r1 = r0.this$0
            java.lang.String r2 = "power"
            java.lang.Object r1 = r1.getSystemService(r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.os.PowerManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.os.PowerManager r1 = (android.os.PowerManager) r1
            com.microtech.aidexx.service.MainService r2 = r0.this$0
            java.lang.Class<com.microtech.aidexx.service.MainService> r3 = com.microtech.aidexx.service.MainService.class
            java.lang.String r3 = r3.getName()
            android.os.PowerManager$WakeLock r1 = r1.newWakeLock(r7, r3)
            r2.setWakeLock(r1)
            com.microtech.aidexx.service.MainService r1 = r0.this$0
            android.os.PowerManager$WakeLock r1 = r1.getWakeLock()
            if (r1 == 0) goto L_0x0229
            r2 = 0
            r1.setReferenceCounted(r2)
        L_0x0229:
            com.microtech.aidexx.service.MainService r1 = r0.this$0
            android.os.PowerManager$WakeLock r1 = r1.getWakeLock()
            if (r1 == 0) goto L_0x0237
            r2 = 61000(0xee48, double:3.0138E-319)
            r1.acquire(r2)
        L_0x0237:
            kotlin.jvm.internal.Ref$IntRef r1 = r0.$count
            int r1 = r1.element
            kotlin.jvm.internal.Ref$IntRef r2 = r0.$count
            int r1 = r1 + r7
            r2.element = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.service.MainService$scheduleTask$1.run():void");
    }
}

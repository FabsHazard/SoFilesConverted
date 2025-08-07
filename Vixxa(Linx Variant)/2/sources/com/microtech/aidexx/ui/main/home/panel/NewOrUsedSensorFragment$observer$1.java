package com.microtech.aidexx.ui.main.home.panel;

import com.microtech.aidexx.ble.MessageObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$observer$1", "Lcom/microtech/aidexx/ble/MessageObserver;", "onMessage", "", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NewOrUsedSensorFragment.kt */
public final class NewOrUsedSensorFragment$observer$1 implements MessageObserver {
    final /* synthetic */ NewOrUsedSensorFragment this$0;

    NewOrUsedSensorFragment$observer$1(NewOrUsedSensorFragment newOrUsedSensorFragment) {
        this.this$0 = newOrUsedSensorFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d5, code lost:
        r2 = r2.getEntity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(com.microtechmd.blecomm.entity.BleMessage r32) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            java.lang.String r2 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "OTA newSensorFragment onMessage msg="
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            r2.eAiDEX(r3)
            int r2 = r32.getOperation()
            boolean r3 = r32.isSuccess()
            java.lang.String r4 = "glucosePanel"
            r5 = 3
            if (r2 != r5) goto L_0x003a
            com.microtech.aidexx.views.dialog.Dialogs r1 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r1.dismissWait()
            com.microtech.aidexx.ui.main.home.HomeStateManager$Companion r1 = com.microtech.aidexx.ui.main.home.HomeStateManager.Companion
            com.microtech.aidexx.ui.main.home.HomeStateManager r1 = r1.instance()
            r1.setState(r4)
            goto L_0x029c
        L_0x003a:
            r6 = 2
            if (r2 != r6) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r7 = 6
            if (r2 != r7) goto L_0x0053
        L_0x0041:
            if (r3 != 0) goto L_0x029c
            com.microtech.aidexx.views.dialog.Dialogs r1 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r1.dismissWait()
            com.microtech.aidexx.ui.main.home.HomeStateManager$Companion r1 = com.microtech.aidexx.ui.main.home.HomeStateManager.Companion
            com.microtech.aidexx.ui.main.home.HomeStateManager r1 = r1.instance()
            r1.setState(r4)
            goto L_0x029c
        L_0x0053:
            if (r2 != 0) goto L_0x0065
            com.microtech.aidexx.views.dialog.Dialogs r1 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r1.dismissWait()
            com.microtech.aidexx.ui.main.home.HomeStateManager$Companion r1 = com.microtech.aidexx.ui.main.home.HomeStateManager.Companion
            com.microtech.aidexx.ui.main.home.HomeStateManager r1 = r1.instance()
            r1.setState(r4)
            goto L_0x029c
        L_0x0065:
            int r3 = com.microtechmd.blecomm.constant.AidexXOperation.GET_DEVICE_INFO
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 != r3) goto L_0x01c1
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$handler$1 r2 = r2.handler
            r2.removeMessages(r5)
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r2 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r2 = r2.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r2 = r2.getDefault()
            boolean r3 = r32.isSuccess()
            if (r3 == 0) goto L_0x00a1
            byte[] r3 = r32.getData()
            java.lang.String r4 = com.microtech.aidexx.utils.ByteUtils.getDeviceSoftVersion(r3)
            int r3 = com.microtech.aidexx.utils.ByteUtils.getDeviceType(r3)
            if (r2 == 0) goto L_0x00a1
            com.microtech.aidexx.db.entity.TransmitterEntity r5 = r2.getEntity()
            r5.setVersion(r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r2.getEntity()
            r4.setDeviceModel(r3)
        L_0x00a1:
            com.microtech.aidexx.ota.OtaManager$Companion r3 = com.microtech.aidexx.ota.OtaManager.Companion
            com.microtech.aidexx.ota.OtaManager r3 = r3.instance()
            com.microtech.aidexx.common.net.entity.OtaInfo r4 = new com.microtech.aidexx.common.net.entity.OtaInfo
            r10 = r4
            r29 = 262143(0x3ffff, float:3.6734E-40)
            r30 = 0
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
            r26 = 0
            r27 = 0
            r28 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r5 = r0.this$0
            if (r2 == 0) goto L_0x00e0
            com.microtech.aidexx.db.entity.TransmitterEntity r2 = r2.getEntity()
            if (r2 == 0) goto L_0x00e0
            java.lang.String r2 = r2.getVersion()
            goto L_0x00e1
        L_0x00e0:
            r2 = r9
        L_0x00e1:
            r4.setAppNewVersion(r2)
            boolean r2 = r32.isSuccess()
            if (r2 != 0) goto L_0x0106
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r10 = "otaRet="
            r2.<init>(r10)
            int r5 = r5.otaCommandState
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = " deviceinfo获取失败"
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r4.setRemark(r2)
        L_0x0106:
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r10 = "OTA 更新后读取 deviceInfo ret:"
            r5.<init>(r10)
            boolean r10 = r32.isSuccess()
            java.lang.StringBuilder r5 = r5.append(r10)
            java.lang.String r10 = " app version: "
            java.lang.StringBuilder r5 = r5.append(r10)
            java.lang.String r10 = r4.getAppNewVersion()
            java.lang.StringBuilder r5 = r5.append(r10)
            java.lang.String r5 = r5.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogI$default(r2, r5, r9, r6, r9)
            r3.updateOtaInfo(r4)
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            int r2 = r2.otaCommandState
            if (r2 == 0) goto L_0x019f
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            int r2 = r2.otaCommandState
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r3 = r0.this$0
            r3.otaCommandState = r8
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r3 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r3 = r3.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r3 = r3.getDefault()
            if (r3 == 0) goto L_0x0169
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r4 = r0.this$0
            boolean r5 = r32.isSuccess()
            if (r5 != 0) goto L_0x0163
            boolean r5 = r32.isSuccess()
            if (r5 != 0) goto L_0x015f
            if (r2 == r7) goto L_0x015f
            goto L_0x0163
        L_0x015f:
            r4.doNewSensor(r3)
            goto L_0x0166
        L_0x0163:
            r4.updateDefaultParam(r3)
        L_0x0166:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x016a
        L_0x0169:
            r2 = r9
        L_0x016a:
            if (r2 != 0) goto L_0x029c
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            r3 = r0
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1 r3 = (com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1) r3
            com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "OTA otaCommandState="
            r4.<init>(r5)
            int r2 = r2.otaCommandState
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = " messageRet="
            java.lang.StringBuilder r2 = r2.append(r4)
            boolean r1 = r32.isSuccess()
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = " deviceModel null"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r3, r1, r9, r6, r9)
            goto L_0x029c
        L_0x019f:
            com.microtech.aidexx.ota.OtaManager$Companion r1 = com.microtech.aidexx.ota.OtaManager.Companion
            com.microtech.aidexx.ota.OtaManager r1 = r1.instance()
            boolean r1 = r1.needCheckOtaVersion()
            if (r1 != 0) goto L_0x01b6
            com.microtech.aidexx.ota.OtaManager$Companion r1 = com.microtech.aidexx.ota.OtaManager.Companion
            com.microtech.aidexx.ota.OtaManager r1 = r1.instance()
            r1.uploadOtaInfo()
            goto L_0x029c
        L_0x01b6:
            com.microtech.aidexx.ble.AidexBleAdapter$Companion r1 = com.microtech.aidexx.ble.AidexBleAdapter.Companion
            com.microtech.aidexx.ble.AidexBleAdapter r1 = r1.getInstance()
            r1.readBootLoaderVersion()
            goto L_0x029c
        L_0x01c1:
            int r3 = com.microtechmd.blecomm.constant.AidexXOperation.SET_NEW_SENSOR
            if (r2 != r3) goto L_0x01e9
            com.microtech.aidexx.ota.OtaManager$Companion r2 = com.microtech.aidexx.ota.OtaManager.Companion
            com.microtech.aidexx.ota.OtaManager r2 = r2.instance()
            r2.setHasDoNewSensor(r7)
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            r2.sentNewSensorState = r5
            com.microtech.aidexx.views.dialog.Dialogs r2 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r2.dismissWait()
            boolean r1 = r32.isSuccess()
            if (r1 != 0) goto L_0x029c
            com.microtech.aidexx.ui.main.home.HomeStateManager$Companion r1 = com.microtech.aidexx.ui.main.home.HomeStateManager.Companion
            com.microtech.aidexx.ui.main.home.HomeStateManager r1 = r1.instance()
            r1.setState(r4)
            goto L_0x029c
        L_0x01e9:
            int r3 = com.microtechmd.blecomm.constant.AidexXOperation.SET_DEFAULT_PARAM
            if (r2 != r3) goto L_0x0245
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "ota SET_DEFAULT_PARAM msg="
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogI$default(r2, r3, r9, r6, r9)
            boolean r1 = r32.isSuccess()
            if (r1 == 0) goto L_0x0223
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r1 = r0.this$0
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$handler$1 r1 = r1.handler
            r1.removeMessages(r8)
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r1.getDefault()
            if (r1 == 0) goto L_0x029c
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            r2.getDefaultParam(r1)
            goto L_0x029c
        L_0x0223:
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r1.getDefault()
            if (r1 == 0) goto L_0x0237
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            r2.doNewSensor(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0238
        L_0x0237:
            r1 = r9
        L_0x0238:
            if (r1 != 0) goto L_0x029c
            r1 = r0
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1 r1 = (com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1) r1
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "ota SET_DEFAULT_PARAM fail model null"
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r1, r2, r9, r6, r9)
            goto L_0x029c
        L_0x0245:
            int r3 = com.microtechmd.blecomm.constant.AidexXOperation.GET_DEFAULT_PARAM
            if (r2 != r3) goto L_0x029c
            boolean r2 = r32.isSuccess()
            if (r2 == 0) goto L_0x027b
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$handler$1 r2 = r2.handler
            r2.removeMessages(r8)
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            androidx.lifecycle.LifecycleOwner r2 = (androidx.lifecycle.LifecycleOwner) r2
            androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r2)
            r3 = r2
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            r4 = r2
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1$onMessage$8 r2 = new com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1$onMessage$8
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r5 = r0.this$0
            r2.<init>(r5, r1, r9)
            r6 = r2
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 2
            r8 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
            goto L_0x029c
        L_0x027b:
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r1.getDefault()
            if (r1 == 0) goto L_0x028f
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment r2 = r0.this$0
            r2.doNewSensor(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0290
        L_0x028f:
            r1 = r9
        L_0x0290:
            if (r1 != 0) goto L_0x029c
            r1 = r0
            com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1 r1 = (com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1) r1
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "ota GET_DEFAULT_PARAM fail model null"
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r1, r2, r9, r6, r9)
        L_0x029c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1.onMessage(com.microtechmd.blecomm.entity.BleMessage):void");
    }
}

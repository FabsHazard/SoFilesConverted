package com.microtech.aidexx.ble.device;

import android.os.SystemClock;
import com.microtech.aidexx.ble.device.entity.CloudDeviceInfo;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.ble.device.model.TransmitterModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.db.entity.TransmitterEntity_;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ>\u0010\u000e\u001a\u00020\f2+\b\u0002\u0010\u000f\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u001d\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002J\u0013\u0010\u001f\u001a\u0004\u0018\u00010 H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001f\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020)R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/microtech/aidexx/ble/device/TransmitterManager;", "", "()V", "defaultModel", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "pairModel", "buildModel", "bleControllerProxy", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "context", "Landroid/content/Context;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCloudDevice", "success", "Lkotlin/Function1;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "Lcom/microtech/aidexx/ble/device/entity/CloudDeviceInfo;", "Lkotlin/ParameterName;", "name", "info", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefault", "getPair", "loadTransmitter", "sn", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyTransmitterChange", "model", "queryTransmitter", "Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "removeDb", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDefault", "removePair", "set", "update", "Lcom/microtech/aidexx/ble/device/model/TransmitterModel;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterManager.kt */
public final class TransmitterManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static TransmitterManager INSTANCE;
    /* access modifiers changed from: private */
    public static final List<Function1<DeviceModel, Unit>> listenerList = new ArrayList();
    private DeviceModel defaultModel;
    private DeviceModel pairModel;

    public /* synthetic */ TransmitterManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TransmitterManager() {
    }

    public final Object queryTransmitter(Continuation<? super TransmitterEntity> continuation) {
        return BoxStoreKt.awaitCallInTx(ObjectBox.INSTANCE.getStore(), new TransmitterManager$$ExternalSyntheticLambda3(), continuation);
    }

    /* access modifiers changed from: private */
    public static final TransmitterEntity queryTransmitter$lambda$0() {
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        return transmitterBox.query().orderDesc(TransmitterEntity_.idx).build().findFirst();
    }

    public static /* synthetic */ Object loadTransmitter$default(TransmitterManager transmitterManager, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return transmitterManager.loadTransmitter(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadTransmitter(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$1 r0 = (com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$1 r0 = new com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x003d
            if (r2 == r3) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x008b
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$0
            com.microtech.aidexx.ble.device.TransmitterManager r6 = (com.microtech.aidexx.ble.device.TransmitterManager) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0057
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.db.ObjectBox r7 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            io.objectbox.BoxStore r7 = r7.getStore()
            com.microtech.aidexx.ble.device.TransmitterManager$$ExternalSyntheticLambda4 r2 = new com.microtech.aidexx.ble.device.TransmitterManager$$ExternalSyntheticLambda4
            r2.<init>(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r7, r2, r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r6 = r5
        L_0x0057:
            com.microtech.aidexx.db.entity.TransmitterEntity r7 = (com.microtech.aidexx.db.entity.TransmitterEntity) r7
            if (r7 == 0) goto L_0x0078
            int r0 = r7.getDeviceType()
            if (r0 != r4) goto L_0x0096
            com.microtech.aidexx.ble.device.model.TransmitterModel$Companion r0 = com.microtech.aidexx.ble.device.model.TransmitterModel.Companion
            com.microtechmd.blecomm.controller.AidexXController r1 = com.microtechmd.blecomm.controller.AidexXController.getInstance()
            java.lang.String r2 = "getInstance(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.microtechmd.blecomm.controller.BleControllerProxy r1 = (com.microtechmd.blecomm.controller.BleControllerProxy) r1
            com.microtech.aidexx.ble.device.model.TransmitterModel r7 = r0.instance(r7, r1)
            com.microtech.aidexx.ble.device.model.DeviceModel r7 = (com.microtech.aidexx.ble.device.model.DeviceModel) r7
            r6.set(r7)
            goto L_0x0096
        L_0x0078:
            com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$2 r7 = new com.microtech.aidexx.ble.device.TransmitterManager$loadTransmitter$2
            r7.<init>(r6)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r2 = 0
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r6 = r6.getCloudDevice(r7, r0)
            if (r6 != r1) goto L_0x008b
            return r1
        L_0x008b:
            com.microtech.aidexx.ui.main.home.HomeStateManager$Companion r6 = com.microtech.aidexx.ui.main.home.HomeStateManager.Companion
            com.microtech.aidexx.ui.main.home.HomeStateManager r6 = r6.instance()
            java.lang.String r7 = "needPair"
            r6.setState(r7)
        L_0x0096:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.TransmitterManager.loadTransmitter(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final TransmitterEntity loadTransmitter$lambda$2(String str) {
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        QueryBuilder<TransmitterEntity> query = transmitterBox.query();
        if (str != null) {
            query.equal(TransmitterEntity_.deviceSn, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        }
        return query.orderDesc(TransmitterEntity_.idx).build().findFirst();
    }

    static /* synthetic */ Object getCloudDevice$default(TransmitterManager transmitterManager, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return transmitterManager.getCloudDevice(function1, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getCloudDevice(Function1<? super BaseResponse<CloudDeviceInfo>, Unit> function1, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TransmitterManager$getCloudDevice$2(function1, (Continuation<? super TransmitterManager$getCloudDevice$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object removeDb(kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ble.device.TransmitterManager$removeDb$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ble.device.TransmitterManager$removeDb$1 r0 = (com.microtech.aidexx.ble.device.TransmitterManager$removeDb$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ble.device.TransmitterManager$removeDb$1 r0 = new com.microtech.aidexx.ble.device.TransmitterManager$removeDb$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ Exception -> 0x002a }
            goto L_0x0063
        L_0x002a:
            r5 = move-exception
            goto L_0x004b
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.db.ObjectBox r6 = com.microtech.aidexx.db.ObjectBox.INSTANCE     // Catch:{ Exception -> 0x002a }
            io.objectbox.BoxStore r6 = r6.getStore()     // Catch:{ Exception -> 0x002a }
            com.microtech.aidexx.ble.device.TransmitterManager$$ExternalSyntheticLambda1 r2 = new com.microtech.aidexx.ble.device.TransmitterManager$$ExternalSyntheticLambda1     // Catch:{ Exception -> 0x002a }
            r2.<init>(r5)     // Catch:{ Exception -> 0x002a }
            r0.label = r3     // Catch:{ Exception -> 0x002a }
            java.lang.Object r5 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r6, r2, r0)     // Catch:{ Exception -> 0x002a }
            if (r5 != r1) goto L_0x0063
            return r1
        L_0x004b:
            com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "removeDb fail ----> "
            r0.<init>(r1)
            java.lang.String r5 = r5.getMessage()
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r5 = r5.toString()
            r6.eAiDEX(r5)
        L_0x0063:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.TransmitterManager.removeDb(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Unit removeDb$lambda$3(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$callback");
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        transmitterBox.removeAll();
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        BleControllerProxy controller;
        DeviceModel deviceModel = this.defaultModel;
        if (!(deviceModel == null || (controller = deviceModel.getController()) == null)) {
            controller.unregister();
        }
        DeviceModel deviceModel2 = this.defaultModel;
        if (deviceModel2 != null) {
            deviceModel2.setController((BleController) null);
        }
        this.defaultModel = null;
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new TransmitterManager$$ExternalSyntheticLambda2(), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit clear$lambda$4() {
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        transmitterBox.removeAll();
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r1 = r1.getEntity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.microtech.aidexx.ble.device.model.DeviceModel buildModel(com.microtechmd.blecomm.controller.BleControllerProxy r11, android.content.Context r12) {
        /*
            r10 = this;
            java.lang.String r0 = "bleControllerProxy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = r11.getSn()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r10.defaultModel
            r2 = 0
            if (r1 == 0) goto L_0x001e
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = r1.getEntity()
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.getDeviceSn()
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0040
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r10.defaultModel
            if (r1 == 0) goto L_0x0040
            boolean r1 = r1.isPaired()
            r3 = 1
            if (r1 != r3) goto L_0x0040
            com.microtech.aidexx.views.dialog.Dialogs r4 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            int r11 = com.microtech.aidexx.R.string.ble_state_paired
            java.lang.String r5 = r12.getString(r11)
            r8 = 2
            r9 = 0
            r6 = 0
            com.microtech.aidexx.views.dialog.Dialogs.showError$default(r4, r5, r6, r8, r9)
            return r2
        L_0x0040:
            com.microtech.aidexx.db.entity.TransmitterEntity r12 = new com.microtech.aidexx.db.entity.TransmitterEntity
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r12.<init>(r0)
            r0 = 1
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r12.setIdx(r0)
            java.lang.String r0 = r11.getMac()
            r12.setDeviceMac(r0)
            com.microtech.aidexx.ble.device.model.TransmitterModel$Companion r0 = com.microtech.aidexx.ble.device.model.TransmitterModel.Companion
            com.microtech.aidexx.ble.device.model.TransmitterModel r11 = r0.instance(r12, r11)
            com.microtech.aidexx.ble.device.model.DeviceModel r11 = (com.microtech.aidexx.ble.device.model.DeviceModel) r11
            r10.pairModel = r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.TransmitterManager.buildModel(com.microtechmd.blecomm.controller.BleControllerProxy, android.content.Context):com.microtech.aidexx.ble.device.model.DeviceModel");
    }

    public final DeviceModel getDefault() {
        return this.defaultModel;
    }

    public final DeviceModel getPair() {
        return this.pairModel;
    }

    public final void removeDefault() {
        this.defaultModel = null;
        notifyTransmitterChange((DeviceModel) null);
    }

    public final void removePair() {
        this.pairModel = null;
    }

    public final void set(DeviceModel deviceModel) {
        DeviceModel deviceModel2;
        BleControllerProxy controller;
        BleController controller2;
        Intrinsics.checkNotNullParameter(deviceModel, "model");
        if (deviceModel.isPaired()) {
            String sensorId = deviceModel.getEntity().getSensorId();
            if (sensorId != null) {
                ObjectBox.runAsync$default(ObjectBox.INSTANCE, new TransmitterManager$$ExternalSyntheticLambda0(sensorId, deviceModel), (Function0) null, (Function1) null, 6, (Object) null);
            }
            deviceModel.setSignalLostFlag(SystemClock.elapsedRealtime());
        }
        DeviceModel deviceModel3 = this.defaultModel;
        if (!(deviceModel3 == null || (controller2 = deviceModel3.getController()) == null)) {
            controller2.unregister();
        }
        this.defaultModel = deviceModel;
        if (deviceModel != null) {
            deviceModel.observerMessage();
        }
        DeviceModel deviceModel4 = this.defaultModel;
        if (!(deviceModel4 == null || !deviceModel4.isPaired() || (deviceModel2 = this.defaultModel) == null || (controller = deviceModel2.getController()) == null)) {
            controller.register();
        }
        notifyTransmitterChange(this.defaultModel);
    }

    /* access modifiers changed from: private */
    public static final void set$lambda$6$lambda$5(String str, DeviceModel deviceModel) {
        Intrinsics.checkNotNullParameter(str, "$it");
        Intrinsics.checkNotNullParameter(deviceModel, "$model");
        Box<RealCgmHistoryEntity> cgmHistoryBox = ObjectBox.INSTANCE.getCgmHistoryBox();
        Intrinsics.checkNotNull(cgmHistoryBox);
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryBox.query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.sensorId;
        Intrinsics.checkNotNullExpressionValue(property, "sensorId");
        RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) ExtendsKt.equal(query, property, str).notEqual(RealCgmHistoryEntity_.eventWarning, -1).or().isNull(RealCgmHistoryEntity_.eventWarning).orderDesc(RealCgmHistoryEntity_.timeOffset).build().findFirst();
        if (realCgmHistoryEntity != null && deviceModel.getEntity().getSensorStartTime() != null) {
            int timeOffset = realCgmHistoryEntity.getTimeOffset();
            Date sensorStartTime = deviceModel.getEntity().getSensorStartTime();
            Intrinsics.checkNotNull(sensorStartTime);
            Date historyDate = ExtendsKt.toHistoryDate(timeOffset, sensorStartTime);
            long currentTimeMillis = TimeUtils.INSTANCE.getCurrentTimeMillis() - historyDate.getTime();
            SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
            if (currentTimeMillis < ExtendsKt.minutesToMillis(settingEntity != null ? settingEntity.getSignalMissingAlertRate() : 15)) {
                deviceModel.setHistoryValid(true);
                deviceModel.setLastHistoryTime(historyDate);
                deviceModel.setLastHistoryAppTime(realCgmHistoryEntity.getAppTime());
                deviceModel.setGlucose(realCgmHistoryEntity.getGlucose());
                deviceModel.setGlucoseLevel(deviceModel.getGlucoseLevel(realCgmHistoryEntity.getGlucose()));
                EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, true);
            }
        }
    }

    public final void update(TransmitterModel transmitterModel) {
        Intrinsics.checkNotNullParameter(transmitterModel, "model");
        if (transmitterModel.getEntity().getIdx() != null) {
            Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
            Intrinsics.checkNotNull(transmitterBox);
            transmitterBox.put(transmitterModel.getEntity());
        }
    }

    private final void notifyTransmitterChange(DeviceModel deviceModel) {
        for (Function1 next : listenerList) {
            if (next != null) {
                next.invoke(deviceModel);
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J+\u0010\u0010\u001a\u00020\u000e2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tJ-\u0010\u0012\u001a\u00020\u000e2%\u0010\u0011\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R3\u0010\u0007\u001a'\u0012#\u0012!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ble/device/TransmitterManager$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/ble/device/TransmitterManager;", "getINSTANCE", "()Lcom/microtech/aidexx/ble/device/TransmitterManager;", "listenerList", "", "Lkotlin/Function1;", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "Lkotlin/ParameterName;", "name", "model", "", "instance", "removeOnTransmitterChangeListener", "listener", "setOnTransmitterChangeListener", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TransmitterManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setOnTransmitterChangeListener(Function1<? super DeviceModel, Unit> function1) {
            TransmitterManager.listenerList.add(function1);
        }

        public final void removeOnTransmitterChangeListener(Function1<? super DeviceModel, Unit> function1) {
            TypeIntrinsics.asMutableCollection(TransmitterManager.listenerList).remove(function1);
        }

        private final TransmitterManager getINSTANCE() {
            if (TransmitterManager.INSTANCE == null) {
                TransmitterManager.INSTANCE = new TransmitterManager((DefaultConstructorMarker) null);
            }
            return TransmitterManager.INSTANCE;
        }

        public final synchronized TransmitterManager instance() {
            TransmitterManager instance;
            instance = getINSTANCE();
            Intrinsics.checkNotNull(instance);
            return instance;
        }
    }
}

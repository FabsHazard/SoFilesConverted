package com.microtech.aidexx.ui.pair;

import android.content.Context;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.ble.MessageObserver;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.ui.pair.PairUtil;
import com.microtech.aidexx.utils.ByteUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.constant.AidexXOperation;
import com.microtechmd.blecomm.entity.BleMessage;
import com.microtechmd.blecomm.parser.AidexXDeviceInfoEntity;
import com.microtechmd.blecomm.parser.AidexXParser;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/pair/PairUtil$observeMessage$1", "Lcom/microtech/aidexx/ble/MessageObserver;", "onMessage", "", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairUtil.kt */
public final class PairUtil$observeMessage$1 implements MessageObserver {
    final /* synthetic */ Context $context;
    final /* synthetic */ CoroutineScope $scope;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.microtech.aidexx.ui.pair.PairUtil$Operation[] r0 = com.microtech.aidexx.ui.pair.PairUtil.Operation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.ui.pair.PairUtil$Operation r1 = com.microtech.aidexx.ui.pair.PairUtil.Operation.PAIR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.ui.pair.PairUtil$Operation r1 = com.microtech.aidexx.ui.pair.PairUtil.Operation.UNPAIR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.pair.PairUtil$observeMessage$1.WhenMappings.<clinit>():void");
        }
    }

    PairUtil$observeMessage$1(Context context, CoroutineScope coroutineScope) {
        this.$context = context;
        this.$scope = coroutineScope;
    }

    public void onMessage(BleMessage bleMessage) {
        DeviceModel deviceModel;
        Unit unit;
        Intrinsics.checkNotNullParameter(bleMessage, CrashHianalyticsData.MESSAGE);
        boolean isSuccess = bleMessage.isSuccess();
        TransmitterManager instance = TransmitterManager.Companion.instance();
        if (PairUtil.INSTANCE.getOperation() == PairUtil.Operation.PAIR) {
            deviceModel = instance.getPair();
        } else {
            deviceModel = instance.getDefault();
        }
        if (deviceModel != null) {
            int operation = bleMessage.getOperation();
            String str = null;
            if (operation == 1) {
                LogUtil.Companion companion = LogUtil.Companion;
                StringBuilder sb = new StringBuilder();
                PairUtil.Operation operation2 = PairUtil.INSTANCE.getOperation();
                if (operation2 != null) {
                    str = operation2.getDesc();
                }
                companion.eAiDEX(sb.append(str).append(" --> discover:").append(isSuccess).toString());
                if (isSuccess) {
                    return;
                }
                if ((PairUtil.INSTANCE.getOperation() == PairUtil.Operation.PAIR || PairUtil.INSTANCE.getOperation() == PairUtil.Operation.UNPAIR) && !PairUtil.INSTANCE.isForceDelete()) {
                    Dialogs.INSTANCE.dismissWait();
                }
            } else if (operation == 2) {
                LogUtil.Companion companion2 = LogUtil.Companion;
                StringBuilder sb2 = new StringBuilder();
                PairUtil.Operation operation3 = PairUtil.INSTANCE.getOperation();
                if (operation3 != null) {
                    str = operation3.getDesc();
                }
                companion2.eAiDEX(sb2.append(str).append(" --> connect:").append(isSuccess).toString());
                if ((PairUtil.INSTANCE.getOperation() != PairUtil.Operation.PAIR && PairUtil.INSTANCE.getOperation() != PairUtil.Operation.UNPAIR) || PairUtil.INSTANCE.isForceDelete()) {
                    return;
                }
                if (isSuccess) {
                    Dialogs.INSTANCE.showWait(this.$context.getString(R.string.ble_state_connecting));
                } else if (AidexBleAdapter.Companion.getInstance().getConnectStatus().getFirst().intValue() == 22) {
                    Dialogs.INSTANCE.showError(this.$context.getString(R.string.ble_state_disable), PairUtilKt.DELAY_A_WHILE);
                } else if (!PairUtil.transmitterOperateComplete) {
                    Dialogs.showError$default(Dialogs.INSTANCE, this.$context.getString(R.string.ble_state_connect_failure), 0, 2, (Object) null);
                }
            } else if (operation == AidexXOperation.ENABLE_NOTIFY) {
                if (PairUtil.INSTANCE.getOperation() == PairUtil.Operation.PAIR) {
                    Dialogs.INSTANCE.showWait(this.$context.getString(R.string.ble_state_enableNotify));
                }
            } else if (operation == 6) {
                LogUtil.Companion companion3 = LogUtil.Companion;
                StringBuilder sb3 = new StringBuilder();
                PairUtil.Operation operation4 = PairUtil.INSTANCE.getOperation();
                if (operation4 != null) {
                    str = operation4.getDesc();
                }
                companion3.eAiDEX(sb3.append(str).append(" --> bond:").append(isSuccess).toString());
                if ((PairUtil.INSTANCE.getOperation() == PairUtil.Operation.PAIR || PairUtil.INSTANCE.getOperation() == PairUtil.Operation.UNPAIR) && !isSuccess && !PairUtil.INSTANCE.isForceDelete()) {
                    PairUtil.INSTANCE.operationFail();
                }
            } else if (operation == 4) {
                LogUtil.Companion companion4 = LogUtil.Companion;
                StringBuilder sb4 = new StringBuilder();
                PairUtil.Operation operation5 = PairUtil.INSTANCE.getOperation();
                if (operation5 != null) {
                    str = operation5.getDesc();
                }
                companion4.eAiDEX(sb4.append(str).append(" --> pair:").append(isSuccess).toString());
                if (!isSuccess) {
                    PairUtil.INSTANCE.operationFail();
                    return;
                }
                OtaManager.Companion.instance().setHasDoNewSensor(false);
                deviceModel.insertHistoryDeviceRecord(deviceModel.getEntity().getDeviceSn());
            } else if (operation == AidexXOperation.DELETE_BOND) {
                LogUtil.Companion companion5 = LogUtil.Companion;
                StringBuilder sb5 = new StringBuilder();
                PairUtil.Operation operation6 = PairUtil.INSTANCE.getOperation();
                companion5.eAiDEX(sb5.append(operation6 != null ? operation6.getDesc() : null).append(" --> delete bond:").append(isSuccess).toString());
                if (PairUtil.INSTANCE.isForceDelete()) {
                    return;
                }
                if (isSuccess) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new PairUtil$observeMessage$1$onMessage$1(deviceModel, (Continuation<? super PairUtil$observeMessage$1$onMessage$1>) null), 3, (Object) null);
                } else {
                    Dialogs.showError$default(Dialogs.INSTANCE, this.$context.getString(R.string.com_actionState_failure, new Object[]{this.$context.getString(R.string.com_action_unpair)}), 0, 2, (Object) null);
                }
            } else if (operation == 5) {
                LogUtil.Companion companion6 = LogUtil.Companion;
                StringBuilder sb6 = new StringBuilder();
                PairUtil.Operation operation7 = PairUtil.INSTANCE.getOperation();
                companion6.eAiDEX(sb6.append(operation7 != null ? operation7.getDesc() : null).append(" --> unpair:").append(isSuccess).toString());
                if (PairUtil.INSTANCE.isForceDelete()) {
                    return;
                }
                if (isSuccess) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new PairUtil$observeMessage$1$onMessage$2(deviceModel, (Continuation<? super PairUtil$observeMessage$1$onMessage$2>) null), 3, (Object) null);
                } else {
                    Dialogs.showError$default(Dialogs.INSTANCE, this.$context.getString(R.string.com_actionState_failure, new Object[]{this.$context.getString(R.string.com_action_unpair)}), 0, 2, (Object) null);
                }
            } else if (operation == AidexXOperation.GET_START_TIME) {
                ObjectBox.INSTANCE.runAsync(new PairUtil$observeMessage$1$$ExternalSyntheticLambda0(bleMessage.getData(), deviceModel, this.$scope), new PairUtil$observeMessage$1$onMessage$4(this.$scope, instance, deviceModel), new PairUtil$observeMessage$1$onMessage$5(this.$scope));
            } else if (operation == AidexXOperation.GET_DEVICE_INFO) {
                AidexXDeviceInfoEntity aidexXDeviceInfo = AidexXParser.getAidexXDeviceInfo(bleMessage.getData());
                if (aidexXDeviceInfo != null) {
                    deviceModel.getEntity().setVersion(aidexXDeviceInfo.getEdition());
                    TransmitterEntity entity = deviceModel.getEntity();
                    int typeWithFlag = aidexXDeviceInfo.getTypeWithFlag();
                    int days = aidexXDeviceInfo.getDays();
                    String key = aidexXDeviceInfo.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "getKey(...)");
                    entity.setDeviceModel(typeWithFlag, days, key);
                    LogUtil.Companion companion7 = LogUtil.Companion;
                    StringBuilder sb7 = new StringBuilder();
                    PairUtil.Operation operation8 = PairUtil.INSTANCE.getOperation();
                    companion7.eAiDEX(sb7.append(operation8 != null ? operation8.getDesc() : null).append(" --> deviceInfo=").append(aidexXDeviceInfo).toString());
                    AidexBleAdapter.Companion.getInstance().readBootLoaderVersion();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    PairUtil$observeMessage$1 pairUtil$observeMessage$1 = this;
                    LogUtil.Companion companion8 = LogUtil.Companion;
                    StringBuilder sb8 = new StringBuilder();
                    PairUtil.Operation operation9 = PairUtil.INSTANCE.getOperation();
                    if (operation9 != null) {
                        str = operation9.getDesc();
                    }
                    companion8.eAiDEX(sb8.append(str).append(" --> deviceInfo=null").toString());
                }
            } else if (operation == 3) {
                LogUtil.Companion companion9 = LogUtil.Companion;
                StringBuilder sb9 = new StringBuilder();
                PairUtil.Operation operation10 = PairUtil.INSTANCE.getOperation();
                if (operation10 != null) {
                    str = operation10.getDesc();
                }
                companion9.eAiDEX(sb9.append(str).append(" --> disconnect:").append(isSuccess).toString());
                PairUtil.Operation operation11 = PairUtil.INSTANCE.getOperation();
                int i = operation11 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[operation11.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (!PairUtil.transmitterOperateComplete) {
                            Dialogs.INSTANCE.dismissWait();
                        }
                    } else if (!PairUtil.transmitterOperateComplete) {
                        PairUtil.INSTANCE.operationFail();
                    }
                } else if (!PairUtil.transmitterOperateComplete) {
                    PairUtil.INSTANCE.operationFail();
                }
            } else if (operation == AidexXOperation.GET_BOOT_VERSION && bleMessage.isSuccess()) {
                String bootVersion = ByteUtils.getBootVersion(bleMessage.getData());
                LogUtil.Companion.xLogI$default(LogUtil.Companion, "OTA 保存 boot version " + bootVersion, (String) null, 2, (Object) null);
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                Intrinsics.checkNotNull(bootVersion);
                mmkvManager.setBootVer(bootVersion);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onMessage$lambda$1(byte[] bArr, DeviceModel deviceModel, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "$scope");
        Date checkToDate = ByteUtils.checkToDate(bArr);
        if (checkToDate != null) {
            deviceModel.updateStart(checkToDate);
        }
        PairUtil pairUtil = PairUtil.INSTANCE;
        PairUtil.transmitterOperateComplete = true;
        deviceModel.savePair(coroutineScope);
    }
}

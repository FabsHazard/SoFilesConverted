package com.microtech.aidexx.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.utils.LogUtil;
import com.microtechmd.blecomm.constant.AidexXOperation;
import com.microtechmd.blecomm.entity.BleMessage;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ble/AidexBleAdapter$initialize$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AidexBleAdapter.kt */
public final class AidexBleAdapter$initialize$1 extends Handler {
    final /* synthetic */ Context $context;
    final /* synthetic */ AidexBleAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AidexBleAdapter$initialize$1(AidexBleAdapter aidexBleAdapter, Context context, Looper looper) {
        super(looper);
        this.this$0 = aidexBleAdapter;
        this.$context = context;
    }

    public void handleMessage(Message message) {
        BluetoothGatt access$getMBluetoothGatt$p;
        BluetoothGatt access$getMBluetoothGatt$p2;
        Unit unit;
        Unit unit2;
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        super.handleMessage(message);
        int i = message.arg1;
        int i2 = message.what;
        if (i2 != 1001) {
            if (i2 != 1100) {
                if (i2 != 2000) {
                    BluetoothGatt bluetoothGatt = null;
                    switch (i2) {
                        case PointerIconCompat.TYPE_HELP:
                            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(AidexxApp.Companion.getInstance(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                                Handler access$getWorkHandler$p = this.this$0.workHandler;
                                if (access$getWorkHandler$p != null) {
                                    access$getWorkHandler$p.removeMessages(1100);
                                }
                                Handler access$getWorkHandler$p2 = this.this$0.workHandler;
                                if (access$getWorkHandler$p2 != null) {
                                    access$getWorkHandler$p2.sendEmptyMessageDelayed(1100, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                                }
                                this.this$0.closeGatt();
                                LogUtil.Companion.eAiDEX("CONNECT_GATT");
                                this.this$0.refreshConnectState(true);
                                AidexBleAdapter aidexBleAdapter = this.this$0;
                                BluetoothDevice access$getMBluetoothDevice$p = aidexBleAdapter.mBluetoothDevice;
                                if (access$getMBluetoothDevice$p != null) {
                                    bluetoothGatt = access$getMBluetoothDevice$p.connectGatt(this.$context, false, this.this$0.bluetoothGattCallback, 2);
                                }
                                aidexBleAdapter.mBluetoothGatt = bluetoothGatt;
                                return;
                            }
                            LogUtil.Companion.eAiDEX("permission denied --> Manifest.permission.BLUETOOTH_CONNECT");
                            return;
                        case 1004:
                            if (this.this$0.mBluetoothGatt != null && (access$getMBluetoothGatt$p = this.this$0.mBluetoothGatt) != null) {
                                access$getMBluetoothGatt$p.discoverServices();
                                return;
                            }
                            return;
                        case 1005:
                            if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(AidexxApp.Companion.getInstance(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                                BluetoothGatt access$getMBluetoothGatt$p3 = this.this$0.mBluetoothGatt;
                                if (access$getMBluetoothGatt$p3 != null) {
                                    access$getMBluetoothGatt$p3.disconnect();
                                    return;
                                }
                                return;
                            }
                            LogUtil.Companion.eAiDEX("permission denied --> Manifest.permission.BLUETOOTH_CONNECT");
                            return;
                        case 1006:
                            LogUtil.Companion.eAiDEX("CLOSE_GATT");
                            this.this$0.refreshConnectState(false);
                            this.this$0.closeGatt();
                            return;
                        case 1007:
                            AidexBleAdapter aidexBleAdapter2 = this.this$0;
                            Object obj = message.obj;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
                            aidexBleAdapter2.sendData(i, (byte[]) obj);
                            return;
                        case PointerIconCompat.TYPE_TEXT:
                            LogUtil.Companion.eAiDEX("CONNECT_DISCONNECTED");
                            this.this$0.refreshConnectState(false);
                            this.this$0.onDisconnected();
                            return;
                        case PointerIconCompat.TYPE_VERTICAL_TEXT:
                            break;
                        case PointerIconCompat.TYPE_ALIAS:
                            Handler access$getWorkHandler$p3 = this.this$0.workHandler;
                            Intrinsics.checkNotNull(access$getWorkHandler$p3);
                            access$getWorkHandler$p3.removeMessages(1100);
                            if (this.this$0.isOnConnectState()) {
                                this.this$0.onConnectSuccess();
                                return;
                            }
                            return;
                        default:
                            switch (i2) {
                                case PointerIconCompat.TYPE_NO_DROP:
                                    this.this$0.characteristicsMap.clear();
                                    BluetoothGatt access$getMBluetoothGatt$p4 = this.this$0.mBluetoothGatt;
                                    Intrinsics.checkNotNull(access$getMBluetoothGatt$p4);
                                    BluetoothGattService service = access$getMBluetoothGatt$p4.getService(ExtendsKt.toUuid(this.this$0.getServiceUUID()));
                                    if (service != null) {
                                        UUID uuid = ExtendsKt.toUuid(this.this$0.getCharacteristicUUID());
                                        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid);
                                        if (characteristic != null) {
                                            this.this$0.characteristicsMap.put(Integer.valueOf(this.this$0.getCharacteristicUUID()), characteristic);
                                            LogUtil.Companion.eAiDEX("discover character " + uuid);
                                        } else {
                                            LogUtil.Companion.eAiDEX("character " + uuid + " not found");
                                        }
                                        UUID uuid2 = ExtendsKt.toUuid(this.this$0.getPrivateCharacteristicUUID());
                                        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(uuid2);
                                        if (characteristic2 != null) {
                                            this.this$0.characteristicsMap.put(Integer.valueOf(this.this$0.getPrivateCharacteristicUUID()), characteristic2);
                                            LogUtil.Companion.eAiDEX("discover character " + uuid2);
                                        } else {
                                            LogUtil.Companion.eAiDEX("character " + uuid2 + " not found");
                                        }
                                        if (characteristic2 != null) {
                                            for (Map.Entry entry : this.this$0.characteristicsMap.entrySet()) {
                                                int intValue = ((Number) entry.getKey()).intValue();
                                                BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) entry.getValue();
                                                if (intValue == this.this$0.getCharacteristicUUID()) {
                                                    this.this$0.mCharacteristic = bluetoothGattCharacteristic;
                                                } else {
                                                    this.this$0.setNotify(bluetoothGattCharacteristic);
                                                    MessageDistributor.Companion.instance().send(new BleMessage(AidexXOperation.ENABLE_NOTIFY, true, (byte[]) null, 1));
                                                }
                                            }
                                            return;
                                        } else if (characteristic != null) {
                                            AidexBleAdapter aidexBleAdapter3 = this.this$0;
                                            aidexBleAdapter3.mCharacteristic = null;
                                            aidexBleAdapter3.setNotify(characteristic);
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                case PointerIconCompat.TYPE_ALL_SCROLL:
                                    if (i != 0 && this.this$0.characteristicsMap.get(Integer.valueOf(i)) != null && (access$getMBluetoothGatt$p2 = this.this$0.mBluetoothGatt) != null) {
                                        access$getMBluetoothGatt$p2.readCharacteristic((BluetoothGattCharacteristic) this.this$0.characteristicsMap.get(Integer.valueOf(i)));
                                        return;
                                    }
                                    return;
                                case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW:
                                    this.this$0.executeDisconnect();
                                    return;
                                case 1015:
                                    Object obj2 = message.obj;
                                    if (obj2 != null) {
                                        AidexBleAdapter aidexBleAdapter4 = this.this$0;
                                        if (obj2 instanceof UUID) {
                                            BluetoothGatt access$getMBluetoothGatt$p5 = aidexBleAdapter4.mBluetoothGatt;
                                            BluetoothGattService service2 = access$getMBluetoothGatt$p5 != null ? access$getMBluetoothGatt$p5.getService(OtaManager.Companion.getOTA_SERVICE()) : null;
                                            if (service2 != null) {
                                                BluetoothGattCharacteristic characteristic3 = service2.getCharacteristic((UUID) obj2);
                                                if (characteristic3 != null) {
                                                    Intrinsics.checkNotNull(characteristic3);
                                                    BluetoothGatt access$getMBluetoothGatt$p6 = aidexBleAdapter4.mBluetoothGatt;
                                                    if (access$getMBluetoothGatt$p6 != null) {
                                                        access$getMBluetoothGatt$p6.readCharacteristic(characteristic3);
                                                    }
                                                    LogUtil.Companion.xLogI$default(LogUtil.Companion, "开始读取otaControl=" + characteristic3.getUuid(), (String) null, 2, (Object) null);
                                                    unit2 = Unit.INSTANCE;
                                                } else {
                                                    unit2 = null;
                                                }
                                                if (unit2 == null) {
                                                    LogUtil.Companion.xLogE$default(LogUtil.Companion, "获取otaService中的 " + obj2 + " 特征失败", (String) null, 2, (Object) null);
                                                }
                                                unit = Unit.INSTANCE;
                                            } else {
                                                unit = null;
                                            }
                                            if (unit == null) {
                                                LogUtil.Companion.xLogE$default(LogUtil.Companion, "获取otaService失败", (String) null, 2, (Object) null);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                    }
                } else if (message.obj != null) {
                    AidexBleAdapter aidexBleAdapter5 = this.this$0;
                    if (i == 0) {
                        Object obj3 = message.obj;
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.ByteArray");
                        aidexBleAdapter5.onReceiveData((byte[]) obj3);
                        return;
                    }
                    Object obj4 = message.obj;
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.ByteArray");
                    aidexBleAdapter5.onReceiveData(i, (byte[]) obj4);
                    return;
                } else {
                    return;
                }
            }
            Handler access$getWorkHandler$p4 = this.this$0.workHandler;
            Intrinsics.checkNotNull(access$getWorkHandler$p4);
            access$getWorkHandler$p4.removeMessages(1100);
            LogUtil.Companion.eAiDEX("BLE_CONNECT_TIME_OUT CONNECT_FAILURE");
            this.this$0.refreshConnectState(false);
            this.this$0.closeGatt();
            this.this$0.onConnectFailure();
            return;
        }
        this.this$0.startBtScan(true);
    }
}

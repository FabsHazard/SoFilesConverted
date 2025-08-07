package com.microtech.aidexx.ota;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.microtech.aidexx.utils.StringUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0017J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0018"}, d2 = {"com/microtech/aidexx/ota/OtaWorker$mGattCallback$1", "Landroid/bluetooth/BluetoothGattCallback;", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onMtuChanged", "mtu", "onPhyUpdate", "txPhy", "rxPhy", "onServicesDiscovered", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaWorker.kt */
public final class OtaWorker$mGattCallback$1 extends BluetoothGattCallback {
    final /* synthetic */ OtaWorker this$0;

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattDescriptor, "descriptor");
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattDescriptor, "descriptor");
    }

    OtaWorker$mGattCallback$1(OtaWorker otaWorker) {
        this.this$0 = otaWorker;
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        if (i != 0) {
            if (i == 8 || i == 19) {
                this.this$0.log("OTA --> Target device disconnected with status: " + i);
            } else {
                this.this$0.log("OTA --> Connection state change error: " + i + " newState: " + i2);
            }
            this.this$0.mError = i | 32768;
            if (i2 == 0) {
                this.this$0.setMConnectionState(0);
            }
        } else if (i2 == 0) {
            this.this$0.log("OTA --> Disconnected from GATT server");
            this.this$0.setMConnectionState(0);
        } else if (i2 == 2) {
            this.this$0.setMConnectionState(-2);
            if (bluetoothGatt.getDevice().getBondState() == 12) {
                this.this$0.waitFor(1600);
            }
            boolean discoverServices = bluetoothGatt.discoverServices();
            this.this$0.log("OTA --> Attempting to start service discovery:" + discoverServices);
            if (!discoverServices) {
                this.this$0.mError = OtaWorkerKt.OTA_ERROR_SERVICE_DISCOVERY_NOT_STARTED;
            } else {
                return;
            }
        }
        Object access$getMLock$p = this.this$0.mLock;
        OtaWorker otaWorker = this.this$0;
        synchronized (access$getMLock$p) {
            otaWorker.mLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        if (i == 0) {
            this.this$0.log("OTA --> Services discovered");
            this.this$0.setMConnectionState(-3);
        } else {
            this.this$0.log("OTA --> Service discovery error: " + i);
            this.this$0.mError = i | 16384;
        }
        Object access$getMLock$p = this.this$0.mLock;
        OtaWorker otaWorker = this.this$0;
        synchronized (access$getMLock$p) {
            otaWorker.mLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        if (i == 0) {
            OtaWorker otaWorker = this.this$0;
            StringBuilder append = new StringBuilder("OTA --> write success, uuid:").append(bluetoothGattCharacteristic.getUuid()).append(", data:");
            byte[] value = bluetoothGattCharacteristic.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            StringBuilder append2 = append.append(ArraysKt.first(value)).append("..");
            byte[] value2 = bluetoothGattCharacteristic.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
            otaWorker.log(append2.append(ArraysKt.last(value2)).toString());
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            if (Intrinsics.areEqual((Object) uuid, (Object) OtaManager.Companion.getOTA_CONTROL())) {
                byte b = bluetoothGattCharacteristic.getValue()[0];
                if (b == 0) {
                    this.this$0.handler.removeMessages(1);
                    this.this$0.setMConnectionState(-6);
                    Object access$getMLock$p = this.this$0.mLock;
                    OtaWorker otaWorker2 = this.this$0;
                    synchronized (access$getMLock$p) {
                        otaWorker2.mLock.notifyAll();
                        Unit unit = Unit.INSTANCE;
                    }
                } else if (b == 3) {
                    this.this$0.handler.removeMessages(2);
                    this.this$0.setMConnectionState(-7);
                    this.this$0.notifyProgress(1, 100.0f);
                    Object access$getMLock$p2 = this.this$0.mLock;
                    OtaWorker otaWorker3 = this.this$0;
                    synchronized (access$getMLock$p2) {
                        otaWorker3.mLock.notifyAll();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } else if (Intrinsics.areEqual((Object) uuid, (Object) OtaManager.Companion.getOTA_DATA())) {
                this.this$0.handleReliableUploadResponse(bluetoothGatt);
            }
        } else {
            this.this$0.log("Send data fail status=" + i + " uuid=" + bluetoothGattCharacteristic.getUuid());
            UUID uuid2 = bluetoothGattCharacteristic.getUuid();
            if (Intrinsics.areEqual((Object) uuid2, (Object) OtaManager.Companion.getOTA_CONTROL())) {
                byte b2 = bluetoothGattCharacteristic.getValue()[0];
                if (b2 == 0) {
                    this.this$0.mError = OtaWorkerKt.OTA_ERROR_START_SEND_FAIL;
                    Object access$getMLock$p3 = this.this$0.mLock;
                    OtaWorker otaWorker4 = this.this$0;
                    synchronized (access$getMLock$p3) {
                        otaWorker4.mLock.notifyAll();
                        Unit unit3 = Unit.INSTANCE;
                    }
                } else if (b2 == 3) {
                    this.this$0.mError = OtaWorkerKt.OTA_ERROR_END_SEND_FAIL;
                    Object access$getMLock$p4 = this.this$0.mLock;
                    OtaWorker otaWorker5 = this.this$0;
                    synchronized (access$getMLock$p4) {
                        otaWorker5.mLock.notifyAll();
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
            } else if (Intrinsics.areEqual((Object) uuid2, (Object) OtaManager.Companion.getOTA_DATA())) {
                this.this$0.mError = OtaWorkerKt.OTA_ERROR_FILE_SEND_FAIL;
                Object access$getMLock$p5 = this.this$0.mLock;
                OtaWorker otaWorker6 = this.this$0;
                synchronized (access$getMLock$p5) {
                    otaWorker6.mLock.notifyAll();
                    Unit unit5 = Unit.INSTANCE;
                }
            }
        }
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        this.this$0.log("OTA  --> onDescriptorReadstatus:" + i + " uuid:" + bluetoothGattCharacteristic.getUuid() + " value:" + StringUtils.INSTANCE.binaryToHexString(bluetoothGattCharacteristic.getValue()));
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        this.this$0.log("OTA  --> onCharacteristicChanged + uuid:" + bluetoothGattCharacteristic.getUuid() + " value:" + StringUtils.INSTANCE.binaryToHexString(bluetoothGattCharacteristic.getValue()));
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        this.this$0.log("OTA  --> onMtuChanged, mtu:" + i + ", status:" + i2);
    }

    public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        this.this$0.log("OTA  --> onPhyUpdate, status:" + i3);
    }
}

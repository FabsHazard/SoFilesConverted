package com.microtech.aidexx.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.PointerIconCompat;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0017J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0017J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u001d"}, d2 = {"com/microtech/aidexx/ble/AidexBleAdapter$bluetoothGattCallback$1", "Landroid/bluetooth/BluetoothGattCallback;", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "value", "", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorWrite", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onMtuChanged", "mtu", "onPhyRead", "txPhy", "rxPhy", "onPhyUpdate", "onReadRemoteRssi", "rssi", "onReliableWriteCompleted", "onServicesDiscovered", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AidexBleAdapter.kt */
public final class AidexBleAdapter$bluetoothGattCallback$1 extends BluetoothGattCallback {
    final /* synthetic */ AidexBleAdapter this$0;

    AidexBleAdapter$bluetoothGattCallback$1(AidexBleAdapter aidexBleAdapter) {
        this.this$0 = aidexBleAdapter;
    }

    public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onPhyUpdate(bluetoothGatt, i, i2, i3);
    }

    public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onPhyRead(bluetoothGatt, i, i2, i3);
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        Handler access$getWorkHandler$p;
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onConnectionStateChange(bluetoothGatt, i, i2);
        LogUtil.Companion.eAiDEX("Connection State Change --> status:" + i + ", newState:" + i2);
        this.this$0.setConnectStatus(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        Function1<Pair<Integer, Integer>, Unit> onConnectStateChangeCallback = this.this$0.getOnConnectStateChangeCallback();
        if (onConnectStateChangeCallback != null) {
            onConnectStateChangeCallback.invoke(this.this$0.getConnectStatus());
        }
        if (i == 0) {
            this.this$0.retryNum = 0;
            if (i2 == 0) {
                Handler access$getWorkHandler$p2 = this.this$0.workHandler;
                if (access$getWorkHandler$p2 != null) {
                    access$getWorkHandler$p2.sendEmptyMessage(1006);
                }
                this.this$0.lastDisConnectTime = SystemClock.elapsedRealtime();
                Handler access$getWorkHandler$p3 = this.this$0.workHandler;
                if (access$getWorkHandler$p3 != null) {
                    access$getWorkHandler$p3.sendEmptyMessage(PointerIconCompat.TYPE_TEXT);
                }
            } else if (i2 == 2 && (access$getWorkHandler$p = this.this$0.workHandler) != null) {
                access$getWorkHandler$p.sendEmptyMessage(1004);
            }
        } else if (i != 133) {
            if (i == 257) {
                Handler access$getWorkHandler$p4 = this.this$0.workHandler;
                if (access$getWorkHandler$p4 != null) {
                    access$getWorkHandler$p4.sendEmptyMessage(1006);
                }
                Handler access$getWorkHandler$p5 = this.this$0.workHandler;
                if (access$getWorkHandler$p5 != null) {
                    access$getWorkHandler$p5.sendEmptyMessage(PointerIconCompat.TYPE_VERTICAL_TEXT);
                }
                EventBusManager.INSTANCE.send(EventBusKey.EVENT_RESTART_BLUETOOTH, true);
            }
            Handler access$getWorkHandler$p6 = this.this$0.workHandler;
            if (access$getWorkHandler$p6 != null) {
                access$getWorkHandler$p6.sendEmptyMessage(PointerIconCompat.TYPE_VERTICAL_TEXT);
            }
        } else if (this.this$0.retryNum < 2) {
            LogUtil.Companion.eAiDEX("onConnectionStateChange retryNum=" + this.this$0.retryNum);
            this.this$0.refreshConnectState(false);
            this.this$0.closeGatt();
            this.this$0.retry();
        } else {
            this.this$0.retryNum = 0;
            Handler access$getWorkHandler$p7 = this.this$0.workHandler;
            if (access$getWorkHandler$p7 != null) {
                access$getWorkHandler$p7.sendEmptyMessage(PointerIconCompat.TYPE_VERTICAL_TEXT);
            }
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onServicesDiscovered(bluetoothGatt, i);
        if (i == 0) {
            Message obtain = Message.obtain();
            obtain.what = PointerIconCompat.TYPE_NO_DROP;
            Handler access$getWorkHandler$p = this.this$0.workHandler;
            if (access$getWorkHandler$p != null) {
                access$getWorkHandler$p.sendMessage(obtain);
                return;
            }
            return;
        }
        Handler access$getWorkHandler$p2 = this.this$0.workHandler;
        if (access$getWorkHandler$p2 != null) {
            access$getWorkHandler$p2.sendEmptyMessage(PointerIconCompat.TYPE_VERTICAL_TEXT);
        }
    }

    @Deprecated(message = "Deprecated in Java")
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (Build.VERSION.SDK_INT < 33 && bluetoothGattCharacteristic != null) {
            AidexBleAdapter aidexBleAdapter = this.this$0;
            LogUtil.Companion.eAiDEX("onCharacteristicChanged under api 33 --> " + StringUtils.INSTANCE.binaryToHexString(bluetoothGattCharacteristic.getValue()));
            aidexBleAdapter.receiveData(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        if (i == 0) {
            LogUtil.Companion.eAiDEX("Characteristic write success --> uuid:" + bluetoothGattCharacteristic.getUuid());
        } else {
            LogUtil.Companion.eAiDEX("Send data fail");
        }
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        Intrinsics.checkNotNullParameter(bArr, "value");
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bArr);
        LogUtil.Companion.eAiDEX("onCharacteristicChanged --> " + StringUtils.INSTANCE.binaryToHexString(bArr));
        if (this.this$0.mBluetoothGatt == null) {
            LogUtil.Companion.eAiDEX("onCharacteristicChanged --> Gatt is null");
        } else {
            this.this$0.receiveData(bluetoothGattCharacteristic, bArr);
        }
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        Intrinsics.checkNotNullParameter(bArr, "value");
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        LogUtil.Companion.eAiDEX("onDescriptorRead --> status:" + i + " uuid:" + bluetoothGattCharacteristic.getUuid() + " value:" + StringUtils.INSTANCE.binaryToHexString(bArr));
        if (!this.this$0.checkOtaData(bluetoothGattCharacteristic)) {
            this.this$0.receiveData(bluetoothGattCharacteristic, bArr);
        }
    }

    @Deprecated(message = "Deprecated in Java")
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        if (Build.VERSION.SDK_INT < 33) {
            byte[] bArr = null;
            LogUtil.Companion.eAiDEX("onDescriptorRead --> status:" + i + " uuid" + (bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null) + " value:" + StringUtils.INSTANCE.binaryToHexString(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : null));
            if (!this.this$0.checkOtaData(bluetoothGattCharacteristic)) {
                AidexBleAdapter aidexBleAdapter = this.this$0;
                if (bluetoothGattCharacteristic != null) {
                    bArr = bluetoothGattCharacteristic.getValue();
                }
                aidexBleAdapter.receiveData(bluetoothGattCharacteristic, bArr);
            }
        }
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Intrinsics.checkNotNullParameter(bluetoothGattDescriptor, "descriptor");
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        if (i == 0) {
            LogUtil.Companion.eAiDEX("onDescriptorWrite -->Descriptor enable success. uuid:" + bluetoothGattDescriptor.getCharacteristic().getUuid());
            if (this.this$0.mCharacteristic == null || Intrinsics.areEqual((Object) bluetoothGattDescriptor.getCharacteristic(), (Object) this.this$0.mCharacteristic)) {
                Handler access$getWorkHandler$p = this.this$0.workHandler;
                if (access$getWorkHandler$p != null) {
                    access$getWorkHandler$p.sendEmptyMessage(PointerIconCompat.TYPE_ALIAS);
                    return;
                }
                return;
            }
            BluetoothGattCharacteristic access$getMCharacteristic$p = this.this$0.mCharacteristic;
            if (access$getMCharacteristic$p != null) {
                this.this$0.setNotify(access$getMCharacteristic$p);
                return;
            }
            return;
        }
        Handler access$getWorkHandler$p2 = this.this$0.workHandler;
        if (access$getWorkHandler$p2 != null) {
            access$getWorkHandler$p2.sendEmptyMessage(1006);
        }
        Handler access$getWorkHandler$p3 = this.this$0.workHandler;
        if (access$getWorkHandler$p3 != null) {
            access$getWorkHandler$p3.sendEmptyMessage(PointerIconCompat.TYPE_VERTICAL_TEXT);
        }
        LogUtil.Companion.eAiDEX("onDescriptorWrite --> Descriptor enable fail,status:" + i);
    }

    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onReliableWriteCompleted(bluetoothGatt, i);
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onReadRemoteRssi(bluetoothGatt, i, i2);
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        super.onMtuChanged(bluetoothGatt, i, i2);
    }
}

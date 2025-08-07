package com.microtech.aidexx.ble.device.entity;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/ble/device/entity/BluetoothDeviceInfo;", "", "name", "", "sn", "rssi", "", "device", "Landroid/bluetooth/BluetoothDevice;", "(Ljava/lang/String;Ljava/lang/String;ILandroid/bluetooth/BluetoothDevice;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "setDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRssi", "()I", "setRssi", "(I)V", "getSn", "setSn", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BluetoothDeviceInfo.kt */
public final class BluetoothDeviceInfo {
    private BluetoothDevice device;
    private String name;
    private int rssi;
    private String sn;

    public BluetoothDeviceInfo() {
        this((String) null, (String) null, 0, (BluetoothDevice) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BluetoothDeviceInfo copy$default(BluetoothDeviceInfo bluetoothDeviceInfo, String str, String str2, int i, BluetoothDevice bluetoothDevice, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bluetoothDeviceInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = bluetoothDeviceInfo.sn;
        }
        if ((i2 & 4) != 0) {
            i = bluetoothDeviceInfo.rssi;
        }
        if ((i2 & 8) != 0) {
            bluetoothDevice = bluetoothDeviceInfo.device;
        }
        return bluetoothDeviceInfo.copy(str, str2, i, bluetoothDevice);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.sn;
    }

    public final int component3() {
        return this.rssi;
    }

    public final BluetoothDevice component4() {
        return this.device;
    }

    public final BluetoothDeviceInfo copy(String str, String str2, int i, BluetoothDevice bluetoothDevice) {
        return new BluetoothDeviceInfo(str, str2, i, bluetoothDevice);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothDeviceInfo)) {
            return false;
        }
        BluetoothDeviceInfo bluetoothDeviceInfo = (BluetoothDeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) bluetoothDeviceInfo.name) && Intrinsics.areEqual((Object) this.sn, (Object) bluetoothDeviceInfo.sn) && this.rssi == bluetoothDeviceInfo.rssi && Intrinsics.areEqual((Object) this.device, (Object) bluetoothDeviceInfo.device);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sn;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.rssi)) * 31;
        BluetoothDevice bluetoothDevice = this.device;
        if (bluetoothDevice != null) {
            i = bluetoothDevice.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BluetoothDeviceInfo(name=" + this.name + ", sn=" + this.sn + ", rssi=" + this.rssi + ", device=" + this.device + ')';
    }

    public BluetoothDeviceInfo(String str, String str2, int i, BluetoothDevice bluetoothDevice) {
        this.name = str;
        this.sn = str2;
        this.rssi = i;
        this.device = bluetoothDevice;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BluetoothDeviceInfo(String str, String str2, int i, BluetoothDevice bluetoothDevice, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : bluetoothDevice);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getSn() {
        return this.sn;
    }

    public final void setSn(String str) {
        this.sn = str;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final void setRssi(int i) {
        this.rssi = i;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final void setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }
}

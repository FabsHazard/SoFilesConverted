package com.microtechmd.blecomm;

import android.bluetooth.BluetoothDevice;
import com.microtechmd.blecomm.controller.BleControllerInfo;

public class BleInfo {
    public BleControllerInfo bleControllerInfo;
    public BluetoothDevice device;

    public BleInfo(BleControllerInfo bleControllerInfo2, BluetoothDevice bluetoothDevice) {
        this.bleControllerInfo = bleControllerInfo2;
        this.device = bluetoothDevice;
    }

    public BleControllerInfo getBleControllerInfo() {
        return this.bleControllerInfo;
    }

    public void setBleControllerInfo(BleControllerInfo bleControllerInfo2) {
        this.bleControllerInfo = bleControllerInfo2;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public void setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }
}

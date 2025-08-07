package com.microtechmd.blecomm;

import android.bluetooth.BluetoothDevice;
import java.util.concurrent.ConcurrentHashMap;

public class BluetoothDeviceStore {
    private final ConcurrentHashMap<String, BluetoothDevice> mDeviceMap = new ConcurrentHashMap<>();

    public void add(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && !this.mDeviceMap.containsKey(bluetoothDevice.getAddress())) {
            this.mDeviceMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
        }
    }

    public void remove(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            this.mDeviceMap.remove(bluetoothDevice.getAddress());
        }
    }

    public void clear() {
        this.mDeviceMap.clear();
    }

    public ConcurrentHashMap<String, BluetoothDevice> getDeviceMap() {
        return this.mDeviceMap;
    }

    public String toString() {
        return "BluetoothLeDeviceStore{mDeviceMap=" + this.mDeviceMap + '}';
    }
}

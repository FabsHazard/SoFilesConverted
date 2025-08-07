package com.microtechmd.blecomm;

public abstract class BleAdapter {
    /* access modifiers changed from: protected */
    public static BleAdapter instance;
    protected long ptr;

    private native void constructor();

    private native void destructor();

    public abstract void executeConnect(String str);

    public abstract void executeDisconnect();

    public abstract void executeReadCharacteristic(int i);

    public abstract void executeStartScan();

    public abstract void executeStopScan();

    public abstract void executeWrite(byte[] bArr);

    public abstract void executeWriteCharacteristic(int i, byte[] bArr);

    public native int getBleState();

    public native int getCharacteristicUUID();

    public abstract BluetoothDeviceStore getDeviceStore();

    public native int getPrivateCharacteristicUUID();

    public native int getServiceUUID();

    public abstract boolean isReadyToConnect(String str);

    public native void onAdvertise(String str, int i, byte[] bArr);

    public native void onAdvertiseWithAndroidRawBytes(String str, int i, byte[] bArr);

    public native void onConnectFailure();

    public native void onConnectSuccess();

    public native void onDisconnected();

    public native void onReceiveData(int i, byte[] bArr);

    public native void onReceiveData(byte[] bArr);

    public native void onScanRespond(String str, int i, byte[] bArr);

    public abstract void setDiscoverCallback();

    public native void setDiscoverTimeoutSeconds(int i);

    public abstract void startBtScan(Boolean bool);

    public abstract void stopBtScan(Boolean bool);

    static {
        System.loadLibrary("blecomm-lib");
    }

    public static BleAdapter getInstance() {
        return instance;
    }

    protected BleAdapter() {
        constructor();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        destructor();
        super.finalize();
    }
}

package com.microtech.aidexx.ota;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OtaWorker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OtaWorker f$0;
    public final /* synthetic */ byte f$1;
    public final /* synthetic */ BluetoothGatt f$2;
    public final /* synthetic */ BluetoothGattCharacteristic f$3;

    public /* synthetic */ OtaWorker$$ExternalSyntheticLambda0(OtaWorker otaWorker, byte b, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f$0 = otaWorker;
        this.f$1 = b;
        this.f$2 = bluetoothGatt;
        this.f$3 = bluetoothGattCharacteristic;
    }

    public final void run() {
        OtaWorker.writeCommandToOtaControl$lambda$9$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

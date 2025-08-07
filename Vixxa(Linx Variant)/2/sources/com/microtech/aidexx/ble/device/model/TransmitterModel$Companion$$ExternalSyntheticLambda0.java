package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.ble.device.model.TransmitterModel;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtechmd.blecomm.controller.BleController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterModel$Companion$$ExternalSyntheticLambda0 implements BleController.MessageCallback {
    public final /* synthetic */ TransmitterEntity f$0;

    public /* synthetic */ TransmitterModel$Companion$$ExternalSyntheticLambda0(TransmitterEntity transmitterEntity) {
        this.f$0 = transmitterEntity;
    }

    public final void onReceive(int i, boolean z, byte[] bArr) {
        TransmitterModel.Companion.instance$lambda$1$lambda$0(this.f$0, i, z, bArr);
    }
}

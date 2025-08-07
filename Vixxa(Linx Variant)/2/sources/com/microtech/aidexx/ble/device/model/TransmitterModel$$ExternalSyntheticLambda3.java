package com.microtech.aidexx.ble.device.model;

import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterModel$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ TransmitterModel f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ TransmitterModel$$ExternalSyntheticLambda3(TransmitterModel transmitterModel, List list, String str) {
        this.f$0 = transmitterModel;
        this.f$1 = list;
        this.f$2 = str;
    }

    public final void run() {
        TransmitterModel.saveCalHistory$lambda$21(this.f$0, this.f$1, this.f$2);
    }
}

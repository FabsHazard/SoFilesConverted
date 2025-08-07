package com.microtech.aidexx.ble.device.model;

import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterModel$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ TransmitterModel f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ TransmitterModel$$ExternalSyntheticLambda6(TransmitterModel transmitterModel, List list) {
        this.f$0 = transmitterModel;
        this.f$1 = list;
    }

    public final void run() {
        TransmitterModel.saveRawHistory$lambda$23(this.f$0, this.f$1);
    }
}

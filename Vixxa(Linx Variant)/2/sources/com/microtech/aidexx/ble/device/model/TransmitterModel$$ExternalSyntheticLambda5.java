package com.microtech.aidexx.ble.device.model;

import java.util.Date;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterModel$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ TransmitterModel f$0;
    public final /* synthetic */ Date f$1;

    public /* synthetic */ TransmitterModel$$ExternalSyntheticLambda5(TransmitterModel transmitterModel, Date date) {
        this.f$0 = transmitterModel;
        this.f$1 = date;
    }

    public final void run() {
        TransmitterModel.onMessage$lambda$3$lambda$2(this.f$0, this.f$1);
    }
}

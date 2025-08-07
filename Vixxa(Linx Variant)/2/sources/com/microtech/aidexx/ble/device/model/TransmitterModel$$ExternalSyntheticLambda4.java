package com.microtech.aidexx.ble.device.model;

import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterModel$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ TransmitterModel f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ TransmitterModel$$ExternalSyntheticLambda4(TransmitterModel transmitterModel, List list, String str, String str2) {
        this.f$0 = transmitterModel;
        this.f$1 = list;
        this.f$2 = str;
        this.f$3 = str2;
    }

    public final void run() {
        TransmitterModel.saveBriefHistory$lambda$22(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

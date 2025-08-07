package com.microtech.aidexx.ui.pair;

import io.objectbox.reactive.DataObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterActivity$$ExternalSyntheticLambda0 implements DataObserver {
    public final /* synthetic */ TransmitterActivity f$0;

    public /* synthetic */ TransmitterActivity$$ExternalSyntheticLambda0(TransmitterActivity transmitterActivity) {
        this.f$0 = transmitterActivity;
    }

    public final void onData(Object obj) {
        TransmitterActivity.loadSavedTransmitter$lambda$7(this.f$0, (Class) obj);
    }
}

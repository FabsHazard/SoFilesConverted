package com.microtech.aidexx.ui.pair;

import io.objectbox.reactive.DataObserver;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterActivity$$ExternalSyntheticLambda1 implements DataObserver {
    public final /* synthetic */ TransmitterActivity f$0;

    public /* synthetic */ TransmitterActivity$$ExternalSyntheticLambda1(TransmitterActivity transmitterActivity) {
        this.f$0 = transmitterActivity;
    }

    public final void onData(Object obj) {
        TransmitterActivity.loadSavedTransmitter$lambda$8(this.f$0, (List) obj);
    }
}

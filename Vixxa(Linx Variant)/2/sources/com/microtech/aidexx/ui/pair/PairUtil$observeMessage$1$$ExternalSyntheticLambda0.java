package com.microtech.aidexx.ui.pair;

import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PairUtil$observeMessage$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte[] f$0;
    public final /* synthetic */ DeviceModel f$1;
    public final /* synthetic */ CoroutineScope f$2;

    public /* synthetic */ PairUtil$observeMessage$1$$ExternalSyntheticLambda0(byte[] bArr, DeviceModel deviceModel, CoroutineScope coroutineScope) {
        this.f$0 = bArr;
        this.f$1 = deviceModel;
        this.f$2 = coroutineScope;
    }

    public final void run() {
        PairUtil$observeMessage$1.onMessage$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}

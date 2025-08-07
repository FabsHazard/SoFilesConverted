package com.microtech.aidexx.ble;

import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AidexBleAdapter$$ExternalSyntheticLambda0 implements BleController.DiscoveredCallback {
    public final /* synthetic */ AidexBleAdapter f$0;

    public /* synthetic */ AidexBleAdapter$$ExternalSyntheticLambda0(AidexBleAdapter aidexBleAdapter) {
        this.f$0 = aidexBleAdapter;
    }

    public final void onDiscovered(BleControllerInfo bleControllerInfo) {
        AidexBleAdapter.setDiscoverCallback$lambda$0(this.f$0, bleControllerInfo);
    }
}

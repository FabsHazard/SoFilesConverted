package com.microtech.aidexx.ui.pair;

import androidx.lifecycle.Observer;
import com.microtechmd.blecomm.controller.BleControllerProxy;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PairCheckDialog$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ BleControllerProxy f$0;
    public final /* synthetic */ PairCheckDialog f$1;

    public /* synthetic */ PairCheckDialog$$ExternalSyntheticLambda2(BleControllerProxy bleControllerProxy, PairCheckDialog pairCheckDialog) {
        this.f$0 = bleControllerProxy;
        this.f$1 = pairCheckDialog;
    }

    public final void onChanged(Object obj) {
        PairCheckDialog.build$lambda$2(this.f$0, this.f$1, (String) obj);
    }
}

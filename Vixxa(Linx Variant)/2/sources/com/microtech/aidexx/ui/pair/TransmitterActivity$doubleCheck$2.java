package com.microtech.aidexx.ui.pair;

import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "info", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
final class TransmitterActivity$doubleCheck$2 extends Lambda implements Function1<BleControllerProxy, Unit> {
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$doubleCheck$2(TransmitterActivity transmitterActivity) {
        super(1);
        this.this$0 = transmitterActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BleControllerProxy) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BleControllerProxy bleControllerProxy) {
        Intrinsics.checkNotNullParameter(bleControllerProxy, TransmitterActivityKt.BLE_INFO);
        this.this$0.executePair(bleControllerProxy);
    }
}

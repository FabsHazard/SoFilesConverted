package com.microtech.aidexx.ble.device;

import com.microtech.aidexx.ble.device.model.TransmitterModel;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtechmd.blecomm.controller.AidexXController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterManager.kt */
final class TransmitterManager$loadTransmitter$2$1$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TransmitterEntity $newEntity;
    final /* synthetic */ TransmitterManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterManager$loadTransmitter$2$1$1$2(TransmitterEntity transmitterEntity, TransmitterManager transmitterManager) {
        super(0);
        this.$newEntity = transmitterEntity;
        this.this$0 = transmitterManager;
    }

    public final void invoke() {
        if (this.$newEntity.getDeviceType() == 2) {
            TransmitterManager transmitterManager = this.this$0;
            TransmitterModel.Companion companion = TransmitterModel.Companion;
            TransmitterEntity transmitterEntity = this.$newEntity;
            AidexXController instance = AidexXController.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
            transmitterManager.set(companion.instance(transmitterEntity, instance));
        }
    }
}

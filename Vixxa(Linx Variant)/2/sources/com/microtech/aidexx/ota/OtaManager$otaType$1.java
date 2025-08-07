package com.microtech.aidexx.ota;

import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager", f = "OtaManager.kt", i = {0, 0, 0}, l = {217}, m = "otaType", n = {"needAppUpdate", "it", "name"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: OtaManager.kt */
final class OtaManager$otaType$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtaManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$otaType$1(OtaManager otaManager, Continuation<? super OtaManager$otaType$1> continuation) {
        super(continuation);
        this.this$0 = otaManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.otaType((DeviceModel) null, this);
    }
}

package com.microtech.aidexx.ota;

import androidx.lifecycle.LifecycleOwner;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager", f = "OtaManager.kt", i = {0, 0, 0, 0}, l = {121}, m = "checkIfNeedOta", n = {"this", "lifecycleOwner", "otaProgressListener", "mac"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: OtaManager.kt */
final class OtaManager$checkIfNeedOta$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtaManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$checkIfNeedOta$1(OtaManager otaManager, Continuation<? super OtaManager$checkIfNeedOta$1> continuation) {
        super(continuation);
        this.this$0 = otaManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkIfNeedOta((DeviceModel) null, (LifecycleOwner) null, (OtaProgressListener) null, this);
    }
}

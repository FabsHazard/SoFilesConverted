package com.microtech.aidexx.ota;

import com.microtech.aidexx.db.entity.OtaResourceEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager", f = "OtaManager.kt", i = {0}, l = {352, 356}, m = "saveOtaResource", n = {"entity"}, s = {"L$0"})
/* compiled from: OtaManager.kt */
final class OtaManager$saveOtaResource$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtaManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$saveOtaResource$1(OtaManager otaManager, Continuation<? super OtaManager$saveOtaResource$1> continuation) {
        super(continuation);
        this.this$0 = otaManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveOtaResource((OtaResourceEntity) null, false, this);
    }
}

package com.microtech.aidexx.ota;

import com.microtech.aidexx.db.entity.OtaResourceEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager", f = "OtaManager.kt", i = {0, 0}, l = {328}, m = "isNeedDownLoad", n = {"this", "entity"}, s = {"L$0", "L$1"})
/* compiled from: OtaManager.kt */
final class OtaManager$isNeedDownLoad$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtaManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$isNeedDownLoad$1(OtaManager otaManager, Continuation<? super OtaManager$isNeedDownLoad$1> continuation) {
        super(continuation);
        this.this$0 = otaManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isNeedDownLoad((OtaResourceEntity) null, this);
    }
}

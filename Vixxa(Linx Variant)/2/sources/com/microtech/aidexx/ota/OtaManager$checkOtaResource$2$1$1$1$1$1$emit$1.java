package com.microtech.aidexx.ota;

import com.microtech.aidexx.common.net.repository.ApiRepository;
import com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1", f = "OtaManager.kt", i = {0, 0}, l = {283, 296, 300}, m = "emit", n = {"this", "ret"}, s = {"L$0", "L$1"})
/* compiled from: OtaManager.kt */
final class OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OtaManager$checkOtaResource$2$1$1$1$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1(OtaManager$checkOtaResource$2$1$1$1$1.AnonymousClass1<? super T> r1, Continuation<? super OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApiRepository.NetResult<String>) null, (Continuation<? super Unit>) this);
    }
}

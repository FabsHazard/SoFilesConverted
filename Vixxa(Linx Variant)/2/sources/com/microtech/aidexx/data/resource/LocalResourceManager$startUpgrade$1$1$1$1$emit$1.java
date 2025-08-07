package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.common.net.repository.ApiRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1", f = "LocalResourceManager.kt", i = {0, 0}, l = {106}, m = "emit", n = {"this", "ret"}, s = {"L$0", "L$1"})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$startUpgrade$1$1$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalResourceManager$startUpgrade$1$1$1$1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$startUpgrade$1$1$1$1$emit$1(LocalResourceManager$startUpgrade$1$1$1$1<? super T> localResourceManager$startUpgrade$1$1$1$1, Continuation<? super LocalResourceManager$startUpgrade$1$1$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = localResourceManager$startUpgrade$1$1$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApiRepository.NetResult<String>) null, (Continuation<? super Unit>) this);
    }
}

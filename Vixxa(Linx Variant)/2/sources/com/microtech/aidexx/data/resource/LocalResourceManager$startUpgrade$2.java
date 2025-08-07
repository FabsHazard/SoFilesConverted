package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager", f = "LocalResourceManager.kt", i = {0, 0}, l = {203}, m = "startUpgrade", n = {"zipFilePath", "unzipPath"}, s = {"L$0", "L$1"})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$startUpgrade$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalResourceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$startUpgrade$2(LocalResourceManager localResourceManager, Continuation<? super LocalResourceManager$startUpgrade$2> continuation) {
        super(continuation);
        this.this$0 = localResourceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startUpgrade((String) null, (String) null, this);
    }
}

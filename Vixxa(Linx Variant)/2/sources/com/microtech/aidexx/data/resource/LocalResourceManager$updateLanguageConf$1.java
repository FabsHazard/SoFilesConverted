package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager", f = "LocalResourceManager.kt", i = {0, 0, 0, 0, 1, 1, 2}, l = {437, 439, 457}, m = "updateLanguageConf", n = {"this", "result", "it", "languageRepo", "this", "result", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0"})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$updateLanguageConf$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalResourceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$updateLanguageConf$1(LocalResourceManager localResourceManager, Continuation<? super LocalResourceManager$updateLanguageConf$1> continuation) {
        super(continuation);
        this.this$0 = localResourceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateLanguageConf((String) null, (String) null, this);
    }
}

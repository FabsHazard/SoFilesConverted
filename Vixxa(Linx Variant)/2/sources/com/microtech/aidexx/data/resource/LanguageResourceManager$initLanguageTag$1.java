package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LanguageResourceManager", f = "LanguageResourceManager.kt", i = {0, 0, 0, 0, 0}, l = {94}, m = "initLanguageTag", n = {"language", "script", "region", "sysStandardTag", "sameLanguageCodeList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: LanguageResourceManager.kt */
final class LanguageResourceManager$initLanguageTag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LanguageResourceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LanguageResourceManager$initLanguageTag$1(LanguageResourceManager languageResourceManager, Continuation<? super LanguageResourceManager$initLanguageTag$1> continuation) {
        super(continuation);
        this.this$0 = languageResourceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initLanguageTag(this);
    }
}

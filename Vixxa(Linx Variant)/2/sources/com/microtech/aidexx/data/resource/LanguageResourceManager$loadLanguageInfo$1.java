package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LanguageResourceManager", f = "LanguageResourceManager.kt", i = {0}, l = {65}, m = "loadLanguageInfo", n = {"curLanguage"}, s = {"L$0"})
/* compiled from: LanguageResourceManager.kt */
final class LanguageResourceManager$loadLanguageInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LanguageResourceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LanguageResourceManager$loadLanguageInfo$1(LanguageResourceManager languageResourceManager, Continuation<? super LanguageResourceManager$loadLanguageInfo$1> continuation) {
        super(continuation);
        this.this$0 = languageResourceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLanguageInfo(this);
    }
}

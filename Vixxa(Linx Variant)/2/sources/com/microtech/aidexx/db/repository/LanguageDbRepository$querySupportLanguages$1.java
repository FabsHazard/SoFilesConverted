package com.microtech.aidexx.db.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.db.repository.LanguageDbRepository", f = "LanguageDbRepository.kt", i = {0}, l = {27, 29}, m = "querySupportLanguages", n = {"this"}, s = {"L$0"})
/* compiled from: LanguageDbRepository.kt */
final class LanguageDbRepository$querySupportLanguages$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LanguageDbRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LanguageDbRepository$querySupportLanguages$1(LanguageDbRepository languageDbRepository, Continuation<? super LanguageDbRepository$querySupportLanguages$1> continuation) {
        super(continuation);
        this.this$0 = languageDbRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.querySupportLanguages(this);
    }
}

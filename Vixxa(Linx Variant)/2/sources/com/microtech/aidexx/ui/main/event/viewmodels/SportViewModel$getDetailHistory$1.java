package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.SportViewModel", f = "SportViewModel.kt", i = {}, l = {60}, m = "getDetailHistory", n = {}, s = {})
/* compiled from: SportViewModel.kt */
final class SportViewModel$getDetailHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SportViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SportViewModel$getDetailHistory$1(SportViewModel sportViewModel, Continuation<? super SportViewModel$getDetailHistory$1> continuation) {
        super(continuation);
        this.this$0 = sportViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDetailHistory(this);
    }
}

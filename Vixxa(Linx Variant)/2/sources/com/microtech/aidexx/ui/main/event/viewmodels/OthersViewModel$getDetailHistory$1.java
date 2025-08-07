package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel", f = "OthersViewModel.kt", i = {}, l = {52}, m = "getDetailHistory", n = {}, s = {})
/* compiled from: OthersViewModel.kt */
final class OthersViewModel$getDetailHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OthersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OthersViewModel$getDetailHistory$1(OthersViewModel othersViewModel, Continuation<? super OthersViewModel$getDetailHistory$1> continuation) {
        super(continuation);
        this.this$0 = othersViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDetailHistory(this);
    }
}

package com.microtech.aidexx.ui.account;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel", f = "AccountViewModel.kt", i = {0}, l = {251}, m = "testData", n = {"data"}, s = {"L$0"})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$testData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$testData$1(AccountViewModel accountViewModel, Continuation<? super AccountViewModel$testData$1> continuation) {
        super(continuation);
        this.this$0 = accountViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.testData((String) null, 0, this);
    }
}

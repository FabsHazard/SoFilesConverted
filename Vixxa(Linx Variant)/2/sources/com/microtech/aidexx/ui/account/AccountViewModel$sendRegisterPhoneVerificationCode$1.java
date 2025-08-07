package com.microtech.aidexx.ui.account;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel", f = "AccountViewModel.kt", i = {}, l = {137}, m = "sendRegisterPhoneVerificationCode", n = {}, s = {})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$sendRegisterPhoneVerificationCode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$sendRegisterPhoneVerificationCode$1(AccountViewModel accountViewModel, Continuation<? super AccountViewModel$sendRegisterPhoneVerificationCode$1> continuation) {
        super(continuation);
        this.this$0 = accountViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendRegisterPhoneVerificationCode((String) null, this);
    }
}

package com.microtech.aidexx.common.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.user.UserInfoManager", f = "UserInfoManager.kt", i = {0}, l = {131}, m = "updateProfile", n = {"this"}, s = {"L$0"})
/* compiled from: UserInfoManager.kt */
final class UserInfoManager$updateProfile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserInfoManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserInfoManager$updateProfile$1(UserInfoManager userInfoManager, Continuation<? super UserInfoManager$updateProfile$1> continuation) {
        super(continuation);
        this.this$0 = userInfoManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateProfile((String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Boolean) null, this);
    }
}

package com.microtech.aidexx.common.user;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.user.UserInfoManager", f = "UserInfoManager.kt", i = {0, 0, 1}, l = {182, 189}, m = "onUserExit", n = {"this", "context", "context"}, s = {"L$0", "L$1", "L$0"})
/* compiled from: UserInfoManager.kt */
final class UserInfoManager$onUserExit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserInfoManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserInfoManager$onUserExit$1(UserInfoManager userInfoManager, Continuation<? super UserInfoManager$onUserExit$1> continuation) {
        super(continuation);
        this.this$0 = userInfoManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onUserExit((Context) null, this);
    }
}

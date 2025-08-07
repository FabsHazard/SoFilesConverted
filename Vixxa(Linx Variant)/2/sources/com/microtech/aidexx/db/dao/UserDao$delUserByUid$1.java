package com.microtech.aidexx.db.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.db.dao.UserDao", f = "UserDao.kt", i = {}, l = {37}, m = "delUserByUid", n = {}, s = {})
/* compiled from: UserDao.kt */
final class UserDao$delUserByUid$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserDao$delUserByUid$1(UserDao userDao, Continuation<? super UserDao$delUserByUid$1> continuation) {
        super(continuation);
        this.this$0 = userDao;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.delUserByUid((String) null, this);
    }
}

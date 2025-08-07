package com.microtech.aidexx.db.repository;

import com.microtech.aidexx.db.dao.UserDao;
import com.microtech.aidexx.db.entity.UserEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/db/repository/AccountDbRepository;", "", "()V", "getUserInfoByUid", "Lcom/microtech/aidexx/db/entity/UserEntity;", "uid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeUserByUId", "", "saveUser", "", "userEntity", "(Lcom/microtech/aidexx/db/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccountDbRepository.kt */
public final class AccountDbRepository {
    public static final AccountDbRepository INSTANCE = new AccountDbRepository();

    private AccountDbRepository() {
    }

    public final Object saveUser(UserEntity userEntity, Continuation<? super Long> continuation) {
        return UserDao.INSTANCE.saveUser(userEntity, continuation);
    }

    public final Object getUserInfoByUid(String str, Continuation<? super UserEntity> continuation) {
        return UserDao.INSTANCE.getUserInfoByUid(str, continuation);
    }

    public final Object removeUserByUId(String str, Continuation<? super Boolean> continuation) {
        return UserDao.INSTANCE.delUserByUid(str, continuation);
    }

    public final Object removeAll(Continuation<? super Unit> continuation) {
        return UserDao.INSTANCE.removeAll(continuation);
    }
}

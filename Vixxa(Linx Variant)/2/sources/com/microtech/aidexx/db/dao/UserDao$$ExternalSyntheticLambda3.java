package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.entity.UserEntity;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserDao$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ UserEntity f$0;

    public /* synthetic */ UserDao$$ExternalSyntheticLambda3(UserEntity userEntity) {
        this.f$0 = userEntity;
    }

    public final Object call() {
        return UserDao.saveUser$lambda$0(this.f$0);
    }
}

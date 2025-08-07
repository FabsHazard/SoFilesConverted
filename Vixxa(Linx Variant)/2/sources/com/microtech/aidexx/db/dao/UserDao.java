package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.db.entity.UserEntity_;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/db/dao/UserDao;", "", "()V", "box", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/UserEntity;", "getBox", "()Lio/objectbox/Box;", "box$delegate", "Lkotlin/Lazy;", "delUserByUid", "", "uid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserInfoByUid", "userId", "removeAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUser", "", "user", "(Lcom/microtech/aidexx/db/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserDao.kt */
public final class UserDao {
    public static final UserDao INSTANCE = new UserDao();
    private static final Lazy box$delegate = LazyKt.lazy(UserDao$box$2.INSTANCE);

    private UserDao() {
    }

    private final Box<UserEntity> getBox() {
        return (Box) box$delegate.getValue();
    }

    public final Object saveUser(UserEntity userEntity, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new UserDao$$ExternalSyntheticLambda3(userEntity), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long saveUser$lambda$0(UserEntity userEntity) {
        Intrinsics.checkNotNullParameter(userEntity, "$user");
        return Long.valueOf(INSTANCE.getBox().put(userEntity));
    }

    public final Object getUserInfoByUid(String str, Continuation<? super UserEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new UserDao$$ExternalSyntheticLambda1(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final UserEntity getUserInfoByUid$lambda$1(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        QueryBuilder<UserEntity> query = INSTANCE.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Property<UserEntity> property = UserEntity_.userId;
        Intrinsics.checkNotNullExpressionValue(property, "userId");
        return (UserEntity) ExtendsKt.equal(query, property, str).orderDesc(UserEntity_.idx).build().findFirst();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object delUserByUid(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.db.dao.UserDao$delUserByUid$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.db.dao.UserDao$delUserByUid$1 r0 = (com.microtech.aidexx.db.dao.UserDao$delUserByUid$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.db.dao.UserDao$delUserByUid$1 r0 = new com.microtech.aidexx.db.dao.UserDao$delUserByUid$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.db.ObjectBox r6 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.db.dao.UserDao$$ExternalSyntheticLambda2 r2 = new com.microtech.aidexx.db.dao.UserDao$$ExternalSyntheticLambda2
            r2.<init>(r5)
            io.objectbox.BoxStore r5 = r6.getStore()
            r0.label = r3
            java.lang.Object r6 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r5, r2, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r6 == 0) goto L_0x0052
            boolean r5 = r6.booleanValue()
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.dao.UserDao.delUserByUid(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Boolean delUserByUid$lambda$3(String str) {
        Intrinsics.checkNotNullParameter(str, "$uid");
        QueryBuilder<UserEntity> query = INSTANCE.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        Property<UserEntity> property = UserEntity_.userId;
        Intrinsics.checkNotNullExpressionValue(property, "userId");
        ExtendsKt.equal(query, property, str);
        Query<UserEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return Boolean.valueOf(build.remove() > 0);
    }

    public final Object removeAll(Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new UserDao$$ExternalSyntheticLambda0(), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit removeAll$lambda$4() {
        INSTANCE.getBox().removeAll();
        return Unit.INSTANCE;
    }
}

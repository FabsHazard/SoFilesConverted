package com.microtech.aidexx.common.user;

import com.microtech.aidexx.db.entity.UserEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.user.UserInfoManager$refreshUserInfo$2", f = "UserInfoManager.kt", i = {}, l = {158, 168}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UserInfoManager.kt */
final class UserInfoManager$refreshUserInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ UserEntity $content;
    int label;
    final /* synthetic */ UserInfoManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserInfoManager$refreshUserInfo$2(UserEntity userEntity, UserInfoManager userInfoManager, Continuation<? super UserInfoManager$refreshUserInfo$2> continuation) {
        super(2, continuation);
        this.$content = userEntity;
        this.this$0 = userInfoManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInfoManager$refreshUserInfo$2(this.$content, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((UserInfoManager$refreshUserInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005d
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0038
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.db.repository.AccountDbRepository r6 = com.microtech.aidexx.db.repository.AccountDbRepository.INSTANCE
            com.microtech.aidexx.db.entity.UserEntity r1 = r5.$content
            java.lang.String r1 = r1.getUserId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r6.getUserInfoByUid(r1, r4)
            if (r6 != r0) goto L_0x0038
            return r0
        L_0x0038:
            com.microtech.aidexx.db.entity.UserEntity r6 = (com.microtech.aidexx.db.entity.UserEntity) r6
            if (r6 != 0) goto L_0x003f
            com.microtech.aidexx.db.entity.UserEntity r6 = r5.$content
            goto L_0x004a
        L_0x003f:
            com.microtech.aidexx.db.entity.UserEntity r1 = r5.$content
            long r3 = r6.getIdx()
            r1.setIdx(r3)
            com.microtech.aidexx.db.entity.UserEntity r6 = r5.$content
        L_0x004a:
            com.microtech.aidexx.common.user.UserInfoManager r1 = r5.this$0
            r1.userEntity = r6
            com.microtech.aidexx.db.repository.AccountDbRepository r1 = com.microtech.aidexx.db.repository.AccountDbRepository.INSTANCE
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r6 = r1.saveUser(r6, r3)
            if (r6 != r0) goto L_0x005d
            return r0
        L_0x005d:
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x0068
            java.lang.Number r6 = (java.lang.Number) r6
            long r0 = r6.longValue()
            goto L_0x006a
        L_0x0068:
            r0 = -1
        L_0x006a:
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.user.UserInfoManager$refreshUserInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

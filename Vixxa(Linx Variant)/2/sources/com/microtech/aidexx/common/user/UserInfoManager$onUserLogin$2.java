package com.microtech.aidexx.common.user;

import com.microtech.aidexx.db.entity.UserEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.user.UserInfoManager$onUserLogin$2", f = "UserInfoManager.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UserInfoManager.kt */
final class UserInfoManager$onUserLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ UserEntity $content;
    int label;
    final /* synthetic */ UserInfoManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserInfoManager$onUserLogin$2(UserInfoManager userInfoManager, UserEntity userEntity, Continuation<? super UserInfoManager$onUserLogin$2> continuation) {
        super(2, continuation);
        this.this$0 = userInfoManager;
        this.$content = userEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInfoManager$onUserLogin$2(this.this$0, this.$content, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((UserInfoManager$onUserLogin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.refreshUserInfo(this.$content, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}

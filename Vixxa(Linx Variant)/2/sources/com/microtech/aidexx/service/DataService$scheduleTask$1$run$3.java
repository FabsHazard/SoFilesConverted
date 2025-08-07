package com.microtech.aidexx.service;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.repository.AccountRepository;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.UserEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.service.DataService$scheduleTask$1$run$3", f = "DataService.kt", i = {}, l = {79, 81}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DataService.kt */
final class DataService$scheduleTask$1$run$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    DataService$scheduleTask$1$run$3(Continuation<? super DataService$scheduleTask$1$run$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataService$scheduleTask$1$run$3(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataService$scheduleTask$1$run$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
            if (userEntity != null && userEntity.isGuideStateChange()) {
                AccountRepository accountRepository = AccountRepository.INSTANCE;
                UserEntity userEntity2 = UserInfoManager.Companion.instance().getUserEntity();
                Integer boxInt = userEntity2 != null ? Boxing.boxInt(userEntity2.isGuide()) : null;
                this.label = 1;
                obj2 = AccountRepository.updateUserInformation$default(accountRepository, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, boxInt, (Integer) null, (Integer) null, this, 3670015, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((ApiResult) obj2) instanceof ApiResult.Success) {
            this.label = 2;
            if (UserInfoManager.updateProfile$default(UserInfoManager.Companion.instance(), (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, Boxing.boxBoolean(false), this, 1048575, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}

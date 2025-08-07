package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.repository.AccountRepository;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.AccountSecurityActivity$logout$1", f = "AccountSecurityActivity.kt", i = {}, l = {121, 123}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountSecurityActivity.kt */
final class AccountSecurityActivity$logout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountSecurityActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountSecurityActivity$logout$1(AccountSecurityActivity accountSecurityActivity, Continuation<? super AccountSecurityActivity$logout$1> continuation) {
        super(2, continuation);
        this.this$0 = accountSecurityActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountSecurityActivity$logout$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountSecurityActivity$logout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AccountRepository.INSTANCE.logout(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LogUtil.Companion.e$default(LogUtil.Companion, "logout = " + ((ApiResult) obj), (String) null, 2, (Object) null);
        this.label = 2;
        if (UserInfoManager.Companion.instance().onUserExit(this.this$0, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}

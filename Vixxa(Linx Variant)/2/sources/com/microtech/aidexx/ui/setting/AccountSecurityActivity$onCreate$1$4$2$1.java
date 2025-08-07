package com.microtech.aidexx.ui.setting;

import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.repository.AccountRepository;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.AccountSecurityActivity$onCreate$1$4$2$1", f = "AccountSecurityActivity.kt", i = {}, l = {83, 86}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountSecurityActivity.kt */
final class AccountSecurityActivity$onCreate$1$4$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $map;
    int label;
    final /* synthetic */ AccountSecurityActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountSecurityActivity$onCreate$1$4$2$1(Map<String, String> map, AccountSecurityActivity accountSecurityActivity, Continuation<? super AccountSecurityActivity$onCreate$1$4$2$1> continuation) {
        super(2, continuation);
        this.$map = map;
        this.this$0 = accountSecurityActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountSecurityActivity$onCreate$1$4$2$1(this.$map, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountSecurityActivity$onCreate$1$4$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AccountRepository.INSTANCE.cancelAccount(this.$map, this);
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
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            WaitDialog.dismiss();
            final AccountSecurityActivity accountSecurityActivity = this.this$0;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (apiResult instanceof ApiResult.Failure) {
            WaitDialog.dismiss();
            ApiResult.Failure failure = (ApiResult.Failure) apiResult;
            if (failure.getMsg().length() > 0) {
                ExtendsKt.toastShort(failure.getMsg());
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.AccountSecurityActivity$onCreate$1$4$2$1$1", f = "AccountSecurityActivity.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.AccountSecurityActivity$onCreate$1$4$2$1$1  reason: invalid class name */
    /* compiled from: AccountSecurityActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(accountSecurityActivity, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Dialogs.INSTANCE.showSuccess(accountSecurityActivity.getString(R.string.com_actionState_success, new Object[]{accountSecurityActivity.getString(R.string.user_sign_logoff)}));
                this.label = 1;
                if (DelayKt.delay(PairUtilKt.DELAY_A_WHILE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            accountSecurityActivity.logout();
            return Unit.INSTANCE;
        }
    }
}

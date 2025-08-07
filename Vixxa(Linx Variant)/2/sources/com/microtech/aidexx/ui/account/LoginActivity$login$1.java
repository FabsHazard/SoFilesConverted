package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.LoginActivity$login$1", f = "LoginActivity.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginActivity.kt */
final class LoginActivity$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $password;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ LoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginActivity$login$1(LoginActivity loginActivity, String str, String str2, int i, Continuation<? super LoginActivity$login$1> continuation) {
        super(2, continuation);
        this.this$0 = loginActivity;
        this.$name = str;
        this.$password = str2;
        this.$type = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginActivity$login$1(this.this$0, this.$name, this.$password, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginActivity$login$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Pair<Integer, String>> login = ((AccountViewModel) this.this$0.getViewModel()).login(this.$name, this.$password, "", this.$type);
            final LoginActivity loginActivity = this.this$0;
            this.label = 1;
            if (login.collect(new FlowCollector() {
                public final Object emit(Pair<Integer, String> pair, Continuation<? super Unit> continuation) {
                    Dialogs.INSTANCE.dismissWait();
                    int intValue = pair.getFirst().intValue();
                    if (intValue == -2) {
                        ExtendsKt.toastShort(pair.getSecond());
                    } else if (intValue == -1) {
                        String string = loginActivity.getString(R.string.com_actionState_failure, new Object[]{loginActivity.getString(R.string.com_action_login)});
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ExtendsKt.toastShort(string);
                    } else if (intValue == 1) {
                        Dialogs.INSTANCE.showWait(loginActivity.getString(R.string.com_downloading));
                    } else if (intValue == 2) {
                        LoginActivity.onLoginSuccess$default(loginActivity, false, 1, (Object) null);
                    } else if (intValue == 3) {
                        loginActivity.onLoginSuccess(true);
                    }
                    LogUtil.Companion.d(pair.getSecond(), "LoginActivity");
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}

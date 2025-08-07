package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.EncryptUtils;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.account.RegisterActivity$register$1", f = "RegisterActivity.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RegisterActivity.kt */
final class RegisterActivity$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $password;
    final /* synthetic */ String $verCode;
    int label;
    final /* synthetic */ RegisterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterActivity$register$1(RegisterActivity registerActivity, String str, String str2, String str3, Continuation<? super RegisterActivity$register$1> continuation) {
        super(2, continuation);
        this.this$0 = registerActivity;
        this.$name = str;
        this.$password = str2;
        this.$verCode = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RegisterActivity$register$1(this.this$0, this.$name, this.$password, this.$verCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RegisterActivity$register$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Pair<Integer, String>> login = ((AccountViewModel) this.this$0.getViewModel()).login(this.$name, EncryptUtils.Companion.md5(this.$password), this.$verCode, 4);
            final RegisterActivity registerActivity = this.this$0;
            this.label = 1;
            if (login.collect(new FlowCollector() {
                public final Object emit(Pair<Integer, String> pair, Continuation<? super Unit> continuation) {
                    Dialogs.INSTANCE.dismissWait();
                    int intValue = pair.getFirst().intValue();
                    if (intValue == -2) {
                        ExtendsKt.toastShort(pair.getSecond());
                    } else if (intValue == -1) {
                        String string = registerActivity.getString(R.string.com_actionState_failure, new Object[]{registerActivity.getString(R.string.com_action_login)});
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ExtendsKt.toastShort(string);
                    } else if (intValue == 1) {
                        Dialogs.INSTANCE.showWait(registerActivity.getString(R.string.com_downloading));
                    } else if (intValue == 2) {
                        RegisterActivity.onLoginSuccess$default(registerActivity, false, 1, (Object) null);
                    } else if (intValue == 3) {
                        registerActivity.guide();
                    }
                    LogUtil.Companion.d(pair.getSecond(), "RegisterActivity");
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

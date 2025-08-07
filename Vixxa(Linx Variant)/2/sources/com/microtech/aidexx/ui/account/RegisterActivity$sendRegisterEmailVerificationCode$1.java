package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.R;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.RegisterActivity$sendRegisterEmailVerificationCode$1", f = "RegisterActivity.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RegisterActivity.kt */
final class RegisterActivity$sendRegisterEmailVerificationCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    int label;
    final /* synthetic */ RegisterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterActivity$sendRegisterEmailVerificationCode$1(RegisterActivity registerActivity, String str, Continuation<? super RegisterActivity$sendRegisterEmailVerificationCode$1> continuation) {
        super(2, continuation);
        this.this$0 = registerActivity;
        this.$email = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RegisterActivity$sendRegisterEmailVerificationCode$1(this.this$0, this.$email, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RegisterActivity$sendRegisterEmailVerificationCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((AccountViewModel) this.this$0.getViewModel()).sendRegisterEmailVerificationCode(StringsKt.trim((CharSequence) this.$email).toString(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            Dialogs.INSTANCE.dismissWait();
        } else {
            Dialogs dialogs = Dialogs.INSTANCE;
            String str = (String) pair.getSecond();
            if (str == null) {
                str = this.this$0.getString(R.string.com_network_failure);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
            Dialogs.showError$default(dialogs, str, 0, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }
}

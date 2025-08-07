package com.microtech.aidexx.ui.setting.profile;

import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
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
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ChangeAccountActivity$doIt$1", f = "ChangeAccountActivity.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChangeAccountActivity.kt */
final class ChangeAccountActivity$doIt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ ChangeAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChangeAccountActivity$doIt$1(ChangeAccountActivity changeAccountActivity, String str, String str2, Continuation<? super ChangeAccountActivity$doIt$1> continuation) {
        super(2, continuation);
        this.this$0 = changeAccountActivity;
        this.$phone = str;
        this.$code = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangeAccountActivity$doIt$1(this.this$0, this.$phone, this.$code, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangeAccountActivity$doIt$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ChangeAccountActivity$doIt$1$1", f = "ChangeAccountActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.setting.profile.ChangeAccountActivity$doIt$1$1  reason: invalid class name */
    /* compiled from: ChangeAccountActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(changeAccountActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Pair<Boolean, String> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                if (((Boolean) pair.getFirst()).booleanValue()) {
                    String string = changeAccountActivity.getString(R.string.com_actionState_success, new Object[]{changeAccountActivity.getString(R.string.user_info_changePhone)});
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    ExtendsKt.toast(string);
                    changeAccountActivity.logout();
                } else {
                    String str = (String) pair.getSecond();
                    if (str == null) {
                        str = changeAccountActivity.getString(R.string.com_network_failure);
                        Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                    }
                    ExtendsKt.toast(str);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Pair<Boolean, String>> updatePhoneOrEmail = this.this$0.getPVm().updatePhoneOrEmail(this.$phone, this.$code);
            final ChangeAccountActivity changeAccountActivity = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(updatePhoneOrEmail, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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

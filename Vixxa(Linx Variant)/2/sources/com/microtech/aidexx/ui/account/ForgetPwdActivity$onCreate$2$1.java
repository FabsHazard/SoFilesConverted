package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.ForgetPwdActivity$onCreate$2$1", f = "ForgetPwdActivity.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ForgetPwdActivity.kt */
final class ForgetPwdActivity$onCreate$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eCode;
    final /* synthetic */ String $pwd;
    final /* synthetic */ String $user;
    int label;
    final /* synthetic */ ForgetPwdActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForgetPwdActivity$onCreate$2$1(ForgetPwdActivity forgetPwdActivity, String str, String str2, String str3, Continuation<? super ForgetPwdActivity$onCreate$2$1> continuation) {
        super(2, continuation);
        this.this$0 = forgetPwdActivity;
        this.$user = str;
        this.$pwd = str2;
        this.$eCode = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForgetPwdActivity$onCreate$2$1(this.this$0, this.$user, this.$pwd, this.$eCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ForgetPwdActivity$onCreate$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.account.ForgetPwdActivity$onCreate$2$1$1", f = "ForgetPwdActivity.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.account.ForgetPwdActivity$onCreate$2$1$1  reason: invalid class name */
    /* compiled from: ForgetPwdActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends String>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(forgetPwdActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Pair<Boolean, String> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                if (((Boolean) pair.getFirst()).booleanValue()) {
                    Dialogs.INSTANCE.showSuccess(forgetPwdActivity.getString(R.string.com_actionState_success, new Object[]{forgetPwdActivity.getString(R.string.user_sign_resetPwd)}));
                    this.label = 1;
                    if (DelayKt.delay(1500, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String str = (String) pair.getSecond();
                    if (str == null) {
                        str = forgetPwdActivity.getString(R.string.com_network_failure);
                        Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                    }
                    ExtendsKt.toast(str);
                    return Unit.INSTANCE;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (UserInfoManager.Companion.instance().isLogin()) {
                CoroutineScope ioScope = ExtendsKt.getIoScope(AidexxApp.Companion.getInstance());
                final ForgetPwdActivity forgetPwdActivity = forgetPwdActivity;
                Job unused = BuildersKt__Builders_commonKt.launch$default(ioScope, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Flow<Pair<Boolean, String>> changePWD = ((AccountViewModel) this.this$0.getViewModel()).changePWD(this.$user, this.$pwd, this.$eCode);
                                final ForgetPwdActivity forgetPwdActivity = this.this$0;
                                this.label = 1;
                                if (FlowKt.collectLatest(changePWD, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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

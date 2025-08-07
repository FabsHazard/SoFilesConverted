package com.microtech.aidexx.base;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.splashscreen.SplashScreenViewProvider;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityWelcomeBinding;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.base.BaseWelcomeActivity$afterResourceLoaded$2", f = "BaseWelcomeActivity.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseWelcomeActivity.kt */
final class BaseWelcomeActivity$afterResourceLoaded$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SplashScreenViewProvider $splashScreen;
    int label;
    final /* synthetic */ BaseWelcomeActivity<VM> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseWelcomeActivity$afterResourceLoaded$2(BaseWelcomeActivity<VM> baseWelcomeActivity, SplashScreenViewProvider splashScreenViewProvider, Continuation<? super BaseWelcomeActivity$afterResourceLoaded$2> continuation) {
        super(2, continuation);
        this.this$0 = baseWelcomeActivity;
        this.$splashScreen = splashScreenViewProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseWelcomeActivity$afterResourceLoaded$2(this.this$0, this.$splashScreen, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseWelcomeActivity$afterResourceLoaded$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.isSupportSplashProgress) {
                this.label = 1;
                if (DelayKt.delay(500, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (ExtendsKt.isGp() && !UserInfoManager.Companion.instance().isLogin()) {
            SplashScreenViewProvider splashScreenViewProvider = this.$splashScreen;
            if (splashScreenViewProvider != null) {
                splashScreenViewProvider.remove();
            }
            ConstraintLayout root = ((ActivityWelcomeBinding) this.this$0.getBinding()).loadResource.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(8);
        }
        BaseWelcomeActivity<VM> baseWelcomeActivity = this.this$0;
        baseWelcomeActivity.afterAgreeUserProtocol(((ActivityWelcomeBinding) baseWelcomeActivity.getBinding()).welcomeTipViewStub);
        LogUtil.Companion.xLogI("afterResourceLoaded afterAgreeUserProtocol", "BaseWelcomeActivity");
        return Unit.INSTANCE;
    }
}

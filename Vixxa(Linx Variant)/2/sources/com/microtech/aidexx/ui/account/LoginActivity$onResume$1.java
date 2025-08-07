package com.microtech.aidexx.ui.account;

import android.os.Bundle;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.data.resource.AppUpgradeManager;
import com.microtech.aidexx.data.resource.PrivacyUpdateManager;
import com.microtech.aidexx.ui.upgrade.AppUpdateFragment;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.account.LoginActivity$onResume$1", f = "LoginActivity.kt", i = {}, l = {80, 87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginActivity.kt */
final class LoginActivity$onResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginActivity$onResume$1(LoginActivity loginActivity, Continuation<? super LoginActivity$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = loginActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginActivity$onResume$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginActivity$onResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AppUpgradeManager.fetchVersionInfo$default(AppUpgradeManager.INSTANCE, false, this, 1, (Object) null);
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
        UpgradeInfo upgradeInfo = (UpgradeInfo) obj;
        if (upgradeInfo != null) {
            LoginActivity loginActivity = this.this$0;
            AppUpdateFragment appUpdateFragment = new AppUpdateFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("upgradeInfo", upgradeInfo);
            appUpdateFragment.setArguments(bundle);
            appUpdateFragment.show(loginActivity.getSupportFragmentManager(), AppUpdateFragment.TAG);
        }
        this.label = 2;
        if (PrivacyUpdateManager.checkPolicyUpdate$default(PrivacyUpdateManager.INSTANCE, false, this, 1, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}

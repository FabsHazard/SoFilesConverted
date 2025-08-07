package com.microtech.aidexx.ui.setting;

import android.os.Bundle;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.data.resource.AppUpgradeManager;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.AboutActivity$onCreate$1$3$1", f = "AboutActivity.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AboutActivity.kt */
final class AboutActivity$onCreate$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AboutActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AboutActivity$onCreate$1$3$1(AboutActivity aboutActivity, Continuation<? super AboutActivity$onCreate$1$3$1> continuation) {
        super(2, continuation);
        this.this$0 = aboutActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AboutActivity$onCreate$1$3$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AboutActivity$onCreate$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AppUpgradeManager.INSTANCE.fetchVersionInfo(true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UpgradeInfo upgradeInfo = (UpgradeInfo) obj;
        if (upgradeInfo != null) {
            AboutActivity aboutActivity = this.this$0;
            AppUpdateFragment appUpdateFragment = new AppUpdateFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("upgradeInfo", upgradeInfo);
            appUpdateFragment.setArguments(bundle);
            appUpdateFragment.show(aboutActivity.getSupportFragmentManager(), AppUpdateFragment.TAG);
        }
        return Unit.INSTANCE;
    }
}

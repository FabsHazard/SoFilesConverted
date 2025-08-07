package com.microtech.aidexx.ui.setting.profile;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity$onCreate$1", f = "ProfileSettingsActivity.kt", i = {}, l = {59, 61}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProfileSettingsActivity.kt */
final class ProfileSettingsActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileSettingsActivity$onCreate$1(ProfileSettingsActivity profileSettingsActivity, Continuation<? super ProfileSettingsActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = profileSettingsActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsActivity$onCreate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(500, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateDiabetesInfo(UserInfoManager.Companion.instance().getUserEntity());
            Dialogs.INSTANCE.dismissWait();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Dialogs.showWait$default(Dialogs.INSTANCE, (String) null, 1, (Object) null);
        this.label = 2;
        if (this.this$0.getPVm().refreshUserInfo(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.updateDiabetesInfo(UserInfoManager.Companion.instance().getUserEntity());
        Dialogs.INSTANCE.dismissWait();
        return Unit.INSTANCE;
    }
}

package com.microtech.aidexx.ui.setting;

import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.data.resource.AppUpgradeManager;
import com.microtech.aidexx.databinding.ActivityAboutBinding;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.AboutActivity$onCreate$2", f = "AboutActivity.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: AboutActivity.kt */
final class AboutActivity$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AboutActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AboutActivity$onCreate$2(AboutActivity aboutActivity, Continuation<? super AboutActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = aboutActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AboutActivity$onCreate$2 aboutActivity$onCreate$2 = new AboutActivity$onCreate$2(this.this$0, continuation);
        aboutActivity$onCreate$2.L$0 = obj;
        return aboutActivity$onCreate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AboutActivity$onCreate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = (CoroutineScope) this.L$0;
            this.label = 1;
            obj = AppUpgradeManager.INSTANCE.fetchVersionInfo(true, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = null;
        if (((UpgradeInfo) obj) != null) {
            AboutActivity aboutActivity = this.this$0;
            ((ActivityAboutBinding) aboutActivity.getBinding()).settingCheckVersion.setValue((String) null);
            TextView secondTextView = ((ActivityAboutBinding) aboutActivity.getBinding()).settingCheckVersion.getSecondTextView();
            secondTextView.setText(aboutActivity.getString(R.string.about_version_new));
            secondTextView.setTextColor(-1);
            secondTextView.setTextSize(13.0f);
            secondTextView.setBackgroundResource(R.drawable.shape_version_new);
            secondTextView.setPadding(18, 2, 18, 2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            AboutActivity aboutActivity2 = this.this$0;
            ((ActivityAboutBinding) aboutActivity2.getBinding()).settingCheckVersion.setValue(aboutActivity2.getString(R.string.about_versionCheck_value));
        }
        return Unit.INSTANCE;
    }
}

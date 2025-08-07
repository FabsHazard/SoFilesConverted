package com.microtech.aidexx.base;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/microtech/aidexx/base/BaseWelcomeActivity$countDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseWelcomeActivity.kt */
public final class BaseWelcomeActivity$countDownTimer$1 extends CountDownTimer {
    final /* synthetic */ BaseWelcomeActivity<VM> this$0;

    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseWelcomeActivity$countDownTimer$1(BaseWelcomeActivity<VM> baseWelcomeActivity) {
        super(3000, 1000);
        this.this$0 = baseWelcomeActivity;
    }

    public void onFinish() {
        this.this$0.isTimerFinish = true;
        this.this$0.nextTimerStepIfNeed();
    }
}

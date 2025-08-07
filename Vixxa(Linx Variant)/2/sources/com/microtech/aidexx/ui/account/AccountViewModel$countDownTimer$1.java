package com.microtech.aidexx.ui.account;

import android.os.CountDownTimer;
import com.microtech.aidexx.utils.TimeUtils;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/microtech/aidexx/ui/account/AccountViewModel$countDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccountViewModel.kt */
public final class AccountViewModel$countDownTimer$1 extends CountDownTimer {
    final /* synthetic */ AccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$countDownTimer$1(AccountViewModel accountViewModel) {
        super(TimeUtils.oneMinuteMillis, 1000);
        this.this$0 = accountViewModel;
    }

    public void onTick(long j) {
        this.this$0.getTimeLeft().setValue(new Pair(true, Integer.valueOf((int) (j / ((long) 1000)))));
    }

    public void onFinish() {
        this.this$0.getTimeLeft().setValue(new Pair(false, 0));
    }
}

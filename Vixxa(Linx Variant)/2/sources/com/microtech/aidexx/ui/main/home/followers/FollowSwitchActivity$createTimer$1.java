package com.microtech.aidexx.ui.main.home.followers;

import android.os.CountDownTimer;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityFollowListBinding;
import com.microtech.aidexx.utils.TimeUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/microtech/aidexx/ui/main/home/followers/FollowSwitchActivity$createTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FollowSwitchActivity.kt */
public final class FollowSwitchActivity$createTimer$1 extends CountDownTimer {
    final /* synthetic */ FollowSwitchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FollowSwitchActivity$createTimer$1(long j, FollowSwitchActivity followSwitchActivity) {
        super(j, TimeUtils.oneMinuteMillis);
        this.this$0 = followSwitchActivity;
    }

    public void onTick(long j) {
        if (!this.this$0.isFinishing()) {
            int millisToMinutes = ExtendsKt.millisToMinutes(j);
            if (millisToMinutes > 1) {
                ((ActivityFollowListBinding) this.this$0.getBinding()).myCountInfo.tvGlucoseValue.setText(String.valueOf(millisToMinutes));
                this.this$0.startWarmUpAnim(Integer.valueOf(60 - millisToMinutes));
                return;
            }
            ((ActivityFollowListBinding) this.this$0.getBinding()).myCountInfo.tvGlucoseValue.setText("1");
            this.this$0.startWarmUpAnim(59);
            cancel();
        }
    }

    public void onFinish() {
        cancel();
    }
}

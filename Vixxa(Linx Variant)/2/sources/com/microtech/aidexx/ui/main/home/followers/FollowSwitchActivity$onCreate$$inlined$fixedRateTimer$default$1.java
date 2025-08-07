package com.microtech.aidexx.ui.main.home.followers;

import androidx.lifecycle.LifecycleOwnerKt;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Timer.kt */
public final class FollowSwitchActivity$onCreate$$inlined$fixedRateTimer$default$1 extends TimerTask {
    final /* synthetic */ FollowSwitchActivity this$0;

    public FollowSwitchActivity$onCreate$$inlined$fixedRateTimer$default$1(FollowSwitchActivity followSwitchActivity) {
        this.this$0 = followSwitchActivity;
    }

    public void run() {
        TimerTask timerTask = this;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new FollowSwitchActivity$onCreate$2$1(this.this$0, (Continuation<? super FollowSwitchActivity$onCreate$2$1>) null), 3, (Object) null);
    }
}

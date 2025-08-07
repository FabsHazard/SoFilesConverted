package com.microtech.aidexx.ui.main.home.customerservice;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/microtech/aidexx/ui/main/home/customerservice/CustomerServiceView$onTouchEvent$1", "Ljava/util/TimerTask;", "run", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomerServiceView.kt */
public final class CustomerServiceView$onTouchEvent$1 extends TimerTask {
    final /* synthetic */ CustomerServiceView this$0;

    CustomerServiceView$onTouchEvent$1(CustomerServiceView customerServiceView) {
        this.this$0 = customerServiceView;
    }

    public void run() {
        if (!this.this$0.isInMotion) {
            if (this.this$0.moveX == 0 && this.this$0.moveY == 0) {
                this.this$0.isLongClick = true;
            } else if (Math.abs(this.this$0.moveX - this.this$0.downX) < 20 && Math.abs(this.this$0.moveY - this.this$0.downY) < 20) {
                this.this$0.isLongClick = true;
            }
            if (this.this$0.isLongClick && !this.this$0.isInMotion) {
                Context context = null;
                if (Build.VERSION.SDK_INT >= 31) {
                    Context access$getMContext$p = this.this$0.mContext;
                    if (access$getMContext$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    } else {
                        context = access$getMContext$p;
                    }
                    Object systemService = context.getSystemService("vibrator_manager");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
                    Vibrator defaultVibrator = ((VibratorManager) systemService).getDefaultVibrator();
                    Intrinsics.checkNotNullExpressionValue(defaultVibrator, "getDefaultVibrator(...)");
                    defaultVibrator.vibrate(VibrationEffect.createOneShot(100, -1));
                    return;
                }
                Context access$getMContext$p2 = this.this$0.mContext;
                if (access$getMContext$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                } else {
                    context = access$getMContext$p2;
                }
                Object systemService2 = context.getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
                ((Vibrator) systemService2).vibrate(100);
            }
        }
    }
}

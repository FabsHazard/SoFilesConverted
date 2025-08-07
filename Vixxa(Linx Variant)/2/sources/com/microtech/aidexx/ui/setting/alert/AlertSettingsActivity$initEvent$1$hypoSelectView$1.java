package com.microtech.aidexx.ui.setting.alert;

import com.microtech.aidexx.databinding.ActivitySettingsAlertBinding;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertSettingsActivity.kt */
final class AlertSettingsActivity$initEvent$1$hypoSelectView$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ AlertSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertSettingsActivity$initEvent$1$hypoSelectView$1(AlertSettingsActivity alertSettingsActivity) {
        super(1);
        this.this$0 = alertSettingsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        if (f != ThresholdManager.INSTANCE.getHypo()) {
            ThresholdManager.INSTANCE.setHypo(f);
            ((ActivitySettingsAlertBinding) this.this$0.getBinding()).hypoThreshold.setValue(GlucoseUtilKt.toGlucoseStringWithUnit(f));
            this.this$0.isHypChanged = true;
        }
    }
}

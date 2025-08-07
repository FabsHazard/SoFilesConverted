package com.microtech.aidexx.ui.main.home.panel;

import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.databinding.FragmentGlucosePanelBinding;
import com.microtech.aidexx.ui.main.home.HomeBackGroundSelector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucosePanelFragment.kt */
final class GlucosePanelFragment$onCreate$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GlucosePanelFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlucosePanelFragment$onCreate$3(GlucosePanelFragment glucosePanelFragment) {
        super(1);
        this.this$0 = glucosePanelFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        DeviceModel deviceModel;
        if (this.this$0.isAdded() && (deviceModel = TransmitterManager.Companion.instance().getDefault()) != null) {
            GlucosePanelFragment glucosePanelFragment = this.this$0;
            DeviceModel.GlucoseLevel glucoseLevel = deviceModel.getGlucoseLevel(deviceModel.getGlucose());
            ((FragmentGlucosePanelBinding) glucosePanelFragment.getBinding()).bgPanel.setBackgroundResource(HomeBackGroundSelector.Companion.instance().getBgForTrend(deviceModel.getGlucoseTrend(), glucoseLevel));
            deviceModel.setGlucoseLevel(glucoseLevel);
        }
    }
}

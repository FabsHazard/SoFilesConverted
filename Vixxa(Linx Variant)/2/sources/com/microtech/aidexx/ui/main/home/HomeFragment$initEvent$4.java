package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$initEvent$4 extends Lambda implements Function1<Boolean, Unit> {
    public static final HomeFragment$initEvent$4 INSTANCE = new HomeFragment$initEvent$4();

    HomeFragment$initEvent$4() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel != null) {
            DeviceModel.GlucoseLevel glucoseLevel = (!deviceModel.isDataValid() || !deviceModel.getMalFunctionList().isEmpty()) ? null : deviceModel.getGlucoseLevel(deviceModel.getGlucose());
            deviceModel.setGlucoseLevel(glucoseLevel);
            HomeBackGroundSelector.Companion.instance().getHomeBg(glucoseLevel);
        }
    }
}

package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "<anonymous parameter 0>", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$transChangeCallback$1 extends Lambda implements Function1<DeviceModel, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$transChangeCallback$1(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceModel deviceModel) {
        this.this$0.judgeState();
    }
}

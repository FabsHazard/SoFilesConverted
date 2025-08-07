package com.microtech.aidexx.ui.pair;

import com.microtech.aidexx.R;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "controller", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
final class TransmitterActivity$initView$4 extends Lambda implements Function1<BleControllerProxy, Unit> {
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$initView$4(TransmitterActivity transmitterActivity) {
        super(1);
        this.this$0 = transmitterActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BleControllerProxy) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BleControllerProxy bleControllerProxy) {
        Intrinsics.checkNotNullParameter(bleControllerProxy, "controller");
        if (bleControllerProxy.isProductionExpire()) {
            int status = bleControllerProxy.getStatus() & 1;
            int calTemp = bleControllerProxy.getCalTemp() & 1;
            if (status == 1 && calTemp == 1) {
                Dialogs dialogs = Dialogs.INSTANCE;
                TransmitterActivity transmitterActivity = this.this$0;
                Dialogs.showMessage$default(dialogs, transmitterActivity, (String) null, transmitterActivity.getString(R.string.ble_state_device_expire), (String) null, (String) null, (Function0) null, 56, (Object) null);
                return;
            }
            this.this$0.doubleCheck(bleControllerProxy);
            return;
        }
        this.this$0.doubleCheck(bleControllerProxy);
    }
}

package com.microtech.aidexx.ui.pair;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/pair/PairUtil$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairUtil.kt */
public final class PairUtil$handler$1 extends Handler {
    PairUtil$handler$1(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        BleController controller;
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        Dialogs.INSTANCE.dismissWait();
        DeviceModel pair = TransmitterManager.Companion.instance().getPair();
        if (!(pair == null || (controller = pair.getController()) == null)) {
            controller.disconnect();
        }
        TransmitterManager.Companion.instance().removePair();
    }
}

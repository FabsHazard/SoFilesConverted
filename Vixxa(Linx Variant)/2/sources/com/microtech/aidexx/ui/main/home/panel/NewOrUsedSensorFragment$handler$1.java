package com.microtech.aidexx.ui.main.home.panel;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.ui.main.home.HomeFragmentKt;
import com.microtech.aidexx.ui.main.home.HomeStateManager;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NewOrUsedSensorFragment.kt */
public final class NewOrUsedSensorFragment$handler$1 extends Handler {
    final /* synthetic */ NewOrUsedSensorFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewOrUsedSensorFragment$handler$1(NewOrUsedSensorFragment newOrUsedSensorFragment, Looper looper) {
        super(looper);
        this.this$0 = newOrUsedSensorFragment;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        int i = message.what;
        if (i == 0) {
            LogUtil.Companion.xLogI$default(LogUtil.Companion, "ota get or set dp msgCommandTimeout", (String) null, 2, (Object) null);
            DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
            if (deviceModel != null) {
                this.this$0.doNewSensor(deviceModel);
            }
        } else if (i != 1) {
            if (i == 2) {
                Dialogs.INSTANCE.dismissWait();
                if (Intrinsics.areEqual((Object) HomeStateManager.Companion.instance().getCurrentState(), (Object) HomeFragmentKt.newOrUsedSensor)) {
                    this.this$0.reset();
                }
            } else if (i == 3) {
                LogUtil.Companion.xLogI$default(LogUtil.Companion, "ota get device info msgCommandTimeout", (String) null, 2, (Object) null);
                DeviceModel deviceModel2 = TransmitterManager.Companion.instance().getDefault();
                if (deviceModel2 != null) {
                    this.this$0.doNewSensor(deviceModel2);
                }
            }
        } else if (Intrinsics.areEqual((Object) HomeStateManager.Companion.instance().getCurrentState(), (Object) HomeFragmentKt.newOrUsedSensor)) {
            this.this$0.reset();
        }
        super.handleMessage(message);
    }
}

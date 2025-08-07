package com.microtech.aidexx.ui.main.bg;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.MessageObserver;
import com.microtech.aidexx.databinding.FragmentBgBinding;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.constant.AidexXOperation;
import com.microtechmd.blecomm.entity.BleMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/bg/BgFragment$mObserver$1", "Lcom/microtech/aidexx/ble/MessageObserver;", "onMessage", "", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgFragment.kt */
public final class BgFragment$mObserver$1 implements MessageObserver {
    final /* synthetic */ BgFragment this$0;

    BgFragment$mObserver$1(BgFragment bgFragment) {
        this.this$0 = bgFragment;
    }

    public void onMessage(BleMessage bleMessage) {
        Intrinsics.checkNotNullParameter(bleMessage, CrashHianalyticsData.MESSAGE);
        int operation = bleMessage.getOperation();
        if (operation == 3) {
            Dialogs.INSTANCE.dismissWait();
        } else if (operation == 1) {
            if (!bleMessage.isSuccess()) {
                Dialogs.showError$default(Dialogs.INSTANCE, this.this$0.getString(R.string.ble_state_connect_failure), 0, 2, (Object) null);
                MessageDistributor.Companion.instance().removeObserver(this);
            }
        } else if (operation == 2) {
            if (!bleMessage.isSuccess()) {
                Dialogs.showError$default(Dialogs.INSTANCE, this.this$0.getString(R.string.ble_state_connect_failure), 0, 2, (Object) null);
                MessageDistributor.Companion.instance().removeObserver(this);
            }
        } else if (operation == AidexXOperation.SET_CALIBRATION) {
            if (bleMessage.isSuccess()) {
                if (bleMessage.getResCode() == 1) {
                    Dialogs.INSTANCE.showSuccess(this.this$0.getString(R.string.com_actionState_success, this.this$0.getString(R.string.com_action_calibration)));
                    ((FragmentBgBinding) this.this$0.getBinding()).etGlucoseValue.setText("");
                } else {
                    Dialogs.showError$default(Dialogs.INSTANCE, this.this$0.getString(R.string.com_actionState_reject, this.this$0.getString(R.string.com_action_calibration)) + '(' + bleMessage.getResCode() + ')', 0, 2, (Object) null);
                }
            }
            MessageDistributor.Companion.instance().removeObserver(this);
        }
    }
}

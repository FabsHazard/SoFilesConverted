package com.microtech.aidexx.ui.main.home.panel;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.ble.MessageObserver;
import com.microtechmd.blecomm.entity.BleMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment$mObserver$1", "Lcom/microtech/aidexx/ble/MessageObserver;", "onMessage", "", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucosePanelFragment.kt */
public final class GlucosePanelFragment$mObserver$1 implements MessageObserver {
    final /* synthetic */ GlucosePanelFragment this$0;

    GlucosePanelFragment$mObserver$1(GlucosePanelFragment glucosePanelFragment) {
        this.this$0 = glucosePanelFragment;
    }

    public void onMessage(BleMessage bleMessage) {
        Intrinsics.checkNotNullParameter(bleMessage, CrashHianalyticsData.MESSAGE);
        this.this$0.handler.sendEmptyMessage(2006);
    }
}

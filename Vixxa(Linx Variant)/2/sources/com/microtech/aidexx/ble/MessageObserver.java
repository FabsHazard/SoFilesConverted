package com.microtech.aidexx.ble;

import com.microtechmd.blecomm.entity.BleMessage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ble/MessageObserver;", "", "onMessage", "", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MessageObserver.kt */
public interface MessageObserver {
    void onMessage(BleMessage bleMessage);
}

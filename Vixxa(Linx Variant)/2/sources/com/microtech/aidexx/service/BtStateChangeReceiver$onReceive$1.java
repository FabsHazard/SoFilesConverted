package com.microtech.aidexx.service;

import android.content.Intent;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BtStateChangeReceiver.kt */
final class BtStateChangeReceiver$onReceive$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Intent $intent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BtStateChangeReceiver$onReceive$1(Intent intent) {
        super(0);
        this.$intent = intent;
    }

    public final void invoke() {
        Intent intent = this.$intent;
        Integer num = null;
        if (StringsKt.equals$default(intent != null ? intent.getAction() : null, "android.bluetooth.adapter.action.STATE_CHANGED", false, 2, (Object) null)) {
            Intent intent2 = this.$intent;
            if (intent2 != null) {
                num = Integer.valueOf(intent2.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE));
            }
            if (num != null && num.intValue() == 11) {
                LogUtil.Companion.eAiDEX("System bluetooth turn on");
                AidexBleAdapter.Companion.getInstance().stopBtScan(true);
            } else if (num != null && num.intValue() == 13) {
                LogUtil.Companion.eAiDEX("System bluetooth turn off");
                AidexBleAdapter.Companion.getInstance().onBluetoothDisable();
            }
        }
    }
}

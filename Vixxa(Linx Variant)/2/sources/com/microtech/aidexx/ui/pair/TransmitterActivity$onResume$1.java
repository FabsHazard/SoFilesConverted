package com.microtech.aidexx.ui.pair;

import android.content.Intent;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.PendingIntentReceiver;
import com.microtech.aidexx.service.MainService;
import com.microtech.aidexx.ui.pair.TransmitterActivity;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
final class TransmitterActivity$onResume$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$onResume$1(TransmitterActivity transmitterActivity) {
        super(0);
        this.this$0 = transmitterActivity;
    }

    public final void invoke() {
        Intent intent = new Intent(this.this$0, MainService.class);
        intent.setAction("START_FOREGROUND");
        this.this$0.startService(intent);
        this.this$0.checkPass = true;
        this.this$0.initAnim();
        Dialogs.INSTANCE.showWait(this.this$0.getString(R.string.com_loading));
        this.this$0.loadSavedTransmitter();
        TransmitterActivity.TransmitterHandler access$getTransmitterHandler$p = this.this$0.transmitterHandler;
        TransmitterActivity.TransmitterHandler transmitterHandler = null;
        if (access$getTransmitterHandler$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterHandler");
            access$getTransmitterHandler$p = null;
        }
        access$getTransmitterHandler$p.removeMessages(PendingIntentReceiver.REQUEST_CODE);
        TransmitterActivity.TransmitterHandler access$getTransmitterHandler$p2 = this.this$0.transmitterHandler;
        if (access$getTransmitterHandler$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterHandler");
        } else {
            transmitterHandler = access$getTransmitterHandler$p2;
        }
        transmitterHandler.sendEmptyMessageDelayed(PendingIntentReceiver.REQUEST_CODE, 3000);
        PairUtil.INSTANCE.registerBondStateChangeReceiver(this.this$0);
    }
}

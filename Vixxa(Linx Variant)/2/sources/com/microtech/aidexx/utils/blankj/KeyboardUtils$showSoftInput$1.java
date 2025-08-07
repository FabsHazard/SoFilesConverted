package com.microtech.aidexx.utils.blankj;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/microtech/aidexx/utils/blankj/KeyboardUtils$showSoftInput$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KeyboardUtils.kt */
public final class KeyboardUtils$showSoftInput$1 extends ResultReceiver {
    KeyboardUtils$showSoftInput$1(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        if (i == 1 || i == 3) {
            KeyboardUtils.INSTANCE.toggleSoftInput();
        }
    }
}

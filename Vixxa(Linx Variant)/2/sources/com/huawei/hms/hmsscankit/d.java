package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.o4;

/* compiled from: OnResultCallbackDelegate */
class d extends IOnResultCallback.Stub {
    private final OnResultCallback a;
    private String b;
    private boolean c;

    d(OnResultCallback onResultCallback, boolean z) {
        this.a = onResultCallback;
        this.c = z;
    }

    public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        HmsScan hmsScan;
        o4.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.c);
        if (this.c) {
            this.a.onResult(hmsScanArr);
        } else if (hmsScanArr != null && hmsScanArr.length > 0 && (hmsScan = hmsScanArr[0]) != null && !TextUtils.equals(this.b, hmsScan.getOriginalValue())) {
            this.b = hmsScanArr[0].getOriginalValue();
            o4.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.c);
            this.a.onResult(hmsScanArr);
        }
    }
}

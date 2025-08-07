package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;

/* compiled from: OnLightVisibleCallBackDelegata */
class c extends IOnLightCallback.Stub {
    private final OnLightVisibleCallBack a;

    c(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.a = onLightVisibleCallBack;
    }

    public void onVisibleChanged(boolean z) throws RemoteException {
        this.a.onVisibleChanged(z);
    }
}

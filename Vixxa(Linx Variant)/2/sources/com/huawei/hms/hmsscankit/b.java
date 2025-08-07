package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.util.Log;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;

/* compiled from: OnErrorCallbackDelegate */
class b extends IOnErrorCallback.Stub {
    private final OnErrorCallback a;

    b(OnErrorCallback onErrorCallback) {
        this.a = onErrorCallback;
    }

    public void onError(int i) throws RemoteException {
        if (this.a != null) {
            Log.i("OnErrorCallbackDelegate", "onError: ErrorCode：" + i);
            this.a.onError(i);
        }
    }
}

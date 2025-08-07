package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

public class StringProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        bundle.putString(IpcConst.KEY_VALUE, (String) obj);
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return bundle.getString(IpcConst.KEY_VALUE);
    }
}

package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

public class BooleanProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Boolean)) {
            return false;
        }
        bundle.putBoolean(IpcConst.KEY_VALUE, ((Boolean) obj).booleanValue());
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(IpcConst.KEY_VALUE));
    }
}

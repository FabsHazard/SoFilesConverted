package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

public class IntProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        bundle.putInt(IpcConst.KEY_VALUE, ((Integer) obj).intValue());
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(IpcConst.KEY_VALUE));
    }
}

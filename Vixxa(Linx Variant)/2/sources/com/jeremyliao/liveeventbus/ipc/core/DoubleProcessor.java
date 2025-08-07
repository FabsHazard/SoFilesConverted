package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

public class DoubleProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Double)) {
            return false;
        }
        bundle.putDouble(IpcConst.KEY_VALUE, ((Double) obj).doubleValue());
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return Double.valueOf(bundle.getDouble(IpcConst.KEY_VALUE));
    }
}

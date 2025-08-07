package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

public class FloatProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Float)) {
            return false;
        }
        bundle.putFloat(IpcConst.KEY_VALUE, ((Float) obj).floatValue());
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return Float.valueOf(bundle.getFloat(IpcConst.KEY_VALUE));
    }
}

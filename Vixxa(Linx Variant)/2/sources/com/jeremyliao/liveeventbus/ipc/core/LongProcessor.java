package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;

public class LongProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Long)) {
            return false;
        }
        bundle.putLong(IpcConst.KEY_VALUE, ((Long) obj).longValue());
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return Long.valueOf(bundle.getLong(IpcConst.KEY_VALUE));
    }
}

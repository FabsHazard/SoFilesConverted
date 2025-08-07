package com.jeremyliao.liveeventbus.ipc.core;

import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import java.io.Serializable;

public class SerializableProcessor implements Processor {
    public boolean writeToBundle(Bundle bundle, Object obj) {
        if (!(obj instanceof Serializable)) {
            return false;
        }
        bundle.putSerializable(IpcConst.KEY_VALUE, (Serializable) obj);
        return true;
    }

    public Object createFromBundle(Bundle bundle) {
        return bundle.getSerializable(IpcConst.KEY_VALUE);
    }
}

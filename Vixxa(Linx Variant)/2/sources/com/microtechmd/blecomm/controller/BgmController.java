package com.microtechmd.blecomm.controller;

public class BgmController extends BleController {
    private native void constructor();

    private native void destructor();

    public native int getDeviceInfo();

    public native int getHistory(int i);

    public BgmController() {
        constructor();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        destructor();
        super.finalize();
    }
}

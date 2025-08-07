package com.microtechmd.blecomm;

import java.util.Timer;
import java.util.TimerTask;

public abstract class NoConnectionBleAdapter extends BleAdapter {
    public void executeStartScan() {
    }

    public void executeStopScan() {
    }

    public boolean isReadyToConnect(String str) {
        return true;
    }

    public void executeConnect(String str) {
        new Timer().schedule(new TimerTask() {
            public void run() {
                NoConnectionBleAdapter.this.onConnectSuccess();
            }
        }, 200);
    }

    public void executeDisconnect() {
        new Timer().schedule(new TimerTask() {
            public void run() {
                NoConnectionBleAdapter.this.onDisconnected();
            }
        }, 200);
    }
}

package io.objectbox.sync;

import javax.annotation.Nullable;

public abstract class ConnectivityMonitor {
    @Nullable
    private SyncClient syncClient;

    public void onObserverRemoved() {
    }

    public void onObserverSet() {
    }

    /* access modifiers changed from: package-private */
    public void setObserver(SyncClient syncClient2) {
        if (syncClient2 != null) {
            this.syncClient = syncClient2;
            onObserverSet();
            return;
        }
        throw new IllegalArgumentException("Sync client must not be null");
    }

    /* access modifiers changed from: package-private */
    public void removeObserver() {
        this.syncClient = null;
        onObserverRemoved();
    }

    public final void notifyConnectionAvailable() {
        SyncClient syncClient2 = this.syncClient;
        if (syncClient2 != null) {
            syncClient2.notifyConnectionAvailable();
        }
    }
}

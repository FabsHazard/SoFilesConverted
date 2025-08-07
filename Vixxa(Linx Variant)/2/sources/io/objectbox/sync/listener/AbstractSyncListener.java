package io.objectbox.sync.listener;

import io.objectbox.sync.SyncChange;

public abstract class AbstractSyncListener implements SyncListener {
    public void onDisconnected() {
    }

    public void onLoggedIn() {
    }

    public void onLoginFailed(long j) {
    }

    public void onServerTimeUpdate(long j) {
    }

    public void onSyncChanges(SyncChange[] syncChangeArr) {
    }

    public void onUpdatesCompleted() {
    }
}

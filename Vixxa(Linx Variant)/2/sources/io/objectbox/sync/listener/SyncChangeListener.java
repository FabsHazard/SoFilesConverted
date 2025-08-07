package io.objectbox.sync.listener;

import io.objectbox.sync.SyncChange;

public interface SyncChangeListener {
    void onSyncChanges(SyncChange[] syncChangeArr);
}

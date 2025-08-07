package io.objectbox.sync;

import io.objectbox.BoxStore;
import io.objectbox.sync.internal.Platform;
import io.objectbox.sync.listener.SyncChangeListener;
import io.objectbox.sync.listener.SyncCompletedListener;
import io.objectbox.sync.listener.SyncConnectionListener;
import io.objectbox.sync.listener.SyncListener;
import io.objectbox.sync.listener.SyncLoginListener;
import io.objectbox.sync.listener.SyncTimeListener;
import java.util.Arrays;
import javax.annotation.Nullable;

public class SyncBuilder {
    final BoxStore boxStore;
    @Nullable
    SyncChangeListener changeListener;
    @Nullable
    SyncCompletedListener completedListener;
    @Nullable
    SyncConnectionListener connectionListener;
    final SyncCredentials credentials;
    @Nullable
    SyncListener listener;
    @Nullable
    SyncLoginListener loginListener;
    final Platform platform;
    RequestUpdatesMode requestUpdatesMode = RequestUpdatesMode.AUTO;
    @Nullable
    SyncTimeListener timeListener;
    @Nullable
    String[] trustedCertPaths;
    boolean uncommittedAcks;
    final String url;

    public enum RequestUpdatesMode {
        MANUAL,
        AUTO,
        AUTO_NO_PUSHES
    }

    public SyncBuilder(BoxStore boxStore2, String str, SyncCredentials syncCredentials) {
        checkNotNull(boxStore2, "BoxStore is required.");
        checkNotNull(str, "Sync server URL is required.");
        checkNotNull(syncCredentials, "Sync credentials are required.");
        if (BoxStore.isSyncAvailable()) {
            this.platform = Platform.findPlatform();
            this.boxStore = boxStore2;
            this.url = str;
            this.credentials = syncCredentials;
            return;
        }
        throw new IllegalStateException("This library does not include ObjectBox Sync. Please visit https://objectbox.io/sync/ for options.");
    }

    public SyncBuilder trustedCertificates(String[] strArr) {
        this.trustedCertPaths = (String[]) Arrays.copyOf(strArr, strArr.length);
        return this;
    }

    public SyncBuilder requestUpdatesMode(RequestUpdatesMode requestUpdatesMode2) {
        this.requestUpdatesMode = requestUpdatesMode2;
        return this;
    }

    public SyncBuilder uncommittedAcks() {
        this.uncommittedAcks = true;
        return this;
    }

    public SyncBuilder loginListener(SyncLoginListener syncLoginListener) {
        this.loginListener = syncLoginListener;
        return this;
    }

    public SyncBuilder completedListener(SyncCompletedListener syncCompletedListener) {
        this.completedListener = syncCompletedListener;
        return this;
    }

    public SyncBuilder changeListener(SyncChangeListener syncChangeListener) {
        this.changeListener = syncChangeListener;
        return this;
    }

    public SyncBuilder timeListener(SyncTimeListener syncTimeListener) {
        this.timeListener = syncTimeListener;
        return this;
    }

    public SyncBuilder connectionListener(SyncConnectionListener syncConnectionListener) {
        this.connectionListener = syncConnectionListener;
        return this;
    }

    public SyncBuilder listener(SyncListener syncListener) {
        this.listener = syncListener;
        return this;
    }

    public SyncClient build() {
        if (this.boxStore.getSyncClient() == null) {
            return new SyncClientImpl(this);
        }
        throw new IllegalStateException("The given store is already associated with a Sync client, close it first.");
    }

    public SyncClient buildAndStart() {
        SyncClient build = build();
        build.start();
        return build;
    }

    private void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}

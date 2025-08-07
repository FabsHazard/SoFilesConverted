package io.objectbox.sync;

import io.objectbox.BoxStore;
import io.objectbox.InternalAccess;
import io.objectbox.sync.SyncBuilder;
import io.objectbox.sync.listener.SyncChangeListener;
import io.objectbox.sync.listener.SyncCompletedListener;
import io.objectbox.sync.listener.SyncConnectionListener;
import io.objectbox.sync.listener.SyncListener;
import io.objectbox.sync.listener.SyncLoginListener;
import io.objectbox.sync.listener.SyncTimeListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class SyncClientImpl implements SyncClient {
    @Nullable
    private BoxStore boxStore;
    /* access modifiers changed from: private */
    @Nullable
    public volatile SyncCompletedListener completedListener;
    /* access modifiers changed from: private */
    @Nullable
    public volatile SyncConnectionListener connectionListener;
    @Nullable
    private final ConnectivityMonitor connectivityMonitor;
    private volatile long handle;
    private final InternalSyncClientListener internalListener;
    /* access modifiers changed from: private */
    public volatile long lastLoginCode;
    /* access modifiers changed from: private */
    @Nullable
    public volatile SyncLoginListener loginListener;
    private final String serverUrl;
    private volatile boolean started;
    /* access modifiers changed from: private */
    @Nullable
    public volatile SyncTimeListener timeListener;

    private native boolean nativeCancelUpdates(long j);

    private static native long nativeCreate(long j, String str, @Nullable String[] strArr);

    private native void nativeDelete(long j);

    private native int nativeGetState(long j);

    /* access modifiers changed from: private */
    public native void nativeObjectsMessageAddBytes(long j, long j2, byte[] bArr, boolean z);

    /* access modifiers changed from: private */
    public native void nativeObjectsMessageAddString(long j, long j2, String str);

    /* access modifiers changed from: private */
    public native boolean nativeObjectsMessageSend(long j, long j2);

    /* access modifiers changed from: private */
    public native long nativeObjectsMessageStart(long j, @Nullable String str);

    private native boolean nativeRequestFullSync(long j, boolean z);

    private native boolean nativeRequestUpdates(long j, boolean z);

    private native long nativeRoundtripTime(long j);

    private native long nativeServerTime(long j);

    private native long nativeServerTimeDiff(long j);

    private native void nativeSetListener(long j, @Nullable InternalSyncClientListener internalSyncClientListener);

    private native void nativeSetLoginInfo(long j, long j2, @Nullable byte[] bArr);

    private native void nativeSetLoginInfoUserPassword(long j, long j2, String str, String str2);

    private native void nativeSetRequestUpdatesMode(long j, boolean z, boolean z2);

    private native void nativeSetSyncChangesListener(long j, @Nullable SyncChangeListener syncChangeListener);

    private native void nativeSetUncommittedAcks(long j, boolean z);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    private native boolean nativeTriggerReconnect(long j);

    SyncClientImpl(SyncBuilder syncBuilder) {
        this.boxStore = syncBuilder.boxStore;
        String str = syncBuilder.url;
        this.serverUrl = str;
        this.connectivityMonitor = syncBuilder.platform.getConnectivityMonitor();
        long nativeCreate = nativeCreate(syncBuilder.boxStore.getNativeStore(), str, syncBuilder.trustedCertPaths);
        if (nativeCreate != 0) {
            this.handle = nativeCreate;
            if (syncBuilder.requestUpdatesMode != SyncBuilder.RequestUpdatesMode.AUTO) {
                nativeSetRequestUpdatesMode(nativeCreate, syncBuilder.requestUpdatesMode != SyncBuilder.RequestUpdatesMode.MANUAL, false);
            }
            if (syncBuilder.uncommittedAcks) {
                nativeSetUncommittedAcks(nativeCreate, true);
            }
            if (syncBuilder.listener != null) {
                setSyncListener(syncBuilder.listener);
            } else {
                this.loginListener = syncBuilder.loginListener;
                this.completedListener = syncBuilder.completedListener;
                if (syncBuilder.changeListener != null) {
                    setSyncChangeListener(syncBuilder.changeListener);
                }
                this.connectionListener = syncBuilder.connectionListener;
                this.timeListener = syncBuilder.timeListener;
            }
            InternalSyncClientListener internalSyncClientListener = new InternalSyncClientListener();
            this.internalListener = internalSyncClientListener;
            nativeSetListener(nativeCreate, internalSyncClientListener);
            setLoginCredentials(syncBuilder.credentials);
            InternalAccess.setSyncClient(syncBuilder.boxStore, this);
            return;
        }
        throw new RuntimeException("Failed to create sync client: handle is zero.");
    }

    /* access modifiers changed from: private */
    public long getHandle() {
        long j = this.handle;
        if (j != 0) {
            return j;
        }
        throw new IllegalStateException("SyncClient already closed");
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public long getLastLoginCode() {
        return this.lastLoginCode;
    }

    public boolean isLoggedIn() {
        return this.lastLoginCode == 20;
    }

    public long getServerTimeNanos() {
        return nativeServerTime(getHandle());
    }

    public long getServerTimeDiffNanos() {
        return nativeServerTimeDiff(getHandle());
    }

    public long getRoundtripTimeNanos() {
        return nativeRoundtripTime(getHandle());
    }

    public SyncState getSyncState() {
        return SyncState.fromId(nativeGetState(getHandle()));
    }

    public void setSyncLoginListener(@Nullable SyncLoginListener syncLoginListener) {
        this.loginListener = syncLoginListener;
    }

    public void setSyncCompletedListener(@Nullable SyncCompletedListener syncCompletedListener) {
        this.completedListener = syncCompletedListener;
    }

    public void setSyncChangeListener(@Nullable SyncChangeListener syncChangeListener) {
        nativeSetSyncChangesListener(getHandle(), syncChangeListener);
    }

    public void setSyncTimeListener(@Nullable SyncTimeListener syncTimeListener) {
        this.timeListener = syncTimeListener;
    }

    public void setSyncConnectionListener(@Nullable SyncConnectionListener syncConnectionListener) {
        this.connectionListener = syncConnectionListener;
    }

    public void setSyncListener(@Nullable SyncListener syncListener) {
        this.loginListener = syncListener;
        this.completedListener = syncListener;
        this.timeListener = syncListener;
        this.connectionListener = syncListener;
        setSyncChangeListener(syncListener);
    }

    public void setLoginCredentials(SyncCredentials syncCredentials) {
        if (syncCredentials instanceof SyncCredentialsToken) {
            SyncCredentialsToken syncCredentialsToken = (SyncCredentialsToken) syncCredentials;
            nativeSetLoginInfo(getHandle(), syncCredentialsToken.getTypeId(), syncCredentialsToken.getTokenBytes());
            syncCredentialsToken.clear();
        } else if (syncCredentials instanceof SyncCredentialsUserPassword) {
            SyncCredentialsUserPassword syncCredentialsUserPassword = (SyncCredentialsUserPassword) syncCredentials;
            nativeSetLoginInfoUserPassword(getHandle(), syncCredentialsUserPassword.getTypeId(), syncCredentialsUserPassword.getUsername(), syncCredentialsUserPassword.getPassword());
        } else {
            throw new IllegalArgumentException("credentials is not a supported type");
        }
    }

    public boolean awaitFirstLogin(long j) {
        if (!this.started) {
            start();
        }
        return this.internalListener.awaitFirstLogin(j);
    }

    public synchronized void start() {
        nativeStart(getHandle());
        this.started = true;
        ConnectivityMonitor connectivityMonitor2 = this.connectivityMonitor;
        if (connectivityMonitor2 != null) {
            connectivityMonitor2.setObserver(this);
        }
    }

    public boolean isStarted() {
        return this.started;
    }

    public synchronized void stop() {
        ConnectivityMonitor connectivityMonitor2 = this.connectivityMonitor;
        if (connectivityMonitor2 != null) {
            connectivityMonitor2.removeObserver();
        }
        nativeStop(getHandle());
        this.started = false;
    }

    public void close() {
        long j;
        synchronized (this) {
            ConnectivityMonitor connectivityMonitor2 = this.connectivityMonitor;
            if (connectivityMonitor2 != null) {
                connectivityMonitor2.removeObserver();
            }
            BoxStore boxStore2 = this.boxStore;
            if (boxStore2 != null) {
                if (boxStore2.getSyncClient() == this) {
                    InternalAccess.setSyncClient(boxStore2, (SyncClient) null);
                }
                this.boxStore = null;
            }
            j = this.handle;
            this.handle = 0;
        }
        if (j != 0) {
            nativeDelete(j);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public boolean requestFullSync() {
        return nativeRequestFullSync(getHandle(), false);
    }

    public boolean requestFullSyncAndUpdates() {
        return nativeRequestFullSync(getHandle(), true);
    }

    public boolean requestUpdates() {
        return nativeRequestUpdates(getHandle(), true);
    }

    public boolean requestUpdatesOnce() {
        return nativeRequestUpdates(getHandle(), false);
    }

    public boolean cancelUpdates() {
        return nativeCancelUpdates(getHandle());
    }

    public void notifyConnectionAvailable() {
        nativeTriggerReconnect(getHandle());
    }

    public ObjectsMessageBuilder startObjectsMessage(long j, @Nullable String str) {
        return new ObjectsMessageBuilderImpl(j, str);
    }

    private class InternalSyncClientListener {
        private final CountDownLatch firstLoginLatch;

        private InternalSyncClientListener() {
            this.firstLoginLatch = new CountDownLatch(1);
        }

        public void onLogin() {
            long unused = SyncClientImpl.this.lastLoginCode = 20;
            this.firstLoginLatch.countDown();
            SyncLoginListener access$300 = SyncClientImpl.this.loginListener;
            if (access$300 != null) {
                access$300.onLoggedIn();
            }
        }

        public void onLoginFailure(long j) {
            long unused = SyncClientImpl.this.lastLoginCode = j;
            this.firstLoginLatch.countDown();
            SyncLoginListener access$300 = SyncClientImpl.this.loginListener;
            if (access$300 != null) {
                access$300.onLoginFailed(j);
            }
        }

        public void onSyncComplete() {
            SyncCompletedListener access$400 = SyncClientImpl.this.completedListener;
            if (access$400 != null) {
                access$400.onUpdatesCompleted();
            }
        }

        public void onServerTimeUpdate(long j) {
            SyncTimeListener access$500 = SyncClientImpl.this.timeListener;
            if (access$500 != null) {
                access$500.onServerTimeUpdate(j);
            }
        }

        public void onDisconnect() {
            SyncConnectionListener access$600 = SyncClientImpl.this.connectionListener;
            if (access$600 != null) {
                access$600.onDisconnected();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean awaitFirstLogin(long j) {
            try {
                return this.firstLoginLatch.await(j, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return false;
            }
        }
    }

    public static class ObjectsMessageBuilderImpl implements ObjectsMessageBuilder {
        private final long builderHandle;
        private boolean sent;
        private final SyncClientImpl syncClient;

        private ObjectsMessageBuilderImpl(SyncClientImpl syncClientImpl, long j, @Nullable String str) {
            this.syncClient = syncClientImpl;
            this.builderHandle = syncClientImpl.nativeObjectsMessageStart(j, str);
        }

        public ObjectsMessageBuilderImpl addString(long j, String str) {
            checkNotSent();
            this.syncClient.nativeObjectsMessageAddString(this.builderHandle, j, str);
            return this;
        }

        public ObjectsMessageBuilderImpl addBytes(long j, byte[] bArr, boolean z) {
            checkNotSent();
            this.syncClient.nativeObjectsMessageAddBytes(this.builderHandle, j, bArr, z);
            return this;
        }

        public boolean send() {
            if (!this.syncClient.isStarted()) {
                return false;
            }
            checkNotSent();
            this.sent = true;
            SyncClientImpl syncClientImpl = this.syncClient;
            return syncClientImpl.nativeObjectsMessageSend(syncClientImpl.getHandle(), this.builderHandle);
        }

        private void checkNotSent() {
            if (this.sent) {
                throw new IllegalStateException("Already sent this message, start a new one instead.");
            }
        }
    }
}

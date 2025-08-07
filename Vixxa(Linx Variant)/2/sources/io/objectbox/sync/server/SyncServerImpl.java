package io.objectbox.sync.server;

import io.objectbox.sync.SyncCredentials;
import io.objectbox.sync.SyncCredentialsToken;
import io.objectbox.sync.listener.SyncChangeListener;
import javax.annotation.Nullable;

public class SyncServerImpl implements SyncServer {
    private volatile long handle;
    @Nullable
    private volatile SyncChangeListener syncChangeListener;
    private final String url;

    private native void nativeAddPeer(long j, String str, long j2, @Nullable byte[] bArr);

    private static native long nativeCreate(long j, String str, @Nullable String str2);

    private native void nativeDelete(long j);

    private native int nativeGetPort(long j);

    private native String nativeGetStatsString(long j);

    private native boolean nativeIsRunning(long j);

    private native void nativeSetAuthenticator(long j, long j2, @Nullable byte[] bArr);

    private native void nativeSetSyncChangesListener(long j, @Nullable SyncChangeListener syncChangeListener2);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    SyncServerImpl(SyncServerBuilder syncServerBuilder) {
        SyncCredentials.CredentialsType credentialsType;
        String str = syncServerBuilder.url;
        this.url = str;
        long nativeCreate = nativeCreate(syncServerBuilder.boxStore.getNativeStore(), str, syncServerBuilder.certificatePath);
        if (nativeCreate != 0) {
            this.handle = nativeCreate;
            for (SyncCredentials next : syncServerBuilder.credentials) {
                if (next instanceof SyncCredentialsToken) {
                    SyncCredentialsToken syncCredentialsToken = (SyncCredentialsToken) next;
                    if (syncCredentialsToken.getType() == SyncCredentials.CredentialsType.SHARED_SECRET_SIPPED) {
                        credentialsType = SyncCredentials.CredentialsType.SHARED_SECRET;
                    } else {
                        credentialsType = syncCredentialsToken.getType();
                    }
                    nativeSetAuthenticator(nativeCreate, credentialsType.id, syncCredentialsToken.getTokenBytes());
                    syncCredentialsToken.clear();
                } else {
                    throw new IllegalArgumentException("Sync credentials of type " + next.getType() + " are not supported");
                }
            }
            for (PeerInfo next2 : syncServerBuilder.peers) {
                SyncCredentialsToken syncCredentialsToken2 = (SyncCredentialsToken) next2.credentials;
                nativeAddPeer(nativeCreate, next2.url, syncCredentialsToken2.getTypeId(), syncCredentialsToken2.getTokenBytes());
            }
            if (syncServerBuilder.changeListener != null) {
                setSyncChangeListener(syncServerBuilder.changeListener);
                return;
            }
            return;
        }
        throw new RuntimeException("Failed to create sync server: handle is zero.");
    }

    private long getHandle() {
        long j = this.handle;
        if (j != 0) {
            return j;
        }
        throw new IllegalStateException("SyncServer already closed");
    }

    public String getUrl() {
        return this.url;
    }

    public int getPort() {
        return nativeGetPort(getHandle());
    }

    public boolean isRunning() {
        return nativeIsRunning(getHandle());
    }

    public String getStatsString() {
        return nativeGetStatsString(getHandle());
    }

    public void setSyncChangeListener(@Nullable SyncChangeListener syncChangeListener2) {
        this.syncChangeListener = syncChangeListener2;
        nativeSetSyncChangesListener(getHandle(), syncChangeListener2);
    }

    public void start() {
        nativeStart(getHandle());
    }

    public void stop() {
        nativeStop(getHandle());
    }

    public void close() {
        long j = this.handle;
        this.handle = 0;
        if (j != 0) {
            nativeDelete(j);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}

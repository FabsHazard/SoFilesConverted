package io.objectbox.sync;

import io.objectbox.sync.SyncCredentials;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.annotation.Nullable;

public final class SyncCredentialsToken extends SyncCredentials {
    private volatile boolean cleared;
    @Nullable
    private byte[] token;

    SyncCredentialsToken(SyncCredentials.CredentialsType credentialsType) {
        super(credentialsType);
        this.token = null;
    }

    SyncCredentialsToken(SyncCredentials.CredentialsType credentialsType, byte[] bArr) {
        this(credentialsType);
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Token must not be empty");
        }
        this.token = bArr;
    }

    SyncCredentialsToken(SyncCredentials.CredentialsType credentialsType, String str) {
        this(credentialsType, str.getBytes(StandardCharsets.UTF_8));
    }

    @Nullable
    public byte[] getTokenBytes() {
        if (!this.cleared) {
            return this.token;
        }
        throw new IllegalStateException("Credentials already have been cleared");
    }

    public void clear() {
        this.cleared = true;
        byte[] bArr = this.token;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
        this.token = null;
    }
}

package io.objectbox.sync;

import io.objectbox.sync.SyncCredentials;

public final class SyncCredentialsUserPassword extends SyncCredentials {
    private final String password;
    private final String username;

    SyncCredentialsUserPassword(String str, String str2) {
        super(SyncCredentials.CredentialsType.USER_PASSWORD);
        this.username = str;
        this.password = str2;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}

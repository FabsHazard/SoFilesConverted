package io.objectbox.sync;

public class SyncCredentials {
    private final CredentialsType type;

    public static SyncCredentials sharedSecret(String str) {
        return new SyncCredentialsToken(CredentialsType.SHARED_SECRET_SIPPED, str);
    }

    public static SyncCredentials sharedSecret(byte[] bArr) {
        return new SyncCredentialsToken(CredentialsType.SHARED_SECRET_SIPPED, bArr);
    }

    public static SyncCredentials google(String str) {
        return new SyncCredentialsToken(CredentialsType.GOOGLE, str);
    }

    public static SyncCredentials userAndPassword(String str, String str2) {
        return new SyncCredentialsUserPassword(str, str2);
    }

    public static SyncCredentials none() {
        return new SyncCredentialsToken(CredentialsType.NONE);
    }

    public enum CredentialsType {
        NONE(1),
        SHARED_SECRET(2),
        GOOGLE(3),
        SHARED_SECRET_SIPPED(4),
        OBX_ADMIN_USER(5),
        USER_PASSWORD(6);
        
        public final long id;

        private CredentialsType(long j) {
            this.id = j;
        }
    }

    SyncCredentials(CredentialsType credentialsType) {
        this.type = credentialsType;
    }

    public CredentialsType getType() {
        return this.type;
    }

    public long getTypeId() {
        return this.type.id;
    }
}

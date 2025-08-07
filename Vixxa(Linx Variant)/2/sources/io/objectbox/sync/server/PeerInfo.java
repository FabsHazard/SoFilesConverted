package io.objectbox.sync.server;

import io.objectbox.sync.SyncCredentials;

class PeerInfo {
    SyncCredentials credentials;
    String url;

    PeerInfo(String str, SyncCredentials syncCredentials) {
        this.url = str;
        this.credentials = syncCredentials;
    }
}

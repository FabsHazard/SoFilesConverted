package io.objectbox.sync.listener;

public interface SyncLoginListener {
    void onLoggedIn();

    void onLoginFailed(long j);
}

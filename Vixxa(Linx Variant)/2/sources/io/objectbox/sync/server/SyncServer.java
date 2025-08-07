package io.objectbox.sync.server;

import io.objectbox.sync.listener.SyncChangeListener;
import java.io.Closeable;
import javax.annotation.Nullable;

public interface SyncServer extends Closeable {
    void close();

    int getPort();

    String getStatsString();

    String getUrl();

    boolean isRunning();

    void setSyncChangeListener(@Nullable SyncChangeListener syncChangeListener);

    void start();

    void stop();
}

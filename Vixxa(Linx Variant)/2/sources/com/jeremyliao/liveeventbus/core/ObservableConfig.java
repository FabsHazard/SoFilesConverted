package com.jeremyliao.liveeventbus.core;

public class ObservableConfig {
    Boolean autoClear = null;
    Boolean lifecycleObserverAlwaysActive = null;

    public ObservableConfig lifecycleObserverAlwaysActive(boolean z) {
        this.lifecycleObserverAlwaysActive = Boolean.valueOf(z);
        return this;
    }

    public ObservableConfig autoClear(boolean z) {
        this.autoClear = Boolean.valueOf(z);
        return this;
    }
}

package com.microtech.aidexx.utils.statusbar;

public abstract class OnceReadValue<P, T> {
    private T cacheValue;
    private volatile boolean isRead = false;

    /* access modifiers changed from: protected */
    public abstract T read(P p);

    public T get(P p) {
        if (this.isRead) {
            return this.cacheValue;
        }
        synchronized (this) {
            if (!this.isRead) {
                this.cacheValue = read(p);
                this.isRead = true;
            }
        }
        return this.cacheValue;
    }
}

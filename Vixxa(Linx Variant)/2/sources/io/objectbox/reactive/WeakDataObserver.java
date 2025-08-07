package io.objectbox.reactive;

import java.lang.ref.WeakReference;

public class WeakDataObserver<T> implements DataObserver<T>, DelegatingObserver {
    private DataSubscription subscription;
    private final WeakReference<DataObserver<T>> weakDelegate;

    WeakDataObserver(DataObserver<T> dataObserver) {
        this.weakDelegate = new WeakReference<>(dataObserver);
    }

    public void onData(T t) {
        DataObserver dataObserver = (DataObserver) this.weakDelegate.get();
        if (dataObserver != null) {
            dataObserver.onData(t);
        } else {
            this.subscription.cancel();
        }
    }

    public DataObserver<T> getObserverDelegate() {
        return (DataObserver) this.weakDelegate.get();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WeakDataObserver)) {
            return false;
        }
        DataObserver dataObserver = (DataObserver) this.weakDelegate.get();
        if (dataObserver == null || dataObserver != ((WeakDataObserver) obj).weakDelegate.get()) {
            return super.equals(obj);
        }
        return true;
    }

    public int hashCode() {
        DataObserver dataObserver = (DataObserver) this.weakDelegate.get();
        if (dataObserver != null) {
            return dataObserver.hashCode();
        }
        return super.hashCode();
    }

    public void setSubscription(DataSubscription dataSubscription) {
        this.subscription = dataSubscription;
    }
}

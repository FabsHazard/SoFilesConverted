package io.objectbox.reactive;

import javax.annotation.Nullable;

class DataSubscriptionImpl<T> implements DataSubscription {
    private volatile boolean canceled;
    private DataObserver<T> observer;
    private DataPublisher<T> publisher;
    private Object publisherParam;

    DataSubscriptionImpl(DataPublisher<T> dataPublisher, @Nullable Object obj, DataObserver<T> dataObserver) {
        this.publisher = dataPublisher;
        this.publisherParam = obj;
        this.observer = dataObserver;
    }

    public synchronized void cancel() {
        this.canceled = true;
        DataPublisher<T> dataPublisher = this.publisher;
        if (dataPublisher != null) {
            dataPublisher.unsubscribe(this.observer, this.publisherParam);
            this.publisher = null;
            this.observer = null;
            this.publisherParam = null;
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }
}

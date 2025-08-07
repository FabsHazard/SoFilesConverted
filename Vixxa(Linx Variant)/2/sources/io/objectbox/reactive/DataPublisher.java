package io.objectbox.reactive;

import javax.annotation.Nullable;

public interface DataPublisher<T> {
    void publishSingle(DataObserver<T> dataObserver, @Nullable Object obj);

    void subscribe(DataObserver<T> dataObserver, @Nullable Object obj);

    void unsubscribe(DataObserver<T> dataObserver, @Nullable Object obj);
}

package io.objectbox.reactive;

public interface DelegatingObserver<T> {
    DataObserver<T> getObserverDelegate();
}

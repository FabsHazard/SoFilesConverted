package io.objectbox.internal;

public interface IdGetter<T> {
    long getId(T t);
}

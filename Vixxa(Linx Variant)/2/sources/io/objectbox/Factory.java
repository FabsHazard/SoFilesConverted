package io.objectbox;

public interface Factory<T> {
    T provide() throws Exception;
}

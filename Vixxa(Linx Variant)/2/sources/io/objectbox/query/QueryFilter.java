package io.objectbox.query;

public interface QueryFilter<T> {
    boolean keep(T t);
}

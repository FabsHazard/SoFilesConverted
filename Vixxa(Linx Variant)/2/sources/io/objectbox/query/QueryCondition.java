package io.objectbox.query;

public interface QueryCondition<T> {
    QueryCondition<T> and(QueryCondition<T> queryCondition);

    QueryCondition<T> or(QueryCondition<T> queryCondition);
}

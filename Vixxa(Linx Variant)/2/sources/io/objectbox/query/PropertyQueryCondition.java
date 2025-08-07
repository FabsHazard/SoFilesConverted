package io.objectbox.query;

public interface PropertyQueryCondition<T> extends QueryCondition<T> {
    QueryCondition<T> alias(String str);
}

package io.objectbox.query;

import io.objectbox.query.LogicQueryCondition;

abstract class QueryConditionImpl<T> implements QueryCondition<T> {
    /* access modifiers changed from: package-private */
    public abstract void apply(QueryBuilder<T> queryBuilder);

    QueryConditionImpl() {
    }

    public QueryCondition<T> and(QueryCondition<T> queryCondition) {
        return new LogicQueryCondition.AndCondition(this, (QueryConditionImpl) queryCondition);
    }

    public QueryCondition<T> or(QueryCondition<T> queryCondition) {
        return new LogicQueryCondition.OrCondition(this, (QueryConditionImpl) queryCondition);
    }
}

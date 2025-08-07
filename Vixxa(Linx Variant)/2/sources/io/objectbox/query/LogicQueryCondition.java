package io.objectbox.query;

abstract class LogicQueryCondition<T> extends QueryConditionImpl<T> {
    private final QueryConditionImpl<T> leftCondition;
    private final QueryConditionImpl<T> rightCondition;

    /* access modifiers changed from: package-private */
    public abstract void applyOperator(QueryBuilder<T> queryBuilder, long j, long j2);

    LogicQueryCondition(QueryConditionImpl<T> queryConditionImpl, QueryConditionImpl<T> queryConditionImpl2) {
        this.leftCondition = queryConditionImpl;
        this.rightCondition = queryConditionImpl2;
    }

    /* access modifiers changed from: package-private */
    public void apply(QueryBuilder<T> queryBuilder) {
        this.leftCondition.apply(queryBuilder);
        long internalGetLastCondition = queryBuilder.internalGetLastCondition();
        this.rightCondition.apply(queryBuilder);
        applyOperator(queryBuilder, internalGetLastCondition, queryBuilder.internalGetLastCondition());
    }

    static class AndCondition<T> extends LogicQueryCondition<T> {
        AndCondition(QueryConditionImpl<T> queryConditionImpl, QueryConditionImpl<T> queryConditionImpl2) {
            super(queryConditionImpl, queryConditionImpl2);
        }

        /* access modifiers changed from: package-private */
        public void applyOperator(QueryBuilder<T> queryBuilder, long j, long j2) {
            queryBuilder.internalAnd(j, j2);
        }
    }

    static class OrCondition<T> extends LogicQueryCondition<T> {
        OrCondition(QueryConditionImpl<T> queryConditionImpl, QueryConditionImpl<T> queryConditionImpl2) {
            super(queryConditionImpl, queryConditionImpl2);
        }

        /* access modifiers changed from: package-private */
        public void applyOperator(QueryBuilder<T> queryBuilder, long j, long j2) {
            queryBuilder.internalOr(j, j2);
        }
    }
}

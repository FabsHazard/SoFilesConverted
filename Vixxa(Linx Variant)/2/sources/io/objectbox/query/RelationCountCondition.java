package io.objectbox.query;

import io.objectbox.relation.RelationInfo;

public class RelationCountCondition<T> extends QueryConditionImpl<T> {
    private final int relationCount;
    private final RelationInfo<T, ?> relationInfo;

    public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
        return super.and(queryCondition);
    }

    public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
        return super.or(queryCondition);
    }

    public RelationCountCondition(RelationInfo<T, ?> relationInfo2, int i) {
        this.relationInfo = relationInfo2;
        this.relationCount = i;
    }

    /* access modifiers changed from: package-private */
    public void apply(QueryBuilder<T> queryBuilder) {
        queryBuilder.relationCount(this.relationInfo, this.relationCount);
    }
}

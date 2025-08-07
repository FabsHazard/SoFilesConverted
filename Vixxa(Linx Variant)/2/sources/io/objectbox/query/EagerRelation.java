package io.objectbox.query;

import io.objectbox.relation.RelationInfo;

class EagerRelation<S, T> {
    public final int limit;
    public final RelationInfo<S, T> relationInfo;

    EagerRelation(int i, RelationInfo<S, T> relationInfo2) {
        this.limit = i;
        this.relationInfo = relationInfo2;
    }
}

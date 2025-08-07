package io.objectbox.relation;

import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.query.QueryCondition;
import io.objectbox.query.RelationCountCondition;
import java.io.Serializable;

public class RelationInfo<SOURCE, TARGET> implements Serializable {
    private static final long serialVersionUID = 7412962174183812632L;
    public final ToManyGetter<TARGET, SOURCE> backlinkToManyGetter;
    public final ToOneGetter<TARGET, SOURCE> backlinkToOneGetter;
    public final int relationId;
    public final EntityInfo<SOURCE> sourceInfo;
    public final Property<?> targetIdProperty;
    public final EntityInfo<TARGET> targetInfo;
    public final int targetRelationId;
    public final ToManyGetter<SOURCE, TARGET> toManyGetter;
    public final ToOneGetter<SOURCE, TARGET> toOneGetter;

    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, Property<SOURCE> property, ToOneGetter<SOURCE, TARGET> toOneGetter2) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.targetIdProperty = property;
        this.toOneGetter = toOneGetter2;
        this.targetRelationId = 0;
        this.backlinkToOneGetter = null;
        this.backlinkToManyGetter = null;
        this.toManyGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, ToManyGetter<SOURCE, TARGET> toManyGetter2, Property<TARGET> property, ToOneGetter<TARGET, SOURCE> toOneGetter2) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.targetIdProperty = property;
        this.toManyGetter = toManyGetter2;
        this.backlinkToOneGetter = toOneGetter2;
        this.targetRelationId = 0;
        this.toOneGetter = null;
        this.backlinkToManyGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, ToManyGetter<SOURCE, TARGET> toManyGetter2, ToManyGetter<TARGET, SOURCE> toManyGetter3, int i) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.toManyGetter = toManyGetter2;
        this.targetRelationId = i;
        this.backlinkToManyGetter = toManyGetter3;
        this.targetIdProperty = null;
        this.toOneGetter = null;
        this.backlinkToOneGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(EntityInfo<SOURCE> entityInfo, EntityInfo<TARGET> entityInfo2, ToManyGetter<SOURCE, TARGET> toManyGetter2, int i) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.toManyGetter = toManyGetter2;
        this.relationId = i;
        this.targetRelationId = 0;
        this.targetIdProperty = null;
        this.toOneGetter = null;
        this.backlinkToOneGetter = null;
        this.backlinkToManyGetter = null;
    }

    public boolean isBacklink() {
        return (this.backlinkToManyGetter == null && this.backlinkToOneGetter == null) ? false : true;
    }

    public String toString() {
        return "RelationInfo from " + this.sourceInfo.getEntityClass() + " to " + this.targetInfo.getEntityClass();
    }

    public QueryCondition<SOURCE> relationCount(int i) {
        if (this.targetIdProperty != null) {
            return new RelationCountCondition(this, i);
        }
        throw new IllegalStateException("The relation count condition is only supported for 1:N (ToMany using @Backlink) relations.");
    }
}

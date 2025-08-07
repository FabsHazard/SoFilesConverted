package io.objectbox.relation;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.exception.DbDetachedException;
import io.objectbox.internal.ReflectionCache;
import java.io.Serializable;
import java.lang.reflect.Field;
import javax.annotation.Nullable;

public class ToOne<TARGET> implements Serializable {
    private static final long serialVersionUID = 5092547044335989281L;
    private transient BoxStore boxStore;
    private boolean checkIdOfTargetForPut;
    private boolean debugRelations;
    private final Object entity;
    private transient Box<Object> entityBox;
    private final RelationInfo<Object, TARGET> relationInfo;
    private volatile long resolvedTargetId;
    private TARGET target;
    private volatile transient Box<TARGET> targetBox;
    private long targetId;
    private transient Field targetIdField;
    private final boolean virtualProperty;

    public ToOne(Object obj, RelationInfo<?, TARGET> relationInfo2) {
        if (obj == null) {
            throw new IllegalArgumentException("No source entity given (null)");
        } else if (relationInfo2 != null) {
            this.entity = obj;
            this.relationInfo = relationInfo2;
            this.virtualProperty = relationInfo2.targetIdProperty.isVirtual;
        } else {
            throw new IllegalArgumentException("No relation info given (null)");
        }
    }

    public TARGET getTarget() {
        return getTarget(getTargetId());
    }

    public TARGET getTarget(long j) {
        synchronized (this) {
            if (this.resolvedTargetId == j) {
                TARGET target2 = this.target;
                return target2;
            }
            ensureBoxes((Object) null);
            TARGET target3 = this.targetBox.get(j);
            setResolvedTarget(target3, j);
            return target3;
        }
    }

    private void ensureBoxes(@Nullable TARGET target2) {
        if (this.targetBox == null) {
            try {
                BoxStore boxStore2 = (BoxStore) ReflectionCache.getInstance().getField(this.entity.getClass(), "__boxStore").get(this.entity);
                this.boxStore = boxStore2;
                if (boxStore2 == null) {
                    if (target2 != null) {
                        this.boxStore = (BoxStore) ReflectionCache.getInstance().getField(target2.getClass(), "__boxStore").get(target2);
                    }
                    if (this.boxStore == null) {
                        throw new DbDetachedException("Cannot resolve relation for detached entities, call box.attach(entity) beforehand.");
                    }
                }
                this.debugRelations = this.boxStore.isDebugRelations();
                this.entityBox = this.boxStore.boxFor(this.relationInfo.sourceInfo.getEntityClass());
                this.targetBox = this.boxStore.boxFor(this.relationInfo.targetInfo.getEntityClass());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public TARGET getCachedTarget() {
        return this.target;
    }

    public boolean isResolved() {
        return this.resolvedTargetId == getTargetId();
    }

    public boolean isResolvedAndNotNull() {
        return this.resolvedTargetId != 0 && this.resolvedTargetId == getTargetId();
    }

    public boolean isNull() {
        return getTargetId() == 0 && this.target == null;
    }

    public void setTargetId(long j) {
        if (this.virtualProperty) {
            this.targetId = j;
        } else {
            try {
                getTargetIdField().set(this.entity, Long.valueOf(j));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Could not update to-one ID in entity", e);
            }
        }
        if (j != 0) {
            this.checkIdOfTargetForPut = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAndUpdateTargetId(long j) {
        setTargetId(j);
        ensureBoxes((Object) null);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setTarget(@Nullable TARGET target2) {
        if (target2 != null) {
            long id = this.relationInfo.targetInfo.getIdGetter().getId(target2);
            this.checkIdOfTargetForPut = id == 0;
            setTargetId(id);
            setResolvedTarget(target2, id);
            return;
        }
        setTargetId(0);
        clearResolved();
    }

    public void setAndPutTarget(@Nullable TARGET target2) {
        ensureBoxes(target2);
        if (target2 != null) {
            long id = this.targetBox.getId(target2);
            if (id == 0) {
                setAndPutTargetAlways(target2);
                return;
            }
            setTargetId(id);
            setResolvedTarget(target2, id);
            this.entityBox.put(this.entity);
            return;
        }
        setTargetId(0);
        clearResolved();
        this.entityBox.put(this.entity);
    }

    public void setAndPutTargetAlways(@Nullable TARGET target2) {
        ensureBoxes(target2);
        if (target2 != null) {
            this.boxStore.runInTx(new ToOne$$ExternalSyntheticLambda0(this, target2));
            return;
        }
        setTargetId(0);
        clearResolved();
        this.entityBox.put(this.entity);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setAndPutTargetAlways$0$io-objectbox-relation-ToOne  reason: not valid java name */
    public /* synthetic */ void m336lambda$setAndPutTargetAlways$0$ioobjectboxrelationToOne(Object obj) {
        setResolvedTarget(obj, this.targetBox.put(obj));
        this.entityBox.put(this.entity);
    }

    private synchronized void setResolvedTarget(@Nullable TARGET target2, long j) {
        if (this.debugRelations) {
            System.out.println("Setting resolved ToOne target to " + (target2 == null ? "null" : "non-null") + " for ID " + j);
        }
        this.resolvedTargetId = j;
        this.target = target2;
    }

    private synchronized void clearResolved() {
        this.resolvedTargetId = 0;
        this.target = null;
    }

    public long getTargetId() {
        if (this.virtualProperty) {
            return this.targetId;
        }
        Field targetIdField2 = getTargetIdField();
        try {
            Long l = (Long) targetIdField2.get(this.entity);
            if (l != null) {
                return l.longValue();
            }
            return 0;
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("Could not access field " + targetIdField2);
        }
    }

    private Field getTargetIdField() {
        if (this.targetIdField == null) {
            this.targetIdField = ReflectionCache.getInstance().getField(this.entity.getClass(), this.relationInfo.targetIdProperty.name);
        }
        return this.targetIdField;
    }

    public boolean internalRequiresPutTarget() {
        return this.checkIdOfTargetForPut && this.target != null && getTargetId() == 0;
    }

    public void internalPutTarget(Cursor<TARGET> cursor) {
        this.checkIdOfTargetForPut = false;
        long put = cursor.put(this.target);
        setTargetId(put);
        setResolvedTarget(this.target, put);
    }

    /* access modifiers changed from: package-private */
    public Object getEntity() {
        return this.entity;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ToOne)) {
            return false;
        }
        ToOne toOne = (ToOne) obj;
        if (this.relationInfo == toOne.relationInfo && getTargetId() == toOne.getTargetId()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long targetId2 = getTargetId();
        return (int) (targetId2 ^ (targetId2 >>> 32));
    }
}

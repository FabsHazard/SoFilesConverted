package io.objectbox.relation;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.InternalAccess;
import io.objectbox.exception.DbDetachedException;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ReflectionCache;
import io.objectbox.internal.ToManyGetter;
import io.objectbox.internal.ToOneGetter;
import io.objectbox.query.QueryFilter;
import io.objectbox.relation.ListFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ToMany<TARGET> implements List<TARGET>, Serializable {
    private static final Integer ONE = 1;
    private static final long serialVersionUID = 2367317778240689006L;
    private transient BoxStore boxStore;
    private transient Comparator<TARGET> comparator;
    private List<TARGET> entities;
    private volatile Map<TARGET, Boolean> entitiesAdded;
    private Map<TARGET, Boolean> entitiesRemoved;
    List<TARGET> entitiesToPut;
    List<TARGET> entitiesToRemoveFromDb;
    private final Object entity;
    private transient Box<Object> entityBox;
    private Map<TARGET, Integer> entityCounts;
    private volatile ListFactory listFactory;
    /* access modifiers changed from: private */
    public final RelationInfo<Object, TARGET> relationInfo;
    private transient boolean removeFromTargetBox;
    private volatile transient Box<TARGET> targetBox;

    public ToMany(Object obj, RelationInfo<?, TARGET> relationInfo2) {
        if (obj == null) {
            throw new IllegalArgumentException("No source entity given (null)");
        } else if (relationInfo2 != null) {
            this.entity = obj;
            this.relationInfo = relationInfo2;
        } else {
            throw new IllegalArgumentException("No relation info given (null)");
        }
    }

    public void setListFactory(ListFactory listFactory2) {
        if (listFactory2 != null) {
            this.listFactory = listFactory2;
            return;
        }
        throw new IllegalArgumentException("ListFactory is null");
    }

    public void setComparator(Comparator<TARGET> comparator2) {
        this.comparator = comparator2;
    }

    public synchronized void setRemoveFromTargetBox(boolean z) {
        this.removeFromTargetBox = z;
    }

    public ListFactory getListFactory() {
        ListFactory listFactory2 = this.listFactory;
        if (listFactory2 == null) {
            synchronized (this) {
                listFactory2 = this.listFactory;
                if (listFactory2 == null) {
                    listFactory2 = new ListFactory.CopyOnWriteArrayListFactory();
                    this.listFactory = listFactory2;
                }
            }
        }
        return listFactory2;
    }

    private void ensureBoxes() {
        if (this.targetBox == null) {
            try {
                BoxStore boxStore2 = (BoxStore) ReflectionCache.getInstance().getField(this.entity.getClass(), "__boxStore").get(this.entity);
                this.boxStore = boxStore2;
                if (boxStore2 != null) {
                    this.entityBox = boxStore2.boxFor(this.relationInfo.sourceInfo.getEntityClass());
                    this.targetBox = this.boxStore.boxFor(this.relationInfo.targetInfo.getEntityClass());
                    return;
                }
                throw new DbDetachedException("Cannot resolve relation for detached objects, call box.attach(object) beforehand.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void ensureEntitiesWithTrackingLists() {
        ensureEntities();
        if (this.entitiesAdded == null) {
            synchronized (this) {
                if (this.entitiesAdded == null) {
                    this.entitiesAdded = new LinkedHashMap();
                    this.entitiesRemoved = new LinkedHashMap();
                    this.entityCounts = new HashMap();
                    for (TARGET next : this.entities) {
                        Integer put = this.entityCounts.put(next, ONE);
                        if (put != null) {
                            this.entityCounts.put(next, Integer.valueOf(put.intValue() + 1));
                        }
                    }
                }
            }
        }
    }

    private void ensureEntities() {
        List<TARGET> list;
        if (this.entities == null) {
            long id = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
            if (id == 0) {
                synchronized (this) {
                    if (this.entities == null) {
                        this.entities = getListFactory().createList();
                    }
                }
                return;
            }
            ensureBoxes();
            int i = this.relationInfo.relationId;
            if (i != 0) {
                list = this.targetBox.internalGetRelationEntities(this.relationInfo.sourceInfo.getEntityId(), i, id, false);
            } else if (this.relationInfo.targetIdProperty != null) {
                list = this.targetBox.internalGetBacklinkEntities(this.relationInfo.targetInfo.getEntityId(), this.relationInfo.targetIdProperty, id);
            } else {
                list = this.targetBox.internalGetRelationEntities(this.relationInfo.targetInfo.getEntityId(), this.relationInfo.targetRelationId, id, true);
            }
            Comparator<TARGET> comparator2 = this.comparator;
            if (comparator2 != null) {
                Collections.sort(list, comparator2);
            }
            synchronized (this) {
                if (this.entities == null) {
                    this.entities = list;
                }
            }
        }
    }

    public synchronized boolean add(TARGET target) {
        trackAdd(target);
        return this.entities.add(target);
    }

    private void trackAdd(TARGET target) {
        ensureEntitiesWithTrackingLists();
        Integer put = this.entityCounts.put(target, ONE);
        if (put != null) {
            this.entityCounts.put(target, Integer.valueOf(put.intValue() + 1));
        }
        this.entitiesAdded.put(target, Boolean.TRUE);
        this.entitiesRemoved.remove(target);
    }

    private void trackAdd(Collection<? extends TARGET> collection) {
        ensureEntitiesWithTrackingLists();
        for (Object trackAdd : collection) {
            trackAdd(trackAdd);
        }
    }

    private void trackRemove(TARGET target) {
        ensureEntitiesWithTrackingLists();
        Integer remove = this.entityCounts.remove(target);
        if (remove == null) {
            return;
        }
        if (remove.intValue() == 1) {
            this.entityCounts.remove(target);
            this.entitiesAdded.remove(target);
            this.entitiesRemoved.put(target, Boolean.TRUE);
        } else if (remove.intValue() > 1) {
            this.entityCounts.put(target, Integer.valueOf(remove.intValue() - 1));
        } else {
            throw new IllegalStateException("Illegal count: " + remove);
        }
    }

    public synchronized void add(int i, TARGET target) {
        trackAdd(target);
        this.entities.add(i, target);
    }

    public synchronized boolean addAll(Collection<? extends TARGET> collection) {
        trackAdd(collection);
        return this.entities.addAll(collection);
    }

    public synchronized boolean addAll(int i, Collection<? extends TARGET> collection) {
        trackAdd(collection);
        return this.entities.addAll(i, collection);
    }

    public synchronized void clear() {
        ensureEntitiesWithTrackingLists();
        List<TARGET> list = this.entities;
        if (list != null) {
            for (TARGET put : list) {
                this.entitiesRemoved.put(put, Boolean.TRUE);
            }
            list.clear();
        }
        Map<TARGET, Boolean> map = this.entitiesAdded;
        if (map != null) {
            map.clear();
        }
        Map<TARGET, Integer> map2 = this.entityCounts;
        if (map2 != null) {
            map2.clear();
        }
    }

    public boolean contains(Object obj) {
        ensureEntities();
        return this.entities.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        ensureEntities();
        return this.entities.containsAll(collection);
    }

    public TARGET get(int i) {
        ensureEntities();
        return this.entities.get(i);
    }

    public int indexOf(Object obj) {
        ensureEntities();
        return this.entities.indexOf(obj);
    }

    public boolean isEmpty() {
        ensureEntities();
        return this.entities.isEmpty();
    }

    @Nonnull
    public Iterator<TARGET> iterator() {
        ensureEntities();
        return this.entities.iterator();
    }

    public int lastIndexOf(Object obj) {
        ensureEntities();
        return this.entities.lastIndexOf(obj);
    }

    @Nonnull
    public ListIterator<TARGET> listIterator() {
        ensureEntities();
        return this.entities.listIterator();
    }

    @Nonnull
    public ListIterator<TARGET> listIterator(int i) {
        ensureEntities();
        return this.entities.listIterator(i);
    }

    public synchronized TARGET remove(int i) {
        TARGET remove;
        ensureEntitiesWithTrackingLists();
        remove = this.entities.remove(i);
        trackRemove(remove);
        return remove;
    }

    public synchronized boolean remove(Object obj) {
        boolean remove;
        ensureEntitiesWithTrackingLists();
        remove = this.entities.remove(obj);
        if (remove) {
            trackRemove(obj);
        }
        return remove;
    }

    public synchronized TARGET removeById(long j) {
        ensureEntities();
        int size = this.entities.size();
        IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        for (int i = 0; i < size; i++) {
            TARGET target = this.entities.get(i);
            if (idGetter.getId(target) == j) {
                TARGET remove = remove(i);
                if (remove == target) {
                    return target;
                }
                throw new IllegalStateException("Mismatch: " + remove + " vs. " + target);
            }
        }
        return null;
    }

    public synchronized boolean removeAll(Collection<?> collection) {
        boolean z;
        z = false;
        for (Object remove : collection) {
            z |= remove((Object) remove);
        }
        return z;
    }

    public synchronized boolean retainAll(Collection<?> collection) {
        boolean z;
        ensureEntitiesWithTrackingLists();
        z = false;
        ArrayList arrayList = null;
        for (TARGET next : this.entities) {
            if (!collection.contains(next)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
                z = true;
            }
        }
        if (arrayList != null) {
            removeAll(arrayList);
        }
        return z;
    }

    public synchronized TARGET set(int i, TARGET target) {
        TARGET target2;
        ensureEntitiesWithTrackingLists();
        target2 = this.entities.set(i, target);
        trackRemove(target2);
        trackAdd(target);
        return target2;
    }

    public int size() {
        ensureEntities();
        return this.entities.size();
    }

    @Nonnull
    public List<TARGET> subList(int i, int i2) {
        ensureEntities();
        return this.entities.subList(i, i2);
    }

    @Nonnull
    public Object[] toArray() {
        ensureEntities();
        return this.entities.toArray();
    }

    @Nonnull
    public <T> T[] toArray(T[] tArr) {
        ensureEntities();
        return this.entities.toArray(tArr);
    }

    public synchronized void reset() {
        this.entities = null;
        this.entitiesAdded = null;
        this.entitiesRemoved = null;
        this.entitiesToRemoveFromDb = null;
        this.entitiesToPut = null;
        this.entityCounts = null;
    }

    public boolean isResolved() {
        return this.entities != null;
    }

    public int getAddCount() {
        Map<TARGET, Boolean> map = this.entitiesAdded;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public int getRemoveCount() {
        Map<TARGET, Boolean> map = this.entitiesRemoved;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public void sortById() {
        ensureEntities();
        Collections.sort(this.entities, new Comparator<TARGET>() {
            IdGetter<TARGET> idGetter;

            {
                this.idGetter = ToMany.this.relationInfo.targetInfo.getIdGetter();
            }

            public int compare(TARGET target, TARGET target2) {
                long id = this.idGetter.getId(target);
                long id2 = this.idGetter.getId(target2);
                if (id == 0) {
                    id = Long.MAX_VALUE;
                }
                if (id2 == 0) {
                    id2 = Long.MAX_VALUE;
                }
                int i = ((id - id2) > 0 ? 1 : ((id - id2) == 0 ? 0 : -1));
                if (i < 0) {
                    return -1;
                }
                return i > 0 ? 1 : 0;
            }
        });
    }

    public void applyChangesToDb() {
        if (this.relationInfo.sourceInfo.getIdGetter().getId(this.entity) != 0) {
            try {
                ensureBoxes();
                if (internalCheckApplyToDbRequired()) {
                    this.boxStore.runInTx(new ToMany$$ExternalSyntheticLambda0(this));
                }
            } catch (DbDetachedException unused) {
                throw new IllegalStateException("The object with the ToMany was not yet persisted, use box.put() on it instead");
            }
        } else {
            throw new IllegalStateException("The object with the ToMany was not yet persisted (no ID), use box.put() on it instead");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$applyChangesToDb$0$io-objectbox-relation-ToMany  reason: not valid java name */
    public /* synthetic */ void m335lambda$applyChangesToDb$0$ioobjectboxrelationToMany() {
        internalApplyToDb(InternalAccess.getActiveTxCursor(this.entityBox), InternalAccess.getActiveTxCursor(this.targetBox));
    }

    public boolean hasA(QueryFilter<TARGET> queryFilter) {
        for (Object keep : toArray()) {
            if (queryFilter.keep(keep)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAll(QueryFilter<TARGET> queryFilter) {
        Object[] array = toArray();
        if (array.length == 0) {
            return false;
        }
        for (Object keep : array) {
            if (!queryFilter.keep(keep)) {
                return false;
            }
        }
        return true;
    }

    public TARGET getById(long j) {
        ensureEntities();
        TARGET[] array = this.entities.toArray();
        IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        for (TARGET target : array) {
            if (idGetter.getId(target) == j) {
                return target;
            }
        }
        return null;
    }

    public int indexOfId(long j) {
        ensureEntities();
        Object[] array = this.entities.toArray();
        IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        int i = 0;
        for (Object id : array) {
            if (idGetter.getId(id) == j) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean hasPendingDbChanges() {
        Map<TARGET, Boolean> map = this.entitiesAdded;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        Map<TARGET, Boolean> map2 = this.entitiesRemoved;
        if (map2 == null || map2.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean internalCheckApplyToDbRequired() {
        if (!hasPendingDbChanges()) {
            return false;
        }
        synchronized (this) {
            if (this.entitiesToPut == null) {
                this.entitiesToPut = new ArrayList();
                this.entitiesToRemoveFromDb = new ArrayList();
            }
        }
        if (this.relationInfo.relationId != 0) {
            return true;
        }
        long id = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
        if (id != 0) {
            IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
            Map<TARGET, Boolean> map = this.entitiesAdded;
            Map<TARGET, Boolean> map2 = this.entitiesRemoved;
            if (this.relationInfo.targetRelationId != 0) {
                return prepareToManyBacklinkEntitiesForDb(id, idGetter, map, map2);
            }
            return prepareToOneBacklinkEntitiesForDb(id, idGetter, map, map2);
        }
        throw new IllegalStateException("Object with the ToMany has no ID (should have been put before)");
    }

    private boolean prepareToManyBacklinkEntitiesForDb(long j, IdGetter<TARGET> idGetter, @Nullable Map<TARGET, Boolean> map, @Nullable Map<TARGET, Boolean> map2) {
        boolean z;
        ToManyGetter<TARGET, SOURCE> toManyGetter = this.relationInfo.backlinkToManyGetter;
        synchronized (this) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (TARGET next : map.keySet()) {
                            ToMany toMany = (ToMany) toManyGetter.getToMany(next);
                            if (toMany == null) {
                                throw new IllegalStateException("The ToMany property for " + this.relationInfo.targetInfo.getEntityName() + " is null");
                            } else if (toMany.getById(j) == null) {
                                toMany.add(this.entity);
                                this.entitiesToPut.add(next);
                            } else if (idGetter.getId(next) == 0) {
                                this.entitiesToPut.add(next);
                            }
                        }
                        map.clear();
                    }
                } finally {
                }
            }
            if (map2 != null) {
                for (TARGET next2 : map2.keySet()) {
                    ToMany toMany2 = (ToMany) toManyGetter.getToMany(next2);
                    if (toMany2.getById(j) != null) {
                        toMany2.removeById(j);
                        if (idGetter.getId(next2) != 0) {
                            if (this.removeFromTargetBox) {
                                this.entitiesToRemoveFromDb.add(next2);
                            } else {
                                this.entitiesToPut.add(next2);
                            }
                        }
                    }
                }
                map2.clear();
            }
            if (this.entitiesToPut.isEmpty()) {
                if (this.entitiesToRemoveFromDb.isEmpty()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean prepareToOneBacklinkEntitiesForDb(long j, IdGetter<TARGET> idGetter, @Nullable Map<TARGET, Boolean> map, @Nullable Map<TARGET, Boolean> map2) {
        boolean z;
        ToOneGetter<TARGET, SOURCE> toOneGetter = this.relationInfo.backlinkToOneGetter;
        synchronized (this) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        for (TARGET next : map.keySet()) {
                            ToOne<SOURCE> toOne = toOneGetter.getToOne(next);
                            if (toOne == null) {
                                throw new IllegalStateException("The ToOne property for " + this.relationInfo.targetInfo.getEntityName() + "." + this.relationInfo.targetIdProperty.name + " is null");
                            } else if (toOne.getTargetId() != j) {
                                toOne.setTarget(this.entity);
                                this.entitiesToPut.add(next);
                            } else if (idGetter.getId(next) == 0) {
                                this.entitiesToPut.add(next);
                            }
                        }
                        map.clear();
                    }
                } finally {
                }
            }
            if (map2 != null) {
                for (TARGET next2 : map2.keySet()) {
                    ToOne<SOURCE> toOne2 = toOneGetter.getToOne(next2);
                    if (toOne2.getTargetId() == j) {
                        toOne2.setTarget(null);
                        if (idGetter.getId(next2) != 0) {
                            if (this.removeFromTargetBox) {
                                this.entitiesToRemoveFromDb.add(next2);
                            } else {
                                this.entitiesToPut.add(next2);
                            }
                        }
                    }
                }
                map2.clear();
            }
            if (this.entitiesToPut.isEmpty()) {
                if (this.entitiesToRemoveFromDb.isEmpty()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public void internalApplyToDb(Cursor<?> cursor, Cursor<TARGET> cursor2) {
        Object[] objArr;
        Object[] objArr2;
        ArrayList arrayList;
        Object[] array;
        Object[] objArr3;
        Cursor<TARGET> cursor3 = cursor2;
        boolean z = this.relationInfo.relationId != 0;
        IdGetter<TARGET> idGetter = this.relationInfo.targetInfo.getIdGetter();
        synchronized (this) {
            objArr = null;
            if (z) {
                for (TARGET next : this.entitiesAdded.keySet()) {
                    if (idGetter.getId(next) == 0) {
                        this.entitiesToPut.add(next);
                    }
                }
                if (this.removeFromTargetBox) {
                    this.entitiesToRemoveFromDb.addAll(this.entitiesRemoved.keySet());
                }
                if (!this.entitiesAdded.isEmpty()) {
                    objArr3 = this.entitiesAdded.keySet().toArray();
                    this.entitiesAdded.clear();
                } else {
                    objArr3 = null;
                }
                if (!this.entitiesRemoved.isEmpty()) {
                    arrayList = new ArrayList(this.entitiesRemoved.keySet());
                    this.entitiesRemoved.clear();
                } else {
                    arrayList = null;
                }
                objArr2 = objArr3;
            } else {
                arrayList = null;
                objArr2 = null;
            }
            array = this.entitiesToRemoveFromDb.isEmpty() ? null : this.entitiesToRemoveFromDb.toArray();
            this.entitiesToRemoveFromDb.clear();
            if (!this.entitiesToPut.isEmpty()) {
                objArr = this.entitiesToPut.toArray();
            }
            this.entitiesToPut.clear();
        }
        if (array != null) {
            for (Object id : array) {
                long id2 = idGetter.getId(id);
                if (id2 != 0) {
                    cursor3.deleteEntity(id2);
                }
            }
        }
        if (objArr != null) {
            for (Object put : objArr) {
                cursor3.put(put);
            }
        }
        if (z) {
            long id3 = this.relationInfo.sourceInfo.getIdGetter().getId(this.entity);
            if (id3 != 0) {
                if (arrayList != null) {
                    removeStandaloneRelations(cursor, id3, arrayList, idGetter);
                }
                if (objArr2 != null) {
                    addStandaloneRelations(cursor, id3, objArr2, idGetter);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Object with the ToMany has no ID (should have been put before)");
        }
    }

    private void removeStandaloneRelations(Cursor<?> cursor, long j, List<TARGET> list, IdGetter<TARGET> idGetter) {
        Iterator<TARGET> it = list.iterator();
        while (it.hasNext()) {
            if (idGetter.getId(it.next()) == 0) {
                it.remove();
            }
        }
        int size = list.size();
        if (size > 0) {
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                jArr[i] = idGetter.getId(list.get(i));
            }
            cursor.modifyRelations(this.relationInfo.relationId, j, jArr, true);
        }
    }

    private void addStandaloneRelations(Cursor<?> cursor, long j, TARGET[] targetArr, IdGetter<TARGET> idGetter) {
        int length = targetArr.length;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            long id = idGetter.getId(targetArr[i]);
            if (id != 0) {
                jArr[i] = id;
                i++;
            } else {
                throw new IllegalStateException("Target object has no ID (should have been put before)");
            }
        }
        cursor.modifyRelations(this.relationInfo.relationId, j, jArr, false);
    }

    /* access modifiers changed from: package-private */
    public Object getEntity() {
        return this.entity;
    }
}

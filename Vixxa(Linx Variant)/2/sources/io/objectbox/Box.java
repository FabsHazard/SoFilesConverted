package io.objectbox;

import io.objectbox.exception.DbException;
import io.objectbox.internal.CallWithHandle;
import io.objectbox.internal.IdGetter;
import io.objectbox.internal.ReflectionCache;
import io.objectbox.query.QueryBuilder;
import io.objectbox.query.QueryCondition;
import io.objectbox.relation.RelationInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class Box<T> {
    final ThreadLocal<Cursor<T>> activeTxCursor = new ThreadLocal<>();
    private volatile Field boxStoreField;
    private final Class<T> entityClass;
    private EntityInfo<T> entityInfo;
    private final IdGetter<T> idGetter;
    private final BoxStore store;
    private final ThreadLocal<Cursor<T>> threadLocalReader = new ThreadLocal<>();

    private boolean isChanged(T t) {
        return false;
    }

    private boolean putIfChanged(T t) {
        return false;
    }

    Box(BoxStore boxStore, Class<T> cls) {
        this.store = boxStore;
        this.entityClass = cls;
        this.idGetter = boxStore.getEntityInfo(cls).getIdGetter();
    }

    /* access modifiers changed from: package-private */
    public Cursor<T> getReader() {
        Cursor<T> activeTxCursor2 = getActiveTxCursor();
        if (activeTxCursor2 != null) {
            return activeTxCursor2;
        }
        Cursor<T> cursor = this.threadLocalReader.get();
        if (cursor != null) {
            Transaction transaction = cursor.tx;
            if (transaction.isClosed() || !transaction.isRecycled()) {
                throw new IllegalStateException("Illegal reader TX state");
            }
            transaction.renew();
            cursor.renew();
            return cursor;
        }
        Cursor<T> createCursor = this.store.beginReadTx().createCursor(this.entityClass);
        this.threadLocalReader.set(createCursor);
        return createCursor;
    }

    /* access modifiers changed from: package-private */
    public Cursor<T> getActiveTxCursor() {
        Transaction transaction = this.store.activeTx.get();
        if (transaction == null) {
            return null;
        }
        if (!transaction.isClosed()) {
            Cursor<T> cursor = this.activeTxCursor.get();
            if (cursor != null && !cursor.getTx().isClosed()) {
                return cursor;
            }
            Cursor<T> createCursor = transaction.createCursor(this.entityClass);
            this.activeTxCursor.set(createCursor);
            return createCursor;
        }
        throw new IllegalStateException("Active TX is closed");
    }

    /* access modifiers changed from: package-private */
    public Cursor<T> getWriter() {
        Cursor<T> activeTxCursor2 = getActiveTxCursor();
        if (activeTxCursor2 != null) {
            return activeTxCursor2;
        }
        Transaction beginTx = this.store.beginTx();
        try {
            return beginTx.createCursor(this.entityClass);
        } catch (RuntimeException e) {
            beginTx.close();
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public void commitWriter(Cursor<T> cursor) {
        if (this.activeTxCursor.get() == null) {
            cursor.close();
            cursor.getTx().commitAndClose();
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseWriter(Cursor<T> cursor) {
        if (this.activeTxCursor.get() == null) {
            Transaction tx = cursor.getTx();
            if (!tx.isClosed()) {
                cursor.close();
                tx.abort();
                tx.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseReader(Cursor<T> cursor) {
        if (this.activeTxCursor.get() == null) {
            Transaction tx = cursor.getTx();
            if (tx.isClosed() || tx.isRecycled() || !tx.isReadOnly()) {
                throw new IllegalStateException("Illegal reader TX state");
            }
            tx.recycle();
        }
    }

    public void closeThreadResources() {
        Cursor cursor = this.threadLocalReader.get();
        if (cursor != null) {
            cursor.close();
            cursor.getTx().close();
            this.threadLocalReader.remove();
        }
    }

    /* access modifiers changed from: package-private */
    public void txCommitted(Transaction transaction) {
        Cursor cursor = this.activeTxCursor.get();
        if (cursor != null) {
            this.activeTxCursor.remove();
            cursor.close();
        }
    }

    /* access modifiers changed from: package-private */
    public void readTxFinished(Transaction transaction) {
        Cursor cursor = this.activeTxCursor.get();
        if (cursor != null && cursor.getTx() == transaction) {
            this.activeTxCursor.remove();
            cursor.close();
        }
    }

    /* access modifiers changed from: package-private */
    public int getPropertyId(String str) {
        Cursor reader = getReader();
        try {
            return reader.getPropertyId(str);
        } finally {
            releaseReader(reader);
        }
    }

    public long getId(T t) {
        return this.idGetter.getId(t);
    }

    public T get(long j) {
        Cursor reader = getReader();
        try {
            return reader.get(j);
        } finally {
            releaseReader(reader);
        }
    }

    public List<T> get(Iterable<Long> iterable) {
        ArrayList arrayList = new ArrayList();
        Cursor reader = getReader();
        try {
            for (Long longValue : iterable) {
                Object obj = reader.get(longValue.longValue());
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } finally {
            releaseReader(reader);
        }
    }

    public List<T> get(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        Cursor reader = getReader();
        try {
            for (long valueOf : jArr) {
                Object obj = reader.get(Long.valueOf(valueOf).longValue());
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        } finally {
            releaseReader(reader);
        }
    }

    public Map<Long, T> getMap(Iterable<Long> iterable) {
        HashMap hashMap = new HashMap();
        Cursor reader = getReader();
        try {
            for (Long next : iterable) {
                hashMap.put(next, reader.get(next.longValue()));
            }
            return hashMap;
        } finally {
            releaseReader(reader);
        }
    }

    public long count() {
        return count(0);
    }

    public long count(long j) {
        Cursor reader = getReader();
        try {
            return reader.count(j);
        } finally {
            releaseReader(reader);
        }
    }

    public boolean isEmpty() {
        return count(1) == 0;
    }

    public List<T> getAll() {
        ArrayList arrayList = new ArrayList();
        Cursor reader = getReader();
        try {
            for (Object first = reader.first(); first != null; first = reader.next()) {
                arrayList.add(first);
            }
            return arrayList;
        } finally {
            releaseReader(reader);
        }
    }

    public boolean contains(long j) {
        Cursor reader = getReader();
        try {
            return reader.seek(j);
        } finally {
            releaseReader(reader);
        }
    }

    public long put(T t) {
        Cursor writer = getWriter();
        try {
            long put = writer.put(t);
            commitWriter(writer);
            return put;
        } finally {
            releaseWriter(writer);
        }
    }

    @SafeVarargs
    public final void put(@Nullable T... tArr) {
        if (tArr != null && tArr.length != 0) {
            Cursor writer = getWriter();
            try {
                for (T put : tArr) {
                    writer.put(put);
                }
                commitWriter(writer);
            } finally {
                releaseWriter(writer);
            }
        }
    }

    public void put(@Nullable Collection<T> collection) {
        if (collection != null && !collection.isEmpty()) {
            Cursor writer = getWriter();
            try {
                for (T put : collection) {
                    writer.put(put);
                }
                commitWriter(writer);
            } finally {
                releaseWriter(writer);
            }
        }
    }

    public void putBatched(@Nullable Collection<T> collection, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Batch size must be 1 or greater but was " + i);
        } else if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                Cursor writer = getWriter();
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 >= i) {
                        break;
                    }
                    try {
                        if (!it.hasNext()) {
                            break;
                        }
                        writer.put(it.next());
                        i2 = i3;
                    } catch (Throwable th) {
                        releaseWriter(writer);
                        throw th;
                    }
                }
                commitWriter(writer);
                releaseWriter(writer);
            }
        }
    }

    public boolean remove(long j) {
        Cursor writer = getWriter();
        try {
            boolean deleteEntity = writer.deleteEntity(j);
            commitWriter(writer);
            return deleteEntity;
        } finally {
            releaseWriter(writer);
        }
    }

    public void remove(@Nullable long... jArr) {
        if (jArr != null && jArr.length != 0) {
            Cursor writer = getWriter();
            try {
                for (long deleteEntity : jArr) {
                    writer.deleteEntity(deleteEntity);
                }
                commitWriter(writer);
            } finally {
                releaseWriter(writer);
            }
        }
    }

    @Deprecated
    public void removeByKeys(@Nullable Collection<Long> collection) {
        removeByIds(collection);
    }

    public void removeByIds(@Nullable Collection<Long> collection) {
        if (collection != null && !collection.isEmpty()) {
            Cursor writer = getWriter();
            try {
                for (Long longValue : collection) {
                    writer.deleteEntity(longValue.longValue());
                }
                commitWriter(writer);
            } finally {
                releaseWriter(writer);
            }
        }
    }

    public boolean remove(T t) {
        Cursor writer = getWriter();
        try {
            boolean deleteEntity = writer.deleteEntity(writer.getId(t));
            commitWriter(writer);
            return deleteEntity;
        } finally {
            releaseWriter(writer);
        }
    }

    @SafeVarargs
    public final void remove(@Nullable T... tArr) {
        if (tArr != null && tArr.length != 0) {
            Cursor writer = getWriter();
            try {
                for (T id : tArr) {
                    writer.deleteEntity(writer.getId(id));
                }
                commitWriter(writer);
            } finally {
                releaseWriter(writer);
            }
        }
    }

    public void remove(@Nullable Collection<T> collection) {
        if (collection != null && !collection.isEmpty()) {
            Cursor writer = getWriter();
            try {
                for (T id : collection) {
                    writer.deleteEntity(writer.getId(id));
                }
                commitWriter(writer);
            } finally {
                releaseWriter(writer);
            }
        }
    }

    public void removeAll() {
        Cursor writer = getWriter();
        try {
            writer.deleteAll();
            commitWriter(writer);
        } finally {
            releaseWriter(writer);
        }
    }

    public long panicModeRemoveAll() {
        return this.store.panicModeRemoveAllObjects(getEntityInfo().getEntityId());
    }

    public QueryBuilder<T> query() {
        return new QueryBuilder<>(this, this.store.getNativeStore(), this.store.getDbName(this.entityClass));
    }

    public QueryBuilder<T> query(QueryCondition<T> queryCondition) {
        return query().apply(queryCondition);
    }

    public BoxStore getStore() {
        return this.store;
    }

    /* JADX INFO: finally extract failed */
    public synchronized EntityInfo<T> getEntityInfo() {
        if (this.entityInfo == null) {
            Cursor reader = getReader();
            try {
                this.entityInfo = reader.getEntityInfo();
                releaseReader(reader);
            } catch (Throwable th) {
                releaseReader(reader);
                throw th;
            }
        }
        return this.entityInfo;
    }

    public void attach(T t) {
        if (this.boxStoreField == null) {
            try {
                this.boxStoreField = ReflectionCache.getInstance().getField(this.entityClass, "__boxStore");
            } catch (Exception e) {
                throw new DbException("Entity cannot be attached - only active entities with relationships support attaching (class has no __boxStore field(?)) : " + this.entityClass, (Throwable) e);
            }
        }
        try {
            this.boxStoreField.set(t, this.store);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Class<T> getEntityClass() {
        return this.entityClass;
    }

    public List<T> internalGetBacklinkEntities(int i, Property<?> property, long j) {
        Cursor reader = getReader();
        try {
            return reader.getBacklinkEntities(i, property, j);
        } finally {
            releaseReader(reader);
        }
    }

    public List<T> internalGetRelationEntities(int i, int i2, long j, boolean z) {
        Cursor reader = getReader();
        try {
            return reader.getRelationEntities(i, i2, j, z);
        } finally {
            releaseReader(reader);
        }
    }

    public long[] internalGetRelationIds(int i, int i2, long j, boolean z) {
        Cursor reader = getReader();
        try {
            return reader.getRelationIds(i, i2, j, z);
        } finally {
            releaseReader(reader);
        }
    }

    public List<T> getRelationEntities(RelationInfo<?, T> relationInfo, long j) {
        return internalGetRelationEntities(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, false);
    }

    public List<T> getRelationBacklinkEntities(RelationInfo<T, ?> relationInfo, long j) {
        return internalGetRelationEntities(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, true);
    }

    public long[] getRelationIds(RelationInfo<?, T> relationInfo, long j) {
        return internalGetRelationIds(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, false);
    }

    public long[] getRelationBacklinkIds(RelationInfo<T, ?> relationInfo, long j) {
        return internalGetRelationIds(relationInfo.sourceInfo.getEntityId(), relationInfo.relationId, j, true);
    }

    public <RESULT> RESULT internalCallWithReaderHandle(CallWithHandle<RESULT> callWithHandle) {
        Cursor reader = getReader();
        try {
            return callWithHandle.call(reader.internalHandle());
        } finally {
            releaseReader(reader);
        }
    }

    public <RESULT> RESULT internalCallWithWriterHandle(CallWithHandle<RESULT> callWithHandle) {
        Cursor writer = getWriter();
        try {
            RESULT call = callWithHandle.call(writer.internalHandle());
            commitWriter(writer);
            return call;
        } finally {
            releaseWriter(writer);
        }
    }

    public String getReaderDebugInfo() {
        Cursor reader = getReader();
        try {
            return reader + " with " + reader.getTx() + "; store's commit count: " + getStore().commitCount;
        } finally {
            releaseReader(reader);
        }
    }
}

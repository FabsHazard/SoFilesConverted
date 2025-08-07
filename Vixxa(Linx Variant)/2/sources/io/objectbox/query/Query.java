package io.objectbox.query;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.InternalAccess;
import io.objectbox.Property;
import io.objectbox.reactive.DataSubscriptionList;
import io.objectbox.reactive.SubscriptionBuilder;
import io.objectbox.relation.RelationInfo;
import io.objectbox.relation.ToOne;
import java.io.Closeable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Query<T> implements Closeable {
    private static final int INITIAL_RETRY_BACK_OFF_IN_MS = 10;
    final Box<T> box;
    @Nullable
    private final Comparator<T> comparator;
    @Nullable
    private final List<EagerRelation<T, ?>> eagerRelations;
    @Nullable
    private final QueryFilter<T> filter;
    volatile long handle;
    private final QueryPublisher<T> publisher;
    private final int queryAttempts;
    private final BoxStore store;

    private native void nativeSetParameters(long j, int i, int i2, @Nullable String str, String str2, String str3);

    /* access modifiers changed from: package-private */
    public native long nativeClone(long j);

    /* access modifiers changed from: package-private */
    public native long nativeCount(long j, long j2);

    /* access modifiers changed from: package-private */
    public native String nativeDescribeParameters(long j);

    /* access modifiers changed from: package-private */
    public native void nativeDestroy(long j);

    /* access modifiers changed from: package-private */
    public native List<T> nativeFind(long j, long j2, long j3, long j4) throws Exception;

    /* access modifiers changed from: package-private */
    public native Object nativeFindFirst(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long nativeFindFirstId(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long[] nativeFindIds(long j, long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native List<IdWithScore> nativeFindIdsWithScores(long j, long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native Object nativeFindUnique(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long nativeFindUniqueId(long j, long j2);

    /* access modifiers changed from: package-private */
    public native List<ObjectWithScore<T>> nativeFindWithScores(long j, long j2, long j3, long j4);

    /* access modifiers changed from: package-private */
    public native long nativeRemove(long j, long j2);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameter(long j, int i, int i2, @Nullable String str, double d);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameter(long j, int i, int i2, @Nullable String str, long j2);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameter(long j, int i, int i2, @Nullable String str, String str2);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameter(long j, int i, int i2, @Nullable String str, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameter(long j, int i, int i2, @Nullable String str, float[] fArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameters(long j, int i, int i2, @Nullable String str, double d, double d2);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameters(long j, int i, int i2, @Nullable String str, long j2, long j3);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameters(long j, int i, int i2, @Nullable String str, int[] iArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameters(long j, int i, int i2, @Nullable String str, long[] jArr);

    /* access modifiers changed from: package-private */
    public native void nativeSetParameters(long j, int i, int i2, @Nullable String str, String[] strArr);

    /* access modifiers changed from: package-private */
    public native String nativeToString(long j);

    Query(Box<T> box2, long j, @Nullable List<EagerRelation<T, ?>> list, @Nullable QueryFilter<T> queryFilter, @Nullable Comparator<T> comparator2) {
        this.box = box2;
        BoxStore store2 = box2.getStore();
        this.store = store2;
        this.queryAttempts = store2.internalQueryAttempts();
        this.handle = j;
        this.publisher = new QueryPublisher<>(this, box2);
        this.eagerRelations = list;
        this.filter = queryFilter;
        this.comparator = comparator2;
    }

    private Query(Query<T> query, long j) {
        this(query.box, j, query.eagerRelations, query.filter, query.comparator);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public synchronized void close() {
        if (this.handle != 0) {
            long j = this.handle;
            this.handle = 0;
            nativeDestroy(j);
        }
    }

    public Query<T> copy() {
        return new Query<>(this, nativeClone(this.handle));
    }

    /* access modifiers changed from: package-private */
    public long cursorHandle() {
        return InternalAccess.getActiveTxCursorHandle(this.box);
    }

    @Nullable
    public T findFirst() {
        ensureNoFilterNoComparator();
        return callInReadTx(new Query$$ExternalSyntheticLambda10(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findFirst$0$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ Object m325lambda$findFirst$0$ioobjectboxqueryQuery() throws Exception {
        Object nativeFindFirst = nativeFindFirst(this.handle, cursorHandle());
        resolveEagerRelation(nativeFindFirst);
        return nativeFindFirst;
    }

    private void ensureNoFilterNoComparator() {
        ensureNoFilter();
        ensureNoComparator();
    }

    private void ensureNoFilter() {
        if (this.filter != null) {
            throw new UnsupportedOperationException("Does not work with a filter. Only find() and forEach() support filters.");
        }
    }

    private void ensureNoComparator() {
        if (this.comparator != null) {
            throw new UnsupportedOperationException("Does not work with a sorting comparator. Only find() supports sorting with a comparator.");
        }
    }

    @Nullable
    public T findUnique() {
        ensureNoFilter();
        return callInReadTx(new Query$$ExternalSyntheticLambda8(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findUnique$1$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ Object m329lambda$findUnique$1$ioobjectboxqueryQuery() throws Exception {
        Object nativeFindUnique = nativeFindUnique(this.handle, cursorHandle());
        resolveEagerRelation(nativeFindUnique);
        return nativeFindUnique;
    }

    @Nonnull
    public List<T> find() {
        return (List) callInReadTx(new Query$$ExternalSyntheticLambda11(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$find$2$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ List m323lambda$find$2$ioobjectboxqueryQuery() throws Exception {
        List nativeFind = nativeFind(this.handle, cursorHandle(), 0, 0);
        if (this.filter != null) {
            Iterator it = nativeFind.iterator();
            while (it.hasNext()) {
                if (!this.filter.keep(it.next())) {
                    it.remove();
                }
            }
        }
        resolveEagerRelations(nativeFind);
        Comparator<T> comparator2 = this.comparator;
        if (comparator2 != null) {
            Collections.sort(nativeFind, comparator2);
        }
        return nativeFind;
    }

    @Nonnull
    public List<T> find(long j, long j2) {
        ensureNoFilterNoComparator();
        return (List) callInReadTx(new Query$$ExternalSyntheticLambda0(this, j, j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$find$3$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ List m324lambda$find$3$ioobjectboxqueryQuery(long j, long j2) throws Exception {
        List nativeFind = nativeFind(this.handle, cursorHandle(), j, j2);
        resolveEagerRelations(nativeFind);
        return nativeFind;
    }

    public long findFirstId() {
        checkOpen();
        return ((Long) this.box.internalCallWithReaderHandle(new Query$$ExternalSyntheticLambda7(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findFirstId$4$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ Long m326lambda$findFirstId$4$ioobjectboxqueryQuery(long j) {
        return Long.valueOf(nativeFindFirstId(this.handle, j));
    }

    public long findUniqueId() {
        checkOpen();
        return ((Long) this.box.internalCallWithReaderHandle(new Query$$ExternalSyntheticLambda9(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findUniqueId$5$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ Long m330lambda$findUniqueId$5$ioobjectboxqueryQuery(long j) {
        return Long.valueOf(nativeFindUniqueId(this.handle, j));
    }

    @Nonnull
    public long[] findIds() {
        return findIds(0, 0);
    }

    @Nonnull
    public long[] findIds(long j, long j2) {
        checkOpen();
        return (long[]) this.box.internalCallWithReaderHandle(new Query$$ExternalSyntheticLambda3(this, j, j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findIds$6$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ long[] m327lambda$findIds$6$ioobjectboxqueryQuery(long j, long j2, long j3) {
        return nativeFindIds(this.handle, j3, j, j2);
    }

    @Nonnull
    public LazyList<T> findLazy() {
        ensureNoFilterNoComparator();
        return new LazyList<>(this.box, findIds(), false);
    }

    @Nonnull
    public LazyList<T> findLazyCached() {
        ensureNoFilterNoComparator();
        return new LazyList<>(this.box, findIds(), true);
    }

    @Nonnull
    public List<IdWithScore> findIdsWithScores(long j, long j2) {
        checkOpen();
        return (List) this.box.internalCallWithReaderHandle(new Query$$ExternalSyntheticLambda5(this, j, j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findIdsWithScores$7$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ List m328lambda$findIdsWithScores$7$ioobjectboxqueryQuery(long j, long j2, long j3) {
        return nativeFindIdsWithScores(this.handle, j3, j, j2);
    }

    @Nonnull
    public List<IdWithScore> findIdsWithScores() {
        return findIdsWithScores(0, 0);
    }

    @Nonnull
    public List<ObjectWithScore<T>> findWithScores(long j, long j2) {
        ensureNoFilterNoComparator();
        return (List) callInReadTx(new Query$$ExternalSyntheticLambda2(this, j, j2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findWithScores$8$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ List m331lambda$findWithScores$8$ioobjectboxqueryQuery(long j, long j2) throws Exception {
        List nativeFindWithScores = nativeFindWithScores(this.handle, cursorHandle(), j, j2);
        if (this.eagerRelations != null) {
            for (int i = 0; i < nativeFindWithScores.size(); i++) {
                resolveEagerRelationForNonNullEagerRelations(((ObjectWithScore) nativeFindWithScores.get(i)).get(), i);
            }
        }
        return nativeFindWithScores;
    }

    @Nonnull
    public List<ObjectWithScore<T>> findWithScores() {
        return findWithScores(0, 0);
    }

    public PropertyQuery property(Property<T> property) {
        return new PropertyQuery(this, property);
    }

    /* access modifiers changed from: package-private */
    public <R> R callInReadTx(Callable<R> callable) {
        checkOpen();
        return this.store.callInReadTxWithRetry(callable, this.queryAttempts, 10, true);
    }

    public void forEach(QueryConsumer<T> queryConsumer) {
        ensureNoComparator();
        checkOpen();
        this.box.getStore().runInReadTx(new Query$$ExternalSyntheticLambda4(this, queryConsumer));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$forEach$9$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ void m332lambda$forEach$9$ioobjectboxqueryQuery(QueryConsumer queryConsumer) {
        int i = 0;
        LazyList lazyList = new LazyList(this.box, findIds(), false);
        int size = lazyList.size();
        while (i < size) {
            Object obj = lazyList.get(i);
            if (obj != null) {
                QueryFilter<T> queryFilter = this.filter;
                if (queryFilter == null || queryFilter.keep(obj)) {
                    if (this.eagerRelations != null) {
                        resolveEagerRelationForNonNullEagerRelations(obj, i);
                    }
                    try {
                        queryConsumer.accept(obj);
                    } catch (BreakForEach unused) {
                        return;
                    }
                }
                i++;
            } else {
                throw new IllegalStateException("Internal error: data object was null");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resolveEagerRelations(List<T> list) {
        if (this.eagerRelations != null) {
            int i = 0;
            for (T resolveEagerRelationForNonNullEagerRelations : list) {
                resolveEagerRelationForNonNullEagerRelations(resolveEagerRelationForNonNullEagerRelations, i);
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resolveEagerRelationForNonNullEagerRelations(@Nonnull T t, int i) {
        for (EagerRelation next : this.eagerRelations) {
            if (next.limit == 0 || i < next.limit) {
                resolveEagerRelation(t, next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resolveEagerRelation(@Nullable T t) {
        List<EagerRelation<T, ?>> list = this.eagerRelations;
        if (list != null && t != null) {
            for (EagerRelation<T, ?> resolveEagerRelation : list) {
                resolveEagerRelation(t, resolveEagerRelation);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resolveEagerRelation(@Nonnull T t, EagerRelation<T, ?> eagerRelation) {
        if (this.eagerRelations != null) {
            RelationInfo<S, T> relationInfo = eagerRelation.relationInfo;
            if (relationInfo.toOneGetter != null) {
                ToOne<TARGET> toOne = relationInfo.toOneGetter.getToOne(t);
                if (toOne != null) {
                    toOne.getTarget();
                }
            } else if (relationInfo.toManyGetter != null) {
                List<TARGET> toMany = relationInfo.toManyGetter.getToMany(t);
                if (toMany != null) {
                    toMany.size();
                }
            } else {
                throw new IllegalStateException("Relation info without relation getter: " + relationInfo);
            }
        }
    }

    public long count() {
        checkOpen();
        ensureNoFilter();
        return ((Long) this.box.internalCallWithReaderHandle(new Query$$ExternalSyntheticLambda6(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$count$10$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ Long m322lambda$count$10$ioobjectboxqueryQuery(long j) {
        return Long.valueOf(nativeCount(this.handle, j));
    }

    public Query<T> setParameter(Property<?> property, String str) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (String) null, str);
        return this;
    }

    public Query<T> setParameter(String str, String str2) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, str2);
        return this;
    }

    public Query<T> setParameter(Property<?> property, long j) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (String) null, j);
        return this;
    }

    public Query<T> setParameter(String str, long j) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, j);
        return this;
    }

    public Query<T> setParameter(Property<?> property, double d) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (String) null, d);
        return this;
    }

    public Query<T> setParameter(String str, double d) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, d);
        return this;
    }

    public Query<T> setParameter(Property<?> property, Date date) {
        return setParameter(property, date.getTime());
    }

    public Query<T> setParameter(String str, Date date) {
        return setParameter(str, date.getTime());
    }

    public Query<T> setParameter(Property<?> property, boolean z) {
        return setParameter(property, z ? 1 : 0);
    }

    public Query<T> setParameter(String str, boolean z) {
        return setParameter(str, z ? 1 : 0);
    }

    public Query<T> setParameter(Property<?> property, int[] iArr) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (String) null, iArr);
        return this;
    }

    public Query<T> setParameter(String str, int[] iArr) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, iArr);
        return this;
    }

    public Query<T> setParameter(Property<?> property, long[] jArr) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (String) null, jArr);
        return this;
    }

    public Query<T> setParameter(String str, long[] jArr) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, jArr);
        return this;
    }

    public Query<T> setParameter(Property<?> property, float[] fArr) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (String) null, fArr);
        return this;
    }

    public Query<T> setParameter(String str, float[] fArr) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, fArr);
        return this;
    }

    public Query<T> setParameter(Property<?> property, String[] strArr) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (String) null, strArr);
        return this;
    }

    public Query<T> setParameter(String str, String[] strArr) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, strArr);
        return this;
    }

    public Query<T> setParameters(Property<?> property, long j, long j2) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (String) null, j, j2);
        return this;
    }

    public Query<T> setParameters(String str, long j, long j2) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, j, j2);
        return this;
    }

    @Deprecated
    public Query<T> setParameters(Property<?> property, int[] iArr) {
        return setParameter(property, iArr);
    }

    @Deprecated
    public Query<T> setParameters(String str, int[] iArr) {
        return setParameter(str, iArr);
    }

    @Deprecated
    public Query<T> setParameters(Property<?> property, long[] jArr) {
        return setParameter(property, jArr);
    }

    @Deprecated
    public Query<T> setParameters(String str, long[] jArr) {
        return setParameter(str, jArr);
    }

    public Query<T> setParameters(Property<?> property, double d, double d2) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (String) null, d, d2);
        return this;
    }

    public Query<T> setParameters(String str, double d, double d2) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, d, d2);
        return this;
    }

    @Deprecated
    public Query<T> setParameters(Property<?> property, String[] strArr) {
        return setParameter(property, strArr);
    }

    @Deprecated
    public Query<T> setParameters(String str, String[] strArr) {
        return setParameter(str, strArr);
    }

    public Query<T> setParameters(Property<?> property, String str, String str2) {
        checkOpen();
        nativeSetParameters(this.handle, property.getEntityId(), property.getId(), (String) null, str, str2);
        return this;
    }

    public Query<T> setParameters(String str, String str2, String str3) {
        checkOpen();
        nativeSetParameters(this.handle, 0, 0, str, str2, str3);
        return this;
    }

    public Query<T> setParameter(Property<?> property, byte[] bArr) {
        checkOpen();
        nativeSetParameter(this.handle, property.getEntityId(), property.getId(), (String) null, bArr);
        return this;
    }

    public Query<T> setParameter(String str, byte[] bArr) {
        checkOpen();
        nativeSetParameter(this.handle, 0, 0, str, bArr);
        return this;
    }

    public long remove() {
        checkOpen();
        ensureNoFilter();
        return ((Long) this.box.internalCallWithWriterHandle(new Query$$ExternalSyntheticLambda1(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$remove$11$io-objectbox-query-Query  reason: not valid java name */
    public /* synthetic */ Long m333lambda$remove$11$ioobjectboxqueryQuery(long j) {
        return Long.valueOf(nativeRemove(this.handle, j));
    }

    public SubscriptionBuilder<List<T>> subscribe() {
        checkOpen();
        return new SubscriptionBuilder<>(this.publisher, (Object) null);
    }

    public SubscriptionBuilder<List<T>> subscribe(DataSubscriptionList dataSubscriptionList) {
        SubscriptionBuilder<List<T>> subscribe = subscribe();
        subscribe.dataSubscriptionList(dataSubscriptionList);
        return subscribe;
    }

    public void publish() {
        this.publisher.publish();
    }

    public String describe() {
        checkOpen();
        return nativeToString(this.handle);
    }

    public String describeParameters() {
        checkOpen();
        return nativeDescribeParameters(this.handle);
    }

    private void checkOpen() {
        if (this.handle == 0) {
            throw new IllegalStateException("This query is closed. Build and use a new one.");
        }
    }
}

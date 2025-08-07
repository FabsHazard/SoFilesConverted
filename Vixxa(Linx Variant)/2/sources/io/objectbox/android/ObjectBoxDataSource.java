package io.objectbox.android;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import io.objectbox.query.Query;
import io.objectbox.reactive.DataObserver;
import java.util.Collections;
import java.util.List;

public class ObjectBoxDataSource<T> extends PositionalDataSource<T> {
    private final DataObserver<List<T>> observer;
    private final Query<T> query;

    public static class Factory<Item> extends DataSource.Factory<Integer, Item> {
        private final Query<Item> query;

        public Factory(Query<Item> query2) {
            this.query = query2;
        }

        public DataSource<Integer, Item> create() {
            return new ObjectBoxDataSource(this.query);
        }
    }

    public ObjectBoxDataSource(Query<T> query2) {
        this.query = query2;
        ObjectBoxDataSource$$ExternalSyntheticLambda0 objectBoxDataSource$$ExternalSyntheticLambda0 = new ObjectBoxDataSource$$ExternalSyntheticLambda0(this);
        this.observer = objectBoxDataSource$$ExternalSyntheticLambda0;
        query2.subscribe().onlyChanges().weak().observer(objectBoxDataSource$$ExternalSyntheticLambda0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$io-objectbox-android-ObjectBoxDataSource  reason: not valid java name */
    public /* synthetic */ void m301lambda$new$0$ioobjectboxandroidObjectBoxDataSource(List list) {
        invalidate();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams loadInitialParams, PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        int count = (int) this.query.count();
        if (count == 0) {
            loadInitialCallback.onResult(Collections.emptyList(), 0, 0);
            return;
        }
        int computeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, count);
        int computeInitialLoadSize = computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, count);
        List loadRange = loadRange(computeInitialLoadPosition, computeInitialLoadSize);
        if (loadRange.size() == computeInitialLoadSize) {
            loadInitialCallback.onResult(loadRange, computeInitialLoadPosition, count);
        } else {
            invalidate();
        }
    }

    public void loadRange(PositionalDataSource.LoadRangeParams loadRangeParams, PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    private List<T> loadRange(int i, int i2) {
        return this.query.find((long) i, (long) i2);
    }
}

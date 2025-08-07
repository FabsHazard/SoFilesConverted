package io.objectbox.android;

import androidx.lifecycle.LiveData;
import io.objectbox.query.Query;
import io.objectbox.reactive.DataObserver;
import io.objectbox.reactive.DataSubscription;
import java.util.List;

public class ObjectBoxLiveData<T> extends LiveData<List<T>> {
    private final DataObserver<List<T>> listener = new ObjectBoxLiveData$$ExternalSyntheticLambda0(this);
    private final Query<T> query;
    private DataSubscription subscription;

    public ObjectBoxLiveData(Query<T> query2) {
        this.query = query2;
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        if (this.subscription == null) {
            this.subscription = this.query.subscribe().observer(this.listener);
        }
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        if (!hasObservers()) {
            this.subscription.cancel();
            this.subscription = null;
        }
    }
}

package io.objectbox.android;

import io.objectbox.reactive.DataObserver;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ObjectBoxLiveData$$ExternalSyntheticLambda0 implements DataObserver {
    public final /* synthetic */ ObjectBoxLiveData f$0;

    public /* synthetic */ ObjectBoxLiveData$$ExternalSyntheticLambda0(ObjectBoxLiveData objectBoxLiveData) {
        this.f$0 = objectBoxLiveData;
    }

    public final void onData(Object obj) {
        this.f$0.postValue((List) obj);
    }
}

package io.objectbox.query;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Query$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ Query f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ Query$$ExternalSyntheticLambda2(Query query, long j, long j2) {
        this.f$0 = query;
        this.f$1 = j;
        this.f$2 = j2;
    }

    public final Object call() {
        return this.f$0.m331lambda$findWithScores$8$ioobjectboxqueryQuery(this.f$1, this.f$2);
    }
}

package com.microtech.aidexx.data;

import io.objectbox.query.QueryBuilder;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CloudCgmHistorySync$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ QueryBuilder f$0;

    public /* synthetic */ CloudCgmHistorySync$$ExternalSyntheticLambda0(QueryBuilder queryBuilder) {
        this.f$0 = queryBuilder;
    }

    public final Object call() {
        return CloudCgmHistorySync.getNeedUploadData$lambda$0(this.f$0);
    }
}

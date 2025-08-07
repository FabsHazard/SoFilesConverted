package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda15 implements Callable {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda15(Class cls, long j) {
        this.f$0 = cls;
        this.f$1 = j;
    }

    public final Object call() {
        return EventDao.removeEventById$lambda$56(this.f$0, this.f$1);
    }
}

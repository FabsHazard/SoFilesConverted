package com.microtech.aidexx.db.dao;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda31 implements Callable {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda31(Class cls, List list) {
        this.f$0 = cls;
        this.f$1 = list;
    }

    public final Object call() {
        return EventDao.updateDeleteStatusByIds$lambda$73(this.f$0, this.f$1);
    }
}

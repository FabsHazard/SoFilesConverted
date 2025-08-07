package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda17 implements Callable {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda17(Class cls, String str) {
        this.f$0 = cls;
        this.f$1 = str;
    }

    public final Object call() {
        return EventDao.removeEventByFrontId$lambda$60(this.f$0, this.f$1);
    }
}

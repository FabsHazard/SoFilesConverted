package com.microtech.aidexx.db.dao;

import io.objectbox.Property;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda23 implements Callable {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ Property f$1;
    public final /* synthetic */ Property f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda23(Class cls, Property property, Property property2, String str) {
        this.f$0 = cls;
        this.f$1 = property;
        this.f$2 = property2;
        this.f$3 = str;
    }

    public final Object call() {
        return EventDao.findMaxEventId$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

package com.microtech.aidexx.db.dao;

import io.objectbox.Property;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda10 implements Callable {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ Property f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda10(Class cls, Property property, String str) {
        this.f$0 = cls;
        this.f$1 = property;
        this.f$2 = str;
    }

    public final Object call() {
        return EventDao.removeSysPresetOfOtherVersion$lambda$4(this.f$0, this.f$1, this.f$2);
    }
}

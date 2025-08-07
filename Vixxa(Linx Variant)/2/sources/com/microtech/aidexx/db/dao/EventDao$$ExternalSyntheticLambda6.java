package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda6 implements Callable {
    public final /* synthetic */ BaseEventEntity f$0;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda6(BaseEventEntity baseEventEntity) {
        this.f$0 = baseEventEntity;
    }

    public final Object call() {
        return EventDao.insertEvent$lambda$27(this.f$0);
    }
}

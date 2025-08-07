package com.microtech.aidexx.db.dao;

import java.util.Date;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$queryNextByTargetDate$2$events$3$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Date f$1;

    public /* synthetic */ EventDao$queryNextByTargetDate$2$events$3$$ExternalSyntheticLambda0(String str, Date date) {
        this.f$0 = str;
        this.f$1 = date;
    }

    public final Object call() {
        return EventDao$queryNextByTargetDate$2$events$3.invokeSuspend$lambda$0(this.f$0, this.f$1);
    }
}

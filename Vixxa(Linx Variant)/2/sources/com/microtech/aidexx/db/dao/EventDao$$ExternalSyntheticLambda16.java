package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda16 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda16(String str, String str2) {
        this.f$0 = str;
        this.f$1 = str2;
    }

    public final Object call() {
        return EventDao.querySportUsrPresetByName$lambda$26(this.f$0, this.f$1);
    }
}

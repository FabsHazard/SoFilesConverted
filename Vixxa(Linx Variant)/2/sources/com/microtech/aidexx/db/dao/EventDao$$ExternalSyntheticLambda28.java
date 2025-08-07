package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventDao$$ExternalSyntheticLambda28 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ EventDao$$ExternalSyntheticLambda28(String str, String str2, String str3) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
    }

    public final Object call() {
        return EventDao.queryInsulinSysPresetByName$lambda$20(this.f$0, this.f$1, this.f$2);
    }
}

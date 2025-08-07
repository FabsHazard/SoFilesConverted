package com.microtech.aidexx.db.dao;

import java.util.Date;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CgmHistoryDao$$ExternalSyntheticLambda5 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Date f$1;

    public /* synthetic */ CgmHistoryDao$$ExternalSyntheticLambda5(String str, Date date) {
        this.f$0 = str;
        this.f$1 = date;
    }

    public final Object call() {
        return CgmHistoryDao.queryNextByTargetDate$lambda$5(this.f$0, this.f$1);
    }
}

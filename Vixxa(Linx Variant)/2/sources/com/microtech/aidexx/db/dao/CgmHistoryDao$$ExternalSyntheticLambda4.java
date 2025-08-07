package com.microtech.aidexx.db.dao;

import java.util.Date;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CgmHistoryDao$$ExternalSyntheticLambda4 implements Callable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Date f$1;
    public final /* synthetic */ Date f$2;

    public /* synthetic */ CgmHistoryDao$$ExternalSyntheticLambda4(String str, Date date, Date date2) {
        this.f$0 = str;
        this.f$1 = date;
        this.f$2 = date2;
    }

    public final Object call() {
        return CgmHistoryDao.query$lambda$3(this.f$0, this.f$1, this.f$2);
    }
}

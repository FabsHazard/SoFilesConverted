package com.microtech.aidexx.db.dao;

import java.util.Date;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BloodGlucoseDao$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ Date f$0;
    public final /* synthetic */ Date f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ BloodGlucoseDao$$ExternalSyntheticLambda3(Date date, Date date2, String str) {
        this.f$0 = date;
        this.f$1 = date2;
        this.f$2 = str;
    }

    public final Object call() {
        return BloodGlucoseDao.query$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}

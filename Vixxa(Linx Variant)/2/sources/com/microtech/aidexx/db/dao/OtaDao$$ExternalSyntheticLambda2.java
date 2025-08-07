package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OtaDao$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ OtaDao f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ OtaDao$$ExternalSyntheticLambda2(OtaDao otaDao, String str) {
        this.f$0 = otaDao;
        this.f$1 = str;
    }

    public final Object call() {
        return OtaDao.queryOtaResourceByKey$lambda$5(this.f$0, this.f$1);
    }
}

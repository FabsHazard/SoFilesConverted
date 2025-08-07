package com.microtech.aidexx.db.dao;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OtaDao$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ OtaDao f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ OtaDao$$ExternalSyntheticLambda0(OtaDao otaDao, String str, String str2, int i) {
        this.f$0 = otaDao;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = i;
    }

    public final Object call() {
        return OtaDao.queryOtaResource$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}

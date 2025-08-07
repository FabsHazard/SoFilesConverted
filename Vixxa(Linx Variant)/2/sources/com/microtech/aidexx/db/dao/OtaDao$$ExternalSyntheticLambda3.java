package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.entity.OtaResourceEntity;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OtaDao$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ OtaDao f$0;
    public final /* synthetic */ OtaResourceEntity f$1;

    public /* synthetic */ OtaDao$$ExternalSyntheticLambda3(OtaDao otaDao, OtaResourceEntity otaResourceEntity) {
        this.f$0 = otaDao;
        this.f$1 = otaResourceEntity;
    }

    public final Object call() {
        return OtaDao.insertOrUpdate$lambda$6(this.f$0, this.f$1);
    }
}

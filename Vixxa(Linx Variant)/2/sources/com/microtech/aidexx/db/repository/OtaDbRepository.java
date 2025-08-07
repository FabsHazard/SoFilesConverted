package com.microtech.aidexx.db.repository;

import com.microtech.aidexx.db.dao.OtaDao;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ+\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J+\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/db/repository/OtaDbRepository;", "", "()V", "dao", "Lcom/microtech/aidexx/db/dao/OtaDao;", "getDao", "()Lcom/microtech/aidexx/db/dao/OtaDao;", "dao$delegate", "Lkotlin/Lazy;", "insertOrUpdate", "", "otaResource", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "(Lcom/microtech/aidexx/db/entity/OtaResourceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtaResource", "", "name", "", "aidexVersion", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtaResourceByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtaResourceByVersion", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaDbRepository.kt */
public final class OtaDbRepository {
    private final Lazy dao$delegate = LazyKt.lazy(OtaDbRepository$dao$2.INSTANCE);

    private final OtaDao getDao() {
        return (OtaDao) this.dao$delegate.getValue();
    }

    public final Object insertOrUpdate(OtaResourceEntity otaResourceEntity, Continuation<? super Long> continuation) {
        return getDao().insertOrUpdate(otaResourceEntity, continuation);
    }

    public final Object queryOtaResource(String str, String str2, Continuation<? super List<OtaResourceEntity>> continuation) {
        return OtaDao.queryOtaResource$default(getDao(), str, str2, 0, continuation, 4, (Object) null);
    }

    public final Object queryOtaResourceByVersion(String str, String str2, String str3, Continuation<? super OtaResourceEntity> continuation) {
        return getDao().queryOtaResourceByVersion(str, str2, str3, continuation);
    }

    public final Object queryOtaResourceByKey(String str, Continuation<? super OtaResourceEntity> continuation) {
        return getDao().queryOtaResourceByKey(str, continuation);
    }
}

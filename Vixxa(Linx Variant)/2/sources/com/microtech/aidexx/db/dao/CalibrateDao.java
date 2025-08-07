package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity_;
import io.objectbox.Box;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.QueryBuilder;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ1\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J1\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/db/dao/CalibrateDao;", "", "()V", "box", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "getBox", "()Lio/objectbox/Box;", "box$delegate", "Lkotlin/Lazy;", "insert", "", "list", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "query", "", "startDate", "Ljava/util/Date;", "endDate", "authorId", "", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryByUid", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalibrateDao.kt */
public final class CalibrateDao {
    public static final CalibrateDao INSTANCE = new CalibrateDao();
    private static final Lazy box$delegate = LazyKt.lazy(CalibrateDao$box$2.INSTANCE);

    private CalibrateDao() {
    }

    private final Box<CalibrateEntity> getBox() {
        return (Box) box$delegate.getValue();
    }

    public final Object queryByUid(String str, Continuation<? super List<CalibrateEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CalibrateDao$$ExternalSyntheticLambda1(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryByUid$lambda$0(String str) {
        Intrinsics.checkNotNullParameter(str, "$id");
        return INSTANCE.getBox().query().equal(CalibrateEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE).build().find();
    }

    public final Object query(Date date, Date date2, String str, Continuation<? super List<CalibrateEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CalibrateDao$$ExternalSyntheticLambda3(date, date2, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List query$lambda$1(Date date, Date date2, String str) {
        Intrinsics.checkNotNullParameter(date, "$startDate");
        Intrinsics.checkNotNullParameter(date2, "$endDate");
        Intrinsics.checkNotNullParameter(str, "$authorId");
        return INSTANCE.getBox().query().between(CalibrateEntity_.timestamp, date.getTime(), date2.getTime()).equal(CalibrateEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE).equal(CalibrateEntity_.deleteStatus, 0).equal(CalibrateEntity_.isValid, 1).build().find();
    }

    public final Object query(String str, String str2, String str3, Continuation<? super List<CalibrateEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CalibrateDao$$ExternalSyntheticLambda2(str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final List query$lambda$2(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "$startDate");
        Intrinsics.checkNotNullParameter(str2, "$endDate");
        Intrinsics.checkNotNullParameter(str3, "$authorId");
        return INSTANCE.getBox().query().greaterOrEqual(CalibrateEntity_.appTime, str, QueryBuilder.StringOrder.CASE_INSENSITIVE).less(CalibrateEntity_.appTime, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE).equal(CalibrateEntity_.userId, str3, QueryBuilder.StringOrder.CASE_SENSITIVE).equal(CalibrateEntity_.deleteStatus, 0).equal(CalibrateEntity_.isValid, 1).build().find();
    }

    public final Object insert(List<CalibrateEntity> list, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CalibrateDao$$ExternalSyntheticLambda0(list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insert$lambda$3(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        INSTANCE.getBox().put(list);
        return Unit.INSTANCE;
    }
}

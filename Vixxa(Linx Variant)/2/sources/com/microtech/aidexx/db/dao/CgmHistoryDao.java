package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import io.objectbox.Box;
import io.objectbox.Property;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J!\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J1\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ1\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010!J#\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010$R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/db/dao/CgmHistoryDao;", "", "()V", "box", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "getBox", "()Lio/objectbox/Box;", "box$delegate", "Lkotlin/Lazy;", "checkHasData", "date", "Ljava/util/Date;", "userId", "", "(Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkHasDataByAppTime", "genCommonCgmQueryBuilder", "Lio/objectbox/query/QueryBuilder;", "builder", "insert", "", "list", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "query", "", "startDate", "endDate", "authorId", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryByUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryNextByTargetDate", "targetDate", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CgmHistoryDao.kt */
public final class CgmHistoryDao {
    public static final CgmHistoryDao INSTANCE = new CgmHistoryDao();
    private static final Lazy box$delegate = LazyKt.lazy(CgmHistoryDao$box$2.INSTANCE);

    private CgmHistoryDao() {
    }

    private final Box<RealCgmHistoryEntity> getBox() {
        return (Box) box$delegate.getValue();
    }

    public final Object checkHasData(Date date, String str, Continuation<? super RealCgmHistoryEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda0(str, date), continuation);
    }

    /* access modifiers changed from: private */
    public static final RealCgmHistoryEntity checkHasData$lambda$0(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        Intrinsics.checkNotNullParameter(date, "$date");
        CgmHistoryDao cgmHistoryDao = INSTANCE;
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        return cgmHistoryDao.genCommonCgmQueryBuilder(str, query).between(RealCgmHistoryEntity_.timestamp, ExtendsKt.getStartOfTheDay(date).getTime(), ExtendsKt.getEndOfTheDay(date).getTime()).build().findFirst();
    }

    public final Object checkHasDataByAppTime(Date date, String str, Continuation<? super RealCgmHistoryEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda2(str, date), continuation);
    }

    /* access modifiers changed from: private */
    public static final RealCgmHistoryEntity checkHasDataByAppTime$lambda$1(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        Intrinsics.checkNotNullParameter(date, "$date");
        CgmHistoryDao cgmHistoryDao = INSTANCE;
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        return cgmHistoryDao.genCommonCgmQueryBuilder(str, query).greaterOrEqual(RealCgmHistoryEntity_.appTime, ExtendsKt.formatWithoutZone(ExtendsKt.getStartOfTheDay(date)), QueryBuilder.StringOrder.CASE_INSENSITIVE).less(RealCgmHistoryEntity_.appTime, ExtendsKt.formatWithoutZone(ExtendsKt.getEndOfTheDay(date)), QueryBuilder.StringOrder.CASE_INSENSITIVE).build().findFirst();
    }

    public final Object queryByUid(String str, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda1(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryByUid$lambda$2(String str) {
        Intrinsics.checkNotNullParameter(str, "$authorId");
        QueryBuilder<RealCgmHistoryEntity> query = INSTANCE.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Property property = RealCgmHistoryEntity_.eventType;
        Intrinsics.checkNotNullExpressionValue(property, "eventType");
        QueryBuilder<RealCgmHistoryEntity> equal = query.equal((Property<RealCgmHistoryEntity>) property, (long) 14);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(property, value.toLong())");
        return equal.equal((Property<RealCgmHistoryEntity>) RealCgmHistoryEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE).build().find();
    }

    public final Object query(Date date, Date date2, String str, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda4(str, date, date2), continuation);
    }

    /* access modifiers changed from: private */
    public static final List query$lambda$3(String str, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(str, "$authorId");
        Intrinsics.checkNotNullParameter(date, "$startDate");
        Intrinsics.checkNotNullParameter(date2, "$endDate");
        CgmHistoryDao cgmHistoryDao = INSTANCE;
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        return cgmHistoryDao.genCommonCgmQueryBuilder(str, query).between(RealCgmHistoryEntity_.timestamp, date.getTime(), date2.getTime()).order(RealCgmHistoryEntity_.timestamp).build().find();
    }

    public final Object query(String str, String str2, String str3, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda3(str3, str, str2), continuation);
    }

    /* access modifiers changed from: private */
    public static final List query$lambda$4(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "$authorId");
        Intrinsics.checkNotNullParameter(str2, "$startDate");
        Intrinsics.checkNotNullParameter(str3, "$endDate");
        CgmHistoryDao cgmHistoryDao = INSTANCE;
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        return cgmHistoryDao.genCommonCgmQueryBuilder(str, query).greaterOrEqual(RealCgmHistoryEntity_.appTime, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE).less(RealCgmHistoryEntity_.appTime, str3, QueryBuilder.StringOrder.CASE_INSENSITIVE).order(RealCgmHistoryEntity_.appTime).build().find();
    }

    public final Object queryNextByTargetDate(String str, Date date, Continuation<? super RealCgmHistoryEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda5(str, date), continuation);
    }

    /* access modifiers changed from: private */
    public static final RealCgmHistoryEntity queryNextByTargetDate$lambda$5(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "$authorId");
        Intrinsics.checkNotNullParameter(date, "$targetDate");
        CgmHistoryDao cgmHistoryDao = INSTANCE;
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        return cgmHistoryDao.genCommonCgmQueryBuilder(str, query).less(RealCgmHistoryEntity_.timestamp, date.getTime()).orderDesc(RealCgmHistoryEntity_.timestamp).build().findFirst();
    }

    private final QueryBuilder<RealCgmHistoryEntity> genCommonCgmQueryBuilder(String str, QueryBuilder<RealCgmHistoryEntity> queryBuilder) {
        queryBuilder.equal((Property<RealCgmHistoryEntity>) RealCgmHistoryEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE).equal(RealCgmHistoryEntity_.deleteStatus, 0).equal(RealCgmHistoryEntity_.glucoseIsValid, 1).equal(RealCgmHistoryEntity_.status, 0).notEqual(RealCgmHistoryEntity_.eventWarning, -1);
        return queryBuilder;
    }

    public final Object insert(List<RealCgmHistoryEntity> list, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new CgmHistoryDao$$ExternalSyntheticLambda6(list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insert$lambda$6(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        INSTANCE.getBox().put(list);
        return Unit.INSTANCE;
    }
}

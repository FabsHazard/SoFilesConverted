package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.db.entity.OtaResourceEntity_;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J+\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/db/dao/OtaDao;", "", "()V", "box", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "getBox", "()Lio/objectbox/Box;", "box$delegate", "Lkotlin/Lazy;", "insertOrUpdate", "", "otaResource", "(Lcom/microtech/aidexx/db/entity/OtaResourceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtaResource", "", "settingType", "", "aidexVersion", "fileType", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtaResourceByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryOtaResourceByVersion", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaDao.kt */
public final class OtaDao {
    private final Lazy box$delegate = LazyKt.lazy(OtaDao$box$2.INSTANCE);

    private final Box<OtaResourceEntity> getBox() {
        return (Box) this.box$delegate.getValue();
    }

    public static /* synthetic */ Object queryOtaResource$default(OtaDao otaDao, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return otaDao.queryOtaResource(str, str2, i, continuation);
    }

    public final Object queryOtaResource(String str, String str2, int i, Continuation<? super List<OtaResourceEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new OtaDao$$ExternalSyntheticLambda0(this, str, str2, i), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryOtaResource$lambda$1(OtaDao otaDao, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(otaDao, "this$0");
        Intrinsics.checkNotNullParameter(str, "$settingType");
        Intrinsics.checkNotNullParameter(str2, "$aidexVersion");
        QueryBuilder<OtaResourceEntity> query = otaDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(OtaResourceEntity_.settingType, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.equal(OtaResourceEntity_.aidexVersion, str2, QueryBuilder.StringOrder.CASE_SENSITIVE);
        Property property = OtaResourceEntity_.fileType;
        Intrinsics.checkNotNullExpressionValue(property, "fileType");
        Intrinsics.checkNotNullExpressionValue(query.equal((Property<OtaResourceEntity>) property, (long) i), "equal(property, value.toLong())");
        Query<OtaResourceEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        List<OtaResourceEntity> find = build.find();
        Intrinsics.checkNotNullExpressionValue(find, "find(...)");
        return CollectionsKt.toMutableList(find);
    }

    public final Object queryOtaResourceByVersion(String str, String str2, String str3, Continuation<? super OtaResourceEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new OtaDao$$ExternalSyntheticLambda1(this, str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final OtaResourceEntity queryOtaResourceByVersion$lambda$3(OtaDao otaDao, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(otaDao, "this$0");
        Intrinsics.checkNotNullParameter(str, "$settingType");
        Intrinsics.checkNotNullParameter(str2, "$aidexVersion");
        Intrinsics.checkNotNullParameter(str3, "$version");
        QueryBuilder<OtaResourceEntity> query = otaDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(OtaResourceEntity_.settingType, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.equal(OtaResourceEntity_.aidexVersion, str2, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.equal(OtaResourceEntity_.version, str3, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.orderDesc(OtaResourceEntity_.idx);
        Query<OtaResourceEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.findFirst();
    }

    public final Object queryOtaResourceByKey(String str, Continuation<? super OtaResourceEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new OtaDao$$ExternalSyntheticLambda2(this, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final OtaResourceEntity queryOtaResourceByKey$lambda$5(OtaDao otaDao, String str) {
        Intrinsics.checkNotNullParameter(otaDao, "this$0");
        Intrinsics.checkNotNullParameter(str, "$key");
        QueryBuilder<OtaResourceEntity> query = otaDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(OtaResourceEntity_.settingTypeVersionKey, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        Query<OtaResourceEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.findFirst();
    }

    public final Object insertOrUpdate(OtaResourceEntity otaResourceEntity, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new OtaDao$$ExternalSyntheticLambda3(this, otaResourceEntity), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long insertOrUpdate$lambda$6(OtaDao otaDao, OtaResourceEntity otaResourceEntity) {
        Intrinsics.checkNotNullParameter(otaDao, "this$0");
        Intrinsics.checkNotNullParameter(otaResourceEntity, "$otaResource");
        return Long.valueOf(otaDao.getBox().put(otaResourceEntity));
    }
}

package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.LanguageConfEntity;
import com.microtech.aidexx.db.entity.LanguageConfEntity_;
import com.microtech.aidexx.db.entity.LanguageEntity;
import com.microtech.aidexx.db.entity.LanguageEntity_;
import io.objectbox.Box;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J7\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ1\u0010\u001e\u001a\u0012\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u00152\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J9\u0010#\u001a*\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00170\u0017\u0018\u0001 \u001f*\u0014\u0012\u000e\b\u0001\u0012\n \u001f*\u0004\u0018\u00010\u00170\u0017\u0018\u00010!0!H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0013\u0010&\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001b\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048BX\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/microtech/aidexx/db/dao/LanguageDao;", "", "()V", "box", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/LanguageEntity;", "getBox", "()Lio/objectbox/Box;", "box$delegate", "Lkotlin/Lazy;", "confBox", "Lcom/microtech/aidexx/db/entity/LanguageConfEntity;", "getConfBox", "confBox$delegate", "insert", "", "list", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertConf", "query", "", "language", "", "module", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryConf", "languageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryConfs", "kotlin.jvm.PlatformType", "languageIds", "", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySupportLanguages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAll", "removeAllConf", "removeLanguageConfOfOtherVersion", "", "exceptVersion", "removeLanguageOfOtherVersion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageDao.kt */
public final class LanguageDao {
    private final Lazy box$delegate = LazyKt.lazy(LanguageDao$box$2.INSTANCE);
    private final Lazy confBox$delegate = LazyKt.lazy(LanguageDao$confBox$2.INSTANCE);

    private final Box<LanguageEntity> getBox() {
        return (Box) this.box$delegate.getValue();
    }

    private final Box<LanguageConfEntity> getConfBox() {
        return (Box) this.confBox$delegate.getValue();
    }

    public final Object insert(List<LanguageEntity> list, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda5(this, list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insert$lambda$0(LanguageDao languageDao, List list) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        languageDao.getBox().put(list);
        return Unit.INSTANCE;
    }

    public final Object query(String str, String str2, String str3, Continuation<? super List<LanguageEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda6(this, str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final List query$lambda$5(LanguageDao languageDao, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        QueryBuilder<LanguageEntity> query = languageDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        if (str != null) {
            query.equal(LanguageEntity_.language, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }
        if (str2 != null) {
            query.equal(LanguageEntity_.module, str2, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }
        if (str3 != null) {
            query.equal(LanguageEntity_.version, str3, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }
        Query<LanguageEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object removeLanguageOfOtherVersion(String str, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda1(this, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long removeLanguageOfOtherVersion$lambda$7(LanguageDao languageDao, String str) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        Intrinsics.checkNotNullParameter(str, "$exceptVersion");
        QueryBuilder<LanguageEntity> query = languageDao.getBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(LanguageEntity_.version, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        Query<LanguageEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return Long.valueOf(build.remove());
    }

    public final Object removeAll(Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda2(this), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit removeAll$lambda$8(LanguageDao languageDao) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        languageDao.getBox().removeAll();
        return Unit.INSTANCE;
    }

    public final Object querySupportLanguages(Continuation<? super String[]> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda4(this), continuation);
    }

    /* access modifiers changed from: private */
    public static final String[] querySupportLanguages$lambda$9(LanguageDao languageDao) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        return languageDao.getBox().query().build().property(LanguageEntity_.language).distinct(QueryBuilder.StringOrder.CASE_SENSITIVE).findStrings();
    }

    public final Object removeAllConf(Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda3(this), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit removeAllConf$lambda$10(LanguageDao languageDao) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        languageDao.getConfBox().removeAll();
        return Unit.INSTANCE;
    }

    public final Object insertConf(List<LanguageConfEntity> list, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda0(this, list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insertConf$lambda$11(LanguageDao languageDao, List list) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        languageDao.getConfBox().put(list);
        return Unit.INSTANCE;
    }

    public final Object queryConfs(String[] strArr, Continuation<? super List<LanguageConfEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda8(this, strArr), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryConfs$lambda$13(LanguageDao languageDao, String[] strArr) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        Intrinsics.checkNotNullParameter(strArr, "$languageIds");
        QueryBuilder<LanguageConfEntity> query = languageDao.getConfBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.in(LanguageConfEntity_.code, strArr, QueryBuilder.StringOrder.CASE_SENSITIVE);
        Query<LanguageConfEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        List<LanguageConfEntity> find = build.find();
        Intrinsics.checkNotNullExpressionValue(find, "find(...)");
        return CollectionsKt.toMutableList(find);
    }

    public final Object queryConf(String str, Continuation<? super LanguageConfEntity> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda9(this, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final LanguageConfEntity queryConf$lambda$15(LanguageDao languageDao, String str) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        Intrinsics.checkNotNullParameter(str, "$languageId");
        QueryBuilder<LanguageConfEntity> query = languageDao.getConfBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(LanguageConfEntity_.code, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        Query<LanguageConfEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.findFirst();
    }

    public final Object removeLanguageConfOfOtherVersion(String str, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new LanguageDao$$ExternalSyntheticLambda7(this, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long removeLanguageConfOfOtherVersion$lambda$17(LanguageDao languageDao, String str) {
        Intrinsics.checkNotNullParameter(languageDao, "this$0");
        Intrinsics.checkNotNullParameter(str, "$exceptVersion");
        QueryBuilder<LanguageConfEntity> query = languageDao.getConfBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(LanguageConfEntity_.version, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        Query<LanguageConfEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return Long.valueOf(build.remove());
    }
}

package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "call", "()Ljava/lang/Long;", "com/microtech/aidexx/db/dao/EventDao$findMaxEventId$2", "com/microtech/aidexx/db/repository/EventDbRepository$findMaxEventId$$inlined$findMaxEventId$1"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: EventDao.kt */
public final class EventRepository$getRecentData$result$1$invokeSuspend$$inlined$findMaxEventId$1<V> implements Callable {
    final /* synthetic */ Property $property;
    final /* synthetic */ String $userId;
    final /* synthetic */ Property $userIdProperty;

    public EventRepository$getRecentData$result$1$invokeSuspend$$inlined$findMaxEventId$1(Property property, Property property2, String str) {
        this.$property = property;
        this.$userIdProperty = property2;
        this.$userId = str;
    }

    public final Long call() {
        BoxStore store = ObjectBox.INSTANCE.getStore();
        Intrinsics.reifiedOperationMarker(4, "EVENT");
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        Box<BaseEventEntity> boxFor = store.boxFor(cls);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
        Box box = boxFor;
        Property property = this.$userIdProperty;
        String str = this.$userId;
        QueryBuilder<BaseEventEntity> query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        QueryBuilder queryBuilder = query;
        Intrinsics.checkNotNull(property, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.findMaxEventId.<no name provided>.call$lambda$0>");
        Property property2 = property;
        query.equal((Property<BaseEventEntity>) property, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        Query<BaseEventEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        Property property3 = this.$property;
        Intrinsics.checkNotNull(property3, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.findMaxEventId>");
        Property property4 = property3;
        return Long.valueOf(build.property(property3).max());
    }
}

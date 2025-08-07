package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.dao.EventDao;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00040\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "kotlin.jvm.PlatformType", "", "call", "com/microtech/aidexx/db/dao/EventDao$queryLatestHistory$2", "com/microtech/aidexx/db/repository/EventDbRepository$queryHistory$$inlined$queryLatestHistory$default$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDao.kt */
public final class SportViewModel$getDetailHistory$$inlined$queryHistory$1<V> implements Callable {
    final /* synthetic */ long $limit;
    final /* synthetic */ Property $timestampProperty;

    public SportViewModel$getDetailHistory$$inlined$queryHistory$1(long j, Property property) {
        this.$limit = j;
        this.$timestampProperty = property;
    }

    public final List<ExerciseEntity> call() {
        Property<ExerciseEntity> deleteStatusProperty = EventDao.INSTANCE.getDeleteStatusProperty(ExerciseEntity.class);
        if (deleteStatusProperty == null) {
            return null;
        }
        long j = this.$limit;
        Property property = this.$timestampProperty;
        Box<ExerciseEntity> boxFor = ObjectBox.INSTANCE.getStore().boxFor(ExerciseEntity.class);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
        QueryBuilder<ExerciseEntity> query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(deleteStatusProperty, 0);
        query.orderDesc(property);
        Query<ExerciseEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find(0, j);
    }
}

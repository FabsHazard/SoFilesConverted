package com.microtech.aidexx.db.dao;

import androidx.exifinterface.media.ExifInterface;
import com.microtech.aidexx.db.ObjectBox;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00040\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "kotlin.jvm.PlatformType", "", "call"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: EventDao.kt */
public final class EventDao$queryLatestHistory$2<V> implements Callable {
    final /* synthetic */ long $limit;
    final /* synthetic */ Property<T> $timestampProperty;

    public EventDao$queryLatestHistory$2(long j, Property<T> property) {
        this.$limit = j;
        this.$timestampProperty = property;
    }

    public final List<T> call() {
        EventDao eventDao = EventDao.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        Property<Object> deleteStatusProperty = eventDao.getDeleteStatusProperty(cls);
        if (deleteStatusProperty == null) {
            return null;
        }
        long j = this.$limit;
        Property<T> property = this.$timestampProperty;
        Property property2 = deleteStatusProperty;
        BoxStore store = ObjectBox.INSTANCE.getStore();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls3 = Object.class;
        Class cls4 = cls3;
        Box<Object> boxFor = store.boxFor(cls3);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
        Box box = boxFor;
        QueryBuilder<Object> query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        QueryBuilder queryBuilder = query;
        query.equal(deleteStatusProperty, 0);
        query.orderDesc(property);
        Query<Object> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        List<Object> find = build.find(0, j);
        List list = find;
        return find;
    }
}

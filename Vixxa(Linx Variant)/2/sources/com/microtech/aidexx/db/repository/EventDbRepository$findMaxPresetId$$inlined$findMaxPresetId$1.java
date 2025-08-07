package com.microtech.aidexx.db.repository;

import androidx.exifinterface.media.ExifInterface;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.query.Query;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "call", "()Ljava/lang/Long;", "com/microtech/aidexx/db/dao/EventDao$findMaxPresetId$3"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: EventDao.kt */
public final class EventDbRepository$findMaxPresetId$$inlined$findMaxPresetId$1<V> implements Callable {
    final /* synthetic */ Property $property;

    public EventDbRepository$findMaxPresetId$$inlined$findMaxPresetId$1(Property property) {
        this.$property = property;
    }

    public final Long call() {
        BoxStore store = ObjectBox.INSTANCE.getStore();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BasePresetEntity> cls = BasePresetEntity.class;
        Class cls2 = cls;
        Query<BasePresetEntity> build = store.boxFor(cls).query().build();
        Property property = this.$property;
        Intrinsics.checkNotNull(property, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.findMaxPresetId>");
        Property property2 = property;
        return Long.valueOf(build.property(property).max());
    }
}

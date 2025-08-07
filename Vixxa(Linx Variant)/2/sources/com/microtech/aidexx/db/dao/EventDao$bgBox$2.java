package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import io.objectbox.Box;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDao.kt */
final class EventDao$bgBox$2 extends Lambda implements Function0<Box<BloodGlucoseEntity>> {
    public static final EventDao$bgBox$2 INSTANCE = new EventDao$bgBox$2();

    EventDao$bgBox$2() {
        super(0);
    }

    public final Box<BloodGlucoseEntity> invoke() {
        Box<BloodGlucoseEntity> boxFor = ObjectBox.INSTANCE.getStore().boxFor(BloodGlucoseEntity.class);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(T::class.java)");
        return boxFor;
    }
}

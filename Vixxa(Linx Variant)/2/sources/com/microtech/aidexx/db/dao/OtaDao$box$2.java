package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import io.objectbox.Box;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaDao.kt */
final class OtaDao$box$2 extends Lambda implements Function0<Box<OtaResourceEntity>> {
    public static final OtaDao$box$2 INSTANCE = new OtaDao$box$2();

    OtaDao$box$2() {
        super(0);
    }

    public final Box<OtaResourceEntity> invoke() {
        Box<OtaResourceEntity> boxFor = ObjectBox.INSTANCE.getStore().boxFor(OtaResourceEntity.class);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(T::class.java)");
        return boxFor;
    }
}

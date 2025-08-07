package com.microtech.aidexx.db.entity.event;

import com.microtech.aidexx.db.entity.event.UnitEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class UnitEntityCursor extends Cursor<UnitEntity> {
    private static final UnitEntity_.UnitEntityIdGetter ID_GETTER = UnitEntity_.__ID_GETTER;
    private static final int __ID_eventType = UnitEntity_.eventType.id;
    private static final int __ID_isDefault = UnitEntity_.isDefault.id;
    private static final int __ID_language = UnitEntity_.language.id;
    private static final int __ID_name = UnitEntity_.name.id;
    private static final int __ID_ratio = UnitEntity_.ratio.id;
    private static final int __ID_value = UnitEntity_.value.id;
    private static final int __ID_version = UnitEntity_.version.id;

    static final class Factory implements CursorFactory<UnitEntity> {
        Factory() {
        }

        public Cursor<UnitEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new UnitEntityCursor(transaction, j, boxStore);
        }
    }

    public UnitEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, UnitEntity_.__INSTANCE, boxStore);
    }

    public long getId(UnitEntity unitEntity) {
        return ID_GETTER.getId(unitEntity);
    }

    public long put(UnitEntity unitEntity) {
        String language = unitEntity.getLanguage();
        int i = 0;
        int i2 = language != null ? __ID_language : 0;
        String name = unitEntity.getName();
        int i3 = name != null ? __ID_name : 0;
        String version = unitEntity.getVersion();
        if (version != null) {
            i = __ID_version;
        }
        long collect313311 = collect313311(this.cursor, unitEntity.getId(), 3, i2, language, i3, name, i, version, 0, (byte[]) null, __ID_eventType, (long) unitEntity.getEventType(), __ID_value, (long) unitEntity.getValue(), __ID_isDefault, (long) unitEntity.isDefault(), 0, 0, 0, 0, 0, 0, 0, 0.0f, __ID_ratio, unitEntity.getRatio());
        unitEntity.setId(collect313311);
        return collect313311;
    }
}

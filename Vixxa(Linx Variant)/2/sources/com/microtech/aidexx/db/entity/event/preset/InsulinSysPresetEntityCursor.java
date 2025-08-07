package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class InsulinSysPresetEntityCursor extends Cursor<InsulinSysPresetEntity> {
    private static final InsulinSysPresetEntity_.InsulinSysPresetEntityIdGetter ID_GETTER = InsulinSysPresetEntity_.__ID_GETTER;
    private static final int __ID_categoryName = InsulinSysPresetEntity_.categoryName.id;
    private static final int __ID_comment = InsulinSysPresetEntity_.comment.id;
    private static final int __ID_deleteFlag = InsulinSysPresetEntity_.deleteFlag.id;
    private static final int __ID_insulinSysPresetId = InsulinSysPresetEntity_.insulinSysPresetId.id;
    private static final int __ID_language = InsulinSysPresetEntity_.language.id;
    private static final int __ID_manufacturer = InsulinSysPresetEntity_.manufacturer.id;
    private static final int __ID_name = InsulinSysPresetEntity_.name.id;
    private static final int __ID_tradeName = InsulinSysPresetEntity_.tradeName.id;
    private static final int __ID_userId = InsulinSysPresetEntity_.userId.id;
    private static final int __ID_version = InsulinSysPresetEntity_.version.id;

    static final class Factory implements CursorFactory<InsulinSysPresetEntity> {
        Factory() {
        }

        public Cursor<InsulinSysPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new InsulinSysPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public InsulinSysPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, InsulinSysPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(InsulinSysPresetEntity insulinSysPresetEntity) {
        return ID_GETTER.getId(insulinSysPresetEntity);
    }

    public long put(InsulinSysPresetEntity insulinSysPresetEntity) {
        String name = insulinSysPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = insulinSysPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = insulinSysPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String categoryName = insulinSysPresetEntity.getCategoryName();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, categoryName != null ? __ID_categoryName : 0, categoryName);
        String tradeName = insulinSysPresetEntity.getTradeName();
        int i5 = tradeName != null ? __ID_tradeName : 0;
        String manufacturer = insulinSysPresetEntity.getManufacturer();
        int i6 = manufacturer != null ? __ID_manufacturer : 0;
        String comment = insulinSysPresetEntity.getComment();
        int i7 = comment != null ? __ID_comment : 0;
        String version = insulinSysPresetEntity.getVersion();
        collect400000(this.cursor, 0, 0, i5, tradeName, i6, manufacturer, i7, comment, version != null ? __ID_version : 0, version);
        Long insulinSysPresetId = insulinSysPresetEntity.getInsulinSysPresetId();
        if (insulinSysPresetId != null) {
            i = __ID_insulinSysPresetId;
        }
        int i8 = i;
        long collect004000 = collect004000(this.cursor, insulinSysPresetEntity.getIdx(), 2, i8, i8 != 0 ? insulinSysPresetId.longValue() : 0, __ID_deleteFlag, (long) insulinSysPresetEntity.getDeleteFlag(), 0, 0, 0, 0);
        insulinSysPresetEntity.setIdx(collect004000);
        return collect004000;
    }
}

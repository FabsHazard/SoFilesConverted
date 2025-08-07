package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class InsulinUsrPresetEntityCursor extends Cursor<InsulinUsrPresetEntity> {
    private static final InsulinUsrPresetEntity_.InsulinUsrPresetEntityIdGetter ID_GETTER = InsulinUsrPresetEntity_.__ID_GETTER;
    private static final int __ID_autoIncrementColumn = InsulinUsrPresetEntity_.autoIncrementColumn.id;
    private static final int __ID_categoryName = InsulinUsrPresetEntity_.categoryName.id;
    private static final int __ID_comment = InsulinUsrPresetEntity_.comment.id;
    private static final int __ID_deleteFlag = InsulinUsrPresetEntity_.deleteFlag.id;
    private static final int __ID_insulinUserPresetId = InsulinUsrPresetEntity_.insulinUserPresetId.id;
    private static final int __ID_language = InsulinUsrPresetEntity_.language.id;
    private static final int __ID_manufacturer = InsulinUsrPresetEntity_.manufacturer.id;
    private static final int __ID_name = InsulinUsrPresetEntity_.name.id;
    private static final int __ID_tradeName = InsulinUsrPresetEntity_.tradeName.id;
    private static final int __ID_userId = InsulinUsrPresetEntity_.userId.id;

    static final class Factory implements CursorFactory<InsulinUsrPresetEntity> {
        Factory() {
        }

        public Cursor<InsulinUsrPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new InsulinUsrPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public InsulinUsrPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, InsulinUsrPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(InsulinUsrPresetEntity insulinUsrPresetEntity) {
        return ID_GETTER.getId(insulinUsrPresetEntity);
    }

    public long put(InsulinUsrPresetEntity insulinUsrPresetEntity) {
        String name = insulinUsrPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = insulinUsrPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = insulinUsrPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String categoryName = insulinUsrPresetEntity.getCategoryName();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, categoryName != null ? __ID_categoryName : 0, categoryName);
        String tradeName = insulinUsrPresetEntity.getTradeName();
        int i5 = tradeName != null ? __ID_tradeName : 0;
        String manufacturer = insulinUsrPresetEntity.getManufacturer();
        int i6 = manufacturer != null ? __ID_manufacturer : 0;
        String comment = insulinUsrPresetEntity.getComment();
        int i7 = comment != null ? __ID_comment : 0;
        String insulinUserPresetId = insulinUsrPresetEntity.getInsulinUserPresetId();
        collect400000(this.cursor, 0, 0, i5, tradeName, i6, manufacturer, i7, comment, insulinUserPresetId != null ? __ID_insulinUserPresetId : 0, insulinUserPresetId);
        Long autoIncrementColumn = insulinUsrPresetEntity.getAutoIncrementColumn();
        if (autoIncrementColumn != null) {
            i = __ID_autoIncrementColumn;
        }
        int i8 = i;
        long collect004000 = collect004000(this.cursor, insulinUsrPresetEntity.getIdx(), 2, i8, i8 != 0 ? autoIncrementColumn.longValue() : 0, __ID_deleteFlag, (long) insulinUsrPresetEntity.getDeleteFlag(), 0, 0, 0, 0);
        insulinUsrPresetEntity.setIdx(collect004000);
        return collect004000;
    }
}

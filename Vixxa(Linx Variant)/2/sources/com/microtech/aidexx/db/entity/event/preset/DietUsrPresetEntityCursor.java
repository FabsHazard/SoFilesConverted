package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class DietUsrPresetEntityCursor extends Cursor<DietUsrPresetEntity> {
    private static final DietUsrPresetEntity_.DietUsrPresetEntityIdGetter ID_GETTER = DietUsrPresetEntity_.__ID_GETTER;
    private static final int __ID_autoIncrementColumn = DietUsrPresetEntity_.autoIncrementColumn.id;
    private static final int __ID_carbohydrate = DietUsrPresetEntity_.carbohydrate.id;
    private static final int __ID_deleteFlag = DietUsrPresetEntity_.deleteFlag.id;
    private static final int __ID_fat = DietUsrPresetEntity_.fat.id;
    private static final int __ID_foodUserPresetId = DietUsrPresetEntity_.foodUserPresetId.id;
    private static final int __ID_language = DietUsrPresetEntity_.language.id;
    private static final int __ID_name = DietUsrPresetEntity_.name.id;
    private static final int __ID_protein = DietUsrPresetEntity_.protein.id;
    private static final int __ID_quantity = DietUsrPresetEntity_.quantity.id;
    private static final int __ID_unit = DietUsrPresetEntity_.unit.id;
    private static final int __ID_userId = DietUsrPresetEntity_.userId.id;

    static final class Factory implements CursorFactory<DietUsrPresetEntity> {
        Factory() {
        }

        public Cursor<DietUsrPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new DietUsrPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public DietUsrPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, DietUsrPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(DietUsrPresetEntity dietUsrPresetEntity) {
        return ID_GETTER.getId(dietUsrPresetEntity);
    }

    public long put(DietUsrPresetEntity dietUsrPresetEntity) {
        String name = dietUsrPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = dietUsrPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = dietUsrPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String foodUserPresetId = dietUsrPresetEntity.getFoodUserPresetId();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, foodUserPresetId != null ? __ID_foodUserPresetId : 0, foodUserPresetId);
        Long autoIncrementColumn = dietUsrPresetEntity.getAutoIncrementColumn();
        if (autoIncrementColumn != null) {
            i = __ID_autoIncrementColumn;
        }
        int i5 = i;
        collect002033(this.cursor, 0, 0, i5, i5 != 0 ? autoIncrementColumn.longValue() : 0, __ID_deleteFlag, (long) dietUsrPresetEntity.getDeleteFlag(), 0, 0.0f, 0, 0.0f, 0, 0.0f, __ID_protein, dietUsrPresetEntity.getProtein(), __ID_fat, dietUsrPresetEntity.getFat(), __ID_carbohydrate, dietUsrPresetEntity.getCarbohydrate());
        long collect313311 = collect313311(this.cursor, dietUsrPresetEntity.getIdx(), 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, __ID_unit, (long) dietUsrPresetEntity.getUnit(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, __ID_quantity, dietUsrPresetEntity.getQuantity());
        dietUsrPresetEntity.setIdx(collect313311);
        return collect313311;
    }
}

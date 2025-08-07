package com.microtech.aidexx.db.entity.event.preset;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class DietSysPresetEntityCursor extends Cursor<DietSysPresetEntity> {
    private static final DietSysPresetEntity_.DietSysPresetEntityIdGetter ID_GETTER = DietSysPresetEntity_.__ID_GETTER;
    private static final int __ID_carbohydrate = DietSysPresetEntity_.carbohydrate.id;
    private static final int __ID_deleteFlag = DietSysPresetEntity_.deleteFlag.id;
    private static final int __ID_energyKcal = DietSysPresetEntity_.energyKcal.id;
    private static final int __ID_fat = DietSysPresetEntity_.fat.id;
    private static final int __ID_foodSysPresetId = DietSysPresetEntity_.foodSysPresetId.id;
    private static final int __ID_language = DietSysPresetEntity_.language.id;
    private static final int __ID_name = DietSysPresetEntity_.name.id;
    private static final int __ID_protein = DietSysPresetEntity_.protein.id;
    private static final int __ID_quantity = DietSysPresetEntity_.quantity.id;
    private static final int __ID_unit = DietSysPresetEntity_.unit.id;
    private static final int __ID_userId = DietSysPresetEntity_.userId.id;
    private static final int __ID_version = DietSysPresetEntity_.version.id;

    static final class Factory implements CursorFactory<DietSysPresetEntity> {
        Factory() {
        }

        public Cursor<DietSysPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new DietSysPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public DietSysPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, DietSysPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(DietSysPresetEntity dietSysPresetEntity) {
        return ID_GETTER.getId(dietSysPresetEntity);
    }

    public long put(DietSysPresetEntity dietSysPresetEntity) {
        String name = dietSysPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = dietSysPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = dietSysPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String version = dietSysPresetEntity.getVersion();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, version != null ? __ID_version : 0, version);
        Long foodSysPresetId = dietSysPresetEntity.getFoodSysPresetId();
        if (foodSysPresetId != null) {
            i = __ID_foodSysPresetId;
        }
        int i5 = i;
        collect002033(this.cursor, 0, 0, i5, i5 != 0 ? foodSysPresetId.longValue() : 0, __ID_deleteFlag, (long) dietSysPresetEntity.getDeleteFlag(), 0, 0.0f, 0, 0.0f, 0, 0.0f, __ID_protein, dietSysPresetEntity.getProtein(), __ID_fat, dietSysPresetEntity.getFat(), __ID_carbohydrate, dietSysPresetEntity.getCarbohydrate());
        long collect002033 = collect002033(this.cursor, dietSysPresetEntity.getIdx(), 2, __ID_unit, (long) dietSysPresetEntity.getUnit(), 0, 0, 0, 0.0f, 0, 0.0f, 0, 0.0f, __ID_quantity, dietSysPresetEntity.getQuantity(), __ID_energyKcal, dietSysPresetEntity.getEnergyKcal(), 0, Utils.DOUBLE_EPSILON);
        dietSysPresetEntity.setIdx(collect002033);
        return collect002033;
    }
}

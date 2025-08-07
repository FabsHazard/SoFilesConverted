package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class MedicineUsrPresetEntityCursor extends Cursor<MedicineUsrPresetEntity> {
    private static final MedicineUsrPresetEntity_.MedicineUsrPresetEntityIdGetter ID_GETTER = MedicineUsrPresetEntity_.__ID_GETTER;
    private static final int __ID_autoIncrementColumn = MedicineUsrPresetEntity_.autoIncrementColumn.id;
    private static final int __ID_categoryName = MedicineUsrPresetEntity_.categoryName.id;
    private static final int __ID_deleteFlag = MedicineUsrPresetEntity_.deleteFlag.id;
    private static final int __ID_englishName = MedicineUsrPresetEntity_.englishName.id;
    private static final int __ID_language = MedicineUsrPresetEntity_.language.id;
    private static final int __ID_manufacturer = MedicineUsrPresetEntity_.manufacturer.id;
    private static final int __ID_medicationUserPresetId = MedicineUsrPresetEntity_.medicationUserPresetId.id;
    private static final int __ID_name = MedicineUsrPresetEntity_.name.id;
    private static final int __ID_tradeName = MedicineUsrPresetEntity_.tradeName.id;
    private static final int __ID_userId = MedicineUsrPresetEntity_.userId.id;

    static final class Factory implements CursorFactory<MedicineUsrPresetEntity> {
        Factory() {
        }

        public Cursor<MedicineUsrPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new MedicineUsrPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public MedicineUsrPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, MedicineUsrPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(MedicineUsrPresetEntity medicineUsrPresetEntity) {
        return ID_GETTER.getId(medicineUsrPresetEntity);
    }

    public long put(MedicineUsrPresetEntity medicineUsrPresetEntity) {
        String name = medicineUsrPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = medicineUsrPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = medicineUsrPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String categoryName = medicineUsrPresetEntity.getCategoryName();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, categoryName != null ? __ID_categoryName : 0, categoryName);
        String tradeName = medicineUsrPresetEntity.getTradeName();
        int i5 = tradeName != null ? __ID_tradeName : 0;
        String manufacturer = medicineUsrPresetEntity.getManufacturer();
        int i6 = manufacturer != null ? __ID_manufacturer : 0;
        String englishName = medicineUsrPresetEntity.getEnglishName();
        int i7 = englishName != null ? __ID_englishName : 0;
        String medicationUserPresetId = medicineUsrPresetEntity.getMedicationUserPresetId();
        collect400000(this.cursor, 0, 0, i5, tradeName, i6, manufacturer, i7, englishName, medicationUserPresetId != null ? __ID_medicationUserPresetId : 0, medicationUserPresetId);
        Long autoIncrementColumn = medicineUsrPresetEntity.getAutoIncrementColumn();
        if (autoIncrementColumn != null) {
            i = __ID_autoIncrementColumn;
        }
        int i8 = i;
        long collect004000 = collect004000(this.cursor, medicineUsrPresetEntity.getIdx(), 2, i8, i8 != 0 ? autoIncrementColumn.longValue() : 0, __ID_deleteFlag, (long) medicineUsrPresetEntity.getDeleteFlag(), 0, 0, 0, 0);
        medicineUsrPresetEntity.setIdx(collect004000);
        return collect004000;
    }
}

package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class MedicineSysPresetEntityCursor extends Cursor<MedicineSysPresetEntity> {
    private static final MedicineSysPresetEntity_.MedicineSysPresetEntityIdGetter ID_GETTER = MedicineSysPresetEntity_.__ID_GETTER;
    private static final int __ID_categoryName = MedicineSysPresetEntity_.categoryName.id;
    private static final int __ID_deleteFlag = MedicineSysPresetEntity_.deleteFlag.id;
    private static final int __ID_englishName = MedicineSysPresetEntity_.englishName.id;
    private static final int __ID_language = MedicineSysPresetEntity_.language.id;
    private static final int __ID_manufacturer = MedicineSysPresetEntity_.manufacturer.id;
    private static final int __ID_medicationSysPresetId = MedicineSysPresetEntity_.medicationSysPresetId.id;
    private static final int __ID_name = MedicineSysPresetEntity_.name.id;
    private static final int __ID_tradeName = MedicineSysPresetEntity_.tradeName.id;
    private static final int __ID_userId = MedicineSysPresetEntity_.userId.id;
    private static final int __ID_version = MedicineSysPresetEntity_.version.id;

    static final class Factory implements CursorFactory<MedicineSysPresetEntity> {
        Factory() {
        }

        public Cursor<MedicineSysPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new MedicineSysPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public MedicineSysPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, MedicineSysPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(MedicineSysPresetEntity medicineSysPresetEntity) {
        return ID_GETTER.getId(medicineSysPresetEntity);
    }

    public long put(MedicineSysPresetEntity medicineSysPresetEntity) {
        String name = medicineSysPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = medicineSysPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = medicineSysPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String categoryName = medicineSysPresetEntity.getCategoryName();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, categoryName != null ? __ID_categoryName : 0, categoryName);
        String tradeName = medicineSysPresetEntity.getTradeName();
        int i5 = tradeName != null ? __ID_tradeName : 0;
        String manufacturer = medicineSysPresetEntity.getManufacturer();
        int i6 = manufacturer != null ? __ID_manufacturer : 0;
        String englishName = medicineSysPresetEntity.getEnglishName();
        int i7 = englishName != null ? __ID_englishName : 0;
        String version = medicineSysPresetEntity.getVersion();
        collect400000(this.cursor, 0, 0, i5, tradeName, i6, manufacturer, i7, englishName, version != null ? __ID_version : 0, version);
        Long medicationSysPresetId = medicineSysPresetEntity.getMedicationSysPresetId();
        if (medicationSysPresetId != null) {
            i = __ID_medicationSysPresetId;
        }
        int i8 = i;
        long collect004000 = collect004000(this.cursor, medicineSysPresetEntity.getIdx(), 2, i8, i8 != 0 ? medicationSysPresetId.longValue() : 0, __ID_deleteFlag, (long) medicineSysPresetEntity.getDeleteFlag(), 0, 0, 0, 0);
        medicineSysPresetEntity.setIdx(collect004000);
        return collect004000;
    }
}

package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class SportSysPresetEntityCursor extends Cursor<SportSysPresetEntity> {
    private static final SportSysPresetEntity_.SportSysPresetEntityIdGetter ID_GETTER = SportSysPresetEntity_.__ID_GETTER;
    private static final int __ID_deleteFlag = SportSysPresetEntity_.deleteFlag.id;
    private static final int __ID_exerciseSysPresetId = SportSysPresetEntity_.exerciseSysPresetId.id;
    private static final int __ID_hourKcalPerKg = SportSysPresetEntity_.hourKcalPerKg.id;
    private static final int __ID_intensityCategoryName = SportSysPresetEntity_.intensityCategoryName.id;
    private static final int __ID_language = SportSysPresetEntity_.language.id;
    private static final int __ID_name = SportSysPresetEntity_.name.id;
    private static final int __ID_userId = SportSysPresetEntity_.userId.id;
    private static final int __ID_version = SportSysPresetEntity_.version.id;

    static final class Factory implements CursorFactory<SportSysPresetEntity> {
        Factory() {
        }

        public Cursor<SportSysPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new SportSysPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public SportSysPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, SportSysPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(SportSysPresetEntity sportSysPresetEntity) {
        return ID_GETTER.getId(sportSysPresetEntity);
    }

    public long put(SportSysPresetEntity sportSysPresetEntity) {
        String name = sportSysPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = sportSysPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = sportSysPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String intensityCategoryName = sportSysPresetEntity.getIntensityCategoryName();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, intensityCategoryName != null ? __ID_intensityCategoryName : 0, intensityCategoryName);
        String version = sportSysPresetEntity.getVersion();
        int i5 = version != null ? __ID_version : 0;
        Long exerciseSysPresetId = sportSysPresetEntity.getExerciseSysPresetId();
        if (exerciseSysPresetId != null) {
            i = __ID_exerciseSysPresetId;
        }
        int i6 = i;
        long collect313311 = collect313311(this.cursor, sportSysPresetEntity.getIdx(), 2, i5, version, 0, (String) null, 0, (String) null, 0, (byte[]) null, i6, i6 != 0 ? exerciseSysPresetId.longValue() : 0, __ID_deleteFlag, (long) sportSysPresetEntity.getDeleteFlag(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, __ID_hourKcalPerKg, sportSysPresetEntity.getHourKcalPerKg());
        sportSysPresetEntity.setIdx(collect313311);
        return collect313311;
    }
}

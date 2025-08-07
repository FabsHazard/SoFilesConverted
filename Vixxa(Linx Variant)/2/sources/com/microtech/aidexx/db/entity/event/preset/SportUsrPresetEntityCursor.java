package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class SportUsrPresetEntityCursor extends Cursor<SportUsrPresetEntity> {
    private static final SportUsrPresetEntity_.SportUsrPresetEntityIdGetter ID_GETTER = SportUsrPresetEntity_.__ID_GETTER;
    private static final int __ID_autoIncrementColumn = SportUsrPresetEntity_.autoIncrementColumn.id;
    private static final int __ID_deleteFlag = SportUsrPresetEntity_.deleteFlag.id;
    private static final int __ID_exerciseUserPresetId = SportUsrPresetEntity_.exerciseUserPresetId.id;
    private static final int __ID_hourKcalPerKg = SportUsrPresetEntity_.hourKcalPerKg.id;
    private static final int __ID_intensityCategoryName = SportUsrPresetEntity_.intensityCategoryName.id;
    private static final int __ID_language = SportUsrPresetEntity_.language.id;
    private static final int __ID_name = SportUsrPresetEntity_.name.id;
    private static final int __ID_userId = SportUsrPresetEntity_.userId.id;

    static final class Factory implements CursorFactory<SportUsrPresetEntity> {
        Factory() {
        }

        public Cursor<SportUsrPresetEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new SportUsrPresetEntityCursor(transaction, j, boxStore);
        }
    }

    public SportUsrPresetEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, SportUsrPresetEntity_.__INSTANCE, boxStore);
    }

    public long getId(SportUsrPresetEntity sportUsrPresetEntity) {
        return ID_GETTER.getId(sportUsrPresetEntity);
    }

    public long put(SportUsrPresetEntity sportUsrPresetEntity) {
        String name = sportUsrPresetEntity.getName();
        int i = 0;
        int i2 = name != null ? __ID_name : 0;
        String userId = sportUsrPresetEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String language = sportUsrPresetEntity.getLanguage();
        int i4 = language != null ? __ID_language : 0;
        String intensityCategoryName = sportUsrPresetEntity.getIntensityCategoryName();
        collect400000(this.cursor, 0, 1, i2, name, i3, userId, i4, language, intensityCategoryName != null ? __ID_intensityCategoryName : 0, intensityCategoryName);
        String exerciseUserPresetId = sportUsrPresetEntity.getExerciseUserPresetId();
        int i5 = exerciseUserPresetId != null ? __ID_exerciseUserPresetId : 0;
        Long autoIncrementColumn = sportUsrPresetEntity.getAutoIncrementColumn();
        if (autoIncrementColumn != null) {
            i = __ID_autoIncrementColumn;
        }
        int i6 = i;
        long collect313311 = collect313311(this.cursor, sportUsrPresetEntity.getIdx(), 2, i5, exerciseUserPresetId, 0, (String) null, 0, (String) null, 0, (byte[]) null, i6, i6 != 0 ? autoIncrementColumn.longValue() : 0, __ID_deleteFlag, (long) sportUsrPresetEntity.getDeleteFlag(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, __ID_hourKcalPerKg, sportUsrPresetEntity.getHourKcalPerKg());
        sportUsrPresetEntity.setIdx(collect313311);
        return collect313311;
    }
}

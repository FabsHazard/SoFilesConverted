package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

public final class BloodGlucoseEntityCursor extends Cursor<BloodGlucoseEntity> {
    private static final BloodGlucoseEntity_.BloodGlucoseEntityIdGetter ID_GETTER = BloodGlucoseEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = BloodGlucoseEntity_.appCreateTime.id;
    private static final int __ID_appTime = BloodGlucoseEntity_.appTime.id;
    private static final int __ID_appTimeZone = BloodGlucoseEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = BloodGlucoseEntity_.autoIncrementColumn.id;
    private static final int __ID_bloodGlucoseId = BloodGlucoseEntity_.bloodGlucoseId.id;
    private static final int __ID_bloodGlucoseMg = BloodGlucoseEntity_.bloodGlucoseMg.id;
    private static final int __ID_deleteStatus = BloodGlucoseEntity_.deleteStatus.id;
    private static final int __ID_dstOffset = BloodGlucoseEntity_.dstOffset.id;
    private static final int __ID_id = BloodGlucoseEntity_.id.id;
    private static final int __ID_language = BloodGlucoseEntity_.language.id;
    private static final int __ID_moment = BloodGlucoseEntity_.moment.id;
    private static final int __ID_recordId = BloodGlucoseEntity_.recordId.id;
    private static final int __ID_recordIndex = BloodGlucoseEntity_.recordIndex.id;
    private static final int __ID_state = BloodGlucoseEntity_.state.id;
    private static final int __ID_testTag = BloodGlucoseEntity_.testTag.id;
    private static final int __ID_timestamp = BloodGlucoseEntity_.timestamp.id;
    private static final int __ID_uploadState = BloodGlucoseEntity_.uploadState.id;
    private static final int __ID_userId = BloodGlucoseEntity_.userId.id;

    static final class Factory implements CursorFactory<BloodGlucoseEntity> {
        Factory() {
        }

        public Cursor<BloodGlucoseEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new BloodGlucoseEntityCursor(transaction, j, boxStore);
        }
    }

    public BloodGlucoseEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, BloodGlucoseEntity_.__INSTANCE, boxStore);
    }

    public long getId(BloodGlucoseEntity bloodGlucoseEntity) {
        return ID_GETTER.getId(bloodGlucoseEntity);
    }

    public long put(BloodGlucoseEntity bloodGlucoseEntity) {
        String id = bloodGlucoseEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = bloodGlucoseEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = bloodGlucoseEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = bloodGlucoseEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = bloodGlucoseEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = bloodGlucoseEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = bloodGlucoseEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String bloodGlucoseId = bloodGlucoseEntity.getBloodGlucoseId();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, bloodGlucoseId != null ? __ID_bloodGlucoseId : 0, bloodGlucoseId);
        Long recordIndex = bloodGlucoseEntity.getRecordIndex();
        int i8 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = bloodGlucoseEntity.getAutoIncrementColumn();
        int i9 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        long j = 0;
        collect313311(this.cursor, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i8, i8 != 0 ? recordIndex.longValue() : 0, i9, i9 != 0 ? autoIncrementColumn.longValue() : 0, __ID_timestamp, bloodGlucoseEntity.getTimestamp(), __ID_state, bloodGlucoseEntity.getState(), __ID_deleteStatus, bloodGlucoseEntity.getDeleteStatus(), __ID_uploadState, bloodGlucoseEntity.getUploadState(), __ID_bloodGlucoseMg, bloodGlucoseEntity.getBloodGlucoseMg(), 0, Utils.DOUBLE_EPSILON);
        Long idx = bloodGlucoseEntity.getIdx();
        Date appCreateTime = bloodGlucoseEntity.getAppCreateTime();
        if (appCreateTime != null) {
            i = __ID_appCreateTime;
        }
        int i10 = i;
        long j2 = this.cursor;
        long longValue = idx != null ? idx.longValue() : 0;
        if (i10 != 0) {
            j = appCreateTime.getTime();
        }
        long collect004000 = collect004000(j2, longValue, 2, i10, j, __ID_moment, (long) bloodGlucoseEntity.getMoment(), __ID_testTag, (long) bloodGlucoseEntity.getTestTag(), 0, 0);
        bloodGlucoseEntity.setIdx(Long.valueOf(collect004000));
        return collect004000;
    }
}

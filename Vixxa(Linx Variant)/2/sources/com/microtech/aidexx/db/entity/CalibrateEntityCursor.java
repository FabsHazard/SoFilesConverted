package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.CalibrateEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

public final class CalibrateEntityCursor extends Cursor<CalibrateEntity> {
    private static final CalibrateEntity_.CalibrateEntityIdGetter ID_GETTER = CalibrateEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = CalibrateEntity_.appCreateTime.id;
    private static final int __ID_appTime = CalibrateEntity_.appTime.id;
    private static final int __ID_appTimeZone = CalibrateEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = CalibrateEntity_.autoIncrementColumn.id;
    private static final int __ID_calTime = CalibrateEntity_.calTime.id;
    private static final int __ID_calibrationId = CalibrateEntity_.calibrationId.id;
    private static final int __ID_cf = CalibrateEntity_.cf.id;
    private static final int __ID_deleteStatus = CalibrateEntity_.deleteStatus.id;
    private static final int __ID_deviceId = CalibrateEntity_.deviceId.id;
    private static final int __ID_dstOffset = CalibrateEntity_.dstOffset.id;
    private static final int __ID_eventIndex = CalibrateEntity_.eventIndex.id;
    private static final int __ID_id = CalibrateEntity_.id.id;
    private static final int __ID_index = CalibrateEntity_.index.id;
    private static final int __ID_indexAfterCal = CalibrateEntity_.indexAfterCal.id;
    private static final int __ID_indexBeforeCal = CalibrateEntity_.indexBeforeCal.id;
    private static final int __ID_isValid = CalibrateEntity_.isValid.id;
    private static final int __ID_language = CalibrateEntity_.language.id;
    private static final int __ID_moment = CalibrateEntity_.moment.id;
    private static final int __ID_offset = CalibrateEntity_.offset.id;
    private static final int __ID_recordId = CalibrateEntity_.recordId.id;
    private static final int __ID_recordIndex = CalibrateEntity_.recordIndex.id;
    private static final int __ID_referenceGlucose = CalibrateEntity_.referenceGlucose.id;
    private static final int __ID_sensorId = CalibrateEntity_.sensorId.id;
    private static final int __ID_sensorIndex = CalibrateEntity_.sensorIndex.id;
    private static final int __ID_state = CalibrateEntity_.state.id;
    private static final int __ID_timeOffset = CalibrateEntity_.timeOffset.id;
    private static final int __ID_timestamp = CalibrateEntity_.timestamp.id;
    private static final int __ID_uploadState = CalibrateEntity_.uploadState.id;
    private static final int __ID_userId = CalibrateEntity_.userId.id;

    static final class Factory implements CursorFactory<CalibrateEntity> {
        Factory() {
        }

        public Cursor<CalibrateEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new CalibrateEntityCursor(transaction, j, boxStore);
        }
    }

    public CalibrateEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, CalibrateEntity_.__INSTANCE, boxStore);
    }

    public long getId(CalibrateEntity calibrateEntity) {
        return ID_GETTER.getId(calibrateEntity);
    }

    public long put(CalibrateEntity calibrateEntity) {
        String id = calibrateEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = calibrateEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = calibrateEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = calibrateEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = calibrateEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = calibrateEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = calibrateEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String deviceId = calibrateEntity.getDeviceId();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, deviceId != null ? __ID_deviceId : 0, deviceId);
        String calibrationId = calibrateEntity.getCalibrationId();
        int i8 = calibrationId != null ? __ID_calibrationId : 0;
        String sensorId = calibrateEntity.getSensorId();
        int i9 = sensorId != null ? __ID_sensorId : 0;
        Long recordIndex = calibrateEntity.getRecordIndex();
        int i10 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = calibrateEntity.getAutoIncrementColumn();
        int i11 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        long j = 0;
        collect313311(this.cursor, 0, 0, i8, calibrationId, i9, sensorId, 0, (String) null, 0, (byte[]) null, i10, i10 != 0 ? recordIndex.longValue() : 0, i11, i11 != 0 ? autoIncrementColumn.longValue() : 0, __ID_timestamp, calibrateEntity.getTimestamp(), __ID_state, calibrateEntity.getState(), __ID_deleteStatus, calibrateEntity.getDeleteStatus(), __ID_uploadState, calibrateEntity.getUploadState(), __ID_referenceGlucose, calibrateEntity.getReferenceGlucose(), 0, Utils.DOUBLE_EPSILON);
        Date appCreateTime = calibrateEntity.getAppCreateTime();
        int i12 = appCreateTime != null ? __ID_appCreateTime : 0;
        Date calTime = calibrateEntity.getCalTime();
        int i13 = calTime != null ? __ID_calTime : 0;
        collect313311(this.cursor, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i12, i12 != 0 ? appCreateTime.getTime() : 0, i13, i13 != 0 ? calTime.getTime() : 0, __ID_moment, (long) calibrateEntity.getMoment(), __ID_eventIndex, calibrateEntity.getEventIndex(), __ID_sensorIndex, calibrateEntity.getSensorIndex(), __ID_indexBeforeCal, calibrateEntity.getIndexBeforeCal(), __ID_cf, calibrateEntity.getCf(), 0, Utils.DOUBLE_EPSILON);
        Long idx = calibrateEntity.getIdx();
        Integer isValid = calibrateEntity.isValid();
        if (isValid != null) {
            i = __ID_isValid;
        }
        int i14 = i;
        long j2 = this.cursor;
        long longValue = idx != null ? idx.longValue() : 0;
        int i15 = __ID_indexAfterCal;
        long indexAfterCal = (long) calibrateEntity.getIndexAfterCal();
        if (i14 != 0) {
            j = (long) isValid.intValue();
        }
        long collect313311 = collect313311(j2, longValue, 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i15, indexAfterCal, i14, j, __ID_index, (long) calibrateEntity.getIndex(), __ID_timeOffset, calibrateEntity.getTimeOffset(), 0, 0, 0, 0, __ID_offset, calibrateEntity.getOffset(), 0, Utils.DOUBLE_EPSILON);
        calibrateEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

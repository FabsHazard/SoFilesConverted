package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

public final class RealCgmHistoryEntityCursor extends Cursor<RealCgmHistoryEntity> {
    private static final RealCgmHistoryEntity_.RealCgmHistoryEntityIdGetter ID_GETTER = RealCgmHistoryEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = RealCgmHistoryEntity_.appCreateTime.id;
    private static final int __ID_appTime = RealCgmHistoryEntity_.appTime.id;
    private static final int __ID_appTimeZone = RealCgmHistoryEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = RealCgmHistoryEntity_.autoIncrementColumn.id;
    private static final int __ID_briefUploadState = RealCgmHistoryEntity_.briefUploadState.id;
    private static final int __ID_cgmRecordId = RealCgmHistoryEntity_.cgmRecordId.id;
    private static final int __ID_dataStatus = RealCgmHistoryEntity_.dataStatus.id;
    private static final int __ID_deleteStatus = RealCgmHistoryEntity_.deleteStatus.id;
    private static final int __ID_deviceId = RealCgmHistoryEntity_.deviceId.id;
    private static final int __ID_deviceSn = RealCgmHistoryEntity_.deviceSn.id;
    private static final int __ID_deviceTime = RealCgmHistoryEntity_.deviceTime.id;
    private static final int __ID_dstOffset = RealCgmHistoryEntity_.dstOffset.id;
    private static final int __ID_eventDataOrigin = RealCgmHistoryEntity_.eventDataOrigin.id;
    private static final int __ID_eventIndex = RealCgmHistoryEntity_.eventIndex.id;
    private static final int __ID_eventType = RealCgmHistoryEntity_.eventType.id;
    private static final int __ID_eventWarning = RealCgmHistoryEntity_.eventWarning.id;
    private static final int __ID_frontRecordId = RealCgmHistoryEntity_.frontRecordId.id;
    private static final int __ID_glucose = RealCgmHistoryEntity_.glucose.id;
    private static final int __ID_glucoseIsValid = RealCgmHistoryEntity_.glucoseIsValid.id;
    private static final int __ID_id = RealCgmHistoryEntity_.id.id;
    private static final int __ID_language = RealCgmHistoryEntity_.language.id;
    private static final int __ID_moment = RealCgmHistoryEntity_.moment.id;
    private static final int __ID_quality = RealCgmHistoryEntity_.quality.id;
    private static final int __ID_rawData1 = RealCgmHistoryEntity_.rawData1.id;
    private static final int __ID_rawData2 = RealCgmHistoryEntity_.rawData2.id;
    private static final int __ID_rawData3 = RealCgmHistoryEntity_.rawData3.id;
    private static final int __ID_rawData4 = RealCgmHistoryEntity_.rawData4.id;
    private static final int __ID_rawData5 = RealCgmHistoryEntity_.rawData5.id;
    private static final int __ID_rawData6 = RealCgmHistoryEntity_.rawData6.id;
    private static final int __ID_rawData7 = RealCgmHistoryEntity_.rawData7.id;
    private static final int __ID_rawData8 = RealCgmHistoryEntity_.rawData8.id;
    private static final int __ID_rawData9 = RealCgmHistoryEntity_.rawData9.id;
    private static final int __ID_rawIsValid = RealCgmHistoryEntity_.rawIsValid.id;
    private static final int __ID_rawOne = RealCgmHistoryEntity_.rawOne.id;
    private static final int __ID_rawTwo = RealCgmHistoryEntity_.rawTwo.id;
    private static final int __ID_rawUploadState = RealCgmHistoryEntity_.rawUploadState.id;
    private static final int __ID_rawVc = RealCgmHistoryEntity_.rawVc.id;
    private static final int __ID_recordId = RealCgmHistoryEntity_.recordId.id;
    private static final int __ID_recordIndex = RealCgmHistoryEntity_.recordIndex.id;
    private static final int __ID_referenceGlucose = RealCgmHistoryEntity_.referenceGlucose.id;
    private static final int __ID_sensorId = RealCgmHistoryEntity_.sensorId.id;
    private static final int __ID_sensorIndex = RealCgmHistoryEntity_.sensorIndex.id;
    private static final int __ID_state = RealCgmHistoryEntity_.state.id;
    private static final int __ID_status = RealCgmHistoryEntity_.status.id;
    private static final int __ID_timeOffset = RealCgmHistoryEntity_.timeOffset.id;
    private static final int __ID_timestamp = RealCgmHistoryEntity_.timestamp.id;
    private static final int __ID_type = RealCgmHistoryEntity_.type.id;
    private static final int __ID_uploadState = RealCgmHistoryEntity_.uploadState.id;
    private static final int __ID_userId = RealCgmHistoryEntity_.userId.id;

    static final class Factory implements CursorFactory<RealCgmHistoryEntity> {
        Factory() {
        }

        public Cursor<RealCgmHistoryEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new RealCgmHistoryEntityCursor(transaction, j, boxStore);
        }
    }

    public RealCgmHistoryEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, RealCgmHistoryEntity_.__INSTANCE, boxStore);
    }

    public long getId(RealCgmHistoryEntity realCgmHistoryEntity) {
        return ID_GETTER.getId(realCgmHistoryEntity);
    }

    public long put(RealCgmHistoryEntity realCgmHistoryEntity) {
        float f;
        float f2;
        float f3;
        String id = realCgmHistoryEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = realCgmHistoryEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = realCgmHistoryEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = realCgmHistoryEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = realCgmHistoryEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = realCgmHistoryEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = realCgmHistoryEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String deviceSn = realCgmHistoryEntity.getDeviceSn();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, deviceSn != null ? __ID_deviceSn : 0, deviceSn);
        String cgmRecordId = realCgmHistoryEntity.getCgmRecordId();
        int i8 = cgmRecordId != null ? __ID_cgmRecordId : 0;
        String sensorId = realCgmHistoryEntity.getSensorId();
        int i9 = sensorId != null ? __ID_sensorId : 0;
        String deviceId = realCgmHistoryEntity.getDeviceId();
        int i10 = deviceId != null ? __ID_deviceId : 0;
        String frontRecordId = realCgmHistoryEntity.getFrontRecordId();
        collect400000(this.cursor, 0, 0, i8, cgmRecordId, i9, sensorId, i10, deviceId, frontRecordId != null ? __ID_frontRecordId : 0, frontRecordId);
        Long recordIndex = realCgmHistoryEntity.getRecordIndex();
        int i11 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = realCgmHistoryEntity.getAutoIncrementColumn();
        int i12 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        Float glucose = realCgmHistoryEntity.getGlucose();
        int i13 = glucose != null ? __ID_glucose : 0;
        Float eventDataOrigin = realCgmHistoryEntity.getEventDataOrigin();
        int i14 = eventDataOrigin != null ? __ID_eventDataOrigin : 0;
        Float rawOne = realCgmHistoryEntity.getRawOne();
        int i15 = rawOne != null ? __ID_rawOne : 0;
        long j = 0;
        collect002033(this.cursor, 0, 0, i11, i11 != 0 ? recordIndex.longValue() : 0, i12, i12 != 0 ? autoIncrementColumn.longValue() : 0, i13, i13 != 0 ? glucose.floatValue() : 0.0f, i14, i14 != 0 ? eventDataOrigin.floatValue() : 0.0f, i15, i15 != 0 ? rawOne.floatValue() : 0.0f, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON);
        Date appCreateTime = realCgmHistoryEntity.getAppCreateTime();
        int i16 = appCreateTime != null ? __ID_appCreateTime : 0;
        Float rawTwo = realCgmHistoryEntity.getRawTwo();
        int i17 = rawTwo != null ? __ID_rawTwo : 0;
        Float rawVc = realCgmHistoryEntity.getRawVc();
        int i18 = rawVc != null ? __ID_rawVc : 0;
        collect002033(this.cursor, 0, 0, __ID_timestamp, realCgmHistoryEntity.getTimestamp(), i16, i16 != 0 ? appCreateTime.getTime() : 0, i17, i17 != 0 ? rawTwo.floatValue() : 0.0f, i18, i18 != 0 ? rawVc.floatValue() : 0.0f, __ID_referenceGlucose, realCgmHistoryEntity.getReferenceGlucose(), 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON);
        Date deviceTime = realCgmHistoryEntity.getDeviceTime();
        int i19 = deviceTime != null ? __ID_deviceTime : 0;
        Float rawData1 = realCgmHistoryEntity.getRawData1();
        int i20 = rawData1 != null ? __ID_rawData1 : 0;
        long j2 = this.cursor;
        long time = i19 != 0 ? deviceTime.getTime() : 0;
        int i21 = __ID_state;
        long state = (long) realCgmHistoryEntity.getState();
        int i22 = __ID_deleteStatus;
        long deleteStatus = (long) realCgmHistoryEntity.getDeleteStatus();
        int i23 = __ID_uploadState;
        int uploadState = realCgmHistoryEntity.getUploadState();
        int i24 = __ID_moment;
        int moment = realCgmHistoryEntity.getMoment();
        int i25 = __ID_briefUploadState;
        int briefUploadState = realCgmHistoryEntity.getBriefUploadState();
        if (i20 != 0) {
            f = rawData1.floatValue();
        } else {
            f = 0.0f;
        }
        collect313311(j2, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i19, time, i21, state, i22, deleteStatus, i23, uploadState, i24, moment, i25, briefUploadState, i20, f, 0, Utils.DOUBLE_EPSILON);
        Float rawData2 = realCgmHistoryEntity.getRawData2();
        int i26 = rawData2 != null ? __ID_rawData2 : 0;
        Float rawData3 = realCgmHistoryEntity.getRawData3();
        int i27 = rawData3 != null ? __ID_rawData3 : 0;
        Float rawData4 = realCgmHistoryEntity.getRawData4();
        int i28 = rawData4 != null ? __ID_rawData4 : 0;
        collect002033(this.cursor, 0, 0, __ID_rawUploadState, (long) realCgmHistoryEntity.getRawUploadState(), __ID_eventIndex, (long) realCgmHistoryEntity.getEventIndex(), i26, i26 != 0 ? rawData2.floatValue() : 0.0f, i27, i27 != 0 ? rawData3.floatValue() : 0.0f, i28, i28 != 0 ? rawData4.floatValue() : 0.0f, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON);
        Integer eventType = realCgmHistoryEntity.getEventType();
        int i29 = eventType != null ? __ID_eventType : 0;
        Integer rawIsValid = realCgmHistoryEntity.getRawIsValid();
        int i30 = rawIsValid != null ? __ID_rawIsValid : 0;
        Float rawData5 = realCgmHistoryEntity.getRawData5();
        int i31 = rawData5 != null ? __ID_rawData5 : 0;
        long j3 = this.cursor;
        int i32 = __ID_sensorIndex;
        long sensorIndex = (long) realCgmHistoryEntity.getSensorIndex();
        int i33 = __ID_dataStatus;
        long dataStatus = (long) realCgmHistoryEntity.getDataStatus();
        long intValue = i29 != 0 ? (long) eventType.intValue() : 0;
        int intValue2 = i30 != 0 ? rawIsValid.intValue() : 0;
        int i34 = __ID_glucoseIsValid;
        int glucoseIsValid = realCgmHistoryEntity.getGlucoseIsValid();
        int i35 = __ID_quality;
        int quality = realCgmHistoryEntity.getQuality();
        if (i31 != 0) {
            f2 = rawData5.floatValue();
        } else {
            f2 = 0.0f;
        }
        collect313311(j3, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i32, sensorIndex, i33, dataStatus, i29, intValue, i30, intValue2, i34, glucoseIsValid, i35, quality, i31, f2, 0, Utils.DOUBLE_EPSILON);
        Float rawData6 = realCgmHistoryEntity.getRawData6();
        int i36 = rawData6 != null ? __ID_rawData6 : 0;
        Float rawData7 = realCgmHistoryEntity.getRawData7();
        int i37 = rawData7 != null ? __ID_rawData7 : 0;
        Float rawData8 = realCgmHistoryEntity.getRawData8();
        int i38 = rawData8 != null ? __ID_rawData8 : 0;
        collect002033(this.cursor, 0, 0, __ID_status, (long) realCgmHistoryEntity.getStatus(), __ID_timeOffset, (long) realCgmHistoryEntity.getTimeOffset(), i36, i36 != 0 ? rawData6.floatValue() : 0.0f, i37, i37 != 0 ? rawData7.floatValue() : 0.0f, i38, i38 != 0 ? rawData8.floatValue() : 0.0f, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON);
        Long idx = realCgmHistoryEntity.getIdx();
        Float rawData9 = realCgmHistoryEntity.getRawData9();
        if (rawData9 != null) {
            i = __ID_rawData9;
        }
        int i39 = i;
        long j4 = this.cursor;
        if (idx != null) {
            j = idx.longValue();
        }
        long j5 = j;
        int i40 = __ID_eventWarning;
        long eventWarning = (long) realCgmHistoryEntity.getEventWarning();
        int i41 = __ID_type;
        long type = (long) realCgmHistoryEntity.getType();
        if (i39 != 0) {
            f3 = rawData9.floatValue();
        } else {
            f3 = 0.0f;
        }
        long collect313311 = collect313311(j4, j5, 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i40, eventWarning, i41, type, 0, 0, 0, 0, 0, 0, 0, 0, i39, f3, 0, Utils.DOUBLE_EPSILON);
        realCgmHistoryEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

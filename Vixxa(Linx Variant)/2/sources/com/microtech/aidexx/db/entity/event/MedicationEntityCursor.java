package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.MedicationEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;
import java.util.List;

public final class MedicationEntityCursor extends Cursor<MedicationEntity> {
    private static final MedicationEntity_.MedicationEntityIdGetter ID_GETTER = MedicationEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = MedicationEntity_.appCreateTime.id;
    private static final int __ID_appTime = MedicationEntity_.appTime.id;
    private static final int __ID_appTimeZone = MedicationEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = MedicationEntity_.autoIncrementColumn.id;
    private static final int __ID_deleteStatus = MedicationEntity_.deleteStatus.id;
    private static final int __ID_dstOffset = MedicationEntity_.dstOffset.id;
    private static final int __ID_expandList = MedicationEntity_.expandList.id;
    private static final int __ID_id = MedicationEntity_.id.id;
    private static final int __ID_isPreset = MedicationEntity_.isPreset.id;
    private static final int __ID_language = MedicationEntity_.language.id;
    private static final int __ID_medicationId = MedicationEntity_.medicationId.id;
    private static final int __ID_medicineDosage = MedicationEntity_.medicineDosage.id;
    private static final int __ID_medicineName = MedicationEntity_.medicineName.id;
    private static final int __ID_moment = MedicationEntity_.moment.id;
    private static final int __ID_recordId = MedicationEntity_.recordId.id;
    private static final int __ID_recordIndex = MedicationEntity_.recordIndex.id;
    private static final int __ID_state = MedicationEntity_.state.id;
    private static final int __ID_takenTime = MedicationEntity_.takenTime.id;
    private static final int __ID_timestamp = MedicationEntity_.timestamp.id;
    private static final int __ID_uploadState = MedicationEntity_.uploadState.id;
    private static final int __ID_userId = MedicationEntity_.userId.id;
    private final MedicationDetail expandListConverter = new MedicationDetail();

    static final class Factory implements CursorFactory<MedicationEntity> {
        Factory() {
        }

        public Cursor<MedicationEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new MedicationEntityCursor(transaction, j, boxStore);
        }
    }

    public MedicationEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, MedicationEntity_.__INSTANCE, boxStore);
    }

    public long getId(MedicationEntity medicationEntity) {
        return ID_GETTER.getId(medicationEntity);
    }

    public long put(MedicationEntity medicationEntity) {
        float f;
        String id = medicationEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = medicationEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = medicationEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = medicationEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = medicationEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = medicationEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = medicationEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String medicationId = medicationEntity.getMedicationId();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, medicationId != null ? __ID_medicationId : 0, medicationId);
        String medicineName = medicationEntity.getMedicineName();
        int i8 = medicineName != null ? __ID_medicineName : 0;
        List<MedicationDetail> expandList = medicationEntity.getExpandList();
        int i9 = expandList != null ? __ID_expandList : 0;
        Long recordIndex = medicationEntity.getRecordIndex();
        int i10 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = medicationEntity.getAutoIncrementColumn();
        int i11 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        Float medicineDosage = medicationEntity.getMedicineDosage();
        int i12 = medicineDosage != null ? __ID_medicineDosage : 0;
        long j = this.cursor;
        String convertToDatabaseValue = i9 != 0 ? this.expandListConverter.convertToDatabaseValue((List<? super BaseEventDetail>) expandList) : null;
        long j2 = 0;
        long longValue = i10 != 0 ? recordIndex.longValue() : 0;
        long longValue2 = i11 != 0 ? autoIncrementColumn.longValue() : 0;
        int i13 = __ID_timestamp;
        long timestamp = medicationEntity.getTimestamp();
        int i14 = __ID_state;
        int state = medicationEntity.getState();
        int i15 = __ID_deleteStatus;
        int deleteStatus = medicationEntity.getDeleteStatus();
        int i16 = __ID_uploadState;
        int uploadState = medicationEntity.getUploadState();
        if (i12 != 0) {
            f = medicineDosage.floatValue();
        } else {
            f = 0.0f;
        }
        collect313311(j, 0, 0, i8, medicineName, i9, convertToDatabaseValue, 0, (String) null, 0, (byte[]) null, i10, longValue, i11, longValue2, i13, timestamp, i14, state, i15, deleteStatus, i16, uploadState, i12, f, 0, Utils.DOUBLE_EPSILON);
        Long idx = medicationEntity.getIdx();
        Date appCreateTime = medicationEntity.getAppCreateTime();
        int i17 = appCreateTime != null ? __ID_appCreateTime : 0;
        Date takenTime = medicationEntity.getTakenTime();
        if (takenTime != null) {
            i = __ID_takenTime;
        }
        int i18 = i;
        long j3 = this.cursor;
        long longValue3 = idx != null ? idx.longValue() : 0;
        long time = i17 != 0 ? appCreateTime.getTime() : 0;
        long time2 = i18 != 0 ? takenTime.getTime() : 0;
        int i19 = __ID_moment;
        long moment = (long) medicationEntity.getMoment();
        int i20 = __ID_isPreset;
        if (medicationEntity.isPreset()) {
            j2 = 1;
        }
        long collect004000 = collect004000(j3, longValue3, 2, i17, time, i18, time2, i19, moment, i20, j2);
        medicationEntity.setIdx(Long.valueOf(collect004000));
        return collect004000;
    }
}

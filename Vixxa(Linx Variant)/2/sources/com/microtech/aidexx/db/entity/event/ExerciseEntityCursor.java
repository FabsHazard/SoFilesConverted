package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.ExerciseEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;
import java.util.List;

public final class ExerciseEntityCursor extends Cursor<ExerciseEntity> {
    private static final ExerciseEntity_.ExerciseEntityIdGetter ID_GETTER = ExerciseEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = ExerciseEntity_.appCreateTime.id;
    private static final int __ID_appTime = ExerciseEntity_.appTime.id;
    private static final int __ID_appTimeZone = ExerciseEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = ExerciseEntity_.autoIncrementColumn.id;
    private static final int __ID_deleteStatus = ExerciseEntity_.deleteStatus.id;
    private static final int __ID_dstOffset = ExerciseEntity_.dstOffset.id;
    private static final int __ID_duration = ExerciseEntity_.duration.id;
    private static final int __ID_exerciseId = ExerciseEntity_.exerciseId.id;
    private static final int __ID_expandList = ExerciseEntity_.expandList.id;
    private static final int __ID_id = ExerciseEntity_.id.id;
    private static final int __ID_intensity = ExerciseEntity_.intensity.id;
    private static final int __ID_isPreset = ExerciseEntity_.isPreset.id;
    private static final int __ID_language = ExerciseEntity_.language.id;
    private static final int __ID_moment = ExerciseEntity_.moment.id;
    private static final int __ID_recordId = ExerciseEntity_.recordId.id;
    private static final int __ID_recordIndex = ExerciseEntity_.recordIndex.id;
    private static final int __ID_startTime = ExerciseEntity_.startTime.id;
    private static final int __ID_state = ExerciseEntity_.state.id;
    private static final int __ID_timestamp = ExerciseEntity_.timestamp.id;
    private static final int __ID_uploadState = ExerciseEntity_.uploadState.id;
    private static final int __ID_userId = ExerciseEntity_.userId.id;
    private final ExerciseDetail expandListConverter = new ExerciseDetail();

    static final class Factory implements CursorFactory<ExerciseEntity> {
        Factory() {
        }

        public Cursor<ExerciseEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new ExerciseEntityCursor(transaction, j, boxStore);
        }
    }

    public ExerciseEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, ExerciseEntity_.__INSTANCE, boxStore);
    }

    public long getId(ExerciseEntity exerciseEntity) {
        return ID_GETTER.getId(exerciseEntity);
    }

    public long put(ExerciseEntity exerciseEntity) {
        String id = exerciseEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = exerciseEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = exerciseEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = exerciseEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = exerciseEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = exerciseEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = exerciseEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String exerciseId = exerciseEntity.getExerciseId();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, exerciseId != null ? __ID_exerciseId : 0, exerciseId);
        List<ExerciseDetail> expandList = exerciseEntity.getExpandList();
        int i8 = expandList != null ? __ID_expandList : 0;
        Long recordIndex = exerciseEntity.getRecordIndex();
        int i9 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = exerciseEntity.getAutoIncrementColumn();
        int i10 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        long j = 0;
        collect313311(this.cursor, 0, 0, i8, i8 != 0 ? this.expandListConverter.convertToDatabaseValue((List<? super BaseEventDetail>) expandList) : null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i9, i9 != 0 ? recordIndex.longValue() : 0, i10, i10 != 0 ? autoIncrementColumn.longValue() : 0, __ID_timestamp, exerciseEntity.getTimestamp(), __ID_state, exerciseEntity.getState(), __ID_deleteStatus, exerciseEntity.getDeleteStatus(), __ID_uploadState, exerciseEntity.getUploadState(), 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        Long idx = exerciseEntity.getIdx();
        Date appCreateTime = exerciseEntity.getAppCreateTime();
        int i11 = appCreateTime != null ? __ID_appCreateTime : 0;
        Date startTime = exerciseEntity.getStartTime();
        int i12 = startTime != null ? __ID_startTime : 0;
        Integer duration = exerciseEntity.getDuration();
        int i13 = duration != null ? __ID_duration : 0;
        Integer intensity = exerciseEntity.getIntensity();
        int i14 = intensity != null ? __ID_intensity : 0;
        long j2 = this.cursor;
        long longValue = idx != null ? idx.longValue() : 0;
        long time = i11 != 0 ? appCreateTime.getTime() : 0;
        if (i12 != 0) {
            j = startTime.getTime();
        }
        long j3 = j;
        int i15 = __ID_moment;
        long moment = (long) exerciseEntity.getMoment();
        int intValue = i13 != 0 ? duration.intValue() : 0;
        if (i14 != 0) {
            i = intensity.intValue();
        }
        long collect313311 = collect313311(j2, longValue, 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i11, time, i12, j3, i15, moment, i13, intValue, i14, i, __ID_isPreset, exerciseEntity.isPreset() ? 1 : 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        exerciseEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

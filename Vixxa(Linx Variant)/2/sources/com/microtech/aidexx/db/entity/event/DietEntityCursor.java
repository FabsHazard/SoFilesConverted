package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.DietEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;
import java.util.List;

public final class DietEntityCursor extends Cursor<DietEntity> {
    private static final DietEntity_.DietEntityIdGetter ID_GETTER = DietEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = DietEntity_.appCreateTime.id;
    private static final int __ID_appTime = DietEntity_.appTime.id;
    private static final int __ID_appTimeZone = DietEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = DietEntity_.autoIncrementColumn.id;
    private static final int __ID_carbohydrate = DietEntity_.carbohydrate.id;
    private static final int __ID_deleteStatus = DietEntity_.deleteStatus.id;
    private static final int __ID_dstOffset = DietEntity_.dstOffset.id;
    private static final int __ID_expandList = DietEntity_.expandList.id;
    private static final int __ID_foodId = DietEntity_.foodId.id;
    private static final int __ID_id = DietEntity_.id.id;
    private static final int __ID_isPreset = DietEntity_.isPreset.id;
    private static final int __ID_language = DietEntity_.language.id;
    private static final int __ID_mealRemark = DietEntity_.mealRemark.id;
    private static final int __ID_mealTime = DietEntity_.mealTime.id;
    private static final int __ID_moment = DietEntity_.moment.id;
    private static final int __ID_recordId = DietEntity_.recordId.id;
    private static final int __ID_recordIndex = DietEntity_.recordIndex.id;
    private static final int __ID_state = DietEntity_.state.id;
    private static final int __ID_timestamp = DietEntity_.timestamp.id;
    private static final int __ID_uploadState = DietEntity_.uploadState.id;
    private static final int __ID_userId = DietEntity_.userId.id;
    private final DietDetail expandListConverter = new DietDetail();

    static final class Factory implements CursorFactory<DietEntity> {
        Factory() {
        }

        public Cursor<DietEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new DietEntityCursor(transaction, j, boxStore);
        }
    }

    public DietEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, DietEntity_.__INSTANCE, boxStore);
    }

    public long getId(DietEntity dietEntity) {
        return ID_GETTER.getId(dietEntity);
    }

    public long put(DietEntity dietEntity) {
        String id = dietEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = dietEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = dietEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = dietEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = dietEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = dietEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = dietEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String foodId = dietEntity.getFoodId();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, foodId != null ? __ID_foodId : 0, foodId);
        String mealRemark = dietEntity.getMealRemark();
        int i8 = mealRemark != null ? __ID_mealRemark : 0;
        List<DietDetail> expandList = dietEntity.getExpandList();
        int i9 = expandList != null ? __ID_expandList : 0;
        Long recordIndex = dietEntity.getRecordIndex();
        int i10 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = dietEntity.getAutoIncrementColumn();
        int i11 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        long j = 0;
        collect313311(this.cursor, 0, 0, i8, mealRemark, i9, i9 != 0 ? this.expandListConverter.convertToDatabaseValue((List<? super BaseEventDetail>) expandList) : null, 0, (String) null, 0, (byte[]) null, i10, i10 != 0 ? recordIndex.longValue() : 0, i11, i11 != 0 ? autoIncrementColumn.longValue() : 0, __ID_timestamp, dietEntity.getTimestamp(), __ID_state, dietEntity.getState(), __ID_deleteStatus, dietEntity.getDeleteStatus(), __ID_uploadState, dietEntity.getUploadState(), 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        Long idx = dietEntity.getIdx();
        Date appCreateTime = dietEntity.getAppCreateTime();
        int i12 = appCreateTime != null ? __ID_appCreateTime : 0;
        Date mealTime = dietEntity.getMealTime();
        int i13 = mealTime != null ? __ID_mealTime : 0;
        Integer carbohydrate = dietEntity.getCarbohydrate();
        int i14 = carbohydrate != null ? __ID_carbohydrate : 0;
        long j2 = this.cursor;
        long longValue = idx != null ? idx.longValue() : 0;
        long time = i12 != 0 ? appCreateTime.getTime() : 0;
        if (i13 != 0) {
            j = mealTime.getTime();
        }
        long j3 = j;
        int i15 = __ID_moment;
        long moment = (long) dietEntity.getMoment();
        if (i14 != 0) {
            i = carbohydrate.intValue();
        }
        long collect313311 = collect313311(j2, longValue, 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i12, time, i13, j3, i15, moment, i14, i, __ID_isPreset, dietEntity.isPreset() ? 1 : 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        dietEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

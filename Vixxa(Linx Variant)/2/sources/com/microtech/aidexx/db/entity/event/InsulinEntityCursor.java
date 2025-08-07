package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.InsulinEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;
import java.util.List;

public final class InsulinEntityCursor extends Cursor<InsulinEntity> {
    private static final InsulinEntity_.InsulinEntityIdGetter ID_GETTER = InsulinEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = InsulinEntity_.appCreateTime.id;
    private static final int __ID_appTime = InsulinEntity_.appTime.id;
    private static final int __ID_appTimeZone = InsulinEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = InsulinEntity_.autoIncrementColumn.id;
    private static final int __ID_deleteStatus = InsulinEntity_.deleteStatus.id;
    private static final int __ID_dstOffset = InsulinEntity_.dstOffset.id;
    private static final int __ID_expandList = InsulinEntity_.expandList.id;
    private static final int __ID_id = InsulinEntity_.id.id;
    private static final int __ID_injectionTime = InsulinEntity_.injectionTime.id;
    private static final int __ID_insulinDosage = InsulinEntity_.insulinDosage.id;
    private static final int __ID_insulinId = InsulinEntity_.insulinId.id;
    private static final int __ID_insulinName = InsulinEntity_.insulinName.id;
    private static final int __ID_isPreset = InsulinEntity_.isPreset.id;
    private static final int __ID_language = InsulinEntity_.language.id;
    private static final int __ID_moment = InsulinEntity_.moment.id;
    private static final int __ID_recordId = InsulinEntity_.recordId.id;
    private static final int __ID_recordIndex = InsulinEntity_.recordIndex.id;
    private static final int __ID_state = InsulinEntity_.state.id;
    private static final int __ID_timestamp = InsulinEntity_.timestamp.id;
    private static final int __ID_uploadState = InsulinEntity_.uploadState.id;
    private static final int __ID_userId = InsulinEntity_.userId.id;
    private final InsulinDetail expandListConverter = new InsulinDetail();

    static final class Factory implements CursorFactory<InsulinEntity> {
        Factory() {
        }

        public Cursor<InsulinEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new InsulinEntityCursor(transaction, j, boxStore);
        }
    }

    public InsulinEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, InsulinEntity_.__INSTANCE, boxStore);
    }

    public long getId(InsulinEntity insulinEntity) {
        return ID_GETTER.getId(insulinEntity);
    }

    public long put(InsulinEntity insulinEntity) {
        float f;
        String id = insulinEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = insulinEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = insulinEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = insulinEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = insulinEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = insulinEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = insulinEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String insulinName = insulinEntity.getInsulinName();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, insulinName != null ? __ID_insulinName : 0, insulinName);
        String insulinId = insulinEntity.getInsulinId();
        int i8 = insulinId != null ? __ID_insulinId : 0;
        List<InsulinDetail> expandList = insulinEntity.getExpandList();
        int i9 = expandList != null ? __ID_expandList : 0;
        Long recordIndex = insulinEntity.getRecordIndex();
        int i10 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = insulinEntity.getAutoIncrementColumn();
        int i11 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        Float insulinDosage = insulinEntity.getInsulinDosage();
        int i12 = insulinDosage != null ? __ID_insulinDosage : 0;
        long j = this.cursor;
        String convertToDatabaseValue = i9 != 0 ? this.expandListConverter.convertToDatabaseValue((List<? super BaseEventDetail>) expandList) : null;
        long j2 = 0;
        long longValue = i10 != 0 ? recordIndex.longValue() : 0;
        long longValue2 = i11 != 0 ? autoIncrementColumn.longValue() : 0;
        int i13 = __ID_timestamp;
        long timestamp = insulinEntity.getTimestamp();
        int i14 = __ID_state;
        int state = insulinEntity.getState();
        int i15 = __ID_deleteStatus;
        int deleteStatus = insulinEntity.getDeleteStatus();
        int i16 = __ID_uploadState;
        int uploadState = insulinEntity.getUploadState();
        if (i12 != 0) {
            f = insulinDosage.floatValue();
        } else {
            f = 0.0f;
        }
        collect313311(j, 0, 0, i8, insulinId, i9, convertToDatabaseValue, 0, (String) null, 0, (byte[]) null, i10, longValue, i11, longValue2, i13, timestamp, i14, state, i15, deleteStatus, i16, uploadState, i12, f, 0, Utils.DOUBLE_EPSILON);
        Long idx = insulinEntity.getIdx();
        Date appCreateTime = insulinEntity.getAppCreateTime();
        int i17 = appCreateTime != null ? __ID_appCreateTime : 0;
        Date injectionTime = insulinEntity.getInjectionTime();
        if (injectionTime != null) {
            i = __ID_injectionTime;
        }
        int i18 = i;
        long j3 = this.cursor;
        long longValue3 = idx != null ? idx.longValue() : 0;
        long time = i17 != 0 ? appCreateTime.getTime() : 0;
        long time2 = i18 != 0 ? injectionTime.getTime() : 0;
        int i19 = __ID_moment;
        long moment = (long) insulinEntity.getMoment();
        int i20 = __ID_isPreset;
        if (insulinEntity.isPreset()) {
            j2 = 1;
        }
        long collect004000 = collect004000(j3, longValue3, 2, i17, time, i18, time2, i19, moment, i20, j2);
        insulinEntity.setIdx(Long.valueOf(collect004000));
        return collect004000;
    }
}

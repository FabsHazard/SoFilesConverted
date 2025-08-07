package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class TimezoneHistoryEntityCursor extends Cursor<TimezoneHistoryEntity> {
    private static final TimezoneHistoryEntity_.TimezoneHistoryEntityIdGetter ID_GETTER = TimezoneHistoryEntity_.__ID_GETTER;
    private static final int __ID_dstOffset = TimezoneHistoryEntity_.dstOffset.id;
    private static final int __ID_from = TimezoneHistoryEntity_.from.id;
    private static final int __ID_frontRecordId = TimezoneHistoryEntity_.frontRecordId.id;
    private static final int __ID_isDstChange = TimezoneHistoryEntity_.isDstChange.id;
    private static final int __ID_sensorId = TimezoneHistoryEntity_.sensorId.id;
    private static final int __ID_timestamp = TimezoneHistoryEntity_.timestamp.id;
    private static final int __ID_to = TimezoneHistoryEntity_.to.id;
    private static final int __ID_uploadState = TimezoneHistoryEntity_.uploadState.id;
    private static final int __ID_userId = TimezoneHistoryEntity_.userId.id;

    static final class Factory implements CursorFactory<TimezoneHistoryEntity> {
        Factory() {
        }

        public Cursor<TimezoneHistoryEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new TimezoneHistoryEntityCursor(transaction, j, boxStore);
        }
    }

    public TimezoneHistoryEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, TimezoneHistoryEntity_.__INSTANCE, boxStore);
    }

    public long getId(TimezoneHistoryEntity timezoneHistoryEntity) {
        return ID_GETTER.getId(timezoneHistoryEntity);
    }

    public long put(TimezoneHistoryEntity timezoneHistoryEntity) {
        String from = timezoneHistoryEntity.getFrom();
        int i = 0;
        int i2 = from != null ? __ID_from : 0;
        String to = timezoneHistoryEntity.getTo();
        int i3 = to != null ? __ID_to : 0;
        String userId = timezoneHistoryEntity.getUserId();
        int i4 = userId != null ? __ID_userId : 0;
        String sensorId = timezoneHistoryEntity.getSensorId();
        collect400000(this.cursor, 0, 1, i2, from, i3, to, i4, userId, sensorId != null ? __ID_sensorId : 0, sensorId);
        Long idx = timezoneHistoryEntity.getIdx();
        String frontRecordId = timezoneHistoryEntity.getFrontRecordId();
        if (frontRecordId != null) {
            i = __ID_frontRecordId;
        }
        long collect313311 = collect313311(this.cursor, idx != null ? idx.longValue() : 0, 2, i, frontRecordId, 0, (String) null, 0, (String) null, 0, (byte[]) null, __ID_timestamp, timezoneHistoryEntity.getTimestamp(), __ID_dstOffset, (long) timezoneHistoryEntity.getDstOffset(), __ID_uploadState, (long) timezoneHistoryEntity.getUploadState(), __ID_isDstChange, timezoneHistoryEntity.isDstChange() ? 1 : 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        timezoneHistoryEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

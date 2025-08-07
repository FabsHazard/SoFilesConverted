package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.event.OthersEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

public final class OthersEntityCursor extends Cursor<OthersEntity> {
    private static final OthersEntity_.OthersEntityIdGetter ID_GETTER = OthersEntity_.__ID_GETTER;
    private static final int __ID_appCreateTime = OthersEntity_.appCreateTime.id;
    private static final int __ID_appTime = OthersEntity_.appTime.id;
    private static final int __ID_appTimeZone = OthersEntity_.appTimeZone.id;
    private static final int __ID_autoIncrementColumn = OthersEntity_.autoIncrementColumn.id;
    private static final int __ID_content = OthersEntity_.content.id;
    private static final int __ID_deleteFlag = OthersEntity_.deleteFlag.id;
    private static final int __ID_deleteStatus = OthersEntity_.deleteStatus.id;
    private static final int __ID_dstOffset = OthersEntity_.dstOffset.id;
    private static final int __ID_id = OthersEntity_.id.id;
    private static final int __ID_language = OthersEntity_.language.id;
    private static final int __ID_moment = OthersEntity_.moment.id;
    private static final int __ID_otherId = OthersEntity_.otherId.id;
    private static final int __ID_recordId = OthersEntity_.recordId.id;
    private static final int __ID_recordIndex = OthersEntity_.recordIndex.id;
    private static final int __ID_state = OthersEntity_.state.id;
    private static final int __ID_timestamp = OthersEntity_.timestamp.id;
    private static final int __ID_uploadState = OthersEntity_.uploadState.id;
    private static final int __ID_userId = OthersEntity_.userId.id;

    static final class Factory implements CursorFactory<OthersEntity> {
        Factory() {
        }

        public Cursor<OthersEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new OthersEntityCursor(transaction, j, boxStore);
        }
    }

    public OthersEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, OthersEntity_.__INSTANCE, boxStore);
    }

    public long getId(OthersEntity othersEntity) {
        return ID_GETTER.getId(othersEntity);
    }

    public long put(OthersEntity othersEntity) {
        String id = othersEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String userId = othersEntity.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String recordId = othersEntity.getRecordId();
        int i4 = recordId != null ? __ID_recordId : 0;
        String language = othersEntity.getLanguage();
        collect400000(this.cursor, 0, 1, i2, id, i3, userId, i4, recordId, language != null ? __ID_language : 0, language);
        String appTime = othersEntity.getAppTime();
        int i5 = appTime != null ? __ID_appTime : 0;
        String appTimeZone = othersEntity.getAppTimeZone();
        int i6 = appTimeZone != null ? __ID_appTimeZone : 0;
        String dstOffset = othersEntity.getDstOffset();
        int i7 = dstOffset != null ? __ID_dstOffset : 0;
        String otherId = othersEntity.getOtherId();
        collect400000(this.cursor, 0, 0, i5, appTime, i6, appTimeZone, i7, dstOffset, otherId != null ? __ID_otherId : 0, otherId);
        String content = othersEntity.getContent();
        int i8 = content != null ? __ID_content : 0;
        Long recordIndex = othersEntity.getRecordIndex();
        int i9 = recordIndex != null ? __ID_recordIndex : 0;
        Long autoIncrementColumn = othersEntity.getAutoIncrementColumn();
        int i10 = autoIncrementColumn != null ? __ID_autoIncrementColumn : 0;
        long j = 0;
        collect313311(this.cursor, 0, 0, i8, content, 0, (String) null, 0, (String) null, 0, (byte[]) null, i9, i9 != 0 ? recordIndex.longValue() : 0, i10, i10 != 0 ? autoIncrementColumn.longValue() : 0, __ID_timestamp, othersEntity.getTimestamp(), __ID_state, othersEntity.getState(), __ID_deleteStatus, othersEntity.getDeleteStatus(), __ID_uploadState, othersEntity.getUploadState(), 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        Long idx = othersEntity.getIdx();
        Date appCreateTime = othersEntity.getAppCreateTime();
        int i11 = appCreateTime != null ? __ID_appCreateTime : 0;
        Integer deleteFlag = othersEntity.getDeleteFlag();
        if (deleteFlag != null) {
            i = __ID_deleteFlag;
        }
        int i12 = i;
        long j2 = this.cursor;
        long longValue = idx != null ? idx.longValue() : 0;
        long time = i11 != 0 ? appCreateTime.getTime() : 0;
        int i13 = __ID_moment;
        long moment = (long) othersEntity.getMoment();
        if (i12 != 0) {
            j = (long) deleteFlag.intValue();
        }
        long collect004000 = collect004000(j2, longValue, 2, i11, time, i13, moment, i12, j, 0, 0);
        othersEntity.setIdx(Long.valueOf(collect004000));
        return collect004000;
    }
}

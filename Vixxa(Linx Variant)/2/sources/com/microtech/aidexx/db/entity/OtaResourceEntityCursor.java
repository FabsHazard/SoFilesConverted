package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.OtaResourceEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class OtaResourceEntityCursor extends Cursor<OtaResourceEntity> {
    private static final OtaResourceEntity_.OtaResourceEntityIdGetter ID_GETTER = OtaResourceEntity_.__ID_GETTER;
    private static final int __ID_aidexVersion = OtaResourceEntity_.aidexVersion.id;
    private static final int __ID_fileType = OtaResourceEntity_.fileType.id;
    private static final int __ID_localFilePath = OtaResourceEntity_.localFilePath.id;
    private static final int __ID_md5 = OtaResourceEntity_.md5.id;
    private static final int __ID_ossFileUrl = OtaResourceEntity_.ossFileUrl.id;
    private static final int __ID_settingContent = OtaResourceEntity_.settingContent.id;
    private static final int __ID_settingType = OtaResourceEntity_.settingType.id;
    private static final int __ID_settingTypeVersionKey = OtaResourceEntity_.settingTypeVersionKey.id;
    private static final int __ID_settingVersion = OtaResourceEntity_.settingVersion.id;
    private static final int __ID_sha256 = OtaResourceEntity_.sha256.id;
    private static final int __ID_version = OtaResourceEntity_.version.id;

    static final class Factory implements CursorFactory<OtaResourceEntity> {
        Factory() {
        }

        public Cursor<OtaResourceEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new OtaResourceEntityCursor(transaction, j, boxStore);
        }
    }

    public OtaResourceEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, OtaResourceEntity_.__INSTANCE, boxStore);
    }

    public long getId(OtaResourceEntity otaResourceEntity) {
        return ID_GETTER.getId(otaResourceEntity);
    }

    public long put(OtaResourceEntity otaResourceEntity) {
        String settingTypeVersionKey = otaResourceEntity.getSettingTypeVersionKey();
        int i = 0;
        int i2 = settingTypeVersionKey != null ? __ID_settingTypeVersionKey : 0;
        String settingVersion = otaResourceEntity.getSettingVersion();
        int i3 = settingVersion != null ? __ID_settingVersion : 0;
        String localFilePath = otaResourceEntity.getLocalFilePath();
        int i4 = localFilePath != null ? __ID_localFilePath : 0;
        String settingContent = otaResourceEntity.getSettingContent();
        collect400000(this.cursor, 0, 1, i2, settingTypeVersionKey, i3, settingVersion, i4, localFilePath, settingContent != null ? __ID_settingContent : 0, settingContent);
        String sha256 = otaResourceEntity.getSha256();
        int i5 = sha256 != null ? __ID_sha256 : 0;
        String ossFileUrl = otaResourceEntity.getOssFileUrl();
        int i6 = ossFileUrl != null ? __ID_ossFileUrl : 0;
        String settingType = otaResourceEntity.getSettingType();
        int i7 = settingType != null ? __ID_settingType : 0;
        String version = otaResourceEntity.getVersion();
        collect400000(this.cursor, 0, 0, i5, sha256, i6, ossFileUrl, i7, settingType, version != null ? __ID_version : 0, version);
        Long idx = otaResourceEntity.getIdx();
        String md5 = otaResourceEntity.getMd5();
        int i8 = md5 != null ? __ID_md5 : 0;
        String aidexVersion = otaResourceEntity.getAidexVersion();
        int i9 = aidexVersion != null ? __ID_aidexVersion : 0;
        Integer fileType = otaResourceEntity.getFileType();
        if (fileType != null) {
            i = __ID_fileType;
        }
        int i10 = i;
        long collect313311 = collect313311(this.cursor, idx != null ? idx.longValue() : 0, 2, i8, md5, i9, aidexVersion, 0, (String) null, 0, (byte[]) null, i10, i10 != 0 ? (long) fileType.intValue() : 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        otaResourceEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

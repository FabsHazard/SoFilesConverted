package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.TransmitterEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

public final class TransmitterEntityCursor extends Cursor<TransmitterEntity> {
    private static final TransmitterEntity_.TransmitterEntityIdGetter ID_GETTER = TransmitterEntity_.__ID_GETTER;
    private static final int __ID_accessId = TransmitterEntity_.accessId.id;
    private static final int __ID_calIndex = TransmitterEntity_.calIndex.id;
    private static final int __ID_deviceKey = TransmitterEntity_.deviceKey.id;
    private static final int __ID_deviceMac = TransmitterEntity_.deviceMac.id;
    private static final int __ID_deviceModel = TransmitterEntity_.deviceModel.id;
    private static final int __ID_deviceName = TransmitterEntity_.deviceName.id;
    private static final int __ID_deviceSn = TransmitterEntity_.deviceSn.id;
    private static final int __ID_deviceType = TransmitterEntity_.deviceType.id;
    private static final int __ID_encryptionKey = TransmitterEntity_.encryptionKey.id;
    private static final int __ID_et = TransmitterEntity_.et.id;
    private static final int __ID_eventIndex = TransmitterEntity_.eventIndex.id;
    private static final int __ID_expirationTime = TransmitterEntity_.expirationTime.id;
    private static final int __ID_fullEventIndex = TransmitterEntity_.fullEventIndex.id;
    private static final int __ID_fullSensorIndex = TransmitterEntity_.fullSensorIndex.id;
    private static final int __ID_hyperThreshold = TransmitterEntity_.hyperThreshold.id;
    private static final int __ID_hypoThreshold = TransmitterEntity_.hypoThreshold.id;
    private static final int __ID_id = TransmitterEntity_.id.id;
    private static final int __ID_modelName = TransmitterEntity_.modelName.id;
    private static final int __ID_needReplace = TransmitterEntity_.needReplace.id;
    private static final int __ID_sensorId = TransmitterEntity_.sensorId.id;
    private static final int __ID_sensorIndex = TransmitterEntity_.sensorIndex.id;
    private static final int __ID_sensorStartTime = TransmitterEntity_.sensorStartTime.id;
    private static final int __ID_version = TransmitterEntity_.version.id;

    static final class Factory implements CursorFactory<TransmitterEntity> {
        Factory() {
        }

        public Cursor<TransmitterEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new TransmitterEntityCursor(transaction, j, boxStore);
        }
    }

    public TransmitterEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, TransmitterEntity_.__INSTANCE, boxStore);
    }

    public long getId(TransmitterEntity transmitterEntity) {
        return ID_GETTER.getId(transmitterEntity);
    }

    public long put(TransmitterEntity transmitterEntity) {
        String id = transmitterEntity.getId();
        int i = 0;
        int i2 = id != null ? __ID_id : 0;
        String deviceMac = transmitterEntity.getDeviceMac();
        int i3 = deviceMac != null ? __ID_deviceMac : 0;
        String version = transmitterEntity.getVersion();
        int i4 = version != null ? __ID_version : 0;
        String deviceSn = transmitterEntity.getDeviceSn();
        int i5 = deviceSn != null ? __ID_deviceSn : 0;
        byte[] accessId = transmitterEntity.getAccessId();
        int i6 = accessId != null ? __ID_accessId : 0;
        byte[] encryptionKey = transmitterEntity.getEncryptionKey();
        collect430000(this.cursor, 0, 1, i2, id, i3, deviceMac, i4, version, i5, deviceSn, i6, accessId, encryptionKey != null ? __ID_encryptionKey : 0, encryptionKey, 0, (byte[]) null);
        String modelName = transmitterEntity.getModelName();
        int i7 = modelName != null ? __ID_modelName : 0;
        String deviceKey = transmitterEntity.getDeviceKey();
        int i8 = deviceKey != null ? __ID_deviceKey : 0;
        String deviceName = transmitterEntity.getDeviceName();
        int i9 = deviceName != null ? __ID_deviceName : 0;
        String sensorId = transmitterEntity.getSensorId();
        collect400000(this.cursor, 0, 0, i7, modelName, i8, deviceKey, i9, deviceName, sensorId != null ? __ID_sensorId : 0, sensorId);
        Date sensorStartTime = transmitterEntity.getSensorStartTime();
        if (sensorStartTime != null) {
            i = __ID_sensorStartTime;
        }
        int i10 = i;
        long j = 0;
        collect313311(this.cursor, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i10, i10 != 0 ? sensorStartTime.getTime() : 0, __ID_calIndex, (long) transmitterEntity.getCalIndex(), __ID_deviceModel, (long) transmitterEntity.getDeviceModel(), __ID_expirationTime, transmitterEntity.getExpirationTime(), __ID_sensorIndex, transmitterEntity.getSensorIndex(), __ID_eventIndex, transmitterEntity.getEventIndex(), __ID_hyperThreshold, transmitterEntity.getHyperThreshold(), 0, Utils.DOUBLE_EPSILON);
        Long idx = transmitterEntity.getIdx();
        long j2 = this.cursor;
        if (idx != null) {
            j = idx.longValue();
        }
        long collect313311 = collect313311(j2, j, 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, __ID_fullEventIndex, (long) transmitterEntity.getFullEventIndex(), __ID_fullSensorIndex, (long) transmitterEntity.getFullSensorIndex(), __ID_et, (long) transmitterEntity.getEt(), __ID_deviceType, transmitterEntity.getDeviceType(), __ID_needReplace, transmitterEntity.getNeedReplace() ? 1 : 0, 0, 0, __ID_hypoThreshold, transmitterEntity.getHypoThreshold(), 0, Utils.DOUBLE_EPSILON);
        transmitterEntity.setIdx(Long.valueOf(collect313311));
        return collect313311;
    }
}

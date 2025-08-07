package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;
import java.util.Date;

public final class HistoryDeviceInfoCursor extends Cursor<HistoryDeviceInfo> {
    private static final HistoryDeviceInfo_.HistoryDeviceInfoIdGetter ID_GETTER = HistoryDeviceInfo_.__ID_GETTER;
    private static final int __ID_deviceId = HistoryDeviceInfo_.deviceId.id;
    private static final int __ID_deviceKey = HistoryDeviceInfo_.deviceKey.id;
    private static final int __ID_deviceMac = HistoryDeviceInfo_.deviceMac.id;
    private static final int __ID_deviceModel = HistoryDeviceInfo_.deviceModel.id;
    private static final int __ID_deviceSn = HistoryDeviceInfo_.deviceSn.id;
    private static final int __ID_et = HistoryDeviceInfo_.et.id;
    private static final int __ID_name = HistoryDeviceInfo_.name.id;
    private static final int __ID_registerTime = HistoryDeviceInfo_.registerTime.id;
    private static final int __ID_sensorId = HistoryDeviceInfo_.sensorId.id;
    private static final int __ID_sensorIndex = HistoryDeviceInfo_.sensorIndex.id;
    private static final int __ID_sensorStartUp = HistoryDeviceInfo_.sensorStartUp.id;
    private static final int __ID_startUpTimeZone = HistoryDeviceInfo_.startUpTimeZone.id;
    private static final int __ID_unregisterTime = HistoryDeviceInfo_.unregisterTime.id;
    private static final int __ID_userId = HistoryDeviceInfo_.userId.id;

    static final class Factory implements CursorFactory<HistoryDeviceInfo> {
        Factory() {
        }

        public Cursor<HistoryDeviceInfo> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new HistoryDeviceInfoCursor(transaction, j, boxStore);
        }
    }

    public HistoryDeviceInfoCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, HistoryDeviceInfo_.__INSTANCE, boxStore);
    }

    public long getId(HistoryDeviceInfo historyDeviceInfo) {
        return ID_GETTER.getId(historyDeviceInfo);
    }

    public long put(HistoryDeviceInfo historyDeviceInfo) {
        String deviceId = historyDeviceInfo.getDeviceId();
        int i = 0;
        int i2 = deviceId != null ? __ID_deviceId : 0;
        String userId = historyDeviceInfo.getUserId();
        int i3 = userId != null ? __ID_userId : 0;
        String sensorId = historyDeviceInfo.getSensorId();
        int i4 = sensorId != null ? __ID_sensorId : 0;
        String startUpTimeZone = historyDeviceInfo.getStartUpTimeZone();
        collect400000(this.cursor, 0, 1, i2, deviceId, i3, userId, i4, sensorId, startUpTimeZone != null ? __ID_startUpTimeZone : 0, startUpTimeZone);
        String deviceSn = historyDeviceInfo.getDeviceSn();
        int i5 = deviceSn != null ? __ID_deviceSn : 0;
        String deviceMac = historyDeviceInfo.getDeviceMac();
        int i6 = deviceMac != null ? __ID_deviceMac : 0;
        String deviceKey = historyDeviceInfo.getDeviceKey();
        int i7 = deviceKey != null ? __ID_deviceKey : 0;
        String name = historyDeviceInfo.getName();
        collect400000(this.cursor, 0, 0, i5, deviceSn, i6, deviceMac, i7, deviceKey, name != null ? __ID_name : 0, name);
        Date sensorStartUp = historyDeviceInfo.getSensorStartUp();
        int i8 = sensorStartUp != null ? __ID_sensorStartUp : 0;
        Date registerTime = historyDeviceInfo.getRegisterTime();
        int i9 = registerTime != null ? __ID_registerTime : 0;
        Date unregisterTime = historyDeviceInfo.getUnregisterTime();
        if (unregisterTime != null) {
            i = __ID_unregisterTime;
        }
        int i10 = i;
        long collect313311 = collect313311(this.cursor, historyDeviceInfo.getIdx(), 2, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i8, i8 != 0 ? sensorStartUp.getTime() : 0, i9, i9 != 0 ? registerTime.getTime() : 0, i10, i10 != 0 ? unregisterTime.getTime() : 0, __ID_sensorIndex, historyDeviceInfo.getSensorIndex(), __ID_deviceModel, historyDeviceInfo.getDeviceModel(), __ID_et, historyDeviceInfo.getEt(), 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        historyDeviceInfo.setIdx(collect313311);
        return collect313311;
    }
}

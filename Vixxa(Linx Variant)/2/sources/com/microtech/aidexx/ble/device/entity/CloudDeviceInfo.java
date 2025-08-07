package com.microtech.aidexx.ble.device.entity;

import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/microtech/aidexx/ble/device/entity/CloudDeviceInfo;", "", "deviceInfo", "Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "record", "Lcom/microtech/aidexx/ble/device/entity/RecordInfo;", "originRecord", "Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;", "calibrationRecord", "Lcom/microtech/aidexx/ble/device/entity/CalibrationRecord;", "(Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;Lcom/microtech/aidexx/ble/device/entity/RecordInfo;Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;Lcom/microtech/aidexx/ble/device/entity/CalibrationRecord;)V", "getCalibrationRecord", "()Lcom/microtech/aidexx/ble/device/entity/CalibrationRecord;", "getDeviceInfo", "()Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "getOriginRecord", "()Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;", "getRecord", "()Lcom/microtech/aidexx/ble/device/entity/RecordInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceRequestInfo.kt */
public final class CloudDeviceInfo {
    private final CalibrationRecord calibrationRecord;
    private final HistoryDeviceInfo deviceInfo;
    private final RawRecordInfo originRecord;
    private final RecordInfo record;

    public static /* synthetic */ CloudDeviceInfo copy$default(CloudDeviceInfo cloudDeviceInfo, HistoryDeviceInfo historyDeviceInfo, RecordInfo recordInfo, RawRecordInfo rawRecordInfo, CalibrationRecord calibrationRecord2, int i, Object obj) {
        if ((i & 1) != 0) {
            historyDeviceInfo = cloudDeviceInfo.deviceInfo;
        }
        if ((i & 2) != 0) {
            recordInfo = cloudDeviceInfo.record;
        }
        if ((i & 4) != 0) {
            rawRecordInfo = cloudDeviceInfo.originRecord;
        }
        if ((i & 8) != 0) {
            calibrationRecord2 = cloudDeviceInfo.calibrationRecord;
        }
        return cloudDeviceInfo.copy(historyDeviceInfo, recordInfo, rawRecordInfo, calibrationRecord2);
    }

    public final HistoryDeviceInfo component1() {
        return this.deviceInfo;
    }

    public final RecordInfo component2() {
        return this.record;
    }

    public final RawRecordInfo component3() {
        return this.originRecord;
    }

    public final CalibrationRecord component4() {
        return this.calibrationRecord;
    }

    public final CloudDeviceInfo copy(HistoryDeviceInfo historyDeviceInfo, RecordInfo recordInfo, RawRecordInfo rawRecordInfo, CalibrationRecord calibrationRecord2) {
        return new CloudDeviceInfo(historyDeviceInfo, recordInfo, rawRecordInfo, calibrationRecord2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudDeviceInfo)) {
            return false;
        }
        CloudDeviceInfo cloudDeviceInfo = (CloudDeviceInfo) obj;
        return Intrinsics.areEqual((Object) this.deviceInfo, (Object) cloudDeviceInfo.deviceInfo) && Intrinsics.areEqual((Object) this.record, (Object) cloudDeviceInfo.record) && Intrinsics.areEqual((Object) this.originRecord, (Object) cloudDeviceInfo.originRecord) && Intrinsics.areEqual((Object) this.calibrationRecord, (Object) cloudDeviceInfo.calibrationRecord);
    }

    public int hashCode() {
        HistoryDeviceInfo historyDeviceInfo = this.deviceInfo;
        int i = 0;
        int hashCode = (historyDeviceInfo == null ? 0 : historyDeviceInfo.hashCode()) * 31;
        RecordInfo recordInfo = this.record;
        int hashCode2 = (hashCode + (recordInfo == null ? 0 : recordInfo.hashCode())) * 31;
        RawRecordInfo rawRecordInfo = this.originRecord;
        int hashCode3 = (hashCode2 + (rawRecordInfo == null ? 0 : rawRecordInfo.hashCode())) * 31;
        CalibrationRecord calibrationRecord2 = this.calibrationRecord;
        if (calibrationRecord2 != null) {
            i = calibrationRecord2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CloudDeviceInfo(deviceInfo=" + this.deviceInfo + ", record=" + this.record + ", originRecord=" + this.originRecord + ", calibrationRecord=" + this.calibrationRecord + ')';
    }

    public CloudDeviceInfo(HistoryDeviceInfo historyDeviceInfo, RecordInfo recordInfo, RawRecordInfo rawRecordInfo, CalibrationRecord calibrationRecord2) {
        this.deviceInfo = historyDeviceInfo;
        this.record = recordInfo;
        this.originRecord = rawRecordInfo;
        this.calibrationRecord = calibrationRecord2;
    }

    public final HistoryDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final RecordInfo getRecord() {
        return this.record;
    }

    public final RawRecordInfo getOriginRecord() {
        return this.originRecord;
    }

    public final CalibrationRecord getCalibrationRecord() {
        return this.calibrationRecord;
    }
}

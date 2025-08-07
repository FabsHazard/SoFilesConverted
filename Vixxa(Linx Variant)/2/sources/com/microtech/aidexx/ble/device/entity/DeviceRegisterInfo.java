package com.microtech.aidexx.ble.device.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ble/device/entity/DeviceRegisterInfo;", "", "record", "Lcom/microtech/aidexx/ble/device/entity/RecordInfo;", "originRecord", "Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;", "calibrationRecord", "Lcom/microtech/aidexx/ble/device/entity/CalibrationRecord;", "deviceId", "", "(Lcom/microtech/aidexx/ble/device/entity/RecordInfo;Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;Lcom/microtech/aidexx/ble/device/entity/CalibrationRecord;Ljava/lang/String;)V", "getCalibrationRecord", "()Lcom/microtech/aidexx/ble/device/entity/CalibrationRecord;", "getDeviceId", "()Ljava/lang/String;", "getOriginRecord", "()Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;", "getRecord", "()Lcom/microtech/aidexx/ble/device/entity/RecordInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceRequestInfo.kt */
public final class DeviceRegisterInfo {
    private final CalibrationRecord calibrationRecord;
    private final String deviceId;
    private final RawRecordInfo originRecord;
    private final RecordInfo record;

    public static /* synthetic */ DeviceRegisterInfo copy$default(DeviceRegisterInfo deviceRegisterInfo, RecordInfo recordInfo, RawRecordInfo rawRecordInfo, CalibrationRecord calibrationRecord2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            recordInfo = deviceRegisterInfo.record;
        }
        if ((i & 2) != 0) {
            rawRecordInfo = deviceRegisterInfo.originRecord;
        }
        if ((i & 4) != 0) {
            calibrationRecord2 = deviceRegisterInfo.calibrationRecord;
        }
        if ((i & 8) != 0) {
            str = deviceRegisterInfo.deviceId;
        }
        return deviceRegisterInfo.copy(recordInfo, rawRecordInfo, calibrationRecord2, str);
    }

    public final RecordInfo component1() {
        return this.record;
    }

    public final RawRecordInfo component2() {
        return this.originRecord;
    }

    public final CalibrationRecord component3() {
        return this.calibrationRecord;
    }

    public final String component4() {
        return this.deviceId;
    }

    public final DeviceRegisterInfo copy(RecordInfo recordInfo, RawRecordInfo rawRecordInfo, CalibrationRecord calibrationRecord2, String str) {
        return new DeviceRegisterInfo(recordInfo, rawRecordInfo, calibrationRecord2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceRegisterInfo)) {
            return false;
        }
        DeviceRegisterInfo deviceRegisterInfo = (DeviceRegisterInfo) obj;
        return Intrinsics.areEqual((Object) this.record, (Object) deviceRegisterInfo.record) && Intrinsics.areEqual((Object) this.originRecord, (Object) deviceRegisterInfo.originRecord) && Intrinsics.areEqual((Object) this.calibrationRecord, (Object) deviceRegisterInfo.calibrationRecord) && Intrinsics.areEqual((Object) this.deviceId, (Object) deviceRegisterInfo.deviceId);
    }

    public int hashCode() {
        RecordInfo recordInfo = this.record;
        int i = 0;
        int hashCode = (recordInfo == null ? 0 : recordInfo.hashCode()) * 31;
        RawRecordInfo rawRecordInfo = this.originRecord;
        int hashCode2 = (hashCode + (rawRecordInfo == null ? 0 : rawRecordInfo.hashCode())) * 31;
        CalibrationRecord calibrationRecord2 = this.calibrationRecord;
        int hashCode3 = (hashCode2 + (calibrationRecord2 == null ? 0 : calibrationRecord2.hashCode())) * 31;
        String str = this.deviceId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "DeviceRegisterInfo(record=" + this.record + ", originRecord=" + this.originRecord + ", calibrationRecord=" + this.calibrationRecord + ", deviceId=" + this.deviceId + ')';
    }

    public DeviceRegisterInfo(RecordInfo recordInfo, RawRecordInfo rawRecordInfo, CalibrationRecord calibrationRecord2, String str) {
        this.record = recordInfo;
        this.originRecord = rawRecordInfo;
        this.calibrationRecord = calibrationRecord2;
        this.deviceId = str;
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

    public final String getDeviceId() {
        return this.deviceId;
    }
}

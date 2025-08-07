package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\tHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001d\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011¨\u00060"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;", "", "deviceType", "", "calIndex", "glucose", "", "trend", "glucoseTime", "", "timeOffset", "calTemp", "status", "sensorId", "historyStatus", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getCalIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCalTemp", "getDeviceType", "getGlucose", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getGlucoseTime", "()Ljava/lang/String;", "getHistoryStatus", "getSensorId", "getStatus", "getTimeOffset", "getTrend", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class DeviceHeartBeat {
    private final Integer calIndex;
    private final Integer calTemp;
    private final Integer deviceType;
    private final Float glucose;
    private final String glucoseTime;
    private final Integer historyStatus;
    private final String sensorId;
    private final Integer status;
    private final Integer timeOffset;
    private final Integer trend;

    public static /* synthetic */ DeviceHeartBeat copy$default(DeviceHeartBeat deviceHeartBeat, Integer num, Integer num2, Float f, Integer num3, String str, Integer num4, Integer num5, Integer num6, String str2, Integer num7, int i, Object obj) {
        DeviceHeartBeat deviceHeartBeat2 = deviceHeartBeat;
        int i2 = i;
        return deviceHeartBeat.copy((i2 & 1) != 0 ? deviceHeartBeat2.deviceType : num, (i2 & 2) != 0 ? deviceHeartBeat2.calIndex : num2, (i2 & 4) != 0 ? deviceHeartBeat2.glucose : f, (i2 & 8) != 0 ? deviceHeartBeat2.trend : num3, (i2 & 16) != 0 ? deviceHeartBeat2.glucoseTime : str, (i2 & 32) != 0 ? deviceHeartBeat2.timeOffset : num4, (i2 & 64) != 0 ? deviceHeartBeat2.calTemp : num5, (i2 & 128) != 0 ? deviceHeartBeat2.status : num6, (i2 & 256) != 0 ? deviceHeartBeat2.sensorId : str2, (i2 & 512) != 0 ? deviceHeartBeat2.historyStatus : num7);
    }

    public final Integer component1() {
        return this.deviceType;
    }

    public final Integer component10() {
        return this.historyStatus;
    }

    public final Integer component2() {
        return this.calIndex;
    }

    public final Float component3() {
        return this.glucose;
    }

    public final Integer component4() {
        return this.trend;
    }

    public final String component5() {
        return this.glucoseTime;
    }

    public final Integer component6() {
        return this.timeOffset;
    }

    public final Integer component7() {
        return this.calTemp;
    }

    public final Integer component8() {
        return this.status;
    }

    public final String component9() {
        return this.sensorId;
    }

    public final DeviceHeartBeat copy(Integer num, Integer num2, Float f, Integer num3, String str, Integer num4, Integer num5, Integer num6, String str2, Integer num7) {
        return new DeviceHeartBeat(num, num2, f, num3, str, num4, num5, num6, str2, num7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceHeartBeat)) {
            return false;
        }
        DeviceHeartBeat deviceHeartBeat = (DeviceHeartBeat) obj;
        return Intrinsics.areEqual((Object) this.deviceType, (Object) deviceHeartBeat.deviceType) && Intrinsics.areEqual((Object) this.calIndex, (Object) deviceHeartBeat.calIndex) && Intrinsics.areEqual((Object) this.glucose, (Object) deviceHeartBeat.glucose) && Intrinsics.areEqual((Object) this.trend, (Object) deviceHeartBeat.trend) && Intrinsics.areEqual((Object) this.glucoseTime, (Object) deviceHeartBeat.glucoseTime) && Intrinsics.areEqual((Object) this.timeOffset, (Object) deviceHeartBeat.timeOffset) && Intrinsics.areEqual((Object) this.calTemp, (Object) deviceHeartBeat.calTemp) && Intrinsics.areEqual((Object) this.status, (Object) deviceHeartBeat.status) && Intrinsics.areEqual((Object) this.sensorId, (Object) deviceHeartBeat.sensorId) && Intrinsics.areEqual((Object) this.historyStatus, (Object) deviceHeartBeat.historyStatus);
    }

    public int hashCode() {
        Integer num = this.deviceType;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.calIndex;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Float f = this.glucose;
        int hashCode3 = (hashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num3 = this.trend;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.glucoseTime;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num4 = this.timeOffset;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.calTemp;
        int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.status;
        int hashCode8 = (hashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str2 = this.sensorId;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num7 = this.historyStatus;
        if (num7 != null) {
            i = num7.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "DeviceHeartBeat(deviceType=" + this.deviceType + ", calIndex=" + this.calIndex + ", glucose=" + this.glucose + ", trend=" + this.trend + ", glucoseTime=" + this.glucoseTime + ", timeOffset=" + this.timeOffset + ", calTemp=" + this.calTemp + ", status=" + this.status + ", sensorId=" + this.sensorId + ", historyStatus=" + this.historyStatus + ')';
    }

    public DeviceHeartBeat(Integer num, Integer num2, Float f, Integer num3, String str, Integer num4, Integer num5, Integer num6, String str2, Integer num7) {
        this.deviceType = num;
        this.calIndex = num2;
        this.glucose = f;
        this.trend = num3;
        this.glucoseTime = str;
        this.timeOffset = num4;
        this.calTemp = num5;
        this.status = num6;
        this.sensorId = str2;
        this.historyStatus = num7;
    }

    public final Integer getDeviceType() {
        return this.deviceType;
    }

    public final Integer getCalIndex() {
        return this.calIndex;
    }

    public final Float getGlucose() {
        return this.glucose;
    }

    public final Integer getTrend() {
        return this.trend;
    }

    public final String getGlucoseTime() {
        return this.glucoseTime;
    }

    public final Integer getTimeOffset() {
        return this.timeOffset;
    }

    public final Integer getCalTemp() {
        return this.calTemp;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getSensorId() {
        return this.sensorId;
    }

    public final Integer getHistoryStatus() {
        return this.historyStatus;
    }
}

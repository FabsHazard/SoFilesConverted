package com.microtech.aidexx.ble.device.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/ble/device/entity/RawRecordInfo;", "", "timeOffset", "", "(I)V", "getTimeOffset", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceRequestInfo.kt */
public final class RawRecordInfo {
    private final int timeOffset;

    public RawRecordInfo() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RawRecordInfo copy$default(RawRecordInfo rawRecordInfo, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rawRecordInfo.timeOffset;
        }
        return rawRecordInfo.copy(i);
    }

    public final int component1() {
        return this.timeOffset;
    }

    public final RawRecordInfo copy(int i) {
        return new RawRecordInfo(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RawRecordInfo) && this.timeOffset == ((RawRecordInfo) obj).timeOffset;
    }

    public int hashCode() {
        return Integer.hashCode(this.timeOffset);
    }

    public String toString() {
        return "RawRecordInfo(timeOffset=" + this.timeOffset + ')';
    }

    public RawRecordInfo(int i) {
        this.timeOffset = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RawRecordInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getTimeOffset() {
        return this.timeOffset;
    }
}

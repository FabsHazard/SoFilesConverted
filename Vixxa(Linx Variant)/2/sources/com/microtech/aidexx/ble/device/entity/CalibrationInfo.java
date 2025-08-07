package com.microtech.aidexx.ble.device.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/ble/device/entity/CalibrationInfo;", "", "floatValue", "", "time", "", "(Ljava/lang/Float;J)V", "intValue", "", "timeOffset", "(II)V", "getFloatValue", "()Ljava/lang/Float;", "setFloatValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getIntValue", "()I", "setIntValue", "(I)V", "getTime", "()J", "setTime", "(J)V", "getTimeOffset", "setTimeOffset", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalibrationInfo.kt */
public final class CalibrationInfo {
    private Float floatValue;
    private int intValue;
    private long time;
    private int timeOffset;

    public final Float getFloatValue() {
        return this.floatValue;
    }

    public final void setFloatValue(Float f) {
        this.floatValue = f;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final void setIntValue(int i) {
        this.intValue = i;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    public final int getTimeOffset() {
        return this.timeOffset;
    }

    public final void setTimeOffset(int i) {
        this.timeOffset = i;
    }

    public CalibrationInfo(Float f, long j) {
        Float.valueOf(0.0f);
        this.floatValue = f;
        this.time = j;
    }

    public CalibrationInfo(int i, int i2) {
        this.floatValue = Float.valueOf(0.0f);
        this.intValue = i;
        this.timeOffset = i2;
    }
}

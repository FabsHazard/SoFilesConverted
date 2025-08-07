package com.microtech.aidexx.ble.device.entity;

import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtechmd.blecomm.parser.CgmBroadcastEntity;
import com.microtechmd.blecomm.parser.CgmHistoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/ble/device/entity/BroadcastEntity;", "Lcom/microtechmd/blecomm/parser/CgmBroadcastEntity;", "()V", "<set-?>", "", "battery", "getBattery", "()I", "Lcom/microtechmd/blecomm/parser/CgmHistoryEntity;", "cgmHistory", "getCgmHistory", "()Lcom/microtechmd/blecomm/parser/CgmHistoryEntity;", "", "datetime", "getDatetime", "()J", "", "glucose", "getGlucose", "()F", "primary", "getPrimary", "receivedTime", "getReceivedTime", "setReceivedTime", "(J)V", "state", "getState", "_setBattery", "", "_setDatetime", "_setGlucose", "_setHistory", "_setPrimary", "_setState", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BroadcastEntity.kt */
public final class BroadcastEntity implements CgmBroadcastEntity {
    private int battery;
    private CgmHistoryEntity cgmHistory;
    private long datetime;
    private float glucose;
    private int primary;
    private long receivedTime;
    private int state;

    public final long getReceivedTime() {
        return this.receivedTime;
    }

    public final void setReceivedTime(long j) {
        this.receivedTime = j;
    }

    public final long getDatetime() {
        return this.datetime;
    }

    public void _setDatetime(long j) {
        this.datetime = j;
    }

    public final int getBattery() {
        return this.battery;
    }

    public void _setBattery(int i) {
        this.battery = i;
    }

    public final float getGlucose() {
        return this.glucose;
    }

    public void _setGlucose(float f) {
        this.glucose = f;
    }

    public final int getPrimary() {
        return this.primary;
    }

    public void _setPrimary(int i) {
        this.primary = i;
    }

    public final int getState() {
        return this.state;
    }

    public void _setState(int i) {
        this.state = i;
    }

    public final CgmHistoryEntity getCgmHistory() {
        return this.cgmHistory;
    }

    public void _setHistory(CgmHistoryEntity cgmHistoryEntity) {
        Intrinsics.checkNotNullParameter(cgmHistoryEntity, "cgmHistory");
        this.cgmHistory = (RealCgmHistoryEntity) cgmHistoryEntity;
    }
}

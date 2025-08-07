package com.microtech.aidexx.db.entity;

import java.util.Date;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001c\u00100\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001c\u00106\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\b¨\u0006<"}, d2 = {"Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "", "()V", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "deviceKey", "getDeviceKey", "setDeviceKey", "deviceMac", "getDeviceMac", "setDeviceMac", "deviceModel", "", "getDeviceModel", "()I", "setDeviceModel", "(I)V", "deviceSn", "getDeviceSn", "setDeviceSn", "et", "getEt", "setEt", "idx", "", "getIdx", "()J", "setIdx", "(J)V", "name", "getName", "setName", "registerTime", "Ljava/util/Date;", "getRegisterTime", "()Ljava/util/Date;", "setRegisterTime", "(Ljava/util/Date;)V", "sensorId", "getSensorId", "setSensorId", "sensorIndex", "getSensorIndex", "setSensorIndex", "sensorStartUp", "getSensorStartUp", "setSensorStartUp", "startUpTimeZone", "getStartUpTimeZone", "setStartUpTimeZone", "unregisterTime", "getUnregisterTime", "setUnregisterTime", "userId", "getUserId", "setUserId", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryDeviceInfo.kt */
public final class HistoryDeviceInfo {
    private String deviceId;
    private String deviceKey;
    private String deviceMac;
    private int deviceModel;
    private String deviceSn;
    private int et;
    private long idx;
    private String name;
    private Date registerTime;
    private String sensorId;
    private int sensorIndex;
    private Date sensorStartUp;
    private String startUpTimeZone;
    private Date unregisterTime;
    private String userId;

    public final long getIdx() {
        return this.idx;
    }

    public final void setIdx(long j) {
        this.idx = j;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getSensorId() {
        return this.sensorId;
    }

    public final void setSensorId(String str) {
        this.sensorId = str;
    }

    public final int getSensorIndex() {
        return this.sensorIndex;
    }

    public final void setSensorIndex(int i) {
        this.sensorIndex = i;
    }

    public final Date getSensorStartUp() {
        return this.sensorStartUp;
    }

    public final void setSensorStartUp(Date date) {
        this.sensorStartUp = date;
    }

    public final String getStartUpTimeZone() {
        return this.startUpTimeZone;
    }

    public final void setStartUpTimeZone(String str) {
        this.startUpTimeZone = str;
    }

    public final int getDeviceModel() {
        return this.deviceModel;
    }

    public final void setDeviceModel(int i) {
        this.deviceModel = i;
    }

    public final String getDeviceSn() {
        return this.deviceSn;
    }

    public final void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public final String getDeviceMac() {
        return this.deviceMac;
    }

    public final void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public final String getDeviceKey() {
        return this.deviceKey;
    }

    public final void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public final Date getRegisterTime() {
        return this.registerTime;
    }

    public final void setRegisterTime(Date date) {
        this.registerTime = date;
    }

    public final Date getUnregisterTime() {
        return this.unregisterTime;
    }

    public final void setUnregisterTime(Date date) {
        this.unregisterTime = date;
    }

    public final int getEt() {
        return this.et;
    }

    public final void setEt(int i) {
        this.et = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }
}

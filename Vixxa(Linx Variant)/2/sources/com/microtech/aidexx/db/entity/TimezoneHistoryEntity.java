package com.microtech.aidexx.db.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000e¨\u00060"}, d2 = {"Lcom/microtech/aidexx/db/entity/TimezoneHistoryEntity;", "", "()V", "dstOffset", "", "getDstOffset", "()I", "setDstOffset", "(I)V", "from", "", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "frontRecordId", "getFrontRecordId", "setFrontRecordId", "idx", "", "getIdx", "()Ljava/lang/Long;", "setIdx", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isDstChange", "", "()Z", "setDstChange", "(Z)V", "sensorId", "getSensorId", "setSensorId", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "to", "getTo", "setTo", "uploadState", "getUploadState", "setUploadState", "userId", "getUserId", "setUserId", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimezoneHistoryEntity.kt */
public final class TimezoneHistoryEntity {
    private int dstOffset;
    private String from;
    private String frontRecordId;
    private Long idx;
    private boolean isDstChange;
    private String sensorId;
    private long timestamp;
    private String to;
    private int uploadState;
    private String userId;

    public final Long getIdx() {
        return this.idx;
    }

    public final void setIdx(Long l) {
        this.idx = l;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final String getTo() {
        return this.to;
    }

    public final void setTo(String str) {
        this.to = str;
    }

    public final int getDstOffset() {
        return this.dstOffset;
    }

    public final void setDstOffset(int i) {
        this.dstOffset = i;
    }

    public final boolean isDstChange() {
        return this.isDstChange;
    }

    public final void setDstChange(boolean z) {
        this.isDstChange = z;
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

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final int getUploadState() {
        return this.uploadState;
    }

    public final void setUploadState(int i) {
        this.uploadState = i;
    }

    public final String getFrontRecordId() {
        return this.frontRecordId;
    }

    public final void setFrontRecordId(String str) {
        this.frontRecordId = str;
    }

    public String toString() {
        return "TimezoneHistoryEntity(idx=" + this.idx + ", from=" + this.from + ", to=" + this.to + ", isDstChange=" + this.isDstChange + ", userId=" + this.userId + ", sensorId=" + this.sensorId + ", timestamp=" + this.timestamp + ", uploadState=" + this.uploadState + ", frontRecordId=" + this.frontRecordId + ')';
    }
}

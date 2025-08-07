package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqScanWatchQr;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "watchCodeId", "", "(I)V", "getWatchCodeId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqScanWatchQr extends ReqEntity {
    private final int watchCodeId;

    public static /* synthetic */ ReqScanWatchQr copy$default(ReqScanWatchQr reqScanWatchQr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = reqScanWatchQr.watchCodeId;
        }
        return reqScanWatchQr.copy(i);
    }

    public final int component1() {
        return this.watchCodeId;
    }

    public final ReqScanWatchQr copy(int i) {
        return new ReqScanWatchQr(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReqScanWatchQr) && this.watchCodeId == ((ReqScanWatchQr) obj).watchCodeId;
    }

    public int hashCode() {
        return Integer.hashCode(this.watchCodeId);
    }

    public String toString() {
        return "ReqScanWatchQr(watchCodeId=" + this.watchCodeId + ')';
    }

    public final int getWatchCodeId() {
        return this.watchCodeId;
    }

    public ReqScanWatchQr(int i) {
        this.watchCodeId = i;
    }
}

package com.microtech.aidexx.utils.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/utils/eventbus/AlertInfo;", "", "content", "", "type", "", "showCustomerService", "", "(Ljava/lang/String;IZ)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getShowCustomerService", "()Z", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventBusEntity.kt */
public final class AlertInfo {
    private String content;
    private final boolean showCustomerService;
    private final int type;

    public static /* synthetic */ AlertInfo copy$default(AlertInfo alertInfo, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = alertInfo.content;
        }
        if ((i2 & 2) != 0) {
            i = alertInfo.type;
        }
        if ((i2 & 4) != 0) {
            z = alertInfo.showCustomerService;
        }
        return alertInfo.copy(str, i, z);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.type;
    }

    public final boolean component3() {
        return this.showCustomerService;
    }

    public final AlertInfo copy(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new AlertInfo(str, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlertInfo)) {
            return false;
        }
        AlertInfo alertInfo = (AlertInfo) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) alertInfo.content) && this.type == alertInfo.type && this.showCustomerService == alertInfo.showCustomerService;
    }

    public int hashCode() {
        int hashCode = ((this.content.hashCode() * 31) + Integer.hashCode(this.type)) * 31;
        boolean z = this.showCustomerService;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "AlertInfo(content=" + this.content + ", type=" + this.type + ", showCustomerService=" + this.showCustomerService + ')';
    }

    public AlertInfo(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.content = str;
        this.type = i;
        this.showCustomerService = z;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getShowCustomerService() {
        return this.showCustomerService;
    }
}

package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJH\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqShareUserInfo;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "readerAlias", "", "hideState", "", "emergePushState", "readerUserName", "normalPushState", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getEmergePushState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHideState", "getNormalPushState", "getReaderAlias", "()Ljava/lang/String;", "getReaderUserName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microtech/aidexx/common/net/entity/ReqShareUserInfo;", "equals", "", "other", "", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqShareUserInfo extends ReqEntity {
    private final Integer emergePushState;
    private final Integer hideState;
    private final Integer normalPushState;
    private final String readerAlias;
    private final String readerUserName;

    public static /* synthetic */ ReqShareUserInfo copy$default(ReqShareUserInfo reqShareUserInfo, String str, Integer num, Integer num2, String str2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqShareUserInfo.readerAlias;
        }
        if ((i & 2) != 0) {
            num = reqShareUserInfo.hideState;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = reqShareUserInfo.emergePushState;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            str2 = reqShareUserInfo.readerUserName;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            num3 = reqShareUserInfo.normalPushState;
        }
        return reqShareUserInfo.copy(str, num4, num5, str3, num3);
    }

    public final String component1() {
        return this.readerAlias;
    }

    public final Integer component2() {
        return this.hideState;
    }

    public final Integer component3() {
        return this.emergePushState;
    }

    public final String component4() {
        return this.readerUserName;
    }

    public final Integer component5() {
        return this.normalPushState;
    }

    public final ReqShareUserInfo copy(String str, Integer num, Integer num2, String str2, Integer num3) {
        Intrinsics.checkNotNullParameter(str2, "readerUserName");
        return new ReqShareUserInfo(str, num, num2, str2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqShareUserInfo)) {
            return false;
        }
        ReqShareUserInfo reqShareUserInfo = (ReqShareUserInfo) obj;
        return Intrinsics.areEqual((Object) this.readerAlias, (Object) reqShareUserInfo.readerAlias) && Intrinsics.areEqual((Object) this.hideState, (Object) reqShareUserInfo.hideState) && Intrinsics.areEqual((Object) this.emergePushState, (Object) reqShareUserInfo.emergePushState) && Intrinsics.areEqual((Object) this.readerUserName, (Object) reqShareUserInfo.readerUserName) && Intrinsics.areEqual((Object) this.normalPushState, (Object) reqShareUserInfo.normalPushState);
    }

    public int hashCode() {
        String str = this.readerAlias;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.hideState;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.emergePushState;
        int hashCode3 = (((hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.readerUserName.hashCode()) * 31;
        Integer num3 = this.normalPushState;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ReqShareUserInfo(readerAlias=" + this.readerAlias + ", hideState=" + this.hideState + ", emergePushState=" + this.emergePushState + ", readerUserName=" + this.readerUserName + ", normalPushState=" + this.normalPushState + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqShareUserInfo(String str, Integer num, Integer num2, String str2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, str2, (i & 16) != 0 ? null : num3);
    }

    public final String getReaderAlias() {
        return this.readerAlias;
    }

    public final Integer getHideState() {
        return this.hideState;
    }

    public final Integer getEmergePushState() {
        return this.emergePushState;
    }

    public final String getReaderUserName() {
        return this.readerUserName;
    }

    public final Integer getNormalPushState() {
        return this.normalPushState;
    }

    public ReqShareUserInfo(String str, Integer num, Integer num2, String str2, Integer num3) {
        Intrinsics.checkNotNullParameter(str2, "readerUserName");
        this.readerAlias = str;
        this.hideState = num;
        this.emergePushState = num2;
        this.readerUserName = str2;
        this.normalPushState = num3;
    }
}

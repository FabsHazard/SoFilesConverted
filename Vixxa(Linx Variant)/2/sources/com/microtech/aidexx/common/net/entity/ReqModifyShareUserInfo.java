package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JT\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqModifyShareUserInfo;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "providerAlias", "", "readerAlias", "hideState", "", "emergePushState", "normalPushState", "userAuthorizationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getEmergePushState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHideState", "getNormalPushState", "getProviderAlias", "()Ljava/lang/String;", "getReaderAlias", "getUserAuthorizationId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/microtech/aidexx/common/net/entity/ReqModifyShareUserInfo;", "equals", "", "other", "", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqModifyShareUserInfo extends ReqEntity {
    private final Integer emergePushState;
    private final Integer hideState;
    private final Integer normalPushState;
    private final String providerAlias;
    private final String readerAlias;
    private final String userAuthorizationId;

    public static /* synthetic */ ReqModifyShareUserInfo copy$default(ReqModifyShareUserInfo reqModifyShareUserInfo, String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqModifyShareUserInfo.providerAlias;
        }
        if ((i & 2) != 0) {
            str2 = reqModifyShareUserInfo.readerAlias;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = reqModifyShareUserInfo.hideState;
        }
        Integer num4 = num;
        if ((i & 8) != 0) {
            num2 = reqModifyShareUserInfo.emergePushState;
        }
        Integer num5 = num2;
        if ((i & 16) != 0) {
            num3 = reqModifyShareUserInfo.normalPushState;
        }
        Integer num6 = num3;
        if ((i & 32) != 0) {
            str3 = reqModifyShareUserInfo.userAuthorizationId;
        }
        return reqModifyShareUserInfo.copy(str, str4, num4, num5, num6, str3);
    }

    public final String component1() {
        return this.providerAlias;
    }

    public final String component2() {
        return this.readerAlias;
    }

    public final Integer component3() {
        return this.hideState;
    }

    public final Integer component4() {
        return this.emergePushState;
    }

    public final Integer component5() {
        return this.normalPushState;
    }

    public final String component6() {
        return this.userAuthorizationId;
    }

    public final ReqModifyShareUserInfo copy(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
        Intrinsics.checkNotNullParameter(str3, "userAuthorizationId");
        return new ReqModifyShareUserInfo(str, str2, num, num2, num3, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqModifyShareUserInfo)) {
            return false;
        }
        ReqModifyShareUserInfo reqModifyShareUserInfo = (ReqModifyShareUserInfo) obj;
        return Intrinsics.areEqual((Object) this.providerAlias, (Object) reqModifyShareUserInfo.providerAlias) && Intrinsics.areEqual((Object) this.readerAlias, (Object) reqModifyShareUserInfo.readerAlias) && Intrinsics.areEqual((Object) this.hideState, (Object) reqModifyShareUserInfo.hideState) && Intrinsics.areEqual((Object) this.emergePushState, (Object) reqModifyShareUserInfo.emergePushState) && Intrinsics.areEqual((Object) this.normalPushState, (Object) reqModifyShareUserInfo.normalPushState) && Intrinsics.areEqual((Object) this.userAuthorizationId, (Object) reqModifyShareUserInfo.userAuthorizationId);
    }

    public int hashCode() {
        String str = this.providerAlias;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.readerAlias;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.hideState;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.emergePushState;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.normalPushState;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return ((hashCode4 + i) * 31) + this.userAuthorizationId.hashCode();
    }

    public String toString() {
        return "ReqModifyShareUserInfo(providerAlias=" + this.providerAlias + ", readerAlias=" + this.readerAlias + ", hideState=" + this.hideState + ", emergePushState=" + this.emergePushState + ", normalPushState=" + this.normalPushState + ", userAuthorizationId=" + this.userAuthorizationId + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqModifyShareUserInfo(String str, String str2, Integer num, Integer num2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, str3);
    }

    public final String getProviderAlias() {
        return this.providerAlias;
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

    public final Integer getNormalPushState() {
        return this.normalPushState;
    }

    public final String getUserAuthorizationId() {
        return this.userAuthorizationId;
    }

    public ReqModifyShareUserInfo(String str, String str2, Integer num, Integer num2, Integer num3, String str3) {
        Intrinsics.checkNotNullParameter(str3, "userAuthorizationId");
        this.providerAlias = str;
        this.readerAlias = str2;
        this.hideState = num;
        this.emergePushState = num2;
        this.normalPushState = num3;
        this.userAuthorizationId = str3;
    }
}

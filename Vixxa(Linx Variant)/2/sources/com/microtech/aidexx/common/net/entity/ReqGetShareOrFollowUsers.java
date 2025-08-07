package com.microtech.aidexx.common.net.entity;

import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqGetShareOrFollowUsers;", "Lcom/microtech/aidexx/common/net/entity/ReqGetEventByPage;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqGetShareOrFollowUsers extends ReqGetEventByPage {
    private final String type;

    public ReqGetShareOrFollowUsers() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ReqGetShareOrFollowUsers copy$default(ReqGetShareOrFollowUsers reqGetShareOrFollowUsers, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqGetShareOrFollowUsers.type;
        }
        return reqGetShareOrFollowUsers.copy(str);
    }

    public final String component1() {
        return this.type;
    }

    public final ReqGetShareOrFollowUsers copy(String str) {
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.OPERATION_TYPE);
        return new ReqGetShareOrFollowUsers(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReqGetShareOrFollowUsers) && Intrinsics.areEqual((Object) this.type, (Object) ((ReqGetShareOrFollowUsers) obj).type);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "ReqGetShareOrFollowUsers(type=" + this.type + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqGetShareOrFollowUsers(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "1" : str);
    }

    public final String getType() {
        return this.type;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReqGetShareOrFollowUsers(String str) {
        super((Long) null, (Long) null, (String) null, 7, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.OPERATION_TYPE);
        this.type = str;
    }
}

package com.microtech.aidexx.common.net.entity;

import com.igexin.assist.sdk.AssistPushConsts;
import com.microtech.aidexx.common.ExtendsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqGyLogin;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "gyuid", "", "token", "origin", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getGyuid", "()Ljava/lang/String;", "getOrigin", "()I", "getToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqGyLogin extends ReqEntity {
    private final String gyuid;
    private final int origin;
    private final String token;

    public static /* synthetic */ ReqGyLogin copy$default(ReqGyLogin reqGyLogin, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reqGyLogin.gyuid;
        }
        if ((i2 & 2) != 0) {
            str2 = reqGyLogin.token;
        }
        if ((i2 & 4) != 0) {
            i = reqGyLogin.origin;
        }
        return reqGyLogin.copy(str, str2, i);
    }

    public final String component1() {
        return this.gyuid;
    }

    public final String component2() {
        return this.token;
    }

    public final int component3() {
        return this.origin;
    }

    public final ReqGyLogin copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "gyuid");
        Intrinsics.checkNotNullParameter(str2, AssistPushConsts.MSG_TYPE_TOKEN);
        return new ReqGyLogin(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqGyLogin)) {
            return false;
        }
        ReqGyLogin reqGyLogin = (ReqGyLogin) obj;
        return Intrinsics.areEqual((Object) this.gyuid, (Object) reqGyLogin.gyuid) && Intrinsics.areEqual((Object) this.token, (Object) reqGyLogin.token) && this.origin == reqGyLogin.origin;
    }

    public int hashCode() {
        return (((this.gyuid.hashCode() * 31) + this.token.hashCode()) * 31) + Integer.hashCode(this.origin);
    }

    public String toString() {
        return "ReqGyLogin(gyuid=" + this.gyuid + ", token=" + this.token + ", origin=" + this.origin + ')';
    }

    public final String getGyuid() {
        return this.gyuid;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getOrigin() {
        return this.origin;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqGyLogin(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? ExtendsKt.isGp() ? 2 : 0 : i);
    }

    public ReqGyLogin(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "gyuid");
        Intrinsics.checkNotNullParameter(str2, AssistPushConsts.MSG_TYPE_TOKEN);
        this.gyuid = str;
        this.token = str2;
        this.origin = i;
    }
}

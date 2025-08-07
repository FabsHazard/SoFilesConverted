package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqChangePWD;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "userName", "", "newPassword", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getNewPassword", "getUserName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqChangePWD extends ReqEntity {
    private final String code;
    private final String newPassword;
    private final String userName;

    public static /* synthetic */ ReqChangePWD copy$default(ReqChangePWD reqChangePWD, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqChangePWD.userName;
        }
        if ((i & 2) != 0) {
            str2 = reqChangePWD.newPassword;
        }
        if ((i & 4) != 0) {
            str3 = reqChangePWD.code;
        }
        return reqChangePWD.copy(str, str2, str3);
    }

    public final String component1() {
        return this.userName;
    }

    public final String component2() {
        return this.newPassword;
    }

    public final String component3() {
        return this.code;
    }

    public final ReqChangePWD copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "newPassword");
        Intrinsics.checkNotNullParameter(str3, "code");
        return new ReqChangePWD(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqChangePWD)) {
            return false;
        }
        ReqChangePWD reqChangePWD = (ReqChangePWD) obj;
        return Intrinsics.areEqual((Object) this.userName, (Object) reqChangePWD.userName) && Intrinsics.areEqual((Object) this.newPassword, (Object) reqChangePWD.newPassword) && Intrinsics.areEqual((Object) this.code, (Object) reqChangePWD.code);
    }

    public int hashCode() {
        return (((this.userName.hashCode() * 31) + this.newPassword.hashCode()) * 31) + this.code.hashCode();
    }

    public String toString() {
        return "ReqChangePWD(userName=" + this.userName + ", newPassword=" + this.newPassword + ", code=" + this.code + ')';
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getNewPassword() {
        return this.newPassword;
    }

    public final String getCode() {
        return this.code;
    }

    public ReqChangePWD(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "newPassword");
        Intrinsics.checkNotNullParameter(str3, "code");
        this.userName = str;
        this.newPassword = str2;
        this.code = str3;
    }
}

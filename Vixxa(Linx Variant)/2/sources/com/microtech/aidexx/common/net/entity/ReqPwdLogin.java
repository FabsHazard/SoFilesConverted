package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqPwdLogin;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "userName", "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "getUserName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqPwdLogin extends ReqEntity {
    private final String password;
    private final String userName;

    public static /* synthetic */ ReqPwdLogin copy$default(ReqPwdLogin reqPwdLogin, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqPwdLogin.userName;
        }
        if ((i & 2) != 0) {
            str2 = reqPwdLogin.password;
        }
        return reqPwdLogin.copy(str, str2);
    }

    public final String component1() {
        return this.userName;
    }

    public final String component2() {
        return this.password;
    }

    public final ReqPwdLogin copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "password");
        return new ReqPwdLogin(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqPwdLogin)) {
            return false;
        }
        ReqPwdLogin reqPwdLogin = (ReqPwdLogin) obj;
        return Intrinsics.areEqual((Object) this.userName, (Object) reqPwdLogin.userName) && Intrinsics.areEqual((Object) this.password, (Object) reqPwdLogin.password);
    }

    public int hashCode() {
        return (this.userName.hashCode() * 31) + this.password.hashCode();
    }

    public String toString() {
        return "ReqPwdLogin(userName=" + this.userName + ", password=" + this.password + ')';
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getPassword() {
        return this.password;
    }

    public ReqPwdLogin(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, "password");
        this.userName = str;
        this.password = str2;
    }
}

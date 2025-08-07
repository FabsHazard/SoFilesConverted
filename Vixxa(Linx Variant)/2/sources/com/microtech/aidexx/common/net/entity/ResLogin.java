package com.microtech.aidexx.common.net.entity;

import com.igexin.assist.sdk.AssistPushConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ResLogin;", "", "userId", "", "phone", "email", "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPhone", "getToken", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class ResLogin {
    private final String email;
    private final String phone;
    private final String token;
    private final String userId;

    public static /* synthetic */ ResLogin copy$default(ResLogin resLogin, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resLogin.userId;
        }
        if ((i & 2) != 0) {
            str2 = resLogin.phone;
        }
        if ((i & 4) != 0) {
            str3 = resLogin.email;
        }
        if ((i & 8) != 0) {
            str4 = resLogin.token;
        }
        return resLogin.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.phone;
    }

    public final String component3() {
        return this.email;
    }

    public final String component4() {
        return this.token;
    }

    public final ResLogin copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str4, AssistPushConsts.MSG_TYPE_TOKEN);
        return new ResLogin(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResLogin)) {
            return false;
        }
        ResLogin resLogin = (ResLogin) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) resLogin.userId) && Intrinsics.areEqual((Object) this.phone, (Object) resLogin.phone) && Intrinsics.areEqual((Object) this.email, (Object) resLogin.email) && Intrinsics.areEqual((Object) this.token, (Object) resLogin.token);
    }

    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        String str = this.phone;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.email;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.token.hashCode();
    }

    public String toString() {
        return "ResLogin(userId=" + this.userId + ", phone=" + this.phone + ", email=" + this.email + ", token=" + this.token + ')';
    }

    public ResLogin(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str4, AssistPushConsts.MSG_TYPE_TOKEN);
        this.userId = str;
        this.phone = str2;
        this.email = str3;
        this.token = str4;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getToken() {
        return this.token;
    }
}

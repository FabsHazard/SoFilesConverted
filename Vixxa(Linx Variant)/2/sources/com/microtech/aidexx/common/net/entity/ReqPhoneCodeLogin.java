package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqPhoneCodeLogin;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "phone", "", "code", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getPassword", "getPhone", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqPhoneCodeLogin extends ReqEntity {
    private final String code;
    private final String password;
    private final String phone;

    public static /* synthetic */ ReqPhoneCodeLogin copy$default(ReqPhoneCodeLogin reqPhoneCodeLogin, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqPhoneCodeLogin.phone;
        }
        if ((i & 2) != 0) {
            str2 = reqPhoneCodeLogin.code;
        }
        if ((i & 4) != 0) {
            str3 = reqPhoneCodeLogin.password;
        }
        return reqPhoneCodeLogin.copy(str, str2, str3);
    }

    public final String component1() {
        return this.phone;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.password;
    }

    public final ReqPhoneCodeLogin copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "code");
        return new ReqPhoneCodeLogin(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqPhoneCodeLogin)) {
            return false;
        }
        ReqPhoneCodeLogin reqPhoneCodeLogin = (ReqPhoneCodeLogin) obj;
        return Intrinsics.areEqual((Object) this.phone, (Object) reqPhoneCodeLogin.phone) && Intrinsics.areEqual((Object) this.code, (Object) reqPhoneCodeLogin.code) && Intrinsics.areEqual((Object) this.password, (Object) reqPhoneCodeLogin.password);
    }

    public int hashCode() {
        int hashCode = ((this.phone.hashCode() * 31) + this.code.hashCode()) * 31;
        String str = this.password;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ReqPhoneCodeLogin(phone=" + this.phone + ", code=" + this.code + ", password=" + this.password + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqPhoneCodeLogin(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getPassword() {
        return this.password;
    }

    public ReqPhoneCodeLogin(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "code");
        this.phone = str;
        this.code = str2;
        this.password = str3;
    }
}

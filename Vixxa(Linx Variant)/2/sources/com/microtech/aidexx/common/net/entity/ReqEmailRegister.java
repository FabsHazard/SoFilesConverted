package com.microtech.aidexx.common.net.entity;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqEmailRegister;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "email", "", "password", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getEmail", "getPassword", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqEmailRegister extends ReqEntity {
    private final String code;
    private final String email;
    private final String password;

    public static /* synthetic */ ReqEmailRegister copy$default(ReqEmailRegister reqEmailRegister, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqEmailRegister.email;
        }
        if ((i & 2) != 0) {
            str2 = reqEmailRegister.password;
        }
        if ((i & 4) != 0) {
            str3 = reqEmailRegister.code;
        }
        return reqEmailRegister.copy(str, str2, str3);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.password;
    }

    public final String component3() {
        return this.code;
    }

    public final ReqEmailRegister copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkNotNullParameter(str2, "password");
        Intrinsics.checkNotNullParameter(str3, "code");
        return new ReqEmailRegister(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqEmailRegister)) {
            return false;
        }
        ReqEmailRegister reqEmailRegister = (ReqEmailRegister) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) reqEmailRegister.email) && Intrinsics.areEqual((Object) this.password, (Object) reqEmailRegister.password) && Intrinsics.areEqual((Object) this.code, (Object) reqEmailRegister.code);
    }

    public int hashCode() {
        return (((this.email.hashCode() * 31) + this.password.hashCode()) * 31) + this.code.hashCode();
    }

    public String toString() {
        return "ReqEmailRegister(email=" + this.email + ", password=" + this.password + ", code=" + this.code + ')';
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getCode() {
        return this.code;
    }

    public ReqEmailRegister(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkNotNullParameter(str2, "password");
        Intrinsics.checkNotNullParameter(str3, "code");
        this.email = str;
        this.password = str2;
        this.code = str3;
    }
}

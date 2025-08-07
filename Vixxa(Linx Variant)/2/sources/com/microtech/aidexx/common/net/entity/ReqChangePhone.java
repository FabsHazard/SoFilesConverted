package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqChangePhone;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "phone", "", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getPhone", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqChangePhone extends ReqEntity {
    private final String code;
    private final String phone;

    public static /* synthetic */ ReqChangePhone copy$default(ReqChangePhone reqChangePhone, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqChangePhone.phone;
        }
        if ((i & 2) != 0) {
            str2 = reqChangePhone.code;
        }
        return reqChangePhone.copy(str, str2);
    }

    public final String component1() {
        return this.phone;
    }

    public final String component2() {
        return this.code;
    }

    public final ReqChangePhone copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "code");
        return new ReqChangePhone(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqChangePhone)) {
            return false;
        }
        ReqChangePhone reqChangePhone = (ReqChangePhone) obj;
        return Intrinsics.areEqual((Object) this.phone, (Object) reqChangePhone.phone) && Intrinsics.areEqual((Object) this.code, (Object) reqChangePhone.code);
    }

    public int hashCode() {
        return (this.phone.hashCode() * 31) + this.code.hashCode();
    }

    public String toString() {
        return "ReqChangePhone(phone=" + this.phone + ", code=" + this.code + ')';
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getCode() {
        return this.code;
    }

    public ReqChangePhone(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(str2, "code");
        this.phone = str;
        this.code = str2;
    }
}

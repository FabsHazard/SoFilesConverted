package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/OtherDiseasesEntity;", "", "otherDiseasesId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOtherDiseasesId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class OtherDiseasesEntity {
    private final String name;
    private final String otherDiseasesId;

    public static /* synthetic */ OtherDiseasesEntity copy$default(OtherDiseasesEntity otherDiseasesEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = otherDiseasesEntity.otherDiseasesId;
        }
        if ((i & 2) != 0) {
            str2 = otherDiseasesEntity.name;
        }
        return otherDiseasesEntity.copy(str, str2);
    }

    public final String component1() {
        return this.otherDiseasesId;
    }

    public final String component2() {
        return this.name;
    }

    public final OtherDiseasesEntity copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "otherDiseasesId");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new OtherDiseasesEntity(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtherDiseasesEntity)) {
            return false;
        }
        OtherDiseasesEntity otherDiseasesEntity = (OtherDiseasesEntity) obj;
        return Intrinsics.areEqual((Object) this.otherDiseasesId, (Object) otherDiseasesEntity.otherDiseasesId) && Intrinsics.areEqual((Object) this.name, (Object) otherDiseasesEntity.name);
    }

    public int hashCode() {
        return (this.otherDiseasesId.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "OtherDiseasesEntity(otherDiseasesId=" + this.otherDiseasesId + ", name=" + this.name + ')';
    }

    public OtherDiseasesEntity(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "otherDiseasesId");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.otherDiseasesId = str;
        this.name = str2;
    }

    public final String getOtherDiseasesId() {
        return this.otherDiseasesId;
    }

    public final String getName() {
        return this.name;
    }
}
